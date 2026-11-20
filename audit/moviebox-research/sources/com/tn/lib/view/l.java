package com.tn.lib.view;

import kotlin.Metadata;
import kotlin.TuplesKt;
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
@Metadata
public final class l {
    public static final void a(String pageName) {
        Intrinsics.g(pageName, "pageName");
        com.transsion.baselib.report.m.f51277a.t(pageName, "browse", kotlin.collections.r.f(TuplesKt.a("module_name", "no_network")));
    }

    public static final void b(String pageName) {
        Intrinsics.g(pageName, "pageName");
        com.transsion.baselib.report.m.f51277a.m(pageName, "click", kotlin.collections.r.f(TuplesKt.a("module_name", "retry")));
    }

    public static final void c(String pageName) {
        Intrinsics.g(pageName, "pageName");
        com.transsion.baselib.report.m.f51277a.m(pageName, "click", kotlin.collections.r.f(TuplesKt.a("module_name", "setting")));
    }
}
