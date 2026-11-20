package com.facebook.ads;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface RewardedInterstitialAdListener extends AdListener {
    void onRewardedInterstitialClosed();

    void onRewardedInterstitialCompleted();
}
