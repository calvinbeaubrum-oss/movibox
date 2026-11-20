package com.google.android.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f35588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f35589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f35590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Long> f35591d = new ThreadLocal<>();

    public k0(long j11) {
        g(j11);
    }

    public static long f(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long i(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public static long j(long j11) {
        return i(j11) % 8589934592L;
    }

    public synchronized long a(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            if (this.f35589b == C.TIME_UNSET) {
                long jLongValue = this.f35588a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) a.e(this.f35591d.get())).longValue();
                }
                this.f35589b = jLongValue - j11;
                notifyAll();
            }
            this.f35590c = j11;
            return j11 + this.f35589b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long b(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            long j12 = this.f35590c;
            if (j12 != C.TIME_UNSET) {
                long jI = i(j12);
                long j13 = (4294967296L + jI) / 8589934592L;
                long j14 = ((j13 - 1) * 8589934592L) + j11;
                j11 += j13 * 8589934592L;
                if (Math.abs(j14 - jI) < Math.abs(j11 - jI)) {
                    j11 = j14;
                }
            }
            return a(f(j11));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long c() {
        long j11;
        j11 = this.f35588a;
        if (j11 == Long.MAX_VALUE || j11 == 9223372036854775806L) {
            j11 = C.TIME_UNSET;
        }
        return j11;
    }

    public synchronized long d() {
        long j11;
        try {
            j11 = this.f35590c;
        } catch (Throwable th2) {
            throw th2;
        }
        return j11 != C.TIME_UNSET ? j11 + this.f35589b : c();
    }

    public synchronized long e() {
        return this.f35589b;
    }

    public synchronized void g(long j11) {
        this.f35588a = j11;
        this.f35589b = j11 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f35590c = C.TIME_UNSET;
    }

    public synchronized void h(boolean z11, long j11) throws InterruptedException {
        try {
            a.g(this.f35588a == 9223372036854775806L);
            if (this.f35589b != C.TIME_UNSET) {
                return;
            }
            if (z11) {
                this.f35591d.set(Long.valueOf(j11));
            } else {
                while (this.f35589b == C.TIME_UNSET) {
                    wait();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
