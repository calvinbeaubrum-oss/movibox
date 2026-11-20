package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdExperienceType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C2G {
    public static byte[] A00;

    static {
        A03();
    }

    public static AdExperienceType A00(String str) {
        if (str == null) {
            return null;
        }
        if (A01(0, 33, 10).equals(str)) {
            return AdExperienceType.AD_EXPERIENCE_TYPE_INTERSTITIAL;
        }
        return A01(33, 42, 97).equals(str) ? AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL : AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(AdExperienceType adExperienceType) {
        return adExperienceType.getAdExperienceType();
    }

    public static void A03() {
        A00 = new byte[]{-126, -123, -128, -122, -103, -111, -122, -109, -118, -122, -113, -124, -122, -128, -124, -112, -113, -121, -118, -120, -128, -118, -113, -107, -122, -109, -108, -107, -118, -107, -118, -126, -115, -39, -36, -41, -35, -16, -24, -35, -22, -31, -35, -26, -37, -35, -41, -37, -25, -26, -34, -31, -33, -41, -22, -35, -17, -39, -22, -36, -35, -36, -41, -31, -26, -20, -35, -22, -21, -20, -31, -20, -31, -39, -28};
    }
}
