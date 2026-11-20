package com.transsion.postdetail.bean;

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
public final class CommentLikeBean implements Serializable {

    @SerializedName("isAffected")
    private Boolean isAffected;

    @SerializedName("likes")
    private Integer likes;

    public CommentLikeBean(Boolean bool, Integer num) {
        this.isAffected = bool;
        this.likes = num;
    }

    public static /* synthetic */ CommentLikeBean copy$default(CommentLikeBean commentLikeBean, Boolean bool, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = commentLikeBean.isAffected;
        }
        if ((i11 & 2) != 0) {
            num = commentLikeBean.likes;
        }
        return commentLikeBean.copy(bool, num);
    }

    public final Boolean component1() {
        return this.isAffected;
    }

    public final Integer component2() {
        return this.likes;
    }

    public final CommentLikeBean copy(Boolean bool, Integer num) {
        return new CommentLikeBean(bool, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentLikeBean)) {
            return false;
        }
        CommentLikeBean commentLikeBean = (CommentLikeBean) obj;
        return Intrinsics.b(this.isAffected, commentLikeBean.isAffected) && Intrinsics.b(this.likes, commentLikeBean.likes);
    }

    public final Integer getLikes() {
        return this.likes;
    }

    public int hashCode() {
        Boolean bool = this.isAffected;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.likes;
        return iHashCode + (num != null ? num.hashCode() : 0);
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

    public String toString() {
        return "CommentLikeBean(isAffected=" + this.isAffected + ", likes=" + this.likes + ")";
    }
}
