package com.bytedance.sdk.openadsdk.api.reward;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGRewardItem {
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f27681sc;

    public PAGRewardItem(int i11, String str) {
        this.f27681sc = i11;
        this.pFF = str;
    }

    public int getRewardAmount() {
        return this.f27681sc;
    }

    public String getRewardName() {
        return this.pFF;
    }
}
