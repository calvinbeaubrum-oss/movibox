package fi;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.x2;
import com.google.android.exoplayer2.y2;
import com.google.android.exoplayer2.z2;
import java.util.Arrays;
import nh.i0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u extends b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public a f65046c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f65048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f65049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final k0[] f65050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f65051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[][][] f65052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k0 f65053g;

        public a(String[] strArr, int[] iArr, k0[] k0VarArr, int[] iArr2, int[][][] iArr3, k0 k0Var) {
            this.f65048b = strArr;
            this.f65049c = iArr;
            this.f65050d = k0VarArr;
            this.f65052f = iArr3;
            this.f65051e = iArr2;
            this.f65053g = k0Var;
            this.f65047a = iArr.length;
        }

        public int a(int i11, int i12, boolean z11) {
            int i13 = this.f65050d[i11].b(i12).f71931a;
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
                String str2 = this.f65050d[i11].b(i12).c(iArr[i13]).f33445m;
                int i15 = i14 + 1;
                if (i14 == 0) {
                    str = str2;
                } else {
                    z11 |= !o0.c(str, str2);
                }
                iMin = Math.min(iMin, x2.d(this.f65052f[i11][i12][i13]));
                i13++;
                i14 = i15;
            }
            return z11 ? Math.min(iMin, this.f65051e[i11]) : iMin;
        }

        public int c(int i11, int i12, int i13) {
            return this.f65052f[i11][i12][i13];
        }

        public int d() {
            return this.f65047a;
        }

        public int e(int i11) {
            return this.f65049c[i11];
        }

        public k0 f(int i11) {
            return this.f65050d[i11];
        }

        public int g(int i11, int i12, int i13) {
            return x2.f(c(i11, i12, i13));
        }

        public k0 h() {
            return this.f65053g;
        }
    }

    public static int k(y2[] y2VarArr, i0 i0Var, int[] iArr, boolean z11) throws ExoPlaybackException {
        int length = y2VarArr.length;
        int i11 = 0;
        boolean z12 = true;
        for (int i12 = 0; i12 < y2VarArr.length; i12++) {
            y2 y2Var = y2VarArr[i12];
            int iMax = 0;
            for (int i13 = 0; i13 < i0Var.f71931a; i13++) {
                iMax = Math.max(iMax, x2.f(y2Var.a(i0Var.c(i13))));
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

    public static int[] l(y2 y2Var, i0 i0Var) throws ExoPlaybackException {
        int[] iArr = new int[i0Var.f71931a];
        for (int i11 = 0; i11 < i0Var.f71931a; i11++) {
            iArr[i11] = y2Var.a(i0Var.c(i11));
        }
        return iArr;
    }

    public static int[] m(y2[] y2VarArr) throws ExoPlaybackException {
        int length = y2VarArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = y2VarArr[i11].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // fi.b0
    public final void f(@Nullable Object obj) {
        this.f65046c = (a) obj;
    }

    @Override // fi.b0
    public final c0 h(y2[] y2VarArr, k0 k0Var, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var) throws ExoPlaybackException {
        int[] iArr = new int[y2VarArr.length + 1];
        int length = y2VarArr.length + 1;
        i0[][] i0VarArr = new i0[length][];
        int[][][] iArr2 = new int[y2VarArr.length + 1][][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = k0Var.f71941a;
            i0VarArr[i11] = new i0[i12];
            iArr2[i11] = new int[i12][];
        }
        int[] iArrM = m(y2VarArr);
        for (int i13 = 0; i13 < k0Var.f71941a; i13++) {
            i0 i0VarB = k0Var.b(i13);
            int iK = k(y2VarArr, i0VarB, iArr, i0VarB.f71933c == 5);
            int[] iArrL = iK == y2VarArr.length ? new int[i0VarB.f71931a] : l(y2VarArr[iK], i0VarB);
            int i14 = iArr[iK];
            i0VarArr[iK][i14] = i0VarB;
            iArr2[iK][i14] = iArrL;
            iArr[iK] = i14 + 1;
        }
        k0[] k0VarArr = new k0[y2VarArr.length];
        String[] strArr = new String[y2VarArr.length];
        int[] iArr3 = new int[y2VarArr.length];
        for (int i15 = 0; i15 < y2VarArr.length; i15++) {
            int i16 = iArr[i15];
            k0VarArr[i15] = new k0((i0[]) o0.H0(i0VarArr[i15], i16));
            iArr2[i15] = (int[][]) o0.H0(iArr2[i15], i16);
            strArr[i15] = y2VarArr[i15].getName();
            iArr3[i15] = y2VarArr[i15].getTrackType();
        }
        a aVar = new a(strArr, iArr3, k0VarArr, iArrM, iArr2, new k0((i0[]) o0.H0(i0VarArr[y2VarArr.length], iArr[y2VarArr.length])));
        Pair<z2[], s[]> pairN = n(aVar, iArr2, iArrM, bVar, j3Var);
        return new c0((z2[]) pairN.first, (s[]) pairN.second, a0.a(aVar, (v[]) pairN.second), aVar);
    }

    public abstract Pair<z2[], s[]> n(a aVar, int[][][] iArr, int[] iArr2, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var) throws ExoPlaybackException;
}
