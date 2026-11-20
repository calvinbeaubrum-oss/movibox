package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.fm;
import com.applovin.impl.gc;
import com.applovin.impl.ge;
import com.applovin.impl.lm;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.ve;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f20875b = new HashMap(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f20876c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f20877d = new HashMap(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f20878e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f20879f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f20880g = new Object();

    /* JADX INFO: compiled from: source.java */
    public class a implements fm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f20881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f20882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MaxAdFormat f20884d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f20885e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f20886f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f20887g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.mediation.ads.a.InterfaceC0188a f20888h;

        public a(long j11, Map map, String str, MaxAdFormat maxAdFormat, Map map2, Map map3, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
            this.f20881a = j11;
            this.f20882b = map;
            this.f20883c = str;
            this.f20884d = maxAdFormat;
            this.f20885e = map2;
            this.f20886f = map3;
            this.f20887g = context;
            this.f20888h = interfaceC0188a;
        }

        @Override // com.applovin.impl.fm.b
        public void a(JSONArray jSONArray) {
            this.f20882b.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f20881a));
            this.f20882b.put("calfc", Integer.valueOf(d.this.b(this.f20883c)));
            lm lmVar = new lm(this.f20883c, this.f20884d, this.f20885e, this.f20886f, this.f20882b, jSONArray, this.f20887g, d.this.f20874a, this.f20888h);
            if (((Boolean) d.this.f20874a.a(ve.K7)).booleanValue()) {
                d.this.f20874a.j0().a((yl) lmVar, tm.b.MEDIATION);
            } else {
                d.this.f20874a.j0().a(lmVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        PUBLISHER_INITIATED("publisher_initiated"),
        SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
        REFRESH(ToolBar.REFRESH),
        EXPONENTIAL_RETRY("exponential_retry"),
        EXPIRED("expired"),
        NATIVE_AD_PLACER("native_ad_placer");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20897a;

        b(String str) {
            this.f20897a = str;
        }

        public String b() {
            return this.f20897a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements com.applovin.impl.mediation.ads.a.InterfaceC0188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f20898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference f20899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f20900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final C0189d f20901d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MaxAdFormat f20902f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Map f20903g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Map f20904h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Map f20905i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f20906j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f20907k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f20908l;

        private c(Map map, Map map2, Map map3, C0189d c0189d, MaxAdFormat maxAdFormat, long j11, long j12, d dVar, com.applovin.impl.sdk.j jVar, Context context) {
            this.f20898a = jVar;
            this.f20899b = new WeakReference(context);
            this.f20900c = dVar;
            this.f20901d = c0189d;
            this.f20902f = maxAdFormat;
            this.f20904h = map2;
            this.f20903g = map;
            this.f20905i = map3;
            this.f20907k = j11;
            this.f20908l = j12;
            if (CollectionUtils.getBoolean(map2, "disable_auto_retries")) {
                this.f20906j = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.f20906j = Math.min(2, ((Integer) jVar.a(ve.f23900w7)).intValue());
            } else {
                this.f20906j = ((Integer) jVar.a(ve.f23900w7)).intValue();
            }
        }

        public /* synthetic */ c(Map map, Map map2, Map map3, C0189d c0189d, MaxAdFormat maxAdFormat, long j11, long j12, d dVar, com.applovin.impl.sdk.j jVar, Context context, a aVar) {
            this(map, map2, map3, c0189d, maxAdFormat, j11, j12, dVar, jVar, context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i11, String str) {
            this.f20904h.put("retry_delay_sec", Integer.valueOf(i11));
            this.f20904h.put("retry_attempt", Integer.valueOf(this.f20901d.f20912d));
            Context contextL = (Context) this.f20899b.get();
            if (contextL == null) {
                contextL = com.applovin.impl.sdk.j.l();
            }
            Context context = contextL;
            this.f20905i.put("art", b.EXPONENTIAL_RETRY.b());
            this.f20905i.put("era", Integer.valueOf(this.f20901d.f20912d));
            this.f20908l = System.currentTimeMillis();
            this.f20900c.a(str, this.f20902f, this.f20903g, this.f20904h, this.f20905i, context, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            this.f20900c.c(str);
            if (((Boolean) this.f20898a.a(ve.f23902y7)).booleanValue() && this.f20901d.f20911c.get()) {
                this.f20898a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20898a.J().a("MediationAdLoadManager", "Ad failed to load but its load state was destroyed");
                    return;
                }
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f20907k;
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) maxError.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f20898a.Q().processWaterfallInfoPostback(str, this.f20902f, maxAdWaterfallInfoImpl, maxError, this.f20908l, jElapsedRealtime);
            }
            boolean z11 = maxError.getCode() == -5603 && yp.c(this.f20898a) && ((Boolean) this.f20898a.a(sj.f23003l6)).booleanValue();
            if (this.f20898a.a(ve.f23901x7, this.f20902f) && this.f20901d.f20912d < this.f20906j && !z11) {
                C0189d.f(this.f20901d);
                final int iPow = (int) Math.pow(2.0d, this.f20901d.f20912d);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21113a.a(iPow, str);
                    }
                }, TimeUnit.SECONDS.toMillis(iPow));
                return;
            }
            this.f20901d.f20912d = 0;
            this.f20901d.f20910b.set(false);
            if (this.f20901d.f20913e != null) {
                MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError;
                maxErrorImpl.setLoadTag(this.f20901d.f20909a);
                maxErrorImpl.setRequestLatencyMillis(jElapsedRealtime);
                gc.a(this.f20901d.f20913e, str, maxError);
                this.f20901d.f20913e = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (((Boolean) this.f20898a.a(ve.f23902y7)).booleanValue() && this.f20901d.f20911c.get()) {
                this.f20898a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20898a.J().a("MediationAdLoadManager", "Ad loaded but its load state was destroyed");
                }
                this.f20898a.Q().destroyAd(maxAd);
                return;
            }
            ge geVar = (ge) maxAd;
            geVar.i(this.f20901d.f20909a);
            geVar.a(SystemClock.elapsedRealtime() - this.f20907k);
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) geVar.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f20898a.Q().processWaterfallInfoPostback(geVar.getAdUnitId(), this.f20902f, maxAdWaterfallInfoImpl, null, this.f20908l, geVar.getRequestLatencyMillis());
            }
            this.f20900c.a(maxAd.getAdUnitId());
            this.f20901d.f20912d = 0;
            if (this.f20901d.f20913e == null) {
                this.f20900c.a(geVar);
                this.f20901d.f20910b.set(false);
                return;
            }
            geVar.B().c().a(this.f20901d.f20913e);
            this.f20901d.f20913e.onAdLoaded(geVar);
            if (geVar.R().endsWith("load")) {
                this.f20901d.f20913e.onAdRevenuePaid(geVar);
            }
            this.f20901d.f20913e = null;
            if ((!this.f20898a.c(ve.f23899v7).contains(maxAd.getAdUnitId()) && !this.f20898a.a(ve.f23898u7, maxAd.getFormat())) || this.f20898a.l0().c() || this.f20898a.l0().d()) {
                this.f20901d.f20910b.set(false);
                return;
            }
            Context contextL = (Context) this.f20899b.get();
            if (contextL == null) {
                contextL = com.applovin.impl.sdk.j.l();
            }
            Context context = contextL;
            this.f20907k = SystemClock.elapsedRealtime();
            this.f20908l = System.currentTimeMillis();
            this.f20905i.put("art", b.SEQUENTIAL_OR_PRECACHE.b());
            this.f20900c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f20903g, this.f20904h, this.f20905i, context, this);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0189d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f20910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f20911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile com.applovin.impl.mediation.ads.a.InterfaceC0188a f20913e;

        private C0189d(String str) {
            this.f20910b = new AtomicBoolean();
            this.f20911c = new AtomicBoolean();
            this.f20909a = str;
        }

        public /* synthetic */ C0189d(String str, a aVar) {
            this(str);
        }

        public static /* synthetic */ int f(C0189d c0189d) {
            int i11 = c0189d.f20912d;
            c0189d.f20912d = i11 + 1;
            return i11;
        }
    }

    public d(com.applovin.impl.sdk.j jVar) {
        this.f20874a = jVar;
    }

    private C0189d a(String str, String str2) {
        C0189d c0189d;
        synchronized (this.f20876c) {
            try {
                String strB = b(str, str2);
                c0189d = (C0189d) this.f20875b.get(strB);
                if (c0189d == null) {
                    c0189d = new C0189d(str2, null);
                    this.f20875b.put(strB, c0189d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c0189d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ge geVar) {
        synchronized (this.f20878e) {
            try {
                if (this.f20877d.containsKey(geVar.getAdUnitId())) {
                    com.applovin.impl.sdk.n.h("AppLovinSdk", "Ad in cache already: " + geVar.getAdUnitId());
                }
                this.f20877d.put(geVar.getAdUnitId(), geVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f20880g) {
            try {
                this.f20874a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20874a.J().a("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
                }
                this.f20879f.remove(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        this.f20874a.j0().a((yl) new fm(str, maxAdFormat, map, context, this.f20874a, new a(SystemClock.elapsedRealtime(), map3, str, maxAdFormat, map, map2, context, interfaceC0188a)), tm.b.MEDIATION);
    }

    private String b(String str, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (str2 != null) {
            str3 = "-" + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        return sb2.toString();
    }

    private ge e(String str) {
        ge geVar;
        synchronized (this.f20878e) {
            geVar = (ge) this.f20877d.get(str);
            this.f20877d.remove(str);
        }
        return geVar;
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, b bVar, Map map, Map map2, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0188a interfaceC0188a) {
        ge geVarE = (this.f20874a.l0().d() || yp.f(com.applovin.impl.sdk.j.l())) ? null : e(str);
        if (geVarE != null) {
            geVarE.i(str2);
            geVarE.B().c().a(interfaceC0188a);
            interfaceC0188a.onAdLoaded(geVarE);
            if (geVarE.R().endsWith("load")) {
                interfaceC0188a.onAdRevenuePaid(geVarE);
            }
        }
        C0189d c0189dA = a(str, str2);
        if (c0189dA.f20910b.compareAndSet(false, true)) {
            if (geVarE == null) {
                c0189dA.f20913e = interfaceC0188a;
            }
            Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
            mapSynchronizedMap.put("art", bVar.b());
            if (StringUtils.isValidString(str2)) {
                mapSynchronizedMap.put("alt", str2);
            }
            a(str, maxAdFormat, map, map2, mapSynchronizedMap, context, new c(map, map2, mapSynchronizedMap, c0189dA, maxAdFormat, SystemClock.elapsedRealtime(), System.currentTimeMillis(), this, this.f20874a, context, null));
            return;
        }
        if (c0189dA.f20913e != null && c0189dA.f20913e != interfaceC0188a) {
            com.applovin.impl.sdk.n.j("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
        }
        c0189dA.f20913e = interfaceC0188a;
    }

    public int b(String str) {
        int iIntValue;
        synchronized (this.f20880g) {
            try {
                Integer num = (Integer) this.f20879f.get(str);
                iIntValue = num != null ? num.intValue() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iIntValue;
    }

    public void c(String str) {
        synchronized (this.f20880g) {
            try {
                this.f20874a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20874a.J().a("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
                }
                Integer num = (Integer) this.f20879f.get(str);
                if (num == null) {
                    num = 0;
                }
                this.f20879f.put(str, Integer.valueOf(num.intValue() + 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c(String str, String str2) {
        synchronized (this.f20876c) {
            String strB = b(str, str2);
            a(str, str2).f20911c.set(true);
            this.f20875b.remove(strB);
        }
    }

    public boolean d(String str) {
        boolean z11;
        synchronized (this.f20878e) {
            z11 = this.f20877d.get(str) != null;
        }
        return z11;
    }
}
