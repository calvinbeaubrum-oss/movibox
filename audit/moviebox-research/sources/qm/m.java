package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f74829b = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f74830c = {1, 1, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f74831d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[][] f74832e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f74833a = -1;

    public static int h(int[] iArr) throws NotFoundException {
        int length = f74832e.length;
        float f11 = 0.38f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float fE = q.e(iArr, f74832e[i12], 0.5f);
            if (fE < f11) {
                i11 = i12;
                f11 = fE;
            } else if (fE == f11) {
                i11 = -1;
            }
        }
        if (i11 >= 0) {
            return i11 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static void j(hm.a aVar, int i11, int i12, StringBuilder sb2) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i11 < i12) {
            q.f(aVar, i11, iArr);
            for (int i13 = 0; i13 < 5; i13++) {
                int i14 = i13 * 2;
                iArr2[i13] = iArr[i14];
                iArr3[i13] = iArr[i14 + 1];
            }
            sb2.append((char) (h(iArr2) + 48));
            sb2.append((char) (h(iArr3) + 48));
            for (int i15 = 0; i15 < 10; i15++) {
                i11 += iArr[i15];
            }
        }
    }

    public static int[] l(hm.a aVar, int i11, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iM = aVar.m();
        int i12 = i11;
        boolean z11 = false;
        int i13 = 0;
        while (i11 < iM) {
            if (aVar.h(i11) != z11) {
                iArr2[i13] = iArr2[i13] + 1;
            } else {
                if (i13 != length - 1) {
                    i13++;
                } else {
                    if (q.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i12, i11};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = i13 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i13--;
                }
                iArr2[i13] = 1;
                z11 = !z11;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int m(hm.a aVar) throws NotFoundException {
        int iM = aVar.m();
        int iK = aVar.k(0);
        if (iK != iM) {
            return iK;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        boolean z11;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb2 = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb2);
        String string = sb2.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f74829b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= length2) {
                z11 = false;
                break;
            }
            int i14 = iArr[i12];
            if (length == i14) {
                z11 = true;
                break;
            }
            if (i14 > i13) {
                i13 = i14;
            }
            i12++;
        }
        if ((z11 || length <= i13) && !z11) {
            throw FormatException.getFormatInstance();
        }
        float f11 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k(iArrK[1], f11), new com.google.zxing.k(iArrI[0], f11)}, BarcodeFormat.ITF);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]I0");
        return jVar;
    }

    public final int[] i(hm.a aVar) throws NotFoundException {
        int[] iArrL;
        aVar.q();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, f74831d[0]);
            } catch (NotFoundException unused) {
                iArrL = l(aVar, iM, f74831d[1]);
            }
            n(aVar, iArrL[0]);
            int i11 = iArrL[0];
            iArrL[0] = aVar.m() - iArrL[1];
            iArrL[1] = aVar.m() - i11;
            aVar.q();
            return iArrL;
        } catch (Throwable th2) {
            aVar.q();
            throw th2;
        }
    }

    public final int[] k(hm.a aVar) throws NotFoundException {
        int[] iArrL = l(aVar, m(aVar), f74830c);
        int i11 = iArrL[1];
        int i12 = iArrL[0];
        this.f74833a = (i11 - i12) / 4;
        n(aVar, i12);
        return iArrL;
    }

    public final void n(hm.a aVar, int i11) throws NotFoundException {
        int iMin = Math.min(this.f74833a * 10, i11);
        for (int i12 = i11 - 1; iMin > 0 && i12 >= 0 && !aVar.h(i12); i12--) {
            iMin--;
        }
        if (iMin != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
