package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.common.TRI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface PAGLoadListener<Ad> extends TRI {
    void onAdLoaded(Ad ad2);

    @Override // com.bytedance.sdk.openadsdk.common.TRI
    void onError(int i11, String str);
}
