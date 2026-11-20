package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxErrorCode;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class xm extends yl {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final AtomicBoolean f24346q = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f24347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f24348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final JSONObject f24349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f24350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.applovin.impl.mediation.ads.a.InterfaceC0188a f24351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final WeakReference f24352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f24353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f24354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List f24355p;

    /* JADX INFO: compiled from: source.java */
    public class b extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f24356h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f24357i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ge f24358j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final List f24359k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f24360l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f24361m;

        /* JADX INFO: compiled from: source.java */
        public class a extends oe {
            public a(com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
                super(interfaceC0188a);
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f24356h;
                com.applovin.impl.sdk.n unused = b.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f24691c.a(b.this.f24690b, "Ad failed to load in " + jElapsedRealtime + " ms for " + xm.this.f24348i.getLabel() + " ad unit " + xm.this.f24347h + " with error: " + maxError);
                }
                b.this.b("failed to load ad: " + maxError.getCode());
                if (b.this.f24361m > 0) {
                    if (!b.this.f24689a.a(ve.B7, String.valueOf(maxError.getCode()))) {
                        b.i(b.this);
                        b.this.f24360l = true;
                        b.this.f24689a.j0().a(b.this, tm.b.MEDIATION, b.this.f24358j.W());
                        return;
                    }
                    com.applovin.impl.sdk.n unused2 = b.this.f24691c;
                    if (com.applovin.impl.sdk.n.a()) {
                        b.this.f24691c.a(b.this.f24690b, "Ignoring failed ad load retry for error code " + maxError.getCode());
                    }
                }
                b bVar = b.this;
                bVar.a(bVar.f24358j, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                if (b.this.f24357i >= b.this.f24359k.size() - 1) {
                    xm.this.b(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                } else {
                    b bVar2 = b.this;
                    b.this.f24689a.j0().a((yl) new b(bVar2.f24357i + 1, b.this.f24359k), tm.b.MEDIATION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                b.this.b("loaded ad");
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f24356h;
                com.applovin.impl.sdk.n unused = b.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f24691c.a(b.this.f24690b, "Ad loaded in " + jElapsedRealtime + "ms for " + xm.this.f24348i.getLabel() + " ad unit " + xm.this.f24347h);
                }
                ge geVar = (ge) maxAd;
                b.this.a(geVar, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                int i11 = b.this.f24357i;
                while (true) {
                    i11++;
                    if (i11 >= b.this.f24359k.size()) {
                        xm.this.b(geVar);
                        return;
                    } else {
                        b bVar = b.this;
                        bVar.a((ge) bVar.f24359k.get(i11), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
                    }
                }
            }
        }

        private b(int i11, List list) {
            super(xm.this.f24690b, xm.this.f24689a, xm.this.f24347h);
            this.f24356h = SystemClock.elapsedRealtime();
            this.f24357i = i11;
            ge geVar = (ge) list.get(i11);
            this.f24358j = geVar;
            this.f24359k = list;
            this.f24361m = geVar.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ge geVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j11, MaxError maxError) {
            xm.this.f24355p.add(new MaxNetworkResponseInfoImpl(adLoadState, af.a(geVar.b()), geVar.G(), geVar.a0(), j11, geVar.C(), maxError));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
        }

        public static /* synthetic */ int i(b bVar) {
            int i11 = bVar.f24361m;
            bVar.f24361m = i11 - 1;
            return i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f24691c;
                String str = this.f24690b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f24360l ? "Retrying loading" : "Loading");
                sb2.append(" ad ");
                sb2.append(this.f24357i + 1);
                sb2.append(" of ");
                sb2.append(this.f24359k.size());
                sb2.append(" from ");
                sb2.append(this.f24358j.c());
                sb2.append(" for ");
                sb2.append(xm.this.f24348i.getLabel());
                sb2.append(" ad unit ");
                sb2.append(xm.this.f24347h);
                nVar.a(str, sb2.toString());
            }
            b("started to load ad");
            Context context = (Context) xm.this.f24352m.get();
            Activity activityN0 = context instanceof Activity ? (Activity) context : this.f24689a.n0();
            this.f24689a.T().b(this.f24358j);
            this.f24689a.Q().loadThirdPartyMediatedAd(xm.this.f24347h, this.f24358j, this.f24360l, activityN0, new a(xm.this.f24351l));
        }
    }

    public xm(String str, MaxAdFormat maxAdFormat, Map map, JSONObject jSONObject, Context context, com.applovin.impl.sdk.j jVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        super("TaskProcessMediationWaterfall", jVar, str);
        this.f24347h = str;
        this.f24348i = maxAdFormat;
        this.f24349j = jSONObject;
        this.f24351l = interfaceC0188a;
        this.f24352m = new WeakReference(context);
        this.f24353n = JsonUtils.getString(jSONObject, "mcode", "");
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        this.f24350k = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            this.f24350k.add(ge.a(i11, map, JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null), jSONObject, jVar));
        }
        this.f24355p = new ArrayList(this.f24350k.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(MaxError maxError) {
        if (maxError.getCode() == 204) {
            this.f24689a.D().c(ca.f18164u);
        } else if (maxError.getCode() == -5001) {
            this.f24689a.D().c(ca.f18165v);
        } else {
            this.f24689a.D().c(ca.f18166w);
        }
        ArrayList arrayList = new ArrayList(this.f24355p.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.f24355p) {
            if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(maxNetworkResponseInfo);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb2 = new StringBuilder("======FAILED AD LOADS======");
            sb2.append("\n");
            int i11 = 0;
            while (i11 < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo2 = (MaxNetworkResponseInfo) arrayList.get(i11);
                i11++;
                sb2.append(i11);
                sb2.append(") ");
                sb2.append(maxNetworkResponseInfo2.getMediatedNetwork().getName());
                sb2.append("\n");
                sb2.append("..code: ");
                sb2.append(maxNetworkResponseInfo2.getError().getCode());
                sb2.append("\n");
                sb2.append("..message: ");
                sb2.append(maxNetworkResponseInfo2.getError().getMessage());
                sb2.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb2.toString());
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f24354o;
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.d(this.f24690b, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.f24348i.getLabel() + " ad unit " + this.f24347h + " with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.f24349j, "waterfall_name", ""), JsonUtils.getString(this.f24349j, "waterfall_test_name", ""), jElapsedRealtime, this.f24355p, JsonUtils.optList(JsonUtils.getJSONArray(this.f24349j, "mwf_info_urls", null), Collections.EMPTY_LIST), this.f24353n));
        gc.a(this.f24351l, this.f24347h, maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ge geVar) {
        this.f24689a.T().c(geVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f24354o;
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.d(this.f24690b, "Waterfall loaded in " + jElapsedRealtime + "ms from " + geVar.c() + " for " + this.f24348i.getLabel() + " ad unit " + this.f24347h);
        }
        geVar.a(new MaxAdWaterfallInfoImpl(geVar, jElapsedRealtime, this.f24355p, this.f24353n));
        gc.f(this.f24351l, geVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        yp.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.f24689a.n0());
    }

    @Override // java.lang.Runnable
    public void run() {
        final MaxErrorImpl maxErrorImpl;
        this.f24354o = SystemClock.elapsedRealtime();
        int i11 = 0;
        if (this.f24349j.optBoolean("is_testing", false) && !this.f24689a.l0().c() && f24346q.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.g90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19166a.e();
                }
            });
        }
        if (this.f24350k.size() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Starting waterfall for " + this.f24348i.getLabel() + " ad unit " + this.f24347h + " with " + this.f24350k.size() + " ad(s)...");
            }
            this.f24689a.j0().a(new b(i11, this.f24350k));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.k(this.f24690b, "No ads were returned from the server for " + this.f24348i.getLabel() + " ad unit " + this.f24347h);
        }
        yp.a(this.f24347h, this.f24348i, this.f24349j, this.f24689a);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f24349j, "settings", new JSONObject());
        long j11 = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        if (af.a(this.f24349j, this.f24347h, this.f24689a)) {
            maxErrorImpl = new MaxErrorImpl(MaxErrorCode.INVALID_AD_UNIT_ID, "Ad Unit ID " + this.f24347h + " is invalid or disabled.\nMake sure to use an Ad Unit ID from the MAX dashboard that is enabled and configured for the current application.\nFor more information, see https://developers.applovin.com/en/getting-started#step-2-create-an-ad-unit\nNote: New ad units cannot load ads until 30-60 minutes after they are created");
            if (yp.c(this.f24689a) && ((Boolean) this.f24689a.a(sj.f23003l6)).booleanValue()) {
                j11 = 0;
            }
        } else {
            maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device");
        }
        if (j11 <= 0) {
            b(maxErrorImpl);
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(j11);
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.h90
            @Override // java.lang.Runnable
            public final void run() {
                this.f19398a.b(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
            x1.a(millis, this.f24689a, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }
}
