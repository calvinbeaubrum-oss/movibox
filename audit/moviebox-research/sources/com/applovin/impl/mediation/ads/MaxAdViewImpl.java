package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.impl.ar;
import com.applovin.impl.br;
import com.applovin.impl.e0;
import com.applovin.impl.gc;
import com.applovin.impl.ge;
import com.applovin.impl.he;
import com.applovin.impl.jn;
import com.applovin.impl.la;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.v;
import com.applovin.impl.ve;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.impl.zq;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAdViewImpl extends com.applovin.impl.mediation.ads.a implements com.applovin.impl.sdk.d.a, br.a, v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f20735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxAdView f20736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f20738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f20739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private he f20740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f20741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f20742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b f20743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f20744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.sdk.d f20745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ar f20746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final br f20747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f20748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private he f20749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f20750p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f20751q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f20752r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f20753s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f20754t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f20755u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f20756v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f20757w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f20758x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f20759y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f20760z;

    /* JADX INFO: compiled from: source.java */
    public class b extends c {
        private b() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            gc.a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.a()) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.Q().destroyAd(maxAd);
                return;
            }
            he heVar = (he) maxAd;
            heVar.g(MaxAdViewImpl.this.f20741g);
            heVar.f(MaxAdViewImpl.this.f20742h);
            if (heVar.z() == null) {
                MaxAdViewImpl.this.sdk.Q().destroyAd(heVar);
                onAdLoadFailed(heVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
                return;
            }
            if (heVar.v0()) {
                long jQ0 = heVar.q0();
                MaxAdViewImpl.this.sdk.J();
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl.this.sdk.J().a(MaxAdViewImpl.this.tag, "Scheduling banner ad refresh " + jQ0 + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                }
                MaxAdViewImpl.this.f20745k.a(jQ0);
                if (MaxAdViewImpl.this.f20745k.g() || MaxAdViewImpl.this.f20751q) {
                    com.applovin.impl.sdk.n nVar2 = MaxAdViewImpl.this.logger;
                    if (com.applovin.impl.sdk.n.a()) {
                        MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                        maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Pausing ad refresh for publisher");
                    }
                    MaxAdViewImpl.this.f20745k.j();
                }
            }
            com.applovin.impl.sdk.n nVar3 = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                maxAdViewImpl3.logger.a(maxAdViewImpl3.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            gc.f(MaxAdViewImpl.this.adListener, maxAd, true);
            MaxAdViewImpl.this.d(heVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class c implements MaxAdListener, MaxAdViewAdListener, MaxAdRevenueListener, com.applovin.impl.mediation.ads.a.InterfaceC0188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f20762a;

        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f20749o)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                gc.a(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f20749o)) {
                if ((MaxAdViewImpl.this.f20749o.w0() || MaxAdViewImpl.this.f20758x) && this.f20762a) {
                    this.f20762a = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdCollapsed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                gc.b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.f20749o)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                gc.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f20749o)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                gc.c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f20749o)) {
                if ((MaxAdViewImpl.this.f20749o.w0() || MaxAdViewImpl.this.f20758x) && !MaxAdViewImpl.this.f20745k.g()) {
                    this.f20762a = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdExpanded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                gc.d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f20749o)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                gc.e(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxAdViewImpl.this.requestListener);
            }
            gc.a(MaxAdViewImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.revenueListener);
            }
            gc.a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends c {
        private d() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (!MaxAdViewImpl.this.f20754t) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Successfully pre-cached ad for refresh");
                }
                MaxAdViewImpl.this.a(maxAd);
                return;
            }
            com.applovin.impl.sdk.n nVar2 = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
            }
            MaxAdViewImpl.this.sdk.Q().destroyAd(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, com.applovin.impl.sdk.j jVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", jVar);
        this.f20737c = UUID.randomUUID().toString().toLowerCase(Locale.US);
        this.f20739e = Long.MAX_VALUE;
        this.f20748n = new Object();
        this.f20749o = null;
        this.f20754t = false;
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f20735a = context.getApplicationContext();
        this.f20736b = maxAdView;
        this.f20738d = view;
        this.f20743i = new b();
        this.f20744j = new d();
        this.f20745k = new com.applovin.impl.sdk.d(jVar, this);
        this.f20746l = new ar(maxAdView, jVar);
        this.f20747m = new br(maxAdView, jVar, this);
        jVar.h().a(this);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Created new MaxAdView (" + this + ")");
        }
    }

    private void a(long j11) {
        if (!yp.a(j11, ((Long) this.sdk.a(ve.f23882e7)).longValue()) || this.f20759y) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "No undesired viewability flags matched or forcing pre-cache - scheduling viewability");
            }
            this.f20750p = false;
            d();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Undesired flags matched - current: " + Long.toBinaryString(j11) + ", undesired: " + Long.toBinaryString(j11));
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Waiting for refresh timer to manually fire request");
        }
        this.f20750p = true;
    }

    private void a(View view, he heVar) {
        int iU0 = heVar.u0();
        int iS0 = heVar.s0();
        int iDpToPx = iU0 == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), iU0);
        int iDpToPx2 = iS0 != -1 ? AppLovinSdkUtils.dpToPx(view.getContext(), iS0) : -1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx2);
        } else {
            layoutParams.width = iDpToPx;
            layoutParams.height = iDpToPx2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Pinning ad view to MAX ad view with width: " + iDpToPx + " and height: " + iDpToPx2 + InstructionFileId.DOT);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int i11 : zq.a(this.f20736b.getGravity(), 10, 14)) {
                layoutParams2.addRule(i11);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(he heVar) {
        long jA = this.f20746l.a(heVar);
        if (!heVar.p0()) {
            a(heVar, jA);
        }
        a(jA);
    }

    private void a(he heVar, long j11) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.Q().processViewabilityAdImpressionPostback(heVar, j11, this.f20743i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a, com.applovin.impl.mediation.d.b bVar) {
        he heVar = this.f20749o;
        if (heVar != null) {
            long jA = this.f20746l.a(heVar);
            this.extraParameters.put("visible_ad_ad_unit_id", this.f20749o.getAdUnitId());
            this.extraParameters.put("viewability_flags", Long.valueOf(jA));
        } else {
            this.extraParameters.remove("visible_ad_ad_unit_id");
            this.extraParameters.remove("viewability_flags");
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f20736b.getContext(), this.f20736b.getWidth());
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f20736b.getContext(), this.f20736b.getHeight());
        this.extraParameters.put("viewport_width", Integer.valueOf(iPxToDp));
        this.extraParameters.put("viewport_height", Integer.valueOf(iPxToDp2));
        this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(this.f20745k.g() || this.f20751q));
        this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(this.f20756v));
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading " + this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + this.adUnitId + "' and notifying " + interfaceC0188a + "...");
        }
        this.sdk.Q().loadAd(this.adUnitId, this.f20737c, this.adFormat, bVar, this.localExtraParameters, this.extraParameters, this.f20735a, interfaceC0188a);
    }

    private void a(final com.applovin.impl.mediation.d.b bVar, final com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        if (!a()) {
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20816a.a(interfaceC0188a, bVar);
                }
            });
            return;
        }
        boolean zC = yp.c(this.sdk);
        this.sdk.E().a(la.L, "attemptingToLoadDestroyedAdView", (Map) CollectionUtils.hashMap("details", "debug=" + zC));
        if (!zC) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to load new ad - this instance is already destroyed");
            return;
        }
        throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.f20753s = false;
        if (!this.f20752r) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Saving pre-cache ad...");
            }
            he heVar = (he) maxAd;
            this.f20740f = heVar;
            heVar.g(this.f20741g);
            this.f20740f.f(this.f20742h);
            return;
        }
        this.f20752r = false;
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
        }
        this.f20743i.onAdLoaded(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxError maxError) {
        if (a()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Ad load failure with ad unit ID '" + this.adUnitId + "' occured after MaxAdView was destroyed.");
                return;
            }
            return;
        }
        if (this.sdk.c(ve.U6).contains(String.valueOf(maxError.getCode()))) {
            this.sdk.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.J().a(this.tag, "Ignoring banner ad refresh for error code " + maxError.getCode());
                return;
            }
            return;
        }
        if (!this.f20751q && !this.f20745k.g()) {
            this.f20750p = true;
            this.f20753s = false;
            long jLongValue = ((Long) this.sdk.a(ve.T6)).longValue();
            if (jLongValue >= 0) {
                this.sdk.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.J().a(this.tag, "Scheduling failed banner ad refresh " + jLongValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.f20745k.a(jLongValue);
                return;
            }
            return;
        }
        if (this.f20753s) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refresh pre-cache failed when auto-refresh is stopped");
            }
            this.f20753s = false;
        }
        if (this.f20752r) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refresh pre-cache failed - MaxAdListener.onAdLoadFailed(adUnitId=" + this.adUnitId + ", error=" + maxError + "), listener=" + this.adListener);
            }
            gc.a(this.adListener, this.adUnitId, maxError, true);
        }
    }

    private void a(String str, String str2) {
        if ("allow_pause_auto_refresh_immediately".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.f20755u = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_auto_retries".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated disable auto-retries to: " + str2);
            }
            this.f20756v = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_precache".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated precached disabled to: " + str2);
            }
            this.f20757w = Boolean.parseBoolean(str2);
            return;
        }
        if ("should_stop_auto_refresh_on_ad_expand".equals(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.f20758x = Boolean.parseBoolean(str2);
            return;
        }
        if ("force_precache".equals(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated force precache to: " + str2);
            }
            this.f20759y = Boolean.parseBoolean(str2);
            return;
        }
        if ("adaptive_banner".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated is adaptive banner to: " + str2);
            }
            this.f20760z = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        boolean z11;
        synchronized (this.f20748n) {
            z11 = this.f20754t;
        }
        return z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final he heVar) {
        View viewZ = heVar.z();
        String str = viewZ == null ? "MaxAdView does not have a loaded ad view" : null;
        MaxAdView maxAdView = this.f20736b;
        if (maxAdView == null) {
            str = "MaxAdView does not have a parent view";
        }
        if (str != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, str);
            }
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + heVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            gc.a(this.adListener, (MaxAd) heVar, (MaxError) maxErrorImpl, true);
            this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, heVar);
            return;
        }
        e();
        a((ge) heVar);
        if (heVar.p0()) {
            this.f20747m.a(heVar);
        }
        maxAdView.setDescendantFocusability(393216);
        if (heVar.r0() != Long.MAX_VALUE) {
            this.f20738d.setBackgroundColor((int) heVar.r0());
        } else {
            long j11 = this.f20739e;
            if (j11 != Long.MAX_VALUE) {
                this.f20738d.setBackgroundColor((int) j11);
            } else {
                this.f20738d.setBackgroundColor(0);
            }
        }
        maxAdView.addView(viewZ);
        a(viewZ, heVar);
        this.sdk.w().d(heVar);
        c(heVar);
        synchronized (this.f20748n) {
            this.f20749o = heVar;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Scheduling impression for ad manually...");
        }
        this.sdk.Q().processRawAdImpression(heVar, this.f20743i);
        if (StringUtils.isValidString(this.f20749o.getAdReviewCreativeId())) {
            gc.a(this.adReviewListener, this.f20749o.getAdReviewCreativeId(), (MaxAd) this.f20749o, true);
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.ads.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f20814a.a(heVar);
            }
        }, heVar.t0());
    }

    private boolean b() {
        if (this.f20757w) {
            return false;
        }
        return ((Boolean) this.sdk.a(ve.f23883f7)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading ad for pre-cache request...");
        }
        a(com.applovin.impl.mediation.d.b.SEQUENTIAL_OR_PRECACHE, this.f20744j);
    }

    private void c(he heVar) {
        int height = this.f20736b.getHeight();
        int width = this.f20736b.getWidth();
        if (height > 0 || width > 0) {
            int iPxToDp = AppLovinSdkUtils.pxToDp(this.f20735a, height);
            int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f20735a, width);
            MaxAdFormat format = heVar.getFormat();
            int height2 = (this.f20760z ? format.getAdaptiveSize(iPxToDp2, this.f20736b.getContext()) : format.getSize()).getHeight();
            int iMin = Math.min(format.getSize().getWidth(), z3.b(this.f20735a).x);
            if (iPxToDp < height2 || iPxToDp2 < iMin) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\n**************************************************\n`MaxAdView` size ");
                sb2.append(iPxToDp2);
                sb2.append("x");
                sb2.append(iPxToDp);
                sb2.append(" dp smaller than required ");
                sb2.append(this.f20760z ? "adaptive " : "");
                sb2.append("size: ");
                sb2.append(iMin);
                sb2.append("x");
                sb2.append(height2);
                sb2.append(" dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n");
                String string = sb2.toString();
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.b("AppLovinSdk", string);
                }
            }
        }
    }

    private void d() {
        if (b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Scheduling refresh precache request now");
            }
            this.f20753s = true;
            this.sdk.j0().a((yl) new jn(this.sdk, "loadMaxAdForPrecacheRequest", new Runnable() { // from class: com.applovin.impl.mediation.ads.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20821a.c();
                }
            }), tm.b.MEDIATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final he heVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f20819a.b(heVar);
            }
        });
    }

    private void e() {
        he heVar;
        MaxAdView maxAdView = this.f20736b;
        if (maxAdView != null) {
            e0.a(maxAdView, this.f20738d);
        }
        this.f20747m.b();
        synchronized (this.f20748n) {
            heVar = this.f20749o;
        }
        if (heVar != null) {
            this.sdk.Q().destroyAd(heVar);
        }
    }

    private void f() {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Rendering for cached ad: " + this.f20740f + "...");
        }
        this.f20743i.onAdLoaded(this.f20740f);
        this.f20740f = null;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        e();
        if (this.f20740f != null) {
            this.sdk.Q().destroyAd(this.f20740f);
        }
        synchronized (this.f20748n) {
            this.f20754t = true;
        }
        this.f20745k.a();
        this.sdk.h().b(this);
        this.sdk.K().c(this.adUnitId, this.f20737c);
        super.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f20741g;
    }

    public void loadAd() {
        loadAd(com.applovin.impl.mediation.d.b.PUBLISHER_INITIATED);
    }

    public void loadAd(com.applovin.impl.mediation.d.b bVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "" + this + " Loading ad for " + this.adUnitId + "...");
        }
        boolean z11 = this.f20755u || ((Boolean) this.sdk.a(ve.f23878a7)).booleanValue();
        if (z11 && !this.f20745k.g() && this.f20745k.h()) {
            com.applovin.impl.sdk.n.h(this.tag, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.f20745k.b()) + " seconds.");
            return;
        }
        if (!z11) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(bVar, this.f20743i);
        } else if (this.f20740f != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering cached ad");
            }
            f();
        } else if (this.f20753s) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Waiting for precache ad to load to render");
            }
            this.f20752r = true;
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(bVar, this.f20743i);
        }
    }

    @Override // com.applovin.impl.sdk.d.a
    public void onAdRefresh() {
        this.f20752r = false;
        if (this.f20740f != null) {
            f();
            return;
        }
        if (!b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refreshing ad from network...");
            }
            loadAd(com.applovin.impl.mediation.d.b.REFRESH);
        } else if (this.f20750p) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
            }
            loadAd(com.applovin.impl.mediation.d.b.REFRESH);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.f20752r = true;
        }
    }

    @Override // com.applovin.impl.v.b
    public void onCreativeIdGenerated(String str, String str2) {
        he heVar = this.f20749o;
        if (heVar != null && heVar.T().equalsIgnoreCase(str)) {
            this.f20749o.h(str2);
            gc.b(this.adReviewListener, str2, this.f20749o);
            return;
        }
        he heVar2 = this.f20740f;
        if (heVar2 == null || !heVar2.T().equalsIgnoreCase(str)) {
            return;
        }
        this.f20740f.h(str2);
    }

    @Override // com.applovin.impl.br.a
    public void onLogVisibilityImpression() {
        a(this.f20749o, this.f20746l.a(this.f20749o));
    }

    public void onWindowVisibilityChanged(int i11) {
        if (((Boolean) this.sdk.a(ve.Y6)).booleanValue() && this.f20745k.h()) {
            if (zq.b(i11)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Ad view visible");
                }
                this.f20745k.d();
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Ad view hidden");
                }
                this.f20745k.c();
            }
        }
    }

    public void setCustomData(String str) {
        if (this.f20749o != null && com.applovin.impl.sdk.n.a()) {
            this.logger.k(this.tag, "Setting custom data (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        yp.b(str, this.tag);
        this.f20742h = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        a(str, str2);
    }

    public void setPlacement(String str) {
        if (this.f20749o != null && com.applovin.impl.sdk.n.a()) {
            this.logger.k(this.tag, "Setting placement (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        this.f20741g = str;
    }

    public void setPublisherBackgroundColor(int i11) {
        this.f20739e = i11;
    }

    public void startAutoRefresh() {
        this.f20751q = false;
        if (!this.f20745k.g()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Ignoring call to startAutoRefresh() - ad refresh is not paused");
                return;
            }
            return;
        }
        this.f20745k.m();
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Resumed auto-refresh with remaining time: " + this.f20745k.b() + "ms");
        }
    }

    public void stopAutoRefresh() {
        if (this.f20749o == null) {
            if (this.f20755u || ((Boolean) this.sdk.a(ve.f23878a7)).booleanValue()) {
                this.f20751q = true;
                return;
            } else {
                com.applovin.impl.sdk.n.j(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Pausing auto-refresh with remaining time: " + this.f20745k.b() + "ms");
        }
        this.f20745k.j();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MaxAdView{adUnitId='");
        sb2.append(this.adUnitId);
        sb2.append('\'');
        sb2.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f20736b) {
            obj = "this";
        }
        sb2.append(obj);
        sb2.append(", isDestroyed=");
        sb2.append(a());
        sb2.append('}');
        return sb2.toString();
    }
}
