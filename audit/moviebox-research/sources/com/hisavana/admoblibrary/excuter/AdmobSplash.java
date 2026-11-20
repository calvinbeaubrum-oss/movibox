package com.hisavana.admoblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.cloud.sdk.commonutil.util.f;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdmobSplash extends BaseSplash {
    private static final String TAG = "AdmobSplash";
    private static boolean isShowingAd = false;
    private AppOpenAd appOpenAd;
    private Activity currentActivity;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;

    /* JADX INFO: compiled from: source.java */
    public class a extends AppOpenAd.AppOpenAdLoadCallback {

        /* JADX INFO: renamed from: com.hisavana.admoblibrary.excuter.AdmobSplash$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0460a extends FullScreenContentCallback {
            public C0460a() {
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdClicked() {
                super.onAdClicked();
                AdmobSplash.this.adClicked(null);
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent();
                AdmobSplash.this.onSkipClick();
                AdmobSplash.this.appOpenAd = null;
                boolean unused = AdmobSplash.isShowingAd = false;
                AdLogUtil.Log().d(AdmobSplash.TAG, "admob splashview onAdClicked" + AdmobSplash.this.getLogString());
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                super.onAdFailedToShowFullScreenContent(adError);
                if (adError != null) {
                    AdmobSplash.this.adFailedToLoad(new TAdErrorCode(adError.getCode(), adError.getMessage()));
                    AdLogUtil.Log().d(AdmobSplash.TAG, "admob splashview show fail:" + adError.getMessage() + AdmobSplash.this.getLogString());
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdImpression() {
                super.onAdImpression();
                AdLogUtil.Log().d(AdmobSplash.TAG, "onAdImpression");
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent();
                AdmobSplash.this.adImpression(null);
                boolean unused = AdmobSplash.isShowingAd = true;
                AdLogUtil.Log().d(AdmobSplash.TAG, "admob splashview onAdShow" + AdmobSplash.this.getLogString());
            }
        }

        public a() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(AppOpenAd appOpenAd) {
            if (appOpenAd == null) {
                return;
            }
            AdmobSplash.this.appOpenAd = appOpenAd;
            if (appOpenAd.getResponseInfo().getLoadedAdapterResponseInfo() == null) {
                AdLogUtil.Log().d(AdmobSplash.TAG, "admob appOpenAd onAdLoaded" + AdmobSplash.this.getLogString());
            } else {
                String adSourceName = appOpenAd.getResponseInfo().getLoadedAdapterResponseInfo().getAdSourceName();
                AdLogUtil.Log().d(AdmobSplash.TAG, "admob appOpenAd onAdLoaded" + AdmobSplash.this.getLogString() + "----->> mediator source:" + adSourceName);
                AdmobSplash.this.setAdmobMediatorInfo(adSourceName);
            }
            AdmobSplash.this.adLoaded();
            AdmobSplash.this.appOpenAd.setFullScreenContentCallback(new C0460a());
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (loadAdError != null) {
                AdmobSplash.this.adFailedToLoad(new TAdErrorCode(loadAdError.getCode(), loadAdError.getMessage()));
                AdLogUtil.Log().w(AdmobSplash.TAG, "admob splashview onError:" + loadAdError.toString() + AdmobSplash.this.getLogString());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ExistsCheck.b {
        public b() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            AdmobSplash.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            if (AdmobSplash.this.isAdAvailable() || ((BaseAd) AdmobSplash.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) AdmobSplash.this).mNetwork.getCodeSeatId())) {
                return;
            }
            AppOpenAd.load(f.a(), ((BaseAd) AdmobSplash.this).mNetwork.getCodeSeatId(), PlatformUtil.a(), AdmobSplash.this.getOrientation(), AdmobSplash.this.loadCallback);
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
            AdLogUtil.Log().d(AdmobSplash.TAG, "onPaidEvent valueMicros " + valueMicros + ",currencyCode " + currencyCode + ",precisionType " + precisionType);
            AdmobSplash.this.admobShowPriceTracking((float) valueMicros, currencyCode, precisionType);
            AdmobSplash.this.onAdditionalShowed(valueMicros, currencyCode, precisionType);
        }
    }

    public AdmobSplash(Context context, Network network) {
        super(context, network);
        this.appOpenAd = null;
    }

    @Override // com.hisavana.common.base.BaseSplash, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AppOpenAd appOpenAd = this.appOpenAd;
        if (appOpenAd != null) {
            appOpenAd.setFullScreenContentCallback(null);
            this.appOpenAd = null;
        }
        if (this.loadCallback != null) {
            this.loadCallback = null;
        }
        AdLogUtil.Log().d(TAG, "destroy " + getLogString());
    }

    public void fetchAd() {
        this.loadCallback = new a();
        try {
            ExistsCheck.a(f.a(), new b());
        } catch (Exception e11) {
            e11.printStackTrace();
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, Log.getStackTraceString(e11)));
        }
    }

    @Override // com.hisavana.common.base.BaseSplash
    public View getSplash() {
        if (f.a() != null) {
            return new View(f.a().getApplicationContext());
        }
        return null;
    }

    public boolean isAdAvailable() {
        return this.appOpenAd != null;
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashShow() {
        showAdIfAvailable();
    }

    @Override // com.hisavana.common.base.BaseSplash
    public void onSplashStartLoad() {
        fetchAd();
    }

    public void showAdIfAvailable() {
        if (isShowingAd || !isAdAvailable()) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            onTimeReach();
            AdLogUtil.Log().e(TAG, "showAdIfAvailable,show error,ad is showing or ad is not available");
            return;
        }
        try {
            this.appOpenAd.setOnPaidEventListener(new c());
            this.appOpenAd.show(this.currentActivity);
        } catch (Exception e11) {
            onAdShowError(new TAdErrorCode(TAdErrorCode.CODE_SHOW_EXCEPTION, e11.getMessage()));
            onTimeReach();
            AdLogUtil.Log().e(TAG, "showAdIfAvailable " + Log.getStackTraceString(e11));
        }
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean supportTimer() {
        return false;
    }
}
