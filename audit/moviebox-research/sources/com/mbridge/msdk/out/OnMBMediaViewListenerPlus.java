package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface OnMBMediaViewListenerPlus {
    void onEnterFullscreen();

    void onExitFullscreen();

    void onFinishRedirection(Campaign campaign, String str);

    void onRedirectionFailed(Campaign campaign, String str);

    void onStartRedirection(Campaign campaign, String str);

    void onVideoAdClicked(Campaign campaign);

    void onVideoComplete();

    void onVideoStart();
}
