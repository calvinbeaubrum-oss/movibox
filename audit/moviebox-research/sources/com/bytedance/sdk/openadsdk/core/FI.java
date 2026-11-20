package com.bytedance.sdk.openadsdk.core;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static FI f28007sc;
    private com.bytedance.sdk.openadsdk.sc.zY.pFF ExN;
    private com.bytedance.sdk.openadsdk.sc.We.pFF TRI;
    private com.bytedance.sdk.openadsdk.sc.ExN.sc We;
    private com.bytedance.sdk.openadsdk.core.model.sc pFF;
    private com.bytedance.sdk.openadsdk.core.model.Sfl zY;

    private FI() {
    }

    public static FI sc() {
        if (f28007sc == null) {
            f28007sc = new FI();
        }
        return f28007sc;
    }

    public com.bytedance.sdk.openadsdk.sc.We.pFF ExN() {
        return this.TRI;
    }

    public void TRI() {
        this.zY = null;
        this.pFF = null;
        this.We = null;
        this.ExN = null;
        this.TRI = null;
    }

    public com.bytedance.sdk.openadsdk.sc.zY.pFF We() {
        return this.ExN;
    }

    public com.bytedance.sdk.openadsdk.core.model.Sfl pFF() {
        return this.zY;
    }

    public com.bytedance.sdk.openadsdk.core.model.sc qr() {
        return this.pFF;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        this.zY = sfl;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        this.pFF = scVar;
    }

    public void sc(com.bytedance.sdk.openadsdk.sc.ExN.sc scVar) {
        this.We = scVar;
    }

    public void sc(com.bytedance.sdk.openadsdk.sc.We.pFF pff) {
        this.TRI = pff;
    }

    public void sc(com.bytedance.sdk.openadsdk.sc.zY.pFF pff) {
        this.ExN = pff;
    }

    public com.bytedance.sdk.openadsdk.sc.ExN.sc zY() {
        return this.We;
    }
}
