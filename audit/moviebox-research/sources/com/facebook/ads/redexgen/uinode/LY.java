package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class LY {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A01(String str) {
        if (str == null) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, A00(0, 1, 88), true);
        int i11 = 0;
        if (str.length() <= 90) {
            return str;
        }
        int length = str.length();
        String strA00 = A00(1, 3, 14);
        if (length <= 93 && str.endsWith(strA00)) {
            return str;
        }
        while (stringTokenizer.hasMoreTokens()) {
            int length2 = stringTokenizer.nextToken().length();
            if (i11 + length2 < 90) {
                i11 += length2;
            }
        }
        return i11 == 0 ? str.substring(0, 90) + strA00 : str.substring(0, i11) + strA00;
    }

    public static void A02() {
        A00 = new byte[]{Ascii.EM, 65, 65, 65};
    }
}
