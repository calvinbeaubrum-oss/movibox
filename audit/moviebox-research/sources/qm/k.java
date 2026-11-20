package qm;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k extends y {
    @Override // qm.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(str);
            } catch (FormatException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
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
        boolean[] zArr = new boolean[67];
        int iB = r.b(zArr, 0, x.f74852d, true);
        for (int i11 = 0; i11 <= 3; i11++) {
            iB += r.b(zArr, iB, x.f74855g[Character.digit(str.charAt(i11), 10)], false);
        }
        int iB2 = iB + r.b(zArr, iB, x.f74853e, false);
        for (int i12 = 4; i12 <= 7; i12++) {
            iB2 += r.b(zArr, iB2, x.f74855g[Character.digit(str.charAt(i12), 10)], true);
        }
        r.b(zArr, iB2, x.f74852d, true);
        return zArr;
    }

    @Override // qm.r
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
