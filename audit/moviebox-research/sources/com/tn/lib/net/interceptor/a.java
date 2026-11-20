package com.tn.lib.net.interceptor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
public final class a implements HttpLoggingInterceptor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49398a = "HttpLogInterceptor";

    public final void a(String tag) {
        Intrinsics.g(tag, "tag");
        this.f49398a = tag;
    }

    @Override // com.tn.lib.net.interceptor.HttpLoggingInterceptor.a
    public void log(String message) {
        Intrinsics.g(message, "message");
        b.a.f(b.f78622a, this.f49398a, message, false, 4, null);
    }
}
