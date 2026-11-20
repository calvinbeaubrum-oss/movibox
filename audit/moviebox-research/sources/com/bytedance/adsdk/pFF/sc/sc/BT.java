package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BT implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, Ql, UFX {
    private final com.bytedance.adsdk.pFF.Ol ExN;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> Qj;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, PointF> TRI;
    private boolean UFX;
    private final boolean We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, PointF> f26196qr;
    private final String zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Path f26197sc = new Path();
    private final RectF pFF = new RectF();
    private final pFF Ol = new pFF();
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> WH = null;

    public BT(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.UFX ufx) {
        this.zY = ufx.sc();
        this.We = ufx.ExN();
        this.ExN = ol2;
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc = ufx.We().sc();
        this.TRI = scVarSc;
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc2 = ufx.zY().sc();
        this.f26196qr = scVarSc2;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc3 = ufx.pFF().sc();
        this.Qj = scVarSc3;
        scVar.sc(scVarSc);
        scVar.sc(scVarSc2);
        scVar.sc(scVarSc3);
        scVarSc.sc(this);
        scVarSc2.sc(this);
        scVarSc3.sc(this);
    }

    private void pFF() {
        this.UFX = false;
        this.ExN.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.Ql
    public Path We() {
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar;
        if (this.UFX) {
            return this.f26197sc;
        }
        this.f26197sc.reset();
        if (this.We) {
            this.UFX = true;
            return this.f26197sc;
        }
        PointF pointFQr = this.f26196qr.qr();
        float f11 = pointFQr.x / 2.0f;
        float f12 = pointFQr.y / 2.0f;
        com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> scVar2 = this.Qj;
        float fOl = scVar2 == null ? 0.0f : ((com.bytedance.adsdk.pFF.sc.pFF.We) scVar2).Ol();
        if (fOl == 0.0f && (scVar = this.WH) != null) {
            fOl = Math.min(scVar.qr().floatValue(), Math.min(f11, f12));
        }
        float fMin = Math.min(f11, f12);
        if (fOl > fMin) {
            fOl = fMin;
        }
        PointF pointFQr2 = this.TRI.qr();
        this.f26197sc.moveTo(pointFQr2.x + f11, (pointFQr2.y - f12) + fOl);
        this.f26197sc.lineTo(pointFQr2.x + f11, (pointFQr2.y + f12) - fOl);
        if (fOl > 0.0f) {
            RectF rectF = this.pFF;
            float f13 = pointFQr2.x;
            float f14 = fOl * 2.0f;
            float f15 = pointFQr2.y;
            rectF.set((f13 + f11) - f14, (f15 + f12) - f14, f13 + f11, f15 + f12);
            this.f26197sc.arcTo(this.pFF, 0.0f, 90.0f, false);
        }
        this.f26197sc.lineTo((pointFQr2.x - f11) + fOl, pointFQr2.y + f12);
        if (fOl > 0.0f) {
            RectF rectF2 = this.pFF;
            float f16 = pointFQr2.x;
            float f17 = pointFQr2.y;
            float f18 = fOl * 2.0f;
            rectF2.set(f16 - f11, (f17 + f12) - f18, (f16 - f11) + f18, f17 + f12);
            this.f26197sc.arcTo(this.pFF, 90.0f, 90.0f, false);
        }
        this.f26197sc.lineTo(pointFQr2.x - f11, (pointFQr2.y - f12) + fOl);
        if (fOl > 0.0f) {
            RectF rectF3 = this.pFF;
            float f19 = pointFQr2.x;
            float f21 = pointFQr2.y;
            float f22 = fOl * 2.0f;
            rectF3.set(f19 - f11, f21 - f12, (f19 - f11) + f22, (f21 - f12) + f22);
            this.f26197sc.arcTo(this.pFF, 180.0f, 90.0f, false);
        }
        this.f26197sc.lineTo((pointFQr2.x + f11) - fOl, pointFQr2.y - f12);
        if (fOl > 0.0f) {
            RectF rectF4 = this.pFF;
            float f23 = pointFQr2.x;
            float f24 = fOl * 2.0f;
            float f25 = pointFQr2.y;
            rectF4.set((f23 + f11) - f24, f25 - f12, f23 + f11, (f25 - f12) + f24);
            this.f26197sc.arcTo(this.pFF, 270.0f, 90.0f, false);
        }
        this.f26197sc.close();
        this.Ol.sc(this.f26197sc);
        this.UFX = true;
        return this.f26197sc;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        pFF();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            zY zYVar = list.get(i11);
            if (zYVar instanceof Dl) {
                Dl dl2 = (Dl) zYVar;
                if (dl2.pFF() == com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc.SIMULTANEOUSLY) {
                    this.Ol.sc(dl2);
                    dl2.sc(this);
                } else if (zYVar instanceof Xc) {
                    this.WH = ((Xc) zYVar).pFF();
                }
            } else if (zYVar instanceof Xc) {
                this.WH = ((Xc) zYVar).pFF();
            }
        }
    }
}
