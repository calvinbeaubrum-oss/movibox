package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class x extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f74852d = {1, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f74853e = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f74854f = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[][] f74855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[][] f74856h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f74857a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f74858b = new w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f74859c = new l();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f74855g = iArr;
        int[][] iArr2 = new int[20][];
        f74856h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i11 = 10; i11 < 20; i11++) {
            int[] iArr3 = f74855g[i11 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i12 = 0; i12 < iArr3.length; i12++) {
                iArr4[i12] = iArr3[(iArr3.length - i12) - 1];
            }
            f74856h[i11] = iArr4;
        }
    }

    public static boolean i(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i11 = length - 1;
        return r(charSequence.subSequence(0, i11)) == Character.digit(charSequence.charAt(i11), 10);
    }

    public static int j(hm.a aVar, int[] iArr, int i11, int[][] iArr2) throws NotFoundException {
        q.f(aVar, i11, iArr);
        int length = iArr2.length;
        float f11 = 0.48f;
        int i12 = -1;
        for (int i13 = 0; i13 < length; i13++) {
            float fE = q.e(iArr, iArr2[i13], 0.7f);
            if (fE < f11) {
                i12 = i13;
                f11 = fE;
            }
        }
        if (i12 >= 0) {
            return i12;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] n(hm.a aVar, int i11, boolean z11, int[] iArr) throws NotFoundException {
        return o(aVar, i11, z11, iArr, new int[iArr.length]);
    }

    public static int[] o(hm.a aVar, int i11, boolean z11, int[] iArr, int[] iArr2) throws NotFoundException {
        int iM = aVar.m();
        int iL = z11 ? aVar.l(i11) : aVar.k(i11);
        int length = iArr.length;
        boolean z12 = z11;
        int i12 = 0;
        int i13 = iL;
        while (iL < iM) {
            if (aVar.h(iL) != z12) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (q.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i13, iL};
                    }
                    i13 += iArr2[0] + iArr2[1];
                    int i14 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z12 = !z12;
            }
            iL++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] p(hm.a aVar) throws NotFoundException {
        int[] iArr = new int[f74852d.length];
        int[] iArrO = null;
        boolean zO = false;
        int i11 = 0;
        while (!zO) {
            int[] iArr2 = f74852d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i11, false, iArr2, iArr);
            int i12 = iArrO[0];
            int i13 = iArrO[1];
            int i14 = i12 - (i13 - i12);
            if (i14 >= 0) {
                zO = aVar.o(i14, i12, false);
            }
            i11 = i13;
        }
        return iArrO;
    }

    public static int r(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i11 = 0;
        for (int i12 = length - 1; i12 >= 0; i12 -= 2) {
            int iCharAt = charSequence.charAt(i12) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i11 += iCharAt;
        }
        int i13 = i11 * 3;
        for (int i14 = length - 2; i14 >= 0; i14 -= 2) {
            int iCharAt2 = charSequence.charAt(i14) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i13 += iCharAt2;
        }
        return (1000 - i13) % 10;
    }

    @Override // qm.q
    public com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(i11, aVar, p(aVar), map);
    }

    public boolean h(String str) throws FormatException {
        return i(str);
    }

    public int[] k(hm.a aVar, int i11) throws NotFoundException {
        return n(aVar, i11, false, f74852d);
    }

    public abstract int l(hm.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException;

    public com.google.zxing.j m(int i11, hm.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strC;
        com.google.zxing.l lVar = map == null ? null : (com.google.zxing.l) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, i11));
        }
        StringBuilder sb2 = this.f74857a;
        sb2.setLength(0);
        int iL = l(aVar, iArr, sb2);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k(iL, i11));
        }
        int[] iArrK = k(aVar, iL);
        if (lVar != null) {
            lVar.a(new com.google.zxing.k((iArrK[0] + iArrK[1]) / 2.0f, i11));
        }
        int i12 = iArrK[1];
        int i13 = (i12 - iArrK[0]) + i12;
        if (i13 >= aVar.m() || !aVar.o(i12, i13, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String string = sb2.toString();
        if (string.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        float f11 = (iArr[1] + iArr[0]) / 2.0f;
        float f12 = (iArrK[1] + iArrK[0]) / 2.0f;
        BarcodeFormat barcodeFormatQ = q();
        float f13 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k(f11, f13), new com.google.zxing.k(f12, f13)}, barcodeFormatQ);
        try {
            com.google.zxing.j jVarA = this.f74858b.a(i11, aVar, iArrK[1]);
            jVar.h(ResultMetadataType.UPC_EAN_EXTENSION, jVarA.f());
            jVar.g(jVarA.d());
            jVar.a(jVarA.e());
            length = jVarA.f().length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (length == iArr2[i14]) {
                    break;
                }
                i14++;
            }
        }
        if ((barcodeFormatQ == BarcodeFormat.EAN_13 || barcodeFormatQ == BarcodeFormat.UPC_A) && (strC = this.f74859c.c(string)) != null) {
            jVar.h(ResultMetadataType.POSSIBLE_COUNTRY, strC);
        }
        int i15 = barcodeFormatQ == BarcodeFormat.EAN_8 ? 4 : 0;
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]E" + i15);
        return jVar;
    }

    public abstract BarcodeFormat q();
}
