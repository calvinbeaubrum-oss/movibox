package com.hisavana.max.util;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.max.check.ExistsCheck;
import com.hisavana.max.executer.MaxNative;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class PlatformUtil {
    public static TAdNativeInfo getTAdNativeInfo(final MaxAd maxAd, int i11, int i12, final BaseNative baseNative) {
        AdNativeInfo.Image image;
        if (maxAd != null) {
            try {
                if (maxAd.getNativeAd() != null && baseNative != null) {
                    final MaxNativeAd nativeAd = maxAd.getNativeAd();
                    final AdNativeInfo adNativeInfo = new AdNativeInfo();
                    if (baseNative.getNetwork() != null) {
                        adNativeInfo.setEcpmPrice(baseNative.getNetwork().getPrice().doubleValue());
                    }
                    adNativeInfo.setTriggerId(baseNative.getTriggerId());
                    adNativeInfo.setNativeAdWrapper(new NativeAdWrapper<MaxNativeAd>(nativeAd, baseNative) { // from class: com.hisavana.max.util.PlatformUtil.1
                        @Override // com.hisavana.common.bean.NativeAdWrapper
                        public void destroy() {
                            MaxNativeAdLoader maxNativeAdLoader;
                            BaseNative baseNative2 = baseNative;
                            if (baseNative2 != null) {
                                if ((baseNative2 instanceof MaxNative) && (maxNativeAdLoader = ((MaxNative) baseNative2).nativeAdLoader) != null) {
                                    maxNativeAdLoader.destroy(maxAd);
                                }
                                baseNative.destroySingleAd(adNativeInfo);
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
                            return (nativeAd.getIcon() == null || nativeAd.getIcon().getUri() == null) ? false : true;
                        }

                        @Override // com.hisavana.common.bean.NativeAdWrapper
                        public boolean isImageValid() {
                            return true;
                        }

                        @Override // com.hisavana.common.bean.NativeAdWrapper
                        public boolean isMaterielValid() {
                            return true;
                        }
                    });
                    adNativeInfo.setAdId(DeviceUtil.n());
                    if (!TextUtils.isEmpty(nativeAd.getTitle())) {
                        adNativeInfo.setTitle(nativeAd.getTitle());
                    }
                    if (!TextUtils.isEmpty(nativeAd.getBody())) {
                        adNativeInfo.setDescription(nativeAd.getBody());
                    }
                    if (!TextUtils.isEmpty(nativeAd.getCallToAction())) {
                        adNativeInfo.setAdCallToAction(nativeAd.getCallToAction());
                    }
                    if (nativeAd.getIcon() == null || nativeAd.getIcon().getUri() == null) {
                        image = null;
                    } else {
                        image = new AdNativeInfo.Image();
                        image.setUrl(nativeAd.getIcon().getUri().toString());
                    }
                    adNativeInfo.setIcon(image);
                    if (nativeAd.getStarRating() != null) {
                        adNativeInfo.setRating(nativeAd.getStarRating().toString());
                    }
                    try {
                        double revenue = maxAd.getRevenue();
                        if (revenue > 0.0d) {
                            adNativeInfo.setEcpmPrice(100.0d * revenue * 1000.0d);
                            AdLogUtil.Log().d(ExistsCheck.MAX_TAG, "onAdLoad，max ptice:" + revenue);
                        }
                    } catch (Exception e11) {
                        AdLogUtil.Log().d(ExistsCheck.MAX_TAG, Log.getStackTraceString(e11));
                    }
                    adNativeInfo.setAdType(i11);
                    adNativeInfo.setTtl(i12);
                    adNativeInfo.setAdSource(baseNative.getAdSource());
                    adNativeInfo.setAdCreateId(adNativeInfo.getAdId());
                    return adNativeInfo;
                }
            } catch (Exception e12) {
                AdLogUtil.Log().w("PlatformUtil", Log.getStackTraceString(e12));
            }
        }
        return null;
    }
}
