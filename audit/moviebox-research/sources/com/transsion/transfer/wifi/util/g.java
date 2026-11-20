package com.transsion.transfer.wifi.util;

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
@Metadata
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f59252a = new g();

    public static /* synthetic */ void b(g gVar, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        gVar.a(str, z11);
    }

    public static /* synthetic */ void d(g gVar, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        gVar.c(str, z11);
    }

    public static /* synthetic */ void f(g gVar, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        gVar.e(str, z11);
    }

    public static /* synthetic */ void h(g gVar, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        gVar.g(str, z11);
    }

    public final void a(String msg, boolean z11) {
        Intrinsics.g(msg, "msg");
        uo.b.f78622a.c("mb_wifi", msg, z11);
    }

    public final void c(String msg, boolean z11) {
        Intrinsics.g(msg, "msg");
        uo.b.f78622a.h("mb_wifi", msg, z11);
    }

    public final void e(String msg, boolean z11) {
        Intrinsics.g(msg, "msg");
        uo.b.f78622a.t("mb_wifi_r", msg, z11);
    }

    public final void g(String msg, boolean z11) {
        Intrinsics.g(msg, "msg");
        uo.b.f78622a.t("mb_wifi", msg, z11);
    }
}
