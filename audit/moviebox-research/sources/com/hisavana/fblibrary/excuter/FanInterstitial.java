package com.hisavana.fblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.f;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.fblibrary.excuter.check.ExistsCheck;
import com.hisavana.fblibrary.excuter.util.PltatformUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FanInterstitial extends BaseInterstitial {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialAd f41779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterstitialAdListener f41780b;

    /* JADX INFO: compiled from: source.java */
    public class a implements InterstitialAdListener {
        public a() {
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad2) {
            AdLogUtil.Log().d("FanInterstitial", "interstitial is click" + FanInterstitial.this.getLogString());
            FanInterstitial.this.adClicked(null);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad2) {
            AdLogUtil.Log().d("FanInterstitial", "interstitial is Loaded" + FanInterstitial.this.getLogString());
            FanInterstitial.this.adLoaded();
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad2, AdError adError) {
            AdLogUtil.Log().w("FanInterstitial", "interstitial is error, error code is " + adError.getErrorCode() + ", error msg is " + adError.getErrorMessage() + FanInterstitial.this.getLogString());
            FanInterstitial.this.adFailedToLoad(new TAdErrorCode(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDismissed(Ad ad2) {
            AdLogUtil.Log().d("FanInterstitial", "interstitial close" + FanInterstitial.this.getLogString());
            FanInterstitial.this.adClosed();
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDisplayed(Ad ad2) {
            AdLogUtil.Log().d("FanInterstitial", "interstitial ad show" + FanInterstitial.this.getLogString());
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad2) {
            FanInterstitial.this.adImpression(null);
        }
    }

    public FanInterstitial(Context context, Network network) {
        super(context, network);
    }

    public final void a() {
        super.loadAd();
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        InterstitialAd interstitialAd = this.f41779a;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.f41779a = null;
        }
        AdLogUtil.Log().d("FanInterstitial", "destroyAd " + getLogString());
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        if (this.f41779a != null || this.mNetwork == null) {
            return;
        }
        this.f41779a = new InterstitialAd(f.a(), this.mNetwork.getCodeSeatId());
        this.f41780b = new a();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        InterstitialAd interstitialAd = this.f41779a;
        if (interstitialAd != null) {
            return interstitialAd.isAdInvalidated() || super.isExpired();
        }
        return super.isExpired();
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        InterstitialAd interstitialAd = this.f41779a;
        return interstitialAd != null && interstitialAd.isAdLoaded();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public boolean isSupportRtBidding() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean isSupportStopRequest() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public void loadAd() {
        a();
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        InterstitialAd interstitialAd = this.f41779a;
        if (interstitialAd != null) {
            interstitialAd.show();
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("FanInterstitial", "onInterstitialShow show error,mInterstitialAd is null");
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        InterstitialAd interstitialAd = this.f41779a;
        if (interstitialAd == null || interstitialAd.isAdLoaded()) {
            return;
        }
        post(PltatformUtil.handler, new Runnable() { // from class: com.hisavana.fblibrary.excuter.FanInterstitial.1

            /* JADX INFO: renamed from: com.hisavana.fblibrary.excuter.FanInterstitial$1$a */
            /* JADX INFO: compiled from: source.java */
            public class a implements AudienceNetworkAds.InitListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ long f41781a;

                public a(long j11) {
                    this.f41781a = j11;
                }

                @Override // com.facebook.ads.AudienceNetworkAds.InitListener
                public void onInitialized(AudienceNetworkAds.InitResult initResult) {
                    AdLogUtil.Log().d("FanInterstitial", "onInitialized " + (System.currentTimeMillis() - this.f41781a));
                    if (initResult == null || !initResult.isSuccess() || FanInterstitial.this.f41779a == null || ((BaseAd) FanInterstitial.this).mNetwork == null) {
                        FanInterstitial.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_SOURCE_INIT_FAILED, initResult == null ? "" : initResult.getMessage()));
                        return;
                    }
                    if (TextUtils.isEmpty(((BaseAd) FanInterstitial.this).mNetwork.getBidInfo() != null ? ((BaseAd) FanInterstitial.this).mNetwork.getBidInfo().getPayload() : null)) {
                        FanInterstitial.this.f41779a.loadAd(FanInterstitial.this.f41779a.buildLoadAdConfig().withAdListener(FanInterstitial.this.f41780b).build());
                    } else {
                        FanInterstitial.this.f41779a.loadAd(FanInterstitial.this.f41779a.buildLoadAdConfig().withAdListener(FanInterstitial.this.f41780b).withBid(((BaseAd) FanInterstitial.this).mNetwork.getBidInfo().getPayload()).build());
                        ((BaseAd) FanInterstitial.this).mNetwork.setBidInfo(null);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ExistsCheck.initFan(f.a(), new a(System.currentTimeMillis()));
                } catch (Exception e11) {
                    AdLogUtil.Log().e("FanInterstitial", "onInterstitialStartLoad " + Log.getStackTraceString(e11));
                }
            }
        });
    }
}
