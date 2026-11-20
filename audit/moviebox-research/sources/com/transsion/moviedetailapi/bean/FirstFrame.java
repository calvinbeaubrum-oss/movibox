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
public final class FirstFrame implements Serializable {

    @SerializedName("format")
    private String format;

    @SerializedName("height")
    private Integer height;

    @SerializedName("size")
    private Integer size;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Integer width;

    public FirstFrame(String str, Integer num, Integer num2, String str2, Integer num3) {
        this.format = str;
        this.height = num;
        this.size = num2;
        this.url = str2;
        this.width = num3;
    }

    public static /* synthetic */ FirstFrame copy$default(FirstFrame firstFrame, String str, Integer num, Integer num2, String str2, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = firstFrame.format;
        }
        if ((i11 & 2) != 0) {
            num = firstFrame.height;
        }
        Integer num4 = num;
        if ((i11 & 4) != 0) {
            num2 = firstFrame.size;
        }
        Integer num5 = num2;
        if ((i11 & 8) != 0) {
            str2 = firstFrame.url;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            num3 = firstFrame.width;
        }
        return firstFrame.copy(str, num4, num5, str3, num3);
    }

    public final String component1() {
        return this.format;
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

    public final Integer component5() {
        return this.width;
    }

    public final FirstFrame copy(String str, Integer num, Integer num2, String str2, Integer num3) {
        return new FirstFrame(str, num, num2, str2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirstFrame)) {
            return false;
        }
        FirstFrame firstFrame = (FirstFrame) obj;
        return Intrinsics.b(this.format, firstFrame.format) && Intrinsics.b(this.height, firstFrame.height) && Intrinsics.b(this.size, firstFrame.size) && Intrinsics.b(this.url, firstFrame.url) && Intrinsics.b(this.width, firstFrame.width);
    }

    public final String getFormat() {
        return this.format;
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
        String str = this.format;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.height;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.size;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.url;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.width;
        return iHashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setFormat(String str) {
        this.format = str;
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
        return "FirstFrame(format=" + this.format + ", height=" + this.height + ", size=" + this.size + ", url=" + this.url + ", width=" + this.width + ")";
    }
}
