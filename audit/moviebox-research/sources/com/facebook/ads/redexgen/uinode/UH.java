package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class UH implements L8 {
    public static byte[] A01;
    public final /* synthetic */ UD A00;

    static {
        A01();
    }

    public UH(UD ud2) {
        this.A00 = ud2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{108, 120, 121, 98, 110, 97, 100, 110, 102};
    }

    @Override // com.facebook.ads.redexgen.uinode.L8
    public final void ABA() {
        if (this.A00.A0A || this.A00.A09) {
            return;
        }
        this.A00.A0U(false, A00(0, 9, 108));
    }

    @Override // com.facebook.ads.redexgen.uinode.L8
    public final void ACm(float f11) {
    }
}
