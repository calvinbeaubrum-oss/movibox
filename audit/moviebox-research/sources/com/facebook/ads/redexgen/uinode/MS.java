package com.facebook.ads.redexgen.uinode;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MS implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ UD A00;

    static {
        A01();
    }

    public MS(UD ud2) {
        this.A00 = ud2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{43, 41, Ascii.ESC, 40, Ascii.EM, 34, Ascii.US, Ascii.EM, 33};
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0U(false, A00(0, 9, 121));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
