package com.hisavana.pangle.executer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PangleVideo extends BaseVideo {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PAGRewardedAdLoadListener f42051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PAGRewardedAdInteractionListener f42052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f42053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PAGRewardedAd f42054m;

    public PangleVideo(Context context, Network network) {
        super(context, network);
        this.f42053l = false;
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f42051j = null;
        this.f42052k = null;
        this.f42054m = null;
        this.f42053l = false;
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        this.f42051j = new PAGRewardedAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleVideo.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                PangleVideo.this.f42054m = pAGRewardedAd;
                if (PangleVideo.this.f42054m != null && PangleVideo.this.f42052k != null) {
                    PangleVideo.this.f42054m.setAdInteractionListener(PangleVideo.this.f42052k);
                    try {
                        Double dValueOf = Double.valueOf(Double.parseDouble(PangleVideo.this.f42054m.getMediaExtraInfo().get(BidResponsed.KEY_PRICE).toString()));
                        if (dValueOf.doubleValue() > 0.0d) {
                            PangleVideo.this.setEcpmPrice(dValueOf.doubleValue() * 100.0d);
                        }
                    } catch (Exception e11) {
                        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, Log.getStackTraceString(e11));
                    }
                }
                PangleVideo.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onAdLoad");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
            public void onError(int i11, String str) {
                PangleVideo.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads failed to load ad with error code：" + i11 + "message: " + str);
            }
        };
        this.f42052k = new PAGRewardedAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleVideo.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                PangleVideo.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                PangleVideo.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                PangleVideo.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
            }

            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
            public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                PangleVideo.this.onReward();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onUserEarnedReward");
            }

            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
            public void onUserEarnedRewardFail(int i11, String str) {
            }
        };
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f42053l;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        PAGRewardedAd pAGRewardedAd = this.f42054m;
        if (pAGRewardedAd != null && activity != null) {
            pAGRewardedAd.show(activity);
        } else {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Pangle Ads failed to show,activity or pageRewardedAd is null"));
            AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads failed to show,activity or pageRewardedAd is null");
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        Network network = this.mNetwork;
        if (network == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            ExistsCheck.initAdSource(network.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleVideo.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleVideo.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    ExistsCheck.setInitState(true);
                    if (((BaseAd) PangleVideo.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleVideo.this).mNetwork.getCodeSeatId()) && PangleVideo.this.f42051j != null) {
                        PAGRewardedAd.loadAd(((BaseAd) PangleVideo.this).mNetwork.getCodeSeatId(), new PAGRewardedRequest(), PangleVideo.this.f42051j);
                        PangleVideo.this.f42053l = true;
                        return;
                    }
                    PangleVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }
}
