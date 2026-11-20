package zm;

import an.c;
import an.e;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.k;
import hm.d;
import hm.f;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k[] f82102b = new k[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f82103a = new c();

    private static hm.b c(hm.b bVar) throws NotFoundException {
        int[] iArrM = bVar.m();
        int[] iArrH = bVar.h();
        if (iArrM == null || iArrH == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fD = d(iArrM, bVar);
        int i11 = iArrM[1];
        int i12 = iArrH[1];
        int i13 = iArrM[0];
        int i14 = iArrH[0];
        if (i13 >= i14 || i11 >= i12) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = i12 - i11;
        if (i15 != i14 - i13 && (i14 = i13 + i15) >= bVar.n()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i14 - i13) + 1) / fD);
        int iRound2 = Math.round((i15 + 1) / fD);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i16 = (int) (fD / 2.0f);
        int i17 = i11 + i16;
        int i18 = i13 + i16;
        int i19 = (((int) ((iRound - 1) * fD)) + i18) - i14;
        if (i19 > 0) {
            if (i19 > i16) {
                throw NotFoundException.getNotFoundInstance();
            }
            i18 -= i19;
        }
        int i21 = (((int) ((iRound2 - 1) * fD)) + i17) - i12;
        if (i21 > 0) {
            if (i21 > i16) {
                throw NotFoundException.getNotFoundInstance();
            }
            i17 -= i21;
        }
        hm.b bVar2 = new hm.b(iRound, iRound2);
        for (int i22 = 0; i22 < iRound2; i22++) {
            int i23 = ((int) (i22 * fD)) + i17;
            for (int i24 = 0; i24 < iRound; i24++) {
                if (bVar.g(((int) (i24 * fD)) + i18, i23)) {
                    bVar2.r(i24, i22);
                }
            }
        }
        return bVar2;
    }

    public static float d(int[] iArr, hm.b bVar) throws NotFoundException {
        int iK = bVar.k();
        int iN = bVar.n();
        int i11 = iArr[0];
        boolean z11 = true;
        int i12 = iArr[1];
        int i13 = 0;
        while (i11 < iN && i12 < iK) {
            if (z11 != bVar.g(i11, i12)) {
                i13++;
                if (i13 == 5) {
                    break;
                }
                z11 = !z11;
            }
            i11++;
            i12++;
        }
        if (i11 == iN || i12 == iK) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i11 - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.i
    public final j a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        k[] kVarArrB;
        d dVarC;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f fVarE = new com.google.zxing.qrcode.detector.c(bVar.a()).e(map);
            d dVarC2 = this.f82103a.c(fVarE.a(), map);
            kVarArrB = fVarE.b();
            dVarC = dVarC2;
        } else {
            dVarC = this.f82103a.c(c(bVar.a()), map);
            kVarArrB = f82102b;
        }
        if (dVarC.f() instanceof e) {
            ((e) dVarC.f()).a(kVarArrB);
        }
        j jVar = new j(dVarC.k(), dVarC.g(), kVarArrB, BarcodeFormat.QR_CODE);
        List<byte[]> listA = dVarC.a();
        if (listA != null) {
            jVar.h(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarC.b();
        if (strB != null) {
            jVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        if (dVarC.l()) {
            jVar.h(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVarC.i()));
            jVar.h(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVarC.h()));
        }
        jVar.h(ResultMetadataType.ERRORS_CORRECTED, dVarC.d());
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + dVarC.j());
        return jVar;
    }

    @Override // com.google.zxing.i
    public j b(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // com.google.zxing.i
    public void reset() {
    }
}
