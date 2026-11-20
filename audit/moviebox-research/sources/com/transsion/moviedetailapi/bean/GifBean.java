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
public final class GifBean implements Serializable {

    @SerializedName("firstFrameUrl")
    private String firstFrameUrl;

    @SerializedName("videoUrl")
    private String videoUrl;

    public GifBean(String str, String str2) {
        this.firstFrameUrl = str;
        this.videoUrl = str2;
    }

    public static /* synthetic */ GifBean copy$default(GifBean gifBean, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gifBean.firstFrameUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = gifBean.videoUrl;
        }
        return gifBean.copy(str, str2);
    }

    public final String component1() {
        return this.firstFrameUrl;
    }

    public final String component2() {
        return this.videoUrl;
    }

    public final GifBean copy(String str, String str2) {
        return new GifBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GifBean)) {
            return false;
        }
        GifBean gifBean = (GifBean) obj;
        return Intrinsics.b(this.firstFrameUrl, gifBean.firstFrameUrl) && Intrinsics.b(this.videoUrl, gifBean.videoUrl);
    }

    public final String getFirstFrameUrl() {
        return this.firstFrameUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String str = this.firstFrameUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setFirstFrameUrl(String str) {
        this.firstFrameUrl = str;
    }

    public final void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public String toString() {
        return "GifBean(firstFrameUrl=" + this.firstFrameUrl + ", videoUrl=" + this.videoUrl + ")";
    }
}
