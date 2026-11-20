package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TF extends KT {
    public static byte[] A02;
    public final /* synthetic */ P3 A00;
    public final /* synthetic */ AnonymousClass93 A01;

    static {
        A02();
    }

    public TF(P3 p11, AnonymousClass93 anonymousClass93) {
        this.A00 = p11;
        this.A01 = anonymousClass93;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 46);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{93, 106, 121, 121, 122, 109, 118, 113, 120, Utf8.REPLACEMENT_BYTE, 118, 113, 123, 122, 121, 118, 113, 118, 107, 122, 115, 102};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (this.A00.A0D.getState() == RB.A02 && this.A00.A0D.getCurrentPositionInMillis() == A00()) {
            this.A00.A0I(A00(0, 22, 49));
        }
    }
}
