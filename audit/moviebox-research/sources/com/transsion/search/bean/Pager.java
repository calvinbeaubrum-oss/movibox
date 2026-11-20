package com.transsion.search.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

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
@Keep
@Metadata
public final class Pager implements Serializable {

    @SerializedName("hasMore")
    private final boolean hasMore;

    @SerializedName("nextPage")
    private final int nextPage;

    @SerializedName("page")
    private final int page;

    @SerializedName("perPage")
    private final int perPage;

    @SerializedName("totalCount")
    private final int totalCount;

    public Pager(boolean z11, int i11, int i12, int i13, int i14) {
        this.hasMore = z11;
        this.nextPage = i11;
        this.page = i12;
        this.perPage = i13;
        this.totalCount = i14;
    }

    public static /* synthetic */ Pager copy$default(Pager pager, boolean z11, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            z11 = pager.hasMore;
        }
        if ((i15 & 2) != 0) {
            i11 = pager.nextPage;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = pager.page;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = pager.perPage;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = pager.totalCount;
        }
        return pager.copy(z11, i16, i17, i18, i14);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final int component2() {
        return this.nextPage;
    }

    public final int component3() {
        return this.page;
    }

    public final int component4() {
        return this.perPage;
    }

    public final int component5() {
        return this.totalCount;
    }

    public final Pager copy(boolean z11, int i11, int i12, int i13, int i14) {
        return new Pager(z11, i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pager)) {
            return false;
        }
        Pager pager = (Pager) obj;
        return this.hasMore == pager.hasMore && this.nextPage == pager.nextPage && this.page == pager.page && this.perPage == pager.perPage && this.totalCount == pager.totalCount;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final int getNextPage() {
        return this.nextPage;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z11 = this.hasMore;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return (((((((r11 * 31) + this.nextPage) * 31) + this.page) * 31) + this.perPage) * 31) + this.totalCount;
    }

    public String toString() {
        return "Pager(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ", totalCount=" + this.totalCount + ")";
    }
}
