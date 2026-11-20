package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public enum QM {
    A03,
    A04,
    A02;

    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, Ascii.RS, Ascii.US, 4, Ascii.DC4, Ascii.CAN, Ascii.US, 10, Ascii.EM, Ascii.US, Ascii.SO, Ascii.SI, 66, 67, 88, 83, 95, 88, 77, 94, 88, 73, 72, Ascii.DC2, Ascii.DC4, 2, Ascii.NAK, Ascii.CAN, Ascii.DC4, 19, 6, Ascii.NAK, 19, 2, 3};
    }
}
