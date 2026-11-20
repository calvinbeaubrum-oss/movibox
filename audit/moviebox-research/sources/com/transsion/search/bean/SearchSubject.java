package com.transsion.search.bean;

import com.transsion.moviedetailapi.bean.Subject;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SearchSubject extends Subject {
    private boolean showDivider;
    private VerticalRank verticalRank;
    private int viewType;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSubject(int i11, VerticalRank verticalRank, boolean z11) {
        super(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
        this.viewType = i11;
        this.verticalRank = verticalRank;
        this.showDivider = z11;
    }

    public static /* synthetic */ SearchSubject copy$default(SearchSubject searchSubject, int i11, VerticalRank verticalRank, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = searchSubject.viewType;
        }
        if ((i12 & 2) != 0) {
            verticalRank = searchSubject.verticalRank;
        }
        if ((i12 & 4) != 0) {
            z11 = searchSubject.showDivider;
        }
        return searchSubject.copy(i11, verticalRank, z11);
    }

    public final int component1() {
        return this.viewType;
    }

    public final VerticalRank component2() {
        return this.verticalRank;
    }

    public final boolean component3() {
        return this.showDivider;
    }

    public final SearchSubject copy(int i11, VerticalRank verticalRank, boolean z11) {
        return new SearchSubject(i11, verticalRank, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSubject)) {
            return false;
        }
        SearchSubject searchSubject = (SearchSubject) obj;
        return this.viewType == searchSubject.viewType && Intrinsics.b(this.verticalRank, searchSubject.verticalRank) && this.showDivider == searchSubject.showDivider;
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final VerticalRank getVerticalRank() {
        return this.verticalRank;
    }

    public final int getViewType() {
        return this.viewType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int i11 = this.viewType * 31;
        VerticalRank verticalRank = this.verticalRank;
        int iHashCode = (i11 + (verticalRank == null ? 0 : verticalRank.hashCode())) * 31;
        boolean z11 = this.showDivider;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final void setShowDivider(boolean z11) {
        this.showDivider = z11;
    }

    public final void setVerticalRank(VerticalRank verticalRank) {
        this.verticalRank = verticalRank;
    }

    public final void setViewType(int i11) {
        this.viewType = i11;
    }

    public String toString() {
        return "SearchSubject(viewType=" + this.viewType + ", verticalRank=" + this.verticalRank + ", showDivider=" + this.showDivider + ")";
    }
}
