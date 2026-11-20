package an;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jm.c f580a = new jm.c(jm.a.f68087l);

    public final int a(byte[] bArr, int i11) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        try {
            int iA = this.f580a.a(iArr, bArr.length - i11);
            for (int i13 = 0; i13 < i11; i13++) {
                bArr[i13] = (byte) iArr[i13];
            }
            return iA;
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public final hm.d b(com.google.zxing.qrcode.decoder.a aVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        f fVarE = aVar.e();
        ErrorCorrectionLevel errorCorrectionLevelD = aVar.d().d();
        a[] aVarArrB = a.b(aVar.c(), fVarE, errorCorrectionLevelD);
        int iC = 0;
        for (a aVar2 : aVarArrB) {
            iC += aVar2.c();
        }
        byte[] bArr = new byte[iC];
        int iA = 0;
        int i11 = 0;
        for (a aVar3 : aVarArrB) {
            byte[] bArrA = aVar3.a();
            int iC2 = aVar3.c();
            iA += a(bArrA, iC2);
            int i12 = 0;
            while (i12 < iC2) {
                bArr[i11] = bArrA[i12];
                i12++;
                i11++;
            }
        }
        hm.d dVarA = b.a(bArr, fVarE, errorCorrectionLevelD, map);
        dVarA.n(Integer.valueOf(iA));
        return dVarA;
    }

    public hm.d c(hm.b bVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException e11;
        com.google.zxing.qrcode.decoder.a aVar = new com.google.zxing.qrcode.decoder.a(bVar);
        FormatException formatException = null;
        try {
            return b(aVar, map);
        } catch (ChecksumException e12) {
            e11 = e12;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                hm.d dVarB = b(aVar, map);
                dVarB.p(new e(true));
                return dVarB;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e11;
            }
        } catch (FormatException e13) {
            e11 = null;
            formatException = e13;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            hm.d dVarB2 = b(aVar, map);
            dVarB2.p(new e(true));
            return dVarB2;
        }
    }
}
