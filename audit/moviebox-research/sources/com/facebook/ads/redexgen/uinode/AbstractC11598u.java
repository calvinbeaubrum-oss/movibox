package com.facebook.ads.redexgen.uinode;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC11598u {
    public static byte[] A00;

    static {
        A03();
    }

    public static C8w A00(C1794Ym c1794Ym) {
        try {
            return new YD(c1794Ym);
        } catch (IOException e11) {
            c1794Ym.A07().A9a(A02(0, 15, 89), C8A.A2K, new C8B(e11));
            return new YG();
        }
    }

    public static EN A01(C1794Ym c1794Ym) {
        return new EN(c1794Ym);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-2, -15, -17, -5, -2, -16, -21, -16, -19, 0, -19, -18, -19, -1, -15};
    }
}
