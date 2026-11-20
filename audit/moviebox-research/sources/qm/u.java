package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f74844a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f74845b = new StringBuilder();

    public static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    public final int a(hm.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f74844a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int iL = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 2 && iL < iM; i12++) {
            int iJ = x.j(aVar, iArr2, iL, x.f74856h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i13 : iArr2) {
                iL += i13;
            }
            if (iJ >= 10) {
                i11 |= 1 << (1 - i12);
            }
            if (i12 != 1) {
                iL = aVar.l(aVar.k(iL));
            }
        }
        if (sb2.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb2.toString()) % 4 == i11) {
            return iL;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public com.google.zxing.j b(int i11, hm.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f74845b;
        sb2.setLength(0);
        int iA = a(aVar, iArr, sb2);
        String string = sb2.toString();
        Map<ResultMetadataType, Object> mapC = c(string);
        float f11 = i11;
        com.google.zxing.j jVar = new com.google.zxing.j(string, null, new com.google.zxing.k[]{new com.google.zxing.k((iArr[0] + iArr[1]) / 2.0f, f11), new com.google.zxing.k(iA, f11)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapC != null) {
            jVar.g(mapC);
        }
        return jVar;
    }
}
