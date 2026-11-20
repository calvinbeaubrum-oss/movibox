package com.bytedance.adsdk.pFF.zY.sc;

import android.graphics.PointF;
import com.bytedance.adsdk.pFF.sc.pFF.dE;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf implements com.bytedance.adsdk.pFF.zY.pFF.zY {
    private final We ExN;
    private final pFF Ol;
    private final pFF Qj;
    private final pFF TRI;
    private final pFF We;
    private final Ql<PointF, PointF> pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final pFF f26266qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final ExN f26267sc;
    private final qr zY;

    public Tf() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public Tf(ExN exN, Ql<PointF, PointF> ql2, qr qrVar, pFF pff, We we2, pFF pff2, pFF pff3, pFF pff4, pFF pff5) {
        this.f26267sc = exN;
        this.pFF = ql2;
        this.zY = qrVar;
        this.We = pff;
        this.ExN = we2;
        this.Qj = pff2;
        this.Ol = pff3;
        this.TRI = pff4;
        this.f26266qr = pff5;
    }

    public We ExN() {
        return this.ExN;
    }

    public pFF Ol() {
        return this.f26266qr;
    }

    public pFF Qj() {
        return this.TRI;
    }

    public pFF TRI() {
        return this.Qj;
    }

    public dE WH() {
        return new dE(this);
    }

    public pFF We() {
        return this.We;
    }

    public Ql<PointF, PointF> pFF() {
        return this.pFF;
    }

    public pFF qr() {
        return this.Ol;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return null;
    }

    public ExN sc() {
        return this.f26267sc;
    }

    public qr zY() {
        return this.zY;
    }
}
