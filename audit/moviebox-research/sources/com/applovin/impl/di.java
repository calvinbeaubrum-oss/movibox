package com.applovin.impl;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class di {
    private static int a(int i11) {
        return (-(i11 & 1)) ^ (i11 >> 1);
    }

    public static ci a(byte[] bArr, int i11) {
        ArrayList arrayListD;
        bh bhVar = new bh(bArr);
        try {
            arrayListD = a(bhVar) ? d(bhVar) : c(bhVar);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListD = null;
        }
        if (arrayListD == null) {
            return null;
        }
        int size = arrayListD.size();
        if (size == 1) {
            return new ci((ci.a) arrayListD.get(0), i11);
        }
        if (size != 2) {
            return null;
        }
        return new ci((ci.a) arrayListD.get(0), (ci.a) arrayListD.get(1), i11);
    }

    private static boolean a(bh bhVar) {
        bhVar.g(4);
        int iJ = bhVar.j();
        bhVar.f(0);
        return iJ == 1886547818;
    }

    private static ci.a b(bh bhVar) {
        int iJ = bhVar.j();
        if (iJ > 10000) {
            return null;
        }
        float[] fArr = new float[iJ];
        for (int i11 = 0; i11 < iJ; i11++) {
            fArr[i11] = bhVar.i();
        }
        int iJ2 = bhVar.j();
        if (iJ2 > 32000) {
            return null;
        }
        double d11 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iJ) * 2.0d) / dLog);
        ah ahVar = new ah(bhVar.c());
        int i12 = 8;
        ahVar.c(bhVar.d() * 8);
        float[] fArr2 = new float[iJ2 * 5];
        int i13 = 5;
        int[] iArr = new int[5];
        int i14 = 0;
        int i15 = 0;
        while (i14 < iJ2) {
            int i16 = 0;
            while (i16 < i13) {
                int iA = iArr[i16] + a(ahVar.a(iCeil));
                if (iA >= iJ || iA < 0) {
                    return null;
                }
                fArr2[i15] = fArr[iA];
                iArr[i16] = iA;
                i16++;
                i15++;
                i13 = 5;
            }
            i14++;
            i13 = 5;
        }
        ahVar.c((ahVar.e() + 7) & (-8));
        int i17 = 32;
        int iA2 = ahVar.a(32);
        ci.b[] bVarArr = new ci.b[iA2];
        int i18 = 0;
        while (i18 < iA2) {
            int iA3 = ahVar.a(i12);
            int iA4 = ahVar.a(i12);
            int iA5 = ahVar.a(i17);
            if (iA5 > 128000) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(((double) iJ2) * d11) / dLog);
            float[] fArr3 = new float[iA5 * 3];
            float[] fArr4 = new float[iA5 * 2];
            int iA6 = 0;
            for (int i19 = 0; i19 < iA5; i19++) {
                iA6 += a(ahVar.a(iCeil2));
                if (iA6 < 0 || iA6 >= iJ2) {
                    return null;
                }
                int i21 = i19 * 3;
                int i22 = iA6 * 5;
                fArr3[i21] = fArr2[i22];
                fArr3[i21 + 1] = fArr2[i22 + 1];
                fArr3[i21 + 2] = fArr2[i22 + 2];
                int i23 = i19 * 2;
                fArr4[i23] = fArr2[i22 + 3];
                fArr4[i23 + 1] = fArr2[i22 + 4];
            }
            bVarArr[i18] = new ci.b(iA3, fArr3, fArr4, iA4);
            i18++;
            i17 = 32;
            d11 = 2.0d;
            i12 = 8;
        }
        return new ci.a(bVarArr);
    }

    private static ArrayList c(bh bhVar) {
        if (bhVar.w() != 0) {
            return null;
        }
        bhVar.g(7);
        int iJ = bhVar.j();
        if (iJ == 1684433976) {
            bh bhVar2 = new bh();
            Inflater inflater = new Inflater(true);
            try {
                if (!xp.a(bhVar, bhVar2, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                bhVar = bhVar2;
            } catch (Throwable th2) {
                inflater.end();
                throw th2;
            }
        } else if (iJ != 1918990112) {
            return null;
        }
        return e(bhVar);
    }

    private static ArrayList d(bh bhVar) {
        int iJ;
        bhVar.g(8);
        int iD = bhVar.d();
        int iE = bhVar.e();
        while (iD < iE && (iJ = bhVar.j() + iD) > iD && iJ <= iE) {
            int iJ2 = bhVar.j();
            if (iJ2 == 2037673328 || iJ2 == 1836279920) {
                bhVar.e(iJ);
                return c(bhVar);
            }
            bhVar.f(iJ);
            iD = iJ;
        }
        return null;
    }

    private static ArrayList e(bh bhVar) {
        ArrayList arrayList = new ArrayList();
        int iD = bhVar.d();
        int iE = bhVar.e();
        while (iD < iE) {
            int iJ = bhVar.j() + iD;
            if (iJ <= iD || iJ > iE) {
                return null;
            }
            if (bhVar.j() == 1835365224) {
                ci.a aVarB = b(bhVar);
                if (aVarB == null) {
                    return null;
                }
                arrayList.add(aVarB);
            }
            bhVar.f(iJ);
            iD = iJ;
        }
        return arrayList;
    }
}
