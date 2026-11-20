package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.common.primitives.Longs;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f33263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f33264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f33266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f33267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f33268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f33269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f33270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f33271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f33272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f33273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f33274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f33275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f33276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f33277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f33278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f33279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f33280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f33281s;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f33282a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f33283b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f33284c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f33285d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f33286e = com.google.android.exoplayer2.util.o0.C0(20);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f33287f = com.google.android.exoplayer2.util.o0.C0(500);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f33288g = 0.999f;

        public i a() {
            return new i(this.f33282a, this.f33283b, this.f33284c, this.f33285d, this.f33286e, this.f33287f, this.f33288g);
        }
    }

    public i(float f11, float f12, long j11, float f13, long j12, long j13, float f14) {
        this.f33263a = f11;
        this.f33264b = f12;
        this.f33265c = j11;
        this.f33266d = f13;
        this.f33267e = j12;
        this.f33268f = j13;
        this.f33269g = f14;
        this.f33270h = C.TIME_UNSET;
        this.f33271i = C.TIME_UNSET;
        this.f33273k = C.TIME_UNSET;
        this.f33274l = C.TIME_UNSET;
        this.f33277o = f11;
        this.f33276n = f12;
        this.f33278p = 1.0f;
        this.f33279q = C.TIME_UNSET;
        this.f33272j = C.TIME_UNSET;
        this.f33275m = C.TIME_UNSET;
        this.f33280r = C.TIME_UNSET;
        this.f33281s = C.TIME_UNSET;
    }

    public static long h(long j11, long j12, float f11) {
        return (long) ((j11 * f11) + ((1.0f - f11) * j12));
    }

    @Override // com.google.android.exoplayer2.r1
    public float a(long j11, long j12) {
        if (this.f33270h == C.TIME_UNSET) {
            return 1.0f;
        }
        i(j11, j12);
        if (this.f33279q != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f33279q < this.f33265c) {
            return this.f33278p;
        }
        this.f33279q = SystemClock.elapsedRealtime();
        f(j11);
        long j13 = j11 - this.f33275m;
        if (Math.abs(j13) < this.f33267e) {
            this.f33278p = 1.0f;
        } else {
            this.f33278p = com.google.android.exoplayer2.util.o0.p((this.f33266d * j13) + 1.0f, this.f33277o, this.f33276n);
        }
        return this.f33278p;
    }

    @Override // com.google.android.exoplayer2.r1
    public long b() {
        return this.f33275m;
    }

    @Override // com.google.android.exoplayer2.r1
    public void c() {
        long j11 = this.f33275m;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        long j12 = j11 + this.f33268f;
        this.f33275m = j12;
        long j13 = this.f33274l;
        if (j13 != C.TIME_UNSET && j12 > j13) {
            this.f33275m = j13;
        }
        this.f33279q = C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.r1
    public void d(long j11) {
        this.f33271i = j11;
        g();
    }

    @Override // com.google.android.exoplayer2.r1
    public void e(u1.g gVar) {
        this.f33270h = com.google.android.exoplayer2.util.o0.C0(gVar.f34829a);
        this.f33273k = com.google.android.exoplayer2.util.o0.C0(gVar.f34830b);
        this.f33274l = com.google.android.exoplayer2.util.o0.C0(gVar.f34831c);
        float f11 = gVar.f34832d;
        if (f11 == -3.4028235E38f) {
            f11 = this.f33263a;
        }
        this.f33277o = f11;
        float f12 = gVar.f34833f;
        if (f12 == -3.4028235E38f) {
            f12 = this.f33264b;
        }
        this.f33276n = f12;
        if (f11 == 1.0f && f12 == 1.0f) {
            this.f33270h = C.TIME_UNSET;
        }
        g();
    }

    public final void f(long j11) {
        long j12 = this.f33280r + (this.f33281s * 3);
        if (this.f33275m > j12) {
            float fC0 = com.google.android.exoplayer2.util.o0.C0(this.f33265c);
            this.f33275m = Longs.h(j12, this.f33272j, this.f33275m - (((long) ((this.f33278p - 1.0f) * fC0)) + ((long) ((this.f33276n - 1.0f) * fC0))));
            return;
        }
        long jR = com.google.android.exoplayer2.util.o0.r(j11 - ((long) (Math.max(0.0f, this.f33278p - 1.0f) / this.f33266d)), this.f33275m, j12);
        this.f33275m = jR;
        long j13 = this.f33274l;
        if (j13 == C.TIME_UNSET || jR <= j13) {
            return;
        }
        this.f33275m = j13;
    }

    public final void g() {
        long j11 = this.f33270h;
        if (j11 != C.TIME_UNSET) {
            long j12 = this.f33271i;
            if (j12 != C.TIME_UNSET) {
                j11 = j12;
            }
            long j13 = this.f33273k;
            if (j13 != C.TIME_UNSET && j11 < j13) {
                j11 = j13;
            }
            long j14 = this.f33274l;
            if (j14 != C.TIME_UNSET && j11 > j14) {
                j11 = j14;
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.f33272j == j11) {
            return;
        }
        this.f33272j = j11;
        this.f33275m = j11;
        this.f33280r = C.TIME_UNSET;
        this.f33281s = C.TIME_UNSET;
        this.f33279q = C.TIME_UNSET;
    }

    public final void i(long j11, long j12) {
        long j13 = j11 - j12;
        long j14 = this.f33280r;
        if (j14 == C.TIME_UNSET) {
            this.f33280r = j13;
            this.f33281s = 0L;
        } else {
            long jMax = Math.max(j13, h(j14, j13, this.f33269g));
            this.f33280r = jMax;
            this.f33281s = h(this.f33281s, Math.abs(j13 - jMax), this.f33269g);
        }
    }
}
