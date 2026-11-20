package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class Image implements Serializable {
    private int alreadyShow;

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
    private float imageViewHeight;
    private float imageViewWidth;
    private int imageViewX;
    private int imageViewY;

    @SerializedName("size")
    private Integer size;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Integer width;

    public Image() {
        this(null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, 0, 16383, null);
    }

    public Image(Integer num, Integer num2, String str, Integer num3, String str2, String str3, GifBean gifBean, String str4, String str5, float f11, float f12, int i11, int i12, int i13) {
        this.height = num;
        this.size = num2;
        this.url = str;
        this.width = num3;
        this.format = str2;
        this.thumbnail = str3;
        this.gifBean = gifBean;
        this.averageHueLight = str4;
        this.averageHueDark = str5;
        this.imageViewHeight = f11;
        this.imageViewWidth = f12;
        this.imageViewX = i11;
        this.imageViewY = i12;
        this.alreadyShow = i13;
    }

    public /* synthetic */ Image(Integer num, Integer num2, String str, Integer num3, String str2, String str3, GifBean gifBean, String str4, String str5, float f11, float f12, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? null : num, (i14 & 2) != 0 ? null : num2, (i14 & 4) != 0 ? null : str, (i14 & 8) != 0 ? null : num3, (i14 & 16) != 0 ? null : str2, (i14 & 32) != 0 ? null : str3, (i14 & 64) != 0 ? null : gifBean, (i14 & 128) != 0 ? null : str4, (i14 & 256) == 0 ? str5 : null, (i14 & 512) != 0 ? 0.0f : f11, (i14 & 1024) == 0 ? f12 : 0.0f, (i14 & 2048) != 0 ? 0 : i11, (i14 & 4096) != 0 ? 0 : i12, (i14 & 8192) == 0 ? i13 : 0);
    }

    public final int getAlreadyShow() {
        return this.alreadyShow;
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

    public final float getImageViewHeight() {
        return this.imageViewHeight;
    }

    public final float getImageViewWidth() {
        return this.imageViewWidth;
    }

    public final int getImageViewX() {
        return this.imageViewX;
    }

    public final int getImageViewY() {
        return this.imageViewY;
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

    public final void setAlreadyShow(int i11) {
        this.alreadyShow = i11;
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

    public final void setImageViewHeight(float f11) {
        this.imageViewHeight = f11;
    }

    public final void setImageViewWidth(float f11) {
        this.imageViewWidth = f11;
    }

    public final void setImageViewX(int i11) {
        this.imageViewX = i11;
    }

    public final void setImageViewY(int i11) {
        this.imageViewY = i11;
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
}
