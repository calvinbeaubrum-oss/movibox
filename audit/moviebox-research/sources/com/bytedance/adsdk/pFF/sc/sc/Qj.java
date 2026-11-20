package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, ExN, UFX {
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> BT;
    private com.bytedance.adsdk.pFF.sc.pFF.zY Dl;
    private final RectF Ol;
    private final Paint Qj;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> Ql;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> SR;
    private final int Sfl;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<com.bytedance.adsdk.pFF.zY.pFF.We, com.bytedance.adsdk.pFF.zY.pFF.We> Tf;
    private final com.bytedance.adsdk.pFF.zY.pFF.qr UFX;
    private final List<Ql> WH;
    private final com.bytedance.adsdk.pFF.zY.zY.sc We;
    private com.bytedance.adsdk.pFF.sc.pFF.Xc Xc;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> YIK;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> dE;
    private final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Path f26201qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    float f26202sc;
    private final com.bytedance.adsdk.pFF.Ol wjp;
    private final boolean zY;
    private final LongSparseArray<LinearGradient> ExN = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> TRI = new LongSparseArray<>();

    public Qj(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.ExN exN) {
        Path path = new Path();
        this.f26201qr = path;
        this.Qj = new com.bytedance.adsdk.pFF.sc.sc(1);
        this.Ol = new RectF();
        this.WH = new ArrayList();
        this.f26202sc = 0.0f;
        this.We = scVar;
        this.pFF = exN.sc();
        this.zY = exN.Qj();
        this.wjp = ol2;
        this.UFX = exN.pFF();
        path.setFillType(exN.zY());
        this.Sfl = (int) (qrVar.ExN() / 32.0f);
        com.bytedance.adsdk.pFF.sc.pFF.sc<com.bytedance.adsdk.pFF.zY.pFF.We, com.bytedance.adsdk.pFF.zY.pFF.We> scVarSc = exN.We().sc();
        this.Tf = scVarSc;
        scVarSc.sc(this);
        scVar.sc(scVarSc);
        com.bytedance.adsdk.pFF.sc.pFF.sc<Integer, Integer> scVarSc2 = exN.ExN().sc();
        this.Ql = scVarSc2;
        scVarSc2.sc(this);
        scVar.sc(scVarSc2);
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc3 = exN.TRI().sc();
        this.SR = scVarSc3;
        scVarSc3.sc(this);
        scVar.sc(scVarSc3);
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc4 = exN.qr().sc();
        this.BT = scVarSc4;
        scVarSc4.sc(this);
        scVar.sc(scVarSc4);
        if (scVar.WH() != null) {
            com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc5 = scVar.WH().sc().sc();
            this.YIK = scVarSc5;
            scVarSc5.sc(this);
            scVar.sc(this.YIK);
        }
        if (scVar.UFX() != null) {
            this.Dl = new com.bytedance.adsdk.pFF.sc.pFF.zY(this, scVar, scVar.UFX());
        }
    }

    private int We() {
        int iRound = Math.round(this.SR.Qj() * this.Sfl);
        int iRound2 = Math.round(this.BT.Qj() * this.Sfl);
        int iRound3 = Math.round(this.Tf.Qj() * this.Sfl);
        int i11 = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i11 = i11 * 31 * iRound2;
        }
        return iRound3 != 0 ? i11 * 31 * iRound3 : i11;
    }

    private LinearGradient pFF() {
        long jWe = We();
        LinearGradient linearGradient = this.ExN.get(jWe);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFQr = this.SR.qr();
        PointF pointFQr2 = this.BT.qr();
        com.bytedance.adsdk.pFF.zY.pFF.We weQr = this.Tf.qr();
        LinearGradient linearGradient2 = new LinearGradient(pointFQr.x, pointFQr.y, pointFQr2.x, pointFQr2.y, sc(weQr.pFF()), weQr.sc(), Shader.TileMode.CLAMP);
        this.ExN.put(jWe, linearGradient2);
        return linearGradient2;
    }

    private int[] sc(int[] iArr) {
        if (this.Xc == null) {
            return iArr;
        }
        throw null;
    }

    private RadialGradient zY() {
        long jWe = We();
        RadialGradient radialGradient = this.TRI.get(jWe);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFQr = this.SR.qr();
        PointF pointFQr2 = this.BT.qr();
        com.bytedance.adsdk.pFF.zY.pFF.We weQr = this.Tf.qr();
        int[] iArrSc = sc(weQr.pFF());
        float[] fArrSc = weQr.sc();
        float f11 = pointFQr.x;
        float f12 = pointFQr.y;
        float fHypot = (float) Math.hypot(pointFQr2.x - f11, pointFQr2.y - f12);
        RadialGradient radialGradient2 = new RadialGradient(f11, f12, fHypot <= 0.0f ? 0.001f : fHypot, iArrSc, fArrSc, Shader.TileMode.CLAMP);
        this.TRI.put(jWe, radialGradient2);
        return radialGradient2;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.wjp.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        if (this.zY) {
            return;
        }
        com.bytedance.adsdk.pFF.ExN.sc("GradientFillContent#draw");
        this.f26201qr.reset();
        for (int i12 = 0; i12 < this.WH.size(); i12++) {
            this.f26201qr.addPath(this.WH.get(i12).We(), matrix);
        }
        this.f26201qr.computeBounds(this.Ol, false);
        Shader shaderPFF = this.UFX == com.bytedance.adsdk.pFF.zY.pFF.qr.LINEAR ? pFF() : zY();
        shaderPFF.setLocalMatrix(matrix);
        this.Qj.setShader(shaderPFF);
        com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> scVar = this.dE;
        if (scVar != null) {
            this.Qj.setColorFilter(scVar.qr());
        }
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVar2 = this.YIK;
        if (scVar2 != null) {
            float fFloatValue = scVar2.qr().floatValue();
            if (fFloatValue == 0.0f) {
                this.Qj.setMaskFilter(null);
            } else if (fFloatValue != this.f26202sc) {
                this.Qj.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f26202sc = fFloatValue;
        }
        com.bytedance.adsdk.pFF.sc.pFF.zY zYVar = this.Dl;
        if (zYVar != null) {
            zYVar.sc(this.Qj);
        }
        this.Qj.setAlpha(com.bytedance.adsdk.pFF.TRI.ExN.sc((int) ((((i11 / 255.0f) * this.Ql.qr().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f26201qr, this.Qj);
        com.bytedance.adsdk.pFF.ExN.pFF("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        this.f26201qr.reset();
        for (int i11 = 0; i11 < this.WH.size(); i11++) {
            this.f26201qr.addPath(this.WH.get(i11).We(), matrix);
        }
        this.f26201qr.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
        for (int i11 = 0; i11 < list2.size(); i11++) {
            zY zYVar = list2.get(i11);
            if (zYVar instanceof Ql) {
                this.WH.add((Ql) zYVar);
            }
        }
    }
}
