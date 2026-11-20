package com.applovin.impl;

import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e6 implements kc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f18562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f18563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f18565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f18568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f18570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f18571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f18572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f18573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f18574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f18575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f18576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f18577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f18578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f18579r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f18580s;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f18581a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f18582b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f18583c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f18584d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f18585e = t2.a(20L);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f18586f = t2.a(500L);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f18587g = 0.999f;

        public e6 a() {
            return new e6(this.f18581a, this.f18582b, this.f18583c, this.f18584d, this.f18585e, this.f18586f, this.f18587g);
        }
    }

    private e6(float f11, float f12, long j11, float f13, long j12, long j13, float f14) {
        this.f18562a = f11;
        this.f18563b = f12;
        this.f18564c = j11;
        this.f18565d = f13;
        this.f18566e = j12;
        this.f18567f = j13;
        this.f18568g = f14;
        this.f18569h = C.TIME_UNSET;
        this.f18570i = C.TIME_UNSET;
        this.f18572k = C.TIME_UNSET;
        this.f18573l = C.TIME_UNSET;
        this.f18576o = f11;
        this.f18575n = f12;
        this.f18577p = 1.0f;
        this.f18578q = C.TIME_UNSET;
        this.f18571j = C.TIME_UNSET;
        this.f18574m = C.TIME_UNSET;
        this.f18579r = C.TIME_UNSET;
        this.f18580s = C.TIME_UNSET;
    }

    private static long a(long j11, long j12, float f11) {
        return (long) ((j11 * f11) + ((1.0f - f11) * j12));
    }

    private void b(long j11) {
        long j12 = this.f18579r + (this.f18580s * 3);
        if (this.f18574m > j12) {
            float fA = t2.a(this.f18564c);
            this.f18574m = sc.a(j12, this.f18571j, this.f18574m - (((long) ((this.f18577p - 1.0f) * fA)) + ((long) ((this.f18575n - 1.0f) * fA))));
            return;
        }
        long jB = xp.b(j11 - ((long) (Math.max(0.0f, this.f18577p - 1.0f) / this.f18565d)), this.f18574m, j12);
        this.f18574m = jB;
        long j13 = this.f18573l;
        if (j13 == C.TIME_UNSET || jB <= j13) {
            return;
        }
        this.f18574m = j13;
    }

    private void b(long j11, long j12) {
        long j13 = j11 - j12;
        long j14 = this.f18579r;
        if (j14 == C.TIME_UNSET) {
            this.f18579r = j13;
            this.f18580s = 0L;
        } else {
            long jMax = Math.max(j13, a(j14, j13, this.f18568g));
            this.f18579r = jMax;
            this.f18580s = a(this.f18580s, Math.abs(j13 - jMax), this.f18568g);
        }
    }

    private void c() {
        long j11 = this.f18569h;
        if (j11 != C.TIME_UNSET) {
            long j12 = this.f18570i;
            if (j12 != C.TIME_UNSET) {
                j11 = j12;
            }
            long j13 = this.f18572k;
            if (j13 != C.TIME_UNSET && j11 < j13) {
                j11 = j13;
            }
            long j14 = this.f18573l;
            if (j14 != C.TIME_UNSET && j11 > j14) {
                j11 = j14;
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.f18571j == j11) {
            return;
        }
        this.f18571j = j11;
        this.f18574m = j11;
        this.f18579r = C.TIME_UNSET;
        this.f18580s = C.TIME_UNSET;
        this.f18578q = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.kc
    public float a(long j11, long j12) {
        if (this.f18569h == C.TIME_UNSET) {
            return 1.0f;
        }
        b(j11, j12);
        if (this.f18578q != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f18578q < this.f18564c) {
            return this.f18577p;
        }
        this.f18578q = SystemClock.elapsedRealtime();
        b(j11);
        long j13 = j11 - this.f18574m;
        if (Math.abs(j13) < this.f18566e) {
            this.f18577p = 1.0f;
        } else {
            this.f18577p = xp.a((this.f18565d * j13) + 1.0f, this.f18576o, this.f18575n);
        }
        return this.f18577p;
    }

    @Override // com.applovin.impl.kc
    public void a() {
        long j11 = this.f18574m;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        long j12 = j11 + this.f18567f;
        this.f18574m = j12;
        long j13 = this.f18573l;
        if (j13 != C.TIME_UNSET && j12 > j13) {
            this.f18574m = j13;
        }
        this.f18578q = C.TIME_UNSET;
    }

    @Override // com.applovin.impl.kc
    public void a(long j11) {
        this.f18570i = j11;
        c();
    }

    @Override // com.applovin.impl.kc
    public void a(td.f fVar) {
        this.f18569h = t2.a(fVar.f23290a);
        this.f18572k = t2.a(fVar.f23291b);
        this.f18573l = t2.a(fVar.f23292c);
        float f11 = fVar.f23293d;
        if (f11 == -3.4028235E38f) {
            f11 = this.f18562a;
        }
        this.f18576o = f11;
        float f12 = fVar.f23294f;
        if (f12 == -3.4028235E38f) {
            f12 = this.f18563b;
        }
        this.f18575n = f12;
        c();
    }

    @Override // com.applovin.impl.kc
    public long b() {
        return this.f18574m;
    }
}
