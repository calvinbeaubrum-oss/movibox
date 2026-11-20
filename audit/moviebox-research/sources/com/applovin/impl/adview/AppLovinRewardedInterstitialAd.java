package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinRewardedInterstitialAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinIncentivizedInterstitial f17505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinAdDisplayListener f17506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinAdClickListener f17507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdVideoPlaybackListener f17508d;

    public AppLovinRewardedInterstitialAd(AppLovinSdk appLovinSdk) {
        this.f17505a = new AppLovinIncentivizedInterstitial(appLovinSdk);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f17507c = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f17506b = appLovinAdDisplayListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f17508d = appLovinAdVideoPlaybackListener;
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f17505a.show(appLovinAd, context, appLovinAdRewardListener, this.f17508d, this.f17506b, this.f17507c);
    }

    public String toString() {
        return "AppLovinRewardedInterstitialAd{}";
    }
}
