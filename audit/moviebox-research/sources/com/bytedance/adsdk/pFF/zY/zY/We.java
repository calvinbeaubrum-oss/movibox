package com.bytedance.adsdk.pFF.zY.zY;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    private final Rect Ol;
    private final Paint Qj;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<Bitmap, Bitmap> Tf;
    private com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> UFX;
    private final Rect WH;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected final com.bytedance.adsdk.pFF.WH f26282qr;

    public We(com.bytedance.adsdk.pFF.Ol ol2, ExN exN) {
        super(ol2, exN);
        this.Qj = new com.bytedance.adsdk.pFF.sc.sc(3);
        this.Ol = new Rect();
        this.WH = new Rect();
        this.f26282qr = ol2.TRI(exN.qr());
    }

    private Bitmap Tf() {
        Bitmap bitmapQr;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Bitmap, Bitmap> scVar = this.Tf;
        if (scVar != null && (bitmapQr = scVar.qr()) != null) {
            return bitmapQr;
        }
        Bitmap bitmapExN = this.pFF.ExN(this.zY.qr());
        if (bitmapExN != null) {
            return bitmapExN;
        }
        com.bytedance.adsdk.pFF.WH wh2 = this.f26282qr;
        if (wh2 != null) {
            return wh2.UFX();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        super.pFF(canvas, matrix, i11);
        Bitmap bitmapTf = Tf();
        if (bitmapTf == null || bitmapTf.isRecycled() || this.f26282qr == null) {
            return;
        }
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
        this.Qj.setAlpha(i11);
        com.bytedance.adsdk.pFF.sc.pFF.sc<ColorFilter, ColorFilter> scVar = this.UFX;
        if (scVar != null) {
            this.Qj.setColorFilter(scVar.qr());
        }
        canvas.save();
        canvas.concat(matrix);
        this.Ol.set(0, 0, bitmapTf.getWidth(), bitmapTf.getHeight());
        if (this.pFF.ExN()) {
            this.WH.set(0, 0, (int) (this.f26282qr.sc() * fSc), (int) (this.f26282qr.pFF() * fSc));
        } else {
            this.WH.set(0, 0, (int) (bitmapTf.getWidth() * fSc), (int) (bitmapTf.getHeight() * fSc));
        }
        canvas.drawBitmap(bitmapTf, this.Ol, this.WH, this.Qj);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.sc, com.bytedance.adsdk.pFF.sc.sc.ExN
    public void sc(RectF rectF, Matrix matrix, boolean z11) {
        super.sc(rectF, matrix, z11);
        if (this.f26282qr != null) {
            float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
            rectF.set(0.0f, 0.0f, this.f26282qr.sc() * fSc, this.f26282qr.pFF() * fSc);
            this.f26287sc.mapRect(rectF);
        }
    }
}
