package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10815j implements NativeAdScrollViewApi {
    public static byte[] A07;
    public final int A00;
    public final NativeAdScrollView.AdViewProvider A01;
    public final NativeAdView.Type A02;
    public final NativeAdViewAttributes A03;
    public final NativeAdsManager A04;
    public final ZE A05;
    public final C1795Yn A06;

    static {
        A07();
    }

    public C10815j(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, NativeAdScrollView.AdViewProvider adViewProvider, int i11, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i12) {
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException(A06(74, 27, 39));
        }
        if (type == null && adViewProvider == null && i11 <= 0) {
            throw new IllegalArgumentException(A06(0, 74, 85));
        }
        this.A06 = C10745c.A03(context);
        this.A04 = nativeAdsManager;
        this.A03 = nativeAdViewAttributes;
        this.A01 = adViewProvider;
        this.A02 = type;
        this.A00 = i12;
        ZF zf2 = new ZF(this);
        ZE ze2 = new ZE(context);
        this.A05 = ze2;
        if (type != null) {
            ze2.A00((int) (LD.A02 * type.getHeight()));
        } else if (i11 > 0) {
            ze2.A00(((int) LD.A02) * i11);
        }
        ze2.setAdapter(zf2);
        setInset(20);
        zf2.A09();
        nativeAdScrollView.addView(ze2);
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-61, -21, -23, -22, -106, -26, -24, -27, -20, -33, -38, -37, -106, -41, -106, -60, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -92, -54, -17, -26, -37, -94, -106, -73, -38, -52, -33, -37, -19, -58, -24, -27, -20, -33, -38, -37, -24, -106, -27, -24, -106, -41, -106, -28, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -66, -37, -33, -35, -34, -22, -70, -26, -106, -87, -68, -79, -66, -83, -119, -84, -69, -107, -87, -74, -87, -81, -83, -70, 104, -74, -73, -68, 104, -76, -73, -87, -84, -83, -84};
    }

    @Override // com.facebook.ads.internal.api.NativeAdScrollViewApi
    public final void setInset(int i11) {
        if (i11 > 0) {
            float f11 = LD.A02;
            int iRound = Math.round(i11 * f11);
            this.A05.setPadding(iRound, 0, iRound, 0);
            this.A05.setPageMargin(Math.round((i11 / 2) * f11));
            this.A05.setClipToPadding(false);
        }
    }
}
