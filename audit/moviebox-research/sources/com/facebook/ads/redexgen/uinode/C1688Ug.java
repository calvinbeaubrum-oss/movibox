package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ug, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1688Ug implements LU {
    public static byte[] A03;
    public static String[] A04 = {"3JpGgMVfhEKs4h1tr8RMzDA7DOHokops", "dXqQ9QAcXKU8whF3kmnzOWjNbVMrrIOv", "otwaAvusvekoag06qMT5pISHPHVrRcMV", "WpvUEDFnYdSXMC7RGaJnlQQN5lPpeUoV", "uIVwlH6eBNHvEYk4kE6nlnhEt8muXj04", "pYVE6LchgLxW1usH7NIdAbU6pOe1Iyyx", "cgHZB3wyyqxQlT2ShG9pTXiCyg", "w9qB75SnMFWvoXL9CpdnGLUKrWLPOybN"};
    public int A00;
    public String A01;
    public final LU A02;

    static {
        A02();
    }

    public C1688Ug(LU lu2) {
        this.A02 = lu2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = bArrCopyOfRange[i14];
            String[] strArr = A04;
            if (strArr[5].charAt(25) == strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[5] = "Ai5XpAh7M4hRkPfPQf54GYnUnAkHicBv";
            strArr2[3] = "aIcIWiLMc3Hy2WApHOm5eO35KvTaoUWD";
            bArrCopyOfRange[i14] = (byte) ((b11 - i13) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        if (this.A01 != null) {
            this.A02.AE8(this.A01 + A00(0, 4, 10) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    public static void A02() {
        A03 = new byte[]{-117, -117, 125, -128};
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void AE8(String str) {
        if (LW.A0A(str)) {
            A01();
            this.A02.AE8(str);
            return;
        }
        String strA04 = LW.A04(str);
        if (strA04.equals(this.A01)) {
            this.A00++;
            return;
        }
        A01();
        this.A01 = strA04;
        this.A00 = 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.LU
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
