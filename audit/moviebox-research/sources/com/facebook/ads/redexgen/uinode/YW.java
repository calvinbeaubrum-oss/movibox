package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YW implements KZ {
    public static byte[] A01;
    public final /* synthetic */ C1794Ym A00;

    static {
        A01();
    }

    public YW(C1794Ym c1794Ym) {
        this.A00 = c1794Ym;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{68, 64, 67, 119, 102, 107, 103, 108, 97, 103, 76, 103, 118, 117, 109, 112, 105, Ascii.SI, 52, Utf8.REPLACEMENT_BYTE, 34, 42, Utf8.REPLACEMENT_BYTE, 57, 46, Utf8.REPLACEMENT_BYTE, 62, 122, Utf8.REPLACEMENT_BYTE, 40, 40, 53, 40, 116, 121, 104, 123, 105, 114, 69, 105, 114, 115, Ascii.DEL, 118, 126};
    }

    @Override // com.facebook.ads.redexgen.uinode.KZ
    public final void A9S(int i11, Throwable th2) {
        Log.e(A00(0, 17, 13), A00(17, 17, 85), th2);
        this.A00.A07().A9a(A00(34, 12, 21), i11, new C8B(th2));
    }
}
