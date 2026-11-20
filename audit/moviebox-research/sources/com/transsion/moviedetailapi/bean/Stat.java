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
public final class Stat implements Serializable {

    @SerializedName("commentCount")
    private Long commentCount;

    @SerializedName("likeCount")
    private Long likeCount;

    @SerializedName("mediaViewCount")
    private Long mediaViewCount;

    @SerializedName("shareCount")
    private Long shareCount;

    @SerializedName("viewCount")
    private Long viewCount;

    public Stat(Long l11, Long l12, Long l13, Long l14, Long l15) {
        this.commentCount = l11;
        this.likeCount = l12;
        this.mediaViewCount = l13;
        this.shareCount = l14;
        this.viewCount = l15;
    }

    public static /* synthetic */ Stat copy$default(Stat stat, Long l11, Long l12, Long l13, Long l14, Long l15, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = stat.commentCount;
        }
        if ((i11 & 2) != 0) {
            l12 = stat.likeCount;
        }
        Long l16 = l12;
        if ((i11 & 4) != 0) {
            l13 = stat.mediaViewCount;
        }
        Long l17 = l13;
        if ((i11 & 8) != 0) {
            l14 = stat.shareCount;
        }
        Long l18 = l14;
        if ((i11 & 16) != 0) {
            l15 = stat.viewCount;
        }
        return stat.copy(l11, l16, l17, l18, l15);
    }

    public final Long component1() {
        return this.commentCount;
    }

    public final Long component2() {
        return this.likeCount;
    }

    public final Long component3() {
        return this.mediaViewCount;
    }

    public final Long component4() {
        return this.shareCount;
    }

    public final Long component5() {
        return this.viewCount;
    }

    public final Stat copy(Long l11, Long l12, Long l13, Long l14, Long l15) {
        return new Stat(l11, l12, l13, l14, l15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stat)) {
            return false;
        }
        Stat stat = (Stat) obj;
        return Intrinsics.b(this.commentCount, stat.commentCount) && Intrinsics.b(this.likeCount, stat.likeCount) && Intrinsics.b(this.mediaViewCount, stat.mediaViewCount) && Intrinsics.b(this.shareCount, stat.shareCount) && Intrinsics.b(this.viewCount, stat.viewCount);
    }

    public final Long getCommentCount() {
        return this.commentCount;
    }

    public final Long getLikeCount() {
        return this.likeCount;
    }

    public final Long getMediaViewCount() {
        return this.mediaViewCount;
    }

    public final Long getShareCount() {
        return this.shareCount;
    }

    public final Long getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        Long l11 = this.commentCount;
        int iHashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        Long l12 = this.likeCount;
        int iHashCode2 = (iHashCode + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.mediaViewCount;
        int iHashCode3 = (iHashCode2 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.shareCount;
        int iHashCode4 = (iHashCode3 + (l14 == null ? 0 : l14.hashCode())) * 31;
        Long l15 = this.viewCount;
        return iHashCode4 + (l15 != null ? l15.hashCode() : 0);
    }

    public final void setCommentCount(Long l11) {
        this.commentCount = l11;
    }

    public final void setLikeCount(Long l11) {
        this.likeCount = l11;
    }

    public final void setMediaViewCount(Long l11) {
        this.mediaViewCount = l11;
    }

    public final void setShareCount(Long l11) {
        this.shareCount = l11;
    }

    public final void setViewCount(Long l11) {
        this.viewCount = l11;
    }

    public String toString() {
        return "Stat(commentCount=" + this.commentCount + ", likeCount=" + this.likeCount + ", mediaViewCount=" + this.mediaViewCount + ", shareCount=" + this.shareCount + ", viewCount=" + this.viewCount + ")";
    }
}
