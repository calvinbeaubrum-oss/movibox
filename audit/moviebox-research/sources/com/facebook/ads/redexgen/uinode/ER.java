package com.facebook.ads.redexgen.uinode;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ER extends ZG {
    public QB A00;

    public final void A04(NativeAdLayout nativeAdLayout, C1795Yn c1795Yn, NativeAd nativeAd, JR jr2) {
        O3 o11 = new O3(c1795Yn);
        MediaView mediaView = new MediaView(c1795Yn);
        AdOptionsView adOptionsView = new AdOptionsView(c1795Yn, nativeAd, nativeAdLayout);
        jr2.A09(adOptionsView, 28);
        this.A00 = new SH(c1795Yn, nativeAd, jr2, V2.A0L(nativeAd.getInternalNativeAd()).A17(), o11, mediaView, adOptionsView);
        AbstractC1462Lo.A0M(nativeAdLayout, jr2.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, o11, this.A00.getViewsForInteraction());
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
