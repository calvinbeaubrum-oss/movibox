package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, ExN, UFX {
    private final String ExN;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> Ol;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> Qj;
    private com.bytedance.adsdk.pFF.sc.pFF.zY Ql;
    private final boolean TRI;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> Tf;
    private final com.bytedance.adsdk.pFF.Ol UFX;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> WH;
    private final com.bytedance.adsdk.pFF.zY.zY.sc We;
    private final Path pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final List<Ql> f26217qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    float f26218sc;
    private final Paint zY;

    public qr(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.BT bt2) {
        Path path = new Path();
        this.pFF = path;
        this.zY = new com.bytedance.adsdk.pFF.sc.sc(1);
        this.f26217qr = new ArrayList();
        this.We = scVar;
        this.ExN = bt2.sc();
        this.TRI = bt2.ExN();
        this.UFX = ol2;
        if (scVar.WH() != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = scVar.WH().sc().sc();
            this.Tf = scVarSc;
            scVarSc.sc(this);
            scVar.sc(this.Tf);
        }
        if (scVar.UFX() != null) {
            this.Ql = new com.bytedance.adsdk.pFF.sc.pFF.zY(this, scVar, scVar.UFX());
        }
        if (bt2.pFF() == null || bt2.zY() == null) {
            this.Qj = null;
            this.Ol = null;
            return;
        }
        path.setFillType(bt2.We());
        com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVarSc2 = bt2.pFF().sc();
        this.Qj = scVarSc2;
        scVarSc2.sc(this);
        scVar.sc(scVarSc2);
        com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVarSc3 = bt2.zY().sc();
        this.Ol = scVarSc3;
        scVarSc3.sc(this);
        scVar.sc(scVarSc3);
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.UFX.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        if (this.TRI) {
            return;
        }
        com.bytedance.adsdk.pFF.ExN.sc("FillContent#draw");
        this.zY.setColor((com.bytedance.adsdk.pFF.TRI.ExN.sc((int) ((((i11 / 255.0f) * this.Ol.qr().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.pFF.sc.pFF.pFF) this.Qj).Ol() & 16777215));
        com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> scVar = this.WH;
        if (scVar != null) {
            this.zY.setColorFilter(scVar.qr());
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar2 = this.Tf;
        if (scVar2 != null) {
            float fFloatValue = scVar2.qr().floatValue();
            if (fFloatValue == 0.0f) {
                this.zY.setMaskFilter(null);
            } else if (fFloatValue != this.f26218sc) {
                this.zY.setMaskFilter(this.We.pFF(fFloatValue));
            }
            this.f26218sc = fFloatValue;
        }
        com.bytedance.adsdk.pFF.sc.pFF.zY zYVar = this.Ql;
        if (zYVar != null) {
            zYVar.sc(this.zY);
        }
        this.pFF.reset();
        for (int i12 = 0; i12 < this.f26217qr.size(); i12++) {
            this.pFF.addPath(this.f26217qr.get(i12).We(), matrix);
        }
        canvas.drawPath(this.pFF, this.zY);
        com.bytedance.adsdk.pFF.ExN.pFF("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        this.pFF.reset();
        for (int i11 = 0; i11 < this.f26217qr.size(); i11++) {
            this.pFF.addPath(this.f26217qr.get(i11).We(), matrix);
        }
        this.pFF.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        for (int i11 = 0; i11 < list2.size(); i11++) {
            zY zYVar = list2.get(i11);
            if (zYVar instanceof Ql) {
                this.f26217qr.add((Ql) zYVar);
            }
        }
    }
}
