package com.hisavana.max.executer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.cloud.sdk.commonutil.util.n;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.max.check.ExistsCheck;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MaxVideo extends BaseVideo {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaxRewardedAd f41835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MaxRewardedAdListener f41836k;

    public MaxVideo(Context context, Network network) {
        super(context, network);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdkConfiguration appLovinSdkConfiguration) {
        MaxRewardedAd maxRewardedAd = this.f41835j;
        if (maxRewardedAd != null) {
            maxRewardedAd.loadAd();
        } else {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with rewardedAd == null"));
        }
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f41836k = null;
        MaxRewardedAd maxRewardedAd = this.f41835j;
        if (maxRewardedAd != null) {
            maxRewardedAd.setListener(null);
            this.f41835j.destroy();
            this.f41835j = null;
        }
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        Network network;
        WeakReference<Context> weakReference = this.mContext;
        Context context = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        if (context == null || n.c() == null || (network = this.mNetwork) == null || TextUtils.isEmpty(network.getCodeSeatId()) || TextUtils.isEmpty(this.mNetwork.getApplicationId()) || ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId()) == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_SOURCE_INIT_FAILED, "Max Ads failed to load ad error with mNetwork == null"));
            return;
        }
        String codeSeatId = this.mNetwork.getCodeSeatId();
        AppLovinSdk appLovinSdk = ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId());
        Objects.requireNonNull(appLovinSdk);
        this.f41835j = MaxRewardedAd.getInstance(codeSeatId, appLovinSdk, n.c());
        MaxRewardedAdListener maxRewardedAdListener = new MaxRewardedAdListener() { // from class: com.hisavana.max.executer.MaxVideo.1
            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                MaxVideo.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdClick");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "MaxAd --> onAdDisplayFailed");
                if (maxError != null) {
                    MaxVideo.this.onAdShowError(new TAdErrorCode(maxError.getCode(), "MaxAd --> onAdDisplayFailed"));
                } else {
                    MaxVideo.this.onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                MaxVideo.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdShowed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                MaxVideo.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdDismissed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                if (maxError == null) {
                    MaxVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                MaxVideo.this.adFailedToLoad(new TAdErrorCode(maxError.getCode(), "Max Ads failed to load ad with error message: " + maxError.getMessage()));
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max onError max code：" + maxError.getCode() + "，message：" + maxError.getMessage());
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                if (maxAd == null) {
                    MaxVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                try {
                    double revenue = maxAd.getRevenue();
                    if (revenue > 0.0d) {
                        MaxVideo.this.setEcpmPrice(100.0d * revenue * 1000.0d);
                    }
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onAdLoad，max price:" + revenue);
                } catch (Exception e11) {
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, Log.getStackTraceString(e11));
                }
                MaxVideo.this.adLoaded();
            }

            @Override // com.applovin.mediation.MaxRewardedAdListener
            public void onRewardedVideoCompleted(MaxAd maxAd) {
            }

            @Override // com.applovin.mediation.MaxRewardedAdListener
            public void onRewardedVideoStarted(MaxAd maxAd) {
            }

            @Override // com.applovin.mediation.MaxRewardedAdListener
            public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
                MaxVideo.this.onReward();
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onUserEarnedReward");
            }
        };
        this.f41836k = maxRewardedAdListener;
        this.f41835j.setListener(maxRewardedAdListener);
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f41835j != null;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        MaxRewardedAd maxRewardedAd = this.f41835j;
        if (maxRewardedAd != null) {
            maxRewardedAd.showAd();
        } else {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "MAX Ads failed to show, rewardedAd is null"));
            AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads failed to show, pageRewardedAd is null");
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        ExistsCheck.initAdSource(new AppLovinSdk.SdkInitializationListener() { // from class: com.hisavana.max.executer.e
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public final void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                this.f41845a.b(appLovinSdkConfiguration);
            }
        });
    }
}
