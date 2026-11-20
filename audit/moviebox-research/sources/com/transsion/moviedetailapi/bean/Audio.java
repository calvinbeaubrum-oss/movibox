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
public final class Audio implements Serializable {

    @SerializedName("bitrate")
    private Integer bitrate;

    @SerializedName("duration")
    private Long duration;

    @SerializedName("size")
    private Integer size;

    @SerializedName("url")
    private String url;

    public Audio(Integer num, Long l11, Integer num2, String str) {
        this.bitrate = num;
        this.duration = l11;
        this.size = num2;
        this.url = str;
    }

    public static /* synthetic */ Audio copy$default(Audio audio, Integer num, Long l11, Integer num2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = audio.bitrate;
        }
        if ((i11 & 2) != 0) {
            l11 = audio.duration;
        }
        if ((i11 & 4) != 0) {
            num2 = audio.size;
        }
        if ((i11 & 8) != 0) {
            str = audio.url;
        }
        return audio.copy(num, l11, num2, str);
    }

    public final Integer component1() {
        return this.bitrate;
    }

    public final Long component2() {
        return this.duration;
    }

    public final Integer component3() {
        return this.size;
    }

    public final String component4() {
        return this.url;
    }

    public final Audio copy(Integer num, Long l11, Integer num2, String str) {
        return new Audio(num, l11, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Audio)) {
            return false;
        }
        Audio audio = (Audio) obj;
        return Intrinsics.b(this.bitrate, audio.bitrate) && Intrinsics.b(this.duration, audio.duration) && Intrinsics.b(this.size, audio.size) && Intrinsics.b(this.url, audio.url);
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Integer num = this.bitrate;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l11 = this.duration;
        int iHashCode2 = (iHashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num2 = this.size;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.url;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final void setBitrate(Integer num) {
        this.bitrate = num;
    }

    public final void setDuration(Long l11) {
        this.duration = l11;
    }

    public final void setSize(Integer num) {
        this.size = num;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Audio(bitrate=" + this.bitrate + ", duration=" + this.duration + ", size=" + this.size + ", url=" + this.url + ")";
    }
}
