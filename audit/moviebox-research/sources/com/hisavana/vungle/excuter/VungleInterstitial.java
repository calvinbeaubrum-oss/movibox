package com.hisavana.vungle.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.vungle.check.ExistsCheck;
import com.transsion.push.PushConstants;
import com.vungle.warren.AdConfig;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.l;
import com.vungle.warren.m;
import com.vungle.warren.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class VungleInterstitial extends BaseInterstitial {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f42073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f42074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f42075l;

    public VungleInterstitial(Context context, Network network) {
        super(context, network);
        this.f42075l = false;
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f42074k = null;
        this.f42073j = null;
        this.f42075l = false;
        AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        this.f42073j = new m() { // from class: com.hisavana.vungle.excuter.VungleInterstitial.1
            @Override // com.vungle.warren.m
            public void onAdLoad(String str) {
                VungleInterstitial.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onAdLoad");
            }

            @Override // com.vungle.warren.m
            public void onError(String str, VungleException vungleException) {
                String localizedMessage = vungleException != null ? vungleException.getLocalizedMessage() : "";
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads failed to load ad for " + str + " with error message: " + localizedMessage);
                VungleInterstitial vungleInterstitial = VungleInterstitial.this;
                if (vungleException != null) {
                    vungleInterstitial.adFailedToLoad(new TAdErrorCode(vungleException.getExceptionCode(), localizedMessage));
                } else {
                    vungleInterstitial.adFailedToLoad(TAdErrorCode.ERROR_AD_REQUEST_FAILED);
                }
            }
        };
        this.f42074k = new q() { // from class: com.hisavana.vungle.excuter.VungleInterstitial.2
            @Override // com.vungle.warren.q
            public void creativeId(String str) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads creativeId:" + str);
            }

            @Override // com.vungle.warren.q
            public void onAdClick(String str) {
                VungleInterstitial.this.adClicked(null);
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdClick + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdEnd(String str) {
                VungleInterstitial.this.adClosed();
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdEnd + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onAdEnd(String str, boolean z11, boolean z12) {
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "onAdEnd");
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
                VungleInterstitial.this.adImpression(null);
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle Ads onAdViewed + Placement Reference ID = " + str);
            }

            @Override // com.vungle.warren.q
            public void onError(String str, VungleException vungleException) {
                String localizedMessage = vungleException != null ? vungleException.getLocalizedMessage() : "";
                AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle  Ads failed to show ad for " + str + " with error message: " + localizedMessage);
                VungleInterstitial vungleInterstitial = VungleInterstitial.this;
                if (vungleException != null) {
                    vungleInterstitial.onAdShowError(new TAdErrorCode(vungleException.getExceptionCode(), localizedMessage));
                } else {
                    vungleInterstitial.onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
                }
            }
        };
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        return this.f42075l;
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        TAdErrorCode tAdErrorCode;
        if (this.mNetwork == null) {
            tAdErrorCode = new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Vungle Ads failed to show ad");
        } else {
            if (Vungle.isInitialized() && Vungle.canPlayAd(this.mNetwork.getCodeSeatId())) {
                AdConfig adConfig = new AdConfig();
                adConfig.d(AdMuteStatus.MUTE_ALL);
                Vungle.playAd(this.mNetwork.getCodeSeatId(), adConfig, this.f42074k);
                return;
            }
            AdLogUtil.Log().d(ExistsCheck.VUNGLE_TAG, "Vungle SDK not initialized || Vungle ad not playable for" + this.mNetwork.getCodeSeatId());
            tAdErrorCode = new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, "Vungle Ads failed to show ad for " + this.mNetwork.getCodeSeatId() + " with error: Vungle SDK not initialized || Vungle ad not playable");
        }
        onAdShowError(tAdErrorCode);
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        Network network = this.mNetwork;
        if (network == null) {
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad error with mNetwork == null "));
        } else {
            ExistsCheck.initAdSource(network.getApplicationId(), new l() { // from class: com.hisavana.vungle.excuter.VungleInterstitial.3
                @Override // com.vungle.warren.l
                public void onAutoCacheAdAvailable(String str) {
                }

                @Override // com.vungle.warren.l
                public void onError(VungleException vungleException) {
                    VungleInterstitial vungleInterstitial = VungleInterstitial.this;
                    if (vungleException != null) {
                        vungleInterstitial.adFailedToLoad(new TAdErrorCode(vungleException.getExceptionCode(), vungleException.getLocalizedMessage()));
                    } else {
                        vungleInterstitial.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
                    }
                    AdLogUtil adLogUtilLog = AdLogUtil.Log();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Vungle.isInitialized() ");
                    sb2.append(Vungle.isInitialized());
                    sb2.append(" VungleException ");
                    sb2.append(ExistsCheck.isDebug ? Log.getStackTraceString(vungleException) : "");
                    adLogUtilLog.d(ExistsCheck.VUNGLE_TAG, sb2.toString());
                }

                @Override // com.vungle.warren.l
                public void onSuccess() {
                    if (((BaseAd) VungleInterstitial.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) VungleInterstitial.this).mNetwork.getCodeSeatId()) && VungleInterstitial.this.f42073j != null) {
                        Vungle.loadAd(((BaseAd) VungleInterstitial.this).mNetwork.getCodeSeatId(), VungleInterstitial.this.f42073j);
                        VungleInterstitial.this.f42075l = true;
                        return;
                    }
                    VungleInterstitial.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "Vungle Ads failed to load ad error with : Vungle.isInitialized() " + Vungle.isInitialized()));
                }
            });
        }
    }
}
