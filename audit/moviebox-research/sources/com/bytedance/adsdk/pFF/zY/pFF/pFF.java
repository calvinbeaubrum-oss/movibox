package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.PointF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements zY {
    private final boolean ExN;
    private final boolean We;
    private final com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26253sc;
    private final com.bytedance.adsdk.pFF.zY.sc.TRI zY;

    public pFF(String str, com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> ql2, com.bytedance.adsdk.pFF.zY.sc.TRI tri, boolean z11, boolean z12) {
        this.f26253sc = str;
        this.pFF = ql2;
        this.zY = tri;
        this.We = z11;
        this.ExN = z12;
    }

    public boolean ExN() {
        return this.ExN;
    }

    public boolean We() {
        return this.We;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.TRI(ol2, scVar, this);
    }

    public String sc() {
        return this.f26253sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.TRI zY() {
        return this.zY;
    }
}
