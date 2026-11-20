package com.applovin.adview;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.ma;
import com.applovin.impl.p9;
import com.applovin.impl.r;
import com.applovin.impl.s;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.t6;
import com.applovin.impl.tb;
import com.applovin.impl.u9;
import com.applovin.impl.uj;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinFullscreenActivity extends Activity implements t6 {

    @SuppressLint({"StaticFieldLeak"})
    public static tb parentInterstitialWrapper;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f17135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p9 f17136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f17137c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.applovin.impl.adview.activity.a f17138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f17139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17140g;

    /* JADX INFO: compiled from: source.java */
    public class a implements p9.d {
        public a() {
        }

        @Override // com.applovin.impl.p9.d
        public void a(p9 p9Var) {
            AppLovinFullscreenActivity.this.f17136b = p9Var;
            p9Var.A();
        }

        @Override // com.applovin.impl.p9.d
        public void a(String str, Throwable th2) {
            tb.a(AppLovinFullscreenActivity.parentInterstitialWrapper.f(), AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th2, AppLovinFullscreenActivity.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements OnBackInvokedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f17142a;

        public b(Runnable runnable) {
            this.f17142a = runnable;
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            this.f17142a.run();
        }
    }

    private void a() {
        tb tbVar;
        j jVar = this.f17135a;
        if (jVar == null || !((Boolean) jVar.a(sj.f23055s2)).booleanValue() || (tbVar = parentInterstitialWrapper) == null || tbVar.f() == null) {
            return;
        }
        com.applovin.impl.sdk.ad.b bVarF = parentInterstitialWrapper.f();
        List listG = bVarF.g();
        if (CollectionUtils.isEmpty(listG)) {
            return;
        }
        s sVar = (s) listG.get(0);
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_url", sVar.c());
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_backup_url", sVar.a());
        this.f17135a.i0().b(uj.M, jSONObject.toString());
        this.f17135a.i0().b(uj.L, Long.valueOf(System.currentTimeMillis()));
        this.f17135a.i0().b(uj.N, CollectionUtils.toJsonString(ma.a(bVarF), "{}"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            p9Var.u();
        }
        if (yp.e(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    @Override // com.applovin.impl.t6
    public void dismiss() {
        if (z3.l() && this.f17139f != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f17139f);
            this.f17139f = null;
        }
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            p9Var.f();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            p9Var.a(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            n.j("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
            dismiss();
            return;
        }
        try {
            requestWindowFeature(1);
        } catch (Throwable th2) {
            n.c("AppLovinFullscreenActivity", "Failed to request window feature", th2);
        }
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        View viewFindViewById = findViewById(R.id.content);
        viewFindViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        String stringExtra = getIntent().getStringExtra("com.applovin.interstitial.sdk_key");
        if (TextUtils.isEmpty(stringExtra)) {
            tb tbVar = parentInterstitialWrapper;
            if (tbVar != null && tbVar.f() != null) {
                tb.a(parentInterstitialWrapper.f(), parentInterstitialWrapper.c(), "Empty SDK key", null, this);
            }
            finish();
            return;
        }
        j jVarA = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(this), this).a();
        this.f17135a = jVarA;
        this.f17140g = ((Boolean) jVarA.a(sj.J2)).booleanValue();
        viewFindViewById.setFitsSystemWindows(true);
        r.a(this.f17140g, this);
        if (z3.l() && ((Boolean) this.f17135a.a(sj.V5)).booleanValue()) {
            this.f17139f = new b(new Runnable() { // from class: com.applovin.adview.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17148a.b();
                }
            });
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f17139f);
        }
        a();
        tb tbVar2 = parentInterstitialWrapper;
        if (tbVar2 != null) {
            p9.a(tbVar2.f(), parentInterstitialWrapper.b(), parentInterstitialWrapper.c(), parentInterstitialWrapper.d(), parentInterstitialWrapper.h(), this.f17135a, this, new a());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.f17135a);
        this.f17138d = aVar;
        bindService(intent, aVar, 1);
        if (z3.j()) {
            String str = this.f17135a.g0().getExtraParameters().get("disable_set_data_dir_suffix");
            if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
                return;
            }
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        j jVar = this.f17135a;
        if (jVar != null && ((Boolean) jVar.a(sj.f23055s2)).booleanValue()) {
            this.f17135a.i0().b(uj.L);
            this.f17135a.i0().b(uj.M);
            this.f17135a.i0().b(uj.N);
        }
        com.applovin.impl.adview.activity.a aVar = this.f17138d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            if (p9Var.B()) {
                parentInterstitialWrapper.j();
            }
            if (!this.f17136b.k()) {
                this.f17136b.f();
            }
            this.f17136b.v();
        }
        parentInterstitialWrapper = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            p9Var.a(i11, keyEvent);
        }
        return super.onKeyDown(i11, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            p9Var.w();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        p9 p9Var;
        try {
            super.onResume();
            if (this.f17137c.get() || (p9Var = this.f17136b) == null) {
                return;
            }
            p9Var.x();
        } catch (IllegalArgumentException e11) {
            this.f17135a.J();
            if (n.a()) {
                this.f17135a.J().a("AppLovinFullscreenActivity", "Error was encountered in onResume().", e11);
            }
            this.f17135a.E().a("AppLovinFullscreenActivity", "onResume", e11);
            dismiss();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        p9 p9Var = this.f17136b;
        if (p9Var != null) {
            p9Var.y();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        if (this.f17136b != null) {
            if (!this.f17137c.getAndSet(false) || (this.f17136b instanceof u9)) {
                this.f17136b.c(z11);
            }
            if (z11) {
                r.a(this.f17140g, this);
            }
        }
        super.onWindowFocusChanged(z11);
    }

    public void setPresenter(@Nullable p9 p9Var) {
        this.f17136b = p9Var;
    }
}
