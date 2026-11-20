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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PreVideoAddress implements Serializable {

    @SerializedName("bitrate")
    private Integer bitrate;

    @SerializedName("definition")
    private String definition;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("fps")
    private Integer fps;

    @SerializedName("height")
    private Integer height;

    @SerializedName("size")
    private Long size;

    @SerializedName("type")
    private Integer type;

    @SerializedName("url")
    private String url;

    @SerializedName("videoId")
    private String videoId;

    @SerializedName("width")
    private Integer width;

    public PreVideoAddress(Integer num, String str, Integer num2, Integer num3, Integer num4, Long l11, Integer num5, String str2, String str3, Integer num6) {
        this.bitrate = num;
        this.definition = str;
        this.duration = num2;
        this.fps = num3;
        this.height = num4;
        this.size = l11;
        this.type = num5;
        this.url = str2;
        this.videoId = str3;
        this.width = num6;
    }

    public final Integer component1() {
        return this.bitrate;
    }

    public final Integer component10() {
        return this.width;
    }

    public final String component2() {
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

    public final Long component6() {
        return this.size;
    }

    public final Integer component7() {
        return this.type;
    }

    public final String component8() {
        return this.url;
    }

    public final String component9() {
        return this.videoId;
    }

    public final PreVideoAddress copy(Integer num, String str, Integer num2, Integer num3, Integer num4, Long l11, Integer num5, String str2, String str3, Integer num6) {
        return new PreVideoAddress(num, str, num2, num3, num4, l11, num5, str2, str3, num6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreVideoAddress)) {
            return false;
        }
        PreVideoAddress preVideoAddress = (PreVideoAddress) obj;
        return Intrinsics.b(this.bitrate, preVideoAddress.bitrate) && Intrinsics.b(this.definition, preVideoAddress.definition) && Intrinsics.b(this.duration, preVideoAddress.duration) && Intrinsics.b(this.fps, preVideoAddress.fps) && Intrinsics.b(this.height, preVideoAddress.height) && Intrinsics.b(this.size, preVideoAddress.size) && Intrinsics.b(this.type, preVideoAddress.type) && Intrinsics.b(this.url, preVideoAddress.url) && Intrinsics.b(this.videoId, preVideoAddress.videoId) && Intrinsics.b(this.width, preVideoAddress.width);
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final String getDefinition() {
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

    public final Long getSize() {
        return this.size;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.bitrate;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.definition;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.duration;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.fps;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.height;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l11 = this.size;
        int iHashCode6 = (iHashCode5 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num5 = this.type;
        int iHashCode7 = (iHashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoId;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num6 = this.width;
        return iHashCode9 + (num6 != null ? num6.hashCode() : 0);
    }

    public final void setBitrate(Integer num) {
        this.bitrate = num;
    }

    public final void setDefinition(String str) {
        this.definition = str;
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

    public final void setSize(Long l11) {
        this.size = l11;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public String toString() {
        return "PreVideoAddress(bitrate=" + this.bitrate + ", definition=" + this.definition + ", duration=" + this.duration + ", fps=" + this.fps + ", height=" + this.height + ", size=" + this.size + ", type=" + this.type + ", url=" + this.url + ", videoId=" + this.videoId + ", width=" + this.width + ")";
    }
}
