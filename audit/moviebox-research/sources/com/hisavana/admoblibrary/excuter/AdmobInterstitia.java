package com.hisavana.admoblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.n;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdmobInterstitia extends BaseInterstitial {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterstitialAd f41692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterstitialAdLoadCallback f41693b;

    /* JADX INFO: compiled from: source.java */
    public class a implements ExistsCheck.b {
        public a() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            AdmobInterstitia.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            if (((BaseAd) AdmobInterstitia.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) AdmobInterstitia.this).mNetwork.getCodeSeatId()) || AdmobInterstitia.this.f41693b == null) {
                AdmobInterstitia.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "onInterstitialStartLoad loadCallback or codeSeatId is null"));
                AdLogUtil.Log().e("AdmobInterstitia", "onInterstitialStartLoad loadCallback or codeSeatId is null");
            } else {
                Context contextC = n.c();
                if (contextC == null) {
                    contextC = f.a();
                }
                InterstitialAd.load(contextC, ((BaseAd) AdmobInterstitia.this).mNetwork.getCodeSeatId(), PlatformUtil.a(), AdmobInterstitia.this.f41693b);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends InterstitialAdLoadCallback {

        /* JADX INFO: compiled from: source.java */
        public class a extends FullScreenContentCallback {
            public a() {
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdClicked() {
                super.onAdClicked();
                AdmobInterstitia.this.adClicked(null);
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent();
                AdmobInterstitia.this.f41692a = null;
                AdLogUtil.Log().d("AdmobInterstitia", "Interstitial is adClosed" + AdmobInterstitia.this.getLogString());
                AdmobInterstitia.this.adClosed();
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                super.onAdFailedToShowFullScreenContent(adError);
                AdmobInterstitia.this.f41692a = null;
                if (adError != null) {
                    AdmobInterstitia.this.onAdShowError(new TAdErrorCode(adError.getCode(), adError.getMessage()));
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdImpression() {
                super.onAdImpression();
                AdLogUtil.Log().d("AdmobInterstitia", "Interstitial is onAdImpression" + AdmobInterstitia.this.getLogString());
                AdmobInterstitia.this.adImpression(null);
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent();
                AdLogUtil.Log().d("AdmobInterstitia", "Interstitial is onAdShowedFullScreenContent" + AdmobInterstitia.this.getLogString());
            }
        }

        public b() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
            super.onAdLoaded(interstitialAd);
            AdapterResponseInfo loadedAdapterResponseInfo = interstitialAd.getResponseInfo().getLoadedAdapterResponseInfo();
            if (loadedAdapterResponseInfo == null) {
                AdLogUtil.Log().d("AdmobInterstitia", "Interstitial is Loaded" + AdmobInterstitia.this.getLogString());
            } else {
                String adSourceName = loadedAdapterResponseInfo.getAdSourceName();
                AdLogUtil.Log().d("AdmobInterstitia", "Interstitial is Loaded" + AdmobInterstitia.this.getLogString() + "\n----->> mediator source : " + adSourceName);
                AdmobInterstitia.this.setAdmobMediatorInfo(adSourceName);
            }
            AdmobInterstitia.this.f41692a = interstitialAd;
            AdmobInterstitia.this.adLoaded();
            AdmobInterstitia.this.f41692a.setFullScreenContentCallback(new a());
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            AdmobInterstitia.this.f41692a = null;
            if (loadAdError != null) {
                AdLogUtil.Log().w("AdmobInterstitia", "ad load failed, error :" + loadAdError.toString() + AdmobInterstitia.this.getLogString());
                AdmobInterstitia.this.adFailedToLoad(new TAdErrorCode(loadAdError.getCode(), loadAdError.getMessage()));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements OnPaidEventListener {
        public c() {
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(AdValue adValue) {
            if (adValue == null) {
                return;
            }
            long valueMicros = adValue.getValueMicros();
            String currencyCode = adValue.getCurrencyCode();
            int precisionType = adValue.getPrecisionType();
            AdLogUtil.Log().d("AdmobInterstitia", "onPaidEvent valueMicros " + valueMicros + ",currencyCode " + currencyCode + ",precisionType " + precisionType);
            AdmobInterstitia.this.admobShowPriceTracking((float) valueMicros, currencyCode, precisionType);
            AdmobInterstitia.this.onAdditionalShowed(valueMicros, currencyCode, precisionType);
        }
    }

    public AdmobInterstitia(Context context, Network network) {
        super(context, network);
        AdLogUtil.Log().d("AdmobInterstitia", "Admob Interstitial");
    }

    @Override // com.hisavana.common.base.BaseInterstitial, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        InterstitialAd interstitialAd = this.f41692a;
        if (interstitialAd != null) {
            interstitialAd.setOnPaidEventListener(null);
            this.f41692a = null;
        }
        AdLogUtil.Log().d("AdmobInterstitia", PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
        if (this.f41693b != null) {
            this.f41693b = null;
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void initInterstitial() {
        this.f41693b = new b();
    }

    @Override // com.hisavana.common.interfacz.IadInterstitial
    public boolean isLoaded() {
        return this.f41692a != null;
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialShow(Activity activity) {
        InterstitialAd interstitialAd = this.f41692a;
        if (interstitialAd != null && activity != null) {
            interstitialAd.setOnPaidEventListener(new c());
            ExistsCheck.b();
            this.f41692a.show(activity);
        } else {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("AdmobInterstitia", "The ad wasn't ready or activity is null. " + getLogString());
        }
    }

    @Override // com.hisavana.common.base.BaseInterstitial
    public void onInterstitialStartLoad() {
        try {
            ExistsCheck.a(f.a(), new a());
        } catch (Exception e11) {
            AdLogUtil.Log().e("AdmobInterstitia", "onInterstitialStartLoad " + Log.getStackTraceString(e11));
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, Log.getStackTraceString(e11)));
        }
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean supportTimer() {
        return false;
    }
}
