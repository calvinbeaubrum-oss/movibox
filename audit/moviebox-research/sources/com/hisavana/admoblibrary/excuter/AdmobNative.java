package com.hisavana.admoblibrary.excuter;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.f;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.hisavana.admoblibrary.check.ExistsCheck;
import com.hisavana.admoblibrary.util.PlatformUtil;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.AdmobInitUtil;
import com.transsion.push.PushConstants;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AdmobNative extends BaseNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdLoader f41698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdLoader.Builder f41699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f41700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f41702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdNativeInfo f41703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f41704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f41705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HandlerThread f41706i;

    /* JADX INFO: compiled from: source.java */
    public class a implements ExistsCheck.b {
        public a() {
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void a() {
            AdmobNative.this.adFailedToLoad(TAdErrorCode.ERROR_AD_SOURCE_INIT_FAILED);
        }

        @Override // com.hisavana.admoblibrary.check.ExistsCheck.b
        public void b() {
            if (((BaseAd) AdmobNative.this).mNetwork == null || TextUtils.isEmpty(((BaseAd) AdmobNative.this).mNetwork.getCodeSeatId())) {
                AdmobNative.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, "codeSeatId is null"));
                return;
            }
            AdmobNative.this.f41699b = new AdLoader.Builder(f.a(), ((BaseAd) AdmobNative.this).mNetwork.getCodeSeatId().trim());
            AdLogUtil.Log().d("AdmobNative", "start load native ad");
            AdmobNative.this.a();
            AdmobNative.this.c();
            AdmobNative.this.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AdListener {
        public b() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            super.onAdClicked();
            AdmobNative admobNative = AdmobNative.this;
            admobNative.adClicked(admobNative.f41703f);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            super.onAdClosed();
            AdmobNative.this.adClosed();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            AdLogUtil adLogUtilLog = AdLogUtil.Log();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ad load failed, error ");
            sb2.append(loadAdError != null ? loadAdError.toString() : "");
            adLogUtilLog.w("AdmobNative", sb2.toString());
            if (AdmobNative.this.f41698a == null) {
                AdLogUtil.Log().d("AdmobNative", " adLoader isLoading");
                return;
            }
            if ((AdmobNative.this.isIconAd() && AdmobNative.this.f41698a.isLoading()) || AdmobNative.this.f41701d) {
                AdLogUtil.Log().d("AdmobNative", " adLoader load fail");
            } else {
                AdmobNative.this.b();
                AdmobNative.this.a(new TAdErrorCode(loadAdError != null ? loadAdError.getCode() : TAdErrorCode.CODE_AD_REQUEST_FAILED, loadAdError != null ? loadAdError.getMessage() : ""));
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            AdLogUtil.Log().d("AdmobNative", "ad impression");
            AdmobNative admobNative = AdmobNative.this;
            admobNative.adImpression(admobNative.f41703f);
        }
    }

    public AdmobNative(Context context, Network network, int i11) {
        super(context, network, i11);
        this.f41699b = null;
        this.f41701d = false;
        this.f41704g = 0;
        this.f41705h = 0;
        this.f41706i = AdmobInitUtil.getHanderThread();
        AdmobInitUtil.start();
        this.f41700c = new Handler(this.f41706i.getLooper());
        this.f41702e = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(AdValue adValue) {
        long valueMicros = adValue.getValueMicros();
        String currencyCode = adValue.getCurrencyCode();
        int precisionType = adValue.getPrecisionType();
        AdLogUtil.Log().d("AdmobNative", "onPaidEvent valueMicros " + valueMicros + ",currencyCode " + currencyCode + ",precisionType " + precisionType);
        admobShowPriceTracking((float) valueMicros, currencyCode, precisionType);
        onAdditionalShowed(valueMicros, currencyCode, precisionType);
    }

    public final void a() {
        NativeAdOptions.Builder videoOptions = new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(AdMuteStatus.MUTE_ALL).setClickToExpandRequested(true).build());
        int i11 = this.f41704g;
        if (i11 == 4) {
            i11 = 0;
        }
        this.f41699b.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.hisavana.admoblibrary.excuter.c
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public final void onNativeAdLoaded(NativeAd nativeAd) {
                this.f41728a.d(nativeAd);
            }
        }).withNativeAdOptions(videoOptions.setAdChoicesPlacement(i11).setMediaAspectRatio(this.f41705h).build());
    }

    public final void a(TAdErrorCode tAdErrorCode) {
        if (this.f41698a == null) {
            AdLogUtil.Log().d("AdmobNative", " adLoader isLoading");
        } else if (this.mNatives.isEmpty()) {
            adFailedToLoad(tAdErrorCode);
        } else {
            adLoaded(this.mNatives);
        }
    }

    public final void b() {
        Handler handler;
        if (!isIconAd() || (handler = this.f41702e) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f41702e = null;
    }

    public final void c() {
        this.f41698a = this.f41699b.withAdListener(new b()).build();
    }

    public final void d() {
        Handler handler;
        if (this.f41699b == null) {
            AdLogUtil.Log().d("AdmobNative", "builder is null");
            return;
        }
        AdLoader adLoader = this.f41698a;
        if (adLoader == null || adLoader.isLoading()) {
            return;
        }
        try {
            this.f41698a.loadAds(PlatformUtil.a(), this.mAdCount);
            if (!isIconAd() || (handler = this.f41702e) == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.hisavana.admoblibrary.excuter.AdmobNative.1
                @Override // java.lang.Runnable
                public void run() {
                    AdmobNative.this.f41701d = true;
                    AdmobNative.this.a(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT);
                }
            }, 30000L);
        } catch (Throwable th2) {
            AdLogUtil.Log().e("AdmobNative", Log.getStackTraceString(th2));
        }
    }

    public final /* synthetic */ void d(NativeAd nativeAd) {
        TAdNativeInfo tAdNativeInfoA;
        if (nativeAd.getResponseInfo() != null && nativeAd.getResponseInfo().getLoadedAdapterResponseInfo() != null) {
            String adSourceName = nativeAd.getResponseInfo().getLoadedAdapterResponseInfo().getAdSourceName();
            AdLogUtil.Log().d("AdmobNative", "onNativeAdLoaded----->> mediator source: " + adSourceName);
            setAdmobMediatorInfo(adSourceName);
        }
        if (this.f41701d) {
            try {
                nativeAd.destroy();
                return;
            } catch (Throwable th2) {
                AdLogUtil.Log().e("AdmobNative", Log.getStackTraceString(th2));
                return;
            }
        }
        if (this.f41698a == null) {
            try {
                nativeAd.destroy();
            } catch (Throwable th3) {
                AdLogUtil.Log().e("AdmobNative", Log.getStackTraceString(th3));
            }
            AdLogUtil.Log().w("AdmobNative", "adLoader is null");
            return;
        }
        try {
            tAdNativeInfoA = PlatformUtil.a(nativeAd, this.mAdt, getTtl(), this);
        } catch (Exception e11) {
            AdLogUtil.Log().e("AdmobNative", "onNativeAdLoaded " + Log.getStackTraceString(e11));
            tAdNativeInfoA = null;
        }
        nativeAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.hisavana.admoblibrary.excuter.d
            @Override // com.google.android.gms.ads.OnPaidEventListener
            public final void onPaidEvent(AdValue adValue) {
                this.f41729a.c(adValue);
            }
        });
        int iFilter = filter(tAdNativeInfoA);
        if (iFilter == 0) {
            this.mNatives.add(tAdNativeInfoA);
        } else {
            AdUtil.release(tAdNativeInfoA);
        }
        AdLoader adLoader = this.f41698a;
        if (adLoader == null || adLoader.isLoading()) {
            return;
        }
        b();
        AdLogUtil.Log().d("AdmobNative", " ad load finish ==" + this.mNatives.size());
        if (!this.mNatives.isEmpty()) {
            adLoaded(this.mNatives);
            return;
        }
        adFailedToLoad(new TAdErrorCode(iFilter, "adMob load failed filter"));
        AdLogUtil.Log().w("AdmobNative", "ad not pass sensitive check or no icon or image filter:" + iFilter);
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f41698a = null;
        b();
        this.f41703f = null;
        AdLogUtil.Log().d("AdmobNative", PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseNative
    public void initNative() {
        try {
            ExistsCheck.a(f.a(), new a());
        } catch (Exception e11) {
            AdLogUtil.Log().d("AdmobNative", Log.getStackTraceString(e11));
            adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_REQUEST_FAILED, Log.getStackTraceString(e11)));
        }
    }

    @Override // com.hisavana.common.base.BaseNative
    public boolean isNativeBanner() {
        return false;
    }

    @Override // com.hisavana.common.base.BaseNative
    public void onNativeAdStartLoad() {
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo) {
        this.f41703f = adNativeInfo;
        logTrigerShow(adNativeInfo);
    }

    @Override // com.hisavana.common.base.BaseNative
    public void setAdmobMediaAspectRatio(int i11) {
        this.f41705h = i11;
    }

    @Override // com.hisavana.common.base.BaseNative
    public void setChoicesPosition(int i11) {
        this.f41704g = i11;
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean supportTimer() {
        return false;
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void unregisterView(@NonNull AdNativeInfo adNativeInfo) {
    }
}
