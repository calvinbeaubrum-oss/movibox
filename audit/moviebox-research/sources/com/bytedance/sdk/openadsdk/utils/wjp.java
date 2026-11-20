package com.bytedance.sdk.openadsdk.utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp {
    public static int sc() {
        try {
            int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / 33554432);
            if (iMaxMemory <= 2) {
                return 2;
            }
            if (iMaxMemory >= 5) {
                return 5;
            }
            return iMaxMemory;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
