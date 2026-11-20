package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i extends y {
    @Override // qm.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + x.r(str);
            } catch (FormatException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
            }
            try {
                if (!x.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        r.c(str);
        int i11 = h.f74824j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iB = r.b(zArr, 0, x.f74852d, true);
        for (int i12 = 1; i12 <= 6; i12++) {
            int iDigit = Character.digit(str.charAt(i12), 10);
            if (((i11 >> (6 - i12)) & 1) == 1) {
                iDigit += 10;
            }
            iB += r.b(zArr, iB, x.f74856h[iDigit], false);
        }
        int iB2 = iB + r.b(zArr, iB, x.f74853e, false);
        for (int i13 = 7; i13 <= 12; i13++) {
            iB2 += r.b(zArr, iB2, x.f74855g[Character.digit(str.charAt(i13), 10)], true);
        }
        r.b(zArr, iB2, x.f74852d, true);
        return zArr;
    }

    @Override // qm.r
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
