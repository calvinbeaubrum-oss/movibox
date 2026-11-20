package com.applovin.impl;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class u1 {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f23472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f23473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AudioTrack f23474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private t1 f23477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f23478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f23479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f23480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f23481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f23482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f23483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f23484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Method f23485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f23486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f23487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f23488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f23489r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f23490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f23491t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f23492u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f23493v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f23494w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f23495x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f23496y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f23497z;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11, long j11);

        void a(long j11);

        void a(long j11, long j12, long j13, long j14);

        void b(long j11);

        void b(long j11, long j12, long j13, long j14);
    }

    public u1(a aVar) {
        this.f23472a = (a) b1.a(aVar);
        if (xp.f24372a >= 18) {
            try {
                this.f23485n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f23473b = new long[10];
    }

    private long a(long j11) {
        return (j11 * 1000000) / ((long) this.f23478g);
    }

    private void a(long j11, long j12) {
        t1 t1Var = (t1) b1.a(this.f23477f);
        if (t1Var.a(j11)) {
            long jC = t1Var.c();
            long jB = t1Var.b();
            if (Math.abs(jC - j11) > 5000000) {
                this.f23472a.b(jB, jC, j11, j12);
                t1Var.e();
            } else if (Math.abs(a(jB) - j12) <= 5000000) {
                t1Var.a();
            } else {
                this.f23472a.a(jB, jC, j11, j12);
                t1Var.e();
            }
        }
    }

    private boolean a() {
        return this.f23479h && ((AudioTrack) b1.a(this.f23474c)).getPlayState() == 2 && b() == 0;
    }

    private static boolean a(int i11) {
        return xp.f24372a < 23 && (i11 == 5 || i11 == 6);
    }

    private long b() {
        AudioTrack audioTrack = (AudioTrack) b1.a(this.f23474c);
        if (this.f23495x != C.TIME_UNSET) {
            return Math.min(this.A, this.f23497z + ((((SystemClock.elapsedRealtime() * 1000) - this.f23495x) * ((long) this.f23478g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f23479h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f23492u = this.f23490s;
            }
            playbackHeadPosition += this.f23492u;
        }
        if (xp.f24372a <= 29) {
            if (playbackHeadPosition == 0 && this.f23490s > 0 && playState == 3) {
                if (this.f23496y == C.TIME_UNSET) {
                    this.f23496y = SystemClock.elapsedRealtime();
                }
                return this.f23490s;
            }
            this.f23496y = C.TIME_UNSET;
        }
        if (this.f23490s > playbackHeadPosition) {
            this.f23491t++;
        }
        this.f23490s = playbackHeadPosition;
        return playbackHeadPosition + (this.f23491t << 32);
    }

    private long c() {
        return a(b());
    }

    private void e() {
        long jC = c();
        if (jC == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f23484m >= 30000) {
            long[] jArr = this.f23473b;
            int i11 = this.f23493v;
            jArr[i11] = jC - jNanoTime;
            this.f23493v = (i11 + 1) % 10;
            int i12 = this.f23494w;
            if (i12 < 10) {
                this.f23494w = i12 + 1;
            }
            this.f23484m = jNanoTime;
            this.f23483l = 0L;
            int i13 = 0;
            while (true) {
                int i14 = this.f23494w;
                if (i13 >= i14) {
                    break;
                }
                this.f23483l += this.f23473b[i13] / ((long) i14);
                i13++;
            }
        }
        if (this.f23479h) {
            return;
        }
        a(jNanoTime, jC);
        h(jNanoTime);
    }

    private void h() {
        this.f23483l = 0L;
        this.f23494w = 0;
        this.f23493v = 0;
        this.f23484m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f23482k = false;
    }

    private void h(long j11) {
        Method method;
        if (!this.f23488q || (method = this.f23485n) == null || j11 - this.f23489r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) xp.a((Integer) method.invoke(b1.a(this.f23474c), new Object[0]))).intValue()) * 1000) - this.f23480i;
            this.f23486o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f23486o = jMax;
            if (jMax > 5000000) {
                this.f23472a.b(jMax);
                this.f23486o = 0L;
            }
        } catch (Exception unused) {
            this.f23485n = null;
        }
        this.f23489r = j11;
    }

    public long a(boolean z11) {
        long jC;
        if (((AudioTrack) b1.a(this.f23474c)).getPlayState() == 3) {
            e();
        }
        long jNanoTime = System.nanoTime() / 1000;
        t1 t1Var = (t1) b1.a(this.f23477f);
        boolean zD = t1Var.d();
        if (zD) {
            jC = a(t1Var.b()) + xp.a(jNanoTime - t1Var.c(), this.f23481j);
        } else {
            jC = this.f23494w == 0 ? c() : this.f23483l + jNanoTime;
            if (!z11) {
                jC = Math.max(0L, jC - this.f23486o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j11 = jNanoTime - this.F;
        if (j11 < 1000000) {
            long jA = this.E + xp.a(j11, this.f23481j);
            long j12 = (j11 * 1000) / 1000000;
            jC = ((jC * j12) + ((1000 - j12) * jA)) / 1000;
        }
        if (!this.f23482k) {
            long j13 = this.B;
            if (jC > j13) {
                this.f23482k = true;
                this.f23472a.a(System.currentTimeMillis() - t2.b(xp.b(t2.b(jC - j13), this.f23481j)));
            }
        }
        this.C = jNanoTime;
        this.B = jC;
        this.D = zD;
        return jC;
    }

    public void a(float f11) {
        this.f23481j = f11;
        t1 t1Var = this.f23477f;
        if (t1Var != null) {
            t1Var.f();
        }
    }

    public void a(AudioTrack audioTrack, boolean z11, int i11, int i12, int i13) {
        this.f23474c = audioTrack;
        this.f23475d = i12;
        this.f23476e = i13;
        this.f23477f = new t1(audioTrack);
        this.f23478g = audioTrack.getSampleRate();
        this.f23479h = z11 && a(i11);
        boolean zG = xp.g(i11);
        this.f23488q = zG;
        this.f23480i = zG ? a(i13 / i12) : -9223372036854775807L;
        this.f23490s = 0L;
        this.f23491t = 0L;
        this.f23492u = 0L;
        this.f23487p = false;
        this.f23495x = C.TIME_UNSET;
        this.f23496y = C.TIME_UNSET;
        this.f23489r = 0L;
        this.f23486o = 0L;
        this.f23481j = 1.0f;
    }

    public int b(long j11) {
        return this.f23476e - ((int) (j11 - (b() * ((long) this.f23475d))));
    }

    public long c(long j11) {
        return t2.b(a(j11 - b()));
    }

    public void d(long j11) {
        this.f23497z = b();
        this.f23495x = SystemClock.elapsedRealtime() * 1000;
        this.A = j11;
    }

    public boolean d() {
        return ((AudioTrack) b1.a(this.f23474c)).getPlayState() == 3;
    }

    public boolean e(long j11) {
        return j11 > b() || a();
    }

    public boolean f() {
        h();
        if (this.f23495x != C.TIME_UNSET) {
            return false;
        }
        ((t1) b1.a(this.f23477f)).f();
        return true;
    }

    public boolean f(long j11) {
        return this.f23496y != C.TIME_UNSET && j11 > 0 && SystemClock.elapsedRealtime() - this.f23496y >= 200;
    }

    public void g() {
        h();
        this.f23474c = null;
        this.f23477f = null;
    }

    public boolean g(long j11) {
        int playState = ((AudioTrack) b1.a(this.f23474c)).getPlayState();
        if (this.f23479h) {
            if (playState == 2) {
                this.f23487p = false;
                return false;
            }
            if (playState == 1 && b() == 0) {
                return false;
            }
        }
        boolean z11 = this.f23487p;
        boolean zE = e(j11);
        this.f23487p = zE;
        if (z11 && !zE && playState != 1) {
            this.f23472a.a(this.f23476e, t2.b(this.f23480i));
        }
        return true;
    }

    public void i() {
        ((t1) b1.a(this.f23477f)).f();
    }
}
