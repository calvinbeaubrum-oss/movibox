package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC09931x {
    public static byte[] A00;

    static {
        A02();
    }

    public static AdSettings.IntegrationErrorMode A00(C1795Yn c1795Yn) {
        AdSettings.IntegrationErrorMode integrationErrorMode = (AdSettings.IntegrationErrorMode) AdInternalSettings.sSettingsBundle.getSerializable(A01(0, 30, 95));
        if (integrationErrorMode == null) {
            integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
        }
        return (integrationErrorMode != AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE || A03(c1795Yn)) ? integrationErrorMode : AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CALLBACK_MODE;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{59, 58, 36, 55, 33, 38, 60, 45, 47, 58, 41, 60, 33, 39, 38, 55, 45, 58, 58, 39, 58, 55, 37, 39, 44, 45, 55, 35, 45, 49};
    }

    public static boolean A03(C1795Yn c1795Yn) {
        return (c1795Yn.getApplicationInfo().flags & 2) != 0;
    }
}
