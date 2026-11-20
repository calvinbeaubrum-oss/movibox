package com.transsion.moviedetailapi.bean;

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
public final class PostSubjectBean implements Serializable {

    @SerializedName("group")
    private Group group;
    private transient boolean isRefresh;

    @SerializedName("items")
    private List<PostSubjectItem> items;

    @SerializedName("pager")
    private Pager pager;

    @SerializedName("subject")
    private Subject subject;

    public PostSubjectBean(List<PostSubjectItem> list, Pager pager, Subject subject, Group group) {
        this.items = list;
        this.pager = pager;
        this.subject = subject;
        this.group = group;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostSubjectBean copy$default(PostSubjectBean postSubjectBean, List list, Pager pager, Subject subject, Group group, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = postSubjectBean.items;
        }
        if ((i11 & 2) != 0) {
            pager = postSubjectBean.pager;
        }
        if ((i11 & 4) != 0) {
            subject = postSubjectBean.subject;
        }
        if ((i11 & 8) != 0) {
            group = postSubjectBean.group;
        }
        return postSubjectBean.copy(list, pager, subject, group);
    }

    public final List<PostSubjectItem> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final Subject component3() {
        return this.subject;
    }

    public final Group component4() {
        return this.group;
    }

    public final PostSubjectBean copy(List<PostSubjectItem> list, Pager pager, Subject subject, Group group) {
        return new PostSubjectBean(list, pager, subject, group);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostSubjectBean)) {
            return false;
        }
        PostSubjectBean postSubjectBean = (PostSubjectBean) obj;
        return Intrinsics.b(this.items, postSubjectBean.items) && Intrinsics.b(this.pager, postSubjectBean.pager) && Intrinsics.b(this.subject, postSubjectBean.subject) && Intrinsics.b(this.group, postSubjectBean.group);
    }

    public final Group getGroup() {
        return this.group;
    }

    public final List<PostSubjectItem> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public int hashCode() {
        List<PostSubjectItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        int iHashCode2 = (iHashCode + (pager == null ? 0 : pager.hashCode())) * 31;
        Subject subject = this.subject;
        int iHashCode3 = (iHashCode2 + (subject == null ? 0 : subject.hashCode())) * 31;
        Group group = this.group;
        return iHashCode3 + (group != null ? group.hashCode() : 0);
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void setGroup(Group group) {
        this.group = group;
    }

    public final void setItems(List<PostSubjectItem> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setRefresh(boolean z11) {
        this.isRefresh = z11;
    }

    public final void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String toString() {
        return "PostSubjectBean(items=" + this.items + ", pager=" + this.pager + ", subject=" + this.subject + ", group=" + this.group + ")";
    }
}
