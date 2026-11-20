package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.mbridge.msdk.playercommon.exoplayer2.Format.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Format[] newArray(int i11) {
            return new Format[i11];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f46510id;
    public final List<byte[]> initializationData;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public Format(Parcel parcel) {
        this.f46510id = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.accessibilityChannel = parcel.readInt();
        this.subsampleOffsetUs = parcel.readLong();
        int i11 = parcel.readInt();
        this.initializationData = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public Format(String str, String str2, String str3, String str4, int i11, int i12, int i13, int i14, float f11, int i15, float f12, byte[] bArr, int i16, ColorInfo colorInfo, int i17, int i18, int i19, int i21, int i22, int i23, String str5, int i24, long j11, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.f46510id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i11;
        this.maxInputSize = i12;
        this.width = i13;
        this.height = i14;
        this.frameRate = f11;
        int i25 = i15;
        this.rotationDegrees = i25 == -1 ? 0 : i25;
        this.pixelWidthHeightRatio = f12 == -1.0f ? 1.0f : f12;
        this.projectionData = bArr;
        this.stereoMode = i16;
        this.colorInfo = colorInfo;
        this.channelCount = i17;
        this.sampleRate = i18;
        this.pcmEncoding = i19;
        int i26 = i21;
        this.encoderDelay = i26 == -1 ? 0 : i26;
        this.encoderPadding = i22 != -1 ? i22 : 0;
        this.selectionFlags = i23;
        this.language = str5;
        this.accessibilityChannel = i24;
        this.subsampleOffsetUs = j11;
        this.initializationData = list == null ? Collections.emptyList() : list;
        this.drmInitData = drmInitData;
        this.metadata = metadata;
    }

    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, int i11, int i12, int i13, List<byte[]> list, int i14, String str5) {
        return new Format(str, str2, str3, str4, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i12, i13, -1, -1, -1, i14, str5, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List<byte[]> list, DrmInitData drmInitData, int i18, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i11, i12, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i13, i14, i15, i16, i17, i18, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, List<byte[]> list, DrmInitData drmInitData, int i16, String str4) {
        return createAudioSampleFormat(str, str2, str3, i11, i12, i13, i14, i15, -1, -1, list, drmInitData, i16, str4, null);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, List<byte[]> list, DrmInitData drmInitData, int i15, String str4) {
        return createAudioSampleFormat(str, str2, str3, i11, i12, i13, i14, -1, list, drmInitData, i15, str4);
    }

    public static Format createContainerFormat(String str, String str2, String str3, String str4, int i11, int i12, String str5) {
        return new Format(str, str2, str3, str4, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i12, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format createImageSampleFormat(String str, String str2, String str3, int i11, int i12, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i12, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format createSampleFormat(String str, String str2, long j11) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j11, null, null, null);
    }

    public static Format createSampleFormat(String str, String str2, String str3, int i11, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i11, int i12, String str5) {
        return createTextContainerFormat(str, str2, str3, str4, i11, i12, str5, -1);
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i11, int i12, String str5, int i13) {
        return new Format(str, str2, str3, str4, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i12, str5, i13, Long.MAX_VALUE, null, null, null);
    }

    public static Format createTextSampleFormat(String str, String str2, int i11, String str3) {
        return createTextSampleFormat(str, str2, i11, str3, null);
    }

    public static Format createTextSampleFormat(String str, String str2, int i11, String str3, DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, null, -1, i11, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i11, int i12, String str4, int i13, DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, str3, i11, i12, str4, i13, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i11, int i12, String str4, int i13, DrmInitData drmInitData, long j11, List<byte[]> list) {
        return new Format(str, null, str2, str3, i11, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i12, str4, i13, j11, list, drmInitData, null);
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i11, int i12, String str4, DrmInitData drmInitData, long j11) {
        return createTextSampleFormat(str, str2, str3, i11, i12, str4, -1, drmInitData, j11, Collections.emptyList());
    }

    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, int i11, int i12, int i13, float f11, List<byte[]> list, int i14) {
        return new Format(str, str2, str3, str4, i11, -1, i12, i13, f11, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i14, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i11, i12, i13, i14, f11, list, i15, f12, null, -1, null, drmInitData);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, byte[] bArr, int i16, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i11, i12, i13, i14, f11, i15, f12, bArr, i16, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i11, i12, i13, i14, f11, list, -1, -1.0f, drmInitData);
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(format.f46510id);
        sb2.append(", mimeType=");
        sb2.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb2.append(", bitrate=");
            sb2.append(format.bitrate);
        }
        if (format.width != -1 && format.height != -1) {
            sb2.append(", res=");
            sb2.append(format.width);
            sb2.append("x");
            sb2.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb2.append(", fps=");
            sb2.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb2.append(", channels=");
            sb2.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb2.append(", sample_rate=");
            sb2.append(format.sampleRate);
        }
        if (format.language != null) {
            sb2.append(", language=");
            sb2.append(format.language);
        }
        return sb2.toString();
    }

    public final Format copyWithContainerInfo(String str, String str2, String str3, int i11, int i12, int i13, int i14, String str4) {
        return new Format(str, this.containerMimeType, str2, str3, i11, this.maxInputSize, i12, i13, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i14, str4, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public final Format copyWithDrmInitData(DrmInitData drmInitData) {
        return new Format(this.f46510id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata);
    }

    public final Format copyWithGaplessInfo(int i11, int i12) {
        return new Format(this.f46510id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, i11, i12, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public final Format copyWithManifestFormatInfo(Format format) {
        if (this == format) {
            return this;
        }
        String str = format.f46510id;
        String str2 = this.codecs;
        if (str2 == null) {
            str2 = format.codecs;
        }
        String str3 = str2;
        int i11 = this.bitrate;
        if (i11 == -1) {
            i11 = format.bitrate;
        }
        int i12 = i11;
        float f11 = this.frameRate;
        if (f11 == -1.0f) {
            f11 = format.frameRate;
        }
        float f12 = f11;
        int i13 = this.selectionFlags | format.selectionFlags;
        String str4 = this.language;
        if (str4 == null) {
            str4 = format.language;
        }
        return new Format(str, this.containerMimeType, this.sampleMimeType, str3, i12, this.maxInputSize, this.width, this.height, f12, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i13, str4, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData), this.metadata);
    }

    public final Format copyWithMaxInputSize(int i11) {
        return new Format(this.f46510id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i11, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public final Format copyWithMetadata(Metadata metadata) {
        return new Format(this.f46510id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, metadata);
    }

    public final Format copyWithRotationDegrees(int i11) {
        return new Format(this.f46510id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, i11, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public final Format copyWithSubsampleOffsetUs(long j11) {
        return new Format(this.f46510id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, j11, this.initializationData, this.drmInitData, this.metadata);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        return this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && Util.areEqual(this.f46510id, format.f46510id) && Util.areEqual(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.drmInitData, format.drmInitData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Arrays.equals(this.projectionData, format.projectionData) && initializationDataEquals(format);
    }

    public final int getPixelCount() {
        int i11;
        int i12 = this.width;
        if (i12 == -1 || (i11 = this.height) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            String str = this.f46510id;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.containerMimeType;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sampleMimeType;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.codecs;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31;
            String str5 = this.language;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.accessibilityChannel) * 31;
            DrmInitData drmInitData = this.drmInitData;
            int iHashCode6 = (iHashCode5 + (drmInitData == null ? 0 : drmInitData.hashCode())) * 31;
            Metadata metadata = this.metadata;
            this.hashCode = iHashCode6 + (metadata != null ? metadata.hashCode() : 0);
        }
        return this.hashCode;
    }

    public final boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.initializationData.size(); i11++) {
            if (!Arrays.equals(this.initializationData.get(i11), format.initializationData.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return "Format(" + this.f46510id + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f46510id);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeString(this.codecs);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.maxInputSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        Util.writeBoolean(parcel, this.projectionData != null);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i11);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.selectionFlags);
        parcel.writeString(this.language);
        parcel.writeInt(this.accessibilityChannel);
        parcel.writeLong(this.subsampleOffsetUs);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            parcel.writeByteArray(this.initializationData.get(i12));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeParcelable(this.metadata, 0);
    }
}
