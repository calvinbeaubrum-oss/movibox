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
public final class Pager implements Serializable {

    @SerializedName("hasMore")
    private Boolean hasMore;

    @SerializedName("nextPage")
    private String nextPage;

    @SerializedName("page")
    private String page;

    @SerializedName("perPage")
    private Integer perPage;

    @SerializedName("totalCount")
    private Integer totalCount;

    public Pager(Boolean bool, String str, String str2, Integer num, Integer num2) {
        this.hasMore = bool;
        this.nextPage = str;
        this.page = str2;
        this.perPage = num;
        this.totalCount = num2;
    }

    public static /* synthetic */ Pager copy$default(Pager pager, Boolean bool, String str, String str2, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = pager.hasMore;
        }
        if ((i11 & 2) != 0) {
            str = pager.nextPage;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = pager.page;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            num = pager.perPage;
        }
        Integer num3 = num;
        if ((i11 & 16) != 0) {
            num2 = pager.totalCount;
        }
        return pager.copy(bool, str3, str4, num3, num2);
    }

    public final Boolean component1() {
        return this.hasMore;
    }

    public final String component2() {
        return this.nextPage;
    }

    public final String component3() {
        return this.page;
    }

    public final Integer component4() {
        return this.perPage;
    }

    public final Integer component5() {
        return this.totalCount;
    }

    public final Pager copy(Boolean bool, String str, String str2, Integer num, Integer num2) {
        return new Pager(bool, str, str2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pager)) {
            return false;
        }
        Pager pager = (Pager) obj;
        return Intrinsics.b(this.hasMore, pager.hasMore) && Intrinsics.b(this.nextPage, pager.nextPage) && Intrinsics.b(this.page, pager.page) && Intrinsics.b(this.perPage, pager.perPage) && Intrinsics.b(this.totalCount, pager.totalCount);
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final String getPage() {
        return this.page;
    }

    public final Integer getPerPage() {
        return this.perPage;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        Boolean bool = this.hasMore;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.nextPage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.page;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.perPage;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.totalCount;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setHasMore(Boolean bool) {
        this.hasMore = bool;
    }

    public final void setNextPage(String str) {
        this.nextPage = str;
    }

    public final void setPage(String str) {
        this.page = str;
    }

    public final void setPerPage(Integer num) {
        this.perPage = num;
    }

    public final void setTotalCount(Integer num) {
        this.totalCount = num;
    }

    public String toString() {
        return "Pager(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ", totalCount=" + this.totalCount + ")";
    }
}
