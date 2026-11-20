package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1822Zp implements InterfaceC10594m {
    public static byte[] A04;
    public static String[] A05 = {"yYJ6SOT3uDFyj2TBTti7WWfRsn28EaA0", "ibfMp1J9gSZsYrxVf4NvaZx8D9JO1QBg", "rjgnGVcZwB7yGoiyculy9B4zYqmoHpCR", "", "BFeMqfRovMahqpkErO60kJAdny9RRdno", "ZwvbtEc0kmFFJCTTqnK3GQ6ySyfI7Whf", "3RaP0tr92GxZHPCEm9", "lHI5DV8"};
    public int A00;
    public int A01;
    public int A02;
    public int[] A03;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-87, -66, -42, -52, -46, -47, 125, -51, -52, -48, -58, -47, -58, -52, -53, -48, 125, -54, -46, -48, -47, 125, -65, -62, 125, -53, -52, -53, -118, -53, -62, -60, -66, -47, -58, -45, -62, -60, -35, -20, -39, -32, -108, -40, -35, -25, -24, -43, -30, -41, -39, -108, -31, -23, -25, -24, -108, -42, -39, -108, -30, -29, -30, -95, -30, -39, -37, -43, -24, -35, -22, -39};
    }

    public final void A02() {
        int[] iArr = this.A03;
        if (iArr != null) {
            if (A05[7].length() != 7) {
                throw new RuntimeException();
            }
            A05[7] = "V5jR13F";
            Arrays.fill(iArr, -1);
        }
        this.A00 = 0;
    }

    public final void A03(int i11, int i12) {
        this.A01 = i11;
        this.A02 = i12;
    }

    public final void A04(C1278Eb c1278Eb, boolean z11) {
        this.A00 = 0;
        int[] iArr = this.A03;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        AbstractC10614o abstractC10614o = c1278Eb.A06;
        if (c1278Eb.A04 == null || abstractC10614o == null || !abstractC10614o.A1U()) {
            return;
        }
        if (z11) {
            boolean zA0B = c1278Eb.A00.A0B();
            String[] strArr = A05;
            if (strArr[0].charAt(30) != strArr[5].charAt(30)) {
                A05[7] = "b5aEeD0";
                if (!zA0B) {
                    abstractC10614o.A1r(c1278Eb.A04.A0E(), this);
                }
            }
            throw new RuntimeException();
        }
        if (!c1278Eb.A1p()) {
            abstractC10614o.A1q(this.A01, this.A02, c1278Eb.A0s, this);
        }
        int i11 = this.A00;
        int i12 = abstractC10614o.A00;
        String[] strArr2 = A05;
        if (strArr2[3].length() != strArr2[6].length()) {
            A05[7] = "TjVTm35";
            if (i11 > i12) {
                abstractC10614o.A00 = this.A00;
                abstractC10614o.A08 = z11;
                c1278Eb.A0r.A0O();
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public final boolean A05(int i11) {
        if (this.A03 == null) {
            return false;
        }
        int i12 = this.A00 * 2;
        for (int i13 = 0; i13 < i12; i13 += 2) {
            if (this.A03[i13] == i11) {
                String[] strArr = A05;
                if (strArr[0].charAt(30) == strArr[5].charAt(30)) {
                    throw new RuntimeException();
                }
                A05[2] = "SVfMGWcG5IEJEA83X9P3956xbutBXkdM";
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10594m
    public final void A3S(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException(A00(0, 37, 10));
        }
        if (i12 < 0) {
            throw new IllegalArgumentException(A00(37, 35, 33));
        }
        int i13 = this.A00 * 2;
        int[] iArr = this.A03;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.A03 = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i13 >= iArr.length) {
            int[] iArr3 = this.A03;
            int[] iArr4 = new int[i13 * 2];
            this.A03 = iArr4;
            System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
        }
        int[] iArr5 = this.A03;
        iArr5[i13] = i11;
        iArr5[i13 + 1] = i12;
        this.A00++;
    }
}
