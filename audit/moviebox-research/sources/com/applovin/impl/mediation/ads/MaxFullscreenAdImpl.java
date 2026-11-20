package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.gc;
import com.applovin.impl.ge;
import com.applovin.impl.ie;
import com.applovin.impl.j8;
import com.applovin.impl.jn;
import com.applovin.impl.la;
import com.applovin.impl.lf;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.tm;
import com.applovin.impl.v;
import com.applovin.impl.ve;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxFullscreenAdImpl extends com.applovin.impl.mediation.ads.a implements com.applovin.impl.sdk.a.InterfaceC0199a, v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f20765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f20766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f20767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.applovin.impl.mediation.b f20768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f20769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ie f20770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f20771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f20772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f20773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f20774j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f20775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f20776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f20777m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WeakReference f20778n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WeakReference f20779o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WeakReference f20780p;

    /* JADX INFO: compiled from: source.java */
    public class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f20781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f20782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.mediation.d.b f20783c;

        public a(Activity activity, Context context, com.applovin.impl.mediation.d.b bVar) {
            this.f20781a = activity;
            this.f20782b = context;
            this.f20783c = bVar;
        }

        @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
        public void a() {
            Context contextN0 = this.f20781a;
            if (contextN0 == null && (contextN0 = this.f20782b) == null) {
                contextN0 = MaxFullscreenAdImpl.this.sdk.n0() != null ? MaxFullscreenAdImpl.this.sdk.n0() : com.applovin.impl.sdk.j.l();
            }
            Context context = contextN0;
            MediationServiceImpl mediationServiceImplQ = MaxFullscreenAdImpl.this.sdk.Q();
            MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
            mediationServiceImplQ.loadAd(maxFullscreenAdImpl.adUnitId, null, maxFullscreenAdImpl.adFormat, this.f20783c, maxFullscreenAdImpl.localExtraParameters, maxFullscreenAdImpl.extraParameters, context, maxFullscreenAdImpl.f20767c);
        }

        @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
        public void a(MaxError maxError) {
            if (((Boolean) MaxFullscreenAdImpl.this.sdk.a(ve.L7)).booleanValue()) {
                com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                    maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + MaxFullscreenAdImpl.this.adUnitId + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
                }
                MaxFullscreenAdImpl maxFullscreenAdImpl2 = MaxFullscreenAdImpl.this;
                gc.a(maxFullscreenAdImpl2.adListener, maxFullscreenAdImpl2.adUnitId, maxError, true);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        Activity getActivity();
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements MaxAdListener, MaxRewardedAdListener, MaxAdRevenueListener, com.applovin.impl.mediation.ads.a.InterfaceC0188a {
        private c() {
        }

        public /* synthetic */ c(MaxFullscreenAdImpl maxFullscreenAdImpl, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            MaxFullscreenAdImpl.this.f20775k = true;
            MaxFullscreenAdImpl.this.loadAd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ie ieVar) {
            if (ieVar.x().get()) {
                return;
            }
            MaxFullscreenAdImpl.this.sdk.E().a(la.B, ieVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.a(maxAd);
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd, boolean z11, ie ieVar, MaxError maxError) {
            MaxFullscreenAdImpl.this.a(maxAd);
            if (!z11 && ieVar.x0() && MaxFullscreenAdImpl.this.sdk.K().d(MaxFullscreenAdImpl.this.adUnitId)) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20846a.a();
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(MaxAd maxAd) {
            if (MaxFullscreenAdImpl.this.f20775k) {
                MaxFullscreenAdImpl.this.d();
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError maxError) {
            final boolean z11 = MaxFullscreenAdImpl.this.f20775k;
            MaxFullscreenAdImpl.this.f20775k = false;
            final ie ieVar = (ie) maxAd;
            MaxFullscreenAdImpl.this.a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.m
                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public final void a() {
                    this.f20839a.a(maxAd, z11, ieVar, maxError);
                }

                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public /* synthetic */ void a(MaxError maxError2) {
                    s.a(this, maxError2);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            final ie ieVar = (ie) maxAd;
            MaxFullscreenAdImpl.this.f20775k = false;
            MaxFullscreenAdImpl.this.sdk.f().a(ieVar);
            Integer num = (Integer) MaxFullscreenAdImpl.this.sdk.a(ve.M7);
            if (num.intValue() > 0) {
                MaxFullscreenAdImpl.this.sdk.j0().b(new jn(MaxFullscreenAdImpl.this.sdk, "ReportAdHiddenCallbackNotCalled", new Runnable() { // from class: com.applovin.impl.mediation.ads.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20847a.a(ieVar);
                    }
                }), tm.b.TIMEOUT, TimeUnit.SECONDS.toMillis(num.intValue()));
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f20775k = false;
            MaxFullscreenAdImpl.this.a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.n
                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public final void a() {
                    this.f20844a.a(maxAd);
                }

                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public /* synthetic */ void a(MaxError maxError) {
                    s.a(this, maxError);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.c();
            MaxFullscreenAdImpl.this.a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.r
                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public final void a() {
                    this.f20851a.a(str, maxError);
                }

                @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                public /* synthetic */ void a(MaxError maxError2) {
                    s.a(this, maxError2);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            ie ieVar;
            synchronized (MaxFullscreenAdImpl.this.f20769e) {
                ieVar = MaxFullscreenAdImpl.this.f20770f;
            }
            MaxFullscreenAdImpl.this.sdk.C().a(MaxFullscreenAdImpl.this.adUnitId);
            MaxFullscreenAdImpl.this.a((ie) maxAd);
            if (!MaxFullscreenAdImpl.this.f20772h.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.a(d.READY, new e() { // from class: com.applovin.impl.mediation.ads.q
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f20849a.b(maxAd);
                    }

                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public /* synthetic */ void a(MaxError maxError) {
                        s.a(this, maxError);
                    }
                });
                return;
            }
            MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
            if (MaxFullscreenAdImpl.this.f20773i.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.d();
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onExpiredAdReloaded(expiredAd=" + ieVar + ", newAd=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.expirationListener);
            }
            gc.a(MaxFullscreenAdImpl.this.expirationListener, (MaxAd) ieVar, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxFullscreenAdImpl.this.requestListener);
            }
            gc.a(MaxFullscreenAdImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.revenueListener);
            }
            gc.a(MaxFullscreenAdImpl.this.revenueListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoCompleted(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxRewardedAdListener.onRewardedVideoCompleted(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.g(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoStarted(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxRewardedAdListener.onRewardedVideoStarted(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.h(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxRewardedAdListener.onUserRewarded(ad=" + maxAd + ", reward=" + maxReward + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            gc.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum d {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a();

        void a(MaxError maxError);
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, b bVar, String str2, com.applovin.impl.sdk.j jVar, Context context) {
        super(str, maxAdFormat, str2, jVar);
        this.f20769e = new Object();
        this.f20770f = null;
        this.f20771g = d.IDLE;
        this.f20772h = new AtomicBoolean();
        this.f20773i = new AtomicBoolean();
        this.f20778n = new WeakReference(null);
        this.f20779o = new WeakReference(null);
        this.f20780p = new WeakReference(null);
        this.f20765a = bVar;
        this.f20767c = new c(this, null);
        this.f20768d = new com.applovin.impl.mediation.b(jVar);
        this.f20766b = new WeakReference(context);
        jVar.h().a(this);
        com.applovin.impl.sdk.n.g(str2, "Created new " + str2 + " (" + this + ")");
    }

    private void a() {
        ie ieVar;
        synchronized (this.f20769e) {
            ieVar = this.f20770f;
            this.f20770f = null;
        }
        this.sdk.Q().destroyAd(ieVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ie ieVar) {
        if (!this.sdk.f().a(ieVar, this)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loaded an expired ad, running expire logic...");
            }
            onAdExpired(ieVar);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Handle ad loaded for regular ad: " + ieVar);
        }
        this.f20770f = ieVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, e eVar) {
        boolean z11;
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1);
        d dVar2 = this.f20771g;
        synchronized (this.f20769e) {
            try {
                d dVar3 = d.IDLE;
                if (dVar2 != dVar3) {
                    d dVar4 = d.LOADING;
                    if (dVar2 == dVar4) {
                        if (dVar != dVar3) {
                            if (dVar == dVar4) {
                                maxErrorImpl = new MaxErrorImpl(-26, "An ad is already loading");
                                com.applovin.impl.sdk.n.h(this.tag, maxErrorImpl.getMessage());
                            } else if (dVar != d.READY) {
                                if (dVar == d.SHOWING) {
                                    com.applovin.impl.sdk.n.h(this.tag, "An ad is not ready to be shown yet");
                                } else if (dVar != d.DESTROYED) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "Unable to transition to: " + dVar);
                                    }
                                }
                            }
                            z11 = false;
                        }
                        z11 = true;
                    } else {
                        d dVar5 = d.READY;
                        if (dVar2 == dVar5) {
                            if (dVar != dVar3) {
                                if (dVar == dVar4) {
                                    com.applovin.impl.sdk.n.h(this.tag, "An ad is already loaded");
                                } else if (dVar == dVar5) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "An ad is already marked as ready");
                                    }
                                } else if (dVar != d.SHOWING && dVar != d.DESTROYED) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "Unable to transition to: " + dVar);
                                    }
                                }
                                z11 = false;
                            }
                            z11 = true;
                        } else {
                            d dVar6 = d.SHOWING;
                            if (dVar2 == dVar6) {
                                if (dVar != dVar3) {
                                    if (dVar == dVar4) {
                                        maxErrorImpl = new MaxErrorImpl(-27, "Can not load another ad while the ad is showing");
                                        com.applovin.impl.sdk.n.h(this.tag, maxErrorImpl.getMessage());
                                    } else if (dVar == dVar5) {
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.logger.b(this.tag, "An ad is already showing, ignoring");
                                        }
                                    } else if (dVar == dVar6) {
                                        com.applovin.impl.sdk.n.h(this.tag, "The ad is already showing, not showing another one");
                                    } else if (dVar != d.DESTROYED) {
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.logger.b(this.tag, "Unable to transition to: " + dVar);
                                        }
                                    }
                                }
                                z11 = true;
                            } else if (dVar2 == d.DESTROYED) {
                                com.applovin.impl.sdk.n.h(this.tag, "No operations are allowed on a destroyed instance");
                            } else if (com.applovin.impl.sdk.n.a()) {
                                this.logger.b(this.tag, "Unknown state: " + this.f20771g);
                            }
                            z11 = false;
                        }
                    }
                } else if (dVar == d.LOADING || dVar == d.DESTROYED) {
                    z11 = true;
                } else {
                    if (dVar == d.SHOWING) {
                        com.applovin.impl.sdk.n.h(this.tag, "No ad is loading or loaded");
                    } else if (com.applovin.impl.sdk.n.a()) {
                        this.logger.b(this.tag, "Unable to transition to: " + dVar);
                    }
                    z11 = false;
                }
                if (z11) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Transitioning from " + this.f20771g + " to " + dVar + "...");
                    }
                    this.f20771g = dVar;
                } else if (com.applovin.impl.sdk.n.a()) {
                    this.logger.k(this.tag, "Not allowed to transition from " + this.f20771g + " to " + dVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            eVar.a();
        } else {
            eVar.a(maxErrorImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.sdk.f().a((ie) maxAd);
        this.f20768d.a();
        a();
        this.sdk.T().a((ge) maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (this.f20773i.compareAndSet(true, false)) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to show an ad. Failed to load an ad in time to show.");
            this.sdk.C().c(this.adUnitId);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, "Failed to show an ad. Failed to load an ad in time to show.");
            lf lfVar = new lf(this.adUnitId, this.adFormat, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + lfVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            gc.a(this.adListener, (MaxAd) lfVar, (MaxError) maxErrorImpl, true);
            if (this.f20770f != null) {
                this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f20770f);
            }
        }
    }

    private void a(String str, String str2) {
        this.f20768d.e(this.f20770f);
        this.f20770f.g(str);
        this.f20770f.f(str2);
        this.f20776l = str;
        this.f20777m = str2;
        this.sdk.w().d(this.f20770f);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.f20770f + "...");
        }
        a((ge) this.f20770f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity) {
        a(str, str2);
        this.f20774j = false;
        this.f20778n = new WeakReference(activity);
        this.sdk.Q().showFullscreenAd(this.f20770f, activity, this.f20767c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity, ViewGroup viewGroup, Lifecycle lifecycle) {
        a(str, str2);
        this.f20774j = true;
        this.f20778n = new WeakReference(activity);
        this.f20779o = new WeakReference(viewGroup);
        this.f20780p = new WeakReference(lifecycle);
        this.sdk.Q().showFullscreenAd(this.f20770f, viewGroup, lifecycle, activity, this.f20767c);
    }

    private boolean a(Activity activity, final String str) {
        if (activity == null && MaxAdFormat.APP_OPEN != this.adFormat) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        }
        if (this.f20771g == d.DESTROYED) {
            boolean zC = yp.c(this.sdk);
            this.sdk.E().a(la.L, "attemptingToShowDestroyedAd", (Map) CollectionUtils.hashMap("details", "debug=" + zC));
            if (zC) {
                throw new IllegalStateException("Attempting to show ad that is destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (!isReady()) {
            String str2 = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            com.applovin.impl.sdk.n.h(this.tag, str2);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, str2);
            lf lfVar = new lf(this.adUnitId, this.adFormat, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + lfVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            gc.a(this.adListener, (MaxAd) lfVar, (MaxError) maxErrorImpl, true);
            if (this.f20770f != null) {
                this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f20770f);
            }
            return false;
        }
        Long l11 = (Long) this.sdk.a(ve.f23891n7);
        Long l12 = (Long) this.sdk.a(ve.f23884g7);
        if (l11.longValue() > 0 && (this.f20770f.getTimeToLiveMillis() < l12.longValue() || this.f20772h.get())) {
            this.f20773i.set(true);
            this.sdk.j0().a(new jn(this.sdk, "handleShowOnLoadTimeoutError", new Runnable() { // from class: com.applovin.impl.mediation.ads.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20831a.a(str);
                }
            }), tm.b.TIMEOUT, l11.longValue());
            return false;
        }
        if (yp.a(com.applovin.impl.sdk.j.l()) != 0 && this.sdk.g0().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
            if (yp.c(this.sdk)) {
                throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
            }
            if (((Boolean) this.sdk.a(ve.C7)).booleanValue()) {
                com.applovin.impl.sdk.n.h(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f20770f + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
                }
                gc.a(this.adListener, (MaxAd) this.f20770f, (MaxError) maxErrorImpl2, true);
                this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.f20770f);
                return false;
            }
        }
        if (!this.sdk.C().d() && !this.sdk.C().c()) {
            return true;
        }
        com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
        MaxErrorImpl maxErrorImpl3 = new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing");
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f20770f + ", error=" + maxErrorImpl3 + "), listener=" + this.adListener);
        }
        gc.a(this.adListener, (MaxAd) this.f20770f, (MaxError) maxErrorImpl3, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl3, this.f20770f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        synchronized (this.f20769e) {
            try {
                if (this.f20770f != null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Destroying ad for '" + this.adUnitId + "'; current ad: " + this.f20770f + "...");
                    }
                    this.sdk.Q().destroyAd(this.f20770f);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.sdk.h().b(this);
        this.f20768d.a();
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        ie ieVar = this.f20770f;
        a((MaxAd) ieVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + ieVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        gc.a(this.adListener, (MaxAd) ieVar, (MaxError) maxErrorImpl, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, ieVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ie ieVar;
        if (this.f20772h.compareAndSet(true, false)) {
            synchronized (this.f20769e) {
                ieVar = this.f20770f;
                this.f20770f = null;
            }
            this.sdk.Q().destroyAd(ieVar);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        ie ieVar = this.f20770f;
        a((MaxAd) ieVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + ieVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        gc.a(this.adListener, (MaxAd) ieVar, (MaxError) maxErrorImpl, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, ieVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Activity activityN0 = (Activity) this.f20778n.get();
        if (activityN0 == null) {
            activityN0 = this.sdk.n0();
        }
        Activity activity = activityN0;
        if (this.f20774j) {
            showAd(this.f20776l, this.f20777m, (ViewGroup) this.f20779o.get(), (Lifecycle) this.f20780p.get(), activity);
        } else {
            showAd(this.f20776l, this.f20777m, activity);
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        a(d.DESTROYED, new e() { // from class: com.applovin.impl.mediation.ads.g
            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public final void a() {
                this.f20822a.b();
            }

            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public /* synthetic */ void a(MaxError maxError) {
                s.a(this, maxError);
            }
        });
    }

    public boolean isReady() {
        boolean z11;
        synchronized (this.f20769e) {
            try {
                ie ieVar = this.f20770f;
                z11 = ieVar != null && ieVar.d0() && this.f20771g == d.READY;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z11) {
            this.sdk.C().c(this.adUnitId);
        }
        return z11;
    }

    public void loadAd() {
        loadAd(com.applovin.impl.mediation.d.b.PUBLISHER_INITIATED);
    }

    public void loadAd(com.applovin.impl.mediation.d.b bVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (this.f20771g == d.DESTROYED) {
            boolean zC = yp.c(this.sdk);
            this.sdk.E().a(la.L, "attemptingToLoadDestroyedAd", (Map) CollectionUtils.hashMap("details", "debug=" + zC));
            if (zC) {
                throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (!isReady()) {
            b bVar2 = this.f20765a;
            a(d.LOADING, new a(bVar2 != null ? bVar2.getActivity() : null, (Context) this.f20766b.get(), bVar));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "An ad is already loaded for '" + this.adUnitId + "'");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdLoaded(ad=" + this.f20770f + "), listener=" + this.adListener);
        }
        gc.f(this.adListener, (MaxAd) this.f20770f, true);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0199a
    public void onAdExpired(j8 j8Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Ad expired " + getAdUnitId());
        }
        this.f20772h.set(true);
        b bVar = this.f20765a;
        Activity activity = bVar != null ? bVar.getActivity() : null;
        if (activity == null && (activity = this.sdk.e().b()) == null) {
            c();
            this.f20767c.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
        } else {
            this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
            this.sdk.Q().loadAd(this.adUnitId, null, this.adFormat, com.applovin.impl.mediation.d.b.EXPIRED, this.localExtraParameters, this.extraParameters, activity, this.f20767c);
        }
    }

    @Override // com.applovin.impl.v.b
    public void onCreativeIdGenerated(String str, String str2) {
        ie ieVar = this.f20770f;
        if (ieVar == null || !ieVar.T().equalsIgnoreCase(str)) {
            return;
        }
        this.f20770f.h(str2);
        gc.b(this.adReviewListener, str2, this.f20770f);
    }

    public void showAd(final String str, final String str2, final Activity activity) {
        List listB = this.sdk.l0().b();
        if (!this.sdk.l0().d() || listB == null || listB.contains(this.f20770f.c())) {
            if (activity == null) {
                activity = this.sdk.n0();
            }
            if (a(activity, str)) {
                a(d.SHOWING, new e() { // from class: com.applovin.impl.mediation.ads.l
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f20835a.a(str, str2, activity);
                    }

                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public /* synthetic */ void a(MaxError maxError) {
                        s.a(this, maxError);
                    }
                });
                return;
            }
            return;
        }
        final String str3 = "Attempting to show ad from <" + this.f20770f.c() + "> which is not in the list of selected ad networks " + listB;
        com.applovin.impl.sdk.n.h(this.tag, str3);
        a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.k
            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public final void a() {
                this.f20833a.b(str3);
            }

            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public /* synthetic */ void a(MaxError maxError) {
                s.a(this, maxError);
            }
        });
    }

    public void showAd(final String str, final String str2, final ViewGroup viewGroup, final Lifecycle lifecycle, Activity activity) {
        if (viewGroup == null || lifecycle == null) {
            com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad with null containerView or lifecycle.");
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle.");
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f20770f + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            gc.a(this.adListener, (MaxAd) this.f20770f, (MaxError) maxErrorImpl, true);
            this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f20770f);
            return;
        }
        if (!viewGroup.isShown() && ((Boolean) this.sdk.a(ve.D7)).booleanValue()) {
            com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad when containerView and/or its ancestors are not visible");
            MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-1, "Attempting to show ad when containerView and/or its ancestors are not visible");
            gc.a(this.adListener, (MaxAd) this.f20770f, (MaxError) maxErrorImpl2, true);
            this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.f20770f);
            return;
        }
        List listB = this.sdk.l0().b();
        if (!this.sdk.l0().d() || listB == null || listB.contains(this.f20770f.c())) {
            if (activity == null) {
                activity = this.sdk.n0();
            }
            final Activity activity2 = activity;
            if (a(activity2, str)) {
                a(d.SHOWING, new e() { // from class: com.applovin.impl.mediation.ads.i
                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public final void a() {
                        this.f20825a.a(str, str2, activity2, viewGroup, lifecycle);
                    }

                    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
                    public /* synthetic */ void a(MaxError maxError) {
                        s.a(this, maxError);
                    }
                });
                return;
            }
            return;
        }
        final String str3 = "Attempting to show ad from <" + this.f20770f.c() + "> which is not in the list of selected ad networks " + listB;
        com.applovin.impl.sdk.n.h(this.tag, str3);
        a(d.IDLE, new e() { // from class: com.applovin.impl.mediation.ads.h
            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public final void a() {
                this.f20823a.c(str3);
            }

            @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.e
            public /* synthetic */ void a(MaxError maxError) {
                s.a(this, maxError);
            }
        });
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.tag);
        sb2.append("{adUnitId='");
        sb2.append(this.adUnitId);
        sb2.append('\'');
        sb2.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f20765a) {
            obj = "this";
        }
        sb2.append(obj);
        sb2.append(", revenueListener=");
        sb2.append(this.revenueListener);
        sb2.append(", requestListener");
        sb2.append(this.requestListener);
        sb2.append(", adReviewListener");
        sb2.append(this.adReviewListener);
        sb2.append(", isReady=");
        sb2.append(isReady());
        sb2.append('}');
        return sb2.toString();
    }
}
