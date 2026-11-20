package com.hisavana.admoblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.n;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdmobVideo extends BaseVideo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RewardedAd f41713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RewardedAdLoadCallback f41714b;

    /* JADX INFO: compiled from: source.java */
    public class a extends RewardedAdLoadCallback {
        public a() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
            AdmobVideo.this.f41713a = rewardedAd;
            if (rewardedAd.getResponseInfo().getLoadedAdapterResponseInfo() == null) {
                AdLogUtil.Log().d("AdmobVideo", "AdmobVideo --> Video Ad was loaded." + AdmobVideo.this.getLogString());
            } else {
                String adSourceName = rewardedAd.getResponseInfo().getLoadedAdapterResponseInfo().getAdSourceName();
                AdLogUtil.Log().d("AdmobVideo", "AdmobVideo --> Video Ad was loaded." + AdmobVideo.this.getLogString() + "\n----->> mediator source : " + adSourceName);
                AdmobVideo.this.setAdmobMediatorInfo(adSourceName);
            }
            AdmobVideo.this.adLoaded();
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            AdmobVideo.this.f41713a = null;
            AdLogUtil.Log().w("AdmobVideo", "AdmobVideo --> ad load failed, error :" + loadAdError.toString() + AdmobVideo.this.getLogString());
            AdmobVideo.this.adFailedToLoad(new TAdErrorCode(loadAdError.getCode(), loadAdError.getMessage()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ExistsCheck.b {
        public b() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            AdmobVideo.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            if (((BaseAd) AdmobVideo.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) AdmobVideo.this).mNetwork.getCodeSeatId()) || AdmobVideo.this.f41714b == null) {
                AdmobVideo.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "rewardedAdLoadCallback or codeSeatId is null"));
                return;
            }
            Context contextC = n.c();
            if (contextC == null) {
                contextC = f.a();
            }
            RewardedAd.load(contextC, ((BaseAd) AdmobVideo.this).mNetwork.getCodeSeatId(), PlatformUtil.a(), AdmobVideo.this.f41714b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends FullScreenContentCallback {
        public c() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            super.onAdClicked();
            AdmobVideo.this.adClicked(null);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            AdmobVideo.this.f41713a = null;
            AdLogUtil.Log().d("AdmobVideo", "AdmobVideo --> video is adClosed");
            AdmobVideo.this.adClosed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            AdLogUtil.Log().w("AdmobVideo", "AdmobVideo --> Ad failed to show." + AdmobVideo.this.getLogString());
            AdmobVideo.this.f41713a = null;
            if (adError != null) {
                AdmobVideo.this.onAdShowError(new TAdErrorCode(adError.getCode(), adError.getMessage()));
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            AdLogUtil.Log().d("AdmobVideo", "AdmobVideo --> Ad was shown." + AdmobVideo.this.getLogString());
            AdmobVideo.this.adImpression(null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements OnPaidEventListener {
        public d() {
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(AdValue adValue) {
            if (adValue == null) {
                return;
            }
            long valueMicros = adValue.getValueMicros();
            String currencyCode = adValue.getCurrencyCode();
            int precisionType = adValue.getPrecisionType();
            AdLogUtil.Log().d("AdmobVideo", "onPaidEvent valueMicros " + valueMicros + ",currencyCode " + currencyCode + ",precisionType " + precisionType);
            AdmobVideo.this.admobShowPriceTracking((float) valueMicros, currencyCode, precisionType);
            AdmobVideo.this.onAdditionalShowed(valueMicros, currencyCode, precisionType);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements OnUserEarnedRewardListener {
        public e() {
        }

        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
            AdLogUtil.Log().d("AdmobVideo", "AdmobVideo --> The user earned the reward." + AdmobVideo.this.getLogString());
            AdmobVideo.this.onReward();
        }
    }

    public AdmobVideo(Context context, Network network) {
        super(context, network);
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        if (this.f41713a != null) {
            this.f41713a = null;
        }
        AdLogUtil.Log().d("AdmobVideo", "AdmobVideo --> destroy" + getLogString());
        if (this.f41714b != null) {
            this.f41714b = null;
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        this.f41714b = new a();
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f41713a != null;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        if (activity == null) {
            AdLogUtil.Log().w("AdmobVideo", "AdmobVideo --> onVideoShow null == activity " + getLogString());
            return;
        }
        RewardedAd rewardedAd = this.f41713a;
        if (rewardedAd == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().w("AdmobVideo", "AdmobVideo --> The rewarded ad wasn't ready yet." + getLogString());
            return;
        }
        try {
            rewardedAd.setFullScreenContentCallback(new c());
            AdLogUtil.Log().d("AdmobVideo", " activity is finish =" + activity.isFinishing());
            this.f41713a.setOnPaidEventListener(new d());
            ExistsCheck.b();
            this.f41713a.show(activity, new e());
        } catch (Exception e11) {
            e11.printStackTrace();
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, e11.getMessage()));
            AdLogUtil.Log().e("AdmobVideo", "AdmobVideo --> onVideoShow 展示异常" + Log.getStackTraceString(e11) + getLogString());
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        try {
            ExistsCheck.a(f.a(), new b());
        } catch (Exception e11) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, e11.getMessage()));
            AdLogUtil.Log().e("AdmobVideo", "onVideoStartLoad " + Log.getStackTraceString(e11));
        }
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean supportTimer() {
        return false;
    }
}
