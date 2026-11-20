package k5;

import androidx.annotation.Nullable;
import org.apache.tools.zip.UnixStat;
import u4.j0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0.a f68278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f68279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final long[] f68283f;

    public i(j0.a aVar, long j11, long j12, @Nullable long[] jArr, int i11, int i12) {
        this.f68278a = aVar;
        this.f68279b = j11;
        this.f68280c = j12;
        this.f68283f = jArr;
        this.f68281d = i11;
        this.f68282e = i12;
    }

    public static i a(j0.a aVar, c0 c0Var) {
        long[] jArr;
        int i11;
        int i12;
        int i13 = aVar.f78321g;
        int iQ = c0Var.q();
        int iL = (iQ & 1) != 0 ? c0Var.L() : -1;
        long J = (iQ & 2) != 0 ? c0Var.J() : -1L;
        if ((iQ & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i14 = 0; i14 < 100; i14++) {
                jArr2[i14] = c0Var.H();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iQ & 8) != 0) {
            c0Var.V(4);
        }
        if (c0Var.a() >= 24) {
            c0Var.V(21);
            int iK = c0Var.K();
            i12 = iK & UnixStat.PERM_MASK;
            i11 = (16773120 & iK) >> 12;
        } else {
            i11 = -1;
            i12 = -1;
        }
        return new i(aVar, iL, J, jArr, i11, i12);
    }
}
