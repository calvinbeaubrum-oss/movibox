package com.hisavana.adxlibrary.excuter;

import android.app.Activity;
import android.content.Context;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdxInterstitia extends BaseInterstitial {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r9.a f41742a;

    /* JADX INFO: compiled from: source.java */
    public class a extends s9.a {
        public a() {
        }

        @Override // s9.a
        public void a() {
            AdLogUtil.Log().d("AdxInterstitia", "interstitial is click" + AdxInterstitia.this.getLogString());
            AdxInterstitia.this.adClicked(null);
        }

        @Override // s9.a
        public void b() {
            AdLogUtil.Log().d("AdxInterstitia", "interstitial is closed" + AdxInterstitia.this.getLogString());
            AdxInterstitia.this.adClosed();
        }

        @Override // s9.a
        public void e() {
            AdLogUtil.Log().d("AdxInterstitia", "interstitial is Loaded" + AdxInterstitia.this.getLogString());
            if (AdxInterstitia.this.f41742a != null) {
                double dC = AdxInterstitia.this.f41742a.c();
                if (AdxInterstitia.this.f41742a.g()) {
                    dC *= 100.0d;
                }
                if (dC > 0.0d) {
                    AdxInterstitia.this.setEcpmPrice(dC);
                }
            }
            AdxInterstitia.this.adLoaded();
        }

        @Override // s9.a
        public void g() {
            AdLogUtil.Log().d("AdxInterstitia", "interstitial is onAdShow" + AdxInterstitia.this.getLogString());
            AdxInterstitia.this.adImpression(null);
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            AdLogUtil.Log().w("AdxInterstitia", "interstitial onError:errorCode:" + taErrorCode.getErrorCode() + ",errorMessage:" + taErrorCode.getErrorMessage() + AdxInterstitia.this.getLogString());
            AdxInterstitia.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
        }

        @Override // s9.a
        public void o() {
            AdxInterstitia.this.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
        }
    }

    public AdxInterstitia(Context context, Network network) {
        super(context, network);
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        r9.a aVar = this.f41742a;
        if (aVar != null) {
            aVar.a();
            this.f41742a = null;
        }
        AdLogUtil.Log().d("AdxInterstitia", PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        Network network;
        if (this.f41742a != null || (network = this.mNetwork) == null) {
            return;
        }
        this.f41742a = new r9.a(network.getCodeSeatId());
        AdManager.f29117b = this.mNetwork.getApplicationId();
        a aVar = new a();
        this.f41742a.p(t9.a.a().a());
        this.f41742a.n(aVar);
        this.f41742a.o(this.mNetwork.getCodeSeatId());
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        r9.a aVar = this.f41742a;
        return aVar != null && aVar.b() == 2;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        r9.a aVar = this.f41742a;
        return aVar != null && aVar.b() == 1;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        r9.a aVar = this.f41742a;
        if (aVar != null) {
            return !aVar.f() || super.isExpired();
        }
        return super.isExpired();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isInternalAd() {
        r9.a aVar = this.f41742a;
        return aVar != null && aVar.g();
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        r9.a aVar = this.f41742a;
        return aVar != null && aVar.h();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isMatchVulgarBrand() {
        r9.a aVar = this.f41742a;
        return aVar != null && aVar.i();
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.interfacz.ICacheAd
    public boolean isOfflineAd() {
        r9.a aVar = this.f41742a;
        return aVar != null && aVar.d() == 1;
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        r9.a aVar = this.f41742a;
        if (aVar == null || aVar.e() == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("AdxInterstitia", "onInterstitialShow ad or listener is null");
            return;
        }
        if (this.secondPrice != 0.0d) {
            t9.a aVarE = this.f41742a.e();
            aVarE.h(this.secondPrice);
            this.f41742a.p(aVarE);
        }
        this.f41742a.q();
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        r9.a aVar = this.f41742a;
        if (aVar == null || aVar.h() || this.f41742a.e() == null) {
            return;
        }
        t9.a aVarE = this.f41742a.e();
        aVarE.k(this.requestType);
        aVarE.l("hisa-" + this.mTriggerId);
        aVarE.j("hisa-" + this.mRequestId);
        aVarE.i(getSupportHisavanaFlag() >= 2);
        this.f41742a.p(aVarE);
        this.f41742a.l(this.isContainVulgarContent);
        this.f41742a.k(this.mGameName, this.mGameScene, this.mExtInfo);
        this.f41742a.m(this.mCurrActivityFullscreen);
        this.f41742a.j();
    }
}
