package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardedVideoAd;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1447Kz {
    public static byte[] A00;

    static {
        A04();
    }

    public static int A00(C1795Yn c1795Yn, int i11) {
        return KE.A00(c1795Yn).getInt(A01(0, 21, 2), i11);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(C1795Yn c1795Yn, String str) {
        int iA00 = A00(c1795Yn, -1);
        if (iA00 == -1) {
            return null;
        }
        try {
            return new ExtraHints.Builder().extraData(A03(str, A01(47, 14, 49), Integer.valueOf(iA00))).build().getHints();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String A03(String str, String str2, Object obj) throws JSONException {
        String strA01 = A01(61, 2, 86);
        if (str != null) {
            strA01 = new JSONObject(str).getJSONObject(A01(42, 5, 31)).optString(A01(32, 10, 91), strA01);
        }
        JSONObject jSONObject = new JSONObject(strA01);
        jSONObject.put(str2, obj);
        return jSONObject.toString();
    }

    public static void A04() {
        A00 = new byte[]{121, 123, 110, 111, -120, 119, 126, 118, -120, 106, 109, 124, -120, 119, 120, -120, 108, 113, 106, 114, 119, -71, -73, -55, -71, -73, -70, -69, -70, -75, -73, -70, -25, -6, -10, -12, -29, -31, -26, -29, -10, -29, -82, -81, -76, -70, -71, -58, -57, -58, -69, -64, -71, -63, -58, -67, -68, -73, -71, -68, -53, -8, -6};
    }

    public static boolean A05(String str) throws JSONException {
        return str != null && new JSONObject(new JSONObject(str).getJSONObject(A01(42, 5, 31)).optString(A01(32, 10, 91), A01(61, 2, 86))).optBoolean(A01(21, 11, 47), false);
    }

    public final InterstitialAd A06(C1795Yn c1795Yn, String str, String str2) {
        if (c1795Yn == null) {
            return null;
        }
        try {
            InterstitialAd interstitialAd = new InterstitialAd(c1795Yn, str);
            interstitialAd.setExtraHints(new ExtraHints.Builder().extraData(A03(str2, A01(21, 11, 47), true)).build());
            return interstitialAd;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final RewardedVideoAd A07(C1795Yn c1795Yn, String str, String str2) {
        if (c1795Yn == null) {
            return null;
        }
        try {
            RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(c1795Yn, str);
            rewardedVideoAd.setExtraHints(new ExtraHints.Builder().extraData(A03(str2, A01(21, 11, 47), true)).build());
            return rewardedVideoAd;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void A08(C1795Yn c1795Yn, boolean z11) {
        String strA01 = A01(0, 21, 2);
        KE.A00(c1795Yn).edit().putInt(strA01, z11 ? 0 : KE.A00(c1795Yn).getInt(strA01, 0) + 1).apply();
    }

    public final boolean A09(C1795Yn c1795Yn, String str, int i11) {
        if (i11 <= 0) {
            return false;
        }
        try {
            return !A05(str) && A00(c1795Yn, i11 + (-1)) >= i11 + (-1);
        } catch (JSONException unused) {
        }
        return false;
    }
}
