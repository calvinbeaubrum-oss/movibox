package com.google.firebase.perf.metrics;

import androidx.annotation.Nullable;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j extends ml.b implements tl.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ql.a f41006j = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PerfSession> f41007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GaugeManager f41008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vl.k f41009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NetworkRequestMetric.b f41010d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<tl.a> f41011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public String f41012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f41013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f41014i;

    public j(vl.k kVar) {
        this(kVar, ml.a.b(), GaugeManager.getInstance());
    }

    public j(vl.k kVar, ml.a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.f41010d = NetworkRequestMetric.B0();
        this.f41011f = new WeakReference<>(this);
        this.f41009c = kVar;
        this.f41008b = gaugeManager;
        this.f41007a = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }

    public static j d(vl.k kVar) {
        return new j(kVar);
    }

    public static boolean g(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt <= 31 || cCharAt > 127) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStarted() {
        return this.f41010d.N();
    }

    private boolean isStopped() {
        return this.f41010d.P();
    }

    public NetworkRequestMetric c() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.f41011f);
        unregisterForAppState();
        com.google.firebase.perf.v1.h[] hVarArrBuildAndSort = PerfSession.buildAndSort(getSessions());
        if (hVarArrBuildAndSort != null) {
            this.f41010d.K(Arrays.asList(hVarArrBuildAndSort));
        }
        NetworkRequestMetric networkRequestMetricBuild = this.f41010d.build();
        if (!sl.j.c(this.f41012g)) {
            f41006j.a("Dropping network request from a 'User-Agent' that is not allowed");
            return networkRequestMetricBuild;
        }
        if (this.f41013h) {
            if (this.f41014i) {
                f41006j.a("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return networkRequestMetricBuild;
        }
        this.f41009c.B(networkRequestMetricBuild, getAppState());
        this.f41013h = true;
        return networkRequestMetricBuild;
    }

    public long e() {
        return this.f41010d.M();
    }

    public boolean f() {
        return this.f41010d.O();
    }

    public List<PerfSession> getSessions() {
        List<PerfSession> listUnmodifiableList;
        synchronized (this.f41007a) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PerfSession perfSession : this.f41007a) {
                    if (perfSession != null) {
                        arrayList.add(perfSession);
                    }
                }
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return listUnmodifiableList;
    }

    public j h(@Nullable String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            switch (upperCase) {
                case "OPTIONS":
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case "GET":
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case "PUT":
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case "HEAD":
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case "POST":
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case "PATCH":
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case "TRACE":
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case "CONNECT":
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case "DELETE":
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.f41010d.R(httpMethod);
        }
        return this;
    }

    public j i(int i11) {
        this.f41010d.S(i11);
        return this;
    }

    public void j() {
        this.f41014i = true;
    }

    public j k() {
        this.f41010d.T(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public j l(long j11) {
        this.f41010d.U(j11);
        return this;
    }

    public j m(long j11) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.f41011f);
        this.f41010d.Q(j11);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.f41008b.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public j n(@Nullable String str) {
        if (str == null) {
            this.f41010d.L();
            return this;
        }
        if (g(str)) {
            this.f41010d.V(str);
        } else {
            f41006j.j("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public j o(long j11) {
        this.f41010d.W(j11);
        return this;
    }

    public j p(long j11) {
        this.f41010d.X(j11);
        return this;
    }

    public j q(long j11) {
        this.f41010d.Y(j11);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.f41008b.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public j r(long j11) {
        this.f41010d.Z(j11);
        return this;
    }

    public j s(@Nullable String str) {
        if (str != null) {
            this.f41010d.a0(com.google.firebase.perf.util.k.e(com.google.firebase.perf.util.k.d(str), 2000));
        }
        return this;
    }

    public j t(@Nullable String str) {
        this.f41012g = str;
        return this;
    }

    @Override // tl.a
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            f41006j.j("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else {
            if (!hasStarted() || isStopped()) {
                return;
            }
            this.f41007a.add(perfSession);
        }
    }
}
