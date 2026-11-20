package com.hisavana.adxlibrary.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.hisavana.adxlibrary.excuter.AdxNative;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.TAdNativeInfo;
import r9.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NativeAdViewHolder extends BaseNativeViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TNativeView f41758a;

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void addContentView(View view) {
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.addView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createAdBadgeView(Context context, TAdNativeInfo tAdNativeInfo) {
        AdxNative adxNative;
        if (context == null || tAdNativeInfo == null || (adxNative = (AdxNative) tAdNativeInfo.getNativeAdWrapper().getAdImpl()) == null || adxNative.getNativeAd() == null) {
            return null;
        }
        AdBadgeView adBadgeView = new AdBadgeView(context);
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.setAdBagdeView(adBadgeView);
        }
        return adBadgeView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createAdCloseView(Context context, TAdNativeInfo tAdNativeInfo) {
        AdxNative adxNative;
        if (context == null || (adxNative = (AdxNative) tAdNativeInfo.getNativeAdWrapper().getAdImpl()) == null) {
            return null;
        }
        b nativeAd = adxNative.getNativeAd();
        AdCloseView adCloseViewC = nativeAd == null ? null : nativeAd.c(context);
        if (adCloseViewC == null) {
            return null;
        }
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.setAdCloseView(adCloseViewC);
        }
        return adCloseViewC;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createAdDisclaimerView(Context context, TAdNativeInfo tAdNativeInfo) {
        AdxNative adxNative;
        if (context == null || tAdNativeInfo == null || (adxNative = (AdxNative) tAdNativeInfo.getNativeAdWrapper().getAdImpl()) == null || adxNative.getNativeAd() == null) {
            return null;
        }
        AdDisclaimerView adDisclaimerView = new AdDisclaimerView(context);
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.setAdDisclaimerView(adDisclaimerView);
        }
        return adDisclaimerView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createChoicesView(Context context, TAdNativeInfo tAdNativeInfo) {
        AdxNative adxNative;
        if (context == null || (adxNative = (AdxNative) tAdNativeInfo.getNativeAdWrapper().getAdImpl()) == null) {
            return null;
        }
        b nativeAd = adxNative.getNativeAd();
        AdChoicesView adChoicesViewB = nativeAd != null ? nativeAd.b(context, (TaNativeInfo) tAdNativeInfo.getNativeAdWrapper().getNativeAd()) : null;
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.setAdChoiceView(adChoicesViewB);
        }
        return adChoicesViewB;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createMediaView(Context context, TAdNativeInfo tAdNativeInfo) {
        MediaView mediaView = new MediaView(context);
        mediaView.init(tAdNativeInfo.getMime());
        return mediaView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createStoreMarkView(Context context, TAdNativeInfo tAdNativeInfo) {
        if (context == null) {
            return null;
        }
        StoreMarkView storeMarkView = new StoreMarkView(context);
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.setPsMarkView(storeMarkView);
        }
        return storeMarkView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void destroy() {
        super.destroy();
        TNativeView tNativeView = this.f41758a;
        if (tNativeView != null) {
            tNativeView.destroy();
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getContainer(TAdNativeInfo tAdNativeInfo, ViewGroup viewGroup) {
        TNativeView tNativeView = new TNativeView(viewGroup.getContext());
        this.f41758a = tNativeView;
        return tNativeView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setIconView(View view) {
        TNativeView tNativeView = this.f41758a;
        if (tNativeView == null || !(view instanceof ImageView)) {
            return;
        }
        tNativeView.setIconView((ImageView) view);
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setMediaView(View view) {
        TNativeView tNativeView = this.f41758a;
        if (tNativeView == null || !(view instanceof MediaView)) {
            return;
        }
        tNativeView.setMediaView((MediaView) view);
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setNativeAd(TAdNativeInfo tAdNativeInfo) {
        AdImage iconImage;
        if (this.f41758a == null || tAdNativeInfo == null) {
            return;
        }
        Object nativeAd = tAdNativeInfo.getNativeAdWrapper().getNativeAd();
        if (nativeAd instanceof TaNativeInfo) {
            Drawable iconDrawable = tAdNativeInfo.getIconDrawable();
            if (iconDrawable != null && (iconImage = ((TaNativeInfo) nativeAd).getIconImage()) != null) {
                iconImage.setDrawable(iconDrawable);
            }
            this.f41758a.setupViews((TaNativeInfo) nativeAd);
        }
    }
}
