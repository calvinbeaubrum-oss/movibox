package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxInterstitialAd implements MaxFullscreenAdImpl.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference f24954b = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f24955a;

    public MaxInterstitialAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxInterstitialAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxInterstitialAd", "MaxInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
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
            f24954b = new WeakReference((Activity) context);
        }
        this.f24955a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", appLovinSdk.a(), context);
    }

    public void destroy() {
        this.f24955a.logApiCall("destroy()");
        this.f24955a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b
    public Activity getActivity() {
        this.f24955a.logApiCall("getActivity()");
        return (Activity) f24954b.get();
    }

    public String getAdUnitId() {
        return this.f24955a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f24955a.isReady();
        this.f24955a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f24955a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f24955a.logApiCall("loadAd()");
        this.f24955a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f24955a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f24955a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(@Nullable MaxAdExpirationListener maxAdExpirationListener) {
        this.f24955a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f24955a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f24955a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f24955a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.f24955a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f24955a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f24955a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f24955a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f24955a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f24955a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f24955a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f24955a.setRevenueListener(maxAdRevenueListener);
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
        this.f24955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        yp.b(str2, "MaxInterstitialAd");
        this.f24955a.showAd(str, str2, getActivity());
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f24955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        yp.b(str2, "MaxInterstitialAd");
        this.f24955a.showAd(str, str2, activity);
    }

    @Deprecated
    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f24955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f24955a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f24955a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f24955a.showAd(str, str2, viewGroup, lifecycle, activity);
    }

    public String toString() {
        return "" + this.f24955a;
    }
}
