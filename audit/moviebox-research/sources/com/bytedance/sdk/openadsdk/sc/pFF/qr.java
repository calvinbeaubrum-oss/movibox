package com.bytedance.sdk.openadsdk.sc.pFF;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr implements TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGNativeAdInteractionListener f28683sc;

    public qr(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.f28683sc = pAGNativeAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.qr.1
            @Override // java.lang.Runnable
            public void run() {
                if (qr.this.f28683sc != null) {
                    qr.this.f28683sc.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.sc.pFF.TRI
    public boolean pFF() {
        return this.f28683sc != null;
    }

    @Override // com.bytedance.sdk.openadsdk.sc.pFF.TRI
    public void sc() {
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.qr.3
            @Override // java.lang.Runnable
            public void run() {
                if (qr.this.f28683sc != null) {
                    qr.this.f28683sc.onAdDismissed();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.sc.pFF.TRI
    public void sc(PAGNativeAd pAGNativeAd) {
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.qr.2
            @Override // java.lang.Runnable
            public void run() {
                if (qr.this.f28683sc != null) {
                    qr.this.f28683sc.onAdShowed();
                }
            }
        });
    }
}
