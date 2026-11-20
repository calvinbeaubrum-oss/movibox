package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class HV {
    public static byte[] A00;

    static {
        A03();
    }

    public static long A00(HU hu2) {
        return hu2.A5p(A02(0, 7, 70), -1L);
    }

    public static Uri A01(HU hu2) {
        String strA5r = hu2.A5r(A02(7, 9, 12), null);
        if (strA5r == null) {
            return null;
        }
        return Uri.parse(strA5r);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{64, 93, 74, 122, 73, 64, 75, 10, Ascii.ETB, 0, 48, Ascii.GS, 10, Ascii.VT, 6, Ascii.GS};
    }

    public static void A04(HW hw2) {
        hw2.A01(A02(7, 9, 12));
    }

    public static void A05(HW hw2, long j11) {
        hw2.A02(A02(0, 7, 70), j11);
    }

    public static void A06(HW hw2, Uri uri) {
        hw2.A03(A02(7, 9, 12), uri.toString());
    }
}
