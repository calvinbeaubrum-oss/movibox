package com.transsion.moviedetail.preload;

import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import lu.b;
import lu.c;

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
@Metadata
public final class a implements c {
    @Override // lu.c
    public List<b<?>> a(String str, Bundle bundle) {
        List<b<?>> listEmptyList;
        String string;
        if (!Intrinsics.b(str, "/movie/detail")) {
            listEmptyList = null;
        } else if (bundle == null || (string = bundle.getString("id")) == null || (listEmptyList = g.h(new MovieDetailDataLoader(string), new MovieDetailDownloadListLoader(string), new MovieDetailResourcesSeasonLoader(string))) == null) {
            listEmptyList = Collections.emptyList();
            Intrinsics.f(listEmptyList, "emptyList()");
        }
        if (listEmptyList != null) {
            return listEmptyList;
        }
        Intrinsics.y("iPreloadList");
        return null;
    }

    @Override // lu.c
    public String getPath() {
        return "/movie/detail";
    }
}
