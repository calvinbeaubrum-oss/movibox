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
public final class CommentLikeBody implements Serializable {

    @SerializedName("commentId")
    private String commentId;

    @SerializedName("reqType")
    private Integer reqType;

    public CommentLikeBody(String str, Integer num) {
        this.commentId = str;
        this.reqType = num;
    }

    public static /* synthetic */ CommentLikeBody copy$default(CommentLikeBody commentLikeBody, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = commentLikeBody.commentId;
        }
        if ((i11 & 2) != 0) {
            num = commentLikeBody.reqType;
        }
        return commentLikeBody.copy(str, num);
    }

    public final String component1() {
        return this.commentId;
    }

    public final Integer component2() {
        return this.reqType;
    }

    public final CommentLikeBody copy(String str, Integer num) {
        return new CommentLikeBody(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentLikeBody)) {
            return false;
        }
        CommentLikeBody commentLikeBody = (CommentLikeBody) obj;
        return Intrinsics.b(this.commentId, commentLikeBody.commentId) && Intrinsics.b(this.reqType, commentLikeBody.reqType);
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final Integer getReqType() {
        return this.reqType;
    }

    public int hashCode() {
        String str = this.commentId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.reqType;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setCommentId(String str) {
        this.commentId = str;
    }

    public final void setReqType(Integer num) {
        this.reqType = num;
    }

    public String toString() {
        return "CommentLikeBody(commentId=" + this.commentId + ", reqType=" + this.reqType + ")";
    }
}
