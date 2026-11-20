package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class p4 implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f21645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f21646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f21650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f21651g;

    public p4(long j11, long j12, int i11, int i12, boolean z11) {
        this.f21645a = j11;
        this.f21646b = j12;
        this.f21647c = i12 == -1 ? 1 : i12;
        this.f21649e = i11;
        this.f21651g = z11;
        if (j11 == -1) {
            this.f21648d = -1L;
            this.f21650f = C.TIME_UNSET;
        } else {
            this.f21648d = j11 - j12;
            this.f21650f = a(j11, j12, i11);
        }
    }

    private static long a(long j11, long j12, int i11) {
        return (Math.max(0L, j11 - j12) * 8000000) / ((long) i11);
    }

    private long c(long j11) {
        long j12 = (j11 * ((long) this.f21649e)) / 8000000;
        long j13 = this.f21647c;
        long jMin = (j12 / j13) * j13;
        long j14 = this.f21648d;
        if (j14 != -1) {
            jMin = Math.min(jMin, j14 - j13);
        }
        return this.f21646b + Math.max(jMin, 0L);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        if (this.f21648d == -1 && !this.f21651g) {
            return new ij.a(new kj(0L, this.f21646b));
        }
        long jC = c(j11);
        long jD = d(jC);
        kj kjVar = new kj(jD, jC);
        if (this.f21648d != -1 && jD < j11) {
            long j12 = jC + ((long) this.f21647c);
            if (j12 < this.f21645a) {
                return new ij.a(kjVar, new kj(d(j12), j12));
            }
        }
        return new ij.a(kjVar);
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return this.f21648d != -1 || this.f21651g;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f21650f;
    }

    public long d(long j11) {
        return a(j11, this.f21646b, this.f21649e);
    }
}
