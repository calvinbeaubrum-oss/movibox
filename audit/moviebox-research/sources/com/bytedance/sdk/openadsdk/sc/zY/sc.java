package com.bytedance.sdk.openadsdk.sc.zY;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements PAGInterstitialAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGInterstitialAdLoadListener f28700sc;

    public sc(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.f28700sc = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f28700sc == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.zY.sc.1
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28700sc != null) {
                    sc.this.f28700sc.onError(i11, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.f28700sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.zY.sc.2
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28700sc != null) {
                    sc.this.f28700sc.onAdLoaded(pAGInterstitialAd);
                }
            }
        });
    }
}
