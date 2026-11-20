package com.mbridge.msdk.out;

import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class RewardInfo implements NoProGuard, Serializable {
    private boolean isCompleteView;
    private int rewardAlertStatus;
    private String rewardAmount;
    private String rewardName;

    public RewardInfo(boolean z11, int i11) {
        this.isCompleteView = z11;
        this.rewardAlertStatus = i11;
    }

    public RewardInfo(boolean z11, String str, String str2) {
        this.isCompleteView = z11;
        this.rewardName = str;
        this.rewardAmount = str2;
    }

    public RewardInfo(boolean z11, String str, String str2, int i11) {
        this.isCompleteView = z11;
        this.rewardName = str;
        this.rewardAmount = str2;
        this.rewardAlertStatus = i11;
    }

    public int getRewardAlertStatus() {
        return this.rewardAlertStatus;
    }

    public String getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public boolean isCompleteView() {
        return this.isCompleteView;
    }

    public void setCompleteView(boolean z11) {
        this.isCompleteView = z11;
    }

    public void setRewardAlertStatus(int i11) {
        this.rewardAlertStatus = i11;
    }

    public void setRewardAmount(String str) {
        this.rewardAmount = str;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public String toString() {
        return "RewardInfo{isCompleteView=" + this.isCompleteView + ", rewardName='" + this.rewardName + "', rewardAmount='" + this.rewardAmount + "', rewardAlertStatus=" + this.rewardAlertStatus + '}';
    }
}
