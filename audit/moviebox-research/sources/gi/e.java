package gi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    @Nullable
    public static d a(byte[] bArr, int i11) {
        ArrayList<d.a> arrayListF;
        c0 c0Var = new c0(bArr);
        try {
            arrayListF = c(c0Var) ? f(c0Var) : e(c0Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new d(arrayListF.get(0), i11);
        }
        if (size != 2) {
            return null;
        }
        return new d(arrayListF.get(0), arrayListF.get(1), i11);
    }

    public static int b(int i11) {
        return (-(i11 & 1)) ^ (i11 >> 1);
    }

    public static boolean c(c0 c0Var) {
        c0Var.Q(4);
        int iN = c0Var.n();
        c0Var.P(0);
        return iN == 1886547818;
    }

    @Nullable
    public static d.a d(c0 c0Var) {
        int iN = c0Var.n();
        if (iN > 10000) {
            return null;
        }
        float[] fArr = new float[iN];
        for (int i11 = 0; i11 < iN; i11++) {
            fArr[i11] = c0Var.m();
        }
        int iN2 = c0Var.n();
        if (iN2 > 32000) {
            return null;
        }
        double d11 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iN) * 2.0d) / dLog);
        b0 b0Var = new b0(c0Var.d());
        int i12 = 8;
        b0Var.p(c0Var.e() * 8);
        float[] fArr2 = new float[iN2 * 5];
        int i13 = 5;
        int[] iArr = new int[5];
        int i14 = 0;
        int i15 = 0;
        while (i14 < iN2) {
            int i16 = 0;
            while (i16 < i13) {
                int iB = iArr[i16] + b(b0Var.h(iCeil));
                if (iB >= iN || iB < 0) {
                    return null;
                }
                fArr2[i15] = fArr[iB];
                iArr[i16] = iB;
                i16++;
                i15++;
                i13 = 5;
            }
            i14++;
            i13 = 5;
        }
        b0Var.p((b0Var.e() + 7) & (-8));
        int i17 = 32;
        int iH = b0Var.h(32);
        d.b[] bVarArr = new d.b[iH];
        int i18 = 0;
        while (i18 < iH) {
            int iH2 = b0Var.h(i12);
            int iH3 = b0Var.h(i12);
            int iH4 = b0Var.h(i17);
            if (iH4 > 128000) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(((double) iN2) * d11) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int iB2 = 0;
            for (int i19 = 0; i19 < iH4; i19++) {
                iB2 += b(b0Var.h(iCeil2));
                if (iB2 < 0 || iB2 >= iN2) {
                    return null;
                }
                int i21 = i19 * 3;
                int i22 = iB2 * 5;
                fArr3[i21] = fArr2[i22];
                fArr3[i21 + 1] = fArr2[i22 + 1];
                fArr3[i21 + 2] = fArr2[i22 + 2];
                int i23 = i19 * 2;
                fArr4[i23] = fArr2[i22 + 3];
                fArr4[i23 + 1] = fArr2[i22 + 4];
            }
            bVarArr[i18] = new d.b(iH2, fArr3, fArr4, iH3);
            i18++;
            i17 = 32;
            d11 = 2.0d;
            i12 = 8;
        }
        return new d.a(bVarArr);
    }

    @Nullable
    public static ArrayList<d.a> e(c0 c0Var) {
        if (c0Var.D() != 0) {
            return null;
        }
        c0Var.Q(7);
        int iN = c0Var.n();
        if (iN == 1684433976) {
            c0 c0Var2 = new c0();
            Inflater inflater = new Inflater(true);
            try {
                if (!o0.r0(c0Var, c0Var2, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                c0Var = c0Var2;
            } catch (Throwable th2) {
                inflater.end();
                throw th2;
            }
        } else if (iN != 1918990112) {
            return null;
        }
        return g(c0Var);
    }

    @Nullable
    public static ArrayList<d.a> f(c0 c0Var) {
        int iN;
        c0Var.Q(8);
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF && (iN = c0Var.n() + iE) > iE && iN <= iF) {
            int iN2 = c0Var.n();
            if (iN2 == 2037673328 || iN2 == 1836279920) {
                c0Var.O(iN);
                return e(c0Var);
            }
            c0Var.P(iN);
            iE = iN;
        }
        return null;
    }

    @Nullable
    public static ArrayList<d.a> g(c0 c0Var) {
        ArrayList<d.a> arrayList = new ArrayList<>();
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF) {
            int iN = c0Var.n() + iE;
            if (iN <= iE || iN > iF) {
                return null;
            }
            if (c0Var.n() == 1835365224) {
                d.a aVarD = d(c0Var);
                if (aVarD == null) {
                    return null;
                }
                arrayList.add(aVarD);
            }
            c0Var.P(iN);
            iE = iN;
        }
        return arrayList;
    }
}
