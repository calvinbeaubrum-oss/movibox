package com.hisavana.fblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.f;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.fblibrary.excuter.check.ExistsCheck;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FanVideo extends BaseVideo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RewardedVideoAd f41790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RewardedVideoAdListener f41791b;

    /* JADX INFO: compiled from: source.java */
    public class a implements RewardedVideoAdListener {
        public a() {
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad2) {
            AdLogUtil.Log().d("video", "FanVideo --> Ad onAdClicked." + FanVideo.this.getLogString());
            FanVideo.this.adClicked(null);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad2) {
            AdLogUtil.Log().d("video", "FanVideo --> Video Ad was loaded." + FanVideo.this.getLogString());
            FanVideo.this.adLoaded();
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad2, AdError adError) {
            if (adError != null) {
                AdLogUtil.Log().w("video", "FanVideo --> ad load failed, error :" + adError.getErrorMessage() + FanVideo.this.getLogString());
                FanVideo.this.adFailedToLoad(new TAdErrorCode(adError.getErrorCode(), adError.getErrorMessage()));
            }
            FanVideo.this.f41790a = null;
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad2) {
            AdLogUtil.Log().d("video", "FanVideo --> Ad was shown." + FanVideo.this.getLogString());
            FanVideo.this.adImpression(null);
        }

        @Override // com.facebook.ads.RewardedVideoAdListener
        public void onRewardedVideoClosed() {
            FanVideo.this.f41790a = null;
            AdLogUtil.Log().d("video", "FanVideo --> video is adClosed" + FanVideo.this.getLogString());
            FanVideo.this.adClosed();
        }

        @Override // com.facebook.ads.RewardedVideoAdListener
        public void onRewardedVideoCompleted() {
            AdLogUtil.Log().d("video", "FanVideo --> The user earned the reward." + FanVideo.this.getLogString());
            FanVideo.this.onReward();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements AudienceNetworkAds.InitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f41793a;

        public b(long j11) {
            this.f41793a = j11;
        }

        @Override // com.facebook.ads.AudienceNetworkAds.InitListener
        public void onInitialized(AudienceNetworkAds.InitResult initResult) {
            AdLogUtil.Log().d("FanVideo", "onInitialized " + (System.currentTimeMillis() - this.f41793a));
            if (initResult == null || !initResult.isSuccess() || FanVideo.this.f41790a == null || ((BaseAd) FanVideo.this).mNetwork == null) {
                FanVideo.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
                return;
            }
            try {
                if (TextUtils.isEmpty(((BaseAd) FanVideo.this).mNetwork.getBidInfo() != null ? ((BaseAd) FanVideo.this).mNetwork.getBidInfo().getPayload() : null)) {
                    FanVideo.this.f41790a.loadAd(FanVideo.this.f41790a.buildLoadAdConfig().withAdListener(FanVideo.this.f41791b).build());
                } else {
                    FanVideo.this.f41790a.loadAd(FanVideo.this.f41790a.buildLoadAdConfig().withBid(((BaseAd) FanVideo.this).mNetwork.getBidInfo().getPayload()).withAdListener(FanVideo.this.f41791b).build());
                    ((BaseAd) FanVideo.this).mNetwork.setBidInfo(null);
                }
            } catch (Exception e11) {
                AdLogUtil.Log().e("FanVideo", "onVideoStartLoad " + Log.getStackTraceString(e11));
            }
        }
    }

    public FanVideo(Context context, Network network) {
        super(context, network);
    }

    public final void a() {
        super.loadAd();
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        if (this.f41790a != null) {
            this.f41790a = null;
        }
        if (this.f41791b != null) {
            this.f41791b = null;
        }
        AdLogUtil.Log().d("video", "destroyAd " + getLogString());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        Context context;
        Network network;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null || (context = this.mContext.get()) == null || (network = this.mNetwork) == null) {
            return;
        }
        this.f41790a = new RewardedVideoAd(context, network.getCodeSeatId());
        this.f41791b = new a();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        if (super.isExpired()) {
            return true;
        }
        RewardedVideoAd rewardedVideoAd = this.f41790a;
        if (rewardedVideoAd != null) {
            return rewardedVideoAd.isAdInvalidated();
        }
        return false;
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f41790a != null;
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean isSupportStopRequest() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public void loadAd() {
        a();
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        if (this.f41790a == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("video", "FanVideo --> The rewarded ad wasn't ready yet.");
            return;
        }
        AdLogUtil.Log().d("video", "FanVideo --> onVideoShow." + getLogString());
        this.f41790a.show();
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        if (this.f41790a == null || this.f41791b == null) {
            return;
        }
        try {
            ExistsCheck.initFan(f.a(), new b(System.currentTimeMillis()));
        } catch (Exception e11) {
            AdLogUtil.Log().e("FanVideo", Log.getStackTraceString(e11));
        }
    }
}
