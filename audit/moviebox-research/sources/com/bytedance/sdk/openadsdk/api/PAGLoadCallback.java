package com.bytedance.sdk.openadsdk.api;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface PAGLoadCallback<Ad> {
    void onAdLoaded(Ad ad2);

    void onError(@NonNull PAGErrorModel pAGErrorModel);
}
