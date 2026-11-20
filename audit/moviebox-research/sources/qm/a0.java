package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a0 extends y {
    @Override // qm.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(z.s(str));
            } catch (FormatException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
            try {
                if (!x.i(z.s(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        r.c(str);
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i11 = z.f74861k[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iB = r.b(zArr, 0, x.f74852d, true);
        for (int i12 = 1; i12 <= 6; i12++) {
            int iDigit2 = Character.digit(str.charAt(i12), 10);
            if (((i11 >> (6 - i12)) & 1) == 1) {
                iDigit2 += 10;
            }
            iB += r.b(zArr, iB, x.f74856h[iDigit2], false);
        }
        r.b(zArr, iB, x.f74854f, false);
        return zArr;
    }

    @Override // qm.r
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
