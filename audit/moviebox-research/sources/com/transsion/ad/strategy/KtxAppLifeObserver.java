package com.transsion.ad.strategy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.MBAd;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
public final class KtxAppLifeObserver extends jq.a implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KtxAppLifeObserver f50569a = new KtxAppLifeObserver();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f50570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f50571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static com.transsion.ad.bidding.interstitial.a f50572d;

    /* JADX INFO: renamed from: com.transsion.ad.strategy.KtxAppLifeObserver$onStart$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.strategy.KtxAppLifeObserver$onStart$1", f = "KtxAppLifeObserver.kt", l = {72}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ u $owner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(u uVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$owner = uVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$owner, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                this.label = 1;
                if (r0.a(300L, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            KtxAppLifeObserver.f50569a.u(this.$owner);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = KtxAppLifeObserver.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    private final void v() {
        com.transsion.ad.bidding.interstitial.a aVar = f50572d;
        if (aVar != null) {
            aVar.F();
        }
        f50572d = null;
    }

    @Override // jq.a
    public void g(TAdErrorCode tAdErrorCode) {
        super.g(tAdErrorCode);
        v();
    }

    @Override // jq.a
    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.h(biddingIntermediateMaterialBean);
        Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB != null) {
            AppCompatActivity appCompatActivity = activityB instanceof AppCompatActivity ? (AppCompatActivity) activityB : null;
            if (appCompatActivity != null) {
                kotlinx.coroutines.j.d(v.a(appCompatActivity), null, null, new KtxAppLifeObserver$onBiddingLoad$1$1$1(activityB, null), 3, null);
            }
        }
    }

    @Override // jq.a
    public void j(int i11) {
        super.j(i11);
        v();
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
        f50571c = false;
        MeasureManager.f50573a.r();
        kotlinx.coroutines.j.d(v.a(owner), null, null, new AnonymousClass1(owner, null), 3, null);
    }

    @Override // androidx.lifecycle.f
    public void onStop(u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.f(this, owner);
        f50570b = SystemClock.elapsedRealtime();
        f50571c = true;
        MeasureManager.f50573a.t();
        com.transsion.ad.bidding.interstitial.a.f50342m.a(oq.d.f72515a.a());
    }

    public final String r() {
        JsonElement jsonElement;
        Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB == null) {
            return "topAct is null";
        }
        if (activityB.isDestroyed()) {
            return "topAct?.isDestroyed == true";
        }
        if (t(activityB) || s(activityB)) {
            return "处理App在锁屏状态下被拉活";
        }
        oq.b bVar = oq.b.f72511a;
        if (bVar.a()) {
            bVar.b(false);
            return "全搜的时候热启动不展示热启动广告";
        }
        if (f50570b <= 0) {
            return "inBackgroundTime <= 0";
        }
        MBAd.a aVarB = MBAd.f50258a.b();
        if (aVarB == null || aVarB.g()) {
            return "";
        }
        if (NewUserManager.f50581a.c()) {
            return "新用户保护期间不展示热启动广告";
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - f50570b;
        JsonObject jsonObjectB = wq.d.f79584a.b(oq.d.f72515a.a());
        int asInt = ((jsonObjectB == null || (jsonElement = jsonObjectB.get("hotSplashInterval")) == null) ? 1 : jsonElement.getAsInt()) * 60000;
        if (jCurrentTimeMillis >= asInt) {
            return "";
        }
        return "不满足最小间隔时间 -- background_time = " + jCurrentTimeMillis + " --- TIME_IN_THE_BACKGROUND = " + asInt;
    }

    public final boolean s(Context context) {
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (Build.VERSION.SDK_INT >= 23) {
            return keyguardManager.isDeviceLocked() || keyguardManager.isKeyguardLocked();
        }
        return keyguardManager.isKeyguardLocked();
    }

    public final boolean t(Context context) {
        Object systemService = context.getSystemService("power");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return !((PowerManager) systemService).isScreenOn();
    }

    public final void u(u uVar) {
        String strR = r();
        if (TextUtils.isEmpty(strR)) {
            kotlinx.coroutines.j.d(v.a(uVar), null, null, new KtxAppLifeObserver$loadHotSplashAd$1(this, null), 3, null);
            return;
        }
        com.transsion.ad.a.H(com.transsion.ad.a.f50276a, getClassTag() + " --> loadHotSplashAd() --> msg = " + strR, false, 2, null);
    }
}
