package com.transsion.fission;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.fissionapi.IFissionProvider;
import defpackage.PalmPayMmkv;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@Route(path = "/fission/provider")
@Metadata
public final class FissionProvider implements IFissionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f51911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51912b = LazyKt__LazyJVMKt.b(new Function0<dt.b>() { // from class: com.transsion.fission.FissionProvider$mPalmPayApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final dt.b invoke() {
            return (dt.b) NetServiceGenerator.f49399d.a().i(dt.b.class);
        }
    });

    public final dt.b A1() {
        return (dt.b) this.f51912b.getValue();
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void C0(int i11) {
        if (PalmPayMmkv.f350a.a().getBoolean("kv_task_is_exists", false)) {
            j.d(l0.a(w0.b()), null, null, new FissionProvider$finishPalmPayTask$1(i11, this, null), 3, null);
        }
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public boolean G0() {
        PalmPayMmkv palmPayMmkv = PalmPayMmkv.f350a;
        return palmPayMmkv.a().getBoolean("kv_task_is_exists", false) && !palmPayMmkv.a().getBoolean("kv_task_is_finished", false);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void H(Function2<? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        j.d(l0.a(w0.b()), null, null, new FissionProvider$showPalmPayDialog$1(this, callback, null), 3, null);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void I(String inviteCode) {
        Intrinsics.g(inviteCode, "inviteCode");
        e.f51915a.c(inviteCode);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public String I0() {
        return e.f51915a.a();
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void U(boolean z11) {
        PalmPayMmkv.f350a.a().putBoolean("kv_task_is_exists", z11);
        uo.b.a.g(uo.b.f78622a, "updatePalmPayTask() ---> isExists = " + z11, false, 2, null);
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public boolean enable() {
        FissionConfig fissionConfigB = FissionManager.f51905a.b();
        String htmlUrl = fissionConfigB != null ? fissionConfigB.getHtmlUrl() : null;
        return !(htmlUrl == null || htmlUrl.length() == 0);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        if (context == null) {
            context = Utils.a();
            Intrinsics.f(context, "getApp()");
        }
        this.f51911a = context;
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void l0(boolean z11) {
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void r1(boolean z11) {
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public String x0() {
        return FissionManager.f51905a.a();
    }

    @Override // com.transsion.fissionapi.IFissionProvider
    public void z0(Context context) {
        Intrinsics.g(context, "context");
        new ft.b(context).show();
    }
}
