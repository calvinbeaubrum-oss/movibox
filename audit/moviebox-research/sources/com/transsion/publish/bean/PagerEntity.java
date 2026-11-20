package com.transsion.publish.bean;

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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class PagerEntity implements Serializable {
    private int count;
    private boolean hasMore;
    private int totalCount;
    private String page = "";
    private String nextPage = "";

    public final int getCount() {
        return this.count;
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

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public final void setHasMore(boolean z11) {
        this.hasMore = z11;
    }

    public final void setNextPage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.nextPage = str;
    }

    public final void setPage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.page = str;
    }

    public final void setTotalCount(int i11) {
        this.totalCount = i11;
    }
}
