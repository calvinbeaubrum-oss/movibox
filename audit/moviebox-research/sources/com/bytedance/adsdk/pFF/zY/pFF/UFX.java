package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.PointF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX implements zY {
    private final boolean ExN;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF We;
    private final com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26246sc;
    private final com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> zY;

    public UFX(String str, com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> ql2, com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> ql3, com.bytedance.adsdk.pFF.zY.sc.pFF pff, boolean z11) {
        this.f26246sc = str;
        this.pFF = ql2;
        this.zY = ql3;
        this.We = pff;
        this.ExN = z11;
    }

    public boolean ExN() {
        return this.ExN;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> We() {
        return this.pFF;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF pFF() {
        return this.We;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.BT(ol2, scVar, this);
    }

    public String sc() {
        return this.f26246sc;
    }

    public String toString() {
        return "RectangleShape{position=" + this.pFF + ", size=" + this.zY + '}';
    }

    public com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> zY() {
        return this.zY;
    }
}
