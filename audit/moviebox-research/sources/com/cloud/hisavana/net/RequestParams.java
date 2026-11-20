package com.cloud.hisavana.net;

import java.util.concurrent.ConcurrentHashMap;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RequestParams {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f28949d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f28951f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f28946a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f28947b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f28948c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f28950e = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f28952g = 1;

    public final int a() {
        return this.f28952g;
    }

    public final ConcurrentHashMap<String, String> b() {
        return this.f28947b;
    }

    public final ConcurrentHashMap<String, String> c() {
        return this.f28948c;
    }

    public final Object d() {
        return this.f28946a;
    }

    public final boolean e() {
        return this.f28951f;
    }

    public final boolean f() {
        return this.f28949d;
    }

    public final boolean g() {
        return this.f28950e;
    }

    public final void h(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f28947b.put(str, str2);
    }

    public final void i(int i11) {
        this.f28952g = i11;
    }

    public final void j(boolean z11) {
        this.f28951f = z11;
    }

    public final void k(boolean z11) {
        this.f28949d = z11;
    }

    public final void l(Object body) {
        Intrinsics.g(body, "body");
        this.f28946a = body;
    }

    public final void m(boolean z11) {
        this.f28950e = z11;
    }
}
