package com.transsion.member.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
public final class Pager implements Serializable {
    public static final int $stable = 8;

    @SerializedName("hasMore")
    private boolean hasMore;

    @SerializedName("nextPage")
    private String nextPage;

    @SerializedName("page")
    private String page;

    @SerializedName("perPage")
    private int perPage;

    public Pager(boolean z11, String str, String str2, int i11) {
        this.hasMore = z11;
        this.nextPage = str;
        this.page = str2;
        this.perPage = i11;
    }

    public /* synthetic */ Pager(boolean z11, String str, String str2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, str, (i12 & 4) != 0 ? null : str2, i11);
    }

    public static /* synthetic */ Pager copy$default(Pager pager, boolean z11, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z11 = pager.hasMore;
        }
        if ((i12 & 2) != 0) {
            str = pager.nextPage;
        }
        if ((i12 & 4) != 0) {
            str2 = pager.page;
        }
        if ((i12 & 8) != 0) {
            i11 = pager.perPage;
        }
        return pager.copy(z11, str, str2, i11);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final String component2() {
        return this.nextPage;
    }

    public final String component3() {
        return this.page;
    }

    public final int component4() {
        return this.perPage;
    }

    public final Pager copy(boolean z11, String str, String str2, int i11) {
        return new Pager(z11, str, str2, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pager)) {
            return false;
        }
        Pager pager = (Pager) obj;
        return this.hasMore == pager.hasMore && Intrinsics.b(this.nextPage, pager.nextPage) && Intrinsics.b(this.page, pager.page) && this.perPage == pager.perPage;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z11 = this.hasMore;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = r11 * 31;
        String str = this.nextPage;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.page;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.perPage;
    }

    public final void setHasMore(boolean z11) {
        this.hasMore = z11;
    }

    public final void setNextPage(String str) {
        this.nextPage = str;
    }

    public final void setPage(String str) {
        this.page = str;
    }

    public final void setPerPage(int i11) {
        this.perPage = i11;
    }

    public String toString() {
        return "Pager(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ")";
    }
}
