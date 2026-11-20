package com.bytedance.sdk.openadsdk.component.zY;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements com.bytedance.sdk.openadsdk.sc.zY.pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGInterstitialAdInteractionListener f27999sc;

    public sc(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.f27999sc = pAGInterstitialAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.f27999sc;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.zY.pFF
    public void pFF() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.f27999sc;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.zY.pFF
    public void sc() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.f27999sc;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }
}
