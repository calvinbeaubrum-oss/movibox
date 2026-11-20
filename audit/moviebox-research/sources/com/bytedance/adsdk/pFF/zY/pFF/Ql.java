package com.bytedance.adsdk.pFF.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ql implements zY {
    private final com.bytedance.adsdk.pFF.zY.sc.Ql<Float, Float> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26239sc;

    public Ql(String str, com.bytedance.adsdk.pFF.zY.sc.Ql<Float, Float> ql2) {
        this.f26239sc = str;
        this.pFF = ql2;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Ql<Float, Float> pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.Xc(ol2, scVar, this);
    }

    public String sc() {
        return this.f26239sc;
    }
}
