package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.bg;
import com.applovin.impl.ca;
import com.applovin.impl.d4;
import com.applovin.impl.d5;
import com.applovin.impl.da;
import com.applovin.impl.dd;
import com.applovin.impl.e4;
import com.applovin.impl.gc;
import com.applovin.impl.h4;
import com.applovin.impl.hr;
import com.applovin.impl.i4;
import com.applovin.impl.jm;
import com.applovin.impl.jn;
import com.applovin.impl.la;
import com.applovin.impl.ma;
import com.applovin.impl.mediation.MaxSegmentCollectionImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.oj;
import com.applovin.impl.pb;
import com.applovin.impl.pe;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.qe;
import com.applovin.impl.qg;
import com.applovin.impl.qn;
import com.applovin.impl.qr;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.sm;
import com.applovin.impl.tj;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.uj;
import com.applovin.impl.ve;
import com.applovin.impl.vj;
import com.applovin.impl.wh;
import com.applovin.impl.wn;
import com.applovin.impl.wp;
import com.applovin.impl.y4;
import com.applovin.impl.ye;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.ze;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static j f22563v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected static Context f22564w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final boolean f22566y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static volatile com.applovin.impl.q f22567z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f22570b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f22574d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private List f22575d0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AppLovinSdkSettings f22578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxSegmentCollection f22580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22582h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f22583h0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private String f22593m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile AppLovinSdk f22594n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private AppLovinSdkInitializationConfiguration f22595n0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private AppLovinSdk.SdkInitializationListener f22601q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private AppLovinSdk.SdkInitializationListener f22603r0;
    private static final Object A0 = new Object();

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final long f22565x0 = System.currentTimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f22576e = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f22584i = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicReference f22586j = new AtomicReference();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicReference f22588k = new AtomicReference();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicReference f22590l = new AtomicReference();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicReference f22592m = new AtomicReference();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final n f22596o = new n(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ma f22598p = new ma(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicReference f22600q = new AtomicReference();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicReference f22602r = new AtomicReference();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicReference f22604s = new AtomicReference();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicReference f22606t = new AtomicReference();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicReference f22608u = new AtomicReference();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicReference f22610v = new AtomicReference();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicReference f22611w = new AtomicReference();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicReference f22612x = new AtomicReference();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicReference f22613y = new AtomicReference();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AtomicReference f22614z = new AtomicReference();
    private final AtomicReference A = new AtomicReference();
    private final AtomicReference B = new AtomicReference();
    private final AtomicReference C = new AtomicReference();
    private final AtomicReference D = new AtomicReference();
    private final AtomicReference E = new AtomicReference();
    private final AtomicReference F = new AtomicReference();
    private final AtomicReference G = new AtomicReference();
    private final AtomicReference H = new AtomicReference();
    private final AtomicReference I = new AtomicReference();
    private final AtomicReference J = new AtomicReference();
    private final AtomicReference K = new AtomicReference();
    private final AtomicReference L = new AtomicReference();
    private final AtomicReference M = new AtomicReference();
    private final AtomicReference N = new AtomicReference();
    private final AtomicReference O = new AtomicReference();
    private final AtomicReference P = new AtomicReference();
    private final AtomicReference Q = new AtomicReference();
    private final AtomicReference R = new AtomicReference();
    private final AtomicReference S = new AtomicReference();
    private final AtomicReference T = new AtomicReference();
    private final AtomicReference U = new AtomicReference();
    private final AtomicReference V = new AtomicReference();
    private final AtomicReference W = new AtomicReference();
    private final AtomicReference X = new AtomicReference();
    private final AtomicReference Y = new AtomicReference();
    private final AtomicReference Z = new AtomicReference();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final AtomicReference f22569a0 = new AtomicReference();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final AtomicReference f22571b0 = new AtomicReference();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final AtomicReference f22573c0 = new AtomicReference();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final Object f22577e0 = new Object();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final AtomicBoolean f22579f0 = new AtomicBoolean(true);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final AtomicBoolean f22581g0 = new AtomicBoolean();

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f22585i0 = false;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f22587j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f22589k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private int f22591l0 = 0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final Object f22597o0 = new Object();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private AppLovinSdkConfiguration f22599p0 = new SdkConfigurationImpl(null, this);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final AtomicBoolean f22605s0 = new AtomicBoolean(false);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final yl f22607t0 = new jn(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.v0
        @Override // java.lang.Runnable
        public final void run() {
            this.f22865a.E0();
        }
    });

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final yl f22609u0 = new jn(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.w0
        @Override // java.lang.Runnable
        public final void run() {
            this.f22869a.F0();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f22572c = System.currentTimeMillis();

    /* JADX INFO: compiled from: source.java */
    public class a implements h4.c {
        public a() {
        }

        @Override // com.applovin.impl.h4.c
        public void a(h4.b bVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements jm.b {

        /* JADX INFO: compiled from: source.java */
        public class a implements h4.c {
            public a() {
            }

            @Override // com.applovin.impl.h4.c
            public void a(h4.b bVar) {
                j.this.J();
                if (n.a()) {
                    j.this.J().a("AppLovinSdk", "Unified flow completed with status: " + bVar);
                }
                if (!bVar.b()) {
                    j.this.d("Initializing SDK in MAX environment...");
                    return;
                }
                j.this.J();
                if (n.a()) {
                    j.this.J().a("AppLovinSdk", "Re-initializing SDK with the updated privacy settings...");
                }
                j.this.P0();
                j.this.M0();
            }
        }

        public b() {
        }

        @Override // com.applovin.impl.jm.b
        public void a(JSONObject jSONObject) {
            boolean z11 = jSONObject != null && jSONObject.length() > 0;
            j.this.c(jSONObject);
            com.applovin.impl.u0.b(j.this);
            e4.a(jSONObject, z11, j.this);
            j.this.N().a(JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
            j.this.E().a();
            j jVar = j.this;
            jVar.f22575d0 = jVar.a(jSONObject);
            if (z11) {
                List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", ""));
                j jVar2 = j.this;
                jVar2.f22599p0 = new SdkConfigurationImpl(listExplode, jVar2);
            }
            j.this.l0().a(jSONObject);
            j.this.b(jSONObject);
            gc.b(((Boolean) j.this.a(sj.f22971h6)).booleanValue());
            gc.a(((Boolean) j.this.a(sj.f22979i6)).booleanValue());
            if (!j.this.A0()) {
                j.this.d("Initializing SDK in non-MAX environment...");
            } else if (j.this.u().e() == i4.a.UNIFIED) {
                Activity activityN0 = j.this.n0();
                if (j.this.f22581g0.compareAndSet(false, true)) {
                    j.this.u().a();
                    j.this.u().b(activityN0, new a());
                } else {
                    j.this.d("Initializing SDK in MAX environment...");
                }
            } else {
                j.this.d("Initializing SDK in MAX environment...");
            }
            if (!((Boolean) j.this.a(sj.f23024o3)).booleanValue() || z11 || !e4.a(j.l())) {
                j.this.L0();
                return;
            }
            j.this.J();
            if (n.a()) {
                j.this.J().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            j.this.Q0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements jm.b {
        public c() {
        }

        @Override // com.applovin.impl.jm.b
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() > 0) {
                j.this.c(jSONObject);
            }
            j.this.f22576e.set(false);
            j.this.L0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements bg.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bg f22619a;

        public d(bg bgVar) {
            this.f22619a = bgVar;
        }

        @Override // com.applovin.impl.bg.a
        public void a() {
            j.this.J();
            if (n.a()) {
                j.this.J().d("AppLovinSdk", "Connected to internet - re-initializing SDK");
            }
            synchronized (j.this.f22577e0) {
                try {
                    if (!j.this.f22583h0) {
                        j.this.P0();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f22619a.b(this);
        }

        @Override // com.applovin.impl.bg.a
        public void b() {
        }
    }

    static {
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.z0
                @Override // java.lang.Runnable
                public final void run() {
                    yp.c();
                }
            });
            f22566y0 = true;
        } catch (Throwable unused) {
            f22566y0 = false;
        }
    }

    public j(Context context) {
        this.f22583h0 = false;
        this.f22578f = new AppLovinSdkSettings(context);
        this.f22583h0 = true;
        if (!y0()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://developers.applovin.com/en/android/overview/integration");
        }
        f22564w0 = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f22570b = new WeakReference((Activity) context);
        }
        if (f22563v0 == null) {
            f22563v0 = this;
        } else {
            n.h("AppLovinSdk", "Multiple SDK instances detected");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0() {
        if (j0().d()) {
            return;
        }
        J();
        if (n.a()) {
            J().a("AppLovinSdk", "Timing out adapters init...");
        }
        j0().e();
        J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0() {
        tm tmVarJ0 = j0();
        int i11 = this.f22591l0 + 1;
        this.f22591l0 = i11;
        tmVarJ0.a((yl) new jm(i11, this, new c()), tm.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        if (A0()) {
            pb.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0() {
        synchronized (this.f22577e0) {
            try {
                boolean zA = e4.a(l());
                if (!((Boolean) a(sj.f23032p3)).booleanValue() || zA) {
                    P0();
                }
                if (((Boolean) a(sj.f23024o3)).booleanValue() && !zA) {
                    J();
                    if (n.a()) {
                        J().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                    }
                    Q0();
                }
                if (u().e() == i4.a.TERMS) {
                    if (A0()) {
                        J();
                        if (n.a()) {
                            J().a("AppLovinSdk", "MAX mediation detected... Generating consent flow...");
                        }
                        u().a();
                        u().b(n0(), new a());
                    } else {
                        J();
                        if (n.a()) {
                            J().a("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + this.f22582h);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        if (w0()) {
            return;
        }
        this.f22607t0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0() {
        if (w0()) {
            return;
        }
        this.f22605s0.set(true);
        this.f22609u0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0() {
        c(uj.H);
    }

    private q K0() {
        if (!wh.f(f22564w0)) {
            return null;
        }
        try {
            return new q(this);
        } catch (Throwable th2) {
            n.b("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        Long l11 = (Long) a(sj.f23096x3);
        if (l11.longValue() >= 0 && this.f22576e.compareAndSet(false, true)) {
            hr.a(l11.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22838a.D0();
                }
            });
        }
    }

    private void N0() {
        Context context = f22564w0;
        n nVarJ = J();
        vj vjVarI0 = i0();
        h4 h4VarU = u();
        a(context);
        f0();
        h();
        m();
        V();
        L().a(MaxAdapter.InitializationStatus.INITIALIZING);
        NativeCrashReporter.a(this);
        if (TextUtils.isEmpty(this.f22568a)) {
            n.h("AppLovinSdk", "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
            n.h("AppLovinSdk", "Called with an invalid SDK key from: " + Log.getStackTraceString(new Throwable("")));
        }
        if (this.f22568a.length() != 86 && yp.c(this)) {
            n.h("AppLovinSdk", "Please double-check that you entered your SDK key correctly (" + this.f22568a + ") : " + Log.getStackTraceString(new Throwable("")));
        }
        if ("HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(this.f22568a)) {
            n.h("AppLovinSdk", "Cross Promo SDK has been deprecated and is no longer supported");
            if (yp.c(this)) {
                throw new RuntimeException("Cross Promo SDK has been deprecated and is no longer supported");
            }
            return;
        }
        if (yp.i()) {
            n.h("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!yp.b(this)) {
            n.h("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (yp.k(context)) {
            this.f22578f.setVerboseLogging(true);
        }
        h0().a(sj.f22996l, Boolean.valueOf(this.f22578f.isVerboseLoggingEnabled()));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        uj ujVar = uj.f23586c;
        if (TextUtils.isEmpty((String) vjVarI0.a(ujVar, (Object) null, defaultSharedPreferences))) {
            this.f22587j0 = true;
            vjVarI0.b(ujVar, Boolean.toString(true), defaultSharedPreferences);
        } else {
            vjVarI0.b(ujVar, Boolean.toString(false), defaultSharedPreferences);
        }
        uj ujVar2 = uj.f23587d;
        if (((Boolean) vjVarI0.a(ujVar2, Boolean.FALSE)).booleanValue()) {
            if (n.a()) {
                nVarJ.a("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.f22589k0 = true;
        } else {
            if (n.a()) {
                nVarJ.a("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            vjVarI0.b(ujVar2, Boolean.TRUE);
            vjVarI0.b(uj.f23598o, Boolean.valueOf(h4VarU.k()));
        }
        uj ujVar3 = uj.f23588e;
        String str = (String) vjVarI0.a(ujVar3, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE > yp.f(str)) {
                vjVarI0.b(ujVar3, AppLovinSdk.VERSION);
            }
        } else {
            vjVarI0.b(ujVar3, AppLovinSdk.VERSION);
        }
        E().a(la.f20376e, (Object) null, (Map) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        N0();
        if (this.f22578f.isExceptionHandlerEnabled() && ((Boolean) a(sj.f23068u)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        int i11 = StringUtils.parseInt(this.f22578f.getExtraParameters().get("initialization_delay_ms"), ((Integer) a(sj.f23049r4)).intValue());
        tm tmVarJ0 = j0();
        jn jnVar = new jn(this, true, "scheduleAdLoadIntegrationErrorAuto", new Runnable() { // from class: com.applovin.impl.sdk.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22651a.G0();
            }
        });
        tm.b bVar = tm.b.CORE;
        long j11 = i11;
        tmVarJ0.a(jnVar, bVar, j11);
        j0().a(new jn(this, true, "scheduleSdkInit", new Runnable() { // from class: com.applovin.impl.sdk.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22835a.H0();
            }
        }), bVar, j11);
    }

    private Map P() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(sj.f23057s4)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        bg bgVarV = V();
        bgVarV.a(new d(bgVarV));
    }

    public static com.applovin.impl.q a(Context context) {
        if (f22567z0 == null) {
            synchronized (A0) {
                try {
                    if (f22567z0 == null) {
                        f22567z0 = new com.applovin.impl.q(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f22567z0;
    }

    public static String a(int i11) {
        return a(i11, (List) null);
    }

    public static String a(int i11, List list) {
        String string = l().getResources().getString(i11);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public static String a(String str) {
        return a(str, (List) null);
    }

    public static String a(String str, List list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context contextL = l();
        return a(contextL.getResources().getIdentifier(str, "string", contextL.getPackageName()), list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(JSONObject jSONObject) {
        List listAsList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            MaxAdFormat fromString = MaxAdFormat.formatFromString((String) it.next());
            if (fromString != null) {
                arrayList.add(fromString);
            }
        }
        return arrayList;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        f22564w0 = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.f22599p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration) {
        N0();
        this.f22578f.attachAppLovinSdk(this);
        String pluginVersion = appLovinSdkInitializationConfiguration.getPluginVersion();
        if (pluginVersion != null) {
            n.g("AppLovinSdk", "Setting plugin version: " + pluginVersion);
            h0().a(sj.U3, pluginVersion);
        }
        if (appLovinSdkInitializationConfiguration.isExceptionHandlerEnabled() && ((Boolean) a(sj.f23068u)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        tm tmVarJ0 = j0();
        yl ylVar = this.f22607t0;
        tm.b bVar = tm.b.CORE;
        tmVarJ0.a(ylVar, bVar);
        j0().a(this.f22609u0, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        h0().a(sj.U3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList()).iterator();
        while (it.hasNext()) {
            n.h("AppLovinSdk", (String) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.f22599p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        q0().a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        this.f22574d = System.currentTimeMillis();
        e4.c(jSONObject, this);
        e4.b(jSONObject, this);
        e4.a(jSONObject, this);
        qe.f(jSONObject, this);
        qe.d(jSONObject, this);
        qe.e(jSONObject, this);
        qe.g(jSONObject, this);
    }

    private void d() {
        tm tmVarJ0 = j0();
        int i11 = this.f22591l0 + 1;
        this.f22591l0 = i11;
        tmVarJ0.a((yl) new jm(i11, this, new b()), tm.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        J();
        if (n.a()) {
            J().a("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.f22599p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        J();
        if (n.a()) {
            J().a("AppLovinSdk", str);
        }
        j0().a(new sm(this));
    }

    public static long k() {
        return f22565x0;
    }

    public static Context l() {
        return f22564w0;
    }

    public static boolean y0() {
        return f22566y0;
    }

    public EventServiceImpl A() {
        Object eventServiceImpl = this.f22588k.get();
        if (eventServiceImpl == null) {
            synchronized (this.f22588k) {
                try {
                    eventServiceImpl = this.f22588k.get();
                    if (eventServiceImpl == null) {
                        eventServiceImpl = new EventServiceImpl(this);
                        this.f22588k.set(eventServiceImpl);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (eventServiceImpl == this.f22588k) {
            eventServiceImpl = null;
        }
        return (EventServiceImpl) eventServiceImpl;
    }

    public boolean A0() {
        return StringUtils.containsIgnoreCase(O(), AppLovinMediationProvider.MAX);
    }

    public l B() {
        Object lVar = this.C.get();
        if (lVar == null) {
            synchronized (this.C) {
                try {
                    lVar = this.C.get();
                    if (lVar == null) {
                        lVar = new l(this);
                        this.C.set(lVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (lVar == this.C) {
            lVar = null;
        }
        return (l) lVar;
    }

    public boolean B0() {
        return yp.a("com.unity3d.player.UnityPlayerActivity");
    }

    public m C() {
        Object mVar = this.E.get();
        if (mVar == null) {
            synchronized (this.E) {
                try {
                    mVar = this.E.get();
                    if (mVar == null) {
                        mVar = new m(this);
                        this.E.set(mVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (mVar == this.E) {
            mVar = null;
        }
        return (m) mVar;
    }

    public da D() {
        Object daVar = this.f22606t.get();
        if (daVar == null) {
            synchronized (this.f22606t) {
                try {
                    daVar = this.f22606t.get();
                    if (daVar == null) {
                        daVar = new da(this);
                        this.f22606t.set(daVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (daVar == this.f22606t) {
            daVar = null;
        }
        return (da) daVar;
    }

    public ma E() {
        return this.f22598p;
    }

    public dd F() {
        Object ddVar = this.X.get();
        if (ddVar == null) {
            synchronized (this.X) {
                try {
                    ddVar = this.X.get();
                    if (ddVar == null) {
                        ddVar = new dd(this);
                        this.X.set(ddVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (ddVar == this.X) {
            ddVar = null;
        }
        return (dd) ddVar;
    }

    public Activity G() {
        WeakReference weakReference = this.f22570b;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public AppLovinSdkInitializationConfiguration H() {
        return this.f22595n0;
    }

    public long I() {
        return this.f22572c;
    }

    public n J() {
        return this.f22596o;
    }

    public void J0() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if ((u().j() && u().e() == i4.a.UNIFIED) || (sdkInitializationListener = this.f22601q0) == null) {
            return;
        }
        if (u0()) {
            this.f22601q0 = null;
            this.f22603r0 = null;
            L().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.f22603r0 == sdkInitializationListener) {
                return;
            }
            L().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(sj.f23044r)).booleanValue()) {
                this.f22601q0 = null;
            } else {
                this.f22603r0 = sdkInitializationListener;
            }
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.y0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22877a.d(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(sj.f23052s)).longValue()));
    }

    public com.applovin.impl.mediation.d K() {
        Object dVar = this.f22571b0.get();
        if (dVar == null) {
            synchronized (this.f22571b0) {
                try {
                    dVar = this.f22571b0.get();
                    if (dVar == null) {
                        dVar = new com.applovin.impl.mediation.d(this);
                        this.f22571b0.set(dVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (dVar == this.f22571b0) {
            dVar = null;
        }
        return (com.applovin.impl.mediation.d) dVar;
    }

    public com.applovin.impl.mediation.e L() {
        Object eVar = this.V.get();
        if (eVar == null) {
            synchronized (this.V) {
                try {
                    eVar = this.V.get();
                    if (eVar == null) {
                        eVar = new com.applovin.impl.mediation.e(this);
                        this.V.set(eVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (eVar == this.V) {
            eVar = null;
        }
        return (com.applovin.impl.mediation.e) eVar;
    }

    public com.applovin.impl.mediation.f M() {
        Object fVar = this.U.get();
        if (fVar == null) {
            synchronized (this.U) {
                try {
                    fVar = this.U.get();
                    if (fVar == null) {
                        fVar = new com.applovin.impl.mediation.f(this);
                        this.U.set(fVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (fVar == this.U) {
            fVar = null;
        }
        return (com.applovin.impl.mediation.f) fVar;
    }

    public void M0() {
        p().a();
    }

    public ue N() {
        Object ueVar = this.Z.get();
        if (ueVar == null) {
            synchronized (this.Z) {
                try {
                    ueVar = this.Z.get();
                    if (ueVar == null) {
                        ueVar = new ue(this);
                        this.Z.set(ueVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (ueVar == this.Z) {
            ueVar = null;
        }
        return (ue) ueVar;
    }

    public String O() {
        String str = (String) a(uj.H);
        return StringUtils.isValidString(str) ? str : this.f22582h;
    }

    public void P0() {
        synchronized (this.f22577e0) {
            this.f22583h0 = true;
            j0().f();
            d();
        }
    }

    public MediationServiceImpl Q() {
        Object mediationServiceImpl = this.W.get();
        if (mediationServiceImpl == null) {
            synchronized (this.W) {
                try {
                    mediationServiceImpl = this.W.get();
                    if (mediationServiceImpl == null) {
                        mediationServiceImpl = new MediationServiceImpl(this);
                        this.W.set(mediationServiceImpl);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (mediationServiceImpl == this.W) {
            mediationServiceImpl = null;
        }
        return (MediationServiceImpl) mediationServiceImpl;
    }

    public ye R() {
        Object yeVar = this.f22608u.get();
        if (yeVar == null) {
            synchronized (this.f22608u) {
                try {
                    yeVar = this.f22608u.get();
                    if (yeVar == null) {
                        yeVar = new ye(this);
                        this.f22608u.set(yeVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (yeVar == this.f22608u) {
            yeVar = null;
        }
        return (ye) yeVar;
    }

    public void R0() {
        n.h("AppLovinSdk", "Resetting SDK state...");
        da daVarD = D();
        ca caVar = ca.f18155l;
        long jB = daVarD.b(caVar);
        h0().a();
        h0().e();
        D().a();
        D().b(caVar, jB + 1);
        if (this.f22579f0.compareAndSet(true, false)) {
            P0();
        } else {
            this.f22579f0.set(true);
        }
    }

    public ze S() {
        Object zeVar = this.Y.get();
        if (zeVar == null) {
            synchronized (this.Y) {
                try {
                    zeVar = this.Y.get();
                    if (zeVar == null) {
                        zeVar = new ze();
                        this.Y.set(zeVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (zeVar == this.Y) {
            zeVar = null;
        }
        return (ze) zeVar;
    }

    public void S0() {
        if (StringUtils.isValidString(this.f22593m0)) {
            return;
        }
        this.f22593m0 = AppLovinMediationProvider.MAX;
        J();
        if (n.a()) {
            J().a("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public o T() {
        Object oVar = this.f22569a0.get();
        if (oVar == null) {
            synchronized (this.f22569a0) {
                try {
                    oVar = this.f22569a0.get();
                    if (oVar == null) {
                        oVar = new o(this);
                        this.f22569a0.set(oVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (oVar == this.f22569a0) {
            oVar = null;
        }
        return (o) oVar;
    }

    public void T0() {
        w().n();
    }

    public AppLovinNativeAdService U() {
        Object appLovinNativeAdService = this.f22586j.get();
        if (appLovinNativeAdService == null) {
            synchronized (this.f22586j) {
                try {
                    appLovinNativeAdService = this.f22586j.get();
                    if (appLovinNativeAdService == null) {
                        appLovinNativeAdService = new AppLovinNativeAdService(this);
                        this.f22586j.set(appLovinNativeAdService);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (appLovinNativeAdService == this.f22586j) {
            appLovinNativeAdService = null;
        }
        return (AppLovinNativeAdService) appLovinNativeAdService;
    }

    public void U0() {
        a((Map) null);
    }

    public bg V() {
        Object bgVar = this.H.get();
        if (bgVar == null) {
            synchronized (this.H) {
                try {
                    bgVar = this.H.get();
                    if (bgVar == null) {
                        bgVar = new bg(l());
                        this.H.set(bgVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (bgVar == this.H) {
            bgVar = null;
        }
        return (bg) bgVar;
    }

    public qg W() {
        Object qgVar = this.O.get();
        if (qgVar == null) {
            synchronized (this.O) {
                try {
                    qgVar = this.O.get();
                    if (qgVar == null) {
                        qgVar = new qg(this);
                        this.O.set(qgVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (qgVar == this.O) {
            qgVar = null;
        }
        return (qg) qgVar;
    }

    public com.applovin.impl.sdk.network.b X() {
        Object bVar = this.S.get();
        if (bVar == null) {
            synchronized (this.S) {
                try {
                    bVar = this.S.get();
                    if (bVar == null) {
                        bVar = new com.applovin.impl.sdk.network.b(this);
                        this.S.set(bVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (bVar == this.S) {
            bVar = null;
        }
        return (com.applovin.impl.sdk.network.b) bVar;
    }

    public PostbackServiceImpl Y() {
        Object postbackServiceImpl = this.R.get();
        if (postbackServiceImpl == null) {
            synchronized (this.R) {
                try {
                    postbackServiceImpl = this.R.get();
                    if (postbackServiceImpl == null) {
                        postbackServiceImpl = new PostbackServiceImpl(this);
                        this.R.set(postbackServiceImpl);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (postbackServiceImpl == this.R) {
            postbackServiceImpl = null;
        }
        return (PostbackServiceImpl) postbackServiceImpl;
    }

    public q Z() {
        Object objK0 = this.f22611w.get();
        if (objK0 == null) {
            synchronized (this.f22611w) {
                try {
                    objK0 = this.f22611w.get();
                    if (objK0 == null) {
                        objK0 = K0();
                        if (objK0 == null) {
                            objK0 = this.f22611w;
                        }
                        this.f22611w.set(objK0);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (objK0 == this.f22611w) {
            objK0 = null;
        }
        return (q) objK0;
    }

    public Object a(sj sjVar) {
        return h0().a(sjVar);
    }

    public Object a(uj ujVar) {
        return a(ujVar, (Object) null);
    }

    public Object a(uj ujVar, Object obj) {
        return i0().a(ujVar, obj);
    }

    public Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return vj.a(str, obj, cls, sharedPreferences);
    }

    public void a() {
        String str = (String) i0().a(uj.f23588e, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < yp.f(str)) {
                n.h("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public void a(long j11) {
        t().b(j11);
    }

    public void a(SharedPreferences sharedPreferences) {
        i0().a(sharedPreferences);
    }

    public void a(pe peVar) {
        if (j0().d()) {
            return;
        }
        List listC = c(ve.G6);
        if (listC.size() <= 0 || !L().a().containsAll(listC)) {
            return;
        }
        J();
        if (n.a()) {
            J().a("AppLovinSdk", "All required adapters initialized");
        }
        j0().e();
        J0();
    }

    public void a(final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (!u0()) {
            this.f22601q0 = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22836a.c(sdkInitializationListener);
                }
            });
        }
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.f22594n = appLovinSdk;
    }

    public void a(final AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (this.f22605s0.get()) {
            n.h("AppLovinSdk", "Invalid initialization process. Please initialize the SDK as soon as possible with \"AppLovinSdk#initialize(AppLovinSdkInitializationConfiguration, AppLovinSdk.SdkInitializationListener)\" before accessing any SDK fields or functions");
            E().a(la.L, "legacy_init_already");
            if (yp.c(this)) {
                throw new IllegalStateException("Invalid initialization process. Please initialize the SDK as soon as possible with \"AppLovinSdk#initialize(AppLovinSdkInitializationConfiguration, AppLovinSdk.SdkInitializationListener)\" before accessing any SDK fields or functions");
            }
            return;
        }
        synchronized (this.f22597o0) {
            try {
                if (this.f22595n0 != null) {
                    if (!u0() || sdkInitializationListener == null) {
                        return;
                    }
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.n0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f22671a.b(sdkInitializationListener);
                        }
                    });
                    return;
                }
                this.f22595n0 = appLovinSdkInitializationConfiguration;
                this.f22601q0 = sdkInitializationListener;
                this.f22568a = appLovinSdkInitializationConfiguration.getSdkKey();
                this.f22582h = appLovinSdkInitializationConfiguration.getMediationProvider();
                this.f22580g = appLovinSdkInitializationConfiguration.getSegmentCollection();
                yp.a(new Runnable() { // from class: com.applovin.impl.sdk.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22815a.a(appLovinSdkInitializationConfiguration);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(String str, AppLovinSdkSettings appLovinSdkSettings) {
        z0().set(true);
        this.f22568a = str;
        this.f22578f = appLovinSdkSettings;
        yp.a(new Runnable() { // from class: com.applovin.impl.sdk.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f22666a.O0();
            }
        });
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        i0().a(str, obj, editor);
    }

    public void a(Map map) {
        N().a(map);
    }

    public void a(boolean z11) {
        synchronized (this.f22577e0) {
            this.f22583h0 = false;
            this.f22585i0 = z11;
        }
        if (z11) {
            List listC = c(ve.G6);
            if (listC.isEmpty()) {
                j0().e();
                J0();
                return;
            }
            Long l11 = (Long) a(ve.H6);
            jn jnVar = new jn(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22834a.C0();
                }
            });
            J();
            if (n.a()) {
                J().a("AppLovinSdk", "Waiting for required adapters to init: " + listC + " - timing out in " + l11 + "ms...");
            }
            j0().a(jnVar, tm.b.TIMEOUT, l11.longValue(), true);
        }
    }

    public boolean a(sj sjVar, MaxAdFormat maxAdFormat) {
        return b(sjVar).contains(maxAdFormat);
    }

    public boolean a(sj sjVar, String str) {
        Iterator it = c(sjVar).iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List list = this.f22575d0;
        return (list == null || list.size() <= 0 || this.f22575d0.contains(maxAdFormat)) ? false : true;
    }

    public String a0() {
        return q0().a();
    }

    public Object b(uj ujVar) {
        return i0().a(ujVar);
    }

    public String b() {
        if (StringUtils.isValidString(this.f22593m0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map mapP = P();
        List listC = c(sj.f23073u4);
        Boolean bool = (Boolean) a(sj.f23081v4);
        if (mapP.isEmpty() && !bool.booleanValue()) {
            return null;
        }
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Integer numValueOf = (Integer) a(sj.f23065t4);
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (numValueOf.intValue() <= 0) {
                    break;
                }
                String className = stackTraceElement.getClassName();
                Iterator it = listC.iterator();
                do {
                    if (!it.hasNext()) {
                        for (Map.Entry entry : mapP.entrySet()) {
                            if (className.startsWith((String) entry.getKey())) {
                                this.f22593m0 = (String) entry.getValue();
                                J();
                                if (n.a()) {
                                    J().a("AppLovinSdk", "Detected mediation provider: " + this.f22593m0);
                                }
                                return null;
                            }
                        }
                        if (bool.booleanValue()) {
                            arrayList.add(className);
                        }
                        numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                        break;
                    }
                } while (!className.startsWith((String) it.next()));
            }
        } catch (Throwable th2) {
            E().a("AppLovinSdk", "detectMediationProvider", th2);
        }
        this.f22593m0 = AppLovinMediationProvider.UNKNOWN;
        J();
        if (n.a()) {
            J().k("AppLovinSdk", "Unable to detect mediation provider");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        String strJoin = StringUtils.join(",", arrayList);
        if (!((Boolean) a(sj.f23089w4)).booleanValue()) {
            return strJoin;
        }
        E().a(la.f20375d, "detectMediationProvider", (Map) CollectionUtils.hashMap("details", strJoin));
        return null;
    }

    public List b(sj sjVar) {
        return h0().b(sjVar);
    }

    public void b(uj ujVar, Object obj) {
        i0().b(ujVar, obj);
    }

    public String b0() {
        return this.f22568a;
    }

    public List c(sj sjVar) {
        return h0().c(sjVar);
    }

    public void c() {
        synchronized (this.f22577e0) {
            try {
                if (!this.f22583h0 && !this.f22585i0) {
                    P0();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c(uj ujVar) {
        i0().b(ujVar);
    }

    public MaxSegmentCollectionImpl c0() {
        return (MaxSegmentCollectionImpl) this.f22580g;
    }

    public Map d0() {
        MaxSegmentCollectionImpl maxSegmentCollectionImplC0 = c0();
        if (maxSegmentCollectionImplC0 == null) {
            return null;
        }
        return maxSegmentCollectionImplC0.getJsonData();
    }

    public com.applovin.impl.q e() {
        return a(f22564w0);
    }

    public void e(String str) {
        J();
        if (n.a()) {
            J().a("AppLovinSdk", "setMediationProvider(mediationProvider=" + str + ")");
        }
        if (str == null || (!str.isEmpty() && str.length() <= 64 && StringUtils.isAlphaNumeric(str))) {
            this.f22582h = str;
            if (yp.h()) {
                yp.a(new Runnable() { // from class: com.applovin.impl.sdk.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22821a.I0();
                    }
                });
                return;
            } else {
                c(uj.H);
                return;
            }
        }
        n.h("AppLovinSdk", "Mediation provider set to invalid value: " + str + ". Please use a valid mediation provider (e.g., AppLovinMediationProvider.MAX)");
    }

    public oj e0() {
        Object ojVar = this.J.get();
        if (ojVar == null) {
            synchronized (this.J) {
                try {
                    ojVar = this.J.get();
                    if (ojVar == null) {
                        ojVar = new oj(this);
                        this.J.set(ojVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (ojVar == this.J) {
            ojVar = null;
        }
        return (oj) ojVar;
    }

    public com.applovin.impl.sdk.a f() {
        Object aVar = this.B.get();
        if (aVar == null) {
            synchronized (this.B) {
                try {
                    aVar = this.B.get();
                    if (aVar == null) {
                        aVar = new com.applovin.impl.sdk.a(this);
                        this.B.set(aVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (aVar == this.B) {
            aVar = null;
        }
        return (com.applovin.impl.sdk.a) aVar;
    }

    public void f(final String str) {
        n.g("AppLovinSdk", "Setting plugin version: " + str);
        if (yp.h()) {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22841a.b(str);
                }
            });
        } else {
            h0().a(sj.U3, str);
        }
    }

    public SessionTracker f0() {
        Object sessionTracker = this.D.get();
        if (sessionTracker == null) {
            synchronized (this.D) {
                try {
                    sessionTracker = this.D.get();
                    if (sessionTracker == null) {
                        sessionTracker = new SessionTracker(this);
                        this.D.set(sessionTracker);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (sessionTracker == this.D) {
            sessionTracker = null;
        }
        return (SessionTracker) sessionTracker;
    }

    public com.applovin.impl.sdk.c g() {
        Object cVar = this.A.get();
        if (cVar == null) {
            synchronized (this.A) {
                try {
                    cVar = this.A.get();
                    if (cVar == null) {
                        cVar = new com.applovin.impl.sdk.c(this);
                        this.A.set(cVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (cVar == this.A) {
            cVar = null;
        }
        return (com.applovin.impl.sdk.c) cVar;
    }

    public void g(final String str) {
        J();
        if (n.a()) {
            J().a("AppLovinSdk", "Setting user id: " + str);
        }
        if (StringUtils.isValidString(str) && str.length() > yp.b(8)) {
            n.h("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + yp.b(8) + " maximum)");
        }
        if (yp.h()) {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22871a.c(str);
                }
            });
        } else {
            q0().a(str);
        }
    }

    public AppLovinSdkSettings g0() {
        return this.f22578f;
    }

    public com.applovin.impl.v h() {
        Object vVar = this.T.get();
        if (vVar == null) {
            synchronized (this.T) {
                try {
                    vVar = this.T.get();
                    if (vVar == null) {
                        vVar = new com.applovin.impl.v(this);
                        this.T.set(vVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (vVar == this.T) {
            vVar = null;
        }
        return (com.applovin.impl.v) vVar;
    }

    public tj h0() {
        Object tjVar = this.f22602r.get();
        if (tjVar == null) {
            synchronized (this.f22602r) {
                try {
                    tjVar = this.f22602r.get();
                    if (tjVar == null) {
                        tjVar = new tj(this);
                        this.f22602r.set(tjVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (tjVar == this.f22602r) {
            tjVar = null;
        }
        return (tj) tjVar;
    }

    public AppLovinAdServiceImpl i() {
        Object appLovinAdServiceImpl = this.f22584i.get();
        if (appLovinAdServiceImpl == null) {
            synchronized (this.f22584i) {
                try {
                    appLovinAdServiceImpl = this.f22584i.get();
                    if (appLovinAdServiceImpl == null) {
                        appLovinAdServiceImpl = new AppLovinAdServiceImpl(this);
                        this.f22584i.set(appLovinAdServiceImpl);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (appLovinAdServiceImpl == this.f22584i) {
            appLovinAdServiceImpl = null;
        }
        return (AppLovinAdServiceImpl) appLovinAdServiceImpl;
    }

    public vj i0() {
        Object vjVar = this.f22612x.get();
        if (vjVar == null) {
            synchronized (this.f22612x) {
                try {
                    vjVar = this.f22612x.get();
                    if (vjVar == null) {
                        vjVar = new vj(this);
                        this.f22612x.set(vjVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (vjVar == this.f22612x) {
            vjVar = null;
        }
        return (vj) vjVar;
    }

    public e j() {
        Object eVar = this.F.get();
        if (eVar == null) {
            synchronized (this.F) {
                try {
                    eVar = this.F.get();
                    if (eVar == null) {
                        eVar = new e(this);
                        this.F.set(eVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (eVar == this.F) {
            eVar = null;
        }
        return (e) eVar;
    }

    public tm j0() {
        Object tmVar = this.f22600q.get();
        if (tmVar == null) {
            synchronized (this.f22600q) {
                try {
                    tmVar = this.f22600q.get();
                    if (tmVar == null) {
                        tmVar = new tm(this);
                        this.f22600q.set(tmVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (tmVar == this.f22600q) {
            tmVar = null;
        }
        return (tm) tmVar;
    }

    public qn k0() {
        Object qnVar = this.M.get();
        if (qnVar == null) {
            synchronized (this.M) {
                try {
                    qnVar = this.M.get();
                    if (qnVar == null) {
                        qnVar = new qn(this);
                        this.M.set(qnVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (qnVar == this.M) {
            qnVar = null;
        }
        return (qn) qnVar;
    }

    public wn l0() {
        Object wnVar = this.f22573c0.get();
        if (wnVar == null) {
            synchronized (this.f22573c0) {
                try {
                    wnVar = this.f22573c0.get();
                    if (wnVar == null) {
                        wnVar = new wn(this);
                        this.f22573c0.set(wnVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (wnVar == this.f22573c0) {
            wnVar = null;
        }
        return (wn) wnVar;
    }

    public ArrayService m() {
        Object arrayService = this.P.get();
        if (arrayService == null) {
            synchronized (this.P) {
                try {
                    arrayService = this.P.get();
                    if (arrayService == null) {
                        arrayService = new ArrayService(this);
                        this.P.set(arrayService);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (arrayService == this.P) {
            arrayService = null;
        }
        return (ArrayService) arrayService;
    }

    public long m0() {
        if (this.f22574d == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.f22574d;
    }

    public f n() {
        Object fVar = this.K.get();
        if (fVar == null) {
            synchronized (this.K) {
                try {
                    fVar = this.K.get();
                    if (fVar == null) {
                        fVar = new f(this);
                        this.K.set(fVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (fVar == this.K) {
            fVar = null;
        }
        return (f) fVar;
    }

    public Activity n0() {
        Activity activityB = a(l()).b();
        return activityB != null ? activityB : G();
    }

    public CmpServiceImpl o() {
        Object cmpServiceImpl = this.f22592m.get();
        if (cmpServiceImpl == null) {
            synchronized (this.f22592m) {
                try {
                    cmpServiceImpl = this.f22592m.get();
                    if (cmpServiceImpl == null) {
                        cmpServiceImpl = new CmpServiceImpl(this);
                        this.f22592m.set(cmpServiceImpl);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (cmpServiceImpl == this.f22592m) {
            cmpServiceImpl = null;
        }
        return (CmpServiceImpl) cmpServiceImpl;
    }

    public String o0() {
        return q0().c();
    }

    public g p() {
        Object gVar = this.I.get();
        if (gVar == null) {
            synchronized (this.I) {
                try {
                    gVar = this.I.get();
                    if (gVar == null) {
                        gVar = new g(this);
                        this.I.set(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (gVar == this.I) {
            gVar = null;
        }
        return (g) gVar;
    }

    public UserServiceImpl p0() {
        Object userServiceImpl = this.f22590l.get();
        if (userServiceImpl == null) {
            synchronized (this.f22590l) {
                try {
                    userServiceImpl = this.f22590l.get();
                    if (userServiceImpl == null) {
                        userServiceImpl = new UserServiceImpl(this);
                        this.f22590l.set(userServiceImpl);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (userServiceImpl == this.f22590l) {
            userServiceImpl = null;
        }
        return (UserServiceImpl) userServiceImpl;
    }

    public String q() {
        return q0().b();
    }

    public wp q0() {
        Object wpVar = this.f22614z.get();
        if (wpVar == null) {
            synchronized (this.f22614z) {
                try {
                    wpVar = this.f22614z.get();
                    if (wpVar == null) {
                        wpVar = new wp(this);
                        this.f22614z.set(wpVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (wpVar == this.f22614z) {
            wpVar = null;
        }
        return (wp) wpVar;
    }

    public AppLovinSdkConfiguration r() {
        return this.f22599p0;
    }

    public qr r0() {
        Object qrVar = this.G.get();
        if (qrVar == null) {
            synchronized (this.G) {
                try {
                    qrVar = this.G.get();
                    if (qrVar == null) {
                        qrVar = new qr(this);
                        this.G.set(qrVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (qrVar == this.G) {
            qrVar = null;
        }
        return (qr) qrVar;
    }

    public d4 s() {
        Object d4Var = this.f22604s.get();
        if (d4Var == null) {
            synchronized (this.f22604s) {
                try {
                    d4Var = this.f22604s.get();
                    if (d4Var == null) {
                        d4Var = new d4(this);
                        this.f22604s.set(d4Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (d4Var == this.f22604s) {
            d4Var = null;
        }
        return (d4) d4Var;
    }

    public AppLovinSdk s0() {
        return this.f22594n;
    }

    public i t() {
        Object iVar = this.f22613y.get();
        if (iVar == null) {
            synchronized (this.f22613y) {
                try {
                    iVar = this.f22613y.get();
                    if (iVar == null) {
                        iVar = new i(this);
                        this.f22613y.set(iVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (iVar == this.f22613y) {
            iVar = null;
        }
        return (i) iVar;
    }

    public boolean t0() {
        return this.f22589k0;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f22568a + "', enabled=" + this.f22585i0 + ", isFirstSession=" + this.f22587j0 + '}';
    }

    public h4 u() {
        Object h4Var = this.L.get();
        if (h4Var == null) {
            synchronized (this.L) {
                try {
                    h4Var = this.L.get();
                    if (h4Var == null) {
                        h4Var = new h4(this);
                        this.L.set(h4Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (h4Var == this.L) {
            h4Var = null;
        }
        return (h4) h4Var;
    }

    public boolean u0() {
        boolean z11;
        synchronized (this.f22577e0) {
            z11 = this.f22585i0;
        }
        return z11;
    }

    public AppLovinTermsAndPrivacyPolicyFlowSettings v() {
        return g0().getBackingConsentFlowSettings();
    }

    public boolean v0() {
        return this.f22587j0;
    }

    public y4 w() {
        Object y4Var = this.N.get();
        if (y4Var == null) {
            synchronized (this.N) {
                try {
                    y4Var = this.N.get();
                    if (y4Var == null) {
                        y4Var = new y4(this);
                        this.N.set(y4Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (y4Var == this.N) {
            y4Var = null;
        }
        return (y4) y4Var;
    }

    public boolean w0() {
        boolean z11;
        synchronized (this.f22597o0) {
            z11 = this.f22595n0 != null;
        }
        return z11;
    }

    public d5 x() {
        Object d5Var = this.Q.get();
        if (d5Var == null) {
            synchronized (this.Q) {
                try {
                    d5Var = this.Q.get();
                    if (d5Var == null) {
                        d5Var = new d5(this);
                        this.Q.set(d5Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (d5Var == this.Q) {
            d5Var = null;
        }
        return (d5) d5Var;
    }

    public boolean x0() {
        boolean z11;
        synchronized (this.f22577e0) {
            z11 = this.f22583h0;
        }
        return z11;
    }

    public k y() {
        Object kVar = this.f22610v.get();
        if (kVar == null) {
            synchronized (this.f22610v) {
                try {
                    kVar = this.f22610v.get();
                    if (kVar == null) {
                        kVar = new k(this);
                        this.f22610v.set(kVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (kVar == this.f22610v) {
            kVar = null;
        }
        return (k) kVar;
    }

    public String z() {
        return this.f22593m0;
    }

    public AtomicBoolean z0() {
        return this.f22605s0;
    }
}
