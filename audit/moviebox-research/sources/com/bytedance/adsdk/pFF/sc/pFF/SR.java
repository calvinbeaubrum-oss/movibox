package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR extends sc<PointF, PointF> {
    protected com.bytedance.adsdk.pFF.qr.pFF<Float> ExN;
    private final sc<Float, Float> Ol;
    private final sc<Float, Float> Qj;
    private final PointF TRI;
    protected com.bytedance.adsdk.pFF.qr.pFF<Float> We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final PointF f26186qr;

    public SR(sc<Float, Float> scVar, sc<Float, Float> scVar2) {
        super(Collections.emptyList());
        this.TRI = new PointF();
        this.f26186qr = new PointF();
        this.Qj = scVar;
        this.Ol = scVar2;
        sc(Qj());
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: Ol, reason: merged with bridge method [inline-methods] */
    public PointF qr() {
        return sc(null, 0.0f);
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public PointF sc(com.bytedance.adsdk.pFF.qr.sc<PointF> scVar, float f11) {
        com.bytedance.adsdk.pFF.qr.sc<Float> scVarZY;
        com.bytedance.adsdk.pFF.qr.sc<Float> scVarZY2;
        if (this.We != null && (scVarZY2 = this.Qj.zY()) != null) {
            this.Qj.ExN();
            Float f12 = scVarZY2.f26179qr;
            if (f12 == null) {
                throw null;
            }
            f12.floatValue();
            throw null;
        }
        if (this.ExN == null || (scVarZY = this.Ol.zY()) == null) {
            this.f26186qr.set(this.TRI.x, 0.0f);
            PointF pointF = this.f26186qr;
            pointF.set(pointF.x, this.TRI.y);
            return this.f26186qr;
        }
        this.Ol.ExN();
        Float f13 = scVarZY.f26179qr;
        if (f13 == null) {
            throw null;
        }
        f13.floatValue();
        throw null;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    public void sc(float f11) {
        this.Qj.sc(f11);
        this.Ol.sc(f11);
        this.TRI.set(this.Qj.qr().floatValue(), this.Ol.qr().floatValue());
        for (int i11 = 0; i11 < this.f26191sc.size(); i11++) {
            this.f26191sc.get(i11).sc();
        }
    }
}
