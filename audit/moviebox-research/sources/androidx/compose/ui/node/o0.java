package androidx.compose.ui.node;

import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class o0 {
    public static final void b(t tVar, k kVar) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < tVar.c()) {
            int i14 = i11 + 2;
            int iB = tVar.b(i11) - tVar.b(i14);
            int iB2 = tVar.b(i11 + 1) - tVar.b(i14);
            int iB3 = tVar.b(i14);
            i11 += 3;
            while (i12 < iB) {
                kVar.b(i13, i12);
                i12++;
            }
            while (i13 < iB2) {
                kVar.c(i13);
                i13++;
            }
            while (true) {
                int i15 = iB3 - 1;
                if (iB3 > 0) {
                    kVar.d(i12, i13);
                    i12++;
                    i13++;
                    iB3 = i15;
                }
            }
        }
    }

    public static final boolean c(int i11, int i12, int i13, int i14, k kVar, int[] iArr, int[] iArr2, int i15, int[] iArr3) {
        int iB;
        int i16;
        int i17;
        int i18 = (i12 - i11) - (i14 - i13);
        boolean z11 = i18 % 2 == 0;
        int i19 = -i15;
        for (int i21 = i19; i21 <= i15; i21 += 2) {
            if (i21 == i19 || (i21 != i15 && c.b(iArr2, i21 + 1) < c.b(iArr2, i21 - 1))) {
                iB = c.b(iArr2, i21 + 1);
                i16 = iB;
            } else {
                iB = c.b(iArr2, i21 - 1);
                i16 = iB - 1;
            }
            int i22 = i14 - ((i12 - i16) - i21);
            int i23 = (i15 == 0 || i16 != iB) ? i22 : i22 + 1;
            while (true) {
                if (i16 <= i11 || i22 <= i13) {
                    break;
                }
                if (!kVar.a(i16 - 1, i22 - 1)) {
                    break;
                }
                i16--;
                i22--;
            }
            c.d(iArr2, i21, i16);
            if (z11 && (i17 = i18 - i21) >= i19 && i17 <= i15) {
                if (c.b(iArr, i17) >= i16) {
                    f(i16, i22, iB, i23, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    public static final t d(int i11, int i12, k kVar) {
        int i13 = ((i11 + i12) + 1) / 2;
        t tVar = new t(i13 * 3);
        t tVar2 = new t(i13 * 4);
        tVar2.h(0, i11, 0, i12);
        int i14 = (i13 * 2) + 1;
        int[] iArrA = c.a(new int[i14]);
        int[] iArrA2 = c.a(new int[i14]);
        int[] iArrB = k1.b(new int[5]);
        while (tVar2.d()) {
            int iF = tVar2.f();
            int iF2 = tVar2.f();
            int iF3 = tVar2.f();
            int iF4 = tVar2.f();
            int[] iArr = iArrA;
            int[] iArr2 = iArrA2;
            if (h(iF4, iF3, iF2, iF, kVar, iArrA, iArrA2, iArrB)) {
                if (k1.c(iArrB) > 0) {
                    k1.a(iArrB, tVar);
                }
                tVar2.h(iF4, k1.h(iArrB), iF2, k1.i(iArrB));
                tVar2.h(k1.d(iArrB), iF3, k1.e(iArrB), iF);
            }
            iArrA = iArr;
            iArrA2 = iArr2;
        }
        tVar.j();
        tVar.g(i11, i12, 0);
        return tVar;
    }

    public static final void e(int i11, int i12, k kVar) {
        b(d(i11, i12, kVar), kVar);
    }

    public static final void f(int i11, int i12, int i13, int i14, boolean z11, int[] iArr) {
        iArr[0] = i11;
        iArr[1] = i12;
        iArr[2] = i13;
        iArr[3] = i14;
        iArr[4] = z11 ? 1 : 0;
    }

    public static final boolean g(int i11, int i12, int i13, int i14, k kVar, int[] iArr, int[] iArr2, int i15, int[] iArr3) {
        int iB;
        int i16;
        int i17;
        int i18 = (i12 - i11) - (i14 - i13);
        boolean z11 = Math.abs(i18) % 2 == 1;
        int i19 = -i15;
        for (int i21 = i19; i21 <= i15; i21 += 2) {
            if (i21 == i19 || (i21 != i15 && c.b(iArr, i21 + 1) > c.b(iArr, i21 - 1))) {
                iB = c.b(iArr, i21 + 1);
                i16 = iB;
            } else {
                iB = c.b(iArr, i21 - 1);
                i16 = iB + 1;
            }
            int i22 = (i13 + (i16 - i11)) - i21;
            int i23 = (i15 == 0 || i16 != iB) ? i22 : i22 - 1;
            while (true) {
                if (i16 >= i12 || i22 >= i14) {
                    break;
                }
                if (!kVar.a(i16, i22)) {
                    break;
                }
                i16++;
                i22++;
            }
            c.d(iArr, i21, i16);
            if (z11 && (i17 = i18 - i21) >= i19 + 1 && i17 <= i15 - 1) {
                if (c.b(iArr2, i17) <= i16) {
                    f(iB, i23, i16, i22, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean h(int i11, int i12, int i13, int i14, k kVar, int[] iArr, int[] iArr2, int[] iArr3) {
        int i15 = i12 - i11;
        int i16 = i14 - i13;
        if (i15 >= 1 && i16 >= 1) {
            int i17 = ((i15 + i16) + 1) / 2;
            c.d(iArr, 1, i11);
            c.d(iArr2, 1, i12);
            int i18 = 0;
            while (i18 < i17) {
                int i19 = i18;
                if (g(i11, i12, i13, i14, kVar, iArr, iArr2, i18, iArr3) || c(i11, i12, i13, i14, kVar, iArr, iArr2, i19, iArr3)) {
                    return true;
                }
                i18 = i19 + 1;
            }
        }
        return false;
    }

    public static final void i(int[] iArr, int i11, int i12) {
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
    }
}
