package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.NativeAdLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1489Mp {
    public static String[] A00 = {"Mh7OQPY25mJ4xZdJdnJU4lIWxnSb2W80", "uMvQGqYS2R9kLiwAhxbB5gyg9uPLoFmG", "JD8RnvPxGeaTxsc34jN0O6vhnDfoaLvm", "v", "yiVoJ6", "bh6EDcFJy1WMlrC6ew5uNV", "HsXTYL", CampaignEx.JSON_KEY_AD_K};
    public static final int A01 = (int) (LD.A02 * 200.0f);
    public static final int A03 = (int) (LD.A02 * 200.0f);
    public static final int A02 = (int) (LD.A02 * 50.0f);

    public static AnonymousClass13 A00(NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return AnonymousClass13.A05;
        }
        return A03(nativeAdLayout) ? AnonymousClass13.A06 : AnonymousClass13.A04;
    }

    public static AbstractC1488Mo A01(C1795Yn c1795Yn, J2 j11, String str, NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return null;
        }
        int width = nativeAdLayout.getWidth();
        int height = nativeAdLayout.getHeight();
        int i11 = A01;
        if (width >= i11 && height >= i11) {
            return new U4(c1795Yn, j11, str);
        }
        if (width < A03 || height < A02) {
            return null;
        }
        return new U5(c1795Yn, j11, str);
    }

    public static U6 A02(C1795Yn c1795Yn, J2 j11, String str, C09701a c09701a, MD md2, MC mc2) {
        return new U6(c1795Yn, j11, str, c09701a, md2, mc2);
    }

    public static boolean A03(NativeAdLayout nativeAdLayout) {
        int width = nativeAdLayout.getWidth();
        int height = nativeAdLayout.getHeight();
        int i11 = A01;
        if (width < i11 || height < i11) {
            if (width >= A03) {
                int i12 = A02;
                if (A00[5].length() != 22) {
                    throw new RuntimeException();
                }
                A00[5] = "hhrIY4o6fKEkU42z4UVpb3";
                if (height < i12) {
                }
            }
            return true;
        }
        return false;
    }
}
