package com.facebook.ads.redexgen.uinode;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class LM {
    public static byte[] A00;

    static {
        A03();
    }

    public static PackageInfo A00(C11237f c11237f) {
        return A01(c11237f, A02(0, 19, 59));
    }

    public static PackageInfo A01(C11237f c11237f, String str) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = c11237f.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ WebSocketProtocol.PAYLOAD_SHORT);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{38, 42, 40, 107, 35, 36, 38, 32, 39, 42, 42, 46, 107, 46, 36, 49, 36, 43, 36};
    }

    public static boolean A04(C11237f c11237f, String str) {
        return A01(c11237f, str) != null;
    }
}
