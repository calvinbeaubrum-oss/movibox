package u4;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f78211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f78212b;

    public b0(c0 c0Var, long j11) {
        this.f78211a = c0Var;
        this.f78212b = j11;
    }

    public final n0 b(long j11, long j12) {
        return new n0((j11 * 1000000) / ((long) this.f78211a.f78223e), this.f78212b + j12);
    }

    @Override // u4.m0
    public long getDurationUs() {
        return this.f78211a.f();
    }

    @Override // u4.m0
    public m0.a getSeekPoints(long j11) {
        z3.a.i(this.f78211a.f78229k);
        c0 c0Var = this.f78211a;
        c0.a aVar = c0Var.f78229k;
        long[] jArr = aVar.f78231a;
        long[] jArr2 = aVar.f78232b;
        int iH = z3.u0.h(jArr, c0Var.i(j11), true, false);
        n0 n0VarB = b(iH == -1 ? 0L : jArr[iH], iH != -1 ? jArr2[iH] : 0L);
        if (n0VarB.f78353a == j11 || iH == jArr.length - 1) {
            return new m0.a(n0VarB);
        }
        int i11 = iH + 1;
        return new m0.a(n0VarB, b(jArr[i11], jArr2[i11]));
    }

    @Override // u4.m0
    public boolean isSeekable() {
        return true;
    }
}
