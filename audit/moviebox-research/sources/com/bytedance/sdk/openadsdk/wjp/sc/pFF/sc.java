package com.bytedance.sdk.openadsdk.wjp.sc.pFF;

import com.bytedance.sdk.openadsdk.core.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static volatile sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28789sc = "";

    private sc() {
    }

    public static sc sc() {
        if (pFF == null) {
            synchronized (sc.class) {
                try {
                    if (pFF == null) {
                        pFF = new sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public String pFF() {
        return Xc.We().McK("gaid") ? this.f28789sc : "";
    }

    public void sc(String str) {
        this.f28789sc = str;
    }
}
