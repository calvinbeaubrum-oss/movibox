package com.facebook.ads.redexgen.uinode;

import android.view.View;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PU implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1653Sx A00;

    static {
        A01();
    }

    public PU(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{41, 50, 50, 49, Utf8.REPLACEMENT_BYTE, 60, 47};
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0K) {
                return;
            }
            this.A00.A0H.A02(A00(0, 7, 124));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
