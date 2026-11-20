package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ds implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long[] f18508f;

    private ds(long j11, int i11, long j12) {
        this(j11, i11, j12, -1L, null);
    }

    private ds(long j11, int i11, long j12, long j13, long[] jArr) {
        this.f18503a = j11;
        this.f18504b = i11;
        this.f18505c = j12;
        this.f18508f = jArr;
        this.f18506d = j13;
        this.f18507e = j13 != -1 ? j11 + j13 : -1L;
    }

    private long a(int i11) {
        return (this.f18505c * ((long) i11)) / 100;
    }

    public static ds a(long j11, long j12, tf.a aVar, bh bhVar) {
        int iA;
        int i11 = aVar.f23376g;
        int i12 = aVar.f23373d;
        int iJ = bhVar.j();
        if ((iJ & 1) != 1 || (iA = bhVar.A()) == 0) {
            return null;
        }
        long jC = xp.c(iA, ((long) i11) * 1000000, i12);
        if ((iJ & 6) != 6) {
            return new ds(j12, aVar.f23372c, jC);
        }
        long jY = bhVar.y();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = bhVar.w();
        }
        if (j11 != -1) {
            long j13 = j12 + jY;
            if (j11 != j13) {
                pc.d("XingSeeker", "XING data size mismatch: " + j11 + ", " + j13);
            }
        }
        return new ds(j12, aVar.f23372c, jC, jY, jArr);
    }

    @Override // com.applovin.impl.lj
    public long a(long j11) {
        long j12 = j11 - this.f18503a;
        if (!b() || j12 <= this.f18504b) {
            return 0L;
        }
        long[] jArr = (long[]) b1.b(this.f18508f);
        double d11 = (j12 * 256.0d) / this.f18506d;
        int iB = xp.b(jArr, (long) d11, true, true);
        long jA = a(iB);
        long j13 = jArr[iB];
        int i11 = iB + 1;
        long jA2 = a(i11);
        long j14 = iB == 99 ? 256L : jArr[i11];
        return jA + Math.round((j13 == j14 ? 0.0d : (d11 - j13) / (j14 - j13)) * (jA2 - jA));
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        if (!b()) {
            return new ij.a(new kj(0L, this.f18503a + ((long) this.f18504b)));
        }
        long jB = xp.b(j11, 0L, this.f18505c);
        double d11 = (jB * 100.0d) / this.f18505c;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                long[] jArr = (long[]) b1.b(this.f18508f);
                double d13 = jArr[i11];
                d12 = d13 + ((d11 - ((double) i11)) * ((i11 == 99 ? 256.0d : jArr[i11 + 1]) - d13));
            }
        }
        return new ij.a(new kj(jB, this.f18503a + xp.b(Math.round((d12 / 256.0d) * this.f18506d), this.f18504b, this.f18506d - 1)));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return this.f18508f != null;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return this.f18507e;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f18505c;
    }
}
