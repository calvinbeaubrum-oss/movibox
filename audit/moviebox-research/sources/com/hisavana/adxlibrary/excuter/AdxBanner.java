package com.hisavana.adxlibrary.excuter;

import android.content.Context;
import com.cloud.hisavana.sdk.api.adx.TBannerView;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdxBanner extends BaseBanner<TBannerView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TBannerView f41740a;

    /* JADX INFO: compiled from: source.java */
    public class a extends s9.a {
        public a() {
        }

        @Override // s9.a
        public void a() {
            AdLogUtil.Log().d("AdxBanner", "banner is click" + AdxBanner.this.getLogString());
            AdxBanner.this.adClicked(null);
        }

        @Override // s9.a
        public void c(TBannerView tBannerView) {
            AdLogUtil.Log().d("AdxBanner", "banner onAdClosed" + AdxBanner.this.getLogString());
            AdxBanner.this.adClosed();
        }

        @Override // s9.a
        public void e() {
            AdLogUtil.Log().d("AdxBanner", "banner is Loaded" + AdxBanner.this.getLogString());
            if (AdxBanner.this.f41740a != null) {
                double bidPrice = AdxBanner.this.f41740a.getBidPrice();
                if (AdxBanner.this.f41740a.isDefaultAd()) {
                    bidPrice *= 100.0d;
                }
                if (bidPrice > 0.0d) {
                    AdxBanner.this.setEcpmPrice(bidPrice);
                }
            }
            AdxBanner.this.adLoaded();
        }

        @Override // s9.a
        public void g() {
            AdLogUtil.Log().d("AdxBanner", "banner onAdShow" + AdxBanner.this.getLogString());
            AdxBanner.this.adImpression(null);
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            AdLogUtil.Log().w("AdxBanner", "banner is Load error:" + taErrorCode.getErrorCode() + " msg:" + taErrorCode.getErrorMessage() + AdxBanner.this.getLogString());
            AdxBanner.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
        }

        @Override // s9.a
        public void o() {
            AdLogUtil.Log().d("AdxBanner", "banner onTimeOut" + AdxBanner.this.getLogString());
            AdxBanner.this.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
        }
    }

    public AdxBanner(Context context, Network network, int i11) {
        super(context, network);
        AdLogUtil.Log().d("AdxBanner", "bannerSize:=" + i11 + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TBannerView getBanner() {
        Network network;
        AdLogUtil.Log().d("AdxBanner", "getBanner " + this.requestType);
        if (this.f41740a == null && (network = this.mNetwork) != null) {
            AdManager.f29117b = network.getApplicationId();
            this.f41740a = new TBannerView(f.a(), this.mNetwork.getCodeSeatId());
            a aVar = new a();
            this.f41740a.setRequest(t9.a.a().a());
            this.f41740a.setListener(aVar);
            this.f41740a.setPlacementId(this.mNetwork.getCodeSeatId());
            this.f41740a.setHideAdCloseView(this.isHideAdCloseView);
            this.f41740a.setCloseDirectlyWithoutJumping(this.isCloseDirectly);
        }
        return this.f41740a;
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d("AdxBanner", PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        TBannerView tBannerView = this.f41740a;
        return tBannerView != null && tBannerView.getAdSource() == 2;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        TBannerView tBannerView = this.f41740a;
        return tBannerView != null && tBannerView.getAdSource() == 1;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isInternalAd() {
        TBannerView tBannerView = this.f41740a;
        return tBannerView != null && tBannerView.isDefaultAd();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isMatchVulgarBrand() {
        TBannerView tBannerView = this.f41740a;
        return tBannerView != null && tBannerView.isMatchVulgarBrand();
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.interfacz.ICacheAd
    public boolean isOfflineAd() {
        TBannerView tBannerView = this.f41740a;
        return tBannerView != null && tBannerView.getFillAdType() == 1;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        TBannerView tBannerView = this.f41740a;
        if (tBannerView != null) {
            tBannerView.destroy();
            this.f41740a = null;
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        TBannerView tBannerView = this.f41740a;
        if (tBannerView == null || tBannerView.getRequest() == null) {
            return;
        }
        AdLogUtil.Log().d("AdxBanner", "onBannerLoad " + this.f41740a.getRequest());
        t9.a request = this.f41740a.getRequest();
        request.k(this.requestType);
        request.l("hisa-" + this.mTriggerId);
        request.j("hisa-" + this.mRequestId);
        request.i(getSupportHisavanaFlag() >= 2);
        this.f41740a.setRequest(request);
        this.f41740a.setContainVulgarContent(this.isContainVulgarContent);
        this.f41740a.setAdLoadScenes(this.mGameName, this.mGameScene, this.mExtInfo);
        this.f41740a.setCurrActivityFullscreen(this.mCurrActivityFullscreen);
        this.f41740a.loadAd();
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        TBannerView tBannerView = this.f41740a;
        if (tBannerView == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("AdxBanner", "showBanner show error");
            return;
        }
        if (this.secondPrice != 0.0d && tBannerView.getRequest() != null) {
            t9.a request = this.f41740a.getRequest();
            request.h(this.secondPrice);
            this.f41740a.setRequest(request);
        }
        this.f41740a.show();
    }
}
