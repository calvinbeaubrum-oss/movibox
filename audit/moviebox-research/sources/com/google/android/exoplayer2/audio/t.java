package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f32920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f32921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public AudioTrack f32922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f32923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public s f32925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f32926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f32927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f32928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f32929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f32930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f32931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f32932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public Method f32933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f32934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f32935p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f32936q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f32937r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f32938s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f32939t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f32940u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f32941v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f32942w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f32943x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f32944y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f32945z;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(long j11);

        void onInvalidLatency(long j11);

        void onPositionFramesMismatch(long j11, long j12, long j13, long j14);

        void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14);

        void onUnderrun(int i11, long j11);
    }

    public t(a aVar) {
        this.f32920a = (a) com.google.android.exoplayer2.util.a.e(aVar);
        if (o0.f35608a >= 18) {
            try {
                this.f32933n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f32921b = new long[10];
    }

    public static boolean o(int i11) {
        return o0.f35608a < 23 && (i11 == 5 || i11 == 6);
    }

    public final boolean a() {
        return this.f32927h && ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f32922c)).getPlayState() == 2 && e() == 0;
    }

    public final long b(long j11) {
        return (j11 * 1000000) / ((long) this.f32926g);
    }

    public int c(long j11) {
        return this.f32924e - ((int) (j11 - (e() * ((long) this.f32923d))));
    }

    public long d(boolean z11) {
        long jF;
        if (((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f32922c)).getPlayState() == 3) {
            m();
        }
        long jNanoTime = System.nanoTime() / 1000;
        s sVar = (s) com.google.android.exoplayer2.util.a.e(this.f32925f);
        boolean zD = sVar.d();
        if (zD) {
            jF = b(sVar.b()) + o0.a0(jNanoTime - sVar.c(), this.f32929j);
        } else {
            jF = this.f32942w == 0 ? f() : this.f32931l + jNanoTime;
            if (!z11) {
                jF = Math.max(0L, jF - this.f32934o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j11 = jNanoTime - this.F;
        if (j11 < 1000000) {
            long jA0 = this.E + o0.a0(j11, this.f32929j);
            long j12 = (j11 * 1000) / 1000000;
            jF = ((jF * j12) + ((1000 - j12) * jA0)) / 1000;
        }
        if (!this.f32930k) {
            long j13 = this.B;
            if (jF > j13) {
                this.f32930k = true;
                this.f32920a.b(System.currentTimeMillis() - o0.f1(o0.f0(o0.f1(jF - j13), this.f32929j)));
            }
        }
        this.C = jNanoTime;
        this.B = jF;
        this.D = zD;
        return jF;
    }

    public final long e() {
        AudioTrack audioTrack = (AudioTrack) com.google.android.exoplayer2.util.a.e(this.f32922c);
        if (this.f32943x != C.TIME_UNSET) {
            return Math.min(this.A, this.f32945z + ((((SystemClock.elapsedRealtime() * 1000) - this.f32943x) * ((long) this.f32926g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f32927h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f32940u = this.f32938s;
            }
            playbackHeadPosition += this.f32940u;
        }
        if (o0.f35608a <= 29) {
            if (playbackHeadPosition == 0 && this.f32938s > 0 && playState == 3) {
                if (this.f32944y == C.TIME_UNSET) {
                    this.f32944y = SystemClock.elapsedRealtime();
                }
                return this.f32938s;
            }
            this.f32944y = C.TIME_UNSET;
        }
        if (this.f32938s > playbackHeadPosition) {
            this.f32939t++;
        }
        this.f32938s = playbackHeadPosition;
        return playbackHeadPosition + (this.f32939t << 32);
    }

    public final long f() {
        return b(e());
    }

    public void g(long j11) {
        this.f32945z = e();
        this.f32943x = SystemClock.elapsedRealtime() * 1000;
        this.A = j11;
    }

    public boolean h(long j11) {
        return j11 > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f32922c)).getPlayState() == 3;
    }

    public boolean j(long j11) {
        return this.f32944y != C.TIME_UNSET && j11 > 0 && SystemClock.elapsedRealtime() - this.f32944y >= 200;
    }

    public boolean k(long j11) {
        int playState = ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f32922c)).getPlayState();
        if (this.f32927h) {
            if (playState == 2) {
                this.f32935p = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z11 = this.f32935p;
        boolean zH = h(j11);
        this.f32935p = zH;
        if (z11 && !zH && playState != 1) {
            this.f32920a.onUnderrun(this.f32924e, o0.f1(this.f32928i));
        }
        return true;
    }

    public final void l(long j11, long j12) {
        s sVar = (s) com.google.android.exoplayer2.util.a.e(this.f32925f);
        if (sVar.e(j11)) {
            long jC = sVar.c();
            long jB = sVar.b();
            if (Math.abs(jC - j11) > 5000000) {
                this.f32920a.onSystemTimeUsMismatch(jB, jC, j11, j12);
                sVar.f();
            } else if (Math.abs(b(jB) - j12) <= 5000000) {
                sVar.a();
            } else {
                this.f32920a.onPositionFramesMismatch(jB, jC, j11, j12);
                sVar.f();
            }
        }
    }

    public final void m() {
        long jF = f();
        if (jF == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f32932m >= 30000) {
            long[] jArr = this.f32921b;
            int i11 = this.f32941v;
            jArr[i11] = jF - jNanoTime;
            this.f32941v = (i11 + 1) % 10;
            int i12 = this.f32942w;
            if (i12 < 10) {
                this.f32942w = i12 + 1;
            }
            this.f32932m = jNanoTime;
            this.f32931l = 0L;
            int i13 = 0;
            while (true) {
                int i14 = this.f32942w;
                if (i13 >= i14) {
                    break;
                }
                this.f32931l += this.f32921b[i13] / ((long) i14);
                i13++;
            }
        }
        if (this.f32927h) {
            return;
        }
        l(jNanoTime, jF);
        n(jNanoTime);
    }

    public final void n(long j11) {
        Method method;
        if (!this.f32936q || (method = this.f32933n) == null || j11 - this.f32937r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) o0.j((Integer) method.invoke(com.google.android.exoplayer2.util.a.e(this.f32922c), new Object[0]))).intValue()) * 1000) - this.f32928i;
            this.f32934o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f32934o = jMax;
            if (jMax > 5000000) {
                this.f32920a.onInvalidLatency(jMax);
                this.f32934o = 0L;
            }
        } catch (Exception unused) {
            this.f32933n = null;
        }
        this.f32937r = j11;
    }

    public boolean p() {
        r();
        if (this.f32943x != C.TIME_UNSET) {
            return false;
        }
        ((s) com.google.android.exoplayer2.util.a.e(this.f32925f)).g();
        return true;
    }

    public void q() {
        r();
        this.f32922c = null;
        this.f32925f = null;
    }

    public final void r() {
        this.f32931l = 0L;
        this.f32942w = 0;
        this.f32941v = 0;
        this.f32932m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f32930k = false;
    }

    public void s(AudioTrack audioTrack, boolean z11, int i11, int i12, int i13) {
        this.f32922c = audioTrack;
        this.f32923d = i12;
        this.f32924e = i13;
        this.f32925f = new s(audioTrack);
        this.f32926g = audioTrack.getSampleRate();
        this.f32927h = z11 && o(i11);
        boolean zU0 = o0.u0(i11);
        this.f32936q = zU0;
        this.f32928i = zU0 ? b(i13 / i12) : -9223372036854775807L;
        this.f32938s = 0L;
        this.f32939t = 0L;
        this.f32940u = 0L;
        this.f32935p = false;
        this.f32943x = C.TIME_UNSET;
        this.f32944y = C.TIME_UNSET;
        this.f32937r = 0L;
        this.f32934o = 0L;
        this.f32929j = 1.0f;
    }

    public void t(float f11) {
        this.f32929j = f11;
        s sVar = this.f32925f;
        if (sVar != null) {
            sVar.g();
        }
    }

    public void u() {
        ((s) com.google.android.exoplayer2.util.a.e(this.f32925f)).g();
    }
}
