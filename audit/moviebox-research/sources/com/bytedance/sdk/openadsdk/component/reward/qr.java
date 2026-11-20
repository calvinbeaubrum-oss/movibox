package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr implements PAGRewardedAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final PAGRewardedAdLoadListener f27846sc;

    public qr(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.f27846sc = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f27846sc != null) {
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.qr.1
                @Override // java.lang.Runnable
                public void run() {
                    PAGRewardedAdLoadListener pAGRewardedAdLoadListener = qr.this.f27846sc;
                    if (pAGRewardedAdLoadListener != null) {
                        pAGRewardedAdLoadListener.onError(i11, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.f27846sc != null) {
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.qr.2
                @Override // java.lang.Runnable
                public void run() {
                    PAGRewardedAdLoadListener pAGRewardedAdLoadListener = qr.this.f27846sc;
                    if (pAGRewardedAdLoadListener != null) {
                        pAGRewardedAdLoadListener.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
