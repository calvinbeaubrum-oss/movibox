package com.google.zxing.qrcode.decoder;

import an.d;
import an.f;
import com.google.zxing.FormatException;
import hm.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f41553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f41554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f41555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41556d;

    public a(b bVar) throws FormatException {
        int iK = bVar.k();
        if (iK < 21 || (iK & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f41553a = bVar;
    }

    public final int a(int i11, int i12, int i13) {
        return this.f41556d ? this.f41553a.g(i12, i11) : this.f41553a.g(i11, i12) ? (i13 << 1) | 1 : i13 << 1;
    }

    public void b() {
        int i11 = 0;
        while (i11 < this.f41553a.n()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.f41553a.k(); i13++) {
                if (this.f41553a.g(i11, i13) != this.f41553a.g(i13, i11)) {
                    this.f41553a.f(i13, i11);
                    this.f41553a.f(i11, i13);
                }
            }
            i11 = i12;
        }
    }

    public byte[] c() throws FormatException {
        d dVarD = d();
        f fVarE = e();
        DataMask dataMask = DataMask.values()[dVarD.c()];
        int iK = this.f41553a.k();
        dataMask.unmaskBitMatrix(this.f41553a, iK);
        b bVarA = fVarE.a();
        byte[] bArr = new byte[fVarE.h()];
        int i11 = iK - 1;
        boolean z11 = true;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == 6) {
                i12--;
            }
            for (int i16 = 0; i16 < iK; i16++) {
                int i17 = z11 ? i11 - i16 : i16;
                for (int i18 = 0; i18 < 2; i18++) {
                    int i19 = i12 - i18;
                    if (!bVarA.g(i19, i17)) {
                        i14++;
                        i15 <<= 1;
                        if (this.f41553a.g(i19, i17)) {
                            i15 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i13] = (byte) i15;
                            i13++;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                }
            }
            z11 = !z11;
            i12 -= 2;
        }
        if (i13 == fVarE.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public d d() throws FormatException {
        d dVar = this.f41555c;
        if (dVar != null) {
            return dVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            iA2 = a(i11, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i12 = 5; i12 >= 0; i12--) {
            iA3 = a(8, i12, iA3);
        }
        int iK = this.f41553a.k();
        int i13 = iK - 7;
        for (int i14 = iK - 1; i14 >= i13; i14--) {
            iA = a(8, i14, iA);
        }
        for (int i15 = iK - 8; i15 < iK; i15++) {
            iA = a(i15, 8, iA);
        }
        d dVarA = d.a(iA3, iA);
        this.f41555c = dVarA;
        if (dVarA != null) {
            return dVarA;
        }
        throw FormatException.getFormatInstance();
    }

    public f e() throws FormatException {
        f fVar = this.f41554b;
        if (fVar != null) {
            return fVar;
        }
        int iK = this.f41553a.k();
        int i11 = (iK - 17) / 4;
        if (i11 <= 6) {
            return f.i(i11);
        }
        int i12 = iK - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i13 = 5; i13 >= 0; i13--) {
            for (int i14 = iK - 9; i14 >= i12; i14--) {
                iA2 = a(i14, i13, iA2);
            }
        }
        f fVarC = f.c(iA2);
        if (fVarC != null && fVarC.e() == iK) {
            this.f41554b = fVarC;
            return fVarC;
        }
        for (int i15 = 5; i15 >= 0; i15--) {
            for (int i16 = iK - 9; i16 >= i12; i16--) {
                iA = a(i15, i16, iA);
            }
        }
        f fVarC2 = f.c(iA);
        if (fVarC2 == null || fVarC2.e() != iK) {
            throw FormatException.getFormatInstance();
        }
        this.f41554b = fVarC2;
        return fVarC2;
    }

    public void f() {
        if (this.f41555c == null) {
            return;
        }
        DataMask.values()[this.f41555c.c()].unmaskBitMatrix(this.f41553a, this.f41553a.k());
    }

    public void g(boolean z11) {
        this.f41554b = null;
        this.f41555c = null;
        this.f41556d = z11;
    }
}
