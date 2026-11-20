package com.hisavana.admoblibrary.holder;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.hisavana.admoblibrary.R$id;
import com.hisavana.admoblibrary.R$layout;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.AdSourceConfig;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NativeAdViewHolder extends BaseNativeViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NativeAdView f41730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, NativeAdView> f41731b = new LinkedHashMap<>();

    public final void a(String str, NativeAdView nativeAdView) {
        try {
            this.f41731b.put(str, nativeAdView);
            if (this.f41731b.size() > 5) {
                AdLogUtil.Log().w("NativeAdViewHolder", "admob container holders exceed the max threshold");
                Map.Entry<String, NativeAdView> next = this.f41731b.entrySet().iterator().next();
                if (next != null) {
                    this.f41731b.remove(next.getKey());
                }
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("NativeAdViewHolder", Log.getStackTraceString(e11));
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void addContentView(View view) {
        if (this.f41730a == null || isCachedAdView()) {
            return;
        }
        AdLogUtil.Log().w("NativeAdViewHolder", "----> admob,addContentView container:" + this.f41730a);
        this.f41730a.removeAllViews();
        this.f41730a.addView(view, 0);
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createMediaView(Context context, TAdNativeInfo tAdNativeInfo) {
        List<TAdNativeInfo.Image> imageList;
        return (AdSourceConfig.isUseMediaView || (imageList = tAdNativeInfo.getImageList()) == null || imageList.isEmpty() || (imageList.get(0).getDrawable() == null && TextUtils.isEmpty(imageList.get(0).getUrl()))) ? new MediaView(context) : new ImageView(context);
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void destroy() {
        super.destroy();
        if (this.f41731b.size() > 0) {
            Iterator<Map.Entry<String, NativeAdView>> it = this.f41731b.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<String, NativeAdView> next = it.next();
                if (next != null && next.getValue() != null) {
                    next.getValue().removeAllViews();
                    try {
                        next.getValue().destroy();
                    } catch (Throwable th2) {
                        AdLogUtil.Log().e("NativeAdViewHolder", Log.getStackTraceString(th2));
                    }
                }
            }
        }
        this.f41731b.clear();
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            nativeAdView.removeAllViews();
            try {
                this.f41730a.destroy();
            } catch (Throwable th3) {
                AdLogUtil.Log().e("NativeAdViewHolder", Log.getStackTraceString(th3));
            }
            this.f41730a = null;
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getContainer(TAdNativeInfo tAdNativeInfo, ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getContext() == null) {
            return null;
        }
        NativeAdView nativeAdView = this.f41731b.get(tAdNativeInfo.getAdId());
        this.f41730a = nativeAdView;
        if (nativeAdView == null) {
            this.f41730a = (NativeAdView) LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R$layout.google_native_app_unified_ad_view, viewGroup, false);
        } else {
            nativeAdView.setTag(R$id.native_view_source, 1);
        }
        return this.f41730a;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getIconView(Context context) {
        View viewCreateIconView = createIconView(context.getApplicationContext());
        this.iconView = viewCreateIconView;
        return viewCreateIconView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getMediaView(Context context, TAdNativeInfo tAdNativeInfo) {
        View viewCreateMediaView = createMediaView(context.getApplicationContext(), tAdNativeInfo);
        this.mediaView = viewCreateMediaView;
        return viewCreateMediaView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public boolean isCachedAdView() {
        NativeAdView nativeAdView = this.f41730a;
        return (nativeAdView == null || nativeAdView.getTag(R$id.native_view_source) == null || ((Integer) this.f41730a.getTag(R$id.native_view_source)).intValue() != 1) ? false : true;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setBodyView(View view) {
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            nativeAdView.setBodyView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setCallToActionOtherView(View view) {
        super.setCallToActionOtherView(view);
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            nativeAdView.setCallToActionView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setCallToActionView(View view) {
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            nativeAdView.setCallToActionView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setHeadlineView(View view) {
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            nativeAdView.setHeadlineView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setIconView(View view) {
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            nativeAdView.setIconView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setMediaView(View view) {
        NativeAdView nativeAdView = this.f41730a;
        if (nativeAdView != null) {
            if (view instanceof MediaView) {
                nativeAdView.setMediaView((MediaView) view);
            } else {
                nativeAdView.setImageView(view);
            }
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setNativeAd(TAdNativeInfo tAdNativeInfo) {
        if (this.f41731b.containsValue(this.f41730a)) {
            AdLogUtil.Log().w("NativeAdViewHolder", "----> admob container has called setNativeAd() before.");
            return;
        }
        if (tAdNativeInfo == null) {
            return;
        }
        try {
            Object nativeAd = tAdNativeInfo.getNativeAdWrapper().getNativeAd();
            NativeAdView nativeAdView = this.f41730a;
            if (nativeAdView == null || !(nativeAd instanceof NativeAd)) {
                return;
            }
            if (nativeAdView.getMediaView() != null) {
                this.f41730a.getMediaView().setMediaContent(((NativeAd) nativeAd).getMediaContent());
            }
            this.f41730a.setNativeAd((NativeAd) nativeAd);
            a(tAdNativeInfo.getAdId(), this.f41730a);
            AdLogUtil.Log().w("NativeAdViewHolder", "----> call setNativeAd()");
        } catch (Exception e11) {
            AdLogUtil.Log().e("NativeAdViewHolder", Log.getStackTraceString(e11));
        }
    }
}
