package km;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.datamatrix.encoder.MinimalEncoder;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.m;
import java.nio.charset.Charset;
import java.util.Map;
import nm.e;
import nm.i;
import nm.j;
import nm.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements m {
    public static hm.b b(bn.b bVar, int i11, int i12) {
        hm.b bVar2;
        int iE = bVar.e();
        int iD = bVar.d();
        int iMax = Math.max(i11, iE);
        int iMax2 = Math.max(i12, iD);
        int iMin = Math.min(iMax / iE, iMax2 / iD);
        int i13 = (iMax - (iE * iMin)) / 2;
        int i14 = (iMax2 - (iD * iMin)) / 2;
        if (i12 < iD || i11 < iE) {
            bVar2 = new hm.b(iE, iD);
            i13 = 0;
            i14 = 0;
        } else {
            bVar2 = new hm.b(i11, i12);
        }
        bVar2.b();
        int i15 = 0;
        while (i15 < iD) {
            int i16 = i13;
            int i17 = 0;
            while (i17 < iE) {
                if (bVar.b(i17, i15) == 1) {
                    bVar2.s(i16, i14, iMin, iMin);
                }
                i17++;
                i16 += iMin;
            }
            i15++;
            i14 += iMin;
        }
        return bVar2;
    }

    public static hm.b c(e eVar, k kVar, int i11, int i12) {
        int iH = kVar.h();
        int iG = kVar.g();
        bn.b bVar = new bn.b(kVar.j(), kVar.i());
        int i13 = 0;
        for (int i14 = 0; i14 < iG; i14++) {
            if (i14 % kVar.f72088e == 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < kVar.j(); i16++) {
                    bVar.g(i15, i13, i16 % 2 == 0);
                    i15++;
                }
                i13++;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < iH; i18++) {
                if (i18 % kVar.f72087d == 0) {
                    bVar.g(i17, i13, true);
                    i17++;
                }
                bVar.g(i17, i13, eVar.e(i18, i14));
                int i19 = i17 + 1;
                int i21 = kVar.f72087d;
                if (i18 % i21 == i21 - 1) {
                    bVar.g(i19, i13, i14 % 2 == 0);
                    i17 += 2;
                } else {
                    i17 = i19;
                }
            }
            int i22 = i13 + 1;
            int i23 = kVar.f72088e;
            if (i14 % i23 == i23 - 1) {
                int i24 = 0;
                for (int i25 = 0; i25 < kVar.j(); i25++) {
                    bVar.g(i24, i22, true);
                    i24++;
                }
                i13 += 2;
            } else {
                i13 = i22;
            }
        }
        return b(bVar, i11, i12);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    @Override // com.google.zxing.m
    public hm.b a(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) {
        c cVar;
        c cVar2;
        String strB;
        EncodeHintType encodeHintType;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i11 + 'x' + i12);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            cVar = (c) map.get(EncodeHintType.MIN_SIZE);
            if (cVar == null) {
                cVar = null;
            }
            cVar2 = (c) map.get(EncodeHintType.MAX_SIZE);
            if (cVar2 == null) {
                cVar2 = null;
            }
        } else {
            cVar = null;
            cVar2 = null;
        }
        boolean z11 = false;
        if (map != null) {
            EncodeHintType encodeHintType2 = EncodeHintType.DATA_MATRIX_COMPACT;
            if (map.containsKey(encodeHintType2) && Boolean.parseBoolean(map.get(encodeHintType2).toString())) {
                EncodeHintType encodeHintType3 = EncodeHintType.GS1_FORMAT;
                if (map.containsKey(encodeHintType3) && Boolean.parseBoolean(map.get(encodeHintType3).toString())) {
                    z11 = true;
                }
                EncodeHintType encodeHintType4 = EncodeHintType.CHARACTER_SET;
                strB = MinimalEncoder.h(str, map.containsKey(encodeHintType4) ? Charset.forName(map.get(encodeHintType4).toString()) : null, z11 ? 29 : -1, symbolShapeHint);
            } else {
                if (map != null) {
                    encodeHintType = EncodeHintType.FORCE_C40;
                    if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                        z11 = true;
                    }
                }
                strB = j.b(str, symbolShapeHint, cVar, cVar2, z11);
            }
        } else {
            if (map != null) {
                encodeHintType = EncodeHintType.FORCE_C40;
                if (map.containsKey(encodeHintType)) {
                    z11 = true;
                }
            }
            strB = j.b(str, symbolShapeHint, cVar, cVar2, z11);
        }
        k kVarL = k.l(strB.length(), symbolShapeHint, cVar, cVar2, true);
        e eVar = new e(i.b(strB, kVarL), kVarL.h(), kVarL.g());
        eVar.h();
        return c(eVar, kVarL, i11, i12);
    }
}
