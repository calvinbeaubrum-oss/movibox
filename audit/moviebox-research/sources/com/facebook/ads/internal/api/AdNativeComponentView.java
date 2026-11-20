package com.facebook.ads.internal.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public abstract class AdNativeComponentView extends RelativeLayout implements AdComponentView {

    @Nullable
    protected AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;

    /* JADX INFO: compiled from: source.java */
    public class a implements AdComponentViewParentApi {
        public a() {
        }

        @Override // com.facebook.ads.internal.api.AdComponentView
        public void addView(View view) {
            AdNativeComponentView.super.addView(view);
        }

        @Override // com.facebook.ads.internal.api.AdComponentView
        public void addView(View view, int i11) {
            AdNativeComponentView.super.addView(view, i11);
        }

        @Override // com.facebook.ads.internal.api.AdComponentView
        public void addView(View view, int i11, int i12) {
            AdNativeComponentView.super.addView(view, i11, i12);
        }

        @Override // com.facebook.ads.internal.api.AdComponentView
        public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
            AdNativeComponentView.super.addView(view, i11, layoutParams);
        }

        @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            AdNativeComponentView.super.addView(view, layoutParams);
        }

        @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
        public void bringChildToFront(View view) {
            AdNativeComponentView.super.bringChildToFront(view);
        }

        @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
        public void onAttachedToWindow() {
            AdNativeComponentView.super.onAttachedToWindow();
        }

        @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
        public void onDetachedFromWindow() {
            AdNativeComponentView.super.onDetachedFromWindow();
        }

        @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
        public void onMeasure(int i11, int i12) {
            AdNativeComponentView.super.onMeasure(i11, i12);
        }

        @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
        public void onVisibilityChanged(View view, int i11) {
            AdNativeComponentView.super.onVisibilityChanged(view, i11);
        }

        @Override // com.facebook.ads.internal.api.AdComponentView
        public void onWindowFocusChanged(boolean z11) {
            AdNativeComponentView.super.onWindowFocusChanged(z11);
        }

        @Override // com.facebook.ads.internal.api.AdComponentView
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            AdNativeComponentView.super.setLayoutParams(layoutParams);
        }

        @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
        public void setMeasuredDimension(int i11, int i12) {
            AdNativeComponentView.super.setMeasuredDimension(i11, i12);
        }
    }

    public AdNativeComponentView(Context context) {
        super(context);
        this.mAdComponentViewParentApi = new a();
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdComponentViewParentApi = new a();
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mAdComponentViewParentApi = new a();
    }

    @RequiresApi(api = 21)
    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mAdComponentViewParentApi = new a();
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view);
        } else {
            super.addView(view);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i11) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i11);
        } else {
            super.addView(view, i11);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i11, int i12) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i11, i12);
        } else {
            super.addView(view, i11, i12);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }

    public void attachAdComponentViewApi(AdComponentViewApiProvider adComponentViewApiProvider) {
        if (DynamicLoaderFactory.isFallbackMode()) {
            return;
        }
        if (this.mAdComponentViewApi != null) {
            throw new IllegalStateException("AdComponentViewApi can't be attached more then once.");
        }
        adComponentViewApiProvider.getAdComponentViewApi().onAttachedToView(this, this.mAdComponentViewParentApi);
        this.mAdComponentViewApi = adComponentViewApiProvider.getAdComponentViewApi();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.bringChildToFront(view);
        } else {
            super.bringChildToFront(view);
        }
    }

    public abstract View getAdContentsView();

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void onAttachedToWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onMeasure(i11, i12);
        } else {
            super.onMeasure(i11, i12);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i11) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onVisibilityChanged(view, i11);
        } else {
            super.onVisibilityChanged(view, i11);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void onWindowFocusChanged(boolean z11) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onWindowFocusChanged(z11);
        } else {
            super.onWindowFocusChanged(z11);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(layoutParams);
        }
    }
}
