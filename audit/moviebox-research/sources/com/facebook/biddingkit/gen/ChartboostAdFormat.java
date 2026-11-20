package com.facebook.biddingkit.gen;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum ChartboostAdFormat {
    INTERSTITIAL(true, 1, 480, 320, 7, "interstitial"),
    REWARDED_VIDEO(true, 1, 480, 320, 7, "rewarded"),
    BANNER(false, 0, 50, 320, 1, "banner");

    private final boolean mHasVideo;
    private final int mHeight;
    private final int mInstl;
    private final String mPlacementType;
    private final int mPos;
    private final int mWidth;

    ChartboostAdFormat(boolean z11, int i11, int i12, int i13, int i14, String str) {
        this.mHasVideo = z11;
        this.mInstl = i11;
        this.mHeight = i12;
        this.mWidth = i13;
        this.mPos = i14;
        this.mPlacementType = str;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getInstl() {
        return this.mInstl;
    }

    public String getPlacementType() {
        return this.mPlacementType;
    }

    public int getPos() {
        return this.mPos;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasVideo() {
        return this.mHasVideo;
    }
}
