package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum C2U {
    A05(A00(22, 6, 6)),
    A03(A00(14, 4, 124)),
    A04(A00(18, 4, 24));

    public static byte[] A01;
    public final String A00;

    static {
        A01();
    }

    C2U(String str) {
        this.A00 = str;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{66, 67, 78, 79, Ascii.SI, Ascii.SO, Ascii.SI, 4, 91, 76, 89, 70, 91, 93, 119, 118, 123, 122, Ascii.NAK, Ascii.DC4, Ascii.NAK, Ascii.RS, Ascii.ETB, 0, Ascii.NAK, 10, Ascii.ETB, 17};
    }

    public final String A02() {
        return this.A00;
    }
}
