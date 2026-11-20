package com.hisavana.adxlibrary.excuter;

import android.content.Context;
import android.view.View;
import com.cloud.hisavana.sdk.api.adx.TSplashView;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdxSplash extends BaseSplash {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r9.d f41752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TSplashView f41753b;

    /* JADX INFO: compiled from: source.java */
    public class a extends s9.a {
        public a() {
        }

        @Override // s9.a
        public void a() {
            AdxSplash.this.adClicked(null);
            AdLogUtil.Log().d("AdxSplash", "adx onAdClicked" + AdxSplash.this.getLogString());
        }

        @Override // s9.a
        public void b() {
            AdLogUtil.Log().d("AdxSplash", "adx onAdClosed " + AdxSplash.this.getLogString());
            AdxSplash.this.adClosed();
        }

        @Override // s9.a
        public void e() {
            AdLogUtil.Log().d("AdxSplash", "adx splashview onAdLoaded" + AdxSplash.this.getLogString());
            if (AdxSplash.this.f41752a != null) {
                double dC = AdxSplash.this.f41752a.c();
                if (AdxSplash.this.f41752a.f()) {
                    dC *= 100.0d;
                }
                if (dC > 0.0d) {
                    AdxSplash.this.setEcpmPrice(dC);
                }
            }
            AdxSplash.this.adLoaded();
        }

        @Override // s9.a
        public void g() {
            AdLogUtil.Log().d("AdxSplash", "adx onAdShow" + AdxSplash.this.getLogString());
            AdxSplash.this.adImpression(null);
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                AdxSplash.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
                AdLogUtil.Log().w("AdxSplash", "adx onError:" + taErrorCode.toString() + AdxSplash.this.getLogString());
            }
        }

        @Override // s9.a
        public void o() {
            AdxSplash.this.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
            AdLogUtil.Log().d("AdxSplash", "adx onTimeOut" + AdxSplash.this.getLogString());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements s9.c {
        public b() {
        }

        @Override // s9.c
        public void a() {
            AdLogUtil.Log().d("AdxSplash", "onTimeEnd,splash timeout");
            AdxSplash.this.onTimeReach();
        }

        @Override // s9.c
        public void onClick() {
            AdLogUtil.Log().d("AdxSplash", "onClick click skip btn");
            AdxSplash.this.onSkipClick();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends s9.a {
        public c() {
        }

        @Override // s9.a
        public void a() {
            AdxSplash.this.adClicked(null);
            AdLogUtil.Log().d("AdxSplash", "adx splashview onAdClicked" + AdxSplash.this.getLogString());
        }

        @Override // s9.a
        public void b() {
            AdxSplash.this.adClosed();
        }

        @Override // s9.a
        public void e() {
            AdLogUtil.Log().d("AdxSplash", "adx splashview onAdLoaded" + AdxSplash.this.getLogString());
            if (AdxSplash.this.f41753b != null) {
                double bidPrice = AdxSplash.this.f41753b.getBidPrice();
                if (AdxSplash.this.f41753b.isDefaultAd()) {
                    bidPrice *= 100.0d;
                }
                if (bidPrice > 0.0d) {
                    AdxSplash.this.setEcpmPrice(bidPrice);
                }
            }
            AdxSplash.this.adLoaded();
        }

        @Override // s9.a
        public void g() {
            AdLogUtil.Log().d("AdxSplash", "adx splashview onAdShow" + AdxSplash.this.getLogString());
            AdxSplash.this.adImpression(null);
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                AdxSplash.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
                AdLogUtil.Log().w("AdxSplash", "adx splashview onError:" + taErrorCode.toString() + AdxSplash.this.getLogString());
            }
        }

        @Override // s9.a
        public void o() {
            AdxSplash.this.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
            AdLogUtil.Log().d("AdxSplash", "adx splashview onTimeOut" + AdxSplash.this.getLogString());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements s9.c {
        public d() {
        }

        @Override // s9.c
        public void a() {
            AdxSplash.this.onTimeReach();
        }

        @Override // s9.c
        public void onClick() {
            AdxSplash.this.onSkipClick();
        }
    }

    public AdxSplash(Context context, Network network) {
        super(context, network);
    }

    public final View a() {
        if (this.f41752a == null) {
            this.f41752a = new r9.d(f.a(), this.mNetwork.getCodeSeatId());
            AdManager.f29117b = this.mNetwork.getApplicationId();
            a aVar = new a();
            this.f41752a.n(t9.a.a().a());
            this.f41752a.l(aVar);
            this.f41752a.o(new b());
        }
        if (f.a() != null) {
            return new View(f.a().getApplicationContext());
        }
        return null;
    }

    public final View b() {
        WeakReference<Context> weakReference;
        if (this.f41753b == null && (weakReference = this.mContext) != null && weakReference.get() != null) {
            this.f41753b = new TSplashView(this.mContext.get(), this.mNetwork.getCodeSeatId());
            AdManager.f29117b = this.mNetwork.getApplicationId();
            c cVar = new c();
            this.f41753b.setRequest(t9.a.a().a());
            this.f41753b.setListener(cVar);
            TSplashView tSplashView = this.f41753b;
            if (tSplashView != null) {
                tSplashView.setSkipListener(new d());
            }
        }
        return this.f41753b;
    }

    @Override // com.hisavana.common.base.BaseSplash
    public boolean checkNeedAddLogo() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        r9.d dVar = this.f41752a;
        if (dVar != null) {
            dVar.a();
            this.f41752a = null;
        }
        TSplashView tSplashView = this.f41753b;
        if (tSplashView != null) {
            tSplashView.destroy();
            this.f41753b = null;
        }
        AdLogUtil.Log().d("AdxSplash", PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseSplash
    public View getSplash() {
        return this.splashMode == 1 ? a() : b();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        if (this.splashMode == 1) {
            r9.d dVar = this.f41752a;
            return dVar != null && dVar.b() == 2;
        }
        TSplashView tSplashView = this.f41753b;
        return tSplashView != null && tSplashView.getAdSource() == 2;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        if (this.splashMode == 1) {
            r9.d dVar = this.f41752a;
            return dVar != null && dVar.b() == 1;
        }
        TSplashView tSplashView = this.f41753b;
        return tSplashView != null && tSplashView.getAdSource() == 1;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isInternalAd() {
        if (this.splashMode == 1) {
            r9.d dVar = this.f41752a;
            return dVar != null && dVar.f();
        }
        TSplashView tSplashView = this.f41753b;
        return tSplashView != null && tSplashView.isDefaultAd();
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isMatchVulgarBrand() {
        if (this.splashMode == 1) {
            r9.d dVar = this.f41752a;
            return dVar != null && dVar.g();
        }
        TSplashView tSplashView = this.f41753b;
        return tSplashView != null && tSplashView.isMatchVulgarBrand();
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.interfacz.ICacheAd
    public boolean isOfflineAd() {
        if (this.splashMode == 1) {
            r9.d dVar = this.f41752a;
            return dVar != null && dVar.d() == 1;
        }
        TSplashView tSplashView = this.f41753b;
        return tSplashView != null && tSplashView.getFillAdType() == 1;
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashShow() {
        if (this.splashMode != 1) {
            TSplashView tSplashView = this.f41753b;
            if (tSplashView == null) {
                AdLogUtil.Log().d("AdxSplash", "show splash failed");
                return;
            }
            if (this.secondPrice != 0.0d && tSplashView.getRequest() != null) {
                t9.a request = this.f41753b.getRequest();
                request.h(this.secondPrice);
                this.f41753b.setRequest(request);
            }
            TSplashView tSplashView2 = this.f41753b;
            if (tSplashView2 != null) {
                tSplashView2.show();
                return;
            }
            return;
        }
        r9.d dVar = this.f41752a;
        if (dVar == null) {
            AdLogUtil.Log().d("AdxSplash", "show splash failed");
            return;
        }
        if (this.secondPrice != 0.0d && dVar.e() != null) {
            t9.a aVarE = this.f41752a.e();
            aVarE.h(this.secondPrice);
            this.f41752a.n(aVarE);
        }
        r9.d dVar2 = this.f41752a;
        if (dVar2 != null) {
            dVar2.m(getLogoLayout());
            this.f41752a.p();
        }
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashStartLoad() {
        if (this.splashMode == 1) {
            r9.d dVar = this.f41752a;
            if (dVar == null || dVar.e() == null) {
                return;
            }
            t9.a aVarE = this.f41752a.e();
            aVarE.k(this.requestType);
            aVarE.l("hisa-" + this.mTriggerId);
            aVarE.j("hisa-" + this.mRequestId);
            this.f41752a.n(aVarE);
            this.f41752a.j(this.isContainVulgarContent);
            this.f41752a.i(this.mGameName, this.mGameScene, this.mExtInfo);
            this.f41752a.k(this.mCurrActivityFullscreen);
            this.f41752a.h();
            return;
        }
        TSplashView tSplashView = this.f41753b;
        if (tSplashView == null || tSplashView.getRequest() == null) {
            return;
        }
        t9.a request = this.f41753b.getRequest();
        request.k(this.requestType);
        request.l("hisa-" + this.mTriggerId);
        request.j("hisa-" + this.mRequestId);
        this.f41753b.setRequest(request);
        this.f41753b.setContainVulgarContent(this.isContainVulgarContent);
        this.f41753b.setAdLoadScenes(this.mGameName, this.mGameScene, this.mExtInfo);
        this.f41753b.setCurrActivityFullscreen(this.mCurrActivityFullscreen);
        this.f41753b.loadAd();
    }
}
