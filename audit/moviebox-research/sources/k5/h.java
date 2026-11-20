package k5;

import androidx.annotation.Nullable;
import u4.j0;
import u4.m0;
import u4.n0;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f68273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f68274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f68276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68277e;

    public h(long[] jArr, long[] jArr2, long j11, long j12, int i11) {
        this.f68273a = jArr;
        this.f68274b = jArr2;
        this.f68275c = j11;
        this.f68276d = j12;
        this.f68277e = i11;
    }

    @Nullable
    public static h b(long j11, long j12, j0.a aVar, c0 c0Var) {
        int iH;
        c0Var.V(10);
        int iQ = c0Var.q();
        if (iQ <= 0) {
            return null;
        }
        int i11 = aVar.f78318d;
        long jF1 = u0.f1(iQ, ((long) (i11 >= 32000 ? 1152 : 576)) * 1000000, i11);
        int iN = c0Var.N();
        int iN2 = c0Var.N();
        int iN3 = c0Var.N();
        c0Var.V(2);
        long j13 = j12 + ((long) aVar.f78317c);
        long[] jArr = new long[iN];
        long[] jArr2 = new long[iN];
        int i12 = 0;
        long j14 = j12;
        while (i12 < iN) {
            int i13 = iN2;
            long j15 = j13;
            jArr[i12] = (((long) i12) * jF1) / ((long) iN);
            jArr2[i12] = Math.max(j14, j15);
            if (iN3 == 1) {
                iH = c0Var.H();
            } else if (iN3 == 2) {
                iH = c0Var.N();
            } else if (iN3 == 3) {
                iH = c0Var.K();
            } else {
                if (iN3 != 4) {
                    return null;
                }
                iH = c0Var.L();
            }
            j14 += ((long) iH) * ((long) i13);
            i12++;
            iN = iN;
            iN2 = i13;
            j13 = j15;
        }
        if (j11 != -1 && j11 != j14) {
            o.h("VbriSeeker", "VBRI data size mismatch: " + j11 + ", " + j14);
        }
        return new h(jArr, jArr2, jF1, j14, aVar.f78320f);
    }

    @Override // k5.g
    public long a() {
        return this.f68276d;
    }

    @Override // k5.g
    public int e() {
        return this.f68277e;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f68275c;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        int iH = u0.h(this.f68273a, j11, true, true);
        n0 n0Var = new n0(this.f68273a[iH], this.f68274b[iH]);
        if (n0Var.f78353a >= j11 || iH == this.f68273a.length - 1) {
            return new m0.a(n0Var);
        }
        int i11 = iH + 1;
        return new m0.a(n0Var, new n0(this.f68273a[i11], this.f68274b[i11]));
    }

    @Override // k5.g
    public long getTimeUs(long j11) {
        return this.f68273a[u0.h(this.f68274b, j11, true, true)];
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }
}
