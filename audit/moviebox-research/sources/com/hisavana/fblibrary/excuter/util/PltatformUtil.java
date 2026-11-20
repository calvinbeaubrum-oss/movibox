package com.hisavana.fblibrary.excuter.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.facebook.ads.Ad;
import com.facebook.ads.AdSettings;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeBannerAd;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class PltatformUtil {
    public static Handler handler;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class a extends NativeAdWrapper<NativeAd> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseNative f41806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdNativeInfo f41807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NativeAd f41808c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NativeAd nativeAd, BaseNative baseNative, BaseNative baseNative2, AdNativeInfo adNativeInfo, NativeAd nativeAd2) {
            super(nativeAd, baseNative);
            this.f41806a = baseNative2;
            this.f41807b = adNativeInfo;
            this.f41808c = nativeAd2;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public void destroy() {
            getNativeAd().destroy();
            BaseNative baseNative = this.f41806a;
            if (baseNative != null) {
                baseNative.destroySingleAd(this.f41807b);
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
        public boolean isExpired() {
            return this.f41808c.isAdInvalidated();
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isIconValid() {
            return getNativeAd().getAdIcon() != null;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isImageValid() {
            return getNativeAd().getAdCoverImage() != null;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isMaterielValid() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public class b extends NativeAdWrapper<NativeBannerAd> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NativeBannerAd f41809a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NativeBannerAd nativeBannerAd, BaseNative baseNative, NativeBannerAd nativeBannerAd2) {
            super(nativeBannerAd, baseNative);
            this.f41809a = nativeBannerAd2;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public void destroy() {
            getNativeAd().destroy();
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public Bundle getTrackBundle() {
            if (getAdImpl() != null) {
                return getAdImpl().mBundle;
            }
            return null;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isExpired() {
            return this.f41809a.isAdInvalidated();
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isIconValid() {
            return getNativeAd().getAdIcon() != null;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isImageValid() {
            return false;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isMaterielValid() {
            return true;
        }
    }

    public static void addTestDevice(Context context) {
        if (AdSettings.isTestMode(context)) {
            return;
        }
        String strJ = da.a.d().j("deviceIdHash", null);
        if (TextUtils.isEmpty(strJ)) {
            return;
        }
        AdSettings.addTestDevice(strJ);
    }

    public static void addTestDevices(Collection<String> collection) {
        AdSettings.addTestDevices(collection);
    }

    public static void clearTestDevices() {
        AdSettings.clearTestDevices();
    }

    @SuppressLint({"RestrictedApi"})
    public static void findFbMediaViewAndIconView(ViewGroup viewGroup, List<View> list) {
        Preconditions.b(list);
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof MediaView) {
                list.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                findFbMediaViewAndIconView((ViewGroup) childAt, list);
            }
        }
    }

    public static TAdNativeInfo getTAdNativeInfo(Ad ad2, int i11, int i12, BaseNative baseNative) {
        AdNativeInfo.Image image;
        AdNativeInfo.Image image2;
        if (ad2 != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (ad2 instanceof NativeAd) {
                    AdNativeInfo adNativeInfo = new AdNativeInfo();
                    NativeAd nativeAd = (NativeAd) ad2;
                    adNativeInfo.setAdId(nativeAd.getId());
                    adNativeInfo.setTitle(nativeAd.getAdvertiserName());
                    adNativeInfo.setDescription(nativeAd.getAdBodyText());
                    adNativeInfo.setSocialContext(nativeAd.getAdSocialContext());
                    adNativeInfo.setSponsoredTranslation(nativeAd.getSponsoredTranslation());
                    adNativeInfo.setAdCallToAction(nativeAd.getAdCallToAction());
                    if (baseNative != null && baseNative.getNetwork() != null) {
                        adNativeInfo.setEcpmPrice(baseNative.getNetwork().getPrice().doubleValue());
                    }
                    if (nativeAd.getAdIcon() != null) {
                        image2 = new AdNativeInfo.Image();
                        image2.setWidth(nativeAd.getAdIcon().getWidth());
                        image2.setHeight(nativeAd.getAdIcon().getHeight());
                    } else {
                        image2 = null;
                    }
                    adNativeInfo.setIcon(image2);
                    if (nativeAd.getAdCoverImage() != null) {
                        AdNativeInfo.Image image3 = new AdNativeInfo.Image();
                        image3.setWidth(nativeAd.getAdCoverImage().getWidth());
                        image3.setHeight(nativeAd.getAdCoverImage().getHeight());
                        image3.setUrl(nativeAd.getAdCoverImage().getUrl());
                        arrayList.add(image3);
                    }
                    adNativeInfo.setImageList(arrayList);
                    adNativeInfo.setTriggerId(baseNative == null ? null : baseNative.getTriggerId());
                    adNativeInfo.setNativeAdWrapper(new a(nativeAd, baseNative, baseNative, adNativeInfo, nativeAd));
                    adNativeInfo.setAdType(i11);
                    adNativeInfo.setTtl(i12);
                    if (baseNative != null) {
                        adNativeInfo.setAdSource(baseNative.getAdSource());
                    }
                    return adNativeInfo;
                }
                if (ad2 instanceof NativeBannerAd) {
                    AdNativeInfo adNativeInfo2 = new AdNativeInfo();
                    NativeBannerAd nativeBannerAd = (NativeBannerAd) ad2;
                    adNativeInfo2.setAdId(nativeBannerAd.getId());
                    adNativeInfo2.setTitle(nativeBannerAd.getAdvertiserName());
                    adNativeInfo2.setDescription(nativeBannerAd.getAdBodyText());
                    adNativeInfo2.setSocialContext(nativeBannerAd.getAdSocialContext());
                    adNativeInfo2.setSponsoredTranslation(nativeBannerAd.getSponsoredTranslation());
                    adNativeInfo2.setAdCallToAction(nativeBannerAd.getAdCallToAction());
                    if (nativeBannerAd.getAdIcon() != null) {
                        image = new AdNativeInfo.Image();
                        image.setWidth(nativeBannerAd.getAdIcon().getWidth());
                        image.setHeight(nativeBannerAd.getAdIcon().getHeight());
                    } else {
                        image = null;
                    }
                    adNativeInfo2.setIcon(image);
                    adNativeInfo2.setImageList(arrayList);
                    adNativeInfo2.setTriggerId(baseNative == null ? null : baseNative.getTriggerId());
                    adNativeInfo2.setNativeAdWrapper(new b(nativeBannerAd, baseNative, nativeBannerAd));
                    adNativeInfo2.setAdType(i11);
                    adNativeInfo2.setTtl(i12);
                    adNativeInfo2.setAdSource(baseNative == null ? 2 : baseNative.getAdSource());
                    return adNativeInfo2;
                }
            } catch (Exception e11) {
                AdLogUtil.Log().w("PlatformUtil", Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public static boolean isTestMode(Context context) {
        return AdSettings.isTestMode(context);
    }

    public static void setDebugBuild(boolean z11) {
        AdSettings.setDebugBuild(z11);
    }
}
