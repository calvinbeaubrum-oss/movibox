package u4;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f78284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f78285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f78286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f78287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f78288f;

    public h(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f78284b = iArr;
        this.f78285c = jArr;
        this.f78286d = jArr2;
        this.f78287e = jArr3;
        int length = iArr.length;
        this.f78283a = length;
        if (length > 0) {
            this.f78288f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f78288f = 0L;
        }
    }

    public int b(long j11) {
        return z3.u0.h(this.f78287e, j11, true, true);
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f78288f;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        int iB = b(j11);
        n0 n0Var = new n0(this.f78287e[iB], this.f78285c[iB]);
        if (n0Var.f78353a >= j11 || iB == this.f78283a - 1) {
            return new m0.a(n0Var);
        }
        int i11 = iB + 1;
        return new m0.a(n0Var, new n0(this.f78287e[i11], this.f78285c[i11]));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f78283a + ", sizes=" + Arrays.toString(this.f78284b) + ", offsets=" + Arrays.toString(this.f78285c) + ", timeUs=" + Arrays.toString(this.f78287e) + ", durationsUs=" + Arrays.toString(this.f78286d) + ")";
    }
}
