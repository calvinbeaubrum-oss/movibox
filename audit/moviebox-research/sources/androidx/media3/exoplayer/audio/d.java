package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import f4.a0;
import java.lang.reflect.Method;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public long G;
    public boolean H;
    public long I;
    public z3.d J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f9946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public AudioTrack f9947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public a0 f9950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f9954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f9956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f9957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public Method f9958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f9959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f9962r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f9963s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f9964t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f9965u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f9966v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9967w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9968x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f9969y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f9970z;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(long j11);

        void onInvalidLatency(long j11);

        void onPositionFramesMismatch(long j11, long j12, long j13, long j14);

        void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14);

        void onUnderrun(int i11, long j11);
    }

    public d(a aVar) {
        this.f9945a = (a) z3.a.e(aVar);
        if (u0.f81838a >= 18) {
            try {
                this.f9958n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f9946b = new long[10];
        this.J = z3.d.f81767a;
    }

    public static boolean o(int i11) {
        return u0.f81838a < 23 && (i11 == 5 || i11 == 6);
    }

    public void a() {
        this.H = true;
    }

    public final boolean b() {
        return this.f9952h && ((AudioTrack) z3.a.e(this.f9947c)).getPlayState() == 2 && e() == 0;
    }

    public int c(long j11) {
        return this.f9949e - ((int) (j11 - (e() * ((long) this.f9948d))));
    }

    public long d(boolean z11) {
        long jF;
        if (((AudioTrack) z3.a.e(this.f9947c)).getPlayState() == 3) {
            m();
        }
        long jNanoTime = this.J.nanoTime() / 1000;
        a0 a0Var = (a0) z3.a.e(this.f9950f);
        boolean zD = a0Var.d();
        if (zD) {
            jF = u0.e1(a0Var.b(), this.f9951g) + u0.h0(jNanoTime - a0Var.c(), this.f9954j);
        } else {
            jF = this.f9968x == 0 ? f() : u0.h0(this.f9956l + jNanoTime, this.f9954j);
            if (!z11) {
                jF = Math.max(0L, jF - this.f9959o);
            }
        }
        if (this.E != zD) {
            this.G = this.D;
            this.F = this.C;
        }
        long j11 = jNanoTime - this.G;
        if (j11 < 1000000) {
            long jH0 = this.F + u0.h0(j11, this.f9954j);
            long j12 = (j11 * 1000) / 1000000;
            jF = ((jF * j12) + ((1000 - j12) * jH0)) / 1000;
        }
        if (!this.f9955k) {
            long j13 = this.C;
            if (jF > j13) {
                this.f9955k = true;
                this.f9945a.b(this.J.currentTimeMillis() - u0.B1(u0.m0(u0.B1(jF - j13), this.f9954j)));
            }
        }
        this.D = jNanoTime;
        this.C = jF;
        this.E = zD;
        return jF;
    }

    public final long e() {
        long jElapsedRealtime = this.J.elapsedRealtime();
        if (this.f9969y != C.TIME_UNSET) {
            if (((AudioTrack) z3.a.e(this.f9947c)).getPlayState() == 2) {
                return this.A;
            }
            return Math.min(this.B, this.A + u0.F(u0.h0(u0.S0(jElapsedRealtime) - this.f9969y, this.f9954j), this.f9951g));
        }
        if (jElapsedRealtime - this.f9963s >= 5) {
            w(jElapsedRealtime);
            this.f9963s = jElapsedRealtime;
        }
        return this.f9964t + this.I + (this.f9965u << 32);
    }

    public final long f() {
        return u0.e1(e(), this.f9951g);
    }

    public void g(long j11) {
        this.A = e();
        this.f9969y = u0.S0(this.J.elapsedRealtime());
        this.B = j11;
    }

    public boolean h(long j11) {
        return j11 > u0.F(d(false), this.f9951g) || b();
    }

    public boolean i() {
        return ((AudioTrack) z3.a.e(this.f9947c)).getPlayState() == 3;
    }

    public boolean j(long j11) {
        return this.f9970z != C.TIME_UNSET && j11 > 0 && this.J.elapsedRealtime() - this.f9970z >= 200;
    }

    public boolean k(long j11) {
        int playState = ((AudioTrack) z3.a.e(this.f9947c)).getPlayState();
        if (this.f9952h) {
            if (playState == 2) {
                this.f9960p = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z11 = this.f9960p;
        boolean zH = h(j11);
        this.f9960p = zH;
        if (z11 && !zH && playState != 1) {
            this.f9945a.onUnderrun(this.f9949e, u0.B1(this.f9953i));
        }
        return true;
    }

    public final void l(long j11) {
        a0 a0Var = (a0) z3.a.e(this.f9950f);
        if (a0Var.e(j11)) {
            long jC = a0Var.c();
            long jB = a0Var.b();
            long jF = f();
            if (Math.abs(jC - j11) > 5000000) {
                this.f9945a.onSystemTimeUsMismatch(jB, jC, j11, jF);
                a0Var.f();
            } else if (Math.abs(u0.e1(jB, this.f9951g) - jF) <= 5000000) {
                a0Var.a();
            } else {
                this.f9945a.onPositionFramesMismatch(jB, jC, j11, jF);
                a0Var.f();
            }
        }
    }

    public final void m() {
        long jNanoTime = this.J.nanoTime() / 1000;
        if (jNanoTime - this.f9957m >= 30000) {
            long jF = f();
            if (jF != 0) {
                this.f9946b[this.f9967w] = u0.m0(jF, this.f9954j) - jNanoTime;
                this.f9967w = (this.f9967w + 1) % 10;
                int i11 = this.f9968x;
                if (i11 < 10) {
                    this.f9968x = i11 + 1;
                }
                this.f9957m = jNanoTime;
                this.f9956l = 0L;
                int i12 = 0;
                while (true) {
                    int i13 = this.f9968x;
                    if (i12 >= i13) {
                        break;
                    }
                    this.f9956l += this.f9946b[i12] / ((long) i13);
                    i12++;
                }
            } else {
                return;
            }
        }
        if (this.f9952h) {
            return;
        }
        l(jNanoTime);
        n(jNanoTime);
    }

    public final void n(long j11) {
        Method method;
        if (!this.f9961q || (method = this.f9958n) == null || j11 - this.f9962r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) u0.i((Integer) method.invoke(z3.a.e(this.f9947c), new Object[0]))).intValue()) * 1000) - this.f9953i;
            this.f9959o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f9959o = jMax;
            if (jMax > 5000000) {
                this.f9945a.onInvalidLatency(jMax);
                this.f9959o = 0L;
            }
        } catch (Exception unused) {
            this.f9958n = null;
        }
        this.f9962r = j11;
    }

    public boolean p() {
        r();
        if (this.f9969y == C.TIME_UNSET) {
            ((a0) z3.a.e(this.f9950f)).g();
            return true;
        }
        this.A = e();
        return false;
    }

    public void q() {
        r();
        this.f9947c = null;
        this.f9950f = null;
    }

    public final void r() {
        this.f9956l = 0L;
        this.f9968x = 0;
        this.f9967w = 0;
        this.f9957m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.f9955k = false;
    }

    public void s(AudioTrack audioTrack, boolean z11, int i11, int i12, int i13) {
        this.f9947c = audioTrack;
        this.f9948d = i12;
        this.f9949e = i13;
        this.f9950f = new a0(audioTrack);
        this.f9951g = audioTrack.getSampleRate();
        this.f9952h = z11 && o(i11);
        boolean zI0 = u0.I0(i11);
        this.f9961q = zI0;
        this.f9953i = zI0 ? u0.e1(i13 / i12, this.f9951g) : -9223372036854775807L;
        this.f9964t = 0L;
        this.f9965u = 0L;
        this.H = false;
        this.I = 0L;
        this.f9966v = 0L;
        this.f9960p = false;
        this.f9969y = C.TIME_UNSET;
        this.f9970z = C.TIME_UNSET;
        this.f9962r = 0L;
        this.f9959o = 0L;
        this.f9954j = 1.0f;
    }

    public void t(float f11) {
        this.f9954j = f11;
        a0 a0Var = this.f9950f;
        if (a0Var != null) {
            a0Var.g();
        }
        r();
    }

    public void u(z3.d dVar) {
        this.J = dVar;
    }

    public void v() {
        if (this.f9969y != C.TIME_UNSET) {
            this.f9969y = u0.S0(this.J.elapsedRealtime());
        }
        ((a0) z3.a.e(this.f9950f)).g();
    }

    public final void w(long j11) {
        AudioTrack audioTrack = (AudioTrack) z3.a.e(this.f9947c);
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f9952h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f9966v = this.f9964t;
            }
            playbackHeadPosition += this.f9966v;
        }
        if (u0.f81838a <= 29) {
            if (playbackHeadPosition == 0 && this.f9964t > 0 && playState == 3) {
                if (this.f9970z == C.TIME_UNSET) {
                    this.f9970z = j11;
                    return;
                }
                return;
            }
            this.f9970z = C.TIME_UNSET;
        }
        long j12 = this.f9964t;
        if (j12 > playbackHeadPosition) {
            if (this.H) {
                this.I += j12;
                this.H = false;
            } else {
                this.f9965u++;
            }
        }
        this.f9964t = playbackHeadPosition;
    }
}
