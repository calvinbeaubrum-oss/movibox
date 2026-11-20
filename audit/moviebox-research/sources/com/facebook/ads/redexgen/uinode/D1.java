package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D1 {
    public static String[] A0G = {"pHpyHP8S", "m7Dm6DzF3JrYgJb8r3aBvOiHYZnTgqFt", "HDu7bLu972VfHIygI4M5b4TuY4lqC4yg", "iivH24vaI3kkb3LFmloVx1IOyWVuKza4", "KZ0yf6ou6J0TqVPjqp3i5DSivFyU8bNM", "Pc4fHgH2fAOt1gCYCPntkv807xx", "lUKVzHZS", "o3UNUm1DzZwOBzkgZiuDkjMNM5U"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public C1371Hu A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;

    public D1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A00(D1 d11) {
        if (this.A0F) {
            if (!d11.A0F || this.A03 != d11.A03 || this.A07 != d11.A07 || this.A0C != d11.A0C) {
                return true;
            }
            boolean z11 = this.A0B;
            String[] strArr = A0G;
            if (strArr[1].charAt(29) == strArr[4].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[7] = "XDMSMjR4OOJ5qpPgon6YqbblugR";
            strArr2[5] = "5xZUmDJH2T0z2hm3Lt8QCiFJvrf";
            if (z11 && d11.A0B && this.A0A != d11.A0A) {
                return true;
            }
            int i11 = this.A05;
            int i12 = d11.A05;
            if (i11 != i12 && (i11 == 0 || i12 == 0)) {
                return true;
            }
            if (this.A09.A04 == 0 && d11.A09.A04 == 0 && (this.A06 != d11.A06 || this.A02 != d11.A02)) {
                return true;
            }
            if (this.A09.A04 == 1 && d11.A09.A04 == 1) {
                int i13 = this.A00;
                if (A0G[2].length() == 32) {
                    String[] strArr3 = A0G;
                    strArr3[7] = "XRlTxrvrNP0CnKRouPcFPiOcqOY";
                    strArr3[5] = "BA8SrIsjDMc450dTESwcliSODCW";
                    if (i13 != d11.A00) {
                        return true;
                    }
                } else if (i13 != d11.A00) {
                    return true;
                }
                if (this.A01 != d11.A01) {
                    return true;
                }
            }
            boolean z12 = this.A0E;
            boolean z13 = d11.A0E;
            if (z12 != z13) {
                return true;
            }
            if (z12 && z13 && this.A04 != d11.A04) {
                return true;
            }
        }
        return false;
    }

    public final void A02() {
        this.A0D = false;
        this.A0F = false;
    }

    public final void A03(int i11) {
        this.A08 = i11;
        this.A0D = true;
    }

    public final void A04(C1371Hu c1371Hu, int i11, int i12, int i13, int i14, boolean z11, boolean z12, boolean z13, boolean z14, int i15, int i16, int i17, int i18, int i19) {
        this.A09 = c1371Hu;
        this.A05 = i11;
        this.A08 = i12;
        this.A03 = i13;
        this.A07 = i14;
        this.A0C = z11;
        this.A0B = z12;
        this.A0A = z13;
        this.A0E = z14;
        this.A04 = i15;
        this.A06 = i16;
        this.A02 = i17;
        this.A00 = i18;
        this.A01 = i19;
        this.A0F = true;
        this.A0D = true;
    }

    public final boolean A05() {
        int i11;
        return this.A0D && ((i11 = this.A08) == 7 || i11 == 2);
    }
}
