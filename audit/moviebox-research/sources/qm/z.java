package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class z extends x {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f74860j = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[][] f74861k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f74862i = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb2 = new StringBuilder(12);
        sb2.append(str.charAt(0));
        char c11 = cArr[5];
        switch (c11) {
            case '0':
            case '1':
            case '2':
                sb2.append(cArr, 0, 2);
                sb2.append(c11);
                sb2.append("0000");
                sb2.append(cArr, 2, 3);
                break;
            case '3':
                sb2.append(cArr, 0, 3);
                sb2.append("00000");
                sb2.append(cArr, 3, 2);
                break;
            case '4':
                sb2.append(cArr, 0, 4);
                sb2.append("00000");
                sb2.append(cArr[4]);
                break;
            default:
                sb2.append(cArr, 0, 5);
                sb2.append("0000");
                sb2.append(c11);
                break;
        }
        if (str.length() >= 8) {
            sb2.append(str.charAt(7));
        }
        return sb2.toString();
    }

    public static void t(StringBuilder sb2, int i11) throws NotFoundException {
        for (int i12 = 0; i12 <= 1; i12++) {
            for (int i13 = 0; i13 < 10; i13++) {
                if (i11 == f74861k[i12][i13]) {
                    sb2.insert(0, (char) (i12 + 48));
                    sb2.append((char) (i13 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // qm.x
    public boolean h(String str) throws FormatException {
        return super.h(s(str));
    }

    @Override // qm.x
    public int[] k(hm.a aVar, int i11) throws NotFoundException {
        return x.n(aVar, i11, true, f74860j);
    }

    @Override // qm.x
    public int l(hm.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f74862i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int i11 = iArr[1];
        int i12 = 0;
        for (int i13 = 0; i13 < 6 && i11 < iM; i13++) {
            int iJ = x.j(aVar, iArr2, i11, x.f74856h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i14 : iArr2) {
                i11 += i14;
            }
            if (iJ >= 10) {
                i12 |= 1 << (5 - i13);
            }
        }
        t(sb2, i12);
        return i11;
    }

    @Override // qm.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_E;
    }
}
