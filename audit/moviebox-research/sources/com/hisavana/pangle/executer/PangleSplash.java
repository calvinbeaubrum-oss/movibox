package com.hisavana.pangle.executer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.n;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PangleSplash extends BaseSplash {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PAGAppOpenAdLoadListener f42044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PAGAppOpenAdInteractionListener f42045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PAGAppOpenAd f42046l;

    public PangleSplash(Context context, Network network) {
        super(context, network);
        this.f42044j = new PAGAppOpenAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleSplash.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
                PangleSplash.this.f42046l = pAGAppOpenAd;
                if (PangleSplash.this.f42045k != null && PangleSplash.this.f42046l != null) {
                    PangleSplash.this.f42046l.setAdInteractionListener(PangleSplash.this.f42045k);
                    try {
                        Double dValueOf = Double.valueOf(Double.parseDouble(pAGAppOpenAd.getMediaExtraInfo().get(BidResponsed.KEY_PRICE).toString()));
                        if (dValueOf.doubleValue() > 0.0d) {
                            AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle onAdLoad，price" + dValueOf);
                            PangleSplash.this.setEcpmPrice(dValueOf.doubleValue() * 100.0d);
                        }
                    } catch (Exception e11) {
                        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, Log.getStackTraceString(e11));
                    }
                }
                PangleSplash.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onAdLoad");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
            public void onError(int i11, String str) {
                PangleSplash.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onError code " + i11 + "，message：" + str);
            }
        };
        this.f42045k = new PAGAppOpenAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleSplash.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
                PangleSplash.this.adClicked(null);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
                PangleSplash.this.adClosed();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
                PangleSplash.this.adImpression(null);
            }
        };
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseSplash
    public View getSplash() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onSplashLoad");
        if (f.a() != null) {
            return new View(f.a().getApplicationContext());
        }
        return null;
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashShow() {
        if (this.f42046l != null && n.c() != null) {
            this.f42046l.show(n.c());
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e(ExistsCheck.PANGLE_TAG, "onSplashShow show error,ad is null or no main activity");
        }
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashStartLoad() {
        if (this.mNetwork == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            ExistsCheck.initAdSource(this.mNetwork.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleSplash.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleSplash.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message：" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    ExistsCheck.setInitState(true);
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init time " + jCurrentTimeMillis2);
                    if (((BaseAd) PangleSplash.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleSplash.this).mNetwork.getCodeSeatId()) && PangleSplash.this.f42044j != null) {
                        PAGAppOpenAd.loadAd(((BaseAd) PangleSplash.this).mNetwork.getCodeSeatId(), new PAGAppOpenRequest(), PangleSplash.this.f42044j);
                        return;
                    }
                    PangleSplash.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }
}
