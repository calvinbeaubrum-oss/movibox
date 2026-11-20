package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final be.a f24835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f24837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f24842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f24843i;

    public zd(be.a aVar, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = false;
        b1.a(!z14 || z12);
        b1.a(!z13 || z12);
        if (!z11 || (!z12 && !z13 && !z14)) {
            z15 = true;
        }
        b1.a(z15);
        this.f24835a = aVar;
        this.f24836b = j11;
        this.f24837c = j12;
        this.f24838d = j13;
        this.f24839e = j14;
        this.f24840f = z11;
        this.f24841g = z12;
        this.f24842h = z13;
        this.f24843i = z14;
    }

    public zd a(long j11) {
        return j11 == this.f24837c ? this : new zd(this.f24835a, this.f24836b, j11, this.f24838d, this.f24839e, this.f24840f, this.f24841g, this.f24842h, this.f24843i);
    }

    public zd b(long j11) {
        return j11 == this.f24836b ? this : new zd(this.f24835a, j11, this.f24837c, this.f24838d, this.f24839e, this.f24840f, this.f24841g, this.f24842h, this.f24843i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zd.class != obj.getClass()) {
            return false;
        }
        zd zdVar = (zd) obj;
        return this.f24836b == zdVar.f24836b && this.f24837c == zdVar.f24837c && this.f24838d == zdVar.f24838d && this.f24839e == zdVar.f24839e && this.f24840f == zdVar.f24840f && this.f24841g == zdVar.f24841g && this.f24842h == zdVar.f24842h && this.f24843i == zdVar.f24843i && xp.a(this.f24835a, zdVar.f24835a);
    }

    public int hashCode() {
        return ((((((((((((((((this.f24835a.hashCode() + 527) * 31) + ((int) this.f24836b)) * 31) + ((int) this.f24837c)) * 31) + ((int) this.f24838d)) * 31) + ((int) this.f24839e)) * 31) + (this.f24840f ? 1 : 0)) * 31) + (this.f24841g ? 1 : 0)) * 31) + (this.f24842h ? 1 : 0)) * 31) + (this.f24843i ? 1 : 0);
    }
}
