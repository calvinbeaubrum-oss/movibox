package com.transsion.commercialization.dialog;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.lifecycle.u;
import com.transsion.commercializationapi.ICommonDialogApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MainAppLifecycleObserver implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f51629b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f51630c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f51631a = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.commercialization.dialog.MainAppLifecycleObserver$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return MainAppLifecycleObserver.f51630c;
        }

        public final void b(boolean z11) {
            MainAppLifecycleObserver.f51630c = z11;
        }
    }

    public static final void e(MainAppLifecycleObserver this$0) {
        Intrinsics.g(this$0, "this$0");
        Activity activityB = com.blankj.utilcode.util.a.b();
        String simpleName = activityB != null ? activityB.getClass().getSimpleName() : null;
        if (simpleName == null) {
            simpleName = "";
        }
        if (StringsKt__StringsKt.Q(simpleName, "Splash", false, 2, null)) {
            this$0.d();
        } else {
            ((ICommonDialogApi) com.alibaba.android.arouter.launcher.a.d().h(ICommonDialogApi.class)).G();
        }
    }

    private final boolean g(Context context) {
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (Build.VERSION.SDK_INT >= 23) {
            return keyguardManager.isDeviceLocked() || keyguardManager.isKeyguardLocked();
        }
        return keyguardManager.isKeyguardLocked();
    }

    private final boolean h(Context context) {
        Object systemService = context.getSystemService("power");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return !((PowerManager) systemService).isScreenOn();
    }

    public final void d() {
        f().removeCallbacksAndMessages(null);
        f().postDelayed(new Runnable() { // from class: com.transsion.commercialization.dialog.c
            @Override // java.lang.Runnable
            public final void run() {
                MainAppLifecycleObserver.e(this.f51645a);
            }
        }, 3000L);
    }

    public final Handler f() {
        return (Handler) this.f51631a.getValue();
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public void onStart(u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.e(this, owner);
        Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB == null || h(activityB) || g(activityB)) {
            return;
        }
        a aVar = f51629b;
        if (!aVar.a()) {
            d();
        }
        aVar.b(false);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onStop(u uVar) {
        androidx.lifecycle.e.f(this, uVar);
    }
}
