package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TK implements PA {
    public static byte[] A01;
    public static String[] A02 = {"0PGepnyvQncL93SwwJBKfYdUcygiJGu5", "mA1Oa6p2jIMu30EggfbRnzpoMhUl4ssl", "uwNPSbrm", "iNgEEx1gRKfrkJTOWqECaM4K08S9ZrIg", "vqVg9oljZl3AjvyleCGqLOYkhmYrxu", "amhtUlMIP3hZuFCKepG62aSokShv2UYv", "BTFyXEOVMEP0nOw0jY0q9zOCSLZ2OeYc", "tcCWg0XVw1JTHEC59N6ZXoklrHSl9wSv"};
    public final /* synthetic */ B0 A00;

    static {
        A01();
    }

    public TK(B0 b11) {
        this.A00 = b11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 51);
            String[] strArr = A02;
            if (strArr[0].charAt(0) == strArr[7].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "WujDwNVbN3bAuExlfya79vhQsxgnNgQM";
            strArr2[5] = "dVRJVduTnq2Mgx4vxcEM2Hhpe9jWwRq5";
            bArrCopyOfRange[i14] = b11;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{91, 90, 44, 111, 126, 109, Ascii.DEL, 100, 105, 104, 87, 69, 66, Ascii.DEL, 86, 73, 69, 87};
    }

    @Override // com.facebook.ads.redexgen.uinode.PA
    public final void ACl() {
        C1794Ym c1794YmA00 = AbstractC11227e.A00();
        if (c1794YmA00 != null) {
            c1794YmA00.A07().A9a(A00(10, 8, 19), C8A.A2e, new C8B(A00(0, 10, 63)));
        }
    }
}
