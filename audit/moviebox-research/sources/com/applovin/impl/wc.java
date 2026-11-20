package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class wc implements wd, wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final be.a f24080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n0 f24082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private be f24083d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private wd f24084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private wd.a f24085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f24086h = C.TIME_UNSET;

    public wc(be.a aVar, n0 n0Var, long j11) {
        this.f24080a = aVar;
        this.f24082c = n0Var;
        this.f24081b = j11;
    }

    private long d(long j11) {
        long j12 = this.f24086h;
        return j12 != C.TIME_UNSET ? j12 : j11;
    }

    @Override // com.applovin.impl.wd
    public long a(long j11) {
        return ((wd) xp.a(this.f24084f)).a(j11);
    }

    @Override // com.applovin.impl.wd
    public long a(long j11, jj jjVar) {
        return ((wd) xp.a(this.f24084f)).a(j11, jjVar);
    }

    @Override // com.applovin.impl.wd
    public long a(h8[] h8VarArr, boolean[] zArr, cj[] cjVarArr, boolean[] zArr2, long j11) {
        long j12;
        long j13 = this.f24086h;
        if (j13 == C.TIME_UNSET || j11 != this.f24081b) {
            j12 = j11;
        } else {
            this.f24086h = C.TIME_UNSET;
            j12 = j13;
        }
        return ((wd) xp.a(this.f24084f)).a(h8VarArr, zArr, cjVarArr, zArr2, j12);
    }

    @Override // com.applovin.impl.wd
    public void a(long j11, boolean z11) {
        ((wd) xp.a(this.f24084f)).a(j11, z11);
    }

    public void a(be.a aVar) {
        long jD = d(this.f24081b);
        wd wdVarA = ((be) b1.a(this.f24083d)).a(aVar, this.f24082c, jD);
        this.f24084f = wdVarA;
        if (this.f24085g != null) {
            wdVarA.a(this, jD);
        }
    }

    public void a(be beVar) {
        b1.b(this.f24083d == null);
        this.f24083d = beVar;
    }

    @Override // com.applovin.impl.wd
    public void a(wd.a aVar, long j11) {
        this.f24085g = aVar;
        wd wdVar = this.f24084f;
        if (wdVar != null) {
            wdVar.a(this, d(this.f24081b));
        }
    }

    @Override // com.applovin.impl.wd.a
    public void a(wd wdVar) {
        ((wd.a) xp.a(this.f24085g)).a((wd) this);
    }

    @Override // com.applovin.impl.wd
    public boolean a() {
        wd wdVar = this.f24084f;
        return wdVar != null && wdVar.a();
    }

    @Override // com.applovin.impl.wd
    public po b() {
        return ((wd) xp.a(this.f24084f)).b();
    }

    @Override // com.applovin.impl.pj.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(wd wdVar) {
        ((wd.a) xp.a(this.f24085g)).a((pj) this);
    }

    @Override // com.applovin.impl.wd
    public boolean b(long j11) {
        wd wdVar = this.f24084f;
        return wdVar != null && wdVar.b(j11);
    }

    public long c() {
        return this.f24086h;
    }

    @Override // com.applovin.impl.wd
    public void c(long j11) {
        ((wd) xp.a(this.f24084f)).c(j11);
    }

    public long d() {
        return this.f24081b;
    }

    @Override // com.applovin.impl.wd
    public long e() {
        return ((wd) xp.a(this.f24084f)).e();
    }

    public void e(long j11) {
        this.f24086h = j11;
    }

    @Override // com.applovin.impl.wd
    public void f() {
        wd wdVar = this.f24084f;
        if (wdVar != null) {
            wdVar.f();
            return;
        }
        be beVar = this.f24083d;
        if (beVar != null) {
            beVar.b();
        }
    }

    @Override // com.applovin.impl.wd
    public long g() {
        return ((wd) xp.a(this.f24084f)).g();
    }

    @Override // com.applovin.impl.wd
    public long h() {
        return ((wd) xp.a(this.f24084f)).h();
    }

    public void i() {
        if (this.f24084f != null) {
            ((be) b1.a(this.f24083d)).a(this.f24084f);
        }
    }
}
