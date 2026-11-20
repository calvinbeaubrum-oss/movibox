package com.hisavana.fblibrary.excuter.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.fblibrary.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NativeAdViewHolder extends BaseNativeViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaView f41804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NativeAdLayout f41805b;

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void addContentView(View view) {
        NativeAdLayout nativeAdLayout = this.f41805b;
        if (nativeAdLayout != null) {
            nativeAdLayout.removeAllViews();
            this.f41805b.addView(view);
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createChoicesView(Context context, TAdNativeInfo tAdNativeInfo) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.addView(new AdOptionsView(context, (NativeAdBase) tAdNativeInfo.getNativeAdWrapper().getNativeAd(), this.f41805b), 0);
        return linearLayout;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createIconView(Context context) {
        return new MediaView(context);
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View createMediaView(Context context, TAdNativeInfo tAdNativeInfo) {
        MediaView mediaView = new MediaView(context);
        this.f41804a = mediaView;
        return mediaView;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void destroy() {
        super.destroy();
        MediaView mediaView = this.f41804a;
        if (mediaView != null) {
            mediaView.destroy();
            this.f41804a = null;
        }
        NativeAdLayout nativeAdLayout = this.f41805b;
        if (nativeAdLayout != null) {
            nativeAdLayout.removeAllViews();
            this.f41805b = null;
        }
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getContainer(TAdNativeInfo tAdNativeInfo, ViewGroup viewGroup) {
        NativeAdLayout nativeAdLayout = (NativeAdLayout) LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R$layout.fb_native_ad_view, viewGroup, false);
        this.f41805b = nativeAdLayout;
        return nativeAdLayout;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setIconDrawable(Drawable drawable) {
    }
}
