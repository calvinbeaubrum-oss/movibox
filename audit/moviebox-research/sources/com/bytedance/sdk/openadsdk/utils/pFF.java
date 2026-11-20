package com.bytedance.sdk.openadsdk.utils;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static SoftReference<com.bytedance.sdk.openadsdk.core.model.Sfl> f28778sc;

    public static com.bytedance.sdk.openadsdk.core.model.Sfl sc() {
        SoftReference<com.bytedance.sdk.openadsdk.core.model.Sfl> softReference = f28778sc;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null) {
            return;
        }
        f28778sc = new SoftReference<>(sfl);
    }
}
