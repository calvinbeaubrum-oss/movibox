package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f19516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f19517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f19518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal f19519d = new ThreadLocal();

    public ho(long j11) {
        d(j11);
    }

    public static long c(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long e(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public synchronized long a() {
        long j11;
        j11 = this.f19516a;
        if (j11 == Long.MAX_VALUE || j11 == 9223372036854775806L) {
            j11 = C.TIME_UNSET;
        }
        return j11;
    }

    public synchronized long a(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            if (this.f19517b == C.TIME_UNSET) {
                long jLongValue = this.f19516a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) b1.a((Long) this.f19519d.get())).longValue();
                }
                this.f19517b = jLongValue - j11;
                notifyAll();
            }
            this.f19518c = j11;
            return j11 + this.f19517b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long b() {
        long j11;
        try {
            j11 = this.f19518c;
        } catch (Throwable th2) {
            throw th2;
        }
        return j11 != C.TIME_UNSET ? j11 + this.f19517b : a();
    }

    public synchronized long b(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            long j12 = this.f19518c;
            if (j12 != C.TIME_UNSET) {
                long jE = e(j12);
                long j13 = (4294967296L + jE) / 8589934592L;
                long j14 = ((j13 - 1) * 8589934592L) + j11;
                j11 += j13 * 8589934592L;
                if (Math.abs(j14 - jE) < Math.abs(j11 - jE)) {
                    j11 = j14;
                }
            }
            return a(c(j11));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long c() {
        return this.f19517b;
    }

    public synchronized void d(long j11) {
        this.f19516a = j11;
        this.f19517b = j11 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f19518c = C.TIME_UNSET;
    }
}
