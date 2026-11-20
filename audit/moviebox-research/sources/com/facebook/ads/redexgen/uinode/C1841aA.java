package com.facebook.ads.redexgen.uinode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1841aA implements InterfaceC10042i {
    public final /* synthetic */ F6 A00;

    public C1841aA(F6 f11) {
        this.A00 = f11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10042i
    public final void A5E(Canvas canvas, RectF rectF, float f11, Paint paint) {
        canvas.drawRoundRect(rectF, f11, f11, paint);
    }
}
