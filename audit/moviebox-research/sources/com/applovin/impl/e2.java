package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e2 implements qi, ri {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18534a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private si f18536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18537d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private cj f18539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f9[] f18540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f18541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f18542j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f18544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f18545m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g9 f18535b = new g9();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18543k = Long.MIN_VALUE;

    public e2(int i11) {
        this.f18534a = i11;
    }

    public final int a(g9 g9Var, p5 p5Var, int i11) {
        int iA = ((cj) b1.a(this.f18539g)).a(g9Var, p5Var, i11);
        if (iA == -4) {
            if (p5Var.e()) {
                this.f18543k = Long.MIN_VALUE;
                return this.f18544l ? -4 : -3;
            }
            long j11 = p5Var.f21657f + this.f18541i;
            p5Var.f21657f = j11;
            this.f18543k = Math.max(this.f18543k, j11);
        } else if (iA == -5) {
            f9 f9Var = (f9) b1.a(g9Var.f19165b);
            if (f9Var.f18904q != Long.MAX_VALUE) {
                g9Var.f19165b = f9Var.a().a(f9Var.f18904q + this.f18541i).a();
            }
        }
        return iA;
    }

    public final a8 a(Throwable th2, f9 f9Var, int i11) {
        return a(th2, f9Var, false, i11);
    }

    public final a8 a(Throwable th2, f9 f9Var, boolean z11, int i11) {
        int i12;
        if (f9Var == null || this.f18545m) {
            i12 = 4;
        } else {
            this.f18545m = true;
            try {
                int iD = v40.d(a(f9Var));
                this.f18545m = false;
                i12 = iD;
            } catch (a8 unused) {
                this.f18545m = false;
                i12 = 4;
            } catch (Throwable th3) {
                this.f18545m = false;
                throw th3;
            }
        }
        return a8.a(th2, getName(), s(), f9Var, i12, z11, i11);
    }

    @Override // com.applovin.impl.qi
    public /* synthetic */ void a(float f11, float f12) {
        f20.a(this, f11, f12);
    }

    @Override // com.applovin.impl.rh.b
    public void a(int i11, Object obj) {
    }

    @Override // com.applovin.impl.qi
    public final void a(long j11) {
        this.f18544l = false;
        this.f18542j = j11;
        this.f18543k = j11;
        a(j11, false);
    }

    public abstract void a(long j11, boolean z11);

    @Override // com.applovin.impl.qi
    public final void a(si siVar, f9[] f9VarArr, cj cjVar, long j11, boolean z11, boolean z12, long j12, long j13) {
        b1.b(this.f18538f == 0);
        this.f18536c = siVar;
        this.f18538f = 1;
        this.f18542j = j11;
        a(z11, z12);
        a(f9VarArr, cjVar, j12, j13);
        a(j11, z11);
    }

    public void a(boolean z11, boolean z12) {
    }

    public abstract void a(f9[] f9VarArr, long j11, long j12);

    @Override // com.applovin.impl.qi
    public final void a(f9[] f9VarArr, cj cjVar, long j11, long j12) {
        b1.b(!this.f18544l);
        this.f18539g = cjVar;
        if (this.f18543k == Long.MIN_VALUE) {
            this.f18543k = j11;
        }
        this.f18540h = f9VarArr;
        this.f18541i = j12;
        a(f9VarArr, j11, j12);
    }

    @Override // com.applovin.impl.qi
    public final int b() {
        return this.f18538f;
    }

    public int b(long j11) {
        return ((cj) b1.a(this.f18539g)).a(j11 - this.f18541i);
    }

    @Override // com.applovin.impl.qi
    public final void b(int i11) {
        this.f18537d = i11;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public final int e() {
        return this.f18534a;
    }

    @Override // com.applovin.impl.qi
    public final void f() {
        b1.b(this.f18538f == 1);
        this.f18535b.a();
        this.f18538f = 0;
        this.f18539g = null;
        this.f18540h = null;
        this.f18544l = false;
        v();
    }

    @Override // com.applovin.impl.qi
    public final void g() {
        this.f18544l = true;
    }

    @Override // com.applovin.impl.qi
    public final void h() {
        ((cj) b1.a(this.f18539g)).a();
    }

    @Override // com.applovin.impl.qi
    public final long i() {
        return this.f18543k;
    }

    @Override // com.applovin.impl.qi
    public final boolean j() {
        return this.f18543k == Long.MIN_VALUE;
    }

    @Override // com.applovin.impl.qi
    public final boolean k() {
        return this.f18544l;
    }

    @Override // com.applovin.impl.qi
    public gd l() {
        return null;
    }

    @Override // com.applovin.impl.ri
    public int m() {
        return 0;
    }

    @Override // com.applovin.impl.qi
    public final ri n() {
        return this;
    }

    @Override // com.applovin.impl.qi
    public final cj o() {
        return this.f18539g;
    }

    public final si q() {
        return (si) b1.a(this.f18536c);
    }

    public final g9 r() {
        this.f18535b.a();
        return this.f18535b;
    }

    @Override // com.applovin.impl.qi
    public final void reset() {
        b1.b(this.f18538f == 0);
        this.f18535b.a();
        w();
    }

    public final int s() {
        return this.f18537d;
    }

    @Override // com.applovin.impl.qi
    public final void start() {
        b1.b(this.f18538f == 1);
        this.f18538f = 2;
        x();
    }

    @Override // com.applovin.impl.qi
    public final void stop() {
        b1.b(this.f18538f == 2);
        this.f18538f = 1;
        y();
    }

    public final f9[] t() {
        return (f9[]) b1.a(this.f18540h);
    }

    public final boolean u() {
        return j() ? this.f18544l : ((cj) b1.a(this.f18539g)).d();
    }

    public abstract void v();

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }
}
