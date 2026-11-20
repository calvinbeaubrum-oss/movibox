package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f74846c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f74847a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f74848b = new StringBuilder();

    public static int c(int i11) throws NotFoundException {
        for (int i12 = 0; i12 < 10; i12++) {
            if (i11 == f74846c[i12]) {
                return i12;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i11 = length - 2; i11 >= 0; i11 -= 2) {
            iCharAt += charSequence.charAt(i11) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i12 = length - 1; i12 >= 0; i12 -= 2) {
            iCharAt2 += charSequence.charAt(i12) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public static String e(String str) {
        String str2;
        byte b11 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                switch (str.hashCode()) {
                    case 54118329:
                        if (!str.equals("90000")) {
                            b11 = -1;
                        }
                        break;
                    case 54395376:
                        if (!str.equals("99990")) {
                            b11 = -1;
                        } else {
                            b11 = 1;
                        }
                        break;
                    case 54395377:
                        if (!str.equals("99991")) {
                            b11 = -1;
                        } else {
                            b11 = 2;
                        }
                        break;
                    default:
                        b11 = -1;
                        break;
                }
                switch (b11) {
                    case 0:
                        return null;
                    case 1:
                        return "Used";
                    case 2:
                        return "0.00";
                }
            }
        } else {
            str2 = "$";
        }
        int i11 = Integer.parseInt(str.substring(1));
        String strValueOf = String.valueOf(i11 / 100);
        int i12 = i11 % 100;
        return str2 + strValueOf + '.' + (i12 < 10 ? "0" + i12 : String.valueOf(i12));
    }

    public static Map<ResultMetadataType, Object> f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, strE);
        return enumMap;
    }

    public final int a(hm.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f74847a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int iL = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 5 && iL < iM; i12++) {
            int iJ = x.j(aVar, iArr2, iL, x.f74856h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i13 : iArr2) {
                iL += i13;
            }
            if (iJ >= 10) {
                i11 |= 1 << (4 - i12);
            }
            if (i12 != 4) {
                iL = aVar.l(aVar.k(iL));
            }
        }
        if (sb2.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb2.toString()) == c(i11)) {
            return iL;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public com.google.zxing.j b(int i11, hm.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f74848b;
        sb2.setLength(0);
        int iA = a(aVar, iArr, sb2);
        String string = sb2.toString();
        Map<ResultMetadataType, Object> mapF = f(string);
        float f11 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, f11), new com.google.zxing.k(iA, f11)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapF != null) {
            jVar.g(mapF);
        }
        return jVar;
    }
}
