package ah;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final long[] f534f;

    public i(long j11, int i11, long j12) {
        this(j11, i11, j12, -1L, null);
    }

    public i(long j11, int i11, long j12, long j13, @Nullable long[] jArr) {
        this.f529a = j11;
        this.f530b = i11;
        this.f531c = j12;
        this.f534f = jArr;
        this.f532d = j13;
        this.f533e = j13 != -1 ? j11 + j13 : -1L;
    }

    @Nullable
    public static i b(long j11, long j12, b0.a aVar, c0 c0Var) {
        int iH;
        int i11 = aVar.f32799g;
        int i12 = aVar.f32796d;
        int iN = c0Var.n();
        if ((iN & 1) != 1 || (iH = c0Var.H()) == 0) {
            return null;
        }
        long jO0 = o0.O0(iH, ((long) i11) * 1000000, i12);
        if ((iN & 6) != 6) {
            return new i(j12, aVar.f32795c, jO0);
        }
        long jF = c0Var.F();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = c0Var.D();
        }
        if (j11 != -1) {
            long j13 = j12 + jF;
            if (j11 != j13) {
                s.i("XingSeeker", "XING data size mismatch: " + j11 + ", " + j13);
            }
        }
        return new i(j12, aVar.f32795c, jO0, jF, jArr);
    }

    @Override // ah.g
    public long a() {
        return this.f533e;
    }

    public final long c(int i11) {
        return (this.f531c * ((long) i11)) / 100;
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f531c;
    }

    @Override // tg.b0
    public tg.b0.a getSeekPoints(long j11) {
        if (!isSeekable()) {
            return new tg.b0.a(new tg.c0(0L, this.f529a + ((long) this.f530b)));
        }
        long jR = o0.r(j11, 0L, this.f531c);
        double d11 = (jR * 100.0d) / this.f531c;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                long[] jArr = (long[]) com.google.android.exoplayer2.util.a.i(this.f534f);
                double d13 = jArr[i11];
                d12 = d13 + ((d11 - ((double) i11)) * ((i11 == 99 ? 256.0d : jArr[i11 + 1]) - d13));
            }
        }
        return new tg.b0.a(new tg.c0(jR, this.f529a + o0.r(Math.round((d12 / 256.0d) * this.f532d), this.f530b, this.f532d - 1)));
    }

    @Override // ah.g
    public long getTimeUs(long j11) {
        long j12 = j11 - this.f529a;
        if (!isSeekable() || j12 <= this.f530b) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.i(this.f534f);
        double d11 = (j12 * 256.0d) / this.f532d;
        int i11 = o0.i(jArr, (long) d11, true, true);
        long jC = c(i11);
        long j13 = jArr[i11];
        int i12 = i11 + 1;
        long jC2 = c(i12);
        long j14 = i11 == 99 ? 256L : jArr[i12];
        return jC + Math.round((j13 == j14 ? 0.0d : (d11 - j13) / (j14 - j13)) * (jC2 - jC));
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return this.f534f != null;
    }
}
