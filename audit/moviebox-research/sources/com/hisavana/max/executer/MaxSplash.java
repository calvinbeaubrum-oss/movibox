package com.hisavana.max.executer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.max.check.ExistsCheck;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MaxSplash extends BaseSplash {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaxAppOpenAd f41832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MaxAdListener f41833k;

    public MaxSplash(Context context, Network network) {
        super(context, network);
    }

    public final /* synthetic */ void b(AppLovinSdkConfiguration appLovinSdkConfiguration) {
        MaxAppOpenAd maxAppOpenAd = this.f41832j;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.loadAd();
        } else {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with appOpenAd == null"));
        }
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f41833k = null;
        MaxAppOpenAd maxAppOpenAd = this.f41832j;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.setListener(null);
            this.f41832j.destroy();
            this.f41832j = null;
        }
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseSplash
    public View getSplash() {
        Network network;
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onSplashLoad");
        WeakReference<Context> weakReference = this.mContext;
        Context context = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        if (context == null || (network = this.mNetwork) == null || TextUtils.isEmpty(network.getCodeSeatId()) || TextUtils.isEmpty(this.mNetwork.getApplicationId()) || ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId()) == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with mNetwork == null"));
            return null;
        }
        String codeSeatId = this.mNetwork.getCodeSeatId();
        AppLovinSdk appLovinSdk = ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId());
        Objects.requireNonNull(appLovinSdk);
        this.f41832j = new MaxAppOpenAd(codeSeatId, appLovinSdk);
        MaxAdListener maxAdListener = new MaxAdListener() { // from class: com.hisavana.max.executer.MaxSplash.1
            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                MaxSplash.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdClick");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "MaxAd --> onAdDisplayFailed");
                if (maxError != null) {
                    MaxSplash.this.onAdShowError(new TAdErrorCode(maxError.getCode(), "MaxAd --> onAdDisplayFailed"));
                } else {
                    MaxSplash.this.onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                MaxSplash.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdShowed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                MaxSplash.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdDismissed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                if (maxError == null) {
                    MaxSplash.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                MaxSplash.this.adFailedToLoad(new TAdErrorCode(maxError.getCode(), "Max Ads failed to load ad with error message: " + maxError.getMessage()));
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max onError max code：" + maxError.getCode() + "，message：" + maxError.getMessage());
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                if (maxAd == null) {
                    MaxSplash.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                try {
                    double revenue = maxAd.getRevenue();
                    if (revenue > 0.0d) {
                        MaxSplash.this.setEcpmPrice(100.0d * revenue * 1000.0d);
                    }
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onAdLoad，max price:" + revenue);
                } catch (Exception e11) {
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, Log.getStackTraceString(e11));
                }
                MaxSplash.this.adLoaded();
            }
        };
        this.f41833k = maxAdListener;
        this.f41832j.setListener(maxAdListener);
        if (f.a() != null) {
            return new View(f.a().getApplicationContext());
        }
        return null;
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashShow() {
        MaxAppOpenAd maxAppOpenAd = this.f41832j;
        if (maxAppOpenAd != null && maxAppOpenAd.isReady()) {
            this.f41832j.showAd();
        } else {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Max Ads failed to show"));
            AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads failed to show");
        }
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashStartLoad() {
        ExistsCheck.initAdSource(new AppLovinSdk.SdkInitializationListener() { // from class: com.hisavana.max.executer.d
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public final void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                this.f41844a.b(appLovinSdkConfiguration);
            }
        });
    }
}
