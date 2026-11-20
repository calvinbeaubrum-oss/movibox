package com.bytedance.sdk.openadsdk.sc.sc;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements PAGBannerAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGBannerAdLoadListener f28697sc;

    public sc(PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        this.f28697sc = pAGBannerAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f28697sc == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.sc.sc.1
            @Override // java.lang.Runnable
            public void run() {
                sc.this.f28697sc.onError(i11, str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGBannerAd pAGBannerAd) {
        if (this.f28697sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.sc.sc.2
            @Override // java.lang.Runnable
            public void run() {
                sc.this.f28697sc.onAdLoaded(pAGBannerAd);
            }
        });
    }
}
