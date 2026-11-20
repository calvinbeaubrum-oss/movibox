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
public final class MbAdImage implements Parcelable {
    public static final Parcelable.Creator<MbAdImage> CREATOR = new a();
    private String averageHueDark;
    private String averageHueLight;
    private final String blurHash;
    private final String bucket;
    private final String format;
    private final Integer height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f50537id;
    private String path;
    private final Integer size;
    private final String thumbnail;
    private String url;
    private final Integer width;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<MbAdImage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MbAdImage createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new MbAdImage(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MbAdImage[] newArray(int i11) {
            return new MbAdImage[i11];
        }
    }

    public MbAdImage() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public MbAdImage(String str, String str2, Integer num, Integer num2, Integer num3, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f50537id = str;
        this.url = str2;
        this.width = num;
        this.height = num2;
        this.size = num3;
        this.bucket = str3;
        this.format = str4;
        this.thumbnail = str5;
        this.blurHash = str6;
        this.path = str7;
        this.averageHueLight = str8;
        this.averageHueDark = str9;
    }

    public /* synthetic */ MbAdImage(String str, String str2, Integer num, Integer num2, Integer num3, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : num, (i11 & 8) != 0 ? null : num2, (i11 & 16) != 0 ? null : num3, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4, (i11 & 128) != 0 ? null : str5, (i11 & 256) != 0 ? null : str6, (i11 & 512) != 0 ? null : str7, (i11 & 1024) != 0 ? null : str8, (i11 & 2048) == 0 ? str9 : null);
    }

    public final String component1() {
        return this.f50537id;
    }

    public final String component10() {
        return this.path;
    }

    public final String component11() {
        return this.averageHueLight;
    }

    public final String component12() {
        return this.averageHueDark;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final Integer component5() {
        return this.size;
    }

    public final String component6() {
        return this.bucket;
    }

    public final String component7() {
        return this.format;
    }

    public final String component8() {
        return this.thumbnail;
    }

    public final String component9() {
        return this.blurHash;
    }

    public final MbAdImage copy(String str, String str2, Integer num, Integer num2, Integer num3, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new MbAdImage(str, str2, num, num2, num3, str3, str4, str5, str6, str7, str8, str9);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbAdImage)) {
            return false;
        }
        MbAdImage mbAdImage = (MbAdImage) obj;
        return Intrinsics.b(this.f50537id, mbAdImage.f50537id) && Intrinsics.b(this.url, mbAdImage.url) && Intrinsics.b(this.width, mbAdImage.width) && Intrinsics.b(this.height, mbAdImage.height) && Intrinsics.b(this.size, mbAdImage.size) && Intrinsics.b(this.bucket, mbAdImage.bucket) && Intrinsics.b(this.format, mbAdImage.format) && Intrinsics.b(this.thumbnail, mbAdImage.thumbnail) && Intrinsics.b(this.blurHash, mbAdImage.blurHash) && Intrinsics.b(this.path, mbAdImage.path) && Intrinsics.b(this.averageHueLight, mbAdImage.averageHueLight) && Intrinsics.b(this.averageHueDark, mbAdImage.averageHueDark);
    }

    public final String getAverageHueDark() {
        return this.averageHueDark;
    }

    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    public final String getBlurHash() {
        return this.blurHash;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getFormat() {
        return this.format;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.f50537id;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.f50537id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.width;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.size;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.bucket;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.format;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.thumbnail;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.blurHash;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.path;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.averageHueLight;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.averageHueDark;
        return iHashCode11 + (str9 != null ? str9.hashCode() : 0);
    }

    public final void setAverageHueDark(String str) {
        this.averageHueDark = str;
    }

    public final void setAverageHueLight(String str) {
        this.averageHueLight = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "MbAdImage(id=" + this.f50537id + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", size=" + this.size + ", bucket=" + this.bucket + ", format=" + this.format + ", thumbnail=" + this.thumbnail + ", blurHash=" + this.blurHash + ", path=" + this.path + ", averageHueLight=" + this.averageHueLight + ", averageHueDark=" + this.averageHueDark + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.f50537id);
        out.writeString(this.url);
        Integer num = this.width;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.height;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.size;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        out.writeString(this.bucket);
        out.writeString(this.format);
        out.writeString(this.thumbnail);
        out.writeString(this.blurHash);
        out.writeString(this.path);
        out.writeString(this.averageHueLight);
        out.writeString(this.averageHueDark);
    }
}
