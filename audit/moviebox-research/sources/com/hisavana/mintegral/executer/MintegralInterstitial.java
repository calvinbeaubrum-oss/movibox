package com.hisavana.mintegral.executer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.check.ExistsCheck;
import com.mbridge.msdk.newinterstitial.out.MBBidNewInterstitialHandler;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MintegralInterstitial extends BaseInterstitial {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MBBidNewInterstitialHandler f41982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public NewInterstitialListener f41983l;

    public MintegralInterstitial(Context context, Network network) {
        super(context, network);
        this.f41981j = false;
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f41982k = null;
        this.f41983l = null;
        this.f41981j = false;
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        this.f41983l = new NewInterstitialListener() { // from class: com.hisavana.mintegral.executer.MintegralInterstitial.1
            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onAdClicked(MBridgeIds mBridgeIds) {
                MintegralInterstitial.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdClicked");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                MintegralInterstitial.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdClose");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdCloseWithNIReward: " + mBridgeIds.toString() + "  " + rewardInfo.toString());
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onAdShow(MBridgeIds mBridgeIds) {
                MintegralInterstitial.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdShow");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onEndcardShow(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onEndcardShow");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onLoadCampaignSuccess(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onLoadCampaignSuccess");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
                MintegralInterstitial.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onResourceLoadFail");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onResourceLoadSuccess(MBridgeIds mBridgeIds) {
                MintegralInterstitial.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onResourceLoadSuccess");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onShowFail(MBridgeIds mBridgeIds, String str) {
                MintegralInterstitial.this.onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onShowFail");
            }

            @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
            public void onVideoComplete(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onVideoComplete");
            }
        };
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        return this.f41981j;
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        MBBidNewInterstitialHandler mBBidNewInterstitialHandler = this.f41982k;
        if (mBBidNewInterstitialHandler != null && mBBidNewInterstitialHandler.isBidReady()) {
            this.f41982k.showFromBid();
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads failed to show");
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        Network network = this.mNetwork;
        if (network != null && !TextUtils.isEmpty(network.getCodeSeatId()) && this.f41983l != null) {
            if (!TextUtils.isEmpty(this.mNetwork.getBidInfo() != null ? this.mNetwork.getBidInfo().getPayload() : null)) {
                MBBidNewInterstitialHandler mBBidNewInterstitialHandler = new MBBidNewInterstitialHandler(f.a(), "", this.mNetwork.getCodeSeatId());
                this.f41982k = mBBidNewInterstitialHandler;
                mBBidNewInterstitialHandler.setInterstitialVideoListener(this.f41983l);
                this.f41981j = true;
                this.f41982k.loadFromBid(this.mNetwork.getBidInfo().getPayload());
                this.f41982k.playVideoMute(AdMuteStatus.MUTE_ALL ? 1 : 2);
                return;
            }
        }
        adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad error with param empty "));
    }
}
