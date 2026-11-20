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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wm extends yl {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final AtomicBoolean f24116z = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f24117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f24118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final JSONObject f24119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.mediation.ads.a.InterfaceC0188a f24120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final WeakReference f24121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f24122m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Queue f24123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f24124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Queue f24125p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Object f24126q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f24127r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f24128s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f24129t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicBoolean f24130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f24131v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f24132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ge f24133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private go f24134y;

    /* JADX INFO: compiled from: source.java */
    public class b extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f24135h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f24136i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ge f24137j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c f24138k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f24139l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f24140m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f24141n;

        /* JADX INFO: compiled from: source.java */
        public class a extends oe {
            public a(com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
                super(interfaceC0188a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a() {
                wm wmVar = wm.this;
                wmVar.b(wmVar.f24133x);
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f24136i;
                com.applovin.impl.sdk.n unused = b.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f24691c.a(b.this.f24135h, "Ad (" + b.this.f24139l + ") failed to load in " + jElapsedRealtime + "ms for " + wm.this.f24118i + " ad unit " + str + " with error: " + maxError);
                }
                b.this.b("failed to load ad: " + maxError.getCode());
                if (!b.this.f24140m) {
                    b bVar = b.this;
                    wm.this.a(bVar.f24137j, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                }
                if (wm.this.f24132w.get()) {
                    return;
                }
                if (wm.this.f24133x != null) {
                    b bVar2 = b.this;
                    if (b.this.b(wm.this.c(bVar2.f24138k))) {
                        wm wmVar = wm.this;
                        wmVar.b(wmVar.f24133x);
                        return;
                    }
                }
                if (b.this.f24141n > 0) {
                    if (!b.this.f24689a.a(ve.B7, String.valueOf(maxError.getCode()))) {
                        b.l(b.this);
                        b.this.f24140m = true;
                        b.this.f24689a.j0().a(b.this, tm.b.MEDIATION, b.this.f24137j.W());
                        return;
                    }
                    com.applovin.impl.sdk.n unused2 = b.this.f24691c;
                    if (com.applovin.impl.sdk.n.a()) {
                        b.this.f24691c.a(b.this.f24690b, "Ignoring failed ad load retry for error code " + maxError.getCode());
                    }
                }
                b bVar3 = b.this;
                if ((!wm.this.d(bVar3.f24138k)) && wm.this.f24131v.get() && wm.this.f24130u.get()) {
                    wm.this.b(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                boolean z11;
                long jF;
                ge geVar;
                b.this.b("loaded ad");
                ge geVar2 = (ge) maxAd;
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f24136i;
                com.applovin.impl.sdk.n unused = b.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f24691c.a(b.this.f24135h, "Ad (" + b.this.f24139l + ") loaded in " + jElapsedRealtime + "ms for " + wm.this.f24118i + " ad unit " + wm.this.f24117h);
                }
                wm.this.a(geVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                b bVar = b.this;
                wm.this.b(bVar.f24138k);
                if (c.BIDDING == b.this.f24138k) {
                    z11 = wm.this.f24131v.get();
                    jF = geVar2.U();
                } else {
                    z11 = wm.this.f24130u.get();
                    jF = geVar2.F();
                }
                if (z11 || jF == 0) {
                    if (b.this.b(geVar2)) {
                        geVar = geVar2;
                        geVar2 = wm.this.f24133x;
                    } else {
                        geVar = wm.this.f24133x;
                    }
                    wm.this.a(geVar2, geVar);
                    return;
                }
                wm.this.f24133x = geVar2;
                if (jF < 0) {
                    return;
                }
                b bVar2 = b.this;
                wm.this.f24134y = go.a(jF, bVar2.f24689a, new Runnable() { // from class: com.applovin.impl.f80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18888a.a();
                    }
                });
            }
        }

        private b(ge geVar, c cVar) {
            super(wm.this.f24690b, wm.this.f24689a, wm.this.f24117h);
            this.f24135h = this.f24690b + ":" + cVar;
            this.f24136i = SystemClock.elapsedRealtime();
            this.f24137j = geVar;
            this.f24138k = cVar;
            this.f24139l = geVar.K() + 1;
            this.f24141n = geVar.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(ge geVar) {
            if (wm.this.f24133x == null) {
                return false;
            }
            if (geVar == null) {
                return true;
            }
            double dP = wm.this.f24133x.P();
            double dP2 = geVar.P();
            if (dP < 0.0d || dP2 < 0.0d) {
                return wm.this.f24133x.K() < geVar.K();
            }
            return dP > dP2;
        }

        public static /* synthetic */ int l(b bVar) {
            int i11 = bVar.f24141n;
            bVar.f24141n = i11 - 1;
            return i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f24691c;
                String str = this.f24135h;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f24140m ? "Retrying loading" : "Loading");
                sb2.append(" ad ");
                sb2.append(this.f24139l);
                sb2.append(" of ");
                sb2.append(wm.this.f24127r);
                sb2.append(" from ");
                sb2.append(this.f24137j.c());
                sb2.append(" for ");
                sb2.append(wm.this.f24118i);
                sb2.append(" ad unit ");
                sb2.append(wm.this.f24117h);
                nVar.a(str, sb2.toString());
            }
            b("started to load ad");
            Context context = (Context) wm.this.f24121l.get();
            Activity activityN0 = context instanceof Activity ? (Activity) context : this.f24689a.n0();
            this.f24689a.T().b(this.f24137j);
            this.f24689a.Q().loadThirdPartyMediatedAd(wm.this.f24117h, this.f24137j, this.f24140m, activityN0, new a(wm.this.f24120k));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        BIDDING,
        TAG
    }

    public wm(String str, MaxAdFormat maxAdFormat, Map map, JSONObject jSONObject, Context context, com.applovin.impl.sdk.j jVar, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        super("TaskProcessMediationWaterfallV2", jVar, str);
        this.f24123n = new LinkedList();
        this.f24124o = new Object();
        this.f24125p = new LinkedList();
        this.f24126q = new Object();
        this.f24130u = new AtomicBoolean();
        this.f24131v = new AtomicBoolean();
        this.f24132w = new AtomicBoolean();
        this.f24117h = str;
        this.f24118i = maxAdFormat;
        this.f24119j = jSONObject;
        this.f24120k = interfaceC0188a;
        this.f24121l = new WeakReference(context);
        this.f24122m = JsonUtils.getString(jSONObject, "mCode", "");
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            ge geVarA = ge.a(i11, map, JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null), jSONObject, jVar);
            if (geVarA.a0()) {
                this.f24125p.add(geVarA);
            } else {
                this.f24123n.add(geVarA);
            }
        }
        int size = this.f24123n.size() + this.f24125p.size();
        this.f24127r = size;
        this.f24129t = new ArrayList(size);
    }

    private ge a(c cVar) {
        return a(cVar, false);
    }

    private ge a(c cVar, boolean z11) {
        ge geVar;
        ge geVar2;
        if (cVar == c.BIDDING) {
            synchronized (this.f24126q) {
                try {
                    geVar2 = (ge) (z11 ? this.f24125p.peek() : this.f24125p.poll());
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return geVar2;
        }
        synchronized (this.f24124o) {
            try {
                geVar = (ge) (z11 ? this.f24123n.peek() : this.f24123n.poll());
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return geVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ge geVar, ge geVar2) {
        if (this.f24132w.compareAndSet(false, true)) {
            f();
            g();
            this.f24689a.T().a(geVar, geVar2);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f24128s;
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.d(this.f24690b, "Waterfall loaded in " + jElapsedRealtime + "ms from " + geVar.c() + " for " + this.f24118i + " ad unit " + this.f24117h);
            }
            geVar.a(new MaxAdWaterfallInfoImpl(geVar, jElapsedRealtime, this.f24129t, this.f24122m));
            gc.f(this.f24120k, geVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ge geVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j11, MaxError maxError) {
        this.f24129t.add(new MaxNetworkResponseInfoImpl(adLoadState, af.a(geVar.b()), geVar.G(), geVar.a0(), j11, geVar.C(), maxError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(MaxError maxError) {
        int i11 = 0;
        if (this.f24132w.compareAndSet(false, true)) {
            if (maxError.getCode() == 204) {
                this.f24689a.D().c(ca.f18164u);
            } else if (maxError.getCode() == -5001) {
                this.f24689a.D().c(ca.f18165v);
            } else {
                this.f24689a.D().c(ca.f18166w);
            }
            ArrayList arrayList = new ArrayList(this.f24129t.size());
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.f24129t) {
                if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                    arrayList.add(maxNetworkResponseInfo);
                }
            }
            if (arrayList.size() > 0) {
                StringBuilder sb2 = new StringBuilder("======FAILED AD LOADS======");
                sb2.append("\n");
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
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f24128s;
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.d(this.f24690b, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.f24118i + " ad unit " + this.f24117h + " with error: " + maxError);
            }
            ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.f24119j, "waterfall_name", ""), JsonUtils.getString(this.f24119j, "waterfall_test_name", ""), jElapsedRealtime, this.f24129t, JsonUtils.optList(JsonUtils.getJSONArray(this.f24119j, "mwf_info_urls", null), Collections.EMPTY_LIST), this.f24122m));
            gc.a(this.f24120k, this.f24117h, maxError);
        }
    }

    private void a(Queue queue) {
        Iterator it = queue.iterator();
        while (it.hasNext()) {
            a((ge) it.next(), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ge geVar) {
        a(geVar, (ge) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (c.BIDDING == cVar) {
            this.f24130u.compareAndSet(false, true);
        } else if (c.TAG == cVar) {
            this.f24131v.compareAndSet(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ge c(c cVar) {
        return a(cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(c cVar) {
        ge geVarA = a(cVar);
        if (geVarA == null) {
            b(cVar);
            return false;
        }
        this.f24689a.j0().a((yl) new b(geVarA, cVar), tm.b.MEDIATION);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        yp.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.f24689a.n0());
    }

    private void f() {
        go goVar = this.f24134y;
        if (goVar == null) {
            return;
        }
        goVar.a();
        this.f24134y = null;
    }

    private void g() {
        a(this.f24123n);
        a(this.f24125p);
    }

    @Override // java.lang.Runnable
    public void run() {
        final MaxErrorImpl maxErrorImpl;
        this.f24128s = SystemClock.elapsedRealtime();
        if (this.f24119j.optBoolean("is_testing", false) && !this.f24689a.l0().c() && f24116z.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.d80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18396a.e();
                }
            });
        }
        if (this.f24127r != 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Starting waterfall for " + this.f24118i.getLabel() + " ad unit " + this.f24117h + " with " + this.f24127r + " ad(s)...");
            }
            d(c.TAG);
            d(c.BIDDING);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.k(this.f24690b, "No ads were returned from the server for " + this.f24118i.getLabel() + " ad unit " + this.f24117h);
        }
        yp.a(this.f24117h, this.f24118i, this.f24119j, this.f24689a);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f24119j, "settings", new JSONObject());
        long j11 = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        if (af.a(this.f24119j, this.f24117h, this.f24689a)) {
            maxErrorImpl = new MaxErrorImpl(MaxErrorCode.INVALID_AD_UNIT_ID, "Ad Unit ID " + this.f24117h + " is invalid or disabled.\nMake sure to use an Ad Unit ID from the MAX dashboard that is enabled and configured for the current application.\nFor more information, see https://developers.applovin.com/en/getting-started#step-2-create-an-ad-unit\nNote: New ad units cannot load ads until 30-60 minutes after they are created");
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
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.e80
            @Override // java.lang.Runnable
            public final void run() {
                this.f18655a.b(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
            x1.a(millis, this.f24689a, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }
}
