package com.google.zxing.aztec.encoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f41486a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] a(hm.a aVar, int i11, int i12) {
        int[] iArr = new int[i12];
        int iM = aVar.m() / i11;
        for (int i13 = 0; i13 < iM; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 |= aVar.h((i13 * i11) + i15) ? 1 << ((i11 - i15) - 1) : 0;
            }
            iArr[i13] = i14;
        }
        return iArr;
    }

    public static void b(hm.b bVar, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13 += 2) {
            int i14 = i11 - i13;
            int i15 = i14;
            while (true) {
                int i16 = i11 + i13;
                if (i15 <= i16) {
                    bVar.r(i15, i14);
                    bVar.r(i15, i16);
                    bVar.r(i14, i15);
                    bVar.r(i16, i15);
                    i15++;
                }
            }
        }
        int i17 = i11 - i12;
        bVar.r(i17, i17);
        int i18 = i17 + 1;
        bVar.r(i18, i17);
        bVar.r(i17, i18);
        int i19 = i11 + i12;
        bVar.r(i19, i17);
        bVar.r(i19, i18);
        bVar.r(i19, i19 - 1);
    }

    public static void c(hm.b bVar, boolean z11, int i11, hm.a aVar) {
        int i12 = i11 / 2;
        int i13 = 0;
        if (z11) {
            while (i13 < 7) {
                int i14 = (i12 - 3) + i13;
                if (aVar.h(i13)) {
                    bVar.r(i14, i12 - 5);
                }
                if (aVar.h(i13 + 7)) {
                    bVar.r(i12 + 5, i14);
                }
                if (aVar.h(20 - i13)) {
                    bVar.r(i14, i12 + 5);
                }
                if (aVar.h(27 - i13)) {
                    bVar.r(i12 - 5, i14);
                }
                i13++;
            }
            return;
        }
        while (i13 < 10) {
            int i15 = (i12 - 5) + i13 + (i13 / 5);
            if (aVar.h(i13)) {
                bVar.r(i15, i12 - 7);
            }
            if (aVar.h(i13 + 10)) {
                bVar.r(i12 + 7, i15);
            }
            if (aVar.h(29 - i13)) {
                bVar.r(i15, i12 + 7);
            }
            if (aVar.h(39 - i13)) {
                bVar.r(i12 - 7, i15);
            }
            i13++;
        }
    }

    public static a d(String str, int i11, int i12, Charset charset) {
        return e(str.getBytes(charset != null ? charset : StandardCharsets.ISO_8859_1), i11, i12, charset);
    }

    public static a e(byte[] bArr, int i11, int i12, Charset charset) {
        hm.a aVarI;
        int i13;
        boolean z11;
        int iAbs;
        int iJ;
        int i14;
        hm.a aVarA = new HighLevelEncoder(bArr, charset).a();
        int iM = ((aVarA.m() * i11) / 100) + 11;
        int iM2 = aVarA.m() + iM;
        int i15 = 0;
        int i16 = 1;
        if (i12 != 0) {
            z11 = i12 < 0;
            iAbs = Math.abs(i12);
            if (iAbs > (z11 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i12)));
            }
            iJ = j(iAbs, z11);
            i13 = f41486a[iAbs];
            int i17 = iJ - (iJ % i13);
            aVarI = i(aVarA, i13);
            if (aVarI.m() + iM > i17) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z11 && aVarI.m() > i13 * 64) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        } else {
            hm.a aVarI2 = null;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (i18 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z12 = i18 <= 3;
                int i21 = z12 ? i18 + 1 : i18;
                int iJ2 = j(i21, z12);
                if (iM2 <= iJ2) {
                    if (aVarI2 == null || i19 != f41486a[i21]) {
                        int i22 = f41486a[i21];
                        i19 = i22;
                        aVarI2 = i(aVarA, i22);
                    }
                    int i23 = iJ2 - (iJ2 % i19);
                    if ((!z12 || aVarI2.m() <= i19 * 64) && aVarI2.m() + iM <= i23) {
                        aVarI = aVarI2;
                        i13 = i19;
                        z11 = z12;
                        iAbs = i21;
                        iJ = iJ2;
                        break;
                    }
                }
                i18++;
                i15 = 0;
                i16 = 1;
            }
        }
        hm.a aVarF = f(aVarI, iJ, i13);
        int iM3 = aVarI.m() / i13;
        hm.a aVarG = g(z11, iAbs, iM3);
        int i24 = (z11 ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i24];
        int i25 = 2;
        if (z11) {
            for (int i26 = 0; i26 < i24; i26++) {
                iArr[i26] = i26;
            }
            i14 = i24;
        } else {
            int i27 = i24 / 2;
            i14 = i24 + 1 + (((i27 - 1) / 15) * 2);
            int i28 = i14 / 2;
            for (int i29 = 0; i29 < i27; i29++) {
                int i31 = (i29 / 15) + i29;
                iArr[(i27 - i29) - 1] = (i28 - i31) - 1;
                iArr[i27 + i29] = i31 + i28 + i16;
            }
        }
        hm.b bVar = new hm.b(i14);
        int i32 = 0;
        int i33 = 0;
        while (i32 < iAbs) {
            int i34 = ((iAbs - i32) * 4) + (z11 ? 9 : 12);
            int i35 = 0;
            while (i35 < i34) {
                int i36 = i35 * 2;
                while (i15 < i25) {
                    if (aVarF.h(i33 + i36 + i15)) {
                        int i37 = i32 * 2;
                        bVar.r(iArr[i37 + i15], iArr[i37 + i35]);
                    }
                    if (aVarF.h((i34 * 2) + i33 + i36 + i15)) {
                        int i38 = i32 * 2;
                        bVar.r(iArr[i38 + i35], iArr[((i24 - 1) - i38) - i15]);
                    }
                    if (aVarF.h((i34 * 4) + i33 + i36 + i15)) {
                        int i39 = (i24 - 1) - (i32 * 2);
                        bVar.r(iArr[i39 - i15], iArr[i39 - i35]);
                    }
                    if (aVarF.h((i34 * 6) + i33 + i36 + i15)) {
                        int i40 = i32 * 2;
                        bVar.r(iArr[((i24 - 1) - i40) - i35], iArr[i40 + i15]);
                    }
                    i15++;
                    i25 = 2;
                }
                i35++;
                i15 = 0;
                i25 = 2;
            }
            i33 += i34 * 8;
            i32++;
            i15 = 0;
            i25 = 2;
        }
        c(bVar, z11, i14, aVarG);
        if (z11) {
            b(bVar, i14 / 2, 5);
        } else {
            int i41 = i14 / 2;
            b(bVar, i41, 7);
            int i42 = 0;
            int i43 = 0;
            while (i43 < (i24 / 2) - 1) {
                for (int i44 = i41 & 1; i44 < i14; i44 += 2) {
                    int i45 = i41 - i42;
                    bVar.r(i45, i44);
                    int i46 = i41 + i42;
                    bVar.r(i46, i44);
                    bVar.r(i44, i45);
                    bVar.r(i44, i46);
                }
                i43 += 15;
                i42 += 16;
            }
        }
        a aVar = new a();
        aVar.c(z11);
        aVar.f(i14);
        aVar.d(iAbs);
        aVar.b(iM3);
        aVar.e(bVar);
        return aVar;
    }

    public static hm.a f(hm.a aVar, int i11, int i12) {
        int iM = aVar.m() / i12;
        jm.d dVar = new jm.d(h(i12));
        int i13 = i11 / i12;
        int[] iArrA = a(aVar, i12, i13);
        dVar.b(iArrA, i13 - iM);
        hm.a aVar2 = new hm.a();
        aVar2.c(0, i11 % i12);
        for (int i14 : iArrA) {
            aVar2.c(i14, i12);
        }
        return aVar2;
    }

    public static hm.a g(boolean z11, int i11, int i12) {
        hm.a aVar = new hm.a();
        if (z11) {
            aVar.c(i11 - 1, 2);
            aVar.c(i12 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i11 - 1, 5);
        aVar.c(i12 - 1, 11);
        return f(aVar, 40, 4);
    }

    public static jm.a h(int i11) {
        if (i11 == 4) {
            return jm.a.f68086k;
        }
        if (i11 == 6) {
            return jm.a.f68085j;
        }
        if (i11 == 8) {
            return jm.a.f68089n;
        }
        if (i11 == 10) {
            return jm.a.f68084i;
        }
        if (i11 == 12) {
            return jm.a.f68083h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i11);
    }

    public static hm.a i(hm.a aVar, int i11) {
        hm.a aVar2 = new hm.a();
        int iM = aVar.m();
        int i12 = (1 << i11) - 2;
        int i13 = 0;
        while (i13 < iM) {
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = i13 + i15;
                if (i16 >= iM || aVar.h(i16)) {
                    i14 |= 1 << ((i11 - 1) - i15);
                }
            }
            int i17 = i14 & i12;
            if (i17 == i12) {
                aVar2.c(i17, i11);
            } else {
                if (i17 == 0) {
                    aVar2.c(i14 | 1, i11);
                } else {
                    aVar2.c(i14, i11);
                }
                i13 += i11;
            }
            i13--;
            i13 += i11;
        }
        return aVar2;
    }

    public static int j(int i11, boolean z11) {
        return ((z11 ? 88 : 112) + (i11 * 16)) * i11;
    }
}
