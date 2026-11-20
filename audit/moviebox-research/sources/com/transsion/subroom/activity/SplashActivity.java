package com.transsion.subroom.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.mb.config.download.RequestConfig;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.subroom.R$layout;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SuppressLint({"CustomSplashScreen"})
public final class SplashActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f58021d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nq.b f58022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58023b = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.subroom.activity.SplashActivity$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f58024c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Handler S() {
        return (Handler) this.f58023b.getValue();
    }

    public static final void U(SplashActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.T("time_out");
    }

    private final void setStatusBar() {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().clearFlags(67108864);
        getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 23 ? 13312 : 5120);
    }

    public final void R() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (System.currentTimeMillis() - roomAppMMKV.a().getLong("app_config_fetch_time", 0L) > 1800000) {
            RequestConfig.f53099a.l();
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SplashActivity$fetchAppConfig$1(null), 3, null);
            roomAppMMKV.a().putLong("app_config_fetch_time", System.currentTimeMillis());
        }
    }

    public final void T(String str) {
        nq.b bVar;
        S().removeCallbacksAndMessages(null);
        com.transsion.ad.a.N(com.transsion.ad.a.f50276a, "SplashActivity --> laterAd() --> state = " + str, false, 2, null);
        AppStartReport appStartReport = AppStartReport.f57974a;
        appStartReport.d(new AppStartDotState(AppStartDotState.AD_RENDERING, 0L, 2, null));
        if (this.f58024c) {
            return;
        }
        this.f58024c = true;
        boolean zEquals = TextUtils.equals("success", str);
        if (TextUtils.equals("time_out", str)) {
            vq.b.f79053a.k("", "", 5, 105, "开屏广告加载超时");
        }
        if (!zEquals) {
            nq.b bVar2 = this.f58022a;
            if (bVar2 != null) {
                bVar2.F();
            }
            this.f58022a = null;
        }
        setStatusBar();
        V();
        R();
        W(zEquals);
        if (getIntent().getBooleanExtra("without_ad", false)) {
            appStartReport.d(new AppStartDotState(AppStartDotState.AD_END, 0L, 2, null));
        } else {
            if (!zEquals || (bVar = this.f58022a) == null) {
                return;
            }
            bVar.o0(Integer.valueOf(R$layout.splash_ad_app_layout), this);
        }
    }

    public final void V() {
        PreloadTrendingData.a aVar = PreloadTrendingData.f52790o;
        aVar.a().t();
        aVar.a().M(this);
        aVar.a().C();
    }

    public final void W(boolean z11) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("isSplashAdLoaded", z11);
        startActivity(intent);
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SplashActivity$toMain$1(this, null), 3, null);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AppStartReport appStartReport = AppStartReport.f57974a;
        appStartReport.d(new AppStartDotState(AppStartDotState.SPLASH_START, 0L, 2, null));
        i3.a.f66893b.a(this);
        if (!isTaskRoot() && !Intrinsics.b(getIntent().getStringExtra("from"), WebConstants.FIELD_DEEPLINK)) {
            uo.b.a.f(uo.b.f78622a, "SplashActivity", "finish from TaskRoot", false, 4, null);
            finish();
            return;
        }
        ILoginApi iLoginApi = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        iLoginApi.b1(iLoginApi.g1() + 1);
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        if (!roomAppMMKV.a().getBoolean("first_start_not_show_cold_ad", false)) {
            T("skip");
            roomAppMMKV.a().putBoolean("first_start_not_show_cold_ad", true);
        } else {
            appStartReport.d(new AppStartDotState(AppStartDotState.AD_LOADING, 0L, 2, null));
            kotlinx.coroutines.j.d(v.a(this), null, null, new SplashActivity$onCreate$2$1(this, null), 3, null);
            S().postDelayed(new Runnable() { // from class: com.transsion.subroom.activity.n
                @Override // java.lang.Runnable
                public final void run() {
                    SplashActivity.U(this.f58042a);
                }
            }, ((long) wq.a.f79581a.j("ColdStartScene")) * 1000);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.transsion.baseui.activity.d.f(null, this, 1, null);
        nq.b bVar = this.f58022a;
        if (bVar != null) {
            bVar.l0(null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.k(null, this, 1, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.d.o(null, this, 1, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        if (z11) {
            AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.SPLASH_RESUME, 0L, 2, null));
        }
    }
}
