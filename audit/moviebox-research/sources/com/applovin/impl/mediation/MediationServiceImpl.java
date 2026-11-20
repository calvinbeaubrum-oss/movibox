package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.an;
import com.applovin.impl.ca;
import com.applovin.impl.fi;
import com.applovin.impl.fn;
import com.applovin.impl.gc;
import com.applovin.impl.ge;
import com.applovin.impl.ie;
import com.applovin.impl.la;
import com.applovin.impl.ln;
import com.applovin.impl.ma;
import com.applovin.impl.ne;
import com.applovin.impl.pe;
import com.applovin.impl.rm;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.ve;
import com.applovin.impl.we;
import com.applovin.impl.xe;
import com.applovin.impl.xj;
import com.applovin.impl.yj;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zj;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f20706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final xj f20707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f20708d = new AtomicReference();

    /* JADX INFO: compiled from: source.java */
    public class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f20709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f20711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ zj f20712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MaxAdFormat f20713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ yj.a f20714f;

        public a(g gVar, String str, long j11, zj zjVar, MaxAdFormat maxAdFormat, yj.a aVar) {
            this.f20709a = gVar;
            this.f20710b = str;
            this.f20711c = j11;
            this.f20712d = zjVar;
            this.f20713e = maxAdFormat;
            this.f20714f = aVar;
        }

        @Override // com.applovin.impl.mediation.g.b
        public void a(MaxError maxError) {
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f20706b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f20706b.b("MediationService", "Signal collection failed from: " + this.f20709a.g() + " for Ad Unit ID: " + this.f20710b + " with error message: \"" + maxError.getMessage() + "\"");
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = this.f20711c;
            yj yjVarA = yj.a(this.f20712d, this.f20709a, maxError, j11, jElapsedRealtime - j11);
            MediationServiceImpl.this.a(yjVarA, this.f20712d, this.f20709a);
            this.f20714f.a(yjVarA);
            this.f20709a.a();
        }

        @Override // com.applovin.impl.mediation.g.b
        public void onSignalCollected(String str) {
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f20706b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f20706b.a("MediationService", "Signal collection successful from: " + this.f20709a.g() + " for Ad Unit ID: " + this.f20710b + " with signal: \"" + str + "\"");
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = this.f20711c;
            long j12 = jElapsedRealtime - j11;
            yj yjVarA = yj.a(this.f20712d, this.f20709a, str, j11, j12);
            MediationServiceImpl.this.f20707c.a(yjVarA, this.f20712d, this.f20710b, this.f20713e);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("network_name", this.f20712d.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", this.f20712d.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", this.f20709a.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j12), map);
            CollectionUtils.putStringIfValid("ad_format", String.valueOf(this.f20713e.getLabel()), map);
            CollectionUtils.putStringIfValid("ad_unit_id", this.f20710b, map);
            MediationServiceImpl.this.f20705a.E().a(la.f20387p, (Map) map);
            this.f20714f.a(yjVarA);
            this.f20709a.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ fi f20716a;

        public b(fi fiVar) {
            this.f20716a = fiVar;
        }

        @Override // com.applovin.impl.mediation.g.b
        public void a(MaxError maxError) {
            this.f20716a.a(maxError);
        }

        @Override // com.applovin.impl.mediation.g.b
        public void onSignalCollected(String str) {
            this.f20716a.b(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20718a;

        static {
            int[] iArr = new int[MaxAdapter.InitializationStatus.values().length];
            f20718a = iArr;
            try {
                iArr[MaxAdapter.InitializationStatus.DOES_NOT_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20718a[MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20718a[MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20718a[MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20718a[MaxAdapter.InitializationStatus.NOT_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20718a[MaxAdapter.InitializationStatus.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, com.applovin.impl.mediation.ads.a.InterfaceC0188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ge f20719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.applovin.impl.mediation.ads.a.InterfaceC0188a f20720b;

        public d(ge geVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
            this.f20719a = geVar;
            this.f20720b = interfaceC0188a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f20705a.C().b(maxAd);
            }
            gc.e(this.f20720b, maxAd);
        }

        public void a(com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
            this.f20720b = interfaceC0188a;
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f20719a.a(bundle);
            MediationServiceImpl.this.f20705a.j().a(this.f20719a, com.applovin.impl.sdk.e.c.CLICK);
            MediationServiceImpl.this.a(this.f20719a, this.f20720b);
            gc.a((MaxAdListener) this.f20720b, maxAd);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.f20719a.a(bundle);
            MediationServiceImpl.this.a(this.f20719a, maxError, this.f20720b);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof ie)) {
                ((ie) maxAd).i0();
            }
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.f20719a.a(bundle);
            gc.a(this.f20720b, maxAd, maxReward);
            MediationServiceImpl.this.f20705a.j0().a((yl) new fn((ie) maxAd, MediationServiceImpl.this.f20705a), tm.b.OTHER);
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.f20719a.a(bundle);
            gc.b(this.f20720b, maxAd);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.f20719a.a(bundle);
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f20706b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f20706b.a("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f20719a, this.f20720b);
            if (!((Boolean) MediationServiceImpl.this.f20705a.a(ve.Q7)).booleanValue() || this.f20719a.v().compareAndSet(false, true)) {
                MediationServiceImpl.this.f20705a.j().a(this.f20719a, com.applovin.impl.sdk.e.c.SHOW);
                MediationServiceImpl.this.f20705a.D().c(ca.f18149f);
                MediationServiceImpl.this.f20705a.D().c(ca.f18152i);
                if (!maxAd.getFormat().isFullscreenAd()) {
                    MediationServiceImpl.this.f20705a.p().b(this.f20719a, "DID_DISPLAY");
                    gc.c(this.f20720b, maxAd);
                    return;
                }
                ie ieVar = (ie) maxAd;
                if (ieVar.t0()) {
                    MediationServiceImpl.this.f20705a.p().b(this.f20719a, "DID_DISPLAY");
                    MediationServiceImpl.this.f20705a.C().a(this.f20719a);
                    gc.c(this.f20720b, maxAd);
                    return;
                }
                com.applovin.impl.sdk.n unused2 = MediationServiceImpl.this.f20706b;
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVar = MediationServiceImpl.this.f20706b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Received ad display callback before attempting show");
                    sb2.append(ieVar.b0() ? " for hybrid ad" : "");
                    nVar.k("MediationService", sb2.toString());
                }
            }
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.f20719a.a(bundle);
            gc.d(this.f20720b, maxAd);
        }

        public void e(final MaxAd maxAd, Bundle bundle) {
            this.f20719a.a(bundle);
            MediationServiceImpl.this.f20705a.E().a(la.A, this.f20719a);
            MediationServiceImpl.this.f20705a.j().a(this.f20719a, com.applovin.impl.sdk.e.c.HIDE);
            MediationServiceImpl.this.f20705a.p().b((ge) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21099a.a(maxAd);
                }
            }, maxAd instanceof ie ? ((ie) maxAd).k0() : 0L);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.f20719a.a(bundle);
            this.f20719a.g0();
            MediationServiceImpl.this.f20705a.j().a(this.f20719a, com.applovin.impl.sdk.e.c.LOAD);
            MediationServiceImpl.this.a(this.f20719a);
            gc.f(this.f20720b, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            a(maxAd, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            c(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            d(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            e(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f20719a.g0();
            MediationServiceImpl.this.b(this.f20719a, maxError, this.f20720b);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            f(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoCompleted(MaxAd maxAd) {
            gc.g(this.f20720b, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoStarted(MaxAd maxAd) {
            gc.h(this.f20720b, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }
    }

    public MediationServiceImpl(com.applovin.impl.sdk.j jVar) {
        this.f20705a = jVar;
        this.f20706b = jVar.J();
        this.f20707c = new xj(jVar);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j11, g gVar, String str, zj zjVar, MaxAdFormat maxAdFormat, yj.a aVar, boolean z11, String str2, MaxError maxError) {
        yj yjVarA;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j11;
        if (z11) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20706b.a("MediationService", "Signal collection successful from: " + gVar.g() + " for Ad Unit ID: " + str + " with signal: \"" + str2 + "\"");
            }
            yjVarA = yj.a(zjVar, gVar, str2, j11, jElapsedRealtime);
            this.f20707c.a(yjVarA, zjVar, str, maxAdFormat);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("network_name", zjVar.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", zjVar.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", gVar.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jElapsedRealtime), map);
            CollectionUtils.putStringIfValid("ad_format", String.valueOf(maxAdFormat.getLabel()), map);
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            this.f20705a.E().a(la.f20387p, (Map) map);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20706b.b("MediationService", "Signal collection failed from: " + gVar.g() + " for Ad Unit ID: " + str + " with error message: \"" + maxError.getMessage() + "\"");
            }
            yjVarA = yj.a(zjVar, gVar, maxError, j11, jElapsedRealtime);
            a(yjVarA, zjVar, gVar);
        }
        aVar.a(yjVarA);
        gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(fi fiVar, g gVar, MaxAdapterParametersImpl maxAdapterParametersImpl, zj zjVar, Activity activity, g.b bVar) {
        if (fiVar.c()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.a("MediationService", "Collecting signal for now-initialized adapter: " + gVar.g());
        }
        gVar.a(maxAdapterParametersImpl, zjVar, activity, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ge geVar) {
        this.f20705a.p().b(geVar, "DID_LOAD");
        if (geVar.R().endsWith("load")) {
            this.f20705a.p().b(geVar);
        }
        HashMap map = new HashMap(3);
        long jH = geVar.H();
        map.put("{LOAD_TIME_MS}", String.valueOf(jH));
        if (geVar.getFormat().isFullscreenAd()) {
            com.applovin.impl.sdk.m.a aVarB = this.f20705a.C().b(geVar.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("load", map, geVar);
        Map mapA = ma.a(geVar);
        mapA.put("duration_ms", String.valueOf(jH));
        this.f20705a.E().a(la.f20393v, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ge geVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        this.f20705a.p().b(geVar, "DID_CLICKED");
        this.f20705a.p().b(geVar, "DID_CLICK");
        if (geVar.R().endsWith("click")) {
            this.f20705a.p().b(geVar);
            gc.a((MaxAdRevenueListener) interfaceC0188a, (MaxAd) geVar);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f20705a.q0().c());
        if (!((Boolean) this.f20705a.a(sj.R3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclick", map, geVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ge geVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a, String str) {
        String str2 = "Failed to load " + geVar + ": adapter init failed with error: " + str;
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.k("MediationService", str2);
        }
        b(geVar, new MaxErrorImpl(MaxAdapterError.NOT_INITIALIZED.getErrorCode(), "Adapter initialization failed"), interfaceC0188a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ge geVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.f20705a.j().a(geVar, com.applovin.impl.sdk.e.c.SHOW_ERROR);
        this.f20705a.p().b(geVar, "DID_FAIL_DISPLAY");
        a(maxError, geVar, true);
        if (geVar.v().compareAndSet(false, true)) {
            gc.a(maxAdListener, geVar, maxError);
        }
    }

    private void a(ie ieVar) {
        if (ieVar.getFormat() == MaxAdFormat.REWARDED || ieVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.f20705a.j0().a((yl) new ln(ieVar, this.f20705a), tm.b.OTHER);
        }
    }

    private void a(ie ieVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        this.f20705a.C().a(false);
        a(ieVar, (MaxAdListener) interfaceC0188a);
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.a("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpression(ieVar, interfaceC0188a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ie ieVar, g gVar, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        ieVar.a(true);
        a(ieVar);
        gVar.c(ieVar, activity);
        a(ieVar, interfaceC0188a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ie ieVar, g gVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        ieVar.a(true);
        a(ieVar);
        gVar.a(ieVar, viewGroup, lifecycle, activity);
        a(ieVar, interfaceC0188a);
    }

    private void a(final ie ieVar, final MaxAdListener maxAdListener) {
        final Long l11 = (Long) this.f20705a.a(ve.f23890m7);
        if (l11.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f21065a.a(ieVar, l11, maxAdListener);
            }
        }, l11.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ie ieVar, Long l11, MaxAdListener maxAdListener) {
        if (ieVar.v().get()) {
            return;
        }
        String str = "Ad (" + ieVar.k() + ") has not been displayed after " + l11 + "ms. Failing ad display...";
        com.applovin.impl.sdk.n.h("MediationService", str);
        a(ieVar, new MaxErrorImpl(-1, str), maxAdListener);
        this.f20705a.C().b(ieVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, fi fiVar, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + gVar.g());
        }
        fiVar.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_NOT_INITIALIZED, "Could not initialize adapter: " + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, String str, MaxAdapterParametersImpl maxAdapterParametersImpl, ge geVar, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        gVar.a(str, maxAdapterParametersImpl, geVar, activity, new d(geVar, interfaceC0188a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(yj yjVar, zj zjVar, g gVar) {
        long jB = yjVar.b();
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(jB));
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", gVar.b(), map);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", gVar.i(), map);
        a("serr", map, yjVar.c(), zjVar);
        HashMap map2 = new HashMap();
        CollectionUtils.putStringIfValid("network_name", zjVar.c(), map2);
        CollectionUtils.putStringIfValid("adapter_class", zjVar.b(), map2);
        CollectionUtils.putStringIfValid("adapter_version", gVar.b(), map2);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jB), map2);
        this.f20705a.E().a(la.f20388q, (Map) map2);
    }

    private void a(MaxError maxError, ge geVar) {
        HashMap map = new HashMap(3);
        long jH = geVar.H();
        map.put("{LOAD_TIME_MS}", String.valueOf(jH));
        if (geVar.getFormat().isFullscreenAd()) {
            com.applovin.impl.sdk.m.a aVarB = this.f20705a.C().b(geVar.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("mlerr", map, maxError, geVar);
        Map mapA = ma.a(geVar);
        mapA.putAll(ma.a(maxError));
        mapA.put("duration_ms", String.valueOf(jH));
        this.f20705a.E().a(la.f20394w, mapA);
    }

    private void a(MaxError maxError, ge geVar, boolean z11) {
        a("mierr", Collections.EMPTY_MAP, maxError, geVar, z11);
        if (!z11 || geVar == null) {
            return;
        }
        this.f20705a.E().a(la.f20397z, geVar, maxError);
    }

    private void a(final String str, final MaxAdFormat maxAdFormat, final zj zjVar, Context context, final yj.a aVar, final g gVar) {
        final fi fiVar = new fi();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        fiVar.a(new fi.b() { // from class: com.applovin.impl.mediation.m
            @Override // com.applovin.impl.fi.b
            public final void a(boolean z11, Object obj, Object obj2) {
                this.f21075a.a(jElapsedRealtime, gVar, str, zjVar, maxAdFormat, aVar, z11, (String) obj, (MaxError) obj2);
            }
        });
        an.a(zjVar.m(), fiVar, new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + zjVar.c() + ") timed out collecting signal"), "MediationService", this.f20705a);
        final g.b bVar = new b(fiVar);
        final Activity activityN0 = context instanceof Activity ? (Activity) context : this.f20705a.n0();
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(zjVar, str, maxAdFormat);
        if (zjVar.w()) {
            fi fiVarA = this.f20705a.L().a(zjVar, activityN0);
            fiVarA.a(new Runnable() { // from class: com.applovin.impl.mediation.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21086a.a(fiVar, gVar, maxAdapterParametersImplA, zjVar, activityN0, bVar);
                }
            });
            fiVarA.a(new fi.a() { // from class: com.applovin.impl.mediation.o
                @Override // com.applovin.impl.fi.a
                public final void a(Object obj) {
                    this.f21094a.a(gVar, fiVar, (String) obj);
                }
            });
            return;
        }
        if (zjVar.x()) {
            fi fiVarA2 = this.f20705a.L().a(zjVar, activityN0);
            if (fiVarA2.d()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20706b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + gVar.g());
                }
                fiVar.a(new MaxErrorImpl("Could not initialize adapter: " + ((String) fiVarA2.a())));
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.a("MediationService", "Collecting signal for adapter: " + gVar.g());
        }
        gVar.a(maxAdapterParametersImplA, zjVar, activityN0, bVar);
    }

    private void a(String str, List list, Map map, Map map2, MaxError maxError, pe peVar, boolean z11) {
        this.f20705a.j0().a((yl) new rm(str, list, map, map2, maxError, peVar, this.f20705a, z11), tm.b.OTHER);
    }

    private void a(String str, Map map, pe peVar) {
        a(str, map, (MaxError) null, peVar);
    }

    private void a(String str, Map map, MaxError maxError, pe peVar) {
        a(str, map, maxError, peVar, true);
    }

    private void a(String str, Map map, MaxError maxError, pe peVar, boolean z11) {
        Map map2 = CollectionUtils.map(map);
        map2.put("{PLACEMENT}", z11 ? StringUtils.emptyIfNull(peVar.getPlacement()) : "");
        map2.put("{CUSTOM_DATA}", z11 ? StringUtils.emptyIfNull(peVar.e()) : "");
        if (peVar instanceof ge) {
            map2.put("{CREATIVE_ID}", z11 ? StringUtils.emptyIfNull(((ge) peVar).getCreativeId()) : "");
        }
        a(str, null, map2, null, maxError, peVar, z11);
    }

    private g b(ie ieVar) {
        g gVarB = ieVar.B();
        if (gVarB != null) {
            return gVarB;
        }
        this.f20705a.C().a(false);
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.k("MediationService", "Failed to show " + ieVar + ": adapter not found");
        }
        com.applovin.impl.sdk.n.h("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + ieVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ge geVar, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, geVar);
        destroyAd(geVar);
        gc.a(maxAdListener, geVar.getAdUnitId(), maxError);
    }

    public void collectSignal(String str, MaxAdFormat maxAdFormat, zj zjVar, Context context, yj.a aVar) {
        if (zjVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        yj yjVarB = this.f20707c.b(zjVar, str, maxAdFormat);
        if (yjVarB != null) {
            aVar.a(yj.a(yjVarB));
            return;
        }
        g gVarA = this.f20705a.M().a(zjVar, zjVar.A());
        if (gVarA == null) {
            aVar.a(yj.a(zjVar, new MaxErrorImpl("Could not load adapter")));
            return;
        }
        if (((Boolean) this.f20705a.a(ve.P7)).booleanValue()) {
            a(str, maxAdFormat, zjVar, context, aVar, gVarA);
            return;
        }
        Activity activityN0 = context instanceof Activity ? (Activity) context : this.f20705a.n0();
        MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(zjVar, str, maxAdFormat);
        if (zjVar.z()) {
            this.f20705a.L().b(zjVar, activityN0);
        }
        a aVar2 = new a(gVarA, str, SystemClock.elapsedRealtime(), zjVar, maxAdFormat, aVar);
        if (!zjVar.w()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20706b.a("MediationService", "Collecting signal for adapter: " + gVarA.g());
            }
            gVarA.a(maxAdapterParametersImplA, zjVar, activityN0, aVar2);
            return;
        }
        if (this.f20705a.L().b(zjVar)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20706b.a("MediationService", "Collecting signal for now-initialized adapter: " + gVarA.g());
            }
            gVarA.a(maxAdapterParametersImplA, zjVar, activityN0, aVar2);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.b("MediationService", "Skip collecting signal for not-initialized adapter: " + gVarA.g());
        }
        aVar.a(yj.a(zjVar, new MaxErrorImpl("Adapter not initialized yet")));
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof ge) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20706b.d("MediationService", "Destroying " + maxAd);
            }
            ge geVar = (ge) maxAd;
            g gVarB = geVar.B();
            if (gVarB != null) {
                gVarB.a();
                geVar.u();
            }
            this.f20705a.h().c(geVar.T());
            this.f20705a.j().a(geVar, com.applovin.impl.sdk.e.c.DESTROY);
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return (JSONObject) this.f20708d.getAndSet(null);
    }

    public void loadAd(String str, @Nullable String str2, MaxAdFormat maxAdFormat, com.applovin.impl.mediation.d.b bVar, Map<String, Object> map, Map<String, Object> map2, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        List<String> adUnitIds;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0188a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f20705a.O())) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
        }
        if (!this.f20705a.u0()) {
            com.applovin.impl.sdk.n.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        if (this.f20705a.z0().get()) {
            adUnitIds = this.f20705a.g0().getInitializationAdUnitIds();
        } else {
            adUnitIds = this.f20705a.H() != null ? this.f20705a.H().getAdUnitIds() : null;
        }
        boolean zStartsWith = str.startsWith("test_mode");
        if (adUnitIds != null && adUnitIds.size() > 0 && !adUnitIds.contains(str) && !zStartsWith) {
            if (yp.c(this.f20705a)) {
                String str3 = "Ad Unit ID " + str + " has not been initialized. When you use selective init, any ad units that you do not explicitly specify are excluded from serving ads for the current session. For more information visit our docs: https://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow";
                if (((Boolean) this.f20705a.a(sj.f23011m6)).booleanValue()) {
                    throw new RuntimeException(str3);
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20706b.b("MediationService", str3);
                }
            }
            this.f20705a.E().a(la.L, "uninitialized_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "uninitialized_ad_unit_id" + str);
        }
        this.f20705a.c();
        if (str.length() != 16 && !zStartsWith && !this.f20705a.b0().startsWith("05TMD")) {
            com.applovin.impl.sdk.n.h("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
        }
        if (!this.f20705a.a(maxAdFormat)) {
            this.f20705a.S0();
            gc.a((MaxAdRequestListener) interfaceC0188a, str, true);
            this.f20705a.K().a(str, str2, maxAdFormat, bVar, map, map2, context, interfaceC0188a);
            return;
        }
        com.applovin.impl.sdk.n.h("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
        gc.a(interfaceC0188a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
    }

    public void loadThirdPartyMediatedAd(final String str, final ge geVar, boolean z11, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        fi fiVarA;
        if (geVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.a("MediationService", "Loading " + geVar + "...");
        }
        if (!z11) {
            this.f20705a.E().a(la.f20392u, geVar);
            this.f20705a.p().b(geVar, "WILL_LOAD");
        }
        final g gVarA = this.f20705a.M().a(geVar);
        if (gVarA == null) {
            String str2 = "Failed to load " + geVar + ": adapter not loaded";
            com.applovin.impl.sdk.n.h("MediationService", str2);
            b(geVar, new MaxErrorImpl(-5001, str2), interfaceC0188a);
            return;
        }
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(geVar);
        if (geVar.e0()) {
            fiVarA = this.f20705a.L().a(geVar, activity);
        } else {
            if (geVar.f0()) {
                this.f20705a.L().b(geVar, activity);
            }
            fiVarA = null;
        }
        final ge geVarA = geVar.a(gVarA);
        gVarA.a(str, geVarA);
        geVarA.h0();
        if (fiVarA == null) {
            gVarA.a(str, maxAdapterParametersImplA, geVarA, activity, new d(geVarA, interfaceC0188a));
        } else {
            fiVarA.a(new fi.a() { // from class: com.applovin.impl.mediation.j
                @Override // com.applovin.impl.fi.a
                public final void a(Object obj) {
                    this.f21052a.a(geVar, interfaceC0188a, (String) obj);
                }
            });
            fiVarA.a(new Runnable() { // from class: com.applovin.impl.mediation.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21057a.a(gVarA, str, maxAdapterParametersImplA, geVarA, activity, interfaceC0188a);
                }
            });
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, @Nullable Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object objA = this.f20705a.C().a();
            if (objA instanceof ge) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (ge) objA, true);
            }
        }
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, ge geVar) {
        a(maxError, geVar, false);
    }

    public void processAdapterInitializationPostback(pe peVar, long j11, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap map = new HashMap(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j11));
        a("minit", map, new MaxErrorImpl(str), peVar);
        Map mapA = ma.a(peVar);
        CollectionUtils.putStringIfValid("adapter_init_status", String.valueOf(initializationStatus.getCode()), mapA);
        CollectionUtils.putStringIfValid(TrackingKey.ERROR_MESSAGE, str, mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j11), mapA);
        switch (c.f20718a[initializationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f20705a.E().a(la.f20385n, mapA);
                break;
            case 4:
                this.f20705a.E().a(la.f20386o, mapA);
                break;
            case 5:
            case 6:
                this.f20705a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20705a.J().k("MediationService", "Adapter init postback called while the adapter is not fully initialized.");
                }
                this.f20705a.E().a(la.f20375d, "adapterNotInitializedForPostback", mapA);
                break;
        }
    }

    public void processCallbackAdImpressionPostback(ge geVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        if (geVar.R().endsWith("cimp")) {
            this.f20705a.p().b(geVar);
            gc.a((MaxAdRevenueListener) interfaceC0188a, (MaxAd) geVar);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f20705a.q0().c());
        if (!((Boolean) this.f20705a.a(sj.R3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mcimp", map, geVar);
        this.f20705a.E().a(la.f20396y, geVar);
    }

    public void processRawAdImpression(ge geVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        this.f20705a.p().b(geVar, "WILL_DISPLAY");
        if (geVar.R().endsWith("mimp")) {
            this.f20705a.p().b(geVar);
            gc.a((MaxAdRevenueListener) interfaceC0188a, (MaxAd) geVar);
        }
        if (((Boolean) this.f20705a.a(sj.J4)).booleanValue()) {
            this.f20705a.R().a(we.f24089d, xe.a(geVar), Long.valueOf(System.currentTimeMillis() - this.f20705a.I()));
        }
        HashMap map = new HashMap(2);
        if (geVar instanceof ie) {
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(((ie) geVar).o0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f20705a.q0().c());
        if (!((Boolean) this.f20705a.a(sj.R3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mimp", map, geVar);
    }

    public void processViewabilityAdImpressionPostback(ne neVar, long j11, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        if (neVar.R().endsWith("vimp")) {
            this.f20705a.p().b(neVar);
            gc.a((MaxAdRevenueListener) interfaceC0188a, (MaxAd) neVar);
        }
        HashMap map = new HashMap(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j11));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(neVar.p0()));
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f20705a.q0().c());
        if (!((Boolean) this.f20705a.a(sj.R3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mvimp", map, neVar);
    }

    public void processWaterfallInfoPostback(String str, MaxAdFormat maxAdFormat, MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl, @Nullable MaxError maxError, long j11, long j12) {
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map);
        CollectionUtils.putStringIfValid("ad_unit_id", str, map);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j12), map);
        if (maxError != null) {
            map.putAll(ma.a(maxError));
        }
        this.f20705a.E().a(la.f20395x, (Map) map);
        if (CollectionUtils.isEmpty(maxAdWaterfallInfoImpl.getPostbackUrls())) {
            return;
        }
        HashMap map2 = new HashMap(8);
        CollectionUtils.putStringIfValid("mcode", maxAdWaterfallInfoImpl.getMCode(), map2);
        CollectionUtils.putStringIfValid("ad_unit_id", str, map2);
        CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map2);
        CollectionUtils.putStringIfValid("name", maxAdWaterfallInfoImpl.getName(), map2);
        CollectionUtils.putLongIfValid("request_latency_ms", Long.valueOf(j12), map2);
        CollectionUtils.putLongIfValid("request_start_timestamp_ms", Long.valueOf(j11), map2);
        CollectionUtils.putLongIfValid("wf_latency_ms", Long.valueOf(maxAdWaterfallInfoImpl.getLatencyMillis()), map2);
        List<MaxNetworkResponseInfo> networkResponses = maxAdWaterfallInfoImpl.getNetworkResponses();
        ArrayList arrayList = new ArrayList(networkResponses.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : networkResponses) {
            MaxMediatedNetworkInfo mediatedNetwork = maxNetworkResponseInfo.getMediatedNetwork();
            HashMap map3 = new HashMap(5);
            CollectionUtils.putStringIfValid("bcode", ((MaxNetworkResponseInfoImpl) maxNetworkResponseInfo).getBCode(), map3);
            map3.put("name", mediatedNetwork.getName());
            CollectionUtils.putLongIfValid("latency_ms", Long.valueOf(maxNetworkResponseInfo.getLatencyMillis()), map3);
            map3.put("load_state", Integer.valueOf(maxNetworkResponseInfo.getAdLoadState().ordinal()));
            MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxNetworkResponseInfo.getError();
            if (maxErrorImpl != null) {
                HashMap map4 = new HashMap(4);
                map4.put(TrackingKey.ERROR_CODE, Integer.valueOf(maxErrorImpl.getCode()));
                map4.put(TrackingKey.ERROR_MESSAGE, maxErrorImpl.getMessage());
                map4.put("third_party_sdk_error_code", Integer.valueOf(maxErrorImpl.getMediatedNetworkErrorCode()));
                map4.put("third_party_sdk_error_message", maxErrorImpl.getMediatedNetworkErrorMessage());
                map3.put("error_info", map4);
            }
            arrayList.add(map3);
        }
        map2.put("ads_info", arrayList);
        a("mwf_info", maxAdWaterfallInfoImpl.getPostbackUrls(), Collections.EMPTY_MAP, map2, null, null, false);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.f20708d.set(jSONObject);
    }

    public void showFullscreenAd(final ie ieVar, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        if (ieVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != ieVar.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f20705a.C().a(true);
        final g gVarB = b(ieVar);
        long jQ0 = ieVar.q0();
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.d("MediationService", "Showing ad " + ieVar.getAdUnitId() + " with delay of " + jQ0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f21032a.a(ieVar, gVarB, activity, interfaceC0188a);
            }
        }, jQ0);
    }

    public void showFullscreenAd(final ie ieVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        if (ieVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f20705a.C().a(true);
        final g gVarB = b(ieVar);
        long jQ0 = ieVar.q0();
        if (com.applovin.impl.sdk.n.a()) {
            this.f20706b.d("MediationService", "Showing ad " + ieVar.getAdUnitId() + " with delay of " + jQ0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f21042a.a(ieVar, gVarB, viewGroup, lifecycle, activity, interfaceC0188a);
            }
        }, jQ0);
    }
}
