package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxRewardedInterstitialAd implements MaxFullscreenAdImpl.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference f24960b = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f24961a;

    public MaxRewardedInterstitialAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxRewardedInterstitialAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxRewardedInterstitialAd", "MaxRewardedInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context instanceof Activity) {
            f24960b = new WeakReference((Activity) context);
        }
        this.f24961a = new MaxFullscreenAdImpl(str, MaxAdFormat.REWARDED_INTERSTITIAL, this, "MaxRewardedInterstitialAd", appLovinSdk.a(), context);
    }

    public void destroy() {
        this.f24961a.logApiCall("destroy()");
        this.f24961a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b
    public Activity getActivity() {
        this.f24961a.logApiCall("getActivity()");
        return (Activity) f24960b.get();
    }

    public boolean isReady() {
        boolean zIsReady = this.f24961a.isReady();
        this.f24961a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f24961a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f24961a.logApiCall("loadAd()");
        this.f24961a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f24961a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f24961a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(@Nullable MaxAdExpirationListener maxAdExpirationListener) {
        this.f24961a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f24961a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f24961a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f24961a.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.f24961a.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f24961a.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f24961a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f24961a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f24961a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f24961a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f24961a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f24961a.setRevenueListener(maxAdRevenueListener);
    }

    @Deprecated
    public void showAd() {
        showAd((String) null);
    }

    public void showAd(Activity activity) {
        showAd((String) null, activity);
    }

    @Deprecated
    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd((String) null, viewGroup, lifecycle);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd((String) null, viewGroup, lifecycle, activity);
    }

    @Deprecated
    public void showAd(String str) {
        showAd(str, (String) null);
    }

    public void showAd(String str, Activity activity) {
        showAd(str, (String) null, activity);
    }

    @Deprecated
    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(str, (String) null, viewGroup, lifecycle);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd(str, null, viewGroup, lifecycle, activity);
    }

    @Deprecated
    public void showAd(String str, String str2) {
        this.f24961a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        this.f24961a.showAd(str, str2, getActivity());
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f24961a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        this.f24961a.showAd(str, str2, activity);
    }

    @Deprecated
    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f24961a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f24961a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f24961a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f24961a.showAd(str, str2, viewGroup, lifecycle, activity);
    }

    public String toString() {
        return "" + this.f24961a;
    }
}
