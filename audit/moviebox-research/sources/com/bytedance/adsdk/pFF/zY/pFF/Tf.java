package com.bytedance.adsdk.pFF.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf implements zY {
    private final boolean ExN;
    private final com.bytedance.adsdk.pFF.zY.sc.Tf We;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26245sc;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF zY;

    public Tf(String str, com.bytedance.adsdk.pFF.zY.sc.pFF pff, com.bytedance.adsdk.pFF.zY.sc.pFF pff2, com.bytedance.adsdk.pFF.zY.sc.Tf tf2, boolean z11) {
        this.f26245sc = str;
        this.pFF = pff;
        this.zY = pff2;
        this.We = tf2;
        this.ExN = z11;
    }

    public boolean ExN() {
        return this.ExN;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Tf We() {
        return this.We;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.dE(ol2, scVar, this);
    }

    public String sc() {
        return this.f26245sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF zY() {
        return this.zY;
    }
}
