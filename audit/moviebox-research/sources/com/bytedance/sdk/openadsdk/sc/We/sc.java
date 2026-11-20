package com.bytedance.sdk.openadsdk.sc.We;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements PAGAppOpenAdLoadListener {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGAppOpenAdLoadListener f28670sc;

    public sc(PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        this.f28670sc = pAGAppOpenAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.TRI
    public void onError(final int i11, final String str) {
        if (this.f28670sc == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.We.sc.1
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28670sc != null) {
                    sc.this.f28670sc.onError(i11, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGAppOpenAd pAGAppOpenAd) {
        if (this.f28670sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sc.We.sc.2
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28670sc != null) {
                    sc.this.f28670sc.onAdLoaded(pAGAppOpenAd);
                }
            }
        });
    }
}
