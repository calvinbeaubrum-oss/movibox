package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.applovin.impl.e4;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements AppLovinWebViewActivity.EventListener, h.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicBoolean f22547h = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static WeakReference f22548i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f22550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinUserService.OnConsentDialogDismissListener f22551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f22552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference f22553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.p f22554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicBoolean f22555g = new AtomicBoolean();

    /* JADX INFO: compiled from: source.java */
    public class a extends com.applovin.impl.p {
        public a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            i.this.f22553e = new WeakReference(activity);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.applovin.impl.p {
        public b() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity instanceof AppLovinWebViewActivity) {
                if (!i.this.f() || i.f22548i.get() != activity) {
                    AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                    WeakReference unused = i.f22548i = new WeakReference(appLovinWebViewActivity);
                    appLovinWebViewActivity.loadUrl((String) i.this.f22549a.a(sj.f23005m0), i.this);
                }
                i.f22547h.set(false);
            }
        }
    }

    public i(j jVar) {
        this.f22553e = new WeakReference(null);
        this.f22549a = jVar;
        this.f22550b = jVar.J();
        if (jVar.G() != null) {
            this.f22553e = new WeakReference(jVar.G());
        }
        j.a(j.l()).a(new a());
        this.f22552d = new h(this, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j11) {
        if (n.a()) {
            this.f22550b.a("ConsentDialogManager", "Scheduling repeating consent alert");
        }
        this.f22552d.a(j11, this.f22549a, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener, Activity activity) {
        if (!a(this.f22549a) || f22547h.getAndSet(true)) {
            if (onConsentDialogDismissListener != null) {
                onConsentDialogDismissListener.onDismiss();
                return;
            }
            return;
        }
        this.f22553e = new WeakReference(activity);
        this.f22551c = onConsentDialogDismissListener;
        this.f22554f = new b();
        this.f22549a.e().a(this.f22554f);
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f22549a.b0());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) this.f22549a.a(sj.f23013n0));
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        WebView webViewA = yp.a(j.l(), "preloading consent dialog", true);
        if (webViewA == null) {
            return;
        }
        webViewA.loadUrl(str);
    }

    private void a(boolean z11, long j11) {
        e();
        if (z11) {
            b(j11);
        }
    }

    private boolean a(j jVar) {
        if (f()) {
            n.h("AppLovinSdk", "Consent dialog already showing");
            return false;
        }
        if (!e4.a(j.l())) {
            n.h("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        }
        if (!((Boolean) jVar.a(sj.f22997l0)).booleanValue()) {
            if (n.a()) {
                this.f22550b.b("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            }
            return false;
        }
        if (StringUtils.isValidString((String) jVar.a(sj.f23005m0))) {
            return true;
        }
        if (n.a()) {
            this.f22550b.b("ConsentDialogManager", "AdServer returned empty consent dialog URL");
        }
        return false;
    }

    private void e() {
        this.f22549a.e().b(this.f22554f);
        if (f()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) f22548i.get();
            f22548i = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.f22551c;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f22551c = null;
                }
            }
        }
    }

    @Override // com.applovin.impl.sdk.h.a
    public void a() {
    }

    public void a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22541a.a(onConsentDialogDismissListener, activity);
            }
        });
    }

    @Override // com.applovin.impl.sdk.h.a
    public void b() {
        final Activity activity = (Activity) this.f22553e.get();
        if (activity != null) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22558a.a(activity);
                }
            }, ((Long) this.f22549a.a(sj.f23021o0)).longValue());
        }
    }

    public void b(final long j11) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22641a.a(j11);
            }
        });
    }

    public boolean f() {
        WeakReference weakReference = f22548i;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void g() {
        if (this.f22555g.getAndSet(true)) {
            return;
        }
        final String str = (String) this.f22549a.a(sj.f23005m0);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22621a.a(str);
            }
        });
    }

    @Override // com.applovin.sdk.AppLovinWebViewActivity.EventListener
    public void onReceivedEvent(String str) {
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, j.l());
            e();
        } else if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, j.l());
            a(((Boolean) this.f22549a.a(sj.f23029p0)).booleanValue(), ((Long) this.f22549a.a(sj.f23069u0)).longValue());
        } else if ("closed".equalsIgnoreCase(str)) {
            a(((Boolean) this.f22549a.a(sj.f23037q0)).booleanValue(), ((Long) this.f22549a.a(sj.f23077v0)).longValue());
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            a(((Boolean) this.f22549a.a(sj.f23045r0)).booleanValue(), ((Long) this.f22549a.a(sj.f23085w0)).longValue());
        }
    }
}
