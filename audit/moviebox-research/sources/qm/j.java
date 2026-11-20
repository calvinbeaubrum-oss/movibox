package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j extends x {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f74826i = new int[4];

    @Override // qm.x
    public int l(hm.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f74826i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int i11 = iArr[1];
        for (int i12 = 0; i12 < 4 && i11 < iM; i12++) {
            sb2.append((char) (x.j(aVar, iArr2, i11, x.f74855g) + 48));
            for (int i13 : iArr2) {
                i11 += i13;
            }
        }
        int i14 = x.n(aVar, i11, true, x.f74853e)[1];
        for (int i15 = 0; i15 < 4 && i14 < iM; i15++) {
            sb2.append((char) (x.j(aVar, iArr2, i14, x.f74855g) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // qm.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
