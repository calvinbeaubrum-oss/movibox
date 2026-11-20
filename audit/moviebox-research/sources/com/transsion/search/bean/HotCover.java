package com.transsion.search.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.moviedetailapi.bean.GifBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class HotCover implements Parcelable {
    public static final Parcelable.Creator<HotCover> CREATOR = new a();

    @SerializedName("averageHueDark")
    private String averageHueDark;

    @SerializedName("averageHueLight")
    private String averageHueLight;

    @SerializedName("format")
    private String format;

    @SerializedName("gif")
    private GifBean gifBean;

    @SerializedName("height")
    private Integer height;

    @SerializedName("size")
    private Integer size;

    @SerializedName(alternate = {"blurHash"}, value = "thumbnail")
    private String thumbnail;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Integer width;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<HotCover> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotCover createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new HotCover(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), (GifBean) parcel.readSerializable(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotCover[] newArray(int i11) {
            return new HotCover[i11];
        }
    }

    public HotCover(Integer num, Integer num2, Integer num3, String str, String str2, String str3, GifBean gifBean, String str4, String str5) {
        this.width = num;
        this.height = num2;
        this.size = num3;
        this.url = str;
        this.format = str2;
        this.thumbnail = str3;
        this.gifBean = gifBean;
        this.averageHueLight = str4;
        this.averageHueDark = str5;
    }

    public /* synthetic */ HotCover(Integer num, Integer num2, Integer num3, String str, String str2, String str3, GifBean gifBean, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, num3, str, str2, str3, gifBean, (i11 & 128) != 0 ? null : str4, (i11 & 256) != 0 ? null : str5);
    }

    public final Integer component1() {
        return this.width;
    }

    public final Integer component2() {
        return this.height;
    }

    public final Integer component3() {
        return this.size;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.format;
    }

    public final String component6() {
        return this.thumbnail;
    }

    public final GifBean component7() {
        return this.gifBean;
    }

    public final String component8() {
        return this.averageHueLight;
    }

    public final String component9() {
        return this.averageHueDark;
    }

    public final HotCover copy(Integer num, Integer num2, Integer num3, String str, String str2, String str3, GifBean gifBean, String str4, String str5) {
        return new HotCover(num, num2, num3, str, str2, str3, gifBean, str4, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotCover)) {
            return false;
        }
        HotCover hotCover = (HotCover) obj;
        return Intrinsics.b(this.width, hotCover.width) && Intrinsics.b(this.height, hotCover.height) && Intrinsics.b(this.size, hotCover.size) && Intrinsics.b(this.url, hotCover.url) && Intrinsics.b(this.format, hotCover.format) && Intrinsics.b(this.thumbnail, hotCover.thumbnail) && Intrinsics.b(this.gifBean, hotCover.gifBean) && Intrinsics.b(this.averageHueLight, hotCover.averageHueLight) && Intrinsics.b(this.averageHueDark, hotCover.averageHueDark);
    }

    public final String getAverageHueDark() {
        return this.averageHueDark;
    }

    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    public final String getFormat() {
        return this.format;
    }

    public final GifBean getGifBean() {
        return this.gifBean;
    }

    public final Integer getHeight() {
        return this.height;
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
        Integer num = this.width;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.height;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.size;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.url;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.format;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnail;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        GifBean gifBean = this.gifBean;
        int iHashCode7 = (iHashCode6 + (gifBean == null ? 0 : gifBean.hashCode())) * 31;
        String str4 = this.averageHueLight;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.averageHueDark;
        return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAverageHueDark(String str) {
        this.averageHueDark = str;
    }

    public final void setAverageHueLight(String str) {
        this.averageHueLight = str;
    }

    public final void setFormat(String str) {
        this.format = str;
    }

    public final void setGifBean(GifBean gifBean) {
        this.gifBean = gifBean;
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final void setSize(Integer num) {
        this.size = num;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public String toString() {
        return "HotCover(width=" + this.width + ", height=" + this.height + ", size=" + this.size + ", url=" + this.url + ", format=" + this.format + ", thumbnail=" + this.thumbnail + ", gifBean=" + this.gifBean + ", averageHueLight=" + this.averageHueLight + ", averageHueDark=" + this.averageHueDark + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
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
        out.writeString(this.url);
        out.writeString(this.format);
        out.writeString(this.thumbnail);
        out.writeSerializable(this.gifBean);
        out.writeString(this.averageHueLight);
        out.writeString(this.averageHueDark);
    }
}
