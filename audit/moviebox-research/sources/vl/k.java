package vl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k implements ml.a.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ql.a f78979s = ql.a.e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final k f78980t = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Integer> f78981a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public jj.e f78984d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public ll.c f78985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public cl.g f78986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public bl.b<cg.h> f78987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f78988i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f78990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public nl.a f78991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f78992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ml.a f78993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.google.firebase.perf.v1.c.b f78994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f78995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f78996q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<c> f78982b = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f78983c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f78997r = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ExecutorService f78989j = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public k() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f78981a = concurrentHashMap;
        concurrentHashMap.put("KEY_AVAILABLE_TRACES_FOR_CACHING", 50);
        concurrentHashMap.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", 50);
        concurrentHashMap.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", 50);
    }

    public static k k() {
        return f78980t;
    }

    public static String l(com.google.firebase.perf.v1.f fVar) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(fVar.d0()), Integer.valueOf(fVar.a0()), Integer.valueOf(fVar.Z()));
    }

    public static String m(NetworkRequestMetric networkRequestMetric) {
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %sms)", networkRequestMetric.s0(), networkRequestMetric.v0() ? String.valueOf(networkRequestMetric.k0()) : "UNKNOWN", new DecimalFormat("#.####").format((networkRequestMetric.z0() ? networkRequestMetric.q0() : 0L) / 1000.0d));
    }

    public static String n(com.google.firebase.perf.v1.i iVar) {
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %sms)", iVar.o0(), new DecimalFormat("#.####").format(iVar.l0() / 1000.0d));
    }

    public static String o(wl.a aVar) {
        if (aVar.m()) {
            return n(aVar.n());
        }
        if (aVar.d()) {
            return m(aVar.f());
        }
        return aVar.a() ? l(aVar.o()) : "log";
    }

    public static String p(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public void A(final com.google.firebase.perf.v1.f fVar, final ApplicationProcessState applicationProcessState) {
        this.f78989j.execute(new Runnable() { // from class: vl.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f78974a.y(fVar, applicationProcessState);
            }
        });
    }

    public void B(final NetworkRequestMetric networkRequestMetric, final ApplicationProcessState applicationProcessState) {
        this.f78989j.execute(new Runnable() { // from class: vl.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f78970a.x(networkRequestMetric, applicationProcessState);
            }
        });
    }

    public void C(final com.google.firebase.perf.v1.i iVar, final ApplicationProcessState applicationProcessState) {
        this.f78989j.execute(new Runnable() { // from class: vl.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f78966a.w(iVar, applicationProcessState);
            }
        });
    }

    public final com.google.firebase.perf.v1.g D(com.google.firebase.perf.v1.g.b bVar, ApplicationProcessState applicationProcessState) {
        G();
        com.google.firebase.perf.v1.c.b bVarO = this.f78994o.O(applicationProcessState);
        if (bVar.m() || bVar.d()) {
            bVarO = bVarO.clone().L(j());
        }
        return bVar.K(bVarO).build();
    }

    public final void E() {
        Context contextJ = this.f78984d.j();
        this.f78990k = contextJ;
        this.f78995p = contextJ.getPackageName();
        this.f78991l = nl.a.g();
        this.f78992m = new d(this.f78990k, new com.google.firebase.perf.util.g(100L, 1L, TimeUnit.MINUTES), 500L);
        this.f78993n = ml.a.b();
        this.f78988i = new b(this.f78987h, this.f78991l.a());
        h();
    }

    public final void F(com.google.firebase.perf.v1.g.b bVar, ApplicationProcessState applicationProcessState) {
        if (!u()) {
            if (s(bVar)) {
                f78979s.b("Transport is not initialized yet, %s will be queued for to be dispatched later", o(bVar));
                this.f78982b.add(new c(bVar, applicationProcessState));
                return;
            }
            return;
        }
        com.google.firebase.perf.v1.g gVarD = D(bVar, applicationProcessState);
        if (t(gVarD)) {
            g(gVarD);
            SessionManager.getInstance().updatePerfSessionIfExpired();
        }
    }

    public final void G() {
        String str;
        if (this.f78991l.K()) {
            if (!this.f78994o.K() || this.f78997r) {
                try {
                    str = (String) Tasks.await(this.f78986g.getId(), ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e11) {
                    f78979s.d("Task to retrieve Installation Id is interrupted: %s", e11.getMessage());
                    str = null;
                } catch (ExecutionException e12) {
                    f78979s.d("Unable to retrieve Installation Id: %s", e12.getMessage());
                    str = null;
                } catch (TimeoutException e13) {
                    f78979s.d("Task to retrieve Installation Id is timed out: %s", e13.getMessage());
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    f78979s.j("Firebase Installation Id is empty, contact Firebase Support for debugging.");
                } else {
                    this.f78994o.N(str);
                }
            }
        }
    }

    public final void H() {
        if (this.f78985f == null && u()) {
            this.f78985f = ll.c.c();
        }
    }

    public final void g(com.google.firebase.perf.v1.g gVar) {
        if (gVar.m()) {
            f78979s.g("Logging %s. In a minute, visit the Firebase console to view your data: %s", o(gVar), i(gVar.n()));
        } else {
            f78979s.g("Logging %s", o(gVar));
        }
        this.f78988i.b(gVar);
    }

    public final void h() {
        this.f78993n.k(new WeakReference<>(f78980t));
        com.google.firebase.perf.v1.c.b bVarE0 = com.google.firebase.perf.v1.c.e0();
        this.f78994o = bVarE0;
        bVarE0.P(this.f78984d.m().c()).M(com.google.firebase.perf.v1.a.X().K(this.f78995p).L(ll.a.f70306b).M(p(this.f78990k)));
        this.f78983c.set(true);
        while (!this.f78982b.isEmpty()) {
            final c cVarPoll = this.f78982b.poll();
            if (cVarPoll != null) {
                this.f78989j.execute(new Runnable() { // from class: vl.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f78977a.v(cVarPoll);
                    }
                });
            }
        }
    }

    public final String i(com.google.firebase.perf.v1.i iVar) {
        String strO0 = iVar.o0();
        return strO0.startsWith("_st_") ? ql.b.c(this.f78996q, this.f78995p, strO0) : ql.b.a(this.f78996q, this.f78995p, strO0);
    }

    public final Map<String, String> j() {
        H();
        ll.c cVar = this.f78985f;
        return cVar != null ? cVar.b() : Collections.emptyMap();
    }

    @Override // ml.a.b
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.f78997r = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (u()) {
            this.f78989j.execute(new Runnable() { // from class: vl.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f78973a.z();
                }
            });
        }
    }

    public final void q(com.google.firebase.perf.v1.g gVar) {
        if (gVar.m()) {
            this.f78993n.d(Constants$CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        } else if (gVar.d()) {
            this.f78993n.d(Constants$CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        }
    }

    public void r(@NonNull jj.e eVar, @NonNull cl.g gVar, @NonNull bl.b<cg.h> bVar) {
        this.f78984d = eVar;
        this.f78996q = eVar.m().e();
        this.f78986g = gVar;
        this.f78987h = bVar;
        this.f78989j.execute(new Runnable() { // from class: vl.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f78969a.E();
            }
        });
    }

    public final boolean s(wl.a aVar) {
        int iIntValue = this.f78981a.get("KEY_AVAILABLE_TRACES_FOR_CACHING").intValue();
        int iIntValue2 = this.f78981a.get("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING").intValue();
        int iIntValue3 = this.f78981a.get("KEY_AVAILABLE_GAUGES_FOR_CACHING").intValue();
        if (aVar.m() && iIntValue > 0) {
            this.f78981a.put("KEY_AVAILABLE_TRACES_FOR_CACHING", Integer.valueOf(iIntValue - 1));
            return true;
        }
        if (aVar.d() && iIntValue2 > 0) {
            this.f78981a.put("KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING", Integer.valueOf(iIntValue2 - 1));
            return true;
        }
        if (!aVar.a() || iIntValue3 <= 0) {
            f78979s.b("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", o(aVar), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue3));
            return false;
        }
        this.f78981a.put("KEY_AVAILABLE_GAUGES_FOR_CACHING", Integer.valueOf(iIntValue3 - 1));
        return true;
    }

    public final boolean t(com.google.firebase.perf.v1.g gVar) {
        if (!this.f78991l.K()) {
            f78979s.g("Performance collection is not enabled, dropping %s", o(gVar));
            return false;
        }
        if (!gVar.V().a0()) {
            f78979s.k("App Instance ID is null or empty, dropping %s", o(gVar));
            return false;
        }
        if (!rl.e.b(gVar, this.f78990k)) {
            f78979s.k("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", o(gVar));
            return false;
        }
        if (!this.f78992m.h(gVar)) {
            q(gVar);
            f78979s.g("Event dropped due to device sampling - %s", o(gVar));
            return false;
        }
        if (!this.f78992m.g(gVar)) {
            return true;
        }
        q(gVar);
        f78979s.g("Rate limited (per device) - %s", o(gVar));
        return false;
    }

    public boolean u() {
        return this.f78983c.get();
    }

    public final /* synthetic */ void v(c cVar) {
        F(cVar.f78946a, cVar.f78947b);
    }

    public final /* synthetic */ void w(com.google.firebase.perf.v1.i iVar, ApplicationProcessState applicationProcessState) {
        F(com.google.firebase.perf.v1.g.X().N(iVar), applicationProcessState);
    }

    public final /* synthetic */ void x(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        F(com.google.firebase.perf.v1.g.X().M(networkRequestMetric), applicationProcessState);
    }

    public final /* synthetic */ void y(com.google.firebase.perf.v1.f fVar, ApplicationProcessState applicationProcessState) {
        F(com.google.firebase.perf.v1.g.X().L(fVar), applicationProcessState);
    }

    public final /* synthetic */ void z() {
        this.f78992m.a(this.f78997r);
    }
}
