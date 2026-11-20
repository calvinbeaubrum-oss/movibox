package tg;

import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f76998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f76999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f77000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f77001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f77002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f77003f;

    public d(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f76999b = iArr;
        this.f77000c = jArr;
        this.f77001d = jArr2;
        this.f77002e = jArr3;
        int length = iArr.length;
        this.f76998a = length;
        if (length > 0) {
            this.f77003f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f77003f = 0L;
        }
    }

    public int b(long j11) {
        return o0.i(this.f77002e, j11, true, true);
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f77003f;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        int iB = b(j11);
        c0 c0Var = new c0(this.f77002e[iB], this.f77000c[iB]);
        if (c0Var.f76996a >= j11 || iB == this.f76998a - 1) {
            return new b0.a(c0Var);
        }
        int i11 = iB + 1;
        return new b0.a(c0Var, new c0(this.f77002e[i11], this.f77000c[i11]));
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f76998a + ", sizes=" + Arrays.toString(this.f76999b) + ", offsets=" + Arrays.toString(this.f77000c) + ", timeUs=" + Arrays.toString(this.f77002e) + ", durationsUs=" + Arrays.toString(this.f77001d) + ")";
    }
}
