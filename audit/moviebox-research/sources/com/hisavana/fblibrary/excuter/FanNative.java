package com.hisavana.fblibrary.excuter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.sdk.commonutil.util.f;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeBannerAd;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.view.TIconView;
import com.hisavana.fblibrary.excuter.check.ExistsCheck;
import com.hisavana.fblibrary.excuter.util.PltatformUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FanNative extends BaseNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeAdBase f41784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NativeAdListener f41785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdNativeInfo f41786c;

    /* JADX INFO: renamed from: com.hisavana.fblibrary.excuter.FanNative$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass4 implements Runnable {
        public final /* synthetic */ NativeAdsManager val$nativeAdsManager;

        public AnonymousClass4(NativeAdsManager nativeAdsManager) {
            this.val$nativeAdsManager = nativeAdsManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$nativeAdsManager.loadAds();
            } catch (Exception e11) {
                AdLogUtil.Log().e("FanNative", Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements NativeAdListener {
        public a() {
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad2) {
            AdLogUtil.Log().d("FanNative", "fan ad clicked");
            FanNative fanNative = FanNative.this;
            fanNative.adClicked(fanNative.f41786c);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad2) {
            TAdNativeInfo tAdNativeInfo = PltatformUtil.getTAdNativeInfo(ad2, ((BaseNative) FanNative.this).mAdt, FanNative.this.getTtl(), FanNative.this);
            int iFilter = FanNative.this.filter(tAdNativeInfo);
            if (iFilter == 0) {
                ((BaseNative) FanNative.this).mNatives.add(tAdNativeInfo);
            } else {
                AdUtil.release(tAdNativeInfo);
            }
            if (!((BaseNative) FanNative.this).mNatives.isEmpty()) {
                FanNative fanNative = FanNative.this;
                fanNative.adLoaded(((BaseNative) fanNative).mNatives);
                return;
            }
            FanNative.this.adFailedToLoad(new TAdErrorCode(iFilter, "ad filter"));
            AdLogUtil.Log().w("FanNative", "ad not pass sensitive check or no icon or image filter:" + iFilter);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad2, AdError adError) {
            AdLogUtil.Log().w("FanNative", "fan native is error, error code is " + adError.getErrorCode() + ", error msg is " + adError.getErrorMessage());
            FanNative.this.adFailedToLoad(new TAdErrorCode(adError.getErrorCode(), adError.getErrorMessage()));
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad2) {
            AdLogUtil.Log().d("FanNative", "fan ad impression");
            FanNative fanNative = FanNative.this;
            fanNative.adImpression(fanNative.f41786c);
        }

        @Override // com.facebook.ads.NativeAdListener
        public void onMediaDownloaded(Ad ad2) {
            AdLogUtil.Log().d("FanNative", "fan native ad media download");
        }
    }

    public FanNative(Context context, Network network, int i11) {
        super(context, network, i11);
    }

    public final void a() {
        String codeSeatId;
        super.loadAd();
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fan native load mPlacementId:");
        Network network = this.mNetwork;
        if (network != null) {
            codeSeatId = network.getCodeSeatId();
        } else {
            codeSeatId = "  num:" + this.mAdCount;
        }
        sb2.append(codeSeatId);
        adLogUtilLog.d("FanNative", sb2.toString());
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        NativeAdBase nativeAdBase = this.f41784a;
        if (nativeAdBase != null) {
            nativeAdBase.destroy();
            this.f41784a = null;
        }
        this.f41786c = null;
        AdLogUtil.Log().d("FanNative", "fan destroy" + getLogString());
    }

    @Override // com.hisavana.common.base.BaseNative
    public void initNative() {
        if (this.mNetwork != null) {
            this.f41784a = this.mAdt == 10 ? new NativeBannerAd(f.a().getApplicationContext(), this.mNetwork.getCodeSeatId()) : new NativeAd(f.a().getApplicationContext(), this.mNetwork.getCodeSeatId());
            this.f41785b = new a();
        }
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        if (super.isExpired()) {
            return true;
        }
        NativeAdBase nativeAdBase = this.f41784a;
        if (nativeAdBase != null) {
            return nativeAdBase.isAdInvalidated();
        }
        return false;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public boolean isSupportRtBidding() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseAd
    public boolean isSupportStopRequest() {
        return true;
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.Iad
    public void loadAd() {
        a();
    }

    @Override // com.hisavana.common.base.BaseNative
    public void onNativeAdStartLoad() {
        if (this.f41784a != null) {
            post(PltatformUtil.handler, new Runnable() { // from class: com.hisavana.fblibrary.excuter.FanNative.1

                /* JADX INFO: renamed from: com.hisavana.fblibrary.excuter.FanNative$1$a */
                /* JADX INFO: compiled from: source.java */
                public class a implements AudienceNetworkAds.InitListener {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ long f41787a;

                    public a(long j11) {
                        this.f41787a = j11;
                    }

                    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
                    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
                        AdLogUtil.Log().d("FanNative", "onInitialized " + (System.currentTimeMillis() - this.f41787a));
                        if (initResult == null || !initResult.isSuccess() || FanNative.this.f41784a == null || ((BaseAd) FanNative.this).mNetwork == null) {
                            FanNative.this.adFailedToLoad(new TAdErrorCode(TAdErrorCode.CODE_AD_SOURCE_INIT_FAILED, initResult == null ? "" : initResult.getMessage()));
                            return;
                        }
                        if (TextUtils.isEmpty(((BaseAd) FanNative.this).mNetwork.getBidInfo() != null ? ((BaseAd) FanNative.this).mNetwork.getBidInfo().getPayload() : null)) {
                            FanNative.this.f41784a.loadAd(FanNative.this.f41784a.buildLoadAdConfig().withAdListener(FanNative.this.f41785b).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
                        } else {
                            FanNative.this.f41784a.loadAd(FanNative.this.f41784a.buildLoadAdConfig().withAdListener(FanNative.this.f41785b).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withBid(((BaseAd) FanNative.this).mNetwork.getBidInfo().getPayload()).build());
                            ((BaseAd) FanNative.this).mNetwork.setBidInfo(null);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ExistsCheck.initFan(f.a(), new a(System.currentTimeMillis()));
                    } catch (Exception e11) {
                        AdLogUtil.Log().e("FanNative", "onNativeAdStartLoad " + Log.getStackTraceString(e11));
                    }
                }
            });
        }
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo) {
        this.f41786c = adNativeInfo;
        logTrigerShow(adNativeInfo);
        NativeAdBase nativeAdBase = (NativeAdBase) adNativeInfo.getNativeAdWrapper().getNativeAd();
        if (viewGroup == null || nativeAdBase == null || !nativeAdBase.isAdLoaded()) {
            onAdShowError(adNativeInfo, TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e("FanNative", "registerViewForInteraction show error,adBase is null or expired");
            return;
        }
        unregisterView(adNativeInfo);
        ArrayList<View> arrayList = new ArrayList();
        PltatformUtil.findFbMediaViewAndIconView(viewGroup, arrayList);
        MediaView mediaView = null;
        MediaView mediaView2 = null;
        for (View view : arrayList) {
            if (view instanceof MediaView) {
                if (view.getParent() instanceof TIconView) {
                    mediaView2 = (MediaView) view;
                } else {
                    mediaView = (MediaView) view;
                }
            }
        }
        if (nativeAdBase instanceof NativeAd) {
            ((NativeAd) nativeAdBase).registerViewForInteraction(viewGroup, mediaView, mediaView2, list);
        } else if (nativeAdBase instanceof NativeBannerAd) {
            ((NativeBannerAd) nativeAdBase).registerViewForInteraction(viewGroup, mediaView2, list);
        }
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void unregisterView(AdNativeInfo adNativeInfo) {
        NativeAdBase nativeAdBase = (NativeAdBase) adNativeInfo.getNativeAdWrapper().getNativeAd();
        if (nativeAdBase != null) {
            nativeAdBase.unregisterView();
        }
    }
}
