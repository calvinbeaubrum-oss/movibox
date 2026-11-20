package com.bytedance.sdk.openadsdk.sc.pFF;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements PAGNativeAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGNativeAdLoadListener f28673sc;

    public ExN(PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        this.f28673sc = pAGNativeAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f28673sc == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.ExN.1
            @Override // java.lang.Runnable
            public void run() {
                ExN.this.f28673sc.onError(i11, str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGNativeAd pAGNativeAd) {
        if (this.f28673sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.ExN.2
            @Override // java.lang.Runnable
            public void run() {
                ExN.this.f28673sc.onAdLoaded(pAGNativeAd);
            }
        });
    }
}
