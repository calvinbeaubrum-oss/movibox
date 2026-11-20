package androidx.media3.exoplayer;

import android.os.SystemClock;
import com.google.common.primitives.Longs;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f10920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f10923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f10925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f10926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f10931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f10933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f10934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f10935p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f10936q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f10937r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f10938s;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f10939a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f10940b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f10941c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f10942d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f10943e = z3.u0.S0(20);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f10944f = z3.u0.S0(500);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f10945g = 0.999f;

        public p a() {
            return new p(this.f10939a, this.f10940b, this.f10941c, this.f10942d, this.f10943e, this.f10944f, this.f10945g);
        }
    }

    public p(float f11, float f12, long j11, float f13, long j12, long j13, float f14) {
        this.f10920a = f11;
        this.f10921b = f12;
        this.f10922c = j11;
        this.f10923d = f13;
        this.f10924e = j12;
        this.f10925f = j13;
        this.f10926g = f14;
        this.f10927h = C.TIME_UNSET;
        this.f10928i = C.TIME_UNSET;
        this.f10930k = C.TIME_UNSET;
        this.f10931l = C.TIME_UNSET;
        this.f10934o = f11;
        this.f10933n = f12;
        this.f10935p = 1.0f;
        this.f10936q = C.TIME_UNSET;
        this.f10929j = C.TIME_UNSET;
        this.f10932m = C.TIME_UNSET;
        this.f10937r = C.TIME_UNSET;
        this.f10938s = C.TIME_UNSET;
    }

    public static long h(long j11, long j12, float f11) {
        return (long) ((j11 * f11) + ((1.0f - f11) * j12));
    }

    @Override // androidx.media3.exoplayer.u1
    public float a(long j11, long j12) {
        if (this.f10927h == C.TIME_UNSET) {
            return 1.0f;
        }
        i(j11, j12);
        if (this.f10936q != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f10936q < this.f10922c) {
            return this.f10935p;
        }
        this.f10936q = SystemClock.elapsedRealtime();
        f(j11);
        long j13 = j11 - this.f10932m;
        if (Math.abs(j13) < this.f10924e) {
            this.f10935p = 1.0f;
        } else {
            this.f10935p = z3.u0.o((this.f10923d * j13) + 1.0f, this.f10934o, this.f10933n);
        }
        return this.f10935p;
    }

    @Override // androidx.media3.exoplayer.u1
    public long b() {
        return this.f10932m;
    }

    @Override // androidx.media3.exoplayer.u1
    public void c() {
        long j11 = this.f10932m;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        long j12 = j11 + this.f10925f;
        this.f10932m = j12;
        long j13 = this.f10931l;
        if (j13 != C.TIME_UNSET && j12 > j13) {
            this.f10932m = j13;
        }
        this.f10936q = C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.u1
    public void d(long j11) {
        this.f10928i = j11;
        g();
    }

    @Override // androidx.media3.exoplayer.u1
    public void e(androidx.media3.common.b0.g gVar) {
        this.f10927h = z3.u0.S0(gVar.f9028a);
        this.f10930k = z3.u0.S0(gVar.f9029b);
        this.f10931l = z3.u0.S0(gVar.f9030c);
        float f11 = gVar.f9031d;
        if (f11 == -3.4028235E38f) {
            f11 = this.f10920a;
        }
        this.f10934o = f11;
        float f12 = gVar.f9032e;
        if (f12 == -3.4028235E38f) {
            f12 = this.f10921b;
        }
        this.f10933n = f12;
        if (f11 == 1.0f && f12 == 1.0f) {
            this.f10927h = C.TIME_UNSET;
        }
        g();
    }

    public final void f(long j11) {
        long j12 = this.f10937r + (this.f10938s * 3);
        if (this.f10932m > j12) {
            float fS0 = z3.u0.S0(this.f10922c);
            this.f10932m = Longs.h(j12, this.f10929j, this.f10932m - (((long) ((this.f10935p - 1.0f) * fS0)) + ((long) ((this.f10933n - 1.0f) * fS0))));
            return;
        }
        long jQ = z3.u0.q(j11 - ((long) (Math.max(0.0f, this.f10935p - 1.0f) / this.f10923d)), this.f10932m, j12);
        this.f10932m = jQ;
        long j13 = this.f10931l;
        if (j13 == C.TIME_UNSET || jQ <= j13) {
            return;
        }
        this.f10932m = j13;
    }

    public final void g() {
        long j11;
        long j12 = this.f10927h;
        if (j12 != C.TIME_UNSET) {
            j11 = this.f10928i;
            if (j11 == C.TIME_UNSET) {
                long j13 = this.f10930k;
                if (j13 != C.TIME_UNSET && j12 < j13) {
                    j12 = j13;
                }
                j11 = this.f10931l;
                if (j11 == C.TIME_UNSET || j12 <= j11) {
                    j11 = j12;
                }
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.f10929j == j11) {
            return;
        }
        this.f10929j = j11;
        this.f10932m = j11;
        this.f10937r = C.TIME_UNSET;
        this.f10938s = C.TIME_UNSET;
        this.f10936q = C.TIME_UNSET;
    }

    public final void i(long j11, long j12) {
        long j13 = j11 - j12;
        long j14 = this.f10937r;
        if (j14 == C.TIME_UNSET) {
            this.f10937r = j13;
            this.f10938s = 0L;
        } else {
            long jMax = Math.max(j13, h(j14, j13, this.f10926g));
            this.f10937r = jMax;
            this.f10938s = h(this.f10938s, Math.abs(j13 - jMax), this.f10926g);
        }
    }
}
