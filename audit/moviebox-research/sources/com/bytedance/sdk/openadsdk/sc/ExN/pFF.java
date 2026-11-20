package com.bytedance.sdk.openadsdk.sc.ExN;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements PAGRewardedAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGRewardedAdLoadListener f28667sc;

    public pFF(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.f28667sc = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f28667sc == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.ExN.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                if (pFF.this.f28667sc != null) {
                    pFF.this.f28667sc.onError(i11, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.f28667sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.ExN.pFF.2
            @Override // java.lang.Runnable
            public void run() {
                if (pFF.this.f28667sc != null) {
                    pFF.this.f28667sc.onAdLoaded(pAGRewardedAd);
                }
            }
        });
    }
}
