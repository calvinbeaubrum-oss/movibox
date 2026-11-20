package u4;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f78297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f78298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f78299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f78300d;

    public i0(long[] jArr, long[] jArr2, long j11) {
        z3.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z11 = length > 0;
        this.f78300d = z11;
        if (!z11 || jArr2[0] <= 0) {
            this.f78297a = jArr;
            this.f78298b = jArr2;
        } else {
            int i11 = length + 1;
            long[] jArr3 = new long[i11];
            this.f78297a = jArr3;
            long[] jArr4 = new long[i11];
            this.f78298b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f78299c = j11;
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f78299c;
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        if (!this.f78300d) {
            return new m0.a(n0.f78352c);
        }
        int iH = z3.u0.h(this.f78298b, j11, true, true);
        n0 n0Var = new n0(this.f78298b[iH], this.f78297a[iH]);
        if (n0Var.f78353a == j11 || iH == this.f78298b.length - 1) {
            return new m0.a(n0Var);
        }
        int i11 = iH + 1;
        return new m0.a(n0Var, new n0(this.f78298b[i11], this.f78297a[i11]));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return this.f78300d;
    }
}
