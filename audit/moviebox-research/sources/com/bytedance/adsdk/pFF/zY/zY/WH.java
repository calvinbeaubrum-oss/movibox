package com.bytedance.adsdk.pFF.zY.zY;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH extends We {
    private int Ol;
    private Path Qj;
    private int WH;

    public WH(com.bytedance.adsdk.pFF.Ol ol2, ExN exN, Context context) {
        super(ol2, exN);
        this.Qj = null;
        this.Ol = -1;
        this.WH = -1;
        if (((We) this).f26282qr != null) {
            float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
            this.Ol = (int) (((We) this).f26282qr.sc() * fSc);
            this.WH = (int) (((We) this).f26282qr.pFF() * fSc);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.Ol, this.WH);
            Path path = new Path();
            this.Qj = path;
            float f11 = fSc * 40.0f;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        }
    }

    private static void sc(View view, int i11, int i12) {
        view.layout(0, 0, i11, i12);
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.pFF.zY.zY.We, com.bytedance.adsdk.pFF.zY.zY.sc
    public void pFF(Canvas canvas, Matrix matrix, int i11) {
        View viewSc = this.pFF.sc();
        if (this.Ol <= 0 || viewSc == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        sc(i11);
        float fTRI = TRI();
        sc(viewSc, this.Ol, this.WH);
        viewSc.setAlpha(fTRI);
        canvas.clipPath(this.Qj);
        viewSc.draw(canvas);
        canvas.restore();
    }
}
