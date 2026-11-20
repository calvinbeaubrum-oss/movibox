package k5;

import androidx.annotation.Nullable;
import u4.j0;
import u4.m0;
import u4.n0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f68284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f68288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f68289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final long[] f68290g;

    public j(long j11, int i11, long j12, int i12) {
        this(j11, i11, j12, i12, -1L, null);
    }

    public j(long j11, int i11, long j12, int i12, long j13, @Nullable long[] jArr) {
        this.f68284a = j11;
        this.f68285b = i11;
        this.f68286c = j12;
        this.f68287d = i12;
        this.f68288e = j13;
        this.f68290g = jArr;
        this.f68289f = j13 != -1 ? j11 + j13 : -1L;
    }

    @Nullable
    public static j b(long j11, i iVar, long j12) {
        long j13 = iVar.f68279b;
        if (j13 == -1 && j13 == 0) {
            return null;
        }
        j0.a aVar = iVar.f68278a;
        long jE1 = u0.e1((j13 * ((long) aVar.f78321g)) - 1, aVar.f78318d);
        long j14 = iVar.f68280c;
        if (j14 == -1 || iVar.f68283f == null) {
            j0.a aVar2 = iVar.f68278a;
            return new j(j12, aVar2.f78317c, jE1, aVar2.f78320f);
        }
        if (j11 != -1 && j11 != j12 + j14) {
            o.h("XingSeeker", "XING data size mismatch: " + j11 + ", " + (j12 + iVar.f68280c));
        }
        j0.a aVar3 = iVar.f68278a;
        return new j(j12, aVar3.f78317c, jE1, aVar3.f78320f, iVar.f68280c, iVar.f68283f);
    }

    @Override // k5.g
    public long a() {
        return this.f68289f;
    }

    public final long c(int i11) {
        return (this.f68286c * ((long) i11)) / 100;
    }

    @Override // k5.g
    public int e() {
        return this.f68287d;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f68286c;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        if (!isSeekable()) {
            return new m0.a(new n0(0L, this.f68284a + ((long) this.f68285b)));
        }
        long jQ = u0.q(j11, 0L, this.f68286c);
        double d11 = (jQ * 100.0d) / this.f68286c;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                long[] jArr = (long[]) z3.a.i(this.f68290g);
                double d13 = jArr[i11];
                d12 = d13 + ((d11 - ((double) i11)) * ((i11 == 99 ? 256.0d : jArr[i11 + 1]) - d13));
            }
        }
        return new m0.a(new n0(jQ, this.f68284a + u0.q(Math.round((d12 / 256.0d) * this.f68288e), this.f68285b, this.f68288e - 1)));
    }

    @Override // k5.g
    public long getTimeUs(long j11) {
        long j12 = j11 - this.f68284a;
        if (!isSeekable() || j12 <= this.f68285b) {
            return 0L;
        }
        long[] jArr = (long[]) z3.a.i(this.f68290g);
        double d11 = (j12 * 256.0d) / this.f68288e;
        int iH = u0.h(jArr, (long) d11, true, true);
        long jC = c(iH);
        long j13 = jArr[iH];
        int i11 = iH + 1;
        long jC2 = c(i11);
        long j14 = iH == 99 ? 256L : jArr[i11];
        return jC + Math.round((j13 == j14 ? 0.0d : (d11 - j13) / (j14 - j13)) * (jC2 - jC));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return this.f68290g != null;
    }
}
