package com.facebook.ads.redexgen.uinode;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HC extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public HC(Throwable th2) {
        super(A00(2, 11, 64) + th2.getClass().getSimpleName() + A00(0, 2, 15) + th2.getMessage(), th2);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{94, 68, -86, -61, -70, -51, -59, -70, -72, -55, -70, -71, 117};
    }
}
