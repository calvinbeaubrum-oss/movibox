package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1189Aa extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public C1189Aa(int i11, int i12, int i13) {
        super(A00(27, 18, 32) + i11 + A00(0, 5, 100) + i12 + A00(5, 22, 3) + i13);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ Worker.WHAT_SYNC_DATA);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{35, 75, 121, 47, 35, 68, 7, Ascii.FF, 5, 10, 10, 1, 8, Ascii.ETB, 68, Ascii.CR, 10, 68, 1, 10, 7, Ascii.VT, 0, Ascii.CR, 10, 3, 68, Ascii.DC2, 41, 47, 38, 41, 35, 43, 34, 35, 103, 33, 40, 53, 42, 38, 51, 125, 103};
    }
}
