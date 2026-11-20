package com.bytedance.sdk.openadsdk.sc.pFF;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We implements PAGNativeAdData {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f28680sc;

    public We(sc scVar) {
        this.f28680sc = scVar;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdChoicesView() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.UFX();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public View getAdLogoView() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.WH();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getButtonText() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.TRI();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getDescription() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.ExN();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGImageItem getIcon() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.zY();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGNativeAdData.PAGNativeMediaType getMediaType() {
        return Sfl.ExN(this.f28680sc.f28688sc) ? PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeVideo : PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeImage;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public PAGMediaView getMediaView() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.qr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData
    public String getTitle() {
        sc scVar = this.f28680sc;
        if (scVar != null) {
            return scVar.We();
        }
        return null;
    }
}
