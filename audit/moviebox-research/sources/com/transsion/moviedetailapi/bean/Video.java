package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class Video implements Serializable {

    @SerializedName("bitrate")
    private Integer bitrate;

    @SerializedName("definition")
    private Integer definition;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("fps")
    private Integer fps;

    @SerializedName("height")
    private Integer height;

    @SerializedName("size")
    private Integer size;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Integer width;

    public Video(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str, Integer num7) {
        this.bitrate = num;
        this.definition = num2;
        this.duration = num3;
        this.fps = num4;
        this.height = num5;
        this.size = num6;
        this.url = str;
        this.width = num7;
    }

    public final Integer component1() {
        return this.bitrate;
    }

    public final Integer component2() {
        return this.definition;
    }

    public final Integer component3() {
        return this.duration;
    }

    public final Integer component4() {
        return this.fps;
    }

    public final Integer component5() {
        return this.height;
    }

    public final Integer component6() {
        return this.size;
    }

    public final String component7() {
        return this.url;
    }

    public final Integer component8() {
        return this.width;
    }

    public final Video copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str, Integer num7) {
        return new Video(num, num2, num3, num4, num5, num6, str, num7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        return Intrinsics.b(this.bitrate, video.bitrate) && Intrinsics.b(this.definition, video.definition) && Intrinsics.b(this.duration, video.duration) && Intrinsics.b(this.fps, video.fps) && Intrinsics.b(this.height, video.height) && Intrinsics.b(this.size, video.size) && Intrinsics.b(this.url, video.url) && Intrinsics.b(this.width, video.width);
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final Integer getDefinition() {
        return this.definition;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.bitrate;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.definition;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.duration;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.fps;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.height;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.size;
        int iHashCode6 = (iHashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str = this.url;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num7 = this.width;
        return iHashCode7 + (num7 != null ? num7.hashCode() : 0);
    }

    public final void setBitrate(Integer num) {
        this.bitrate = num;
    }

    public final void setDefinition(Integer num) {
        this.definition = num;
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final void setFps(Integer num) {
        this.fps = num;
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final void setSize(Integer num) {
        this.size = num;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public String toString() {
        return "Video(bitrate=" + this.bitrate + ", definition=" + this.definition + ", duration=" + this.duration + ", fps=" + this.fps + ", height=" + this.height + ", size=" + this.size + ", url=" + this.url + ", width=" + this.width + ")";
    }
}
