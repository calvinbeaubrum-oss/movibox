package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.k f11770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p4.e0[] f11772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a2 f11775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f11777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y2[] f11778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s4.e0 f11779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r2 f11780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public z1 f11781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p4.k0 f11782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public s4.f0 f11783n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11784o;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        z1 a(a2 a2Var, long j11);
    }

    public z1(y2[] y2VarArr, long j11, s4.e0 e0Var, androidx.media3.exoplayer.upstream.b bVar, r2 r2Var, a2 a2Var, s4.f0 f0Var) {
        this.f11778i = y2VarArr;
        this.f11784o = j11;
        this.f11779j = e0Var;
        this.f11780k = r2Var;
        androidx.media3.exoplayer.source.l.b bVar2 = a2Var.f9824a;
        this.f11771b = bVar2.f11209a;
        this.f11775f = a2Var;
        this.f11782m = p4.k0.f73571d;
        this.f11783n = f0Var;
        this.f11772c = new p4.e0[y2VarArr.length];
        this.f11777h = new boolean[y2VarArr.length];
        this.f11770a = e(bVar2, r2Var, bVar, a2Var.f9825b, a2Var.f9827d);
    }

    public static androidx.media3.exoplayer.source.k e(androidx.media3.exoplayer.source.l.b bVar, r2 r2Var, androidx.media3.exoplayer.upstream.b bVar2, long j11, long j12) {
        androidx.media3.exoplayer.source.k kVarH = r2Var.h(bVar, bVar2, j11);
        return j12 != C.TIME_UNSET ? new androidx.media3.exoplayer.source.b(kVarH, true, 0L, j12) : kVarH;
    }

    public static void u(r2 r2Var, androidx.media3.exoplayer.source.k kVar) {
        try {
            if (kVar instanceof androidx.media3.exoplayer.source.b) {
                r2Var.A(((androidx.media3.exoplayer.source.b) kVar).f11124a);
            } else {
                r2Var.A(kVar);
            }
        } catch (RuntimeException e11) {
            z3.o.d("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    public void A() {
        androidx.media3.exoplayer.source.k kVar = this.f11770a;
        if (kVar instanceof androidx.media3.exoplayer.source.b) {
            long j11 = this.f11775f.f9827d;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((androidx.media3.exoplayer.source.b) kVar).m(0L, j11);
        }
    }

    public long a(s4.f0 f0Var, long j11, boolean z11) {
        return b(f0Var, j11, z11, new boolean[this.f11778i.length]);
    }

    public long b(s4.f0 f0Var, long j11, boolean z11, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= f0Var.f76008a) {
                break;
            }
            boolean[] zArr2 = this.f11777h;
            if (z11 || !f0Var.b(this.f11783n, i11)) {
                z12 = false;
            }
            zArr2[i11] = z12;
            i11++;
        }
        g(this.f11772c);
        f();
        this.f11783n = f0Var;
        h();
        long jE = this.f11770a.e(f0Var.f76010c, this.f11777h, this.f11772c, zArr, j11);
        c(this.f11772c);
        this.f11774e = false;
        int i12 = 0;
        while (true) {
            p4.e0[] e0VarArr = this.f11772c;
            if (i12 >= e0VarArr.length) {
                return jE;
            }
            if (e0VarArr[i12] != null) {
                z3.a.g(f0Var.c(i12));
                if (this.f11778i[i12].getTrackType() != -2) {
                    this.f11774e = true;
                }
            } else {
                z3.a.g(f0Var.f76010c[i12] == null);
            }
            i12++;
        }
    }

    public final void c(p4.e0[] e0VarArr) {
        int i11 = 0;
        while (true) {
            y2[] y2VarArr = this.f11778i;
            if (i11 >= y2VarArr.length) {
                return;
            }
            if (y2VarArr[i11].getTrackType() == -2 && this.f11783n.c(i11)) {
                e0VarArr[i11] = new p4.l();
            }
            i11++;
        }
    }

    public void d(long j11, float f11, long j12) {
        z3.a.g(r());
        this.f11770a.a(new w1.b().f(y(j11)).g(f11).e(j12).d());
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i11 = 0;
        while (true) {
            s4.f0 f0Var = this.f11783n;
            if (i11 >= f0Var.f76008a) {
                return;
            }
            boolean zC = f0Var.c(i11);
            s4.z zVar = this.f11783n.f76010c[i11];
            if (zC && zVar != null) {
                zVar.disable();
            }
            i11++;
        }
    }

    public final void g(p4.e0[] e0VarArr) {
        int i11 = 0;
        while (true) {
            y2[] y2VarArr = this.f11778i;
            if (i11 >= y2VarArr.length) {
                return;
            }
            if (y2VarArr[i11].getTrackType() == -2) {
                e0VarArr[i11] = null;
            }
            i11++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i11 = 0;
        while (true) {
            s4.f0 f0Var = this.f11783n;
            if (i11 >= f0Var.f76008a) {
                return;
            }
            boolean zC = f0Var.c(i11);
            s4.z zVar = this.f11783n.f76010c[i11];
            if (zC && zVar != null) {
                zVar.enable();
            }
            i11++;
        }
    }

    public long i() {
        if (!this.f11773d) {
            return this.f11775f.f9825b;
        }
        long bufferedPositionUs = this.f11774e ? this.f11770a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f11775f.f9828e : bufferedPositionUs;
    }

    @Nullable
    public z1 j() {
        return this.f11781l;
    }

    public long k() {
        if (this.f11773d) {
            return this.f11770a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.f11784o;
    }

    public long m() {
        return this.f11775f.f9825b + this.f11784o;
    }

    public p4.k0 n() {
        return this.f11782m;
    }

    public s4.f0 o() {
        return this.f11783n;
    }

    public void p(float f11, androidx.media3.common.m0 m0Var) throws ExoPlaybackException {
        this.f11773d = true;
        this.f11782m = this.f11770a.getTrackGroups();
        s4.f0 f0VarV = v(f11, m0Var);
        a2 a2Var = this.f11775f;
        long jMax = a2Var.f9825b;
        long j11 = a2Var.f9828e;
        if (j11 != C.TIME_UNSET && jMax >= j11) {
            jMax = Math.max(0L, j11 - 1);
        }
        long jA = a(f0VarV, jMax, false);
        long j12 = this.f11784o;
        a2 a2Var2 = this.f11775f;
        this.f11784o = j12 + (a2Var2.f9825b - jA);
        this.f11775f = a2Var2.b(jA);
    }

    public boolean q() {
        return this.f11773d && (!this.f11774e || this.f11770a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.f11781l == null;
    }

    public void s(long j11) {
        z3.a.g(r());
        if (this.f11773d) {
            this.f11770a.reevaluateBuffer(y(j11));
        }
    }

    public void t() {
        f();
        u(this.f11780k, this.f11770a);
    }

    public s4.f0 v(float f11, androidx.media3.common.m0 m0Var) throws ExoPlaybackException {
        s4.f0 f0VarK = this.f11779j.k(this.f11778i, n(), this.f11775f.f9824a, m0Var);
        for (s4.z zVar : f0VarK.f76010c) {
            if (zVar != null) {
                zVar.onPlaybackSpeed(f11);
            }
        }
        return f0VarK;
    }

    public void w(@Nullable z1 z1Var) {
        if (z1Var == this.f11781l) {
            return;
        }
        f();
        this.f11781l = z1Var;
        h();
    }

    public void x(long j11) {
        this.f11784o = j11;
    }

    public long y(long j11) {
        return j11 - l();
    }

    public long z(long j11) {
        return j11 + l();
    }
}
