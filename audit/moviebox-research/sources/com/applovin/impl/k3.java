package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k3 implements wd, wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd f20098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private wd.a f20099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a[] f20100c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f20101d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f20102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f20103g;

    /* JADX INFO: compiled from: source.java */
    public final class a implements cj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cj f20104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f20105b;

        public a(cj cjVar) {
            this.f20104a = cjVar;
        }

        @Override // com.applovin.impl.cj
        public int a(long j11) {
            if (k3.this.c()) {
                return -3;
            }
            return this.f20104a.a(j11);
        }

        @Override // com.applovin.impl.cj
        public int a(g9 g9Var, p5 p5Var, int i11) {
            if (k3.this.c()) {
                return -3;
            }
            if (this.f20105b) {
                p5Var.e(4);
                return -4;
            }
            int iA = this.f20104a.a(g9Var, p5Var, i11);
            if (iA == -5) {
                f9 f9Var = (f9) b1.a(g9Var.f19165b);
                int i12 = f9Var.C;
                if (i12 != 0 || f9Var.D != 0) {
                    k3 k3Var = k3.this;
                    if (k3Var.f20102f != 0) {
                        i12 = 0;
                    }
                    g9Var.f19165b = f9Var.a().e(i12).f(k3Var.f20103g == Long.MIN_VALUE ? f9Var.D : 0).a();
                }
                return -5;
            }
            k3 k3Var2 = k3.this;
            long j11 = k3Var2.f20103g;
            if (j11 == Long.MIN_VALUE || ((iA != -4 || p5Var.f21657f < j11) && !(iA == -3 && k3Var2.e() == Long.MIN_VALUE && !p5Var.f21656d))) {
                return iA;
            }
            p5Var.b();
            p5Var.e(4);
            this.f20105b = true;
            return -4;
        }

        @Override // com.applovin.impl.cj
        public void a() {
            this.f20104a.a();
        }

        public void b() {
            this.f20105b = false;
        }

        @Override // com.applovin.impl.cj
        public boolean d() {
            return !k3.this.c() && this.f20104a.d();
        }
    }

    public k3(wd wdVar, boolean z11, long j11, long j12) {
        this.f20098a = wdVar;
        this.f20101d = z11 ? j11 : C.TIME_UNSET;
        this.f20102f = j11;
        this.f20103g = j12;
    }

    private static boolean a(long j11, h8[] h8VarArr) {
        if (j11 != 0) {
            for (h8 h8Var : h8VarArr) {
                if (h8Var != null) {
                    f9 f9VarG = h8Var.g();
                    if (!Cif.a(f9VarG.f18900m, f9VarG.f18897j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private jj b(long j11, jj jjVar) {
        long jB = xp.b(jjVar.f19980a, 0L, j11 - this.f20102f);
        long j12 = jjVar.f19981b;
        long j13 = this.f20103g;
        long jB2 = xp.b(j12, 0L, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11);
        return (jB == jjVar.f19980a && jB2 == jjVar.f19981b) ? jjVar : new jj(jB, jB2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    @Override // com.applovin.impl.wd
    public long a(long j11) {
        this.f20101d = C.TIME_UNSET;
        boolean z11 = false;
        for (a aVar : this.f20100c) {
            if (aVar != null) {
                aVar.b();
            }
        }
        long jA = this.f20098a.a(j11);
        if (jA == j11) {
            z11 = true;
        } else if (jA >= this.f20102f) {
            long j12 = this.f20103g;
            if (j12 == Long.MIN_VALUE || jA <= j12) {
                z11 = true;
            }
        }
        b1.b(z11);
        return jA;
    }

    @Override // com.applovin.impl.wd
    public long a(long j11, jj jjVar) {
        long j12 = this.f20102f;
        if (j11 == j12) {
            return j12;
        }
        return this.f20098a.a(j11, b(j11, jjVar));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    @Override // com.applovin.impl.wd
    public long a(h8[] h8VarArr, boolean[] zArr, cj[] cjVarArr, boolean[] zArr2, long j11) {
        long j12;
        boolean z11;
        this.f20100c = new a[cjVarArr.length];
        cj[] cjVarArr2 = new cj[cjVarArr.length];
        int i11 = 0;
        while (true) {
            cj cjVar = null;
            if (i11 >= cjVarArr.length) {
                break;
            }
            a[] aVarArr = this.f20100c;
            a aVar = (a) cjVarArr[i11];
            aVarArr[i11] = aVar;
            if (aVar != null) {
                cjVar = aVar.f20104a;
            }
            cjVarArr2[i11] = cjVar;
            i11++;
        }
        long jA = this.f20098a.a(h8VarArr, zArr, cjVarArr2, zArr2, j11);
        if (c()) {
            long j13 = this.f20102f;
            if (j11 == j13 && a(j13, h8VarArr)) {
                j12 = jA;
            } else {
                j12 = C.TIME_UNSET;
            }
        } else {
            j12 = C.TIME_UNSET;
        }
        this.f20101d = j12;
        if (jA != j11) {
            if (jA >= this.f20102f) {
                long j14 = this.f20103g;
                z11 = j14 == Long.MIN_VALUE || jA <= j14;
            }
        }
        b1.b(z11);
        for (int i12 = 0; i12 < cjVarArr.length; i12++) {
            cj cjVar2 = cjVarArr2[i12];
            if (cjVar2 == null) {
                this.f20100c[i12] = null;
            } else {
                a[] aVarArr2 = this.f20100c;
                a aVar2 = aVarArr2[i12];
                if (aVar2 == null || aVar2.f20104a != cjVar2) {
                    aVarArr2[i12] = new a(cjVar2);
                }
            }
            cjVarArr[i12] = this.f20100c[i12];
        }
        return jA;
    }

    public void a(long j11, long j12) {
        this.f20102f = j11;
        this.f20103g = j12;
    }

    @Override // com.applovin.impl.wd
    public void a(long j11, boolean z11) {
        this.f20098a.a(j11, z11);
    }

    @Override // com.applovin.impl.wd
    public void a(wd.a aVar, long j11) {
        this.f20099b = aVar;
        this.f20098a.a(this, j11);
    }

    @Override // com.applovin.impl.wd.a
    public void a(wd wdVar) {
        ((wd.a) b1.a(this.f20099b)).a((wd) this);
    }

    @Override // com.applovin.impl.wd
    public boolean a() {
        return this.f20098a.a();
    }

    @Override // com.applovin.impl.wd
    public po b() {
        return this.f20098a.b();
    }

    @Override // com.applovin.impl.pj.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(wd wdVar) {
        ((wd.a) b1.a(this.f20099b)).a((pj) this);
    }

    @Override // com.applovin.impl.wd
    public boolean b(long j11) {
        return this.f20098a.b(j11);
    }

    @Override // com.applovin.impl.wd
    public void c(long j11) {
        this.f20098a.c(j11);
    }

    public boolean c() {
        return this.f20101d != C.TIME_UNSET;
    }

    @Override // com.applovin.impl.wd
    public long e() {
        long jE = this.f20098a.e();
        if (jE != Long.MIN_VALUE) {
            long j11 = this.f20103g;
            if (j11 == Long.MIN_VALUE || jE < j11) {
                return jE;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.applovin.impl.wd
    public void f() {
        this.f20098a.f();
    }

    @Override // com.applovin.impl.wd
    public long g() {
        long jG = this.f20098a.g();
        if (jG != Long.MIN_VALUE) {
            long j11 = this.f20103g;
            if (j11 == Long.MIN_VALUE || jG < j11) {
                return jG;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.applovin.impl.wd
    public long h() {
        if (c()) {
            long j11 = this.f20101d;
            this.f20101d = C.TIME_UNSET;
            long jH = h();
            return jH != C.TIME_UNSET ? jH : j11;
        }
        long jH2 = this.f20098a.h();
        if (jH2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        b1.b(jH2 >= this.f20102f);
        long j12 = this.f20103g;
        b1.b(j12 == Long.MIN_VALUE || jH2 <= j12);
        return jH2;
    }
}
