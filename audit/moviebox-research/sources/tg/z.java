package tg;

import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class z implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f77099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f77100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f77101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f77102d;

    public z(long[] jArr, long[] jArr2, long j11) {
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z11 = length > 0;
        this.f77102d = z11;
        if (!z11 || jArr2[0] <= 0) {
            this.f77099a = jArr;
            this.f77100b = jArr2;
        } else {
            int i11 = length + 1;
            long[] jArr3 = new long[i11];
            this.f77099a = jArr3;
            long[] jArr4 = new long[i11];
            this.f77100b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f77101c = j11;
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f77101c;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        if (!this.f77102d) {
            return new b0.a(c0.f76995c);
        }
        int i11 = o0.i(this.f77100b, j11, true, true);
        c0 c0Var = new c0(this.f77100b[i11], this.f77099a[i11]);
        if (c0Var.f76996a == j11 || i11 == this.f77100b.length - 1) {
            return new b0.a(c0Var);
        }
        int i12 = i11 + 1;
        return new b0.a(c0Var, new c0(this.f77100b[i12], this.f77099a[i12]));
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return this.f77102d;
    }
}
