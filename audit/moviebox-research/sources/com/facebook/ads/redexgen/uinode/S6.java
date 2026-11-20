package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network.dex */
public enum S6 {
    A03(A01(35, 4, 104)),
    A04(A01(39, 4, 113));

    public static byte[] A01;
    public String A00;

    static {
        A02();
    }

    S6(String str) {
        this.A00 = str;
    }

    public static S6 A00(String str) {
        for (S6 s11 : values()) {
            if (s11.A00.equals(str)) {
                return s11;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.US, A01(4, 27, 75), str));
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-99, -84, -93, -93, -22, Ascii.SI, Ascii.ETB, 2, Ascii.CR, 10, 5, -63, Ascii.DC4, 6, 19, Ascii.ETB, 6, 19, -63, 19, 6, Ascii.DC4, 17, Ascii.DLE, Ascii.SI, Ascii.DC4, 6, -37, -63, -58, Ascii.DC4, -34, -40, -40, -29, 36, 51, 42, 42, 50, 44, 44, 55};
    }
}
