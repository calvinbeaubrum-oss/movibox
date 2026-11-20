package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxNativeAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxNativeAdLoaderImpl f24980a;

    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        com.applovin.impl.mediation.ads.a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f24980a = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.f24980a.logApiCall("a()");
        this.f24980a.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.f24980a.logApiCall("b()");
        this.f24980a.handleNativeAdViewRendered(maxAd);
    }

    public void destroy() {
        this.f24980a.logApiCall("destroy()");
        this.f24980a.destroy();
    }

    public void destroy(MaxAd maxAd) {
        this.f24980a.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.f24980a.destroy(maxAd);
    }

    public String getAdUnitId() {
        return this.f24980a.getAdUnitId();
    }

    public String getPlacement() {
        this.f24980a.logApiCall("getPlacement()");
        return this.f24980a.getPlacement();
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        this.f24980a.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.f24980a.loadAd(maxNativeAdView);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        this.f24980a.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.f24980a.render(maxNativeAdView, maxAd);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f24980a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f24980a.setAdReviewListener(maxAdReviewListener);
    }

    public void setCustomData(String str) {
        this.f24980a.logApiCall("setCustomData(value=" + str + ")");
        this.f24980a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f24980a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f24980a.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f24980a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f24980a.setLocalExtraParameter(str, obj);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        this.f24980a.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.f24980a.setNativeAdListener(maxNativeAdListener);
    }

    public void setPlacement(String str) {
        this.f24980a.logApiCall("setPlacement(placement=" + str + ")");
        this.f24980a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f24980a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f24980a.setRevenueListener(maxAdRevenueListener);
    }
}
