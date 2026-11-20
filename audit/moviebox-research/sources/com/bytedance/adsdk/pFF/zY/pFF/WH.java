package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.PointF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH implements zY {
    private final com.bytedance.adsdk.pFF.zY.sc.pFF ExN;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF Ol;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF Qj;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF TRI;
    private final boolean UFX;
    private final boolean WH;
    private final com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> We;
    private final sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.zY.sc.pFF f26247qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26248sc;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        STAR(1),
        POLYGON(2);

        private final int zY;

        sc(int i11) {
            this.zY = i11;
        }

        public static sc sc(int i11) {
            for (sc scVar : values()) {
                if (scVar.zY == i11) {
                    return scVar;
                }
            }
            return null;
        }
    }

    public WH(String str, sc scVar, com.bytedance.adsdk.pFF.zY.sc.pFF pff, com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> ql2, com.bytedance.adsdk.pFF.zY.sc.pFF pff2, com.bytedance.adsdk.pFF.zY.sc.pFF pff3, com.bytedance.adsdk.pFF.zY.sc.pFF pff4, com.bytedance.adsdk.pFF.zY.sc.pFF pff5, com.bytedance.adsdk.pFF.zY.sc.pFF pff6, boolean z11, boolean z12) {
        this.f26248sc = str;
        this.pFF = scVar;
        this.zY = pff;
        this.We = ql2;
        this.ExN = pff2;
        this.TRI = pff3;
        this.f26247qr = pff4;
        this.Qj = pff5;
        this.Ol = pff6;
        this.WH = z11;
        this.UFX = z12;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF ExN() {
        return this.ExN;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF Ol() {
        return this.Ol;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF Qj() {
        return this.Qj;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF TRI() {
        return this.TRI;
    }

    public boolean UFX() {
        return this.UFX;
    }

    public boolean WH() {
        return this.WH;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> We() {
        return this.We;
    }

    public sc pFF() {
        return this.pFF;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF qr() {
        return this.f26247qr;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.SR(ol2, scVar, this);
    }

    public String sc() {
        return this.f26248sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF zY() {
        return this.zY;
    }
}
