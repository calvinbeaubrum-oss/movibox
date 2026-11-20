package com.transsion.commercialization.aha;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class AhaGameQuery implements Serializable {

    @SerializedName("pageNum")
    private int pageNum;

    @SerializedName("pageSize")
    private int pageSize;

    /* JADX WARN: Illegal instructions before constructor call */
    public AhaGameQuery() {
        int i11 = 0;
        this(i11, i11, 3, null);
    }

    public AhaGameQuery(int i11, int i12) {
        this.pageNum = i11;
        this.pageSize = i12;
    }

    public /* synthetic */ AhaGameQuery(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 10 : i12);
    }

    public static /* synthetic */ AhaGameQuery copy$default(AhaGameQuery ahaGameQuery, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = ahaGameQuery.pageNum;
        }
        if ((i13 & 2) != 0) {
            i12 = ahaGameQuery.pageSize;
        }
        return ahaGameQuery.copy(i11, i12);
    }

    public final int component1() {
        return this.pageNum;
    }

    public final int component2() {
        return this.pageSize;
    }

    public final AhaGameQuery copy(int i11, int i12) {
        return new AhaGameQuery(i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AhaGameQuery)) {
            return false;
        }
        AhaGameQuery ahaGameQuery = (AhaGameQuery) obj;
        return this.pageNum == ahaGameQuery.pageNum && this.pageSize == ahaGameQuery.pageSize;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public int hashCode() {
        return (this.pageNum * 31) + this.pageSize;
    }

    public final void setPageNum(int i11) {
        this.pageNum = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public String toString() {
        return "AhaGameQuery(pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ")";
    }
}
