package com.transsion.sunflower;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f58393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f58394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f58395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Boolean> f58396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Boolean> f58397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FSNConfig f58398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f58399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f58400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Intent f58401i;

    public f(Context ctx) {
        Intrinsics.g(ctx, "ctx");
        this.f58393a = ctx;
        this.f58399g = R$mipmap.ic_launcher;
    }

    public final FSNManager a() {
        return FSNManager.f58381e.b(this);
    }

    public final FSNConfig b() {
        return this.f58398f;
    }

    public final Context c() {
        return this.f58393a;
    }

    public final int d() {
        return this.f58399g;
    }

    public final Function1<String, Unit> e() {
        return this.f58394b;
    }

    public final Function1<String, Unit> f() {
        return this.f58395c;
    }

    public final Function0<Boolean> g() {
        return this.f58397e;
    }

    public final Intent h() {
        return this.f58401i;
    }

    public final Function0<Boolean> i() {
        return this.f58396d;
    }

    public final boolean j() {
        return this.f58400h;
    }

    public final void k(Function0<Boolean> function0) {
        this.f58396d = function0;
    }

    public final void l(FSNConfig fSNConfig) {
        this.f58398f = fSNConfig;
    }

    public final void m(boolean z11) {
        this.f58400h = z11;
    }

    public final void n(int i11) {
        this.f58399g = i11;
    }

    public final void o(Function1<? super String, Unit> function1) {
        this.f58394b = function1;
    }

    public final void p(Function1<? super String, Unit> function1) {
        this.f58395c = function1;
    }

    public final void q(Function0<Boolean> function0) {
        this.f58397e = function0;
    }

    public final void r(Intent intent) {
        this.f58401i = intent;
    }
}
