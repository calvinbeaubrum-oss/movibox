package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class ShortTVRespData {
    private transient boolean isRefresh;
    private List<Subject> items;
    private Pager pager;

    public ShortTVRespData() {
        this(null, null, false, 7, null);
    }

    public ShortTVRespData(List<Subject> list, Pager pager, boolean z11) {
        this.items = list;
        this.pager = pager;
        this.isRefresh = z11;
    }

    public /* synthetic */ ShortTVRespData(List list, Pager pager, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : pager, (i11 & 4) != 0 ? false : z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortTVRespData copy$default(ShortTVRespData shortTVRespData, List list, Pager pager, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = shortTVRespData.items;
        }
        if ((i11 & 2) != 0) {
            pager = shortTVRespData.pager;
        }
        if ((i11 & 4) != 0) {
            z11 = shortTVRespData.isRefresh;
        }
        return shortTVRespData.copy(list, pager, z11);
    }

    public final List<Subject> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final boolean component3() {
        return this.isRefresh;
    }

    public final ShortTVRespData copy(List<Subject> list, Pager pager, boolean z11) {
        return new ShortTVRespData(list, pager, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortTVRespData)) {
            return false;
        }
        ShortTVRespData shortTVRespData = (ShortTVRespData) obj;
        return Intrinsics.b(this.items, shortTVRespData.items) && Intrinsics.b(this.pager, shortTVRespData.pager) && this.isRefresh == shortTVRespData.isRefresh;
    }

    public final List<Subject> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        List<Subject> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        int iHashCode2 = (iHashCode + (pager != null ? pager.hashCode() : 0)) * 31;
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

    public final void setItems(List<Subject> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public final void setRefresh(boolean z11) {
        this.isRefresh = z11;
    }

    public String toString() {
        return "ShortTVRespData(items=" + this.items + ", pager=" + this.pager + ", isRefresh=" + this.isRefresh + ")";
    }
}
