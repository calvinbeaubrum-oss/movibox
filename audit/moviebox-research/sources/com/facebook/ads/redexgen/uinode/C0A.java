package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0A {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 64);
        }
        return new String(bArrCopyOfRange);
    }

    private String A01(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= str.length()) ? A00(0, 0, 13) : str.substring(iLastIndexOf + 1, str.length());
    }

    public static void A02() {
        A00 = new byte[]{71};
    }

    public final String A03(String str) {
        String strA01 = A01(str);
        String strA02 = C0I.A02(str);
        return TextUtils.isEmpty(strA01) ? strA02 : strA02 + A00(0, 1, 41) + strA01;
    }
}
