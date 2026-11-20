package com.hisavana.vungle.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.vungle.check.ExistsCheck;
import com.transsion.push.PushConstants;
import com.vungle.warren.AdConfig;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.l;
import com.vungle.warren.m;
import com.vungle.warren.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class VungleVideo extends BaseVideo {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f42079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f42080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f42081l;

    public VungleVideo(Context context, Network network) {
        super(context, network);
        this.f42081l = false;
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f42080k = null;
        this.f42079j = null;
        this.f42081l = false;
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        this.f42079j = new m() { // from class: com.hisavana.vungle.excuter.VungleVideo.1
            @Override // com.vungle.warren.m
            public void onAdLoad(String str) {
                VungleVideo.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onAdLoad");
            }

            @Override // com.vungle.warren.m
            public void onError(String str, VungleException vungleException) {
                String localizedMessage = vungleException != null ? vungleException.getLocalizedMessage() : "";
                VungleVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad for " + str + " with error message: " + localizedMessage));
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads failed to load ad for " + str + "  with error message: " + localizedMessage);
                VungleVideo vungleVideo = VungleVideo.this;
                if (vungleException != null) {
                    vungleVideo.adFailedToLoad(new TAdErrorCode(vungleException.getExceptionCode(), localizedMessage));
                } else {
                    vungleVideo.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_FAILED);
                }
            }
        };
        this.f42080k = new q() { // from class: com.hisavana.vungle.excuter.VungleVideo.2
            @Override // com.vungle.warren.q
            public void creativeId(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads creativeId:" + str);
            }

            @Override // com.vungle.warren.q
            public void onAdClick(String str) {
                VungleVideo.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdClick + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdEnd(String str) {
                VungleVideo.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdEnd + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdEnd(String str, boolean z11, boolean z12) {
            }

            @Override // com.vungle.warren.q
            public void onAdLeftApplication(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdLeftApplication + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdRewarded(String str) {
                VungleVideo.this.onReward();
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdRewarded + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdStart(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdStart + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdViewed(String str) {
                VungleVideo.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdViewed + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onError(String str, VungleException vungleException) {
                String localizedMessage = vungleException != null ? vungleException.getLocalizedMessage() : "";
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle  Ads failed to show ad for " + str + " with error message: " + localizedMessage);
                VungleVideo.this.onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Vungle Ads failed to show ad for " + str + " with error: " + localizedMessage));
            }
        };
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f42081l;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        if (this.mNetwork == null) {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Vungle Ads failed to show ad"));
            return;
        }
        if (Vungle.isInitialized() && Vungle.canPlayAd(this.mNetwork.getCodeSeatId())) {
            AdConfig adConfig = new AdConfig();
            adConfig.d(AdMuteStatus.MUTE_ALL);
            Vungle.playAd(this.mNetwork.getCodeSeatId(), adConfig, this.f42080k);
            return;
        }
        onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Vungle Ads failed to show ad for " + this.mNetwork.getCodeSeatId() + " with error: Vungle SDK not initialized || Vungle ad not playable"));
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle SDK not initialized || Vungle ad not playable for" + this.mNetwork.getCodeSeatId());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        Network network = this.mNetwork;
        if (network == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad error with mNetwork == null "));
        } else {
            ExistsCheck.initAdSource(network.getApplicationId(), new l() { // from class: com.hisavana.vungle.excuter.VungleVideo.3
                @Override // com.vungle.warren.l
                public void onAutoCacheAdAvailable(String str) {
                    AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onAutoCacheAdAvailable " + str);
                }

                @Override // com.vungle.warren.l
                public void onError(VungleException vungleException) {
                    AdLogUtil adLogUtilLog = AdLogUtil.Log();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Vungle.isInitialized() ");
                    sb2.append(Vungle.isInitialized());
                    sb2.append(" VungleException ");
                    sb2.append(ExistsCheck.isDebug ? Log.getStackTraceString(vungleException) : "");
                    adLogUtilLog.d(ExistsCheck.VUNGLE_TAG, sb2.toString());
                    if (vungleException != null) {
                        VungleVideo.this.adFailedToLoad(new TAdErrorCode(vungleException.getExceptionCode(), vungleException.getLocalizedMessage()));
                    } else {
                        VungleVideo.this.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_FAILED);
                    }
                }

                @Override // com.vungle.warren.l
                public void onSuccess() {
                    if (((BaseAd) VungleVideo.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) VungleVideo.this).mNetwork.getCodeSeatId()) || VungleVideo.this.f42079j == null) {
                        VungleVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad error with : network is null"));
                    } else {
                        Vungle.loadAd(((BaseAd) VungleVideo.this).mNetwork.getCodeSeatId(), VungleVideo.this.f42079j);
                        VungleVideo.this.f42081l = true;
                    }
                }
            });
        }
    }
}
