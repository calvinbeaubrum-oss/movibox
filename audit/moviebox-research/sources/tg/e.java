package tg;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f77004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f77005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f77007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f77008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f77009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f77010g;

    public e(long j11, long j12, int i11, int i12, boolean z11) {
        this.f77004a = j11;
        this.f77005b = j12;
        this.f77006c = i12 == -1 ? 1 : i12;
        this.f77008e = i11;
        this.f77010g = z11;
        if (j11 == -1) {
            this.f77007d = -1L;
            this.f77009f = C.TIME_UNSET;
        } else {
            this.f77007d = j11 - j12;
            this.f77009f = d(j11, j12, i11);
        }
    }

    public static long d(long j11, long j12, int i11) {
        return (Math.max(0L, j11 - j12) * 8000000) / ((long) i11);
    }

    public final long b(long j11) {
        long j12 = (j11 * ((long) this.f77008e)) / 8000000;
        int i11 = this.f77006c;
        long jMin = (j12 / ((long) i11)) * ((long) i11);
        long j13 = this.f77007d;
        if (j13 != -1) {
            jMin = Math.min(jMin, j13 - ((long) i11));
        }
        return this.f77005b + Math.max(jMin, 0L);
    }

    public long c(long j11) {
        return d(j11, this.f77005b, this.f77008e);
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f77009f;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        if (this.f77007d == -1 && !this.f77010g) {
            return new b0.a(new c0(0L, this.f77005b));
        }
        long jB = b(j11);
        long jC = c(jB);
        c0 c0Var = new c0(jC, jB);
        if (this.f77007d != -1 && jC < j11) {
            int i11 = this.f77006c;
            if (((long) i11) + jB < this.f77004a) {
                long j12 = jB + ((long) i11);
                return new b0.a(c0Var, new c0(c(j12), j12));
            }
        }
        return new b0.a(c0Var);
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return this.f77007d != -1 || this.f77010g;
    }
}
