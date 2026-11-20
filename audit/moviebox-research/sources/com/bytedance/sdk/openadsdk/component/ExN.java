package com.bytedance.sdk.openadsdk.component;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements com.bytedance.sdk.openadsdk.sc.We.pFF {
    private final AtomicBoolean pFF = new AtomicBoolean(false);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGAppOpenAdInteractionListener f27734sc;

    public ExN(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.f27734sc = pAGAppOpenAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.f27734sc;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.We.pFF
    public void pFF() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.pFF.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.f27734sc) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }

    @Override // com.bytedance.sdk.openadsdk.sc.We.pFF
    public void sc() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.f27734sc;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.We.pFF
    public void zY() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.pFF.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.f27734sc) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }
}
