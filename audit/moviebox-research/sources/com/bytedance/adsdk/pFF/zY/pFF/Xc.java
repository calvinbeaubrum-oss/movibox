package com.bytedance.adsdk.pFF.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Xc implements zY {
    private final boolean We;
    private final int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26251sc;
    private final com.bytedance.adsdk.pFF.zY.sc.Qj zY;

    public Xc(String str, int i11, com.bytedance.adsdk.pFF.zY.sc.Qj qj2, boolean z11) {
        this.f26251sc = str;
        this.pFF = i11;
        this.zY = qj2;
        this.We = z11;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Qj pFF() {
        return this.zY;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.wjp(ol2, scVar, this);
    }

    public String sc() {
        return this.f26251sc;
    }

    public String toString() {
        return "ShapePath{name=" + this.f26251sc + ", index=" + this.pFF + '}';
    }

    public boolean zY() {
        return this.We;
    }
}
