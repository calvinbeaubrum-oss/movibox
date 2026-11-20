package u4;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f78290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f78291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f78293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f78295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f78296g;

    public i(long j11, long j12, int i11, int i12, boolean z11) {
        this.f78290a = j11;
        this.f78291b = j12;
        this.f78292c = i12 == -1 ? 1 : i12;
        this.f78294e = i11;
        this.f78296g = z11;
        if (j11 == -1) {
            this.f78293d = -1L;
            this.f78295f = C.TIME_UNSET;
        } else {
            this.f78293d = j11 - j12;
            this.f78295f = d(j11, j12, i11);
        }
    }

    public static long d(long j11, long j12, int i11) {
        return (Math.max(0L, j11 - j12) * 8000000) / ((long) i11);
    }

    public final long b(long j11) {
        long j12 = (j11 * ((long) this.f78294e)) / 8000000;
        int i11 = this.f78292c;
        long jMin = (j12 / ((long) i11)) * ((long) i11);
        long j13 = this.f78293d;
        if (j13 != -1) {
            jMin = Math.min(jMin, j13 - ((long) i11));
        }
        return this.f78291b + Math.max(jMin, 0L);
    }

    public long c(long j11) {
        return d(j11, this.f78291b, this.f78294e);
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f78295f;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        if (this.f78293d == -1 && !this.f78296g) {
            return new m0.a(new n0(0L, this.f78291b));
        }
        long jB = b(j11);
        long jC = c(jB);
        n0 n0Var = new n0(jC, jB);
        if (this.f78293d != -1 && jC < j11) {
            int i11 = this.f78292c;
            if (((long) i11) + jB < this.f78290a) {
                long j12 = jB + ((long) i11);
                return new m0.a(n0Var, new n0(c(j12), j12));
            }
        }
        return new m0.a(n0Var);
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return this.f78293d != -1 || this.f78296g;
    }
}
