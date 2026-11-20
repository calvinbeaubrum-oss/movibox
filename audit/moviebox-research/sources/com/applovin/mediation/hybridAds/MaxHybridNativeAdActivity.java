package com.applovin.mediation.hybridAds;

import android.os.Bundle;
import com.applovin.impl.bd;
import com.applovin.impl.cd;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.j;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxHybridNativeAdActivity extends bd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxNativeAdView f24963f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f24964a;

        public a(MaxNativeAd maxNativeAd) {
            this.f24964a = maxNativeAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f24964a.prepareForInteraction(MaxHybridNativeAdActivity.this.f24963f.getClickableViews(), MaxHybridNativeAdActivity.this.f24963f)) {
                return;
            }
            this.f24964a.prepareViewForInteraction(MaxHybridNativeAdActivity.this.f24963f);
        }
    }

    public void a(cd cdVar, MaxNativeAd maxNativeAd, j jVar, MaxAdapterListener maxAdapterListener) {
        super.a(cdVar, jVar, maxAdapterListener);
        MaxNativeAdView maxNativeAdView = new MaxNativeAdView(maxNativeAd, new MaxNativeAdViewBinder.Builder(R.layout.max_hybrid_native_ad_view).setTitleTextViewId(R.id.applovin_native_title_text_view).setBodyTextViewId(R.id.applovin_native_body_text_view).setAdvertiserTextViewId(R.id.applovin_native_advertiser_text_view).setIconImageViewId(R.id.applovin_native_icon_image_view).setMediaContentViewGroupId(R.id.applovin_native_media_content_view).setOptionsContentViewGroupId(R.id.applovin_native_options_view).setCallToActionButtonId(R.id.applovin_native_cta_button).build(), this);
        this.f24963f = maxNativeAdView;
        maxNativeAdView.renderCustomNativeAdView(maxNativeAd);
        a aVar = new a(maxNativeAd);
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            runOnUiThread(aVar);
        } else {
            jVar.j0().a((yl) new jn(jVar, "MaxHybridNativeAdPrepareForInteraction", aVar), tm.b.MEDIATION);
        }
    }

    @Override // com.applovin.impl.bd, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.f24963f, "MaxHybridNativeAdActivity");
    }
}
