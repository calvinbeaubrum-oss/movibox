package com.cloud.tmc.integration.utils;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f31025a = new a0();

    public final <T> T a(String str, Class<T> type) {
        Intrinsics.g(type, "type");
        return (T) com.cloud.tmc.miniutils.util.k.d(str, type);
    }

    public final String b(String json, String key) {
        Intrinsics.g(json, "json");
        Intrinsics.g(key, "key");
        String strA = com.cloud.tmc.miniutils.util.o.a(json, key);
        Intrinsics.f(strA, "getString(json, key)");
        return strA;
    }

    public final <T> String c(T t11) {
        String strJ = com.cloud.tmc.miniutils.util.k.j(t11);
        Intrinsics.f(strJ, "toJson(bean)");
        return strJ;
    }
}
