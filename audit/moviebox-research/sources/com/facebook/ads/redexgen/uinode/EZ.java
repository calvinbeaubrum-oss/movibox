package com.facebook.ads.redexgen.uinode;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EZ extends ZG {
    public QB A00;

    public final void A04(C1795Yn c1795Yn, NativeBannerAd nativeBannerAd, JR jr2, NativeAdLayout nativeAdLayout) {
        MediaView mediaView = new MediaView(nativeAdLayout.getContext());
        AdOptionsView adOptionsView = new AdOptionsView(nativeAdLayout.getContext(), nativeBannerAd, nativeAdLayout);
        jr2.A09(adOptionsView, 20);
        this.A00 = new SI(c1795Yn, nativeBannerAd, jr2, V2.A0L(nativeBannerAd.getInternalNativeAd()).A17(), mediaView, adOptionsView);
        AbstractC1462Lo.A0M(nativeAdLayout, jr2.A00());
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, mediaView, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.C10725a, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
