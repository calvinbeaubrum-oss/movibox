package com.transsion.ad.monopoly.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MbAdVideo implements Parcelable {
    public static final Parcelable.Creator<MbAdVideo> CREATOR = new a();
    private final Integer bitrate;
    private final String bucket;
    private final Integer definition;
    private final Long duration;
    private final Integer fps;
    private final Integer height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f50538id;
    private String path;
    private final Integer size;
    private final Integer type;
    private final String url;
    private final Integer width;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MbAdVideo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MbAdVideo createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MbAdVideo(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MbAdVideo[] newArray(int i11) {
            return new MbAdVideo[i11];
        }
    }

    public MbAdVideo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public MbAdVideo(String str, Integer num, Integer num2, String str2, Long l11, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str3, String str4) {
        this.f50538id = str;
        this.type = num;
        this.definition = num2;
        this.url = str2;
        this.duration = l11;
        this.width = num3;
        this.height = num4;
        this.size = num5;
        this.fps = num6;
        this.bitrate = num7;
        this.bucket = str3;
        this.path = str4;
    }

    public /* synthetic */ MbAdVideo(String str, Integer num, Integer num2, String str2, Long l11, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : num2, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : l11, (i11 & 32) != 0 ? null : num3, (i11 & 64) != 0 ? null : num4, (i11 & 128) != 0 ? null : num5, (i11 & 256) != 0 ? null : num6, (i11 & 512) != 0 ? null : num7, (i11 & 1024) != 0 ? null : str3, (i11 & 2048) == 0 ? str4 : null);
    }

    public final String component1() {
        return this.f50538id;
    }

    public final Integer component10() {
        return this.bitrate;
    }

    public final String component11() {
        return this.bucket;
    }

    public final String component12() {
        return this.path;
    }

    public final Integer component2() {
        return this.type;
    }

    public final Integer component3() {
        return this.definition;
    }

    public final String component4() {
        return this.url;
    }

    public final Long component5() {
        return this.duration;
    }

    public final Integer component6() {
        return this.width;
    }

    public final Integer component7() {
        return this.height;
    }

    public final Integer component8() {
        return this.size;
    }

    public final Integer component9() {
        return this.fps;
    }

    public final MbAdVideo copy(String str, Integer num, Integer num2, String str2, Long l11, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str3, String str4) {
        return new MbAdVideo(str, num, num2, str2, l11, num3, num4, num5, num6, num7, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbAdVideo)) {
            return false;
        }
        MbAdVideo mbAdVideo = (MbAdVideo) obj;
        return Intrinsics.b(this.f50538id, mbAdVideo.f50538id) && Intrinsics.b(this.type, mbAdVideo.type) && Intrinsics.b(this.definition, mbAdVideo.definition) && Intrinsics.b(this.url, mbAdVideo.url) && Intrinsics.b(this.duration, mbAdVideo.duration) && Intrinsics.b(this.width, mbAdVideo.width) && Intrinsics.b(this.height, mbAdVideo.height) && Intrinsics.b(this.size, mbAdVideo.size) && Intrinsics.b(this.fps, mbAdVideo.fps) && Intrinsics.b(this.bitrate, mbAdVideo.bitrate) && Intrinsics.b(this.bucket, mbAdVideo.bucket) && Intrinsics.b(this.path, mbAdVideo.path);
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Integer getDefinition() {
        return this.definition;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.f50538id;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.f50538id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.definition;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.duration;
        int iHashCode5 = (iHashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num3 = this.width;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.height;
        int iHashCode7 = (iHashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.size;
        int iHashCode8 = (iHashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.fps;
        int iHashCode9 = (iHashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.bitrate;
        int iHashCode10 = (iHashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str3 = this.bucket;
        int iHashCode11 = (iHashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.path;
        return iHashCode11 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public String toString() {
        return "MbAdVideo(id=" + this.f50538id + ", type=" + this.type + ", definition=" + this.definition + ", url=" + this.url + ", duration=" + this.duration + ", width=" + this.width + ", height=" + this.height + ", size=" + this.size + ", fps=" + this.fps + ", bitrate=" + this.bitrate + ", bucket=" + this.bucket + ", path=" + this.path + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f50538id);
        Integer num = this.type;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.definition;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.url);
        Long l11 = this.duration;
        if (l11 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l11.longValue());
        }
        Integer num3 = this.width;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.height;
        if (num4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num4.intValue());
        }
        Integer num5 = this.size;
        if (num5 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num5.intValue());
        }
        Integer num6 = this.fps;
        if (num6 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num6.intValue());
        }
        Integer num7 = this.bitrate;
        if (num7 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num7.intValue());
        }
        out.writeString(this.bucket);
        out.writeString(this.path);
    }
}
