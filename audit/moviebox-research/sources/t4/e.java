package t4;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.zip.Inflater;
import z3.b0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
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
        c0Var.V(4);
        int iQ = c0Var.q();
        c0Var.U(0);
        return iQ == 1886547818;
    }

    @Nullable
    public static d.a d(c0 c0Var) {
        int iQ = c0Var.q();
        if (iQ > 10000) {
            return null;
        }
        float[] fArr = new float[iQ];
        for (int i11 = 0; i11 < iQ; i11++) {
            fArr[i11] = c0Var.p();
        }
        int iQ2 = c0Var.q();
        if (iQ2 > 32000) {
            return null;
        }
        double d11 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iQ) * 2.0d) / dLog);
        b0 b0Var = new b0(c0Var.e());
        int i12 = 8;
        b0Var.p(c0Var.f() * 8);
        float[] fArr2 = new float[iQ2 * 5];
        int i13 = 5;
        int[] iArr = new int[5];
        int i14 = 0;
        int i15 = 0;
        while (i14 < iQ2) {
            int i16 = 0;
            while (i16 < i13) {
                int iB = iArr[i16] + b(b0Var.h(iCeil));
                if (iB >= iQ || iB < 0) {
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
            int iCeil2 = (int) Math.ceil(Math.log(((double) iQ2) * d11) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int iB2 = 0;
            for (int i19 = 0; i19 < iH4; i19++) {
                iB2 += b(b0Var.h(iCeil2));
                if (iB2 < 0 || iB2 >= iQ2) {
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
        if (c0Var.H() != 0) {
            return null;
        }
        c0Var.V(7);
        int iQ = c0Var.q();
        if (iQ == 1684433976) {
            c0 c0Var2 = new c0();
            Inflater inflater = new Inflater(true);
            try {
                if (!u0.D0(c0Var, c0Var2, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                c0Var = c0Var2;
            } catch (Throwable th2) {
                inflater.end();
                throw th2;
            }
        } else if (iQ != 1918990112) {
            return null;
        }
        return g(c0Var);
    }

    @Nullable
    public static ArrayList<d.a> f(c0 c0Var) {
        int iQ;
        c0Var.V(8);
        int iF = c0Var.f();
        int iG = c0Var.g();
        while (iF < iG && (iQ = c0Var.q() + iF) > iF && iQ <= iG) {
            int iQ2 = c0Var.q();
            if (iQ2 == 2037673328 || iQ2 == 1836279920) {
                c0Var.T(iQ);
                return e(c0Var);
            }
            c0Var.U(iQ);
            iF = iQ;
        }
        return null;
    }

    @Nullable
    public static ArrayList<d.a> g(c0 c0Var) {
        ArrayList<d.a> arrayList = new ArrayList<>();
        int iF = c0Var.f();
        int iG = c0Var.g();
        while (iF < iG) {
            int iQ = c0Var.q() + iF;
            if (iQ <= iF || iQ > iG) {
                return null;
            }
            if (c0Var.q() == 1835365224) {
                d.a aVarD = d(c0Var);
                if (aVarD == null) {
                    return null;
                }
                arrayList.add(aVarD);
            }
            c0Var.U(iQ);
            iF = iQ;
        }
        return arrayList;
    }
}
