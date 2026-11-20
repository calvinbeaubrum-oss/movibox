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
public final class LikeBean implements Serializable {

    @SerializedName("isAffected")
    private Boolean isAffected;

    @SerializedName("likes")
    private Integer likes;
    private String postId;

    public LikeBean(Boolean bool, Integer num, String str) {
        this.isAffected = bool;
        this.likes = num;
        this.postId = str;
    }

    public static /* synthetic */ LikeBean copy$default(LikeBean likeBean, Boolean bool, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = likeBean.isAffected;
        }
        if ((i11 & 2) != 0) {
            num = likeBean.likes;
        }
        if ((i11 & 4) != 0) {
            str = likeBean.postId;
        }
        return likeBean.copy(bool, num, str);
    }

    public final Boolean component1() {
        return this.isAffected;
    }

    public final Integer component2() {
        return this.likes;
    }

    public final String component3() {
        return this.postId;
    }

    public final LikeBean copy(Boolean bool, Integer num, String str) {
        return new LikeBean(bool, num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikeBean)) {
            return false;
        }
        LikeBean likeBean = (LikeBean) obj;
        return Intrinsics.b(this.isAffected, likeBean.isAffected) && Intrinsics.b(this.likes, likeBean.likes) && Intrinsics.b(this.postId, likeBean.postId);
    }

    public final Integer getLikes() {
        return this.likes;
    }

    public final String getPostId() {
        return this.postId;
    }

    public int hashCode() {
        Boolean bool = this.isAffected;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.likes;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.postId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final Boolean isAffected() {
        return this.isAffected;
    }

    public final void setAffected(Boolean bool) {
        this.isAffected = bool;
    }

    public final void setLikes(Integer num) {
        this.likes = num;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public String toString() {
        return "LikeBean(isAffected=" + this.isAffected + ", likes=" + this.likes + ", postId=" + this.postId + ")";
    }
}
