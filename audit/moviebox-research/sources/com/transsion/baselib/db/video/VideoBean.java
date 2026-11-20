package com.transsion.baselib.db.video;

import androidx.annotation.Keep;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class VideoBean {
    private Long playProgress;
    private final String postId;
    private String url;

    public VideoBean(String postId, Long l11, String str) {
        Intrinsics.g(postId, "postId");
        this.postId = postId;
        this.playProgress = l11;
        this.url = str;
    }

    public /* synthetic */ VideoBean(String str, Long l11, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : l11, (i11 & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ VideoBean copy$default(VideoBean videoBean, String str, Long l11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = videoBean.postId;
        }
        if ((i11 & 2) != 0) {
            l11 = videoBean.playProgress;
        }
        if ((i11 & 4) != 0) {
            str2 = videoBean.url;
        }
        return videoBean.copy(str, l11, str2);
    }

    public final String component1() {
        return this.postId;
    }

    public final Long component2() {
        return this.playProgress;
    }

    public final String component3() {
        return this.url;
    }

    public final VideoBean copy(String postId, Long l11, String str) {
        Intrinsics.g(postId, "postId");
        return new VideoBean(postId, l11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoBean)) {
            return false;
        }
        VideoBean videoBean = (VideoBean) obj;
        return Intrinsics.b(this.postId, videoBean.postId) && Intrinsics.b(this.playProgress, videoBean.playProgress) && Intrinsics.b(this.url, videoBean.url);
    }

    public final Long getPlayProgress() {
        return this.playProgress;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = this.postId.hashCode() * 31;
        Long l11 = this.playProgress;
        int iHashCode2 = (iHashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.url;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setPlayProgress(Long l11) {
        this.playProgress = l11;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "VideoBean(postId=" + this.postId + ", playProgress=" + this.playProgress + ", url=" + this.url + ")";
    }
}
