package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class r implements com.google.zxing.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f74841a = Pattern.compile("[0-9]+");

    public static int b(boolean[] zArr, int i11, int[] iArr, boolean z11) {
        int i12 = 0;
        for (int i13 : iArr) {
            int i14 = 0;
            while (i14 < i13) {
                zArr[i11] = z11;
                i14++;
                i11++;
            }
            i12 += i13;
            z11 = !z11;
        }
        return i12;
    }

    public static void c(String str) {
        if (!f74841a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    public static hm.b h(boolean[] zArr, int i11, int i12, int i13) {
        int length = zArr.length;
        int i14 = i13 + length;
        int iMax = Math.max(i11, i14);
        int iMax2 = Math.max(1, i12);
        int i15 = iMax / i14;
        int i16 = (iMax - (length * i15)) / 2;
        hm.b bVar = new hm.b(iMax, iMax2);
        int i17 = 0;
        while (i17 < length) {
            if (zArr[i17]) {
                bVar.s(i16, 0, i15, iMax2);
            }
            i17++;
            i16 += i15;
        }
        return bVar;
    }

    @Override // com.google.zxing.m
    public hm.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i11 + 'x' + i12);
        }
        Collection<BarcodeFormat> collectionG = g();
        if (collectionG == null || collectionG.contains(barcodeFormat)) {
            int iF = f();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    iF = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return h(e(str, map), i11, i12, iF);
        }
        throw new IllegalArgumentException("Can only encode " + collectionG + ", but got " + barcodeFormat);
    }

    public abstract boolean[] d(String str);

    public boolean[] e(String str, Map<EncodeHintType, ?> map) {
        return d(str);
    }

    public int f() {
        return 10;
    }

    public abstract Collection<BarcodeFormat> g();
}
