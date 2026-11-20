package com.hisavana.admoblibrary.excuter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.cloud.sdk.commonutil.util.f;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdmobBanner extends BaseBanner<AdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdView f41687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41689c;

    /* JADX INFO: compiled from: source.java */
    public class a extends AdListener {
        public a() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            AdLogUtil.Log().d("AdmobBanner", "onAdClicked");
            super.onAdClicked();
            AdmobBanner.this.adClicked(null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            if (AdmobBanner.this.f41689c == 0) {
                AdmobBanner.this.adClosed();
            }
            AdLogUtil.Log().d("AdmobBanner", "onAdClosed bannerType " + AdmobBanner.this.f41689c);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            AdLogUtil.Log().w("AdmobBanner", "banner onAdFailedToLoad:" + loadAdError.toString() + AdmobBanner.this.getLogString());
            AdmobBanner.this.adFailedToLoad(new TAdErrorCode(loadAdError.getCode(), loadAdError.getMessage()));
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            AdLogUtil.Log().d("AdmobBanner", "onAdImpression");
            super.onAdImpression();
            AdmobBanner.this.adImpression(null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            ResponseInfo responseInfo = AdmobBanner.this.f41687a.getResponseInfo();
            if (responseInfo == null || responseInfo.getLoadedAdapterResponseInfo() == null) {
                AdLogUtil.Log().d("AdmobBanner", "banner onAdLoaded" + AdmobBanner.this.getLogString());
            } else {
                String adSourceName = responseInfo.getLoadedAdapterResponseInfo().getAdSourceName();
                AdLogUtil.Log().d("AdmobBanner", "banner onAdLoaded" + AdmobBanner.this.getLogString() + "\n----->> mediator source : " + adSourceName);
                AdmobBanner.this.setAdmobMediatorInfo(adSourceName);
            }
            AdmobBanner.this.adLoaded();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ExistsCheck.b {
        public b() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            AdmobBanner.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            if (AdmobBanner.this.f41687a != null) {
                AdmobBanner.this.f41687a.loadAd(PlatformUtil.a(AdmobBanner.this.f41689c));
            } else {
                AdLogUtil.Log().e("AdmobBanner", "onBannerLoad adView is null");
            }
        }
    }

    public AdmobBanner(Context context, Network network, int i11, int i12) {
        super(context, network);
        this.f41688b = i11;
        this.f41689c = i12;
        AdLogUtil.Log().d("AdmobBanner", "bannerSize:=" + i11 + getLogString());
    }

    public final AdSize a() {
        AdSize currentOrientationAnchoredAdaptiveBannerAdSize;
        AdSize adSize = AdSize.BANNER;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null) {
            return adSize;
        }
        Context context = this.mContext.get();
        if (context instanceof Activity) {
            WindowManager windowManager = ((Activity) context).getWindowManager();
            Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
            if (defaultDisplay == null) {
                return adSize;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            float f11 = displayMetrics.widthPixels;
            float f12 = displayMetrics.density;
            if (f11 <= 0.0f || f12 <= 0.0f) {
                return adSize;
            }
            currentOrientationAnchoredAdaptiveBannerAdSize = AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, (int) (f11 / f12));
        } else {
            currentOrientationAnchoredAdaptiveBannerAdSize = adSize;
        }
        return currentOrientationAnchoredAdaptiveBannerAdSize != null ? currentOrientationAnchoredAdaptiveBannerAdSize : adSize;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    @Override // com.hisavana.common.base.BaseBanner
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AdView getBanner() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null) {
            return this.f41687a;
        }
        Context applicationContext = this.mContext.get();
        if (this.f41687a == null && applicationContext != null && this.mNetwork != null) {
            if (!(applicationContext instanceof Activity)) {
                this.f41689c = 0;
            }
            if (this.f41689c == 0) {
                applicationContext = applicationContext.getApplicationContext();
            }
            AdView adView = new AdView(applicationContext);
            this.f41687a = adView;
            adView.setAdUnitId(this.mNetwork.getCodeSeatId());
            int i11 = this.f41688b;
            if (i11 == 0) {
                this.f41687a.setAdSize(a());
            } else if (i11 == 1) {
                this.f41687a.setAdSize(AdSize.LARGE_BANNER);
            } else if (i11 == 2) {
                this.f41687a.setAdSize(AdSize.MEDIUM_RECTANGLE);
            } else if (i11 != 3) {
                this.f41687a.setAdSize(AdSize.BANNER);
            } else {
                this.f41687a.setAdSize(AdSize.LARGE_BANNER);
            }
            this.f41687a.setAdListener(new a());
            this.f41687a.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.hisavana.admoblibrary.excuter.a
                @Override // com.google.android.gms.ads.OnPaidEventListener
                public final void onPaidEvent(AdValue adValue) {
                    this.f41720a.b(adValue);
                }
            });
        }
        return this.f41687a;
    }

    public final /* synthetic */ void b(AdValue adValue) {
        long valueMicros = adValue.getValueMicros();
        String currencyCode = adValue.getCurrencyCode();
        int precisionType = adValue.getPrecisionType();
        AdLogUtil.Log().d("AdmobBanner", "onPaidEvent valueMicros " + valueMicros + ",currencyCode " + currencyCode + ",precisionType " + precisionType);
        admobShowPriceTracking((float) valueMicros, currencyCode, precisionType);
        onAdditionalShowed(valueMicros, currencyCode, precisionType);
    }

    @Override // com.hisavana.common.base.BaseBanner
    public boolean destroyFoldAd() {
        super.destroyFoldAd();
        AdLogUtil.Log().d("AdmobBanner", "destroyFoldAd mBannerType " + this.f41689c);
        if (this.f41689c == 0) {
            return false;
        }
        destroyAd();
        return true;
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerDestroy() {
        try {
            AdView adView = this.f41687a;
            if (adView != null) {
                adView.setAdListener(null);
                this.f41687a.setOnPaidEventListener(null);
                this.f41687a.destroy();
                this.f41687a = null;
            }
        } catch (Throwable th2) {
            AdLogUtil.Log().e("AdmobBanner", Log.getStackTraceString(th2));
            this.f41687a = null;
        }
        AdLogUtil.Log().d("AdmobBanner", "banner destroy" + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void onBannerLoad() {
        try {
            ExistsCheck.a(f.a(), new b());
        } catch (Throwable th2) {
            th2.printStackTrace();
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, Log.getStackTraceString(th2)));
        }
    }

    @Override // com.hisavana.common.base.BaseBanner
    public void showBanner() {
        AdView adView = this.f41687a;
        if (adView != null) {
            adView.setVisibility(0);
        }
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean supportTimer() {
        return false;
    }
}
