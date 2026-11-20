package s4;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.m0;
import androidx.media3.common.n0;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.x2;
import androidx.media3.exoplayer.y2;
import androidx.media3.exoplayer.z2;
import java.util.Arrays;
import p4.k0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public a f75986c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f75987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f75988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f75989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final k0[] f75990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f75991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[][][] f75992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k0 f75993g;

        public a(String[] strArr, int[] iArr, k0[] k0VarArr, int[] iArr2, int[][][] iArr3, k0 k0Var) {
            this.f75988b = strArr;
            this.f75989c = iArr;
            this.f75990d = k0VarArr;
            this.f75992f = iArr3;
            this.f75991e = iArr2;
            this.f75993g = k0Var;
            this.f75987a = iArr.length;
        }

        public int a(int i11, int i12, boolean z11) {
            int i13 = this.f75990d[i11].b(i12).f9330a;
            int[] iArr = new int[i13];
            int i14 = 0;
            for (int i15 = 0; i15 < i13; i15++) {
                int iG = g(i11, i12, i15);
                if (iG == 4 || (z11 && iG == 3)) {
                    iArr[i14] = i15;
                    i14++;
                }
            }
            return b(i11, i12, Arrays.copyOf(iArr, i14));
        }

        public int b(int i11, int i12, int[] iArr) {
            int i13 = 0;
            String str = null;
            boolean z11 = false;
            int i14 = 0;
            int iMin = 16;
            while (i13 < iArr.length) {
                String str2 = this.f75990d[i11].b(i12).a(iArr[i13]).f9501m;
                int i15 = i14 + 1;
                if (i14 == 0) {
                    str = str2;
                } else {
                    z11 |= !u0.c(str, str2);
                }
                iMin = Math.min(iMin, x2.f(this.f75992f[i11][i12][i13]));
                i13++;
                i14 = i15;
            }
            return z11 ? Math.min(iMin, this.f75991e[i11]) : iMin;
        }

        public int c(int i11, int i12, int i13) {
            return this.f75992f[i11][i12][i13];
        }

        public int d() {
            return this.f75987a;
        }

        public int e(int i11) {
            return this.f75989c[i11];
        }

        public k0 f(int i11) {
            return this.f75990d[i11];
        }

        public int g(int i11, int i12, int i13) {
            return x2.i(c(i11, i12, i13));
        }

        public k0 h() {
            return this.f75993g;
        }
    }

    public static int n(y2[] y2VarArr, n0 n0Var, int[] iArr, boolean z11) throws ExoPlaybackException {
        int length = y2VarArr.length;
        int i11 = 0;
        boolean z12 = true;
        for (int i12 = 0; i12 < y2VarArr.length; i12++) {
            y2 y2Var = y2VarArr[i12];
            int iMax = 0;
            for (int i13 = 0; i13 < n0Var.f9330a; i13++) {
                iMax = Math.max(iMax, x2.i(y2Var.a(n0Var.a(i13))));
            }
            boolean z13 = iArr[i12] == 0;
            if (iMax > i11 || (iMax == i11 && z11 && !z12 && z13)) {
                length = i12;
                z12 = z13;
                i11 = iMax;
            }
        }
        return length;
    }

    public static int[] o(y2 y2Var, n0 n0Var) throws ExoPlaybackException {
        int[] iArr = new int[n0Var.f9330a];
        for (int i11 = 0; i11 < n0Var.f9330a; i11++) {
            iArr[i11] = y2Var.a(n0Var.a(i11));
        }
        return iArr;
    }

    public static int[] p(y2[] y2VarArr) throws ExoPlaybackException {
        int length = y2VarArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = y2VarArr[i11].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // s4.e0
    public final void i(@Nullable Object obj) {
        this.f75986c = (a) obj;
    }

    @Override // s4.e0
    public final f0 k(y2[] y2VarArr, k0 k0Var, androidx.media3.exoplayer.source.l.b bVar, m0 m0Var) throws ExoPlaybackException {
        int[] iArr = new int[y2VarArr.length + 1];
        int length = y2VarArr.length + 1;
        n0[][] n0VarArr = new n0[length][];
        int[][][] iArr2 = new int[y2VarArr.length + 1][][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = k0Var.f73574a;
            n0VarArr[i11] = new n0[i12];
            iArr2[i11] = new int[i12][];
        }
        int[] iArrP = p(y2VarArr);
        for (int i13 = 0; i13 < k0Var.f73574a; i13++) {
            n0 n0VarB = k0Var.b(i13);
            int iN = n(y2VarArr, n0VarB, iArr, n0VarB.f9332c == 5);
            int[] iArrO = iN == y2VarArr.length ? new int[n0VarB.f9330a] : o(y2VarArr[iN], n0VarB);
            int i14 = iArr[iN];
            n0VarArr[iN][i14] = n0VarB;
            iArr2[iN][i14] = iArrO;
            iArr[iN] = i14 + 1;
        }
        k0[] k0VarArr = new k0[y2VarArr.length];
        String[] strArr = new String[y2VarArr.length];
        int[] iArr3 = new int[y2VarArr.length];
        for (int i15 = 0; i15 < y2VarArr.length; i15++) {
            int i16 = iArr[i15];
            k0VarArr[i15] = new k0((n0[]) u0.X0(n0VarArr[i15], i16));
            iArr2[i15] = (int[][]) u0.X0(iArr2[i15], i16);
            strArr[i15] = y2VarArr[i15].getName();
            iArr3[i15] = y2VarArr[i15].getTrackType();
        }
        a aVar = new a(strArr, iArr3, k0VarArr, iArrP, iArr2, new k0((n0[]) u0.X0(n0VarArr[y2VarArr.length], iArr[y2VarArr.length])));
        Pair<z2[], z[]> pairQ = q(aVar, iArr2, iArrP, bVar, m0Var);
        return new f0((z2[]) pairQ.first, (z[]) pairQ.second, d0.b(aVar, (c0[]) pairQ.second), aVar);
    }

    public abstract Pair<z2[], z[]> q(a aVar, int[][][] iArr, int[] iArr2, androidx.media3.exoplayer.source.l.b bVar, m0 m0Var) throws ExoPlaybackException;
}
