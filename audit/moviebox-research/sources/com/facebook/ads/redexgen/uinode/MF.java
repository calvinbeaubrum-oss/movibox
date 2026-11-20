package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MF implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ ViewOnClickListenerC1223Bi A00;

    static {
        A01();
    }

    public MF(ViewOnClickListenerC1223Bi viewOnClickListenerC1223Bi) {
        this.A00 = viewOnClickListenerC1223Bi;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{62, 56, 46, 57, Ascii.DC4, 41, 62, 45, 45, 46, 57, 46, 47, Ascii.DC4, 40, 39, 34, 40, 32, Ascii.DC4, 42, 45, Utf8.REPLACEMENT_BYTE, 46, 57, Ascii.DC4, 47, 46, 39, 42, 50};
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0H(A00(0, 31, 125));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
