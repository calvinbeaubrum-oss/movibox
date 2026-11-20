package lm;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.datamatrix.decoder.DecodedBitStreamParser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jm.c f70329a = new jm.c(jm.a.f68088m);

    public final int a(byte[] bArr, int i11) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        try {
            int iA = this.f70329a.a(iArr, bArr.length - i11);
            for (int i13 = 0; i13 < i11; i13++) {
                bArr[i13] = (byte) iArr[i13];
            }
            return iA;
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public hm.d b(hm.b bVar) throws ChecksumException, FormatException {
        a aVar = new a(bVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar2 : bVarArrB) {
            iC += bVar2.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        int iA = 0;
        for (int i11 = 0; i11 < length; i11++) {
            b bVar3 = bVarArrB[i11];
            byte[] bArrA = bVar3.a();
            int iC2 = bVar3.c();
            iA += a(bArrA, iC2);
            for (int i12 = 0; i12 < iC2; i12++) {
                bArr[(i12 * length) + i11] = bArrA[i12];
            }
        }
        hm.d dVarA = DecodedBitStreamParser.a(bArr);
        dVarA.n(Integer.valueOf(iA));
        return dVarA;
    }
}
