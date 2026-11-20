package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1434Kk implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C1795Yn A00;

    static {
        A01();
    }

    public RunnableC1434Kk(C1795Yn c1795Yn) {
        this.A00 = c1795Yn;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{97, 122, 125, 98, 97, 99, 104, 99, 116, 111, 101};
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            C8B c8b = new C8B(A00(0, 4, 88));
            c8b.A05(1);
            c8b.A06(1);
            c8b.A0A(false);
            this.A00.A07().A9b(A00(4, 7, 112), C8A.A1Y, c8b);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
