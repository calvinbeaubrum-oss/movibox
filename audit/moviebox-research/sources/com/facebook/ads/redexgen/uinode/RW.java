package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class RW {
    public static byte[] A05;
    public RS A00;
    public RV A01;
    public String A02;
    public String A03;
    public byte[] A04;

    static {
        A01();
    }

    public RW(String str, RY ry2, RS rs2) {
        this.A03 = A00(0, 0, 77);
        if (str != null) {
            this.A03 = str;
        }
        if (ry2 != null && !ry2.A06().isEmpty()) {
            this.A03 += A00(0, 1, 35) + ry2.A06();
        }
        this.A00 = rs2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{119};
    }

    public final RS A02() {
        return this.A00;
    }

    public final RV A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final byte[] A06() {
        return this.A04;
    }
}
