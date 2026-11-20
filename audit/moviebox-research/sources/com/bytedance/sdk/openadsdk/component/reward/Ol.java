package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol implements com.bytedance.sdk.openadsdk.sc.ExN.sc {
    private final PAGRewardedAdInteractionCallback pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PAGRewardedAdInteractionListener f27799sc;

    public Ol(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.pFF = pAGRewardedAdInteractionCallback;
        this.f27799sc = null;
    }

    public Ol(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.f27799sc = pAGRewardedAdInteractionListener;
        this.pFF = null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.f27799sc;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdClicked();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.pFF;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.ExN.sc
    public void pFF() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.f27799sc;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdDismissed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.pFF;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.ExN.sc
    public void sc() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.f27799sc;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdShowed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.pFF;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sc.ExN.sc
    public void sc(boolean z11, int i11, String str, int i12, String str2) {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.f27799sc;
        if (pAGRewardedAdInteractionListener != null) {
            if (z11) {
                pAGRewardedAdInteractionListener.onUserEarnedReward(new PAGRewardItem(i11, str));
                return;
            } else {
                pAGRewardedAdInteractionListener.onUserEarnedRewardFail(i12, str2);
                return;
            }
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.pFF;
        if (pAGRewardedAdInteractionCallback != null) {
            if (z11) {
                pAGRewardedAdInteractionCallback.onUserEarnedReward(new PAGRewardItem(i11, str));
            } else {
                pAGRewardedAdInteractionCallback.onUserEarnedRewardFail(new PAGErrorModel(i12, str2));
            }
        }
    }
}
