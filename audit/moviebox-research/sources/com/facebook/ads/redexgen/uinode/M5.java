package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M5 {
    public static byte[] A00;
    public static final String A01;

    static {
        A01();
        A01 = M5.class.getSimpleName();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{100, -105, -126, -124, -113, -109, -120, -114, -115, Utf8.REPLACEMENT_BYTE, -120, -115, Utf8.REPLACEMENT_BYTE, -110, -126, -111, -124, -124, -115, Utf8.REPLACEMENT_BYTE, -120, -115, -109, -124, -111, -128, -126, -109, -120, -107, -124, Utf8.REPLACEMENT_BYTE, -126, -121, -124, -126, -118, 75, Utf8.REPLACEMENT_BYTE, -128, -110, -110, -108, -116, -120, -115, -122, Utf8.REPLACEMENT_BYTE, -120, -115, -109, -124, -111, -128, -126, -109, -120, -107, -124, 77, -103, -104, -96, -114, -101, -46, -55, -45, -53, -39};
    }

    public static boolean A02(C1795Yn c1795Yn) {
        return A03(c1795Yn) && M6.A03(c1795Yn);
    }

    public static boolean A03(C1795Yn c1795Yn) {
        if (c1795Yn == null) {
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) c1795Yn.getSystemService(A00(60, 5, 18));
            return Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e11) {
            Log.e(A01, A00(0, 60, 8), e11);
            c1795Yn.A07().A9a(A00(65, 5, 73), C8A.A2S, new C8B(e11));
            return true;
        }
    }
}
