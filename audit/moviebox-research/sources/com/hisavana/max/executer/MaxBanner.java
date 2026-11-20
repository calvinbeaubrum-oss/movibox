package com.hisavana.max.executer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.max.check.ExistsCheck;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MaxBanner extends BaseBanner {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaxAdView f41822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f41823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MaxAdViewAdListener f41824l;

    public MaxBanner(Context context, Network network, int i11) {
        super(context, network);
        this.f41823k = i11;
        this.f41824l = new MaxAdViewAdListener() { // from class: com.hisavana.max.executer.MaxBanner.1
            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                MaxBanner.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdClick");
            }

            @Override // com.applovin.mediation.MaxAdViewAdListener
            public void onAdCollapsed(MaxAd maxAd) {
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "MaxAd --> onAdDisplayFailed");
                if (maxError != null) {
                    MaxBanner.this.onAdShowError(new TAdErrorCode(maxError.getCode(), "MaxAd --> onAdDisplayFailed"));
                } else {
                    MaxBanner.this.onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                MaxBanner.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdShowed");
            }

            @Override // com.applovin.mediation.MaxAdViewAdListener
            public void onAdExpanded(MaxAd maxAd) {
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                MaxBanner.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdDismissed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                if (maxError == null) {
                    MaxBanner.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                MaxBanner.this.adFailedToLoad(new TAdErrorCode(maxError.getCode(), "Max Ads failed to load ad with error message: " + maxError.getMessage()));
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max onError max code：" + maxError.getCode() + "，message：" + maxError.getMessage());
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                if (maxAd == null) {
                    MaxBanner.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                try {
                    double revenue = maxAd.getRevenue();
                    if (revenue > 0.0d) {
                        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onAdLoad，max price" + revenue);
                        MaxBanner.this.setEcpmPrice(100.0d * revenue * 1000.0d);
                    }
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onAdLoad，max price:" + revenue);
                } catch (Exception e11) {
                    AdLogUtil.Log().d(ExistsCheck.MAX_TAG, Log.getStackTraceString(e11));
                }
                MaxBanner.this.adLoaded();
            }
        };
    }

    public final /* synthetic */ void b(long j11, AppLovinSdkConfiguration appLovinSdkConfiguration) {
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "banner onSdkInitialized time：  " + (System.currentTimeMillis() - j11));
        MaxAdView maxAdView = this.f41822j;
        if (maxAdView != null) {
            maxAdView.loadAd();
        } else {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with adView == null"));
        }
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    public View getBanner() {
        Network network;
        int iDpToPx;
        int height;
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "getBanner " + this.f41822j);
        WeakReference<Context> weakReference = this.mContext;
        Context applicationContext = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        if (applicationContext != null) {
            applicationContext = applicationContext.getApplicationContext();
        }
        if (this.f41822j == null && applicationContext != null && (network = this.mNetwork) != null && !TextUtils.isEmpty(network.getCodeSeatId()) && !TextUtils.isEmpty(this.mNetwork.getApplicationId()) && ExistsCheck.getAppLovinSdk(applicationContext, this.mNetwork.getApplicationId()) != null) {
            String codeSeatId = this.mNetwork.getCodeSeatId();
            MaxAdFormat maxAdFormat = MaxAdFormat.BANNER;
            AppLovinSdk appLovinSdk = ExistsCheck.getAppLovinSdk(applicationContext, this.mNetwork.getApplicationId());
            Objects.requireNonNull(appLovinSdk);
            MaxAdView maxAdView = new MaxAdView(codeSeatId, maxAdFormat, appLovinSdk, applicationContext);
            this.f41822j = maxAdView;
            maxAdView.setExtraParameter("adaptive_banner", "true");
            int i11 = this.f41823k;
            if (i11 == 0 || i11 == 1 || i11 == 2 || i11 == 3) {
                this.f41822j.setLocalExtraParameter("adaptive_banner_width", 320);
                iDpToPx = AppLovinSdkUtils.dpToPx(applicationContext, 320);
                height = this.f41822j.getAdFormat().getAdaptiveSize(320, applicationContext).getHeight();
            } else {
                iDpToPx = -1;
                height = AppLovinSdkUtils.isTablet(applicationContext) ? 90 : 50;
            }
            this.f41822j.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx, AppLovinSdkUtils.dpToPx(applicationContext, height)));
            this.f41822j.setListener(this.f41824l);
        }
        return this.f41822j;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onBannerDestroy");
        this.f41824l = null;
        MaxAdView maxAdView = this.f41822j;
        if (maxAdView != null) {
            maxAdView.setListener(null);
            this.f41822j.destroy();
            this.f41822j = null;
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onBannerLoad");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ExistsCheck.initAdSource(new AppLovinSdk.SdkInitializationListener() { // from class: com.hisavana.max.executer.a
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public final void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                this.f41838a.b(jCurrentTimeMillis, appLovinSdkConfiguration);
            }
        });
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "showBanner");
        MaxAdView maxAdView = this.f41822j;
        if (maxAdView != null) {
            maxAdView.setVisibility(0);
        }
    }
}
