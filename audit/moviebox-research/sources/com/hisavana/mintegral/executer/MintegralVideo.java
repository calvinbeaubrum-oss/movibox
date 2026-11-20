package com.hisavana.mintegral.executer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.check.ExistsCheck;
import com.mbridge.msdk.out.MBBidRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.out.RewardVideoListener;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MintegralVideo extends BaseVideo {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MBBidRewardVideoHandler f41998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RewardVideoListener f41999l;

    public MintegralVideo(Context context, Network network) {
        super(context, network);
        this.f41997j = false;
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f41998k = null;
        this.f41999l = null;
        this.f41997j = false;
        AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        this.f41999l = new RewardVideoListener() { // from class: com.hisavana.mintegral.executer.MintegralVideo.1
            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdClose，rewardInfo.isCompleteView()：" + rewardInfo.isCompleteView());
                if (rewardInfo.isCompleteView()) {
                    MintegralVideo.this.onReward();
                }
                MintegralVideo.this.adClosed();
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onAdShow(MBridgeIds mBridgeIds) {
                MintegralVideo.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onAdShow");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onEndcardShow(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onEndcardShow");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onLoadSuccess(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onLoadSuccess");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onShowFail(MBridgeIds mBridgeIds, String str) {
                MintegralVideo.this.onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Mintegral Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onShowFailed");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoAdClicked(MBridgeIds mBridgeIds) {
                MintegralVideo.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onVideoAdClicked");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoComplete(MBridgeIds mBridgeIds) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onVideoComplete");
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
                MintegralVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads failed to load ad with message：" + str);
            }

            @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.b.g
            public void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
                MintegralVideo.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintegral Ads onVideoLoadSuccess");
            }
        };
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f41997j;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        MBBidRewardVideoHandler mBBidRewardVideoHandler = this.f41998k;
        if (mBBidRewardVideoHandler != null && mBBidRewardVideoHandler.isBidReady()) {
            this.f41998k.showFromBid();
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "Mintergral Ads failed to show");
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        Network network = this.mNetwork;
        if (network != null && !TextUtils.isEmpty(network.getCodeSeatId()) && this.f41999l != null) {
            if (!TextUtils.isEmpty(this.mNetwork.getBidInfo() != null ? this.mNetwork.getBidInfo().getPayload() : null)) {
                MBBidRewardVideoHandler mBBidRewardVideoHandler = new MBBidRewardVideoHandler(f.a(), "", this.mNetwork.getCodeSeatId());
                this.f41998k = mBBidRewardVideoHandler;
                mBBidRewardVideoHandler.setRewardVideoListener(this.f41999l);
                this.f41998k.loadFromBid(this.mNetwork.getBidInfo().getPayload());
                this.f41998k.playVideoMute(AdMuteStatus.MUTE_ALL ? 1 : 2);
                this.f41997j = true;
                return;
            }
        }
        adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Mintegral Ads failed to load ad error with params empty"));
    }
}
