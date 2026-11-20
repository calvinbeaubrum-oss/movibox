package tg;

import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f77078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f77079b;

    public u(v vVar, long j11) {
        this.f77078a = vVar;
        this.f77079b = j11;
    }

    public final c0 b(long j11, long j12) {
        return new c0((j11 * 1000000) / ((long) this.f77078a.f77084e), this.f77079b + j12);
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f77078a.f();
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        com.google.android.exoplayer2.util.a.i(this.f77078a.f77090k);
        v vVar = this.f77078a;
        v.a aVar = vVar.f77090k;
        long[] jArr = aVar.f77092a;
        long[] jArr2 = aVar.f77093b;
        int i11 = o0.i(jArr, vVar.i(j11), true, false);
        c0 c0VarB = b(i11 == -1 ? 0L : jArr[i11], i11 != -1 ? jArr2[i11] : 0L);
        if (c0VarB.f76996a == j11 || i11 == jArr.length - 1) {
            return new b0.a(c0VarB);
        }
        int i12 = i11 + 1;
        return new b0.a(c0VarB, b(jArr[i12], jArr2[i12]));
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }
}
