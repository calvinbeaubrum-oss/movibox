package ah;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f528d;

    public h(long[] jArr, long[] jArr2, long j11, long j12) {
        this.f525a = jArr;
        this.f526b = jArr2;
        this.f527c = j11;
        this.f528d = j12;
    }

    @Nullable
    public static h b(long j11, long j12, b0.a aVar, c0 c0Var) {
        int iD;
        c0Var.Q(10);
        int iN = c0Var.n();
        if (iN <= 0) {
            return null;
        }
        int i11 = aVar.f32796d;
        long jO0 = o0.O0(iN, ((long) (i11 >= 32000 ? 1152 : 576)) * 1000000, i11);
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        int iJ3 = c0Var.J();
        c0Var.Q(2);
        long j13 = j12 + ((long) aVar.f32795c);
        long[] jArr = new long[iJ];
        long[] jArr2 = new long[iJ];
        int i12 = 0;
        long j14 = j12;
        while (i12 < iJ) {
            int i13 = iJ2;
            long j15 = j13;
            jArr[i12] = (((long) i12) * jO0) / ((long) iJ);
            jArr2[i12] = Math.max(j14, j15);
            if (iJ3 == 1) {
                iD = c0Var.D();
            } else if (iJ3 == 2) {
                iD = c0Var.J();
            } else if (iJ3 == 3) {
                iD = c0Var.G();
            } else {
                if (iJ3 != 4) {
                    return null;
                }
                iD = c0Var.H();
            }
            j14 += ((long) iD) * ((long) i13);
            i12++;
            jArr = jArr;
            iJ2 = i13;
            j13 = j15;
        }
        long[] jArr3 = jArr;
        if (j11 != -1 && j11 != j14) {
            s.i("VbriSeeker", "VBRI data size mismatch: " + j11 + ", " + j14);
        }
        return new h(jArr3, jArr2, jO0, j14);
    }

    @Override // ah.g
    public long a() {
        return this.f528d;
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f527c;
    }

    @Override // tg.b0
    public tg.b0.a getSeekPoints(long j11) {
        int i11 = o0.i(this.f525a, j11, true, true);
        tg.c0 c0Var = new tg.c0(this.f525a[i11], this.f526b[i11]);
        if (c0Var.f76996a >= j11 || i11 == this.f525a.length - 1) {
            return new tg.b0.a(c0Var);
        }
        int i12 = i11 + 1;
        return new tg.b0.a(c0Var, new tg.c0(this.f525a[i12], this.f526b[i12]));
    }

    @Override // ah.g
    public long getTimeUs(long j11) {
        return this.f525a[o0.i(this.f526b, j11, true, true)];
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }
}
