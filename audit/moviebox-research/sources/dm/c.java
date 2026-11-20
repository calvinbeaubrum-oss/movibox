package dm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.m;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements m {
    public static hm.b b(String str, BarcodeFormat barcodeFormat, int i11, int i12, Charset charset, int i13, int i14) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(com.google.zxing.aztec.encoder.c.d(str, i13, i14, charset), i11, i12);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    public static hm.b c(com.google.zxing.aztec.encoder.a aVar, int i11, int i12) {
        hm.b bVarA = aVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int iN = bVarA.n();
        int iK = bVarA.k();
        int iMax = Math.max(i11, iN);
        int iMax2 = Math.max(i12, iK);
        int iMin = Math.min(iMax / iN, iMax2 / iK);
        int i13 = (iMax - (iN * iMin)) / 2;
        int i14 = (iMax2 - (iK * iMin)) / 2;
        hm.b bVar = new hm.b(iMax, iMax2);
        int i15 = 0;
        while (i15 < iK) {
            int i16 = i13;
            int i17 = 0;
            while (i17 < iN) {
                if (bVarA.g(i17, i15)) {
                    bVar.s(i16, i14, iMin, iMin);
                }
                i17++;
                i16 += iMin;
            }
            i15++;
            i14 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.m
    public hm.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i13;
        int i14;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            Charset charsetForName = map.containsKey(encodeHintType) ? Charset.forName(map.get(encodeHintType).toString()) : null;
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int i15 = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charsetForName;
                i13 = i15;
                i14 = Integer.parseInt(map.get(encodeHintType3).toString());
            } else {
                charset = charsetForName;
                i13 = i15;
            }
            return b(str, barcodeFormat, i11, i12, charset, i13, i14);
        }
        charset = null;
        i13 = 33;
        i14 = 0;
        return b(str, barcodeFormat, i11, i12, charset, i13, i14);
    }
}
