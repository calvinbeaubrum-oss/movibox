package com.bytedance.adsdk.pFF.sc.sc;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends sc {
    private final boolean ExN;
    private final com.bytedance.adsdk.pFF.zY.pFF.qr Ol;
    private final RectF Qj;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> Ql;
    private com.bytedance.adsdk.pFF.sc.pFF.Xc SR;
    private final LongSparseArray<LinearGradient> TRI;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> Tf;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<com.bytedance.adsdk.pFF.zY.pFF.We, com.bytedance.adsdk.pFF.zY.pFF.We> UFX;
    private final int WH;
    private final String We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f26200qr;

    public Ol(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.TRI tri) {
        super(ol2, scVar, tri.Qj().sc(), tri.Ol().sc(), tri.Tf(), tri.We(), tri.qr(), tri.WH(), tri.UFX());
        this.TRI = new LongSparseArray<>();
        this.f26200qr = new LongSparseArray<>();
        this.Qj = new RectF();
        this.We = tri.sc();
        this.Ol = tri.pFF();
        this.ExN = tri.Ql();
        this.WH = (int) (ol2.cvk().ExN() / 32.0f);
        com.bytedance.adsdk.pFF.sc.pFF.sc<com.bytedance.adsdk.pFF.zY.pFF.We, com.bytedance.adsdk.pFF.zY.pFF.We> scVarSc = tri.zY().sc();
        this.UFX = scVarSc;
        scVarSc.sc(this);
        scVar.sc(scVarSc);
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc2 = tri.ExN().sc();
        this.Tf = scVarSc2;
        scVarSc2.sc(this);
        scVar.sc(scVarSc2);
        com.bytedance.adsdk.pFF.sc.pFF.sc<PointF, PointF> scVarSc3 = tri.TRI().sc();
        this.Ql = scVarSc3;
        scVarSc3.sc(this);
        scVar.sc(scVarSc3);
    }

    private int We() {
        int iRound = Math.round(this.Tf.Qj() * this.WH);
        int iRound2 = Math.round(this.Ql.Qj() * this.WH);
        int iRound3 = Math.round(this.UFX.Qj() * this.WH);
        int i11 = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i11 = i11 * 31 * iRound2;
        }
        return iRound3 != 0 ? i11 * 31 * iRound3 : i11;
    }

    private LinearGradient pFF() {
        long jWe = We();
        LinearGradient linearGradient = this.TRI.get(jWe);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFQr = this.Tf.qr();
        PointF pointFQr2 = this.Ql.qr();
        com.bytedance.adsdk.pFF.zY.pFF.We weQr = this.UFX.qr();
        LinearGradient linearGradient2 = new LinearGradient(pointFQr.x, pointFQr.y, pointFQr2.x, pointFQr2.y, sc(weQr.pFF()), weQr.sc(), Shader.TileMode.CLAMP);
        this.TRI.put(jWe, linearGradient2);
        return linearGradient2;
    }

    private int[] sc(int[] iArr) {
        if (this.SR == null) {
            return iArr;
        }
        throw null;
    }

    private RadialGradient zY() {
        long jWe = We();
        RadialGradient radialGradient = this.f26200qr.get(jWe);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFQr = this.Tf.qr();
        PointF pointFQr2 = this.Ql.qr();
        com.bytedance.adsdk.pFF.zY.pFF.We weQr = this.UFX.qr();
        int[] iArrSc = sc(weQr.pFF());
        float[] fArrSc = weQr.sc();
        float f11 = pointFQr.x;
        float f12 = pointFQr.y;
        RadialGradient radialGradient2 = new RadialGradient(f11, f12, (float) Math.hypot(pointFQr2.x - f11, pointFQr2.y - f12), iArrSc, fArrSc, Shader.TileMode.CLAMP);
        this.f26200qr.put(jWe, radialGradient2);
        return radialGradient2;
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(Canvas canvas, Matrix matrix, int i11) {
        if (this.ExN) {
            return;
        }
        sc(this.Qj, matrix, false);
        Shader shaderPFF = this.Ol == com.bytedance.adsdk.pFF.zY.pFF.qr.LINEAR ? pFF() : zY();
        shaderPFF.setLocalMatrix(matrix);
        this.pFF.setShader(shaderPFF);
        super.sc(canvas, matrix, i11);
    }
}
