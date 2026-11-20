package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import com.applovin.mediation.MaxReward;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxRewardImpl implements MaxReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20701b;

    private MaxRewardImpl(int i11, String str) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
        }
        this.f20700a = str;
        this.f20701b = i11;
    }

    public static MaxReward create(int i11, String str) {
        return new MaxRewardImpl(i11, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    @Override // com.applovin.mediation.MaxReward
    public final int getAmount() {
        return this.f20701b;
    }

    @Override // com.applovin.mediation.MaxReward
    public final String getLabel() {
        return this.f20700a;
    }

    @NonNull
    public String toString() {
        return "MaxReward{amount=" + this.f20701b + ", label=" + this.f20700a + "}";
    }
}
