package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.Path;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT implements zY {
    private final com.bytedance.adsdk.pFF.zY.sc.We ExN;
    private final boolean TRI;
    private final com.bytedance.adsdk.pFF.zY.sc.sc We;
    private final Path.FillType pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final boolean f26232sc;
    private final String zY;

    public BT(String str, boolean z11, Path.FillType fillType, com.bytedance.adsdk.pFF.zY.sc.sc scVar, com.bytedance.adsdk.pFF.zY.sc.We we2, boolean z12) {
        this.zY = str;
        this.f26232sc = z11;
        this.pFF = fillType;
        this.We = scVar;
        this.ExN = we2;
        this.TRI = z12;
    }

    public boolean ExN() {
        return this.TRI;
    }

    public Path.FillType We() {
        return this.pFF;
    }

    public com.bytedance.adsdk.pFF.zY.sc.sc pFF() {
        return this.We;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.qr(ol2, scVar, this);
    }

    public String sc() {
        return this.zY;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f26232sc + '}';
    }

    public com.bytedance.adsdk.pFF.zY.sc.We zY() {
        return this.ExN;
    }
}
