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
public final class PagerBody implements Serializable {

    @SerializedName("page")
    private String page;

    @SerializedName("perPage")
    private Integer perPage;

    public PagerBody(String str, Integer num) {
        this.page = str;
        this.perPage = num;
    }

    public static /* synthetic */ PagerBody copy$default(PagerBody pagerBody, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pagerBody.page;
        }
        if ((i11 & 2) != 0) {
            num = pagerBody.perPage;
        }
        return pagerBody.copy(str, num);
    }

    public final String component1() {
        return this.page;
    }

    public final Integer component2() {
        return this.perPage;
    }

    public final PagerBody copy(String str, Integer num) {
        return new PagerBody(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagerBody)) {
            return false;
        }
        PagerBody pagerBody = (PagerBody) obj;
        return Intrinsics.b(this.page, pagerBody.page) && Intrinsics.b(this.perPage, pagerBody.perPage);
    }

    public final String getPage() {
        return this.page;
    }

    public final Integer getPerPage() {
        return this.perPage;
    }

    public int hashCode() {
        String str = this.page;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.perPage;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setPage(String str) {
        this.page = str;
    }

    public final void setPerPage(Integer num) {
        this.perPage = num;
    }

    public String toString() {
        return "PagerBody(page=" + this.page + ", perPage=" + this.perPage + ")";
    }
}
