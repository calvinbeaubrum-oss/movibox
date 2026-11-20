package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1948bt {
    public static byte[] A00;
    public static final C1947bs A01;
    public static final GK[] A02;

    static {
        C1947bs c1947bs;
        try {
            A02();
            c1947bs = (C1947bs) Class.forName(A00(0, 49, 52)).newInstance();
        } catch (ClassCastException unused) {
            c1947bs = null;
        } catch (ClassNotFoundException unused2) {
            c1947bs = null;
        } catch (IllegalAccessException unused3) {
            c1947bs = null;
        } catch (InstantiationException unused4) {
            c1947bs = null;
        }
        if (c1947bs == null) {
            c1947bs = new C1947bs();
        }
        A01 = c1947bs;
        A02 = new GK[0];
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A01(AbstractC11106o abstractC11106o) {
        return A01.A03(abstractC11106o);
    }

    public static void A02() {
        A00 = new byte[]{-2, 2, 7, -1, -4, 1, -63, 5, -8, -7, -1, -8, -10, 7, -63, -3, 9, 0, -63, -4, 1, 7, -8, 5, 1, -12, -1, -63, -27, -8, -7, -1, -8, -10, 7, -4, 2, 1, -39, -12, -10, 7, 2, 5, Ascii.FF, -36, 0, 3, -1};
    }
}
