package com.mbridge.msdk.newout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface IMBRRewardVideoHandler {
    boolean isReady();

    void load();

    void load(String str);

    void setRewardVideoListener(RewardVideoListener rewardVideoListener);

    void show(String str);
}
