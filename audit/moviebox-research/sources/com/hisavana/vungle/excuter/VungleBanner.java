package com.hisavana.vungle.excuter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.vungle.check.ExistsCheck;
import com.transsion.push.PushConstants;
import com.vungle.warren.AdConfig;
import com.vungle.warren.Vungle;
import com.vungle.warren.c;
import com.vungle.warren.d;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.l;
import com.vungle.warren.m;
import com.vungle.warren.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class VungleBanner extends BaseBanner {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f42065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f42066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q f42067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f42068m;

    public VungleBanner(Context context, Network network, int i11) {
        super(context, network);
        this.f42066k = new m() { // from class: com.hisavana.vungle.excuter.VungleBanner.1
            @Override // com.vungle.warren.m
            public void onAdLoad(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onAdLoad");
                VungleBanner.this.adLoaded();
            }

            @Override // com.vungle.warren.m
            public void onError(String str, VungleException vungleException) {
                String localizedMessage = vungleException != null ? vungleException.getLocalizedMessage() : "";
                AdLogUtil.Log().e(ExistsCheck.VUNGLE_TAG, "onError vungleException " + vungleException);
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads failed to load ad for " + str + " with  error message: " + localizedMessage);
                VungleBanner vungleBanner = VungleBanner.this;
                if (vungleException != null) {
                    vungleBanner.adFailedToLoad(new TAdErrorCode(vungleException.getExceptionCode(), localizedMessage));
                } else {
                    vungleBanner.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_FAILED);
                }
            }
        };
        this.f42067l = new q() { // from class: com.hisavana.vungle.excuter.VungleBanner.2
            @Override // com.vungle.warren.q
            public void creativeId(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads creativeId:" + str);
            }

            @Override // com.vungle.warren.q
            public void onAdClick(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdClick + Placement Reference ID = " + str);
                VungleBanner.this.adClicked(null);
            }

            @Override // com.vungle.warren.q
            public void onAdEnd(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdEnd + Placement Reference ID = " + str);
                VungleBanner.this.adClosed();
            }

            @Override // com.vungle.warren.q
            public void onAdEnd(String str, boolean z11, boolean z12) {
            }

            @Override // com.vungle.warren.q
            public void onAdLeftApplication(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdLeftApplication + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdRewarded(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdRewarded + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdStart(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdStart + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdViewed(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdViewed + Placement Reference ID = " + str);
                VungleBanner.this.adImpression(null);
            }

            @Override // com.vungle.warren.q
            public void onError(String str, VungleException vungleException) {
                AdLogUtil adLogUtilLog = AdLogUtil.Log();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Vungle Ads failed to show ad for ");
                sb2.append(str);
                sb2.append(" with error message: ");
                sb2.append(vungleException);
                adLogUtilLog.d(ExistsCheck.VUNGLE_TAG, sb2.toString() == null ? "" : vungleException.getLocalizedMessage());
                VungleBanner vungleBanner = VungleBanner.this;
                if (vungleException != null) {
                    vungleBanner.onAdShowError(new TAdErrorCode(vungleException.getExceptionCode(), vungleException.getLocalizedMessage()));
                } else {
                    vungleBanner.onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
                }
            }
        };
        c cVar = new c();
        this.f42068m = cVar;
        cVar.c(AdConfig.AdSize.BANNER);
        cVar.d(true);
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    public View getBanner() {
        if (this.f42065j == null && this.mNetwork != null && Vungle.isInitialized() && d.c(this.mNetwork.getCodeSeatId(), this.f42068m.a())) {
            this.f42065j = d.e(this.mNetwork.getCodeSeatId(), this.f42068m, this.f42067l);
        }
        return this.f42065j;
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public void loadAd() {
        this.mRequestId = DeviceUtil.n();
        this.startTime = System.currentTimeMillis();
        if (supportTimer()) {
            startTimer();
        }
        adTrackingRequest();
        onBannerLoad();
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onBannerDestroy");
        View view = this.f42065j;
        if (view != null) {
            if (view instanceof com.vungle.warren.VungleBanner) {
                ((com.vungle.warren.VungleBanner) view).destroyAd();
            }
            this.f42065j = null;
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onBannerLoad");
        if (this.mNetwork == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad error with mNetwork == null "));
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            ExistsCheck.initAdSource(this.mNetwork.getApplicationId(), new l() { // from class: com.hisavana.vungle.excuter.VungleBanner.3
                @Override // com.vungle.warren.l
                public void onAutoCacheAdAvailable(String str) {
                    AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onAutoCacheAdAvailable " + str);
                }

                @Override // com.vungle.warren.l
                public void onError(VungleException vungleException) {
                    VungleBanner vungleBanner = VungleBanner.this;
                    if (vungleException != null) {
                        vungleBanner.adFailedToLoad(new TAdErrorCode(vungleException.getExceptionCode(), vungleException.getLocalizedMessage()));
                    } else {
                        vungleBanner.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
                    }
                    AdLogUtil adLogUtilLog = AdLogUtil.Log();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("init onError ");
                    sb2.append(ExistsCheck.isDebug ? Log.getStackTraceString(vungleException) : "");
                    adLogUtilLog.d(ExistsCheck.VUNGLE_TAG, sb2.toString());
                }

                @Override // com.vungle.warren.l
                public void onSuccess() {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "init time " + jCurrentTimeMillis2);
                    if (((BaseAd) VungleBanner.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) VungleBanner.this).mNetwork.getCodeSeatId()) || VungleBanner.this.f42067l == null || VungleBanner.this.f42066k == null) {
                        VungleBanner.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad error with : Vungle.isInitialized()：true"));
                    } else {
                        d.g(((BaseAd) VungleBanner.this).mNetwork.getCodeSeatId(), VungleBanner.this.f42068m, VungleBanner.this.f42066k);
                    }
                }
            });
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "showBanner");
        View view = this.f42065j;
        if (view != null) {
            view.setVisibility(0);
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e(ExistsCheck.VUNGLE_TAG, "showBanner error");
        }
    }
}
