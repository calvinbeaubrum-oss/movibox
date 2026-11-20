package com.hisavana.fblibrary.excuter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.f;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.fblibrary.excuter.check.ExistsCheck;
import com.hisavana.fblibrary.excuter.util.PltatformUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FanBanner extends BaseBanner<AdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdView f41772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdSize f41774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdListener f41775d;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdListener {
        public a() {
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad2) {
            AdLogUtil.Log().d("FanBanner", "banner onAdClicked" + FanBanner.this.getLogString());
            FanBanner.this.adClicked(null);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad2) {
            AdLogUtil.Log().d("FanBanner", "banner onAdLoaded" + FanBanner.this.getLogString());
            FanBanner.this.adLoaded();
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad2, AdError adError) {
            AdLogUtil.Log().w("FanBanner", "banner onError:" + adError.getErrorCode() + FanBanner.this.getLogString());
            FanBanner.this.adFailedToLoad(new TAdErrorCode(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad2) {
            AdLogUtil.Log().d("FanBanner", "banner onLoggingImpression" + FanBanner.this.getLogString());
            FanBanner.this.adImpression(null);
        }
    }

    public FanBanner(Context context, Network network, int i11) {
        super(context, network);
        this.mContext = new WeakReference<>(context);
        this.f41773b = i11;
        AdLogUtil.Log().d("FanBanner", "bannerSize:=" + i11 + getLogString());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002a  */
    @Override // com.hisavana.common.base.BaseBanner
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdView getBanner() {
        if (this.f41772a == null) {
            Network network = this.mNetwork;
            if (network == null || TextUtils.isEmpty(network.getCodeSeatId())) {
                return null;
            }
            int i11 = this.f41773b;
            if (i11 == 0) {
                this.f41774c = AdSize.BANNER_HEIGHT_50;
            } else if (i11 == 1) {
                this.f41774c = AdSize.BANNER_HEIGHT_90;
            } else if (i11 == 2) {
                this.f41774c = AdSize.RECTANGLE_HEIGHT_250;
            } else if (i11 != 3) {
                this.f41774c = AdSize.BANNER_HEIGHT_50;
            } else {
                this.f41774c = AdSize.BANNER_HEIGHT_90;
            }
            this.f41772a = new AdView(f.a(), this.mNetwork.getCodeSeatId(), this.f41774c);
            this.f41775d = new a();
        }
        return this.f41772a;
    }

    public final void b() {
        super.loadAd();
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d("FanBanner", "destroyAd " + getLogString());
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        AdView adView = this.f41772a;
        if (adView != null) {
            return adView.isAdInvalidated() || super.isExpired();
        }
        return super.isExpired();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public boolean isSupportRtBidding() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean isSupportStopRequest() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public void loadAd() {
        b();
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        AdView adView = this.f41772a;
        if (adView != null) {
            adView.destroy();
            this.f41772a = null;
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        post(PltatformUtil.handler, new Runnable() { // from class: com.hisavana.fblibrary.excuter.FanBanner.2

            /* JADX INFO: renamed from: com.hisavana.fblibrary.excuter.FanBanner$2$a */
            /* JADX INFO: compiled from: source.java */
            public class a implements AudienceNetworkAds.InitListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ long f41776a;

                public a(long j11) {
                    this.f41776a = j11;
                }

                @Override // com.facebook.ads.AudienceNetworkAds.InitListener
                public void onInitialized(AudienceNetworkAds.InitResult initResult) {
                    AdLogUtil.Log().d("FanBanner", "onInitialized " + (System.currentTimeMillis() - this.f41776a));
                    if (initResult == null || !initResult.isSuccess() || FanBanner.this.f41772a == null || ((BaseAd) FanBanner.this).mNetwork == null) {
                        FanBanner.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_SOURCE_INIT_FAILED, initResult == null ? "" : initResult.getMessage()));
                        return;
                    }
                    if (TextUtils.isEmpty(((BaseAd) FanBanner.this).mNetwork.getBidInfo() != null ? ((BaseAd) FanBanner.this).mNetwork.getBidInfo().getPayload() : null)) {
                        FanBanner.this.f41772a.loadAd(FanBanner.this.f41772a.buildLoadAdConfig().withAdListener(FanBanner.this.f41775d).build());
                        return;
                    }
                    AdLogUtil.Log().d("FanBanner", "load banner with bid info");
                    FanBanner.this.f41772a.loadAd(FanBanner.this.f41772a.buildLoadAdConfig().withAdListener(FanBanner.this.f41775d).withBid(((BaseAd) FanBanner.this).mNetwork.getBidInfo().getPayload()).build());
                    ((BaseAd) FanBanner.this).mNetwork.setBidInfo(null);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ExistsCheck.initFan(f.a(), new a(System.currentTimeMillis()));
                } catch (Exception e11) {
                    AdLogUtil.Log().e("FanBanner", "onBannerLoad " + Log.getStackTraceString(e11));
                }
            }
        });
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        AdView adView = this.f41772a;
        if (adView != null) {
            adView.setVisibility(0);
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("FanBanner", "showBanner error,adView is null");
        }
    }
}
