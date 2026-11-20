package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd f24295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f24296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cj[] f24297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zd f24300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f24302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ri[] f24303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final vo f24304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final fe f24305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private xd f24306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private po f24307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private wo f24308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f24309o;

    public xd(ri[] riVarArr, long j11, vo voVar, n0 n0Var, fe feVar, zd zdVar, wo woVar) {
        this.f24303i = riVarArr;
        this.f24309o = j11;
        this.f24304j = voVar;
        this.f24305k = feVar;
        be.a aVar = zdVar.f24835a;
        this.f24296b = aVar.f24653a;
        this.f24300f = zdVar;
        this.f24307m = po.f21808d;
        this.f24308n = woVar;
        this.f24297c = new cj[riVarArr.length];
        this.f24302h = new boolean[riVarArr.length];
        this.f24295a = a(aVar, feVar, n0Var, zdVar.f24836b, zdVar.f24838d);
    }

    private static wd a(be.a aVar, fe feVar, n0 n0Var, long j11, long j12) {
        wd wdVarA = feVar.a(aVar, n0Var, j11);
        return j12 != C.TIME_UNSET ? new k3(wdVarA, true, 0L, j12) : wdVarA;
    }

    private void a() {
        if (!k()) {
            return;
        }
        int i11 = 0;
        while (true) {
            wo woVar = this.f24308n;
            if (i11 >= woVar.f24150a) {
                return;
            }
            boolean zA = woVar.a(i11);
            h8 h8Var = this.f24308n.f24152c[i11];
            if (zA && h8Var != null) {
                h8Var.f();
            }
            i11++;
        }
    }

    private static void a(fe feVar, wd wdVar) {
        try {
            if (wdVar instanceof k3) {
                feVar.a(((k3) wdVar).f20098a);
            } else {
                feVar.a(wdVar);
            }
        } catch (RuntimeException e11) {
            pc.a("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    private void a(cj[] cjVarArr) {
        int i11 = 0;
        while (true) {
            ri[] riVarArr = this.f24303i;
            if (i11 >= riVarArr.length) {
                return;
            }
            if (riVarArr[i11].e() == -2 && this.f24308n.a(i11)) {
                cjVarArr[i11] = new s7();
            }
            i11++;
        }
    }

    private void b() {
        if (!k()) {
            return;
        }
        int i11 = 0;
        while (true) {
            wo woVar = this.f24308n;
            if (i11 >= woVar.f24150a) {
                return;
            }
            boolean zA = woVar.a(i11);
            h8 h8Var = this.f24308n.f24152c[i11];
            if (zA && h8Var != null) {
                h8Var.i();
            }
            i11++;
        }
    }

    private void b(cj[] cjVarArr) {
        int i11 = 0;
        while (true) {
            ri[] riVarArr = this.f24303i;
            if (i11 >= riVarArr.length) {
                return;
            }
            if (riVarArr[i11].e() == -2) {
                cjVarArr[i11] = null;
            }
            i11++;
        }
    }

    private boolean k() {
        return this.f24306l == null;
    }

    public long a(wo woVar, long j11, boolean z11) {
        return a(woVar, j11, z11, new boolean[this.f24303i.length]);
    }

    public long a(wo woVar, long j11, boolean z11, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= woVar.f24150a) {
                break;
            }
            boolean[] zArr2 = this.f24302h;
            if (z11 || !woVar.a(this.f24308n, i11)) {
                z12 = false;
            }
            zArr2[i11] = z12;
            i11++;
        }
        b(this.f24297c);
        a();
        this.f24308n = woVar;
        b();
        long jA = this.f24295a.a(woVar.f24152c, this.f24302h, this.f24297c, zArr, j11);
        a(this.f24297c);
        this.f24299e = false;
        int i12 = 0;
        while (true) {
            cj[] cjVarArr = this.f24297c;
            if (i12 >= cjVarArr.length) {
                return jA;
            }
            if (cjVarArr[i12] != null) {
                b1.b(woVar.a(i12));
                if (this.f24303i[i12].e() != -2) {
                    this.f24299e = true;
                }
            } else {
                b1.b(woVar.f24152c[i12] == null);
            }
            i12++;
        }
    }

    public void a(float f11, fo foVar) {
        this.f24298d = true;
        this.f24307m = this.f24295a.b();
        wo woVarB = b(f11, foVar);
        zd zdVar = this.f24300f;
        long jMax = zdVar.f24836b;
        long j11 = zdVar.f24839e;
        if (j11 != C.TIME_UNSET && jMax >= j11) {
            jMax = Math.max(0L, j11 - 1);
        }
        long jA = a(woVarB, jMax, false);
        long j12 = this.f24309o;
        zd zdVar2 = this.f24300f;
        this.f24309o = j12 + (zdVar2.f24836b - jA);
        this.f24300f = zdVar2.b(jA);
    }

    public void a(long j11) {
        b1.b(k());
        this.f24295a.b(d(j11));
    }

    public void a(xd xdVar) {
        if (xdVar == this.f24306l) {
            return;
        }
        a();
        this.f24306l = xdVar;
        b();
    }

    public wo b(float f11, fo foVar) {
        wo woVarA = this.f24304j.a(this.f24303i, h(), this.f24300f.f24835a, foVar);
        for (h8 h8Var : woVarA.f24152c) {
            if (h8Var != null) {
                h8Var.a(f11);
            }
        }
        return woVarA;
    }

    public void b(long j11) {
        b1.b(k());
        if (this.f24298d) {
            this.f24295a.c(d(j11));
        }
    }

    public long c() {
        if (!this.f24298d) {
            return this.f24300f.f24836b;
        }
        long jE = this.f24299e ? this.f24295a.e() : Long.MIN_VALUE;
        return jE == Long.MIN_VALUE ? this.f24300f.f24839e : jE;
    }

    public void c(long j11) {
        this.f24309o = j11;
    }

    public long d(long j11) {
        return j11 - f();
    }

    public xd d() {
        return this.f24306l;
    }

    public long e() {
        if (this.f24298d) {
            return this.f24295a.g();
        }
        return 0L;
    }

    public long e(long j11) {
        return j11 + f();
    }

    public long f() {
        return this.f24309o;
    }

    public long g() {
        return this.f24300f.f24836b + this.f24309o;
    }

    public po h() {
        return this.f24307m;
    }

    public wo i() {
        return this.f24308n;
    }

    public boolean j() {
        return this.f24298d && (!this.f24299e || this.f24295a.e() == Long.MIN_VALUE);
    }

    public void l() {
        a();
        a(this.f24305k, this.f24295a);
    }

    public void m() {
        wd wdVar = this.f24295a;
        if (wdVar instanceof k3) {
            long j11 = this.f24300f.f24838d;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((k3) wdVar).a(0L, j11);
        }
    }
}
