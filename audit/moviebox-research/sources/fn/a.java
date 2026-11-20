package fn;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.interfacz.AdShowListener;
import com.hisavana.common.utils.AdLogUtil;
import java.util.ArrayList;
import s9.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: fn.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0674a extends NativeAdWrapper<TaNativeInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseNative f65145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdNativeInfo f65146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f65147c;

        /* JADX INFO: renamed from: fn.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0675a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AdShowListener f65148a;

            public C0675a(AdShowListener adShowListener) {
                this.f65148a = adShowListener;
            }

            @Override // s9.b
            public void p(TaNativeInfo taNativeInfo) {
                C0674a c0674a = C0674a.this;
                c0674a.f65145a.adImpression(c0674a.f65146b);
                AdShowListener adShowListener = this.f65148a;
                if (adShowListener != null) {
                    adShowListener.onAdShow(C0674a.this.f65146b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0674a(TaNativeInfo taNativeInfo, BaseNative baseNative, BaseNative baseNative2, AdNativeInfo adNativeInfo, TaNativeInfo taNativeInfo2) {
            super(taNativeInfo, baseNative);
            this.f65145a = baseNative2;
            this.f65146b = adNativeInfo;
            this.f65147c = taNativeInfo2;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public void destroy() {
            getNativeAd().destroy();
            BaseNative baseNative = this.f65145a;
            if (baseNative != null) {
                baseNative.destroySingleAd(this.f65146b);
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
        public void handleClick() {
            ba.a.b(this.f65147c);
            this.f65145a.adClicked(this.f65146b);
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isExpired() {
            return !getNativeAd().isAdValid();
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isIconValid() {
            return true;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isImageValid() {
            return true;
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isMatchVulgarBrand() {
            return this.f65147c.isMatchVulgarBrand();
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public boolean isMaterielValid() {
            return this.f65145a.isIconAd() ? isIconValid() : isImageValid();
        }

        @Override // com.hisavana.common.bean.NativeAdWrapper
        public void registerViewForInteraction(View view, AdShowListener adShowListener) {
            BaseNative baseNative = this.f65145a;
            if (baseNative == null) {
                return;
            }
            baseNative.logTrigerShow(this.f65146b);
            ba.a.c(this.f65147c, view, new C0675a(adShowListener));
        }
    }

    public static TAdNativeInfo a(TaNativeInfo taNativeInfo, int i11, int i12, BaseNative baseNative) {
        AdNativeInfo.Image image;
        if (taNativeInfo != null && baseNative != null) {
            try {
                AdNativeInfo adNativeInfo = new AdNativeInfo();
                ArrayList arrayList = new ArrayList();
                adNativeInfo.setAdId(DeviceUtil.n());
                adNativeInfo.setTitle(taNativeInfo.getTitle());
                adNativeInfo.setDescription(taNativeInfo.getDescription());
                adNativeInfo.setAdCallToAction(taNativeInfo.getCtatext());
                adNativeInfo.setHisavanaSource(taNativeInfo.getHisavanaSource());
                if (taNativeInfo.getIconImage() == null || TextUtils.isEmpty(taNativeInfo.getIconImage().getImgUrl())) {
                    image = null;
                } else {
                    image = new AdNativeInfo.Image();
                    image.setUrl(taNativeInfo.getIconImage().getImgUrl());
                    image.setWidth(taNativeInfo.getIconImage().getW());
                    image.setHeight(taNativeInfo.getIconImage().getH());
                    image.setDrawable(taNativeInfo.getIconImage().getDrawable());
                    image.setCached(taNativeInfo.getIconImage().isCached());
                }
                adNativeInfo.setIcon(image);
                if (taNativeInfo.getImage() != null) {
                    AdNativeInfo.Image image2 = new AdNativeInfo.Image();
                    image2.setUrl(taNativeInfo.getImage().getImgUrl());
                    image2.setWidth(taNativeInfo.getImage().getW());
                    image2.setHeight(taNativeInfo.getImage().getH());
                    image2.setDrawable(taNativeInfo.getImage().getDrawable());
                    image2.setCached(taNativeInfo.getImage().isCached());
                    arrayList.add(image2);
                }
                adNativeInfo.setImageList(arrayList);
                adNativeInfo.setRating(taNativeInfo.getRating());
                double bidPrice = taNativeInfo.getBidPrice();
                if (taNativeInfo.isDefaultAd()) {
                    bidPrice *= 100.0d;
                }
                if (bidPrice > 0.0d) {
                    adNativeInfo.setEcpmPrice(bidPrice);
                }
                adNativeInfo.setAdType(i11);
                adNativeInfo.setTtl(i12);
                adNativeInfo.setAdSource(baseNative.getAdSource());
                adNativeInfo.setMaterialStyle(taNativeInfo.getMaterialStyle());
                adNativeInfo.setAdCreateId(taNativeInfo.getAdCreateId() == null ? "0" : taNativeInfo.getAdCreateId().toString());
                adNativeInfo.setOfflineAd(taNativeInfo.isOfflineAd());
                adNativeInfo.setPullNewestLive(taNativeInfo.getPullNewestLive());
                adNativeInfo.setPackageName(taNativeInfo.getPackageName());
                adNativeInfo.setAppInfo(taNativeInfo.getAppInfo());
                adNativeInfo.setIconAd(baseNative.isIconAd());
                adNativeInfo.setPullNewestLive(taNativeInfo.getPullNewestLive());
                if (taNativeInfo.getAdItem() != null && taNativeInfo.getPullNewestLive() == 3 && !TextUtils.isEmpty(taNativeInfo.getAdItem().getDeepLinkUrl()) && !taNativeInfo.getAdItem().getDeepLinkUrl().contains("play.google.com")) {
                    adNativeInfo.setDeepLink(taNativeInfo.getAdItem().getDeepLinkUrl());
                }
                adNativeInfo.setTriggerId(baseNative.getTriggerId());
                adNativeInfo.setInternalAd(taNativeInfo.isDefaultAd());
                adNativeInfo.setNativeAdWrapper(new C0674a(taNativeInfo, baseNative, baseNative, adNativeInfo, taNativeInfo));
                return adNativeInfo;
            } catch (Exception e11) {
                AdLogUtil.Log().w("PlatformUtil", Log.getStackTraceString(e11));
            }
        }
        return null;
    }
}
