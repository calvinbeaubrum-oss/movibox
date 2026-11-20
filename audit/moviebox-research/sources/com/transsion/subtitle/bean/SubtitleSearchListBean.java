package com.transsion.subtitle.bean;

import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import java.io.Serializable;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SubtitleSearchListBean implements Serializable {
    private transient boolean isRefresh;
    private List<SubtitleItem> items;
    private Pager pager;
    private transient int searchType;

    public SubtitleSearchListBean(Pager pager, List<SubtitleItem> list, int i11, boolean z11) {
        this.pager = pager;
        this.items = list;
        this.searchType = i11;
        this.isRefresh = z11;
    }

    public /* synthetic */ SubtitleSearchListBean(Pager pager, List list, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(pager, list, (i12 & 4) != 0 ? -1 : i11, (i12 & 8) != 0 ? false : z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitleSearchListBean copy$default(SubtitleSearchListBean subtitleSearchListBean, Pager pager, List list, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            pager = subtitleSearchListBean.pager;
        }
        if ((i12 & 2) != 0) {
            list = subtitleSearchListBean.items;
        }
        if ((i12 & 4) != 0) {
            i11 = subtitleSearchListBean.searchType;
        }
        if ((i12 & 8) != 0) {
            z11 = subtitleSearchListBean.isRefresh;
        }
        return subtitleSearchListBean.copy(pager, list, i11, z11);
    }

    public final Pager component1() {
        return this.pager;
    }

    public final List<SubtitleItem> component2() {
        return this.items;
    }

    public final int component3() {
        return this.searchType;
    }

    public final boolean component4() {
        return this.isRefresh;
    }

    public final SubtitleSearchListBean copy(Pager pager, List<SubtitleItem> list, int i11, boolean z11) {
        return new SubtitleSearchListBean(pager, list, i11, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubtitleSearchListBean)) {
            return false;
        }
        SubtitleSearchListBean subtitleSearchListBean = (SubtitleSearchListBean) obj;
        return Intrinsics.b(this.pager, subtitleSearchListBean.pager) && Intrinsics.b(this.items, subtitleSearchListBean.items) && this.searchType == subtitleSearchListBean.searchType && this.isRefresh == subtitleSearchListBean.isRefresh;
    }

    public final List<SubtitleItem> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        Pager pager = this.pager;
        int iHashCode = (pager == null ? 0 : pager.hashCode()) * 31;
        List<SubtitleItem> list = this.items;
        int iHashCode2 = (((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.searchType) * 31;
        boolean z11 = this.isRefresh;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode2 + r11;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void setItems(List<SubtitleItem> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setRefresh(boolean z11) {
        this.isRefresh = z11;
    }

    public final void setSearchType(int i11) {
        this.searchType = i11;
    }

    public String toString() {
        return "SubtitleSearchListBean(pager=" + this.pager + ", items=" + this.items + ", searchType=" + this.searchType + ", isRefresh=" + this.isRefresh + ")";
    }
}
