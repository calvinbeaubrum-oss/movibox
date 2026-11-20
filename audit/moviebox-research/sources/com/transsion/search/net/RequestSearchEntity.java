package com.transsion.search.net;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class RequestSearchEntity implements Serializable {
    private String keyword;
    private int page;
    private int perPage;
    private int subjectType;

    public RequestSearchEntity(int i11, int i12, String keyword) {
        Intrinsics.g(keyword, "keyword");
        this.page = i11;
        this.perPage = i12;
        this.keyword = keyword;
    }

    public RequestSearchEntity(int i11, int i12, String keyword, int i13) {
        Intrinsics.g(keyword, "keyword");
        this.page = i11;
        this.perPage = i12;
        this.keyword = keyword;
        this.subjectType = i13;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final void setKeyword(String str) {
        Intrinsics.g(str, "<set-?>");
        this.keyword = str;
    }

    public final void setPage(int i11) {
        this.page = i11;
    }

    public final void setPerPage(int i11) {
        this.perPage = i11;
    }

    public final void setSubjectType(int i11) {
        this.subjectType = i11;
    }
}
