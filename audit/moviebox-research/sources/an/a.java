package an;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f577b;

    public a(int i11, byte[] bArr) {
        this.f576a = i11;
        this.f577b = bArr;
    }

    public static a[] b(byte[] bArr, f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != fVar.h()) {
            throw new IllegalArgumentException();
        }
        f.b bVarF = fVar.f(errorCorrectionLevel);
        f.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (f.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        a[] aVarArr = new a[iA];
        int i11 = 0;
        for (f.a aVar2 : aVarArrA) {
            int i12 = 0;
            while (i12 < aVar2.a()) {
                int iB = aVar2.b();
                aVarArr[i11] = new a(iB, new byte[bVarF.b() + iB]);
                i12++;
                i11++;
            }
        }
        int length = aVarArr[0].f577b.length;
        int i13 = iA - 1;
        while (i13 >= 0 && aVarArr[i13].f577b.length != length) {
            i13--;
        }
        int i14 = i13 + 1;
        int iB2 = length - bVarF.b();
        int i15 = 0;
        for (int i16 = 0; i16 < iB2; i16++) {
            int i17 = 0;
            while (i17 < i11) {
                aVarArr[i17].f577b[i16] = bArr[i15];
                i17++;
                i15++;
            }
        }
        int i18 = i14;
        while (i18 < i11) {
            aVarArr[i18].f577b[iB2] = bArr[i15];
            i18++;
            i15++;
        }
        int length2 = aVarArr[0].f577b.length;
        while (iB2 < length2) {
            int i19 = 0;
            while (i19 < i11) {
                aVarArr[i19].f577b[i19 < i14 ? iB2 : iB2 + 1] = bArr[i15];
                i19++;
                i15++;
            }
            iB2++;
        }
        return aVarArr;
    }

    public byte[] a() {
        return this.f577b;
    }

    public int c() {
        return this.f576a;
    }
}
