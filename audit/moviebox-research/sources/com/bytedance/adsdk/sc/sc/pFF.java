package com.bytedance.adsdk.sc.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends RuntimeException {
    public pFF(String str, Throwable th2) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th2);
    }
}
