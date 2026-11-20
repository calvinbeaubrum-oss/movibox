package zm;

import bn.e;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.m;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements m {
    public static hm.b b(e eVar, int i11, int i12, int i13) {
        bn.b bVarA = eVar.a();
        if (bVarA == null) {
            throw new IllegalStateException();
        }
        int iE = bVarA.e();
        int iD = bVarA.d();
        int i14 = i13 * 2;
        int i15 = iE + i14;
        int i16 = i14 + iD;
        int iMax = Math.max(i11, i15);
        int iMax2 = Math.max(i12, i16);
        int iMin = Math.min(iMax / i15, iMax2 / i16);
        int i17 = (iMax - (iE * iMin)) / 2;
        int i18 = (iMax2 - (iD * iMin)) / 2;
        hm.b bVar = new hm.b(iMax, iMax2);
        int i19 = 0;
        while (i19 < iD) {
            int i21 = i17;
            int i22 = 0;
            while (i22 < iE) {
                if (bVarA.b(i22, i19) == 1) {
                    bVar.s(i21, i18, iMin, iMin);
                }
                i22++;
                i21 += iMin;
            }
            i19++;
            i18 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.m
    public hm.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i11 + 'x' + i12);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i13 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i13 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return b(com.google.zxing.qrcode.encoder.a.n(str, errorCorrectionLevelValueOf, map), i11, i12, i13);
    }
}
