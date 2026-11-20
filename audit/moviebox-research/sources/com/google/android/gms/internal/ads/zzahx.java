package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahx {
    public byte[] zzN;
    public zzaeb zzT;
    public boolean zzU;
    public zzaea zzW;
    public int zzX;
    private int zzY;
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzadz zzi;
    public byte[] zzj;
    public zzae zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = 0;
    public int zzr = -1;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public byte[] zzv = null;
    public int zzw = -1;
    public boolean zzx = false;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzV = true;
    private String zzZ = "eng";

    private static Pair zzf(zzfp zzfpVar) throws zzcc {
        try {
            zzfpVar.zzL(16);
            long jZzs = zzfpVar.zzs();
            if (jZzs == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzs == 859189832) {
                return new Pair(MimeTypes.VIDEO_H263, null);
            }
            if (jZzs != 826496599) {
                zzff.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
            }
            int iZzd = zzfpVar.zzd() + 20;
            byte[] bArrZzM = zzfpVar.zzM();
            while (true) {
                int length = bArrZzM.length;
                if (iZzd >= length - 4) {
                    throw zzcc.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i11 = iZzd + 1;
                if (bArrZzM[iZzd] == 0 && bArrZzM[i11] == 0 && bArrZzM[iZzd + 2] == 1 && bArrZzM[iZzd + 3] == 15) {
                    return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrZzM, iZzd, length)));
                }
                iZzd = i11;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzcc {
        int i11;
        int i12;
        try {
            if (bArr[0] != 2) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int i13 = 1;
            int i14 = 0;
            while (true) {
                int i15 = bArr[i13];
                i13++;
                i11 = i15 & 255;
                if (i11 != 255) {
                    break;
                }
                i14 += 255;
            }
            int i16 = i14 + i11;
            int i17 = 0;
            while (true) {
                int i18 = bArr[i13];
                i13++;
                i12 = i18 & 255;
                if (i12 != 255) {
                    break;
                }
                i17 += 255;
            }
            int i19 = i17 + i12;
            if (bArr[i13] != 1) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i13, bArr2, 0, i16);
            int i21 = i13 + i16;
            if (bArr[i21] != 3) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int i22 = i21 + i19;
            if (bArr[i22] != 5) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i22;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i22, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzfp zzfpVar) throws zzcc {
        try {
            int iZzk = zzfpVar.zzk();
            if (iZzk == 1) {
                return true;
            }
            if (iZzk == 65534) {
                zzfpVar.zzK(24);
                if (zzfpVar.zzt() == zzahy.zzf.getMostSignificantBits() && zzfpVar.zzt() == zzahy.zzf.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing MS/ACM codec private", null);
        }
    }

    private final byte[] zzi(String str) throws zzcc {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzcc.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x0193  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ef A[PHI: r9
  0x01ef: PHI (r9v7 int) = (r9v1 int), (r9v2 int), (r9v3 int), (r9v4 int), (r9v5 int), (r9v0 int) binds: [B:140:0x027a, B:135:0x0247, B:132:0x0226, B:130:0x0221, B:128:0x021c, B:120:0x01ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:172:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:177:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:178:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:181:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:182:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:184:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:186:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:191:0x0407  */
    /* JADX WARN: Code duplicated, block: B:193:0x040c  */
    /* JADX WARN: Code duplicated, block: B:196:0x0413  */
    /* JADX WARN: Code duplicated, block: B:199:0x0423  */
    /* JADX WARN: Code duplicated, block: B:202:0x0429  */
    /* JADX WARN: Code duplicated, block: B:204:0x042f  */
    /* JADX WARN: Code duplicated, block: B:227:0x0512  */
    /* JADX WARN: Code duplicated, block: B:232:0x0533  */
    /* JADX WARN: Code duplicated, block: B:250:0x057e  */
    /* JADX WARN: Code duplicated, block: B:252:0x059e  */
    /* JADX WARN: Code duplicated, block: B:254:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:269:0x05d5  */
    public final void zze(zzacx zzacxVar, int i11) throws zzcc {
        byte b11;
        List listSingletonList;
        List list;
        String str;
        String str2;
        int i12;
        String str3;
        int i13;
        zzak zzakVar;
        int i14;
        int iIntValue;
        int i15;
        float f11;
        int i16;
        int i17;
        int i18;
        zzacq zzacqVarZza;
        String str4 = this.zzb;
        int iZzk = 4;
        int i19 = 0;
        switch (str4) {
            case "V_MPEG4/ISO/AP":
                b11 = 6;
                break;
            case "V_MPEG4/ISO/SP":
                b11 = 4;
                break;
            case "A_MS/ACM":
                b11 = Ascii.ETB;
                break;
            case "A_TRUEHD":
                b11 = Ascii.DC2;
                break;
            case "A_VORBIS":
                b11 = Ascii.VT;
                break;
            case "A_MPEG/L2":
                b11 = Ascii.SO;
                break;
            case "A_MPEG/L3":
                b11 = Ascii.SI;
                break;
            case "V_MS/VFW/FOURCC":
                b11 = 9;
                break;
            case "S_DVBSUB":
                b11 = 32;
                break;
            case "V_MPEG4/ISO/ASP":
                b11 = 5;
                break;
            case "V_MPEG4/ISO/AVC":
                b11 = 7;
                break;
            case "S_VOBSUB":
                b11 = Ascii.RS;
                break;
            case "A_DTS/LOSSLESS":
                b11 = Ascii.NAK;
                break;
            case "A_AAC":
                b11 = Ascii.CR;
                break;
            case "A_AC3":
                b11 = Ascii.DLE;
                break;
            case "A_DTS":
                b11 = 19;
                break;
            case "V_AV1":
                b11 = 2;
                break;
            case "V_VP8":
                b11 = 0;
                break;
            case "V_VP9":
                b11 = 1;
                break;
            case "S_HDMV/PGS":
                b11 = Ascii.US;
                break;
            case "V_THEORA":
                b11 = 10;
                break;
            case "A_DTS/EXPRESS":
                b11 = Ascii.DC4;
                break;
            case "A_PCM/FLOAT/IEEE":
                b11 = Ascii.SUB;
                break;
            case "A_PCM/INT/BIG":
                b11 = Ascii.EM;
                break;
            case "A_PCM/INT/LIT":
                b11 = Ascii.CAN;
                break;
            case "S_TEXT/ASS":
                b11 = Ascii.FS;
                break;
            case "V_MPEGH/ISO/HEVC":
                b11 = 8;
                break;
            case "S_TEXT/WEBVTT":
                b11 = Ascii.GS;
                break;
            case "S_TEXT/UTF8":
                b11 = Ascii.ESC;
                break;
            case "V_MPEG2":
                b11 = 3;
                break;
            case "A_EAC3":
                b11 = 17;
                break;
            case "A_FLAC":
                b11 = Ascii.SYN;
                break;
            case "A_OPUS":
                b11 = Ascii.FF;
                break;
            default:
                b11 = -1;
                break;
        }
        String str5 = MimeTypes.AUDIO_RAW;
        zzt zztVarZzg = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        byte[] bArr = null;
        switch (b11) {
            case 0:
                str5 = MimeTypes.VIDEO_VP8;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null && (zzacqVarZza = zzacq.zza(new zzfp(this.zzN))) != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z11 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i21 = (z11 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                } else if (zzcb.zzh(str3)) {
                    if (this.zzq == 0) {
                        i17 = this.zzo;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzl;
                        }
                        this.zzo = i17;
                        i18 = this.zzp;
                        if (i18 == -1) {
                            i18 = this.zzm;
                        }
                        this.zzp = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i15 = this.zzo;
                    if (i15 != iIntValue || (i16 = this.zzp) == iIntValue) {
                        f11 = -1.0f;
                    } else {
                        f11 = (this.zzm * i15) / (this.zzl * i16);
                    }
                    if (this.zzx) {
                        if (this.zzD != -1.0f && this.zzE != -1.0f && this.zzF != -1.0f && this.zzG != -1.0f && this.zzH != -1.0f && this.zzI != -1.0f && this.zzJ != -1.0f && this.zzK != -1.0f && this.zzL != -1.0f && this.zzM != -1.0f) {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzL + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                            byteBufferOrder.putShort((short) this.zzB);
                            byteBufferOrder.putShort((short) this.zzC);
                        }
                        zzr zzrVar = new zzr();
                        zzrVar.zzc(this.zzy);
                        zzrVar.zzb(this.zzA);
                        zzrVar.zzd(this.zzz);
                        zzrVar.zze(bArr);
                        zzrVar.zzf(this.zzn);
                        zzrVar.zza(this.zzn);
                        zztVarZzg = zzrVar.zzg();
                    }
                    if (this.zza != null && zzahy.zzg.containsKey(this.zza)) {
                        iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                    }
                    if (this.zzr == 0 || Float.compare(this.zzs, 0.0f) != 0 || Float.compare(this.zzt, 0.0f) != 0) {
                        i19 = iIntValue;
                    } else if (Float.compare(this.zzu, 0.0f) != 0) {
                        if (Float.compare(this.zzu, 90.0f) == 0) {
                            i19 = 90;
                        } else if (Float.compare(this.zzu, -180.0f) == 0 || Float.compare(this.zzu, 180.0f) == 0) {
                            i19 = 180;
                        } else if (Float.compare(this.zzu, -90.0f) == 0) {
                            i19 = 270;
                        } else {
                            i19 = iIntValue;
                        }
                    }
                    zzakVar.zzab(this.zzl);
                    zzakVar.zzI(this.zzm);
                    zzakVar.zzS(f11);
                    zzakVar.zzV(i19);
                    zzakVar.zzT(this.zzv);
                    zzakVar.zzZ(this.zzw);
                    zzakVar.zzA(zztVarZzg);
                    i14 = 2;
                } else {
                    if (MimeTypes.APPLICATION_SUBRIP.equals(str3) && !MimeTypes.TEXT_SSA.equals(str3) && !MimeTypes.TEXT_VTT.equals(str3) && !MimeTypes.APPLICATION_VOBSUB.equals(str3) && !MimeTypes.APPLICATION_PGS.equals(str3) && !MimeTypes.APPLICATION_DVBSUBS.equals(str3)) {
                        throw zzcc.zza("Unexpected MIME type.", null);
                    }
                    i14 = 3;
                }
                if (this.zza != null && !zzahy.zzg.containsKey(this.zza)) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i21);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac = zzakVar.zzac();
                zzaea zzaeaVarZzw = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw;
                zzaeaVarZzw.zzl(zzamVarZzac);
                return;
            case 1:
                str5 = MimeTypes.VIDEO_VP9;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z12 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i22 = (z12 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder2 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder2.put((byte) 0);
                                byteBufferOrder2.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder2.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder2.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder2.putShort((short) this.zzB);
                                byteBufferOrder2.putShort((short) this.zzC);
                            }
                            zzr zzrVar2 = new zzr();
                            zzrVar2.zzc(this.zzy);
                            zzrVar2.zzb(this.zzA);
                            zzrVar2.zzd(this.zzz);
                            zzrVar2.zze(bArr);
                            zzrVar2.zzf(this.zzn);
                            zzrVar2.zza(this.zzn);
                            zztVarZzg = zzrVar2.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i22);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac2 = zzakVar.zzac();
                zzaea zzaeaVarZzw2 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw2;
                zzaeaVarZzw2.zzl(zzamVarZzac2);
                return;
            case 2:
                str5 = "video/av01";
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z13 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i23 = (z13 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder3 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder3.put((byte) 0);
                                byteBufferOrder3.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder3.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder3.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder3.putShort((short) this.zzB);
                                byteBufferOrder3.putShort((short) this.zzC);
                            }
                            zzr zzrVar3 = new zzr();
                            zzrVar3.zzc(this.zzy);
                            zzrVar3.zzb(this.zzA);
                            zzrVar3.zzd(this.zzz);
                            zzrVar3.zze(bArr);
                            zzrVar3.zzf(this.zzn);
                            zzrVar3.zza(this.zzn);
                            zztVarZzg = zzrVar3.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i23);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac3 = zzakVar.zzac();
                zzaea zzaeaVarZzw3 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw3;
                zzaeaVarZzw3.zzl(zzamVarZzac3);
                return;
            case 3:
                str5 = MimeTypes.VIDEO_MPEG2;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z14 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i24 = (z14 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder4 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder4.put((byte) 0);
                                byteBufferOrder4.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder4.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder4.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder4.putShort((short) this.zzB);
                                byteBufferOrder4.putShort((short) this.zzC);
                            }
                            zzr zzrVar4 = new zzr();
                            zzrVar4.zzc(this.zzy);
                            zzrVar4.zzb(this.zzA);
                            zzrVar4.zzd(this.zzz);
                            zzrVar4.zze(bArr);
                            zzrVar4.zzf(this.zzn);
                            zzrVar4.zza(this.zzn);
                            zztVarZzg = zzrVar4.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i24);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac4 = zzakVar.zzac();
                zzaea zzaeaVarZzw4 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw4;
                zzaeaVarZzw4.zzl(zzamVarZzac4);
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr2 = this.zzj;
                listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str5 = MimeTypes.VIDEO_MP4V;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z15 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i25 = (z15 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder5 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder5.put((byte) 0);
                                byteBufferOrder5.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder5.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder5.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder5.putShort((short) this.zzB);
                                byteBufferOrder5.putShort((short) this.zzC);
                            }
                            zzr zzrVar5 = new zzr();
                            zzrVar5.zzc(this.zzy);
                            zzrVar5.zzb(this.zzA);
                            zzrVar5.zzd(this.zzz);
                            zzrVar5.zze(bArr);
                            zzrVar5.zzf(this.zzn);
                            zzrVar5.zza(this.zzn);
                            zztVarZzg = zzrVar5.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i25);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac5 = zzakVar.zzac();
                zzaea zzaeaVarZzw5 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw5;
                zzaeaVarZzw5.zzl(zzamVarZzac5);
                return;
            case 7:
                zzabz zzabzVarZza = zzabz.zza(new zzfp(zzi(this.zzb)));
                list = zzabzVarZza.zza;
                this.zzX = zzabzVarZza.zzb;
                str = zzabzVarZza.zzk;
                str5 = MimeTypes.VIDEO_H264;
                str2 = str;
                listSingletonList = list;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z16 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i26 = (z16 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder6 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder6.put((byte) 0);
                                byteBufferOrder6.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder6.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder6.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder6.putShort((short) this.zzB);
                                byteBufferOrder6.putShort((short) this.zzC);
                            }
                            zzr zzrVar6 = new zzr();
                            zzrVar6.zzc(this.zzy);
                            zzrVar6.zzb(this.zzA);
                            zzrVar6.zzd(this.zzz);
                            zzrVar6.zze(bArr);
                            zzrVar6.zzf(this.zzn);
                            zzrVar6.zza(this.zzn);
                            zztVarZzg = zzrVar6.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i26);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac6 = zzakVar.zzac();
                zzaea zzaeaVarZzw6 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw6;
                zzaeaVarZzw6.zzl(zzamVarZzac6);
                return;
            case 8:
                zzadl zzadlVarZza = zzadl.zza(new zzfp(zzi(this.zzb)));
                list = zzadlVarZza.zza;
                this.zzX = zzadlVarZza.zzb;
                str = zzadlVarZza.zzi;
                str5 = MimeTypes.VIDEO_H265;
                str2 = str;
                listSingletonList = list;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z17 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i27 = (z17 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder7 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder7.put((byte) 0);
                                byteBufferOrder7.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder7.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder7.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder7.putShort((short) this.zzB);
                                byteBufferOrder7.putShort((short) this.zzC);
                            }
                            zzr zzrVar7 = new zzr();
                            zzrVar7.zzc(this.zzy);
                            zzrVar7.zzb(this.zzA);
                            zzrVar7.zzd(this.zzz);
                            zzrVar7.zze(bArr);
                            zzrVar7.zzf(this.zzn);
                            zzrVar7.zza(this.zzn);
                            zztVarZzg = zzrVar7.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i27);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac7 = zzakVar.zzac();
                zzaea zzaeaVarZzw7 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw7;
                zzaeaVarZzw7.zzl(zzamVarZzac7);
                return;
            case 9:
                Pair pairZzf = zzf(new zzfp(zzi(this.zzb)));
                str5 = (String) pairZzf.first;
                listSingletonList = (List) pairZzf.second;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z18 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i28 = (z18 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder8 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder8.put((byte) 0);
                                byteBufferOrder8.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder8.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder8.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder8.putShort((short) this.zzB);
                                byteBufferOrder8.putShort((short) this.zzC);
                            }
                            zzr zzrVar8 = new zzr();
                            zzrVar8.zzc(this.zzy);
                            zzrVar8.zzb(this.zzA);
                            zzrVar8.zzd(this.zzz);
                            zzrVar8.zze(bArr);
                            zzrVar8.zzf(this.zzn);
                            zzrVar8.zza(this.zzn);
                            zztVarZzg = zzrVar8.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i28);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac8 = zzakVar.zzac();
                zzaea zzaeaVarZzw8 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw8;
                zzaeaVarZzw8.zzl(zzamVarZzac8);
                return;
            case 10:
                str5 = MimeTypes.VIDEO_UNKNOWN;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z19 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i29 = (z19 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder9 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder9.put((byte) 0);
                                byteBufferOrder9.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder9.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder9.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder9.putShort((short) this.zzB);
                                byteBufferOrder9.putShort((short) this.zzC);
                            }
                            zzr zzrVar9 = new zzr();
                            zzrVar9.zzc(this.zzy);
                            zzrVar9.zzb(this.zzA);
                            zzrVar9.zzd(this.zzz);
                            zzrVar9.zze(bArr);
                            zzrVar9.zzf(this.zzn);
                            zzrVar9.zza(this.zzn);
                            zztVarZzg = zzrVar9.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i29);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac9 = zzakVar.zzac();
                zzaea zzaeaVarZzw9 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw9;
                zzaeaVarZzw9.zzl(zzamVarZzac9);
                return;
            case 11:
                listSingletonList = zzg(zzi(str4));
                i12 = 8192;
                str5 = MimeTypes.AUDIO_VORBIS;
                str2 = null;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z110 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i210 = (z110 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder10 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder10.put((byte) 0);
                                byteBufferOrder10.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder10.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder10.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder10.putShort((short) this.zzB);
                                byteBufferOrder10.putShort((short) this.zzC);
                            }
                            zzr zzrVar10 = new zzr();
                            zzrVar10.zzc(this.zzy);
                            zzrVar10.zzb(this.zzA);
                            zzrVar10.zzd(this.zzz);
                            zzrVar10.zze(bArr);
                            zzrVar10.zzf(this.zzn);
                            zzrVar10.zza(this.zzn);
                            zztVarZzg = zzrVar10.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i210);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac10 = zzakVar.zzac();
                zzaea zzaeaVarZzw10 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw10;
                zzaeaVarZzw10.zzl(zzamVarZzac10);
                return;
            case 12:
                listSingletonList = new ArrayList(3);
                listSingletonList.add(zzi(this.zzb));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.zzR).array());
                listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.zzS).array());
                i12 = 5760;
                str5 = MimeTypes.AUDIO_OPUS;
                str2 = null;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z111 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i211 = (z111 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder11 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder11.put((byte) 0);
                                byteBufferOrder11.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder11.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder11.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder11.putShort((short) this.zzB);
                                byteBufferOrder11.putShort((short) this.zzC);
                            }
                            zzr zzrVar11 = new zzr();
                            zzrVar11.zzc(this.zzy);
                            zzrVar11.zzb(this.zzA);
                            zzrVar11.zzd(this.zzz);
                            zzrVar11.zze(bArr);
                            zzrVar11.zzf(this.zzn);
                            zzrVar11.zza(this.zzn);
                            zztVarZzg = zzrVar11.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i211);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac11 = zzakVar.zzac();
                zzaea zzaeaVarZzw11 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw11;
                zzaeaVarZzw11.zzl(zzamVarZzac11);
                return;
            case 13:
                listSingletonList = Collections.singletonList(zzi(str4));
                zzabr zzabrVarZza = zzabs.zza(this.zzj);
                this.zzQ = zzabrVarZza.zza;
                this.zzO = zzabrVarZza.zzb;
                String str6 = zzabrVarZza.zzc;
                str5 = MimeTypes.AUDIO_AAC;
                str2 = str6;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z112 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i212 = (z112 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder12 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder12.put((byte) 0);
                                byteBufferOrder12.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder12.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder12.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder12.putShort((short) this.zzB);
                                byteBufferOrder12.putShort((short) this.zzC);
                            }
                            zzr zzrVar12 = new zzr();
                            zzrVar12.zzc(this.zzy);
                            zzrVar12.zzb(this.zzA);
                            zzrVar12.zzd(this.zzz);
                            zzrVar12.zze(bArr);
                            zzrVar12.zzf(this.zzn);
                            zzrVar12.zza(this.zzn);
                            zztVarZzg = zzrVar12.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i212);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac12 = zzakVar.zzac();
                zzaea zzaeaVarZzw12 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw12;
                zzaeaVarZzw12.zzl(zzamVarZzac12);
                return;
            case 14:
                str5 = MimeTypes.AUDIO_MPEG_L2;
                listSingletonList = null;
                str2 = null;
                i12 = 4096;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z113 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i213 = (z113 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder13 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder13.put((byte) 0);
                                byteBufferOrder13.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder13.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder13.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder13.putShort((short) this.zzB);
                                byteBufferOrder13.putShort((short) this.zzC);
                            }
                            zzr zzrVar13 = new zzr();
                            zzrVar13.zzc(this.zzy);
                            zzrVar13.zzb(this.zzA);
                            zzrVar13.zzd(this.zzz);
                            zzrVar13.zze(bArr);
                            zzrVar13.zzf(this.zzn);
                            zzrVar13.zza(this.zzn);
                            zztVarZzg = zzrVar13.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i213);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac13 = zzakVar.zzac();
                zzaea zzaeaVarZzw13 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw13;
                zzaeaVarZzw13.zzl(zzamVarZzac13);
                return;
            case 15:
                str5 = MimeTypes.AUDIO_MPEG;
                listSingletonList = null;
                str2 = null;
                i12 = 4096;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z114 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i214 = (z114 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder14 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder14.put((byte) 0);
                                byteBufferOrder14.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder14.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder14.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder14.putShort((short) this.zzB);
                                byteBufferOrder14.putShort((short) this.zzC);
                            }
                            zzr zzrVar14 = new zzr();
                            zzrVar14.zzc(this.zzy);
                            zzrVar14.zzb(this.zzA);
                            zzrVar14.zzd(this.zzz);
                            zzrVar14.zze(bArr);
                            zzrVar14.zzf(this.zzn);
                            zzrVar14.zza(this.zzn);
                            zztVarZzg = zzrVar14.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i214);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac14 = zzakVar.zzac();
                zzaea zzaeaVarZzw14 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw14;
                zzaeaVarZzw14.zzl(zzamVarZzac14);
                return;
            case 16:
                str5 = MimeTypes.AUDIO_AC3;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z115 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i215 = (z115 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder15 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder15.put((byte) 0);
                                byteBufferOrder15.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder15.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder15.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder15.putShort((short) this.zzB);
                                byteBufferOrder15.putShort((short) this.zzC);
                            }
                            zzr zzrVar15 = new zzr();
                            zzrVar15.zzc(this.zzy);
                            zzrVar15.zzb(this.zzA);
                            zzrVar15.zzd(this.zzz);
                            zzrVar15.zze(bArr);
                            zzrVar15.zzf(this.zzn);
                            zzrVar15.zza(this.zzn);
                            zztVarZzg = zzrVar15.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i215);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac15 = zzakVar.zzac();
                zzaea zzaeaVarZzw15 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw15;
                zzaeaVarZzw15.zzl(zzamVarZzac15);
                return;
            case 17:
                str5 = MimeTypes.AUDIO_E_AC3;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z116 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i216 = (z116 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder16 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder16.put((byte) 0);
                                byteBufferOrder16.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder16.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder16.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder16.putShort((short) this.zzB);
                                byteBufferOrder16.putShort((short) this.zzC);
                            }
                            zzr zzrVar16 = new zzr();
                            zzrVar16.zzc(this.zzy);
                            zzrVar16.zzb(this.zzA);
                            zzrVar16.zzd(this.zzz);
                            zzrVar16.zze(bArr);
                            zzrVar16.zzf(this.zzn);
                            zzrVar16.zza(this.zzn);
                            zztVarZzg = zzrVar16.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i216);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac16 = zzakVar.zzac();
                zzaea zzaeaVarZzw16 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw16;
                zzaeaVarZzw16.zzl(zzamVarZzac16);
                return;
            case 18:
                this.zzT = new zzaeb();
                str5 = MimeTypes.AUDIO_TRUEHD;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z117 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i217 = (z117 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder17 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder17.put((byte) 0);
                                byteBufferOrder17.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder17.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder17.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder17.putShort((short) this.zzB);
                                byteBufferOrder17.putShort((short) this.zzC);
                            }
                            zzr zzrVar17 = new zzr();
                            zzrVar17.zzc(this.zzy);
                            zzrVar17.zzb(this.zzA);
                            zzrVar17.zzd(this.zzz);
                            zzrVar17.zze(bArr);
                            zzrVar17.zzf(this.zzn);
                            zzrVar17.zza(this.zzn);
                            zztVarZzg = zzrVar17.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i217);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac17 = zzakVar.zzac();
                zzaea zzaeaVarZzw17 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw17;
                zzaeaVarZzw17.zzl(zzamVarZzac17);
                return;
            case 19:
            case 20:
                str5 = MimeTypes.AUDIO_DTS;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z118 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i218 = (z118 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder18 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder18.put((byte) 0);
                                byteBufferOrder18.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder18.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder18.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder18.putShort((short) this.zzB);
                                byteBufferOrder18.putShort((short) this.zzC);
                            }
                            zzr zzrVar18 = new zzr();
                            zzrVar18.zzc(this.zzy);
                            zzrVar18.zzb(this.zzA);
                            zzrVar18.zzd(this.zzz);
                            zzrVar18.zze(bArr);
                            zzrVar18.zzf(this.zzn);
                            zzrVar18.zza(this.zzn);
                            zztVarZzg = zzrVar18.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i218);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac18 = zzakVar.zzac();
                zzaea zzaeaVarZzw18 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw18;
                zzaeaVarZzw18.zzl(zzamVarZzac18);
                return;
            case 21:
                str5 = MimeTypes.AUDIO_DTS_HD;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z119 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i219 = (z119 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder19 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder19.put((byte) 0);
                                byteBufferOrder19.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder19.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder19.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder19.putShort((short) this.zzB);
                                byteBufferOrder19.putShort((short) this.zzC);
                            }
                            zzr zzrVar19 = new zzr();
                            zzrVar19.zzc(this.zzy);
                            zzrVar19.zzb(this.zzA);
                            zzrVar19.zzd(this.zzz);
                            zzrVar19.zze(bArr);
                            zzrVar19.zzf(this.zzn);
                            zzrVar19.zza(this.zzn);
                            zztVarZzg = zzrVar19.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i219);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac19 = zzakVar.zzac();
                zzaea zzaeaVarZzw19 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw19;
                zzaeaVarZzw19.zzl(zzamVarZzac19);
                return;
            case 22:
                listSingletonList = Collections.singletonList(zzi(str4));
                str5 = MimeTypes.AUDIO_FLAC;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1110 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2110 = (z1110 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder110 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder110.put((byte) 0);
                                byteBufferOrder110.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder110.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder110.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder110.putShort((short) this.zzB);
                                byteBufferOrder110.putShort((short) this.zzC);
                            }
                            zzr zzrVar110 = new zzr();
                            zzrVar110.zzc(this.zzy);
                            zzrVar110.zzb(this.zzA);
                            zzrVar110.zzd(this.zzz);
                            zzrVar110.zze(bArr);
                            zzrVar110.zzf(this.zzn);
                            zzrVar110.zza(this.zzn);
                            zztVarZzg = zzrVar110.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2110);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac110 = zzakVar.zzac();
                zzaea zzaeaVarZzw110 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw110;
                zzaeaVarZzw110.zzl(zzamVarZzac110);
                return;
            case 23:
                if (zzh(new zzfp(zzi(this.zzb)))) {
                    iZzk = zzfy.zzk(this.zzP);
                    if (iZzk == 0) {
                        zzff.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + this.zzP + ". Setting mimeType to audio/x-unknown");
                    } else {
                        listSingletonList = null;
                        str2 = null;
                        i12 = -1;
                    }
                    if (this.zzN != null) {
                        str2 = zzacqVarZza.zza;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z1111 = this.zzV;
                    if (true != this.zzU) {
                        i13 = 0;
                    } else {
                        i13 = 2;
                    }
                    int i2111 = (z1111 ? 1 : 0) | i13;
                    zzakVar = new zzak();
                    if (zzcb.zzg(str3)) {
                        if (zzcb.zzh(str3)) {
                            if (this.zzq == 0) {
                                i17 = this.zzo;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.zzl;
                                }
                                this.zzo = i17;
                                i18 = this.zzp;
                                if (i18 == -1) {
                                    i18 = this.zzm;
                                }
                                this.zzp = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.zzo;
                            if (i15 != iIntValue) {
                                f11 = -1.0f;
                            } else {
                                f11 = -1.0f;
                            }
                            if (this.zzx) {
                                if (this.zzD != -1.0f) {
                                    bArr = new byte[25];
                                    ByteBuffer byteBufferOrder111 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                    byteBufferOrder111.put((byte) 0);
                                    byteBufferOrder111.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                    byteBufferOrder111.putShort((short) (this.zzL + 0.5f));
                                    byteBufferOrder111.putShort((short) (this.zzM + 0.5f));
                                    byteBufferOrder111.putShort((short) this.zzB);
                                    byteBufferOrder111.putShort((short) this.zzC);
                                }
                                zzr zzrVar111 = new zzr();
                                zzrVar111.zzc(this.zzy);
                                zzrVar111.zzb(this.zzA);
                                zzrVar111.zzd(this.zzz);
                                zzrVar111.zze(bArr);
                                zzrVar111.zzf(this.zzn);
                                zzrVar111.zza(this.zzn);
                                zztVarZzg = zzrVar111.zzg();
                            }
                            if (this.zza != null) {
                                iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                            }
                            if (this.zzr == 0) {
                                i19 = iIntValue;
                            } else {
                                i19 = iIntValue;
                            }
                            zzakVar.zzab(this.zzl);
                            zzakVar.zzI(this.zzm);
                            zzakVar.zzS(f11);
                            zzakVar.zzV(i19);
                            zzakVar.zzT(this.zzv);
                            zzakVar.zzZ(this.zzw);
                            zzakVar.zzA(zztVarZzg);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        zzakVar.zzy(this.zzO);
                        zzakVar.zzX(this.zzQ);
                        zzakVar.zzQ(iZzk);
                        i14 = 1;
                    }
                    if (this.zza != null) {
                        zzakVar.zzM(this.zza);
                    }
                    zzakVar.zzJ(i11);
                    zzakVar.zzW(str3);
                    zzakVar.zzO(i12);
                    zzakVar.zzN(this.zzZ);
                    zzakVar.zzY(i2111);
                    zzakVar.zzL(listSingletonList);
                    zzakVar.zzz(str2);
                    zzakVar.zzE(this.zzk);
                    zzam zzamVarZzac111 = zzakVar.zzac();
                    zzaea zzaeaVarZzw111 = zzacxVar.zzw(this.zzc, i14);
                    this.zzW = zzaeaVarZzw111;
                    zzaeaVarZzw111.zzl(zzamVarZzac111);
                    return;
                }
                zzff.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                listSingletonList = null;
                str2 = null;
                str5 = MimeTypes.AUDIO_UNKNOWN;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1112 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2112 = (z1112 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder112 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder112.put((byte) 0);
                                byteBufferOrder112.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder112.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder112.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder112.putShort((short) this.zzB);
                                byteBufferOrder112.putShort((short) this.zzC);
                            }
                            zzr zzrVar112 = new zzr();
                            zzrVar112.zzc(this.zzy);
                            zzrVar112.zzb(this.zzA);
                            zzrVar112.zzd(this.zzz);
                            zzrVar112.zze(bArr);
                            zzrVar112.zzf(this.zzn);
                            zzrVar112.zza(this.zzn);
                            zztVarZzg = zzrVar112.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2112);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac112 = zzakVar.zzac();
                zzaea zzaeaVarZzw112 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw112;
                zzaeaVarZzw112.zzl(zzamVarZzac112);
                return;
            case 24:
                iZzk = zzfy.zzk(this.zzP);
                if (iZzk == 0) {
                    zzff.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.zzP + ". Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str2 = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i12 = -1;
                    iZzk = -1;
                } else {
                    listSingletonList = null;
                    str2 = null;
                    i12 = -1;
                }
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1113 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2113 = (z1113 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder113 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder113.put((byte) 0);
                                byteBufferOrder113.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder113.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder113.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder113.putShort((short) this.zzB);
                                byteBufferOrder113.putShort((short) this.zzC);
                            }
                            zzr zzrVar113 = new zzr();
                            zzrVar113.zzc(this.zzy);
                            zzrVar113.zzb(this.zzA);
                            zzrVar113.zzd(this.zzz);
                            zzrVar113.zze(bArr);
                            zzrVar113.zzf(this.zzn);
                            zzrVar113.zza(this.zzn);
                            zztVarZzg = zzrVar113.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2113);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac113 = zzakVar.zzac();
                zzaea zzaeaVarZzw113 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw113;
                zzaeaVarZzw113.zzl(zzamVarZzac113);
                return;
            case 25:
                int i31 = this.zzP;
                if (i31 == 8) {
                    listSingletonList = null;
                    str2 = null;
                    i12 = -1;
                    iZzk = 3;
                } else {
                    if (i31 == 16) {
                        iZzk = ASTNode.DEOP;
                    } else if (i31 == 24) {
                        iZzk = 1342177280;
                    } else if (i31 == 32) {
                        iZzk = 1610612736;
                    } else {
                        zzff.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i31 + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str2 = null;
                        str5 = MimeTypes.AUDIO_UNKNOWN;
                        i12 = -1;
                        iZzk = -1;
                    }
                    listSingletonList = null;
                    str2 = null;
                    i12 = -1;
                }
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1114 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2114 = (z1114 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder114 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder114.put((byte) 0);
                                byteBufferOrder114.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder114.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder114.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder114.putShort((short) this.zzB);
                                byteBufferOrder114.putShort((short) this.zzC);
                            }
                            zzr zzrVar114 = new zzr();
                            zzrVar114.zzc(this.zzy);
                            zzrVar114.zzb(this.zzA);
                            zzrVar114.zzd(this.zzz);
                            zzrVar114.zze(bArr);
                            zzrVar114.zzf(this.zzn);
                            zzrVar114.zza(this.zzn);
                            zztVarZzg = zzrVar114.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2114);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac114 = zzakVar.zzac();
                zzaea zzaeaVarZzw114 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw114;
                zzaeaVarZzw114.zzl(zzamVarZzac114);
                return;
            case 26:
                int i32 = this.zzP;
                if (i32 == 32) {
                    listSingletonList = null;
                    str2 = null;
                    i12 = -1;
                } else {
                    zzff.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i32 + ". Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str2 = null;
                    str5 = MimeTypes.AUDIO_UNKNOWN;
                    i12 = -1;
                    iZzk = -1;
                }
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1115 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2115 = (z1115 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder115 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder115.put((byte) 0);
                                byteBufferOrder115.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder115.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder115.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder115.putShort((short) this.zzB);
                                byteBufferOrder115.putShort((short) this.zzC);
                            }
                            zzr zzrVar115 = new zzr();
                            zzrVar115.zzc(this.zzy);
                            zzrVar115.zzb(this.zzA);
                            zzrVar115.zzd(this.zzz);
                            zzrVar115.zze(bArr);
                            zzrVar115.zzf(this.zzn);
                            zzrVar115.zza(this.zzn);
                            zztVarZzg = zzrVar115.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2115);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac115 = zzakVar.zzac();
                zzaea zzaeaVarZzw115 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw115;
                zzaeaVarZzw115.zzl(zzamVarZzac115);
                return;
            case 27:
                str5 = MimeTypes.APPLICATION_SUBRIP;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1116 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2116 = (z1116 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder116 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder116.put((byte) 0);
                                byteBufferOrder116.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder116.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder116.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder116.putShort((short) this.zzB);
                                byteBufferOrder116.putShort((short) this.zzC);
                            }
                            zzr zzrVar116 = new zzr();
                            zzrVar116.zzc(this.zzy);
                            zzrVar116.zzb(this.zzA);
                            zzrVar116.zzd(this.zzz);
                            zzrVar116.zze(bArr);
                            zzrVar116.zzf(this.zzn);
                            zzrVar116.zza(this.zzn);
                            zztVarZzg = zzrVar116.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2116);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac116 = zzakVar.zzac();
                zzaea zzaeaVarZzw116 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw116;
                zzaeaVarZzw116.zzl(zzamVarZzac116);
                return;
            case 28:
                listSingletonList = zzgaa.zzn(zzahy.zzc, zzi(this.zzb));
                str5 = MimeTypes.TEXT_SSA;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1117 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2117 = (z1117 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder117 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder117.put((byte) 0);
                                byteBufferOrder117.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder117.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder117.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder117.putShort((short) this.zzB);
                                byteBufferOrder117.putShort((short) this.zzC);
                            }
                            zzr zzrVar117 = new zzr();
                            zzrVar117.zzc(this.zzy);
                            zzrVar117.zzb(this.zzA);
                            zzrVar117.zzd(this.zzz);
                            zzrVar117.zze(bArr);
                            zzrVar117.zzf(this.zzn);
                            zzrVar117.zza(this.zzn);
                            zztVarZzg = zzrVar117.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2117);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac117 = zzakVar.zzac();
                zzaea zzaeaVarZzw117 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw117;
                zzaeaVarZzw117.zzl(zzamVarZzac117);
                return;
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                str5 = MimeTypes.TEXT_VTT;
                listSingletonList = null;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1118 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2118 = (z1118 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder118 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder118.put((byte) 0);
                                byteBufferOrder118.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder118.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder118.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder118.putShort((short) this.zzB);
                                byteBufferOrder118.putShort((short) this.zzC);
                            }
                            zzr zzrVar118 = new zzr();
                            zzrVar118.zzc(this.zzy);
                            zzrVar118.zzb(this.zzA);
                            zzrVar118.zzd(this.zzz);
                            zzrVar118.zze(bArr);
                            zzrVar118.zzf(this.zzn);
                            zzrVar118.zza(this.zzn);
                            zztVarZzg = zzrVar118.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2118);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac118 = zzakVar.zzac();
                zzaea zzaeaVarZzw118 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw118;
                zzaeaVarZzw118.zzl(zzamVarZzac118);
                return;
            case 30:
                listSingletonList = zzgaa.zzm(zzi(str4));
                str2 = null;
                str5 = MimeTypes.APPLICATION_VOBSUB;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1119 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i2119 = (z1119 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder119 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder119.put((byte) 0);
                                byteBufferOrder119.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder119.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder119.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder119.putShort((short) this.zzB);
                                byteBufferOrder119.putShort((short) this.zzC);
                            }
                            zzr zzrVar119 = new zzr();
                            zzrVar119.zzc(this.zzy);
                            zzrVar119.zzb(this.zzA);
                            zzrVar119.zzd(this.zzz);
                            zzrVar119.zze(bArr);
                            zzrVar119.zzf(this.zzn);
                            zzrVar119.zza(this.zzn);
                            zztVarZzg = zzrVar119.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i2119);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac119 = zzakVar.zzac();
                zzaea zzaeaVarZzw119 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw119;
                zzaeaVarZzw119.zzl(zzamVarZzac119);
                return;
            case VungleException.WEB_CRASH /* 31 */:
                listSingletonList = null;
                str2 = null;
                str5 = MimeTypes.APPLICATION_PGS;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z11110 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i21110 = (z11110 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1110 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1110.put((byte) 0);
                                byteBufferOrder1110.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder1110.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder1110.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder1110.putShort((short) this.zzB);
                                byteBufferOrder1110.putShort((short) this.zzC);
                            }
                            zzr zzrVar1110 = new zzr();
                            zzrVar1110.zzc(this.zzy);
                            zzrVar1110.zzb(this.zzA);
                            zzrVar1110.zzd(this.zzz);
                            zzrVar1110.zze(bArr);
                            zzrVar1110.zzf(this.zzn);
                            zzrVar1110.zza(this.zzn);
                            zztVarZzg = zzrVar1110.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i21110);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac1110 = zzakVar.zzac();
                zzaea zzaeaVarZzw1110 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw1110;
                zzaeaVarZzw1110.zzl(zzamVarZzac1110);
                return;
            case 32:
                byte[] bArr3 = new byte[4];
                System.arraycopy(zzi(str4), 0, bArr3, 0, 4);
                listSingletonList = zzgaa.zzm(bArr3);
                str5 = MimeTypes.APPLICATION_DVBSUBS;
                str2 = null;
                i12 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z11111 = this.zzV;
                if (true != this.zzU) {
                    i13 = 0;
                } else {
                    i13 = 2;
                }
                int i21111 = (z11111 ? 1 : 0) | i13;
                zzakVar = new zzak();
                if (zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i17 = this.zzo;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzl;
                            }
                            this.zzo = i17;
                            i18 = this.zzp;
                            if (i18 == -1) {
                                i18 = this.zzm;
                            }
                            this.zzp = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.zzo;
                        if (i15 != iIntValue) {
                            f11 = -1.0f;
                        } else {
                            f11 = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = new byte[25];
                                ByteBuffer byteBufferOrder1111 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                                byteBufferOrder1111.put((byte) 0);
                                byteBufferOrder1111.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                                byteBufferOrder1111.putShort((short) (this.zzL + 0.5f));
                                byteBufferOrder1111.putShort((short) (this.zzM + 0.5f));
                                byteBufferOrder1111.putShort((short) this.zzB);
                                byteBufferOrder1111.putShort((short) this.zzC);
                            }
                            zzr zzrVar1111 = new zzr();
                            zzrVar1111.zzc(this.zzy);
                            zzrVar1111.zzb(this.zzA);
                            zzrVar1111.zzd(this.zzz);
                            zzrVar1111.zze(bArr);
                            zzrVar1111.zzf(this.zzn);
                            zzrVar1111.zza(this.zzn);
                            zztVarZzg = zzrVar1111.zzg();
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i19 = iIntValue;
                        } else {
                            i19 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f11);
                        zzakVar.zzV(i19);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        }
                        i14 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                    i14 = 1;
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i11);
                zzakVar.zzW(str3);
                zzakVar.zzO(i12);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i21111);
                zzakVar.zzL(listSingletonList);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac1111 = zzakVar.zzac();
                zzaea zzaeaVarZzw1111 = zzacxVar.zzw(this.zzc, i14);
                this.zzW = zzaeaVarZzw1111;
                zzaeaVarZzw1111.zzl(zzamVarZzac1111);
                return;
            default:
                throw zzcc.zza("Unrecognized codec identifier.", null);
        }
    }
}
