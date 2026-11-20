package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class T0 extends KT {
    public static byte[] A01;
    public final /* synthetic */ C1653Sx A00;

    static {
        A02();
    }

    public T0(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{35, 54, 49, 50, 60, -19, 68, 46, 64, -19, 59, 50, 67, 50, Utf8.REPLACEMENT_BYTE, -19, 61, Utf8.REPLACEMENT_BYTE, 50, 61, 46, Utf8.REPLACEMENT_BYTE, 50, 49};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (this.A00.A0S) {
            return;
        }
        this.A00.A0X.ADX(A00(0, 24, 79));
    }
}
