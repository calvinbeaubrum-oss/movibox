package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile zY f28571sc;

    private zY() {
    }

    public static zY sc(Context context) {
        if (f28571sc == null) {
            synchronized (zY.class) {
                try {
                    if (f28571sc == null) {
                        f28571sc = new zY();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28571sc;
    }

    public int pFF(String str, int i11) {
        return com.bytedance.sdk.openadsdk.multipro.We.We.sc("ttopenadsdk", str, i11);
    }

    public Long pFF(String str, long j11) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.multipro.We.We.sc("ttopenadsdk", str, j11));
    }

    public String pFF(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.We.We.pFF("ttopenadsdk", str, str2);
    }

    public void sc(String str, int i11) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("ttopenadsdk", str, Integer.valueOf(i11));
    }

    public void sc(String str, long j11) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("ttopenadsdk", str, Long.valueOf(j11));
    }

    public void sc(String str, String str2) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("ttopenadsdk", str, str2);
    }
}
