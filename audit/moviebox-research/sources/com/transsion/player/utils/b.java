package com.transsion.player.utils;

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
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f54866a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f54867b;

    public static /* synthetic */ void b(b bVar, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        bVar.a(str, str2, z11);
    }

    public static /* synthetic */ void d(b bVar, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        bVar.c(str, str2, z11);
    }

    public static /* synthetic */ void f(b bVar, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        bVar.e(str, str2, z11);
    }

    public static /* synthetic */ void i(b bVar, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        bVar.h(str, str2, z11);
    }

    public final void a(String tag, String msg, boolean z11) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        c cVar = f54867b;
        if (cVar != null) {
            cVar.b(tag, msg, z11);
        }
    }

    public final void c(String tag, String msg, boolean z11) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        c cVar = f54867b;
        if (cVar != null) {
            cVar.d(tag, msg, z11);
        }
    }

    public final void e(String tag, String msg, boolean z11) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        c cVar = f54867b;
        if (cVar != null) {
            cVar.a(tag, msg, z11);
        }
    }

    public final void g(c callback) {
        Intrinsics.g(callback, "callback");
        f54867b = callback;
    }

    public final void h(String tag, String msg, boolean z11) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(msg, "msg");
        c cVar = f54867b;
        if (cVar != null) {
            cVar.c(tag, msg, z11);
        }
    }
}
