package com.facebook.ads.redexgen.uinode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1839a8 implements InterfaceC10042i {
    public final /* synthetic */ C1838a7 A00;

    public C1839a8(C1838a7 c1838a7) {
        this.A00 = c1838a7;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10042i
    public final void A5E(Canvas canvas, RectF rectF, float f11, Paint paint) {
        float f12 = f11 * 2.0f;
        float fWidth = (rectF.width() - f12) - 1.0f;
        float fHeight = (rectF.height() - f12) - 1.0f;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        if (f11 >= 1.0f) {
            float f13 = f11 + 0.5f;
            this.A00.A00.set(-f13, -f13, f13, f13);
            int iSave = canvas2.save();
            canvas2.translate(rectF.left + f13, rectF.top + f13);
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.translate(fWidth, 0.0f);
            canvas2.rotate(90.0f);
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.translate(fHeight, 0.0f);
            canvas2.rotate(90.0f);
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.translate(fWidth, 0.0f);
            canvas2.rotate(90.0f);
            canvas2 = canvas2;
            canvas2.drawArc(this.A00.A00, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(iSave);
            canvas2.drawRect((rectF.left + f13) - 1.0f, rectF.top, (rectF.right - f13) + 1.0f, rectF.top + f13, paint2);
            paint2 = paint2;
            canvas2.drawRect((rectF.left + f13) - 1.0f, rectF.bottom - f13, (rectF.right - f13) + 1.0f, rectF.bottom, paint2);
        }
        canvas2.drawRect(rectF.left, rectF.top + f11, rectF.right, rectF.bottom - f11, paint2);
    }
}
