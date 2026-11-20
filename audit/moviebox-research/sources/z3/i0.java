package z3;

import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f81792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f81793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f81794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Long> f81795d = new ThreadLocal<>();

    public i0(long j11) {
        i(j11);
    }

    public static long h(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long k(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public static long l(long j11) {
        return k(j11) % 8589934592L;
    }

    public synchronized long a(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            if (!g()) {
                long jLongValue = this.f81792a;
                if (jLongValue == 9223372036854775806L) {
                    jLongValue = ((Long) a.e(this.f81795d.get())).longValue();
                }
                this.f81793b = jLongValue - j11;
                notifyAll();
            }
            this.f81794c = j11;
            return j11 + this.f81793b;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long b(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            long j12 = this.f81794c;
            if (j12 != C.TIME_UNSET) {
                long jK = k(j12);
                long j13 = (4294967296L + jK) / 8589934592L;
                long j14 = ((j13 - 1) * 8589934592L) + j11;
                j11 += j13 * 8589934592L;
                if (Math.abs(j14 - jK) < Math.abs(j11 - jK)) {
                    j11 = j14;
                }
            }
            return a(h(j11));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long c(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = this.f81794c;
        if (j12 != C.TIME_UNSET) {
            long jK = k(j12);
            long j13 = jK / 8589934592L;
            Long.signum(j13);
            long j14 = (j13 * 8589934592L) + j11;
            j11 += (j13 + 1) * 8589934592L;
            if (j14 >= jK) {
                j11 = j14;
            }
        }
        return a(h(j11));
    }

    public synchronized long d() {
        long j11;
        j11 = this.f81792a;
        if (j11 == Long.MAX_VALUE || j11 == 9223372036854775806L) {
            j11 = C.TIME_UNSET;
        }
        return j11;
    }

    public synchronized long e() {
        long j11;
        try {
            j11 = this.f81794c;
        } catch (Throwable th2) {
            throw th2;
        }
        return j11 != C.TIME_UNSET ? j11 + this.f81793b : d();
    }

    public synchronized long f() {
        return this.f81793b;
    }

    public synchronized boolean g() {
        return this.f81793b != C.TIME_UNSET;
    }

    public synchronized void i(long j11) {
        this.f81792a = j11;
        this.f81793b = j11 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f81794c = C.TIME_UNSET;
    }

    public synchronized void j(boolean z11, long j11, long j12) throws InterruptedException, TimeoutException {
        try {
            a.g(this.f81792a == 9223372036854775806L);
            if (g()) {
                return;
            }
            if (z11) {
                this.f81795d.set(Long.valueOf(j11));
            } else {
                long jElapsedRealtime = 0;
                long j13 = j12;
                while (!g()) {
                    if (j12 == 0) {
                        wait();
                    } else {
                        a.g(j13 > 0);
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        wait(j13);
                        jElapsedRealtime += SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        if (jElapsedRealtime >= j12 && !g()) {
                            throw new TimeoutException("TimestampAdjuster failed to initialize in " + j12 + " milliseconds");
                        }
                        j13 = j12 - jElapsedRealtime;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
