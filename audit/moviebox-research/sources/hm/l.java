package hm;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f66528e;

    public l(com.google.zxing.e eVar) {
        super(eVar);
    }

    public static int[][] i(byte[] bArr, int i11, int i12, int i13, int i14) {
        int i15 = 8;
        int i16 = i14 - 8;
        int i17 = i13 - 8;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i12, i11);
        int i18 = 0;
        while (i18 < i12) {
            int i19 = i18 << 3;
            if (i19 > i16) {
                i19 = i16;
            }
            int i21 = 0;
            while (i21 < i11) {
                int i22 = i21 << 3;
                if (i22 > i17) {
                    i22 = i17;
                }
                int i23 = (i19 * i13) + i22;
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                int i27 = 255;
                while (i24 < i15) {
                    int i28 = 0;
                    while (i28 < i15) {
                        int i29 = bArr[i23 + i28] & 255;
                        i25 += i29;
                        if (i29 < i27) {
                            i27 = i29;
                        }
                        if (i29 > i26) {
                            i26 = i29;
                        }
                        i28++;
                        i15 = 8;
                    }
                    if (i26 - i27 > 24) {
                        while (true) {
                            i24++;
                            i23 += i13;
                            if (i24 < 8) {
                                int i31 = 0;
                                for (int i32 = 8; i31 < i32; i32 = 8) {
                                    i25 += bArr[i23 + i31] & 255;
                                    i31++;
                                }
                            }
                        }
                    }
                    i24++;
                    i23 += i13;
                    i15 = 8;
                }
                int i33 = i25 >> 6;
                if (i26 - i27 <= 24) {
                    i33 = i27 / 2;
                    if (i18 > 0 && i21 > 0) {
                        int[] iArr2 = iArr[i18 - 1];
                        int i34 = i21 - 1;
                        int i35 = ((iArr2[i21] + (iArr[i18][i34] * 2)) + iArr2[i34]) / 4;
                        if (i27 < i35) {
                            i33 = i35;
                        }
                    }
                }
                iArr[i18][i21] = i33;
                i21++;
                i15 = 8;
            }
            i18++;
            i15 = 8;
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i11, int i12, int i13, int i14, int[][] iArr, b bVar) {
        int i15 = i14 - 8;
        int i16 = i13 - 8;
        for (int i17 = 0; i17 < i12; i17++) {
            int i18 = i17 << 3;
            int i19 = i18 > i15 ? i15 : i18;
            int iK = k(i17, i12 - 3);
            for (int i21 = 0; i21 < i11; i21++) {
                int i22 = i21 << 3;
                int i23 = i22 > i16 ? i16 : i22;
                int iK2 = k(i21, i11 - 3);
                int i24 = 0;
                for (int i25 = -2; i25 <= 2; i25++) {
                    int[] iArr2 = iArr[iK + i25];
                    i24 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[2 + iK2];
                }
                l(bArr, i23, i19, i24 / 25, i13, bVar);
            }
        }
    }

    public static int k(int i11, int i12) {
        if (i11 < 2) {
            return 2;
        }
        return Math.min(i11, i12);
    }

    public static void l(byte[] bArr, int i11, int i12, int i13, int i14, b bVar) {
        int i15 = (i12 * i14) + i11;
        int i16 = 0;
        while (i16 < 8) {
            for (int i17 = 0; i17 < 8; i17++) {
                if ((bArr[i15 + i17] & 255) <= i13) {
                    bVar.r(i11 + i17, i12 + i16);
                }
            }
            i16++;
            i15 += i14;
        }
    }

    @Override // com.google.zxing.a
    public com.google.zxing.a a(com.google.zxing.e eVar) {
        return new l(eVar);
    }

    @Override // hm.j, com.google.zxing.a
    public b b() throws NotFoundException {
        b bVar = this.f66528e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.e eVarE = e();
        int iD = eVarE.d();
        int iA = eVarE.a();
        if (iD < 40 || iA < 40) {
            this.f66528e = super.b();
        } else {
            byte[] bArrB = eVarE.b();
            int i11 = iD >> 3;
            if ((iD & 7) != 0) {
                i11++;
            }
            int i12 = i11;
            int i13 = iA >> 3;
            if ((iA & 7) != 0) {
                i13++;
            }
            int i14 = i13;
            int[][] iArrI = i(bArrB, i12, i14, iD, iA);
            b bVar2 = new b(iD, iA);
            j(bArrB, i12, i14, iD, iA, iArrI, bVar2);
            this.f66528e = bVar2;
        }
        return this.f66528e;
    }
}
