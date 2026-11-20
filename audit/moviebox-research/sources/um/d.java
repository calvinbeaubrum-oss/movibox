package um;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.m;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d implements m {
    public static hm.b b(byte[][] bArr, int i11) {
        int i12 = i11 * 2;
        hm.b bVar = new hm.b(bArr[0].length + i12, bArr.length + i12);
        bVar.b();
        int iK = (bVar.k() - i11) - 1;
        int i13 = 0;
        while (i13 < bArr.length) {
            byte[] bArr2 = bArr[i13];
            for (int i14 = 0; i14 < bArr[0].length; i14++) {
                if (bArr2[i14] == 1) {
                    bVar.r(i14 + i11, iK);
                }
            }
            i13++;
            iK--;
        }
        return bVar;
    }

    public static hm.b c(ym.d dVar, String str, int i11, int i12, int i13, int i14, boolean z11) throws WriterException {
        boolean z12;
        dVar.e(str, i11, z11);
        byte[][] bArrB = dVar.f().b(1, 4);
        if ((i13 > i12) != (bArrB[0].length < bArrB.length)) {
            bArrB = d(bArrB);
            z12 = true;
        } else {
            z12 = false;
        }
        int iMin = Math.min(i12 / bArrB[0].length, i13 / bArrB.length);
        if (iMin <= 1) {
            return b(bArrB, i14);
        }
        byte[][] bArrB2 = dVar.f().b(iMin, iMin * 4);
        if (z12) {
            bArrB2 = d(bArrB2);
        }
        return b(bArrB2, i14);
    }

    public static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int length = (bArr.length - i11) - 1;
            for (int i12 = 0; i12 < bArr[0].length; i12++) {
                bArr2[i12][length] = bArr[i11][i12];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.m
    public hm.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        int i13;
        int i14;
        boolean z11;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        ym.d dVar = new ym.d();
        boolean z12 = false;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                dVar.h(Boolean.parseBoolean(map.get(encodeHintType).toString()));
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                dVar.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                ym.c cVar = (ym.c) map.get(encodeHintType3);
                dVar.j(cVar.a(), cVar.c(), cVar.b(), cVar.d());
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            int i15 = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            int i16 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                dVar.k(Charset.forName(map.get(encodeHintType6).toString()));
            }
            EncodeHintType encodeHintType7 = EncodeHintType.PDF417_AUTO_ECI;
            if (map.containsKey(encodeHintType7) && Boolean.parseBoolean(map.get(encodeHintType7).toString())) {
                z12 = true;
            }
            z11 = z12;
            i14 = i15;
            i13 = i16;
        } else {
            i13 = 2;
            i14 = 30;
            z11 = false;
        }
        return c(dVar, str, i13, i11, i12, i14, z11);
    }
}
