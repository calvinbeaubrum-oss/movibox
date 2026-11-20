package com.transsion.transfer.wifi.connect.adapter;

import androidx.appcompat.app.AppCompatActivity;
import com.transsion.transfer.wifi.util.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;

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
public abstract class BaseWifiConnectAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0 f59144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.transfer.wifi.connect.b f59145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qy.a f59146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatActivity f59147d;

    public static /* synthetic */ void b(BaseWifiConnectAdapter baseWifiConnectAdapter, AppCompatActivity appCompatActivity, qy.a aVar, k0 k0Var, com.transsion.transfer.wifi.connect.b bVar, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
        if ((i11 & 1) != 0) {
            appCompatActivity = null;
        }
        baseWifiConnectAdapter.a(appCompatActivity, aVar, k0Var, bVar);
    }

    public final void a(AppCompatActivity appCompatActivity, qy.a aVar, k0 k0Var, com.transsion.transfer.wifi.connect.b bVar) {
        this.f59147d = appCompatActivity;
        this.f59146c = aVar;
        this.f59144a = k0Var;
        this.f59145b = bVar;
        if (k0Var != null) {
            j.d(k0Var, null, null, new BaseWifiConnectAdapter$connect$1(this, null), 3, null);
        }
    }

    public abstract void c();

    public abstract void d();

    public final String e() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final AppCompatActivity f() {
        return this.f59147d;
    }

    public final k0 g() {
        return this.f59144a;
    }

    public final com.transsion.transfer.wifi.connect.b h() {
        return this.f59145b;
    }

    public final qy.a i() {
        return this.f59146c;
    }

    public final void j(String msg) {
        Intrinsics.g(msg, "msg");
        g.b(g.f59252a, e() + " --> " + msg, false, 2, null);
    }

    public final void k() {
        c();
        this.f59144a = null;
        this.f59147d = null;
        this.f59145b = null;
        this.f59146c = null;
    }
}
