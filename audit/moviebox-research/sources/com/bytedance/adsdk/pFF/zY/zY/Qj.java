package com.bytedance.adsdk.pFF.zY.zY;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends sc {
    private final float[] Ol;
    private final Paint Qj;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> Tf;
    private final ExN UFX;
    private final Path WH;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final RectF f26281qr;

    public Qj(com.bytedance.adsdk.pFF.Ol ol2, ExN exN) {
        super(ol2, exN);
        this.f26281qr = new RectF();
        com.bytedance.adsdk.pFF.sc.sc scVar = new com.bytedance.adsdk.pFF.sc.sc();
        this.Qj = scVar;
        this.Ol = new float[8];
        this.WH = new Path();
        this.UFX = exN;
        scVar.setAlpha(0);
        scVar.setStyle(Paint.Style.FILL);
        scVar.setColor(exN.dE());
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        super.pFF(canvas, matrix, i11);
        int iAlpha = Color.alpha(this.UFX.dE());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i11 / 255.0f) * (((iAlpha / 255.0f) * (this.We.sc() == null ? 100 : this.We.sc().qr().intValue())) / 100.0f) * 255.0f);
        this.Qj.setAlpha(iIntValue);
        com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> scVar = this.Tf;
        if (scVar != null) {
            this.Qj.setColorFilter(scVar.qr());
        }
        if (iIntValue > 0) {
            float[] fArr = this.Ol;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.UFX.wjp();
            float[] fArr2 = this.Ol;
            fArr2[3] = 0.0f;
            fArr2[4] = this.UFX.wjp();
            this.Ol[5] = this.UFX.Xc();
            float[] fArr3 = this.Ol;
            fArr3[6] = 0.0f;
            fArr3[7] = this.UFX.Xc();
            matrix.mapPoints(this.Ol);
            this.WH.reset();
            Path path = this.WH;
            float[] fArr4 = this.Ol;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.WH;
            float[] fArr5 = this.Ol;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.WH;
            float[] fArr6 = this.Ol;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.WH;
            float[] fArr7 = this.Ol;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.WH;
            float[] fArr8 = this.Ol;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.WH.close();
            canvas.drawPath(this.WH, this.Qj);
        }
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        super.sc(rectF, matrix, z11);
        this.f26281qr.set(0.0f, 0.0f, this.UFX.wjp(), this.UFX.Xc());
        this.f26287sc.mapRect(this.f26281qr);
        rectF.set(this.f26281qr);
    }
}
