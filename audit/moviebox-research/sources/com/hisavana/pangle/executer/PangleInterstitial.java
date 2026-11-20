package com.hisavana.pangle.executer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PangleInterstitial extends BaseInterstitial {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PAGInterstitialAdLoadListener f42030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PAGInterstitialAdInteractionListener f42031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f42032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PAGInterstitialAd f42033m;

    public PangleInterstitial(Context context, Network network) {
        super(context, network);
        this.f42032l = false;
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f42033m = null;
        this.f42030j = null;
        this.f42031k = null;
        this.f42032l = false;
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        this.f42030j = new PAGInterstitialAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleInterstitial.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                if (pAGInterstitialAd == null) {
                    return;
                }
                PangleInterstitial.this.f42033m = pAGInterstitialAd;
                if (PangleInterstitial.this.f42031k != null) {
                    PangleInterstitial.this.f42033m.setAdInteractionListener(PangleInterstitial.this.f42031k);
                    try {
                        Double dValueOf = Double.valueOf(Double.parseDouble(PangleInterstitial.this.f42033m.getMediaExtraInfo().get(BidResponsed.KEY_PRICE).toString()));
                        if (dValueOf.doubleValue() > 0.0d) {
                            PangleInterstitial.this.setEcpmPrice(dValueOf.doubleValue() * 100.0d);
                        }
                    } catch (Exception e11) {
                        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, Log.getStackTraceString(e11));
                    }
                    PangleInterstitial.this.adLoaded();
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onAdLoad");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
            public void onError(int i11, String str) {
                PangleInterstitial.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads failed to load ad with error code：" + i11 + "，message: " + str);
            }
        };
        this.f42031k = new PAGInterstitialAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleInterstitial.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                PangleInterstitial.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                PangleInterstitial.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                PangleInterstitial.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
            }
        };
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        return this.f42032l;
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        PAGInterstitialAd pAGInterstitialAd = this.f42033m;
        if (pAGInterstitialAd != null && activity != null) {
            pAGInterstitialAd.show(activity);
        } else {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Pangle Ads failed to show"));
            AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads failed to show");
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        Network network = this.mNetwork;
        if (network == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            ExistsCheck.initAdSource(network.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleInterstitial.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleInterstitial.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message：" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    ExistsCheck.setInitState(true);
                    if (((BaseAd) PangleInterstitial.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleInterstitial.this).mNetwork.getCodeSeatId()) && PangleInterstitial.this.f42030j != null) {
                        PAGInterstitialAd.loadAd(((BaseAd) PangleInterstitial.this).mNetwork.getCodeSeatId(), new PAGInterstitialRequest(), PangleInterstitial.this.f42030j);
                        PangleInterstitial.this.f42032l = true;
                        return;
                    }
                    PangleInterstitial.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }
}
