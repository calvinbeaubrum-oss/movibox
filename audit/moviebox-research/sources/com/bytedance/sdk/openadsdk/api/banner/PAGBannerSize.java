package com.bytedance.sdk.openadsdk.api.banner;

import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PAGBannerSize {
    private final int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f27653sc;
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(320, 50);
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(LogSeverity.NOTICE_VALUE, 250);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);

    public PAGBannerSize(int i11, int i12) {
        this.f27653sc = i11;
        this.pFF = i12;
    }

    public int getHeight() {
        return this.pFF;
    }

    public int getWidth() {
        return this.f27653sc;
    }
}
