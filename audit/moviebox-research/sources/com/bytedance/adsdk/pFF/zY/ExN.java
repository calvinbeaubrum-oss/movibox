package com.bytedance.adsdk.pFF.zY;

import com.bytedance.adsdk.pFF.SR;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final ExN f26226sc = new ExN();
    private final SR<String, com.bytedance.adsdk.pFF.qr> pFF = new SR<>(20);

    public static ExN sc() {
        return f26226sc;
    }

    public com.bytedance.adsdk.pFF.qr sc(String str) {
        if (str == null) {
            return null;
        }
        return this.pFF.sc(str);
    }

    public void sc(String str, com.bytedance.adsdk.pFF.qr qrVar) {
        if (str == null) {
            return;
        }
        this.pFF.sc(str, qrVar);
    }
}
