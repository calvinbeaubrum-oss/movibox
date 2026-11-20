package com.transsion.postdetail.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
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
public final class CommentListBean implements Serializable {

    @SerializedName("commentList")
    private List<CommentBean> commentList;

    @SerializedName("pager")
    private Pager pager;

    public CommentListBean(List<CommentBean> list, Pager pager) {
        this.commentList = list;
        this.pager = pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentListBean copy$default(CommentListBean commentListBean, List list, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = commentListBean.commentList;
        }
        if ((i11 & 2) != 0) {
            pager = commentListBean.pager;
        }
        return commentListBean.copy(list, pager);
    }

    public final List<CommentBean> component1() {
        return this.commentList;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final CommentListBean copy(List<CommentBean> list, Pager pager) {
        return new CommentListBean(list, pager);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentListBean)) {
            return false;
        }
        CommentListBean commentListBean = (CommentListBean) obj;
        return Intrinsics.b(this.commentList, commentListBean.commentList) && Intrinsics.b(this.pager, commentListBean.pager);
    }

    public final List<CommentBean> getCommentList() {
        return this.commentList;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        List<CommentBean> list = this.commentList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        return iHashCode + (pager != null ? pager.hashCode() : 0);
    }

    public final void setCommentList(List<CommentBean> list) {
        this.commentList = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public String toString() {
        return "CommentListBean(commentList=" + this.commentList + ", pager=" + this.pager + ")";
    }
}
