package com.facebook.ads.redexgen.uinode;

import android.content.SharedPreferences;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6S {
    public static byte[] A00;

    static {
        A02();
    }

    public static SharedPreferences A00(C11237f c11237f) {
        return c11237f.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(9, 34, 105), c11237f), 0);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{45, 59, Ascii.DLE, 42, 55, 59, 61, 46, 60, 43, 39, 37, 102, 46, 41, 43, 45, 42, 39, 39, 35, 102, 41, 44, 59, 102, 33, 38, 60, 45, 58, 38, 41, 36, 102, 42, 60, 45, 48, 60, 58, 41, 59};
    }

    public final String A03(C11237f c11237f) {
        return A00(c11237f).getString(A01(0, 9, Worker.WHAT_QUIT), null);
    }

    public final void A04(C11237f c11237f, String str) {
        A00(c11237f).edit().putString(A01(0, 9, Worker.WHAT_QUIT), str).apply();
    }
}
