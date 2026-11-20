package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1450Lc {
    A08(0),
    A07(0),
    A06(1),
    A03(2),
    A04(3),
    A05(4);

    public static byte[] A01;
    public final int A00;

    static {
        A01();
    }

    EnumC1450Lc(int i11) {
        this.A00 = i11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-85, -83, -96, -89, -86, -93, -67, -112, -91, -36, -34, -47, -40, -37, -44, -18, -62, -42, -45, -43, -56, -49, -46, -53, -27, -70, -51, -26, -24, -37, -30, -27, -34, -8, -30, -25, -19, -34, -21, -25, -34, -19, -90, -89, -90, -99, -34, -41, -44, -41, -40, -32, -41};
    }
}
