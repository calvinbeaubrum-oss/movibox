package com.hisavana.max.executer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.cloud.sdk.commonutil.util.n;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.max.check.ExistsCheck;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MaxInterstitial extends BaseInterstitial {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaxInterstitialAd f41826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MaxAdListener f41827k;

    public MaxInterstitial(Context context, Network network) {
        super(context, network);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j11, AppLovinSdkConfiguration appLovinSdkConfiguration) {
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "interstitial onSdkInitialized time:" + (System.currentTimeMillis() - j11));
        MaxInterstitialAd maxInterstitialAd = this.f41826j;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.loadAd();
        } else {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with interstitialAd == null"));
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f41827k = null;
        MaxInterstitialAd maxInterstitialAd = this.f41826j;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.setListener(null);
            this.f41826j.destroy();
            this.f41826j = null;
        }
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        Network network;
        WeakReference<Context> weakReference = this.mContext;
        Context context = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        Activity activityC = n.c();
        if (context == null || activityC == null || (network = this.mNetwork) == null || TextUtils.isEmpty(network.getCodeSeatId()) || TextUtils.isEmpty(this.mNetwork.getApplicationId()) || ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId()) == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with params == null"));
            return;
        }
        String codeSeatId = this.mNetwork.getCodeSeatId();
        AppLovinSdk appLovinSdk = ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId());
        Objects.requireNonNull(appLovinSdk);
        this.f41826j = new MaxInterstitialAd(codeSeatId, appLovinSdk, activityC);
        MaxAdListener maxAdListener = new MaxAdListener() { // from class: com.hisavana.max.executer.MaxInterstitial.1
            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                MaxInterstitial.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdClick");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "MaxAd --> onAdDisplayFailed");
                if (maxError != null) {
                    MaxInterstitial.this.onAdShowError(new TAdErrorCode(maxError.getCode(), maxError.getMessage()));
                } else {
                    MaxInterstitial.this.onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "MaxAd --> onAdDisplayFailed"));
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                MaxInterstitial.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdShowed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                MaxInterstitial.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdDismissed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                if (maxError == null) {
                    MaxInterstitial.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                MaxInterstitial.this.adFailedToLoad(new TAdErrorCode(maxError.getCode(), "Max Ads failed to load ad with error message: " + maxError.getMessage()));
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max onError max code：" + maxError.getCode() + "，message：" + maxError.getMessage());
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                if (maxAd == null) {
                    MaxInterstitial.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                try {
                    double revenue = maxAd.getRevenue();
                    if (revenue > 0.0d) {
                        MaxInterstitial.this.setEcpmPrice(100.0d * revenue * 1000.0d);
                    }
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onAdLoad，max price:" + revenue);
                } catch (Exception e11) {
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, Log.getStackTraceString(e11));
                }
                MaxInterstitial.this.adLoaded();
            }
        };
        this.f41827k = maxAdListener;
        this.f41826j.setListener(maxAdListener);
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        return this.f41826j != null;
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        MaxInterstitialAd maxInterstitialAd = this.f41826j;
        if (maxInterstitialAd != null && maxInterstitialAd.isReady()) {
            this.f41826j.showAd();
        } else {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Max Ads failed to show"));
            AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads failed to show");
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ExistsCheck.initAdSource(new AppLovinSdk.SdkInitializationListener() { // from class: com.hisavana.max.executer.b
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public final void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                this.f41840a.b(jCurrentTimeMillis, appLovinSdkConfiguration);
            }
        });
    }
}
