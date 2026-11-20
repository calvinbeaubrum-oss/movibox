package com.hisavana.admoblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.f;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b extends BaseVideo {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RewardedInterstitialAd f41721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RewardedInterstitialAdLoadCallback f41722k;

    /* JADX INFO: compiled from: source.java */
    public class a extends RewardedInterstitialAdLoadCallback {
        public a() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
            b.this.f41721j = rewardedInterstitialAd;
            AdapterResponseInfo loadedAdapterResponseInfo = rewardedInterstitialAd.getResponseInfo().getLoadedAdapterResponseInfo();
            if (loadedAdapterResponseInfo == null) {
                AdLogUtil.Log().d("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> Video Ad was loaded." + b.this.getLogString());
            } else {
                String adSourceName = loadedAdapterResponseInfo.getAdSourceName();
                AdLogUtil.Log().d("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> Video Ad was loaded." + b.this.getLogString() + "----->>mediator source: " + adSourceName);
                b.this.setAdmobMediatorInfo(adSourceName);
            }
            b.this.adLoaded();
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            b.this.f41721j = null;
            AdLogUtil.Log().w("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> ad load failed, error :" + loadAdError.toString() + b.this.getLogString());
            b.this.adFailedToLoad(new TAdErrorCode(loadAdError.getCode(), loadAdError.getMessage()));
        }
    }

    /* JADX INFO: renamed from: com.hisavana.admoblibrary.excuter.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0461b implements ExistsCheck.b {
        public C0461b() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            b.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            if (((BaseAd) b.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) b.this).mNetwork.getCodeSeatId()) || b.this.f41722k == null) {
                b.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "rewardedAdLoadCallback or codeSeatId is null"));
            } else {
                RewardedInterstitialAd.load(f.a(), ((BaseAd) b.this).mNetwork.getCodeSeatId(), PlatformUtil.a(), b.this.f41722k);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends FullScreenContentCallback {
        public c() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            super.onAdClicked();
            b.this.adClicked(null);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            b.this.f41721j = null;
            AdLogUtil.Log().d("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> video is adClosed");
            b.this.adClosed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            AdLogUtil.Log().w("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> Ad failed to show." + b.this.getLogString());
            b.this.f41721j = null;
            if (adError != null) {
                b.this.onAdShowError(new TAdErrorCode(adError.getCode(), adError.getMessage()));
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            AdLogUtil.Log().d("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> Ad was shown." + b.this.getLogString());
            b.this.adImpression(null);
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
            AdLogUtil.Log().d("AdmobInterstitiaVideo", "onPaidEvent valueMicros " + valueMicros + ",currencyCode " + currencyCode + ",precisionType " + precisionType);
            b.this.admobShowPriceTracking((float) valueMicros, currencyCode, precisionType);
            b.this.onAdditionalShowed(valueMicros, currencyCode, precisionType);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements OnUserEarnedRewardListener {
        public e() {
        }

        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
            AdLogUtil.Log().d("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> The user earned the reward." + b.this.getLogString());
            b.this.onReward();
        }
    }

    public b(Context context, Network network) {
        super(context, network);
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        if (this.f41721j != null) {
            this.f41721j = null;
        }
        AdLogUtil.Log().d("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> destroy" + getLogString());
        if (this.f41722k != null) {
            this.f41722k = null;
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        this.f41722k = new a();
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        return this.f41721j != null;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        if (activity == null) {
            AdLogUtil.Log().w("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> onVideoShow null == activity " + getLogString());
            return;
        }
        RewardedInterstitialAd rewardedInterstitialAd = this.f41721j;
        if (rewardedInterstitialAd == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().w("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> The rewarded ad wasn't ready yet." + getLogString());
            return;
        }
        try {
            rewardedInterstitialAd.setFullScreenContentCallback(new c());
            AdLogUtil.Log().d("AdmobInterstitiaVideo", " activity is finish =" + activity.isFinishing());
            this.f41721j.setOnPaidEventListener(new d());
            ExistsCheck.b();
            this.f41721j.show(activity, new e());
        } catch (Exception e11) {
            e11.printStackTrace();
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, e11.getMessage()));
            AdLogUtil.Log().e("AdmobInterstitiaVideo", "AdmobInterstitialVideo --> onVideoShow 展示异常" + Log.getStackTraceString(e11) + getLogString());
        }
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        try {
            ExistsCheck.a(f.a(), new C0461b());
        } catch (Exception e11) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, e11.getMessage()));
            AdLogUtil.Log().e("AdmobInterstitiaVideo", "onVideoStartLoad " + Log.getStackTraceString(e11));
        }
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean supportTimer() {
        return false;
    }
}
