package com.bytedance.sdk.openadsdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface CustomEventInterstitialListener {
    void onInterstitialClicked();

    void onInterstitialDismissed();

    void onInterstitialImpression();

    void onInterstitialShowFail();

    void onInterstitialShown();

    void onLeaveApplication();
}
