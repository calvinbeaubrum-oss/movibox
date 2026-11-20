package com.applovin.mediation.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAppOpenAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f24953a;

    public MaxAppOpenAd(@NonNull String str, @NonNull Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxAppOpenAd(@NonNull String str, @NonNull AppLovinSdk appLovinSdk) {
        this(str, appLovinSdk, j.l());
    }

    private MaxAppOpenAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        this.f24953a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, null, "MaxAppOpenAd", appLovinSdk.a(), context);
    }

    public void destroy() {
        this.f24953a.logApiCall("destroy()");
        this.f24953a.destroy();
    }

    @NonNull
    public String getAdUnitId() {
        return this.f24953a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f24953a.isReady();
        this.f24953a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f24953a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f24953a.logApiCall("loadAd()");
        this.f24953a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f24953a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f24953a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f24953a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f24953a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(@NonNull String str, @Nullable String str2) {
        this.f24953a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f24953a.setExtraParameter(str, str2);
    }

    public void setListener(@Nullable MaxAdListener maxAdListener) {
        this.f24953a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f24953a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(@NonNull String str, @Nullable Object obj) {
        this.f24953a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f24953a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f24953a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f24953a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(@Nullable MaxAdRevenueListener maxAdRevenueListener) {
        this.f24953a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f24953a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd(null);
    }

    public void showAd(@Nullable String str) {
        showAd(str, null);
    }

    public void showAd(@Nullable String str, @Nullable String str2) {
        this.f24953a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        yp.b(str2, "MaxAppOpenAd");
        this.f24953a.showAd(str, str2, null);
    }

    @NonNull
    public String toString() {
        return "" + this.f24953a;
    }
}
