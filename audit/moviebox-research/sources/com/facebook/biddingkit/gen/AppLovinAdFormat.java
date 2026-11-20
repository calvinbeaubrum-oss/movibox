package com.facebook.biddingkit.gen;

import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum AppLovinAdFormat {
    INTERSTITIAL(320, 480, 1, "", "banner", "video"),
    BANNER(320, 50, 0, "", "banner"),
    MREC(LogSeverity.NOTICE_VALUE, 250, 0, "", "banner"),
    REWARDED_VIDEO(480, 320, 0, "rewarded", "banner", "video");

    private final String mFirstFormatLabel;
    private final int mHeight;
    private final int mInstl;
    private final String mRewarded;
    private final String mSecondFormatLabel;
    private final int mWidth;

    AppLovinAdFormat(int i11, int i12, int i13, String str, String str2) {
        this(i11, i12, i13, str, str2, "");
    }

    AppLovinAdFormat(int i11, int i12, int i13, String str, String str2, String str3) {
        this.mWidth = i11;
        this.mHeight = i12;
        this.mInstl = i13;
        this.mRewarded = str;
        this.mFirstFormatLabel = str2;
        this.mSecondFormatLabel = str3;
    }

    public String getFormatLabel() {
        return this.mFirstFormatLabel;
    }

    public int getHeight(boolean z11) {
        return z11 ? this.mWidth : this.mHeight;
    }

    public int getInstl() {
        return this.mInstl;
    }

    public String getRewarded() {
        return this.mRewarded;
    }

    public String getSecondFormatLabelLabel() {
        return this.mSecondFormatLabel;
    }

    public int getWidth(boolean z11) {
        return z11 ? this.mHeight : this.mWidth;
    }
}
