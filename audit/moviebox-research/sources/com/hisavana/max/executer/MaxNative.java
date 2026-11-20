package com.hisavana.max.executer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.max.check.ExistsCheck;
import com.hisavana.max.util.PlatformUtil;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MaxNative extends BaseNative {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaxNativeAdListener f41829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MaxAd f41830k;
    public MaxNativeAdLoader nativeAdLoader;

    public MaxNative(Context context, Network network, int i11) {
        super(context, network, i11);
        this.f41829j = new MaxNativeAdListener() { // from class: com.hisavana.max.executer.MaxNative.1
            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdClicked(MaxAd maxAd) {
                MaxNative.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max Ads onAdClick");
            }

            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdExpired(MaxAd maxAd) {
                super.onNativeAdExpired(maxAd);
            }

            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdLoadFailed(String str, MaxError maxError) {
                if (maxError == null) {
                    MaxNative.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad with error "));
                    return;
                }
                MaxNative.this.adFailedToLoad(new TAdErrorCode(maxError.getCode(), "Max Ads failed to load ad with error message: " + maxError.getMessage()));
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "Max onError max code：" + maxError.getCode() + "，message：" + maxError.getMessage());
            }

            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdLoaded(@Nullable MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                MaxNative maxNative = MaxNative.this;
                if (maxNative.nativeAdLoader != null && maxNative.f41830k != null) {
                    MaxNative maxNative2 = MaxNative.this;
                    maxNative2.nativeAdLoader.destroy(maxNative2.f41830k);
                }
                MaxNative.this.f41830k = maxAd;
                AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onNativeAdLoaded");
                if (maxAd == null || maxAd.getNativeAd() == null) {
                    return;
                }
                TAdNativeInfo tAdNativeInfo = PlatformUtil.getTAdNativeInfo(maxAd, ((BaseNative) MaxNative.this).mAdt, MaxNative.this.getTtl(), MaxNative.this);
                int iFilter = MaxNative.this.filter(tAdNativeInfo);
                if (iFilter == 0) {
                    ((BaseNative) MaxNative.this).mNatives.add(tAdNativeInfo);
                } else {
                    AdUtil.release(tAdNativeInfo);
                }
                if (((BaseNative) MaxNative.this).mNatives.size() > 0) {
                    MaxNative maxNative3 = MaxNative.this;
                    maxNative3.adLoaded(((BaseNative) maxNative3).mNatives);
                    return;
                }
                MaxNative.this.adFailedToLoad(new TAdErrorCode(iFilter, "ad filter"));
                AdLogUtil.Log().w(ExistsCheck.MAX_TAG, "ad not pass sensitive check or no icon or image filter:" + iFilter);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(long j11, AppLovinSdkConfiguration appLovinSdkConfiguration) {
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "interstitial onSdkInitialized time " + (System.currentTimeMillis() - j11));
        MaxNativeAdLoader maxNativeAdLoader = this.nativeAdLoader;
        if (maxNativeAdLoader != null) {
            maxNativeAdLoader.loadAd();
        } else {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with nativeAdLoader == null"));
        }
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        MaxAd maxAd = this.f41830k;
        if (maxAd != null) {
            this.nativeAdLoader.destroy(maxAd);
        }
        MaxNativeAdLoader maxNativeAdLoader = this.nativeAdLoader;
        if (maxNativeAdLoader != null) {
            maxNativeAdLoader.setNativeAdListener(null);
            this.nativeAdLoader.destroy();
            this.nativeAdLoader = null;
        }
        this.f41829j = null;
        this.f41830k = null;
        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseNative
    public void initNative() {
        Network network;
        WeakReference<Context> weakReference = this.mContext;
        Context context = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        if (context == null || (network = this.mNetwork) == null || TextUtils.isEmpty(network.getCodeSeatId()) || TextUtils.isEmpty(this.mNetwork.getApplicationId()) || ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId()) == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Max Ads failed to load ad error with mNetwork == null"));
            return;
        }
        String codeSeatId = this.mNetwork.getCodeSeatId();
        AppLovinSdk appLovinSdk = ExistsCheck.getAppLovinSdk(context, this.mNetwork.getApplicationId());
        Objects.requireNonNull(appLovinSdk);
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(codeSeatId, appLovinSdk, context);
        this.nativeAdLoader = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this.f41829j);
    }

    @Override // com.hisavana.common.base.BaseNative
    public void onNativeAdStartLoad() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ExistsCheck.initAdSource(new AppLovinSdk.SdkInitializationListener() { // from class: com.hisavana.max.executer.c
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public final void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                this.f41842a.e(jCurrentTimeMillis, appLovinSdkConfiguration);
            }
        });
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo) {
        MaxAd maxAd;
        logTrigerShow(adNativeInfo);
        if (viewGroup == null || !(viewGroup.getChildAt(0) instanceof MaxNativeAdView) || (maxAd = this.f41830k) == null || maxAd.getNativeAd() == null || this.f41830k.getNativeAd().isExpired()) {
            return;
        }
        this.nativeAdLoader.render((MaxNativeAdView) viewGroup.getChildAt(0), this.f41830k);
        adImpression(adNativeInfo);
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void unregisterView(@NonNull AdNativeInfo adNativeInfo) {
    }
}
