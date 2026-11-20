package vl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nl.a f78948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f78949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f78950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f78951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f78952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f78953f;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final ql.a f78954k = ql.a.e();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final long f78955l = TimeUnit.SECONDS.toMicros(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.firebase.perf.util.a f78956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f78957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Timer f78958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.google.firebase.perf.util.g f78959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f78960e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f78961f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.google.firebase.perf.util.g f78962g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.google.firebase.perf.util.g f78963h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f78964i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f78965j;

        public a(com.google.firebase.perf.util.g gVar, long j11, com.google.firebase.perf.util.a aVar, nl.a aVar2, String str, boolean z11) {
            this.f78956a = aVar;
            this.f78960e = j11;
            this.f78959d = gVar;
            this.f78961f = j11;
            this.f78958c = aVar.a();
            g(aVar2, str, z11);
            this.f78957b = z11;
        }

        public static long c(nl.a aVar, String str) {
            return str == "Trace" ? aVar.E() : aVar.q();
        }

        public static long d(nl.a aVar, String str) {
            return str == "Trace" ? aVar.t() : aVar.t();
        }

        public static long e(nl.a aVar, String str) {
            return str == "Trace" ? aVar.F() : aVar.r();
        }

        public static long f(nl.a aVar, String str) {
            return str == "Trace" ? aVar.t() : aVar.t();
        }

        public synchronized void a(boolean z11) {
            try {
                this.f78959d = z11 ? this.f78962g : this.f78963h;
                this.f78960e = z11 ? this.f78964i : this.f78965j;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public synchronized boolean b(@NonNull com.google.firebase.perf.v1.g gVar) {
            try {
                Timer timerA = this.f78956a.a();
                double durationMicros = (this.f78958c.getDurationMicros(timerA) * this.f78959d.a()) / f78955l;
                if (durationMicros > 0.0d) {
                    this.f78961f = Math.min(this.f78961f + durationMicros, this.f78960e);
                    this.f78958c = timerA;
                }
                double d11 = this.f78961f;
                if (d11 >= 1.0d) {
                    this.f78961f = d11 - 1.0d;
                    return true;
                }
                if (this.f78957b) {
                    f78954k.j("Exceeded log rate limit, dropping the log.");
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public final void g(nl.a aVar, String str, boolean z11) {
            long jF = f(aVar, str);
            long jE = e(aVar, str);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            com.google.firebase.perf.util.g gVar = new com.google.firebase.perf.util.g(jE, jF, timeUnit);
            this.f78962g = gVar;
            this.f78964i = jE;
            if (z11) {
                f78954k.b("Foreground %s logging rate:%f, burst capacity:%d", str, gVar, Long.valueOf(jE));
            }
            long jD = d(aVar, str);
            long jC = c(aVar, str);
            com.google.firebase.perf.util.g gVar2 = new com.google.firebase.perf.util.g(jC, jD, timeUnit);
            this.f78963h = gVar2;
            this.f78965j = jC;
            if (z11) {
                f78954k.b("Background %s logging rate:%f, capacity:%d", str, gVar2, Long.valueOf(jC));
            }
        }
    }

    public d(@NonNull Context context, com.google.firebase.perf.util.g gVar, long j11) {
        this(gVar, j11, new com.google.firebase.perf.util.a(), b(), b(), nl.a.g());
        this.f78953f = com.google.firebase.perf.util.k.b(context);
    }

    public d(com.google.firebase.perf.util.g gVar, long j11, com.google.firebase.perf.util.a aVar, float f11, float f12, nl.a aVar2) {
        this.f78951d = null;
        this.f78952e = null;
        boolean z11 = false;
        this.f78953f = false;
        com.google.firebase.perf.util.k.a(0.0f <= f11 && f11 < 1.0f, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        if (0.0f <= f12 && f12 < 1.0f) {
            z11 = true;
        }
        com.google.firebase.perf.util.k.a(z11, "Fragment sampling bucket ID should be in range [0.0f, 1.0f).");
        this.f78949b = f11;
        this.f78950c = f12;
        this.f78948a = aVar2;
        this.f78951d = new a(gVar, j11, aVar, aVar2, "Trace", this.f78953f);
        this.f78952e = new a(gVar, j11, aVar, aVar2, "Network", this.f78953f);
    }

    @VisibleForTesting
    public static float b() {
        return new Random().nextFloat();
    }

    public void a(boolean z11) {
        this.f78951d.a(z11);
        this.f78952e.a(z11);
    }

    public final boolean c(List<com.google.firebase.perf.v1.h> list) {
        return list.size() > 0 && list.get(0).W() > 0 && list.get(0).V(0) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
    }

    public final boolean d() {
        return this.f78950c < this.f78948a.f();
    }

    public final boolean e() {
        return this.f78949b < this.f78948a.s();
    }

    public final boolean f() {
        return this.f78949b < this.f78948a.G();
    }

    public boolean g(com.google.firebase.perf.v1.g gVar) {
        if (!j(gVar)) {
            return false;
        }
        if (gVar.d()) {
            return !this.f78952e.b(gVar);
        }
        if (gVar.m()) {
            return !this.f78951d.b(gVar);
        }
        return true;
    }

    public boolean h(com.google.firebase.perf.v1.g gVar) {
        if (gVar.m() && !f() && !c(gVar.n().p0())) {
            return false;
        }
        if (!i(gVar) || d() || c(gVar.n().p0())) {
            return !gVar.d() || e() || c(gVar.f().l0());
        }
        return false;
    }

    public boolean i(com.google.firebase.perf.v1.g gVar) {
        return gVar.m() && gVar.n().o0().startsWith("_st_") && gVar.n().e0("Hosting_activity");
    }

    public boolean j(@NonNull com.google.firebase.perf.v1.g gVar) {
        return (!gVar.m() || (!(gVar.n().o0().equals(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString()) || gVar.n().o0().equals(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString())) || gVar.n().h0() <= 0)) && !gVar.a();
    }
}
