package com.bytedance.sdk.openadsdk.api.banner;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGBannerRequest extends PAGRequest {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private PAGBannerSize f27652sc;

    public PAGBannerRequest(PAGBannerSize pAGBannerSize) {
        this.f27652sc = pAGBannerSize;
    }

    public PAGBannerSize getAdSize() {
        return this.f27652sc;
    }

    public void setAdSize(PAGBannerSize pAGBannerSize) {
        this.f27652sc = pAGBannerSize;
    }
}
