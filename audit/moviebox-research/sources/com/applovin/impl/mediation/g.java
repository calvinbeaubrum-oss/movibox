package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.ge;
import com.applovin.impl.ie;
import com.applovin.impl.jn;
import com.applovin.impl.pe;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.ve;
import com.applovin.impl.yl;
import com.applovin.impl.zj;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f20995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final pe f20997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f20998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxAdapter f20999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f21000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ge f21001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f21002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAd f21003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxNativeAdView f21004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ViewGroup f21005m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MaxAdapterResponseParameters f21007o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f21011s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f20993a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c f21006n = new c(this, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f21008p = new AtomicBoolean(true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f21009q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f21010r = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public class a implements MaxSignalCollectionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ zj f21012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f21013b;

        public a(zj zjVar, e eVar) {
            this.f21012a = zjVar;
            this.f21013b = eVar;
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
        public void onSignalCollected(String str) {
            if (this.f21012a.y() && TextUtils.isEmpty(str)) {
                g.this.a(new MaxErrorImpl("Signal is not a valid string"), this.f21013b);
            } else {
                g.this.a(str, this.f21013b);
            }
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
        public void onSignalCollectionFailed(String str) {
            g.this.a(new MaxErrorImpl(str), this.f21013b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(MaxError maxError);

        void onSignalCollected(String str);
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements MaxInterstitialAdapterListener, MaxAppOpenAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener, MaxAdViewAdapterListener, MaxNativeAdAdapterListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediationServiceImpl.d f21015a;

        private c() {
        }

        public /* synthetic */ c(g gVar, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.f21015a.onAdCollapsed(g.this.f21001i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Bundle bundle) {
            this.f21015a.a(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ie ieVar, MaxReward maxReward, Bundle bundle) {
            this.f21015a.a(ieVar, maxReward, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MediationServiceImpl.d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("No listener specified");
            }
            this.f21015a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError) {
            if (g.this.f21009q.compareAndSet(false, true)) {
                this.f21015a.onAdLoadFailed(g.this.f21000h, maxError);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError, Bundle bundle) {
            this.f21015a.a(g.this.f21001i, maxError, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, MaxAdListener maxAdListener, String str) {
            try {
                runnable.run();
            } catch (Throwable th2) {
                com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + (maxAdListener != null ? maxAdListener.getClass().getName() : null), th2);
                g.this.f20994b.E().a("MediationAdapterWrapper", str, th2, CollectionUtils.hashMap("adapter_class", g.this.f20997e.b()));
            }
        }

        private void a(String str, final Bundle bundle) {
            if (!g.this.f21001i.x().get()) {
                if (((Boolean) g.this.f20994b.a(ve.Q7)).booleanValue()) {
                    a(str, this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.w0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f21133a.h(bundle);
                        }
                    });
                    return;
                } else {
                    if (g.this.f21001i.v().compareAndSet(false, true)) {
                        a(str, this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.x0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f21138a.i(bundle);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.b("MediationAdapterWrapper", g.this.f20998f + ": blocking ad displayed callback for " + g.this.f21001i + " since onAdHidden() has been called");
            }
            g.this.f20994b.p().a(g.this.f21001i, str);
        }

        private void a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            g.this.f20993a.post(new Runnable() { // from class: com.applovin.impl.mediation.f1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20989a.a(runnable, maxAdListener, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError) {
            if (!g.this.f21001i.x().get()) {
                a(str, this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21122a.a(maxError);
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.b("MediationAdapterWrapper", g.this.f20998f + ": blocking ad load failed callback for " + g.this.f21001i + " since onAdHidden() has been called");
            }
            g.this.f20994b.p().a(g.this.f21001i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError, final Bundle bundle) {
            if (!g.this.f21001i.x().get()) {
                a(str, this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21101a.a(maxError, bundle);
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.b("MediationAdapterWrapper", g.this.f20998f + ": blocking ad display failed callback for " + g.this.f21001i + " since onAdHidden() has been called");
            }
            g.this.f20994b.p().a(g.this.f21001i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            this.f21015a.onRewardedVideoCompleted(g.this.f21001i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Bundle bundle) {
            this.f21015a.d(g.this.f21001i, bundle);
        }

        private void b(String str, final Bundle bundle) {
            if (g.this.f21001i.x().compareAndSet(false, true)) {
                a(str, this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20973a.j(bundle);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f21015a.onRewardedVideoStarted(g.this.f21001i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Bundle bundle) {
            this.f21015a.a(g.this.f21001i, bundle);
        }

        private void c(String str, final Bundle bundle) {
            if (!g.this.f21001i.x().get()) {
                g.this.f21010r.set(true);
                a(str, this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.b1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20862a.k(bundle);
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.b("MediationAdapterWrapper", g.this.f20998f + ": blocking ad loaded callback for " + g.this.f21001i + " since onAdHidden() has been called");
            }
            g.this.f20994b.p().a(g.this.f21001i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            this.f21015a.onRewardedVideoCompleted(g.this.f21001i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Bundle bundle) {
            this.f21015a.a(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            this.f21015a.onRewardedVideoStarted(g.this.f21001i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Bundle bundle) {
            this.f21015a.a(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Bundle bundle) {
            this.f21015a.a(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Bundle bundle) {
            this.f21015a.a(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Bundle bundle) {
            this.f21015a.c(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(Bundle bundle) {
            this.f21015a.c(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(Bundle bundle) {
            this.f21015a.e(g.this.f21001i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(Bundle bundle) {
            if (g.this.f21009q.compareAndSet(false, true)) {
                this.f21015a.f(g.this.f21001i, bundle);
            }
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked() {
            onAdViewAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.z0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21148a.a(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed() {
            onAdViewAdCollapsed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21128a.a();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAdViewAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": adview ad failed to display with error: " + maxAdapterError);
            }
            a("onAdViewAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed(Bundle bundle) {
            if (g.this.f21001i.b0()) {
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": adview ad displayed with extra info: " + bundle);
            }
            a("onAdViewAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded() {
            onAdViewAdExpanded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.y0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21143a.b(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden() {
            onAdViewAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": adview ad hidden with extra info: " + bundle);
            }
            b("onAdViewAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": adview ad loaded with extra info: " + bundle);
            }
            g.this.f21002j = view;
            c("onAdViewAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked() {
            onAppOpenAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": app open ad clicked with extra info: " + bundle);
            }
            a("onAppOpenAdClicked", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21097a.c(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAppOpenAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": app open ad display failed with error: " + maxAdapterError);
            }
            a("onAppOpenAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed() {
            onAppOpenAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": app open ad displayed with extra info: " + bundle);
            }
            a("onAppOpenAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden() {
            onAppOpenAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": app open ad hidden with extra info: " + bundle);
            }
            b("onAppOpenAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": app open ad failed to load with error: " + maxAdapterError);
            }
            a("onAppOpenAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded() {
            onAppOpenAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": app open ad loaded with extra info: " + bundle);
            }
            c("onAppOpenAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked() {
            onInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20917a.d(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            a("onInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": interstitial ad displayed with extra info: " + bundle);
            }
            a("onInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden() {
            onInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": interstitial ad hidden with extra info " + bundle);
            }
            b("onInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": interstitial ad loaded with extra info: " + bundle);
            }
            c("onInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked() {
            onNativeAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": native ad clicked");
            }
            a("onNativeAdClicked", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.a1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20733a.e(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdDisplayed(Bundle bundle) {
            if (g.this.f21001i.b0()) {
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": native ad displayed with extra info: " + bundle);
            }
            a("onNativeAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": native ad loaded with extra info: " + bundle);
            }
            g.this.f21003k = maxNativeAd;
            c("onNativeAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked() {
            onRewardedAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.g1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21030a.f(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad displayed with extra info: " + bundle);
            }
            a("onRewardedAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden() {
            onRewardedAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad hidden with extra info: " + bundle);
            }
            b("onRewardedAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded() {
            onRewardedAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad loaded with extra info: " + bundle);
            }
            c("onRewardedAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdVideoCompleted() {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded video completed");
            }
            a("onRewardedAdVideoCompleted", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21118a.b();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdVideoStarted() {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded video started");
            }
            a("onRewardedAdVideoStarted", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21116a.c();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked() {
            onRewardedInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial ad clicked with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdClicked", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20872a.g(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            }
            a("onRewardedInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden() {
            onRewardedInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial ad hidden with extra info: " + bundle);
            }
            b("onRewardedInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.k("MediationAdapterWrapper", g.this.f20998f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            }
            c("onRewardedInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdVideoCompleted() {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial completed");
            }
            a("onRewardedInterstitialAdVideoCompleted", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21106a.d();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdVideoStarted() {
            com.applovin.impl.sdk.n unused = g.this.f20995c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": rewarded interstitial started");
            }
            a("onRewardedInterstitialAdVideoStarted", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21093a.e();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(MaxReward maxReward) {
            onUserRewarded(maxReward, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(final MaxReward maxReward, final Bundle bundle) {
            if (g.this.f21001i instanceof ie) {
                final ie ieVar = (ie) g.this.f21001i;
                if (ieVar.s0().compareAndSet(false, true)) {
                    com.applovin.impl.sdk.n unused = g.this.f20995c;
                    if (com.applovin.impl.sdk.n.a()) {
                        g.this.f20995c.d("MediationAdapterWrapper", g.this.f20998f + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", this.f21015a, new Runnable() { // from class: com.applovin.impl.mediation.r0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f21109a.a(ieVar, maxReward, bundle);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements MaxAdapter.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f21017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final pe f21018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f21019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MaxAdapter.OnCompletionListener f21020d;

        public d(com.applovin.impl.sdk.j jVar, pe peVar, long j11, MaxAdapter.OnCompletionListener onCompletionListener) {
            this.f21017a = jVar;
            this.f21018b = peVar;
            this.f21019c = j11;
            this.f21020d = onCompletionListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
            this.f21017a.L().a(this.f21018b, SystemClock.elapsedRealtime() - this.f21019c, initializationStatus, str);
            MaxAdapter.OnCompletionListener onCompletionListener = this.f21020d;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(initializationStatus, str);
            }
        }

        @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
        public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21039a.a(initializationStatus, str);
                }
            }, this.f21018b.h());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zj f21021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f21022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f21023c = new AtomicBoolean();

        public e(zj zjVar, b bVar) {
            this.f21021a = zjVar;
            this.f21022b = bVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final WeakReference f21024h;

        private f() {
            super("TaskTimeoutMediatedAd", g.this.f20994b);
            this.f21024h = new WeakReference(g.this.f21006n);
        }

        public /* synthetic */ f(g gVar, a aVar) {
            this();
        }

        private void b(ge geVar) {
            if (geVar != null) {
                this.f24689a.S().a(geVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f21009q.get()) {
                return;
            }
            if (g.this.f21001i.c0()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, g.this.f20998f + " is timing out, considering JS Tag ad loaded: " + g.this.f21001i);
                }
                b(g.this.f21001i);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, g.this.f20998f + " is timing out " + g.this.f21001i + "...");
            }
            b(g.this.f21001i);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-5101, "Adapter timed out");
            c cVar = (c) this.f21024h.get();
            if (cVar != null) {
                cVar.a(this.f24690b, maxErrorImpl);
            }
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0191g extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final e f21026h;

        private C0191g(e eVar) {
            super("TaskTimeoutSignalCollection", g.this.f20994b);
            this.f21026h = eVar;
        }

        public /* synthetic */ C0191g(g gVar, e eVar, a aVar) {
            this(eVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21026h.f21023c.get()) {
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, g.this.f20998f + " is timing out " + this.f21026h.f21021a + "...");
            }
            g.this.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + g.this.f20998f + ") timed out"), this.f21026h);
        }
    }

    public g(pe peVar, MaxAdapter maxAdapter, boolean z11, com.applovin.impl.sdk.j jVar) {
        if (peVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        }
        if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f20996d = peVar.c();
        this.f20999g = maxAdapter;
        this.f20994b = jVar;
        this.f20995c = jVar.J();
        this.f20997e = peVar;
        this.f20998f = maxAdapter.getClass().getSimpleName();
        this.f21011s = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        ((MaxAppOpenAdapter) this.f20999g).showAppOpenAd(this.f21007o, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxInterstitialAdViewAdapter) this.f20999g).showInterstitialAd(this.f21007o, viewGroup, lifecycle, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ge geVar, Activity activity) {
        this.f20994b.F().a((ie) geVar, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ge geVar, Runnable runnable) {
        a(this.f20997e, geVar);
        try {
            runnable.run();
        } catch (Throwable th2) {
            String str = "Failed to start loading ad for " + this.f20996d + " due to: " + th2;
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
            this.f21006n.a("load_ad", new MaxErrorImpl(-1, str));
            this.f20994b.E().a("MediationAdapterWrapper", "load_ad", th2, CollectionUtils.hashMap("adapter_class", this.f20997e.b()));
            a("load_ad");
            this.f20994b.M().a(this.f20997e.b(), "load_ad", this.f21001i);
        }
    }

    private void a(pe peVar, ge geVar) {
        a(new f(this, null), peVar, geVar);
    }

    private void a(pe peVar, e eVar) {
        a(new C0191g(this, eVar, null), peVar, (ge) null);
    }

    private void a(yl ylVar, pe peVar, ge geVar) {
        long jM = peVar.m();
        if (jM <= 0) {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f20995c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Non-positive timeout set for ");
                if (geVar != null) {
                    peVar = geVar;
                }
                sb2.append(peVar);
                sb2.append(", not scheduling a timeout");
                nVar.a("MediationAdapterWrapper", sb2.toString());
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVar2 = this.f20995c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Setting timeout ");
            sb3.append(jM);
            sb3.append("ms for ");
            if (geVar != null) {
                peVar = geVar;
            }
            sb3.append(peVar);
            nVar2.a("MediationAdapterWrapper", sb3.toString());
        }
        this.f20994b.j0().a(ylVar, tm.b.TIMEOUT, jM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(zj zjVar, e eVar, MaxSignalProvider maxSignalProvider, MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity) {
        a(zjVar, eVar);
        try {
            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters, activity, new a(zjVar, eVar));
        } catch (Throwable th2) {
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl("Failed signal collection for " + this.f20996d + " due to: " + th2);
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", maxErrorImpl.getMessage());
            a(maxErrorImpl, eVar);
            this.f20994b.E().a("MediationAdapterWrapper", "collect_signal", th2, CollectionUtils.hashMap("adapter_class", this.f20997e.b()));
            a("collect_signal");
            this.f20994b.M().a(this.f20997e.b(), "collect_signal", this.f21001i);
        }
        if (!eVar.f21023c.get() && zjVar.m() == 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20995c.a("MediationAdapterWrapper", "Failing signal collection " + zjVar + " since it has 0 timeout");
            }
            a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + this.f20998f + ") has 0 timeout"), eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxError maxError, e eVar) {
        if (!eVar.f21023c.compareAndSet(false, true) || eVar.f21022b == null) {
            return;
        }
        eVar.f21022b.a(maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapter.OnCompletionListener onCompletionListener, MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.applovin.impl.sdk.n.a()) {
            this.f20995c.a("MediationAdapterWrapper", "Initializing " + this.f20998f + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + this.f20997e.s());
        }
        this.f20999g.initialize(maxAdapterInitializationParameters, activity, new d(this.f20994b, this.f20997e, jElapsedRealtime, onCompletionListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxInterstitialAdapter) this.f20999g).loadInterstitialAd(maxAdapterResponseParameters, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity) {
        ((MaxAdViewAdapter) this.f20999g).loadAdViewAd(maxAdapterResponseParameters, maxAdFormat, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th2) {
            String str = "Failed to start displaying ad for " + this.f20996d + " due to: " + th2;
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
            this.f21006n.a("show_ad", new MaxErrorImpl(-1, str), (Bundle) null);
            this.f20994b.E().a("MediationAdapterWrapper", "show_ad", th2, CollectionUtils.hashMap("adapter_class", this.f20997e.b()));
            a("show_ad");
            this.f20994b.M().a(this.f20997e.b(), "show_ad", this.f21001i);
        }
    }

    private void a(final Runnable runnable, ge geVar) {
        a("show_ad", geVar.getFormat(), new Runnable() { // from class: com.applovin.impl.mediation.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f21055a.a(runnable);
            }
        });
    }

    private void a(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20995c.d("MediationAdapterWrapper", "Marking " + this.f20998f + " as disabled due to: " + str);
        }
        this.f21008p.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, e eVar) {
        if (!eVar.f21023c.compareAndSet(false, true) || eVar.f21022b == null) {
            return;
        }
        eVar.f21022b.onSignalCollected(str);
    }

    private void a(final String str, MaxAdFormat maxAdFormat, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.applovin.impl.mediation.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f21049a.a(str, runnable);
            }
        };
        if (a(str, maxAdFormat)) {
            this.f20993a.post(runnable2);
            return;
        }
        jn jnVar = new jn(this.f20994b, str + ":" + this.f20997e.c(), runnable2);
        if (((Boolean) this.f20994b.a(sj.f22949f0)).booleanValue()) {
            this.f20994b.j0().a(jnVar, this.f20997e);
        } else {
            this.f20994b.j0().a(jnVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        try {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20995c.a("MediationAdapterWrapper", this.f20998f + ": running " + str + "...");
            }
            runnable.run();
            if (com.applovin.impl.sdk.n.a()) {
                this.f20995c.a("MediationAdapterWrapper", this.f20998f + ": finished " + str + "");
            }
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed operation " + str + " for " + this.f20996d, th2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fail_");
            sb2.append(str);
            a(sb2.toString());
            if (str.equals(PushConstants.PROVIDER_FIELD_DESTROY)) {
                return;
            }
            this.f20994b.M().a(this.f20997e.b(), str, this.f21001i);
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("is_wrapper", "true");
            CollectionUtils.putStringIfValid("adapter_class", this.f20997e.b(), mapHashMap);
            this.f20994b.E().a("MediationAdapterWrapper", str, th2, mapHashMap);
        }
    }

    private boolean a(String str, MaxAdFormat maxAdFormat) {
        Boolean boolShouldShowAdsOnUiThread;
        MaxAdapter maxAdapter = this.f20999g;
        if (maxAdapter == null) {
            return this.f20997e.s();
        }
        if ("initialize".equals(str)) {
            Boolean boolShouldInitializeOnUiThread = maxAdapter.shouldInitializeOnUiThread();
            if (boolShouldInitializeOnUiThread != null) {
                return boolShouldInitializeOnUiThread.booleanValue();
            }
        } else if ("collect_signal".equals(str)) {
            Boolean boolShouldCollectSignalsOnUiThread = maxAdapter.shouldCollectSignalsOnUiThread();
            if (boolShouldCollectSignalsOnUiThread != null) {
                return boolShouldCollectSignalsOnUiThread.booleanValue();
            }
        } else if ("load_ad".equals(str) && maxAdFormat != null) {
            Boolean boolShouldLoadAdsOnUiThread = maxAdapter.shouldLoadAdsOnUiThread(maxAdFormat);
            if (boolShouldLoadAdsOnUiThread != null) {
                return boolShouldLoadAdsOnUiThread.booleanValue();
            }
        } else if ("show_ad".equals(str) && maxAdFormat != null && (boolShouldShowAdsOnUiThread = maxAdapter.shouldShowAdsOnUiThread(maxAdFormat)) != null) {
            return boolShouldShowAdsOnUiThread.booleanValue();
        }
        return this.f20997e.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity) {
        ((MaxRewardedAdapter) this.f20999g).showRewardedAd(this.f21007o, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxRewardedAdViewAdapter) this.f20999g).showRewardedAd(this.f21007o, viewGroup, lifecycle, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxAppOpenAdapter) this.f20999g).loadAppOpenAd(maxAdapterResponseParameters, activity, this.f21006n);
    }

    private void b(String str, Runnable runnable) {
        a(str, (MaxAdFormat) null, runnable);
    }

    private boolean b(ge geVar, Activity activity) {
        if (geVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (geVar.B() == null) {
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", "Adapter has been garbage collected");
            this.f21006n.a("ad_show", new MaxErrorImpl(-1, "Adapter has been garbage collected"), (Bundle) null);
            return false;
        }
        if (geVar.B() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != geVar.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (this.f21008p.get()) {
            if (j()) {
                return true;
            }
            throw new IllegalStateException("Mediation adapter '" + this.f20998f + "' does not have an ad loaded. Please load an ad first");
        }
        String str = "Mediation adapter '" + this.f20998f + "' is disabled. Showing ads with this adapter is disabled.";
        com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
        this.f21006n.a("ad_show", new MaxErrorImpl(-1, str), (Bundle) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.f20999g).showRewardedInterstitialAd(this.f21007o, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedAdapter) this.f20999g).loadRewardedAd(maxAdapterResponseParameters, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Activity activity) {
        ((MaxInterstitialAdapter) this.f20999g).showInterstitialAd(this.f21007o, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedInterstitialAdapter) this.f20999g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MediationAdapterBase) this.f20999g).loadNativeAd(maxAdapterResponseParameters, activity, this.f21006n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        a(PushConstants.PROVIDER_FIELD_DESTROY);
        this.f20999g.onDestroy();
        this.f20999g = null;
        this.f21002j = null;
        this.f21003k = null;
        this.f21004l = null;
        this.f21005m = null;
    }

    public void a() {
        if (this.f21011s) {
            return;
        }
        b(PushConstants.PROVIDER_FIELD_DESTROY, new Runnable() { // from class: com.applovin.impl.mediation.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f21064a.l();
            }
        });
    }

    public void a(ViewGroup viewGroup) {
        this.f21005m = viewGroup;
    }

    public void a(ge geVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (b(geVar, activity)) {
            if (geVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.m0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21082a.a(viewGroup, lifecycle, activity);
                    }
                };
            } else {
                if (geVar.getFormat() != MaxAdFormat.REWARDED) {
                    throw new IllegalStateException("Failed to show " + geVar + ": " + geVar.getFormat() + " is not a supported ad format");
                }
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21124a.b(viewGroup, lifecycle, activity);
                    }
                };
            }
            a(runnable, geVar);
        }
    }

    public void a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        b("initialize", new Runnable() { // from class: com.applovin.impl.mediation.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f21129a.a(onCompletionListener, maxAdapterInitializationParameters, activity);
            }
        });
    }

    public void a(final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, final zj zjVar, final Activity activity, b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!this.f21008p.get()) {
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", "Mediation adapter '" + this.f20998f + "' is disabled. Signal collection ads with this adapter is disabled.");
            bVar.a(new MaxErrorImpl("The adapter (" + this.f20998f + ") is disabled"));
            return;
        }
        final e eVar = new e(zjVar, bVar);
        MaxAdapter maxAdapter = this.f20999g;
        if (maxAdapter instanceof MaxSignalProvider) {
            final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
            b("collect_signal", new Runnable() { // from class: com.applovin.impl.mediation.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21069a.a(zjVar, eVar, maxSignalProvider, maxAdapterSignalCollectionParameters, activity);
                }
            });
            return;
        }
        a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED, "The adapter (" + this.f20998f + ") does not support signal collection"), eVar);
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f21004l = maxNativeAdView;
    }

    public void a(String str, ge geVar) {
        this.f21000h = str;
        this.f21001i = geVar;
    }

    public void a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final ge geVar, final Activity activity, MediationServiceImpl.d dVar) {
        final Runnable runnable;
        if (geVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (!this.f21008p.get()) {
            String str2 = "Mediation adapter '" + this.f20998f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str2);
            dVar.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
            return;
        }
        this.f21007o = maxAdapterResponseParameters;
        this.f21006n.a(dVar);
        final MaxAdFormat maxAdFormatJ = geVar.b0() ? geVar.J() : geVar.getFormat();
        if (maxAdFormatJ == MaxAdFormat.INTERSTITIAL) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21135a.a(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatJ == MaxAdFormat.APP_OPEN) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21140a.b(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatJ == MaxAdFormat.REWARDED) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21145a.c(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatJ == MaxAdFormat.REWARDED_INTERSTITIAL) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20730a.d(maxAdapterResponseParameters, activity);
                }
            };
        } else if (maxAdFormatJ == MaxAdFormat.NATIVE) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20859a.e(maxAdapterResponseParameters, activity);
                }
            };
        } else {
            if (!maxAdFormatJ.isAdViewAd()) {
                throw new IllegalStateException("Failed to load " + geVar + ": " + geVar.getFormat() + " (" + geVar.J() + ") is not a supported ad format");
            }
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20868a.a(maxAdapterResponseParameters, maxAdFormatJ, activity);
                }
            };
        }
        a("load_ad", maxAdFormatJ, new Runnable() { // from class: com.applovin.impl.mediation.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f20914a.a(geVar, runnable);
            }
        });
    }

    public String b() {
        MaxAdapter maxAdapter = this.f20999g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to get adapter version for " + this.f20996d, th2);
            this.f20994b.E().a("MediationAdapterWrapper", "adapter_version", th2, CollectionUtils.hashMap("adapter_class", this.f20997e.b()));
            a("adapter_version");
            this.f20994b.M().a(this.f20997e.b(), "adapter_version", this.f21001i);
            return null;
        }
    }

    public MediationServiceImpl.d c() {
        return this.f21006n.f21015a;
    }

    public void c(final ge geVar, final Activity activity) {
        Runnable runnable;
        if (b(geVar, activity)) {
            if (geVar.b0()) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21119a.a(geVar, activity);
                    }
                };
            } else if (geVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20971a.d(activity);
                    }
                };
            } else if (geVar.getFormat() == MaxAdFormat.APP_OPEN) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20987a.a(activity);
                    }
                };
            } else if (geVar.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21028a.b(activity);
                    }
                };
            } else {
                if (geVar.getFormat() != MaxAdFormat.REWARDED_INTERSTITIAL) {
                    throw new IllegalStateException("Failed to show " + geVar + ": " + geVar.getFormat() + " is not a supported ad format");
                }
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21037a.c(activity);
                    }
                };
            }
            a(runnable, geVar);
        }
    }

    public View d() {
        return this.f21002j;
    }

    public MaxNativeAd e() {
        return this.f21003k;
    }

    public MaxNativeAdView f() {
        return this.f21004l;
    }

    public String g() {
        return this.f20996d;
    }

    public ViewGroup h() {
        return this.f21005m;
    }

    public String i() {
        MaxAdapter maxAdapter = this.f20999g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to get adapter's SDK version for " + this.f20996d, th2);
            this.f20994b.E().a("MediationAdapterWrapper", "sdk_version", th2, CollectionUtils.hashMap("adapter_class", this.f20997e.b()));
            a("sdk_version");
            this.f20994b.M().a(this.f20997e.b(), "sdk_version", this.f21001i);
            return null;
        }
    }

    public boolean j() {
        return this.f21009q.get() && this.f21010r.get();
    }

    public boolean k() {
        return this.f21008p.get();
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f20998f + "'}";
    }
}
