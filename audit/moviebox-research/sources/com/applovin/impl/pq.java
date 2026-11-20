package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class pq implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f21813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f21814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21816d;

    private pq(long[] jArr, long[] jArr2, long j11, long j12) {
        this.f21813a = jArr;
        this.f21814b = jArr2;
        this.f21815c = j11;
        this.f21816d = j12;
    }

    public static pq a(long j11, long j12, tf.a aVar, bh bhVar) {
        int iW;
        bhVar.g(10);
        int iJ = bhVar.j();
        if (iJ <= 0) {
            return null;
        }
        int i11 = aVar.f23373d;
        long jC = xp.c(iJ, ((long) (i11 >= 32000 ? 1152 : 576)) * 1000000, i11);
        int iC = bhVar.C();
        int iC2 = bhVar.C();
        int iC3 = bhVar.C();
        bhVar.g(2);
        long j13 = j12 + ((long) aVar.f23372c);
        long[] jArr = new long[iC];
        long[] jArr2 = new long[iC];
        int i12 = 0;
        long j14 = j12;
        while (i12 < iC) {
            int i13 = iC2;
            long j15 = j13;
            jArr[i12] = (((long) i12) * jC) / ((long) iC);
            jArr2[i12] = Math.max(j14, j15);
            if (iC3 == 1) {
                iW = bhVar.w();
            } else if (iC3 == 2) {
                iW = bhVar.C();
            } else if (iC3 == 3) {
                iW = bhVar.z();
            } else {
                if (iC3 != 4) {
                    return null;
                }
                iW = bhVar.A();
            }
            j14 += (long) (iW * i13);
            i12++;
            j13 = j15;
            iC2 = i13;
        }
        if (j11 != -1 && j11 != j14) {
            pc.d("VbriSeeker", "VBRI data size mismatch: " + j11 + ", " + j14);
        }
        return new pq(jArr, jArr2, jC, j14);
    }

    @Override // com.applovin.impl.lj
    public long a(long j11) {
        return this.f21813a[xp.b(this.f21814b, j11, true, true)];
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j11) {
        int iB = xp.b(this.f21813a, j11, true, true);
        kj kjVar = new kj(this.f21813a[iB], this.f21814b[iB]);
        if (kjVar.f20256a >= j11 || iB == this.f21813a.length - 1) {
            return new ij.a(kjVar);
        }
        int i11 = iB + 1;
        return new ij.a(kjVar, new kj(this.f21813a[i11], this.f21814b[i11]));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return this.f21816d;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f21815c;
    }
}
