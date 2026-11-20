package com.bytedance.sdk.openadsdk.component.zY;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements PAGInterstitialAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final PAGInterstitialAdLoadListener f27996sc;

    public pFF(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.f27996sc = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f27996sc != null) {
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.zY.pFF.1
                @Override // java.lang.Runnable
                public void run() {
                    PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = pFF.this.f27996sc;
                    if (pAGInterstitialAdLoadListener != null) {
                        pAGInterstitialAdLoadListener.onError(i11, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.f27996sc != null) {
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.zY.pFF.2
                @Override // java.lang.Runnable
                public void run() {
                    PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = pFF.this.f27996sc;
                    if (pAGInterstitialAdLoadListener != null) {
                        pAGInterstitialAdLoadListener.onAdLoaded(pAGInterstitialAd);
                    }
                }
            });
        }
    }
}
