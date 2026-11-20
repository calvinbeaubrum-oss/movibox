package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class nb implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f21307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final rc f21308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final rc f21309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f21310d;

    public nb(long j11, long j12, long j13) {
        this.f21310d = j11;
        this.f21307a = j13;
        rc rcVar = new rc();
        this.f21308b = rcVar;
        rc rcVar2 = new rc();
        this.f21309c = rcVar2;
        rcVar.a(0L);
        rcVar2.a(j12);
    }

    @Override // com.applovin.impl.lj
    public long a(long j11) {
        return this.f21308b.a(xp.a(this.f21309c, j11, true, true));
    }

    public void a(long j11, long j12) {
        if (c(j11)) {
            return;
        }
        this.f21308b.a(j11);
        this.f21309c.a(j12);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        int iA = xp.a(this.f21308b, j11, true, true);
        kj kjVar = new kj(this.f21308b.a(iA), this.f21309c.a(iA));
        if (kjVar.f20256a == j11 || iA == this.f21308b.a() - 1) {
            return new ij.a(kjVar);
        }
        int i11 = iA + 1;
        return new ij.a(kjVar, new kj(this.f21308b.a(i11), this.f21309c.a(i11)));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return this.f21307a;
    }

    public boolean c(long j11) {
        rc rcVar = this.f21308b;
        return j11 - rcVar.a(rcVar.a() - 1) < 100000;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f21310d;
    }

    public void d(long j11) {
        this.f21310d = j11;
    }
}
