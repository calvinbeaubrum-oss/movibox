package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class or implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mr f21612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f21616e;

    public or(mr mrVar, int i11, long j11, long j12) {
        this.f21612a = mrVar;
        this.f21613b = i11;
        this.f21614c = j11;
        long j13 = (j12 - j11) / ((long) mrVar.f21197e);
        this.f21615d = j13;
        this.f21616e = c(j13);
    }

    private long c(long j11) {
        return xp.c(j11 * ((long) this.f21613b), 1000000L, this.f21612a.f21195c);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        long jB = xp.b((((long) this.f21612a.f21195c) * j11) / (((long) this.f21613b) * 1000000), 0L, this.f21615d - 1);
        long j12 = this.f21614c + (((long) this.f21612a.f21197e) * jB);
        long jC = c(jB);
        kj kjVar = new kj(jC, j12);
        if (jC >= j11 || jB == this.f21615d - 1) {
            return new ij.a(kjVar);
        }
        long j13 = jB + 1;
        return new ij.a(kjVar, new kj(c(j13), this.f21614c + (((long) this.f21612a.f21197e) * j13)));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f21616e;
    }
}
