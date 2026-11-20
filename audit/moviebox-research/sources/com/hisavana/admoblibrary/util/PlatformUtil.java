package com.hisavana.admoblibrary.util;

import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.f;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.NativeAd;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.infra.gateway.core.utils.b;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class PlatformUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f41732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f41733b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f41734c = "";

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a extends NativeAdWrapper<NativeAd> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseNative f41735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdNativeInfo f41736b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NativeAd nativeAd, BaseNative baseNative, BaseNative baseNative2, AdNativeInfo adNativeInfo) {
            super(nativeAd, baseNative);
            this.f41735a = baseNative2;
            this.f41736b = adNativeInfo;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public void destroy() {
            BaseNative baseNative = this.f41735a;
            if (baseNative != null) {
                baseNative.destroySingleAd(this.f41736b);
            }
            try {
                getNativeAd().destroy();
            } catch (Throwable th2) {
                AdLogUtil.Log().e("admob PlatformUtil", Log.getStackTraceString(th2));
            }
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public Bundle getTrackBundle() {
            if (getAdImpl() != null) {
                return getAdImpl().mBundle;
            }
            return null;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isIconValid() {
            return (getNativeAd().getIcon() == null || getNativeAd().getIcon().getDrawable() == null) ? false : true;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isImageValid() {
            return this.f41736b.getImageList().size() > 0;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isMaterielValid() {
            return true;
        }
    }

    public static AdRequest a() {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.setHttpTimeoutMillis(ComConstants.AD_TIMEOUT_MILLIS);
        return builder.build();
    }

    public static AdRequest a(int i11) {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.setHttpTimeoutMillis(ComConstants.AD_TIMEOUT_MILLIS);
        if (i11 != 0) {
            Bundle bundle = new Bundle();
            if (i11 == 1) {
                bundle.putString("collapsible", "top");
            } else {
                bundle.putString("collapsible", "bottom");
            }
            bundle.putString("collapsible_request_id", UUID.randomUUID().toString());
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        return builder.build();
    }

    public static TAdNativeInfo a(Object obj, int i11, int i12, BaseNative baseNative) {
        AdNativeInfo.Image image;
        VideoController videoController;
        if (obj != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (obj instanceof NativeAd) {
                    AdNativeInfo adNativeInfo = new AdNativeInfo();
                    NativeAd nativeAd = (NativeAd) obj;
                    if (baseNative != null && baseNative.getNetwork() != null) {
                        adNativeInfo.setEcpmPrice(baseNative.getNetwork().getPrice().doubleValue());
                    }
                    adNativeInfo.setTriggerId(baseNative == null ? null : baseNative.getTriggerId());
                    adNativeInfo.setNativeAdWrapper(new a(nativeAd, baseNative, baseNative, adNativeInfo));
                    adNativeInfo.setAdId(DeviceUtil.n());
                    if (nativeAd.getHeadline() != null) {
                        adNativeInfo.setTitle(nativeAd.getHeadline().toString());
                    }
                    if (nativeAd.getBody() != null) {
                        adNativeInfo.setDescription(nativeAd.getBody().toString());
                    }
                    if (nativeAd.getCallToAction() != null) {
                        adNativeInfo.setAdCallToAction(nativeAd.getCallToAction().toString());
                    }
                    if (nativeAd.getStarRating() != null) {
                        adNativeInfo.setRating(nativeAd.getStarRating() + "");
                    }
                    if (nativeAd.getPrice() != null) {
                        adNativeInfo.setSaleprice(nativeAd.getPrice());
                    }
                    if (nativeAd.getIcon() != null) {
                        image = new AdNativeInfo.Image();
                        if (nativeAd.getIcon().getDrawable() != null) {
                            image.setDrawable(nativeAd.getIcon().getDrawable());
                            image.setUrl(nativeAd.getIcon().getUri() != null ? nativeAd.getIcon().getUri().toString() : "");
                        }
                    } else {
                        image = null;
                    }
                    adNativeInfo.setIcon(image);
                    if (nativeAd.getMediaContent() != null) {
                        try {
                            videoController = nativeAd.getMediaContent().getVideoController();
                        } catch (Exception unused) {
                            videoController = null;
                        }
                    } else {
                        videoController = null;
                    }
                    if (videoController != null && videoController.hasVideoContent()) {
                        AdNativeInfo.Image image2 = new AdNativeInfo.Image();
                        image2.setRatio(nativeAd.getMediaContent().getAspectRatio());
                        arrayList.add(image2);
                    } else if (nativeAd.getImages() != null && !nativeAd.getImages().isEmpty()) {
                        AdNativeInfo.Image image3 = new AdNativeInfo.Image();
                        if (nativeAd.getImages().get(0) != null) {
                            image3.setDrawable(nativeAd.getImages().get(0).getDrawable());
                        }
                        if (nativeAd.getImages().get(0) != null && nativeAd.getImages().get(0).getUri() != null) {
                            image3.setUrl(nativeAd.getImages().get(0).getUri().toString());
                        }
                        arrayList.add(image3);
                    }
                    adNativeInfo.setImageList(arrayList);
                    adNativeInfo.setAdType(i11);
                    adNativeInfo.setTtl(i12);
                    adNativeInfo.setAdSource(baseNative.getAdSource());
                    adNativeInfo.setAdCreateId(adNativeInfo.getAdId());
                    adNativeInfo.setIconAd(baseNative.isIconAd());
                    return adNativeInfo;
                }
            } catch (Exception e11) {
                AdLogUtil.Log().w("PlatformUtil", Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f41734c)) {
            return f41734c;
        }
        String string = Settings.Secure.getString(f.a().getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim();
        }
        String strA = TextUtils.isEmpty(string) ? "" : b.a(string);
        f41734c = strA;
        return strA;
    }
}
