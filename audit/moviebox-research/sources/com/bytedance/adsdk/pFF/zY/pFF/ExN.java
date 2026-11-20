package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.Path;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements zY {
    private final com.bytedance.adsdk.pFF.zY.sc.TRI ExN;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF Ol;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF Qj;
    private final com.bytedance.adsdk.pFF.zY.sc.TRI TRI;
    private final boolean WH;
    private final com.bytedance.adsdk.pFF.zY.sc.We We;
    private final Path.FillType pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f26233qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final qr f26234sc;
    private final com.bytedance.adsdk.pFF.zY.sc.zY zY;

    public ExN(String str, qr qrVar, Path.FillType fillType, com.bytedance.adsdk.pFF.zY.sc.zY zYVar, com.bytedance.adsdk.pFF.zY.sc.We we2, com.bytedance.adsdk.pFF.zY.sc.TRI tri, com.bytedance.adsdk.pFF.zY.sc.TRI tri2, com.bytedance.adsdk.pFF.zY.sc.pFF pff, com.bytedance.adsdk.pFF.zY.sc.pFF pff2, boolean z11) {
        this.f26234sc = qrVar;
        this.pFF = fillType;
        this.zY = zYVar;
        this.We = we2;
        this.ExN = tri;
        this.TRI = tri2;
        this.f26233qr = str;
        this.Qj = pff;
        this.Ol = pff2;
        this.WH = z11;
    }

    public com.bytedance.adsdk.pFF.zY.sc.We ExN() {
        return this.We;
    }

    public boolean Qj() {
        return this.WH;
    }

    public com.bytedance.adsdk.pFF.zY.sc.TRI TRI() {
        return this.ExN;
    }

    public com.bytedance.adsdk.pFF.zY.sc.zY We() {
        return this.zY;
    }

    public qr pFF() {
        return this.f26234sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.TRI qr() {
        return this.TRI;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.Qj(ol2, qrVar, scVar, this);
    }

    public String sc() {
        return this.f26233qr;
    }

    public Path.FillType zY() {
        return this.pFF;
    }
}
