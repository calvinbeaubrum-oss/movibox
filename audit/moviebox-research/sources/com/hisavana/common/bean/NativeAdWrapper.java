package com.hisavana.common.bean;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.interfacz.AdShowListener;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NativeAdWrapper<T> {
    private BaseNative adImpl;
    private final T nativeAd;

    public NativeAdWrapper(T t11, BaseNative baseNative) {
        this.nativeAd = t11;
        this.adImpl = baseNative;
    }

    @SuppressLint({"RestrictedApi"})
    public abstract void destroy();

    public void detachContext() {
        BaseNative baseNative = this.adImpl;
        if (baseNative != null) {
            baseNative.detachContext();
        }
    }

    public BaseNative getAdImpl() {
        return this.adImpl;
    }

    public T getNativeAd() {
        return this.nativeAd;
    }

    public abstract Bundle getTrackBundle();

    public void handleClick() {
    }

    public boolean isExpired() {
        BaseNative baseNative = this.adImpl;
        if (baseNative != null) {
            return baseNative.isExpired();
        }
        return true;
    }

    public abstract boolean isIconValid();

    public abstract boolean isImageValid();

    public boolean isMatchVulgarBrand() {
        return false;
    }

    public boolean isMaterielValid() {
        return isImageValid() || isIconValid();
    }

    public void registerViewForInteraction(View view, AdShowListener adShowListener) {
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, @NonNull AdNativeInfo adNativeInfo) {
        BaseNative baseNative = this.adImpl;
        if (baseNative != null) {
            baseNative.registerViewForInteraction(viewGroup, list, adNativeInfo);
        }
    }

    public void unregisterView(@NonNull AdNativeInfo adNativeInfo) {
        BaseNative baseNative = this.adImpl;
        if (baseNative != null) {
            baseNative.unregisterView(adNativeInfo);
        }
    }
}
