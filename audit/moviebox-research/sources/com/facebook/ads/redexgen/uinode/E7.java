package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E7 implements Runnable {
    public static byte[] A01;
    public static String[] A02 = {"trtHxdWfI8aUUasJnLCFOWNhTEgT5SfR", "ildDLLQ3Py5XZqRSamTTI6YoT50zpskF", "dVw5UxmZMKob3SUb3uvB6OES0lFAFJfM", "IR8fXYoB6j0jxnrkbU78JZ5o5XE94BNQ", "b3RCFjVWO3b8eRQaxF9", "jCTIeE11ZTJ65IoFy1xYkV7ELZ3vCqIN", "TgSfnKfrSSedvNLmmcoIbwvrw3BnVtDY", "eNW8IuS2yi6nO7dU30TIFIzk8f1M77f"};
    public final /* synthetic */ EG A00;

    static {
        A01();
    }

    public E7(EG eg2) {
        this.A00 = eg2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = (bArrCopyOfRange[i14] ^ i13) ^ 26;
            if (A02[0].charAt(19) == 't') {
                throw new RuntimeException();
            }
            A02[6] = "Wfj4XOUJd4uRzIFmDg2tyEJWBqTNOatQ";
            bArrCopyOfRange[i14] = (byte) i15;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{76, 110, 121, 100, 98, 99, 45, 107, 100, 97, 104, 45, 97, 98, 108, 105, 100, 99, 106, 45, 107, 108, 100, 97, 104, 105, 35, Ascii.FF, 39, Utf8.REPLACEMENT_BYTE, 38, 36, 39, 41, 44, 5, 41, 38, 41, 47, 45, 58};
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        DownloadAction[] downloadActionArrA03;
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                downloadActionArrA03 = this.A00.A09.A03(this.A00.A0E);
            } catch (Throwable th2) {
                Log.e(A00(27, 15, 82), A00(0, 27, 23), th2);
                downloadActionArrA03 = new DownloadAction[0];
            }
            this.A00.A07.post(new E6(this, downloadActionArrA03));
        } catch (Throwable th3) {
            KL.A00(th3, this);
        }
    }
}
