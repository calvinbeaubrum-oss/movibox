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
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxRewardedAd implements MaxFullscreenAdImpl.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f24956b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f24957c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakReference f24958d = new WeakReference(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f24959a;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk, Context context) {
        this.f24959a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.a(), context);
    }

    public static MaxRewardedAd getInstance(String str, Context context) {
        return getInstance(str, AppLovinSdk.getInstance(context), context);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
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
            f24958d = new WeakReference((Activity) context);
        }
        synchronized (f24957c) {
            try {
                Map map = f24956b;
                MaxRewardedAd maxRewardedAd = (MaxRewardedAd) map.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk, context);
                map.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void destroy() {
        this.f24959a.logApiCall("destroy()");
        synchronized (f24957c) {
            f24956b.remove(this.f24959a.getAdUnitId());
        }
        this.f24959a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b
    public Activity getActivity() {
        this.f24959a.logApiCall("getActivity()");
        return (Activity) f24958d.get();
    }

    public String getAdUnitId() {
        return this.f24959a.getAdUnitId();
    }

    public boolean isReady() {
        boolean zIsReady = this.f24959a.isReady();
        this.f24959a.logApiCall("isReady() " + zIsReady + " for ad unit id " + this.f24959a.getAdUnitId());
        return zIsReady;
    }

    public void loadAd() {
        this.f24959a.logApiCall("loadAd()");
        this.f24959a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f24959a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f24959a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(@Nullable MaxAdExpirationListener maxAdExpirationListener) {
        this.f24959a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f24959a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f24959a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f24959a.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.f24959a.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f24959a.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f24959a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f24959a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f24959a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f24959a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f24959a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f24959a.setRevenueListener(maxAdRevenueListener);
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
        this.f24959a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        yp.b(str2, "MaxRewardedAd");
        this.f24959a.showAd(str, str2, getActivity());
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f24959a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        yp.b(str2, "MaxRewardedAd");
        this.f24959a.showAd(str, str2, activity);
    }

    @Deprecated
    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f24959a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f24959a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f24959a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f24959a.showAd(str, str2, viewGroup, lifecycle, activity);
    }

    public String toString() {
        return "" + this.f24959a;
    }
}
