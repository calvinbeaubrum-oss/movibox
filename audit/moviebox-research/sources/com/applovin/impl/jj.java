package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class jj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final jj f19975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final jj f19976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final jj f19977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final jj f19978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final jj f19979g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19981b;

    static {
        jj jjVar = new jj(0L, 0L);
        f19975c = jjVar;
        f19976d = new jj(Long.MAX_VALUE, Long.MAX_VALUE);
        f19977e = new jj(Long.MAX_VALUE, 0L);
        f19978f = new jj(0L, Long.MAX_VALUE);
        f19979g = jjVar;
    }

    public jj(long j11, long j12) {
        b1.a(j11 >= 0);
        b1.a(j12 >= 0);
        this.f19980a = j11;
        this.f19981b = j12;
    }

    public long a(long j11, long j12, long j13) {
        long j14 = this.f19980a;
        if (j14 == 0 && this.f19981b == 0) {
            return j11;
        }
        long jD = xp.d(j11, j14, Long.MIN_VALUE);
        long jA = xp.a(j11, this.f19981b, Long.MAX_VALUE);
        boolean z11 = false;
        boolean z12 = jD <= j12 && j12 <= jA;
        if (jD <= j13 && j13 <= jA) {
            z11 = true;
        }
        if (z12 && z11) {
            return Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13;
        }
        if (z12) {
            return j12;
        }
        return z11 ? j13 : jD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jj.class != obj.getClass()) {
            return false;
        }
        jj jjVar = (jj) obj;
        return this.f19980a == jjVar.f19980a && this.f19981b == jjVar.f19981b;
    }

    public int hashCode() {
        return (((int) this.f19980a) * 31) + ((int) this.f19981b);
    }
}
