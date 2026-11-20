package com.hisavana.pangle.executer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PangleBanner extends BaseBanner {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f42021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PAGBannerAdLoadListener f42022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PAGBannerAdInteractionListener f42023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PAGBannerAd f42024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PAGBannerRequest f42025n;

    public PangleBanner(Context context, Network network, int i11) {
        super(context, network);
        this.f42022k = new PAGBannerAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleBanner.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                if (pAGBannerAd == null) {
                    return;
                }
                PangleBanner.this.f42024m = pAGBannerAd;
                PangleBanner pangleBanner = PangleBanner.this;
                pangleBanner.f42021j = pangleBanner.f42024m.getBannerView();
                if (PangleBanner.this.f42023l != null) {
                    PangleBanner.this.f42024m.setAdInteractionListener(PangleBanner.this.f42023l);
                    try {
                        Double dValueOf = Double.valueOf(Double.parseDouble(PangleBanner.this.f42024m.getMediaExtraInfo().get(BidResponsed.KEY_PRICE).toString()));
                        if (dValueOf.doubleValue() > 0.0d) {
                            PangleBanner.this.setEcpmPrice(dValueOf.doubleValue() * 100.0d);
                        }
                    } catch (Exception e11) {
                        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, Log.getStackTraceString(e11));
                    }
                }
                PangleBanner.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle onAdLoad");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
            public void onError(int i12, String str) {
                PangleBanner.this.adFailedToLoad(new TAdErrorCode(i12, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle onError pangle code：" + i12 + "，message：" + str);
            }
        };
        this.f42023l = new PAGBannerAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleBanner.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
                PangleBanner.this.adClicked(null);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
                PangleBanner.this.adClosed();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
                PangleBanner.this.adImpression(null);
            }
        };
        this.f42025n = new PAGBannerRequest(i11 != 1 ? i11 != 2 ? i11 != 3 ? PAGBannerSize.BANNER_W_320_H_50 : new PAGBannerSize(320, 90) : PAGBannerSize.BANNER_W_300_H_250 : new PAGBannerSize(320, 100));
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    public View getBanner() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "getBanner " + this.f42021j);
        WeakReference<Context> weakReference = this.mContext;
        Context context = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        if (this.f42021j == null && context != null) {
            this.f42021j = new View(f.a());
        }
        return this.f42021j;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onBannerDestroy");
        if (this.f42021j != null) {
            this.f42021j = null;
        }
        PAGBannerAd pAGBannerAd = this.f42024m;
        if (pAGBannerAd != null) {
            pAGBannerAd.destroy();
        }
        this.f42023l = null;
        this.f42022k = null;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onBannerLoad");
        if (this.mNetwork == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            ExistsCheck.initAdSource(this.mNetwork.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleBanner.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleBanner.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message：" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    ExistsCheck.setInitState(true);
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init time " + jCurrentTimeMillis2);
                    if (((BaseAd) PangleBanner.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleBanner.this).mNetwork.getCodeSeatId()) && PangleBanner.this.f42022k != null) {
                        PAGBannerAd.loadAd(((BaseAd) PangleBanner.this).mNetwork.getCodeSeatId(), PangleBanner.this.f42025n, PangleBanner.this.f42022k);
                        return;
                    }
                    PangleBanner.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "showBanner");
        View view = this.f42021j;
        if (view != null) {
            view.setVisibility(0);
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e(ExistsCheck.PANGLE_TAG, "showBanner show error,adView is null");
        }
    }
}
