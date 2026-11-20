package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig;
import com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_text = Util.getIntegerCodeForString(MimeTypes.BASE_TYPE_TEXT);
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString("meta");

    /* JADX INFO: compiled from: source.java */
    public static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z11) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z11;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public final boolean moveNext() {
            int i11 = this.index + 1;
            this.index = i11;
            if (i11 == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i12 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i12;
                this.nextSamplesPerChunkChangeIndex = i12 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i11) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public final int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public final boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public final int readNextSampleSize() {
            int i11 = this.fixedSampleSize;
            return i11 == 0 ? this.data.readUnsignedIntToInt() : i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public final int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public final boolean isFixedSampleSize() {
            return false;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public final int readNextSampleSize() {
            int i11 = this.fieldSize;
            if (i11 == 8) {
                return this.data.readUnsignedByte();
            }
            if (i11 == 16) {
                return this.data.readUnsignedShort();
            }
            int i12 = this.sampleIndex;
            this.sampleIndex = i12 + 1;
            if (i12 % 2 != 0) {
                return this.currentByte & 15;
            }
            int unsignedByte = this.data.readUnsignedByte();
            this.currentByte = unsignedByte;
            return (unsignedByte & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TkhdData {
        private final long duration;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f46514id;
        private final int rotationDegrees;

        public TkhdData(int i11, long j11, int i12) {
            this.f46514id = i11;
            this.duration = j11;
            this.rotationDegrees = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class UnhandledEditListException extends ParserException {
    }

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[Util.constrainValue(3, 0, length)] && jArr[Util.constrainValue(jArr.length - 3, 0, length)] < j13 && j13 <= j11;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i11, int i12) {
        int position = parsableByteArray.getPosition();
        while (position - i11 < i12) {
            parsableByteArray.setPosition(position);
            int i13 = parsableByteArray.readInt();
            Assertions.checkArgument(i13 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += i13;
        }
        return -1;
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i11, int i12, int i13, int i14, String str, boolean z11, DrmInitData drmInitData, StsdData stsdData, int i15) throws ParserException {
        int unsignedShort;
        int iRound;
        int unsignedIntToInt;
        String str2;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        int i16;
        int i17 = i12;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i17 + 16);
        if (z11) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            int unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            int unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            iRound = unsignedFixedPoint1616;
            unsignedIntToInt = unsignedShort2;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            iRound = (int) Math.round(parsableByteArray.readDouble());
            unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        }
        int position = parsableByteArray.getPosition();
        int iIntValue = i11;
        if (iIntValue == Atom.TYPE_enca) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i17, i13);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i15] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        int i18 = Atom.TYPE_ac_3;
        String str5 = MimeTypes.AUDIO_RAW;
        if (iIntValue == i18) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == Atom.TYPE_ec_3) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == Atom.TYPE_dtsc) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == Atom.TYPE_dtsh || iIntValue == Atom.TYPE_dtsl) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == Atom.TYPE_dtse) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == Atom.TYPE_samr) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (iIntValue == Atom.TYPE_sawb) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else if (iIntValue == Atom.TYPE_lpcm || iIntValue == Atom.TYPE_sowt) {
            str2 = MimeTypes.AUDIO_RAW;
        } else if (iIntValue == Atom.TYPE__mp3) {
            str2 = MimeTypes.AUDIO_MPEG;
        } else {
            str2 = iIntValue == Atom.TYPE_alac ? MimeTypes.AUDIO_ALAC : null;
        }
        String str6 = str2;
        int iIntValue2 = unsignedIntToInt;
        int iIntValue3 = iRound;
        int i19 = position;
        byte[] bArr = null;
        while (i19 - i17 < i13) {
            parsableByteArray.setPosition(i19);
            int i21 = parsableByteArray.readInt();
            Assertions.checkArgument(i21 > 0, "childAtomSize should be positive");
            int i22 = parsableByteArray.readInt();
            int i23 = Atom.TYPE_esds;
            if (i22 == i23 || (z11 && i22 == Atom.TYPE_wave)) {
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData3;
                int iFindEsdsPosition = i22 == i23 ? i19 : findEsdsPosition(parsableByteArray, i19, i21);
                if (iFindEsdsPosition != -1) {
                    Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindEsdsPosition);
                    str6 = (String) esdsFromParent.first;
                    bArr = (byte[]) esdsFromParent.second;
                    if (MimeTypes.AUDIO_AAC.equals(str6)) {
                        Pair<Integer, Integer> aacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                        iIntValue3 = ((Integer) aacAudioSpecificConfig.first).intValue();
                        iIntValue2 = ((Integer) aacAudioSpecificConfig.second).intValue();
                    }
                }
                i19 += i21;
                i17 = i12;
                drmInitData3 = drmInitData2;
                str5 = str4;
            } else {
                if (i22 == Atom.TYPE_dac3) {
                    parsableByteArray.setPosition(i19 + 8);
                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i14), str, drmInitData3);
                } else if (i22 == Atom.TYPE_dec3) {
                    parsableByteArray.setPosition(i19 + 8);
                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i14), str, drmInitData3);
                } else {
                    if (i22 == Atom.TYPE_ddts) {
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData3;
                        i16 = i19;
                        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i14), str6, null, -1, -1, iIntValue2, iIntValue3, null, drmInitData2, 0, str);
                        i21 = i21;
                    } else {
                        i16 = i19;
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData3;
                        if (i22 == Atom.TYPE_alac) {
                            byte[] bArr2 = new byte[i21];
                            i19 = i16;
                            parsableByteArray.setPosition(i19);
                            parsableByteArray.readBytes(bArr2, 0, i21);
                            bArr = bArr2;
                        }
                    }
                    i19 = i16;
                }
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData3;
            }
            str6 = str3;
            i19 += i21;
            i17 = i12;
            drmInitData3 = drmInitData2;
            str5 = str4;
        }
        String str7 = str6;
        String str8 = str5;
        DrmInitData drmInitData4 = drmInitData3;
        if (stsdData.format != null || str7 == null) {
            return;
        }
        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i14), str7, null, -1, -1, iIntValue2, iIntValue3, str8.equals(str7) ? 2 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData4, 0, str);
    }

    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i11, int i12) {
        int i13 = i11 + 8;
        String string = null;
        Integer numValueOf = null;
        int i14 = -1;
        int i15 = 0;
        while (i13 - i11 < i12) {
            parsableByteArray.setPosition(i13);
            int i16 = parsableByteArray.readInt();
            int i17 = parsableByteArray.readInt();
            if (i17 == Atom.TYPE_frma) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i17 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i17 == Atom.TYPE_schi) {
                i14 = i13;
                i15 = i16;
            }
            i13 += i16;
        }
        if (!C.CENC_TYPE_cenc.equals(string) && !C.CENC_TYPE_cbc1.equals(string) && !C.CENC_TYPE_cens.equals(string) && !C.CENC_TYPE_cbcs.equals(string)) {
            return null;
        }
        Assertions.checkArgument(numValueOf != null, "frma atom is mandatory");
        Assertions.checkArgument(i14 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i14, i15, string);
        Assertions.checkArgument(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, schiFromParent);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create(null, null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i11 = 0; i11 < unsignedIntToInt; i11++) {
            jArr[i11] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i11] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.setPosition(i11 + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i11 = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i11 = (i11 << 7) | (unsignedByte & 127);
        }
        return i11;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int i11 = parsableByteArray.readInt();
        if (i11 == TYPE_soun) {
            return 1;
        }
        if (i11 == TYPE_vide) {
            return 2;
        }
        if (i11 == TYPE_text || i11 == TYPE_sbtl || i11 == TYPE_subt || i11 == TYPE_clcp) {
            return 3;
        }
        return i11 == TYPE_meta ? 4 : -1;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i11) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i11) {
            int position = parsableByteArray.getPosition();
            int i12 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i12);
            }
            parsableByteArray.skipBytes(i12 - 8);
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.setPosition(i11 + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            parsableByteArray.setPosition(i13);
            int i14 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i13, i14 + i13);
            }
            i13 += i14;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i11, int i12) {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i11 < i12) {
            parsableByteArray.setPosition(position);
            int i13 = parsableByteArray.readInt();
            Assertions.checkArgument(i13 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i13)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i13;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            parsableByteArray.setPosition(i15);
            int i16 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i13 = unsignedByte & 15;
                    i14 = (unsignedByte & 240) >> 4;
                }
                boolean z11 = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z11 && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z11, str, unsignedByte2, bArr2, i14, i13, bArr);
            }
            i15 += i16;
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0343  */
    /* JADX WARN: Code duplicated, block: B:137:0x0345  */
    /* JADX WARN: Code duplicated, block: B:141:0x0351  */
    /* JADX WARN: Code duplicated, block: B:143:0x035c  */
    /* JADX WARN: Code duplicated, block: B:145:0x037a  */
    /* JADX WARN: Code duplicated, block: B:146:0x037c  */
    /* JADX WARN: Code duplicated, block: B:151:0x038a  */
    /* JADX WARN: Code duplicated, block: B:152:0x038c  */
    /* JADX WARN: Code duplicated, block: B:155:0x0390  */
    /* JADX WARN: Code duplicated, block: B:156:0x0393  */
    /* JADX WARN: Code duplicated, block: B:158:0x0396  */
    /* JADX WARN: Code duplicated, block: B:159:0x0399  */
    /* JADX WARN: Code duplicated, block: B:161:0x039d  */
    /* JADX WARN: Code duplicated, block: B:163:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:164:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:168:0x03af  */
    /* JADX WARN: Code duplicated, block: B:170:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:172:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:173:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:183:0x0414  */
    /* JADX WARN: Code duplicated, block: B:190:0x0451  */
    /* JADX WARN: Code duplicated, block: B:209:0x0385 A[EDGE_INSN: B:209:0x0385->B:149:0x0385 BREAK  A[LOOP:5: B:139:0x034a->B:148:0x037f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x037f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0470 A[SYNTHETIC] */
    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z11;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        Track track2;
        String str;
        long[] jArr;
        int[] iArr;
        int i11;
        long[] jArr2;
        int[] iArr2;
        long j11;
        String str2;
        int i12;
        long[] jArr3;
        boolean z12;
        boolean z13;
        int i13;
        int i14;
        int i15;
        long[] jArr4;
        long j12;
        long[] jArr5;
        int[] iArr3;
        boolean z14;
        boolean z15;
        long[] jArr6;
        int[] iArr4;
        int[] iArr5;
        long[] jArr7;
        int i16;
        int i17;
        long[] jArr8;
        int[] iArr6;
        long[] jArr9;
        long j13;
        long j14;
        String str3;
        int[] iArr7;
        int[] iArr8;
        int iBinarySearchCeil;
        int iBinarySearchCeil2;
        long j15;
        int iBinarySearchCeil3;
        boolean z16;
        int i18;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], C.TIME_UNSET);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
            z11 = true;
        } else {
            z11 = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = null;
        ParsableByteArray parsableByteArray5 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray6 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z11);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray6 != null) {
            parsableByteArray6.setPosition(12);
            unsignedIntToInt = parsableByteArray6.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        int unsignedIntToInt6 = -1;
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt2 = parsableByteArray5.readUnsignedIntToInt();
            if (unsignedIntToInt2 > 0) {
                unsignedIntToInt6 = parsableByteArray5.readUnsignedIntToInt() - 1;
                parsableByteArray4 = parsableByteArray5;
            }
        } else {
            parsableByteArray4 = parsableByteArray5;
            unsignedIntToInt2 = 0;
        }
        long j16 = 0;
        if (stz2SampleSizeBox.isFixedSampleSize() && MimeTypes.AUDIO_RAW.equals(track.format.sampleMimeType) && unsignedIntToInt3 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) {
            track2 = track;
            str = TAG;
            int i19 = chunkIterator.length;
            long[] jArr10 = new long[i19];
            int[] iArr9 = new int[i19];
            while (chunkIterator.moveNext()) {
                int i21 = chunkIterator.index;
                jArr10[i21] = chunkIterator.offset;
                iArr9[i21] = chunkIterator.numSamples;
            }
            Format format = track2.format;
            FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(format.pcmEncoding, format.channelCount), jArr10, iArr9, unsignedIntToInt5);
            jArr = resultsRechunk.offsets;
            iArr = resultsRechunk.sizes;
            i11 = resultsRechunk.maximumSize;
            jArr2 = resultsRechunk.timestamps;
            iArr2 = resultsRechunk.flags;
            j11 = resultsRechunk.duration;
        } else {
            long[] jArr11 = new long[sampleCount];
            int[] iArr10 = new int[sampleCount];
            int i22 = unsignedIntToInt2;
            long[] jArr12 = new long[sampleCount];
            int[] iArr11 = new int[sampleCount];
            int i23 = unsignedIntToInt5;
            long j17 = 0;
            long j18 = 0;
            int i24 = unsignedIntToInt3;
            int i25 = 0;
            int i26 = 0;
            int unsignedIntToInt7 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = i22;
            int unsignedIntToInt8 = unsignedIntToInt6;
            int i31 = unsignedIntToInt;
            int i32 = unsignedIntToInt4;
            while (i25 < sampleCount) {
                while (i28 == 0) {
                    Assertions.checkState(chunkIterator.moveNext());
                    j18 = chunkIterator.offset;
                    i28 = chunkIterator.numSamples;
                    i24 = i24;
                    i32 = i32;
                }
                int i33 = i24;
                int i34 = i32;
                if (parsableByteArray6 != null) {
                    while (unsignedIntToInt7 == 0 && i31 > 0) {
                        unsignedIntToInt7 = parsableByteArray6.readUnsignedIntToInt();
                        i27 = parsableByteArray6.readInt();
                        i31--;
                    }
                    unsignedIntToInt7--;
                }
                int i35 = i27;
                jArr11[i25] = j18;
                int nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                iArr10[i25] = nextSampleSize;
                if (nextSampleSize > i26) {
                    i26 = nextSampleSize;
                }
                jArr12[i25] = j17 + ((long) i35);
                iArr11[i25] = parsableByteArray4 == null ? 1 : 0;
                if (i25 == unsignedIntToInt8) {
                    iArr11[i25] = 1;
                    i29--;
                    if (i29 > 0) {
                        unsignedIntToInt8 = parsableByteArray4.readUnsignedIntToInt() - 1;
                    }
                }
                j17 += (long) i23;
                int unsignedIntToInt9 = i34 - 1;
                if (unsignedIntToInt9 == 0 && i33 > 0) {
                    i33--;
                    unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                    i23 = parsableByteArray3.readInt();
                }
                int i36 = unsignedIntToInt9;
                j18 += (long) iArr10[i25];
                i28--;
                i25++;
                stz2SampleSizeBox = stz2SampleSizeBox;
                jArr11 = jArr11;
                i32 = i36;
                i27 = i35;
                i24 = i33;
            }
            int i37 = i24;
            int i38 = i32;
            int i39 = i27;
            long[] jArr13 = jArr11;
            j11 = j17 + ((long) i39);
            Assertions.checkArgument(unsignedIntToInt7 == 0);
            while (i31 > 0) {
                Assertions.checkArgument(parsableByteArray6.readUnsignedIntToInt() == 0);
                parsableByteArray6.readInt();
                i31--;
            }
            if (i29 == 0 && i38 == 0) {
                i18 = i28;
                if (i18 == 0 && i37 == 0) {
                    track2 = track;
                    str = TAG;
                }
                jArr2 = jArr12;
                iArr = iArr10;
                iArr2 = iArr11;
                i11 = i26;
                jArr = jArr13;
            } else {
                i18 = i28;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Inconsistent stbl box for track ");
            track2 = track;
            sb2.append(track2.f46515id);
            sb2.append(": remainingSynchronizationSamples ");
            sb2.append(i29);
            sb2.append(", remainingSamplesAtTimestampDelta ");
            sb2.append(i38);
            sb2.append(", remainingSamplesInChunk ");
            sb2.append(i18);
            sb2.append(", remainingTimestampDeltaChanges ");
            sb2.append(i37);
            String string = sb2.toString();
            str = TAG;
            Log.w(str, string);
            jArr2 = jArr12;
            iArr = iArr10;
            iArr2 = iArr11;
            i11 = i26;
            jArr = jArr13;
        }
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j11, 1000000L, track2.timescale);
        if (track2.editListDurations == null || gaplessInfoHolder.hasGaplessInfo()) {
            long[] jArr14 = jArr;
            int[] iArr12 = iArr;
            int i40 = i11;
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new TrackSampleTable(track, jArr14, iArr12, i40, jArr2, iArr2, jScaleLargeTimestamp);
        }
        long[] jArr15 = track2.editListDurations;
        if (jArr15.length == 1 && track2.type == 1 && jArr2.length >= 2) {
            long j19 = track2.editListMediaTimes[0];
            long jScaleLargeTimestamp2 = j19 + Util.scaleLargeTimestamp(jArr15[0], track2.timescale, track2.movieTimescale);
            str2 = str;
            if (canApplyEditWithGaplessInfo(jArr2, j11, j19, jScaleLargeTimestamp2)) {
                long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j19 - jArr2[0], track2.format.sampleRate, track2.timescale);
                i12 = i11;
                long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j11 - jScaleLargeTimestamp2, track2.format.sampleRate, track2.timescale);
                if ((jScaleLargeTimestamp3 != 0 || jScaleLargeTimestamp4 != 0) && jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                    gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(track, jArr, iArr, i12, jArr2, iArr2, jScaleLargeTimestamp);
                }
            }
            jArr3 = track2.editListDurations;
            if (jArr3.length != 1 && jArr3[0] == 0) {
                long j21 = track2.editListMediaTimes[0];
                for (int i41 = 0; i41 < jArr2.length; i41++) {
                    jArr2[i41] = Util.scaleLargeTimestamp(jArr2[i41] - j21, 1000000L, track2.timescale);
                }
                return new TrackSampleTable(track, jArr, iArr, i12, jArr2, iArr2, Util.scaleLargeTimestamp(j11 - j21, 1000000L, track2.timescale));
            }
            if (track2.type == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            z13 = false;
            i13 = 0;
            i14 = 0;
            i15 = 0;
            while (true) {
                jArr4 = track2.editListDurations;
                j12 = -1;
                if (i15 < jArr4.length) {
                    break;
                }
                long[] jArr16 = jArr;
                int[] iArr13 = iArr;
                j15 = track2.editListMediaTimes[i15];
                if (j15 != -1) {
                    long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(jArr4[i15], track2.timescale, track2.movieTimescale);
                    iBinarySearchCeil3 = Util.binarySearchCeil(jArr2, j15, true, true);
                    int iBinarySearchCeil4 = Util.binarySearchCeil(jArr2, j15 + jScaleLargeTimestamp5, z12, false);
                    i13 += iBinarySearchCeil4 - iBinarySearchCeil3;
                    if (i14 != iBinarySearchCeil3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z13 |= z16;
                    i14 = iBinarySearchCeil4;
                }
                i15++;
                jArr = jArr16;
                iArr = iArr13;
            }
            jArr5 = jArr;
            iArr3 = iArr;
            if (i13 != sampleCount) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z13 | z14;
            if (z15) {
                jArr6 = new long[i13];
            } else {
                jArr6 = jArr5;
            }
            if (z15) {
                iArr4 = new int[i13];
            } else {
                iArr4 = iArr3;
            }
            if (z15) {
                i12 = 0;
            }
            if (z15) {
                iArr5 = new int[i13];
            } else {
                iArr5 = iArr2;
            }
            jArr7 = new long[i13];
            i16 = 0;
            i17 = 0;
            while (true) {
                jArr8 = track2.editListDurations;
                if (i17 < jArr8.length) {
                    return new TrackSampleTable(track, jArr6, iArr4, i12, jArr7, iArr5, Util.scaleLargeTimestamp(j16, 1000000L, track2.timescale));
                }
                iArr6 = iArr4;
                jArr9 = jArr7;
                j13 = track2.editListMediaTimes[i17];
                j14 = jArr8[i17];
                if (j13 != j12) {
                    long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(j14, track2.timescale, track2.movieTimescale) + j13;
                    iBinarySearchCeil = Util.binarySearchCeil(jArr2, j13, true, true);
                    iBinarySearchCeil2 = Util.binarySearchCeil(jArr2, jScaleLargeTimestamp6, z12, false);
                    if (z15) {
                        int i42 = iBinarySearchCeil2 - iBinarySearchCeil;
                        System.arraycopy(jArr5, iBinarySearchCeil, jArr6, i16, i42);
                        iArr7 = iArr3;
                        iArr8 = iArr6;
                        System.arraycopy(iArr7, iBinarySearchCeil, iArr8, i16, i42);
                        System.arraycopy(iArr2, iBinarySearchCeil, iArr5, i16, i42);
                    } else {
                        iArr7 = iArr3;
                        iArr8 = iArr6;
                    }
                    if (iBinarySearchCeil >= iBinarySearchCeil2 && (iArr5[i16] & 1) == 0) {
                        Log.w(str2, "Ignoring edit list: edit does not start with a sync sample.");
                        throw new UnhandledEditListException();
                    }
                    int i43 = i12;
                    while (iBinarySearchCeil < iBinarySearchCeil2) {
                        int i44 = iBinarySearchCeil2;
                        String str4 = str2;
                        long j22 = j13;
                        jArr9[i16] = Util.scaleLargeTimestamp(j16, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr2[iBinarySearchCeil] - j13, 1000000L, track2.timescale);
                        if (!z15 && iArr8[i16] > i43) {
                            i43 = iArr7[iBinarySearchCeil];
                        }
                        i16++;
                        iBinarySearchCeil++;
                        iBinarySearchCeil2 = i44;
                        str2 = str4;
                        j13 = j22;
                    }
                    str3 = str2;
                    i12 = i43;
                } else {
                    str3 = str2;
                    iArr7 = iArr3;
                    jArr5 = jArr5;
                    iArr8 = iArr6;
                }
                j16 += j14;
                i17++;
                str2 = str3;
                iArr4 = iArr8;
                z12 = z12;
                jArr7 = jArr9;
                jArr5 = jArr5;
                iArr3 = iArr7;
                j12 = -1;
            }
        } else {
            str2 = str;
        }
        i12 = i11;
        jArr3 = track2.editListDurations;
        if (jArr3.length != 1) {
        }
        if (track2.type == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        z13 = false;
        i13 = 0;
        i14 = 0;
        i15 = 0;
        while (true) {
            jArr4 = track2.editListDurations;
            j12 = -1;
            if (i15 < jArr4.length) {
                break;
                break;
            }
            long[] jArr17 = jArr;
            int[] iArr14 = iArr;
            j15 = track2.editListMediaTimes[i15];
            if (j15 != -1) {
                long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(jArr4[i15], track2.timescale, track2.movieTimescale);
                iBinarySearchCeil3 = Util.binarySearchCeil(jArr2, j15, true, true);
                int iBinarySearchCeil5 = Util.binarySearchCeil(jArr2, j15 + jScaleLargeTimestamp7, z12, false);
                i13 += iBinarySearchCeil5 - iBinarySearchCeil3;
                if (i14 != iBinarySearchCeil3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z13 |= z16;
                i14 = iBinarySearchCeil5;
            }
            i15++;
            jArr = jArr17;
            iArr = iArr14;
        }
        jArr5 = jArr;
        iArr3 = iArr;
        if (i13 != sampleCount) {
            z14 = true;
        } else {
            z14 = false;
        }
        z15 = z13 | z14;
        if (z15) {
            jArr6 = new long[i13];
        } else {
            jArr6 = jArr5;
        }
        if (z15) {
            iArr4 = new int[i13];
        } else {
            iArr4 = iArr3;
        }
        if (z15) {
            i12 = 0;
        }
        if (z15) {
            iArr5 = new int[i13];
        } else {
            iArr5 = iArr2;
        }
        jArr7 = new long[i13];
        i16 = 0;
        i17 = 0;
        while (true) {
            jArr8 = track2.editListDurations;
            if (i17 < jArr8.length) {
                return new TrackSampleTable(track, jArr6, iArr4, i12, jArr7, iArr5, Util.scaleLargeTimestamp(j16, 1000000L, track2.timescale));
            }
            iArr6 = iArr4;
            jArr9 = jArr7;
            j13 = track2.editListMediaTimes[i17];
            j14 = jArr8[i17];
            if (j13 != j12) {
                long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(j14, track2.timescale, track2.movieTimescale) + j13;
                iBinarySearchCeil = Util.binarySearchCeil(jArr2, j13, true, true);
                iBinarySearchCeil2 = Util.binarySearchCeil(jArr2, jScaleLargeTimestamp8, z12, false);
                if (z15) {
                    int i45 = iBinarySearchCeil2 - iBinarySearchCeil;
                    System.arraycopy(jArr5, iBinarySearchCeil, jArr6, i16, i45);
                    iArr7 = iArr3;
                    iArr8 = iArr6;
                    System.arraycopy(iArr7, iBinarySearchCeil, iArr8, i16, i45);
                    System.arraycopy(iArr2, iBinarySearchCeil, iArr5, i16, i45);
                } else {
                    iArr7 = iArr3;
                    iArr8 = iArr6;
                }
                if (iBinarySearchCeil >= iBinarySearchCeil2) {
                }
                int i46 = i12;
                while (iBinarySearchCeil < iBinarySearchCeil2) {
                    int i47 = iBinarySearchCeil2;
                    String str5 = str2;
                    long j23 = j13;
                    jArr9[i16] = Util.scaleLargeTimestamp(j16, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr2[iBinarySearchCeil] - j13, 1000000L, track2.timescale);
                    if (!z15) {
                    }
                    i16++;
                    iBinarySearchCeil++;
                    iBinarySearchCeil2 = i47;
                    str2 = str5;
                    j13 = j23;
                }
                str3 = str2;
                i12 = i46;
            } else {
                str3 = str2;
                iArr7 = iArr3;
                jArr5 = jArr5;
                iArr8 = iArr6;
            }
            j16 += j14;
            i17++;
            str2 = str3;
            iArr4 = iArr8;
            z12 = z12;
            jArr7 = jArr9;
            jArr5 = jArr5;
            iArr3 = iArr7;
            j12 = -1;
        }
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i11, int i12, String str, DrmInitData drmInitData, boolean z11) throws ParserException {
        parsableByteArray.setPosition(12);
        int i13 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i13);
        for (int i14 = 0; i14 < i13; i14++) {
            int position = parsableByteArray.getPosition();
            int i15 = parsableByteArray.readInt();
            Assertions.checkArgument(i15 > 0, "childAtomSize should be positive");
            int i16 = parsableByteArray.readInt();
            if (i16 == Atom.TYPE_avc1 || i16 == Atom.TYPE_avc3 || i16 == Atom.TYPE_encv || i16 == Atom.TYPE_mp4v || i16 == Atom.TYPE_hvc1 || i16 == Atom.TYPE_hev1 || i16 == Atom.TYPE_s263 || i16 == Atom.TYPE_vp08 || i16 == Atom.TYPE_vp09) {
                parseVideoSampleEntry(parsableByteArray, i16, position, i15, i11, i12, drmInitData, stsdData, i14);
            } else if (i16 == Atom.TYPE_mp4a || i16 == Atom.TYPE_enca || i16 == Atom.TYPE_ac_3 || i16 == Atom.TYPE_ec_3 || i16 == Atom.TYPE_dtsc || i16 == Atom.TYPE_dtse || i16 == Atom.TYPE_dtsh || i16 == Atom.TYPE_dtsl || i16 == Atom.TYPE_samr || i16 == Atom.TYPE_sawb || i16 == Atom.TYPE_lpcm || i16 == Atom.TYPE_sowt || i16 == Atom.TYPE__mp3 || i16 == Atom.TYPE_alac) {
                parseAudioSampleEntry(parsableByteArray, i16, position, i15, i11, str, z11, drmInitData, stsdData, i14);
            } else if (i16 == Atom.TYPE_TTML || i16 == Atom.TYPE_tx3g || i16 == Atom.TYPE_wvtt || i16 == Atom.TYPE_stpp || i16 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, i16, position, i15, i11, str, stsdData);
            } else if (i16 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i11), MimeTypes.APPLICATION_CAMERA_MOTION, null, -1, null);
            }
            parsableByteArray.setPosition(position + i15);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i11, int i12, int i13, int i14, String str, StsdData stsdData) throws ParserException {
        parsableByteArray.setPosition(i12 + 16);
        int i15 = Atom.TYPE_TTML;
        String str2 = MimeTypes.APPLICATION_TTML;
        List listSingletonList = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != i15) {
            if (i11 == Atom.TYPE_tx3g) {
                int i16 = i13 - 16;
                byte[] bArr = new byte[i16];
                parsableByteArray.readBytes(bArr, 0, i16);
                listSingletonList = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i11 == Atom.TYPE_wvtt) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i11 == Atom.TYPE_stpp) {
                j11 = 0;
            } else {
                if (i11 != Atom.TYPE_c608) {
                    throw new IllegalStateException();
                }
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        stsdData.format = Format.createTextSampleFormat(Integer.toString(i14), str2, null, -1, 0, str, -1, null, j11, listSingletonList);
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j11;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i11 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i12 = fullAtomVersion == 0 ? 4 : 8;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            j11 = C.TIME_UNSET;
            if (i14 >= i12) {
                parsableByteArray.skipBytes(i12);
                break;
            }
            if (parsableByteArray.data[position + i14] != -1) {
                long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                if (unsignedInt == 0) {
                    break;
                }
                j11 = unsignedInt;
                break;
            }
            i14++;
        }
        parsableByteArray.skipBytes(16);
        int i15 = parsableByteArray.readInt();
        int i16 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i17 = parsableByteArray.readInt();
        int i18 = parsableByteArray.readInt();
        if (i15 == 0 && i16 == 65536 && i17 == -65536 && i18 == 0) {
            i13 = 90;
        } else if (i15 == 0 && i16 == -65536 && i17 == 65536 && i18 == 0) {
            i13 = 270;
        } else if (i15 == -65536 && i16 == 0 && i17 == 0 && i18 == -65536) {
            i13 = 180;
        }
        return new TkhdData(i11, j11, i13);
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j11, DrmInitData drmInitData, boolean z11, boolean z12) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int hdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (hdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long jScaleLargeTimestamp = C.TIME_UNSET;
        long j12 = j11 == C.TIME_UNSET ? tkhd.duration : j11;
        long mvhd = parseMvhd(leafAtom.data);
        if (j12 != C.TIME_UNSET) {
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(j12, 1000000L, mvhd);
        }
        long j13 = jScaleLargeTimestamp;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> mdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData stsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, tkhd.f46514id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z12);
        if (z11) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> edts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.f46514id, hdlr, ((Long) mdhd.first).longValue(), mvhd, j13, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z11) {
        if (z11) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i11 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + i11);
            }
            parsableByteArray.skipBytes(i11 - 8);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i11, int i12, int i13, int i14, int i15, DrmInitData drmInitData, StsdData stsdData, int i16) throws ParserException {
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i12 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str = null;
        int iIntValue = i11;
        if (iIntValue == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i12, i13);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i16] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        List<byte[]> listSingletonList = null;
        byte[] projFromParent = null;
        boolean z11 = false;
        float paspFromParent = 1.0f;
        int i17 = -1;
        while (position - i12 < i13) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i18 = parsableByteArray.readInt();
            if (i18 == 0 && parsableByteArray.getPosition() - i12 == i13) {
                break;
            }
            Assertions.checkArgument(i18 > 0, "childAtomSize should be positive");
            int i19 = parsableByteArray.readInt();
            if (i19 == Atom.TYPE_avcC) {
                Assertions.checkState(str == null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listSingletonList = avcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z11) {
                    paspFromParent = avcConfig.pixelWidthAspectRatio;
                }
                str = MimeTypes.VIDEO_H264;
            } else if (i19 == Atom.TYPE_hvcC) {
                Assertions.checkState(str == null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                listSingletonList = hevcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                str = MimeTypes.VIDEO_H265;
            } else if (i19 == Atom.TYPE_vpcC) {
                Assertions.checkState(str == null);
                str = iIntValue == Atom.TYPE_vp08 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
            } else if (i19 == Atom.TYPE_d263) {
                Assertions.checkState(str == null);
                str = MimeTypes.VIDEO_H263;
            } else if (i19 == Atom.TYPE_esds) {
                Assertions.checkState(str == null);
                Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                str = (String) esdsFromParent.first;
                listSingletonList = Collections.singletonList(esdsFromParent.second);
            } else if (i19 == Atom.TYPE_pasp) {
                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                z11 = true;
            } else if (i19 == Atom.TYPE_sv3d) {
                projFromParent = parseProjFromParent(parsableByteArray, position2, i18);
            } else if (i19 == Atom.TYPE_st3d) {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(3);
                if (unsignedByte == 0) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (unsignedByte2 == 0) {
                        i17 = 0;
                    } else if (unsignedByte2 == 1) {
                        i17 = 1;
                    } else if (unsignedByte2 == 2) {
                        i17 = 2;
                    } else if (unsignedByte2 == 3) {
                        i17 = 3;
                    }
                }
            }
            position += i18;
        }
        if (str == null) {
            return;
        }
        stsdData.format = Format.createVideoSampleFormat(Integer.toString(i14), str, null, -1, -1, unsignedShort, unsignedShort2, -1.0f, listSingletonList, i15, paspFromParent, projFromParent, i17, null, drmInitData2);
    }
}
