package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class RectangleIndicator extends BaseIndicator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f49900d;

    public RectangleIndicator(Context context) {
        this(context, null);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49900d = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iD = this.f49892a.d();
        if (iD <= 1) {
            return;
        }
        int i11 = 0;
        float fE = 0.0f;
        while (i11 < iD) {
            this.f49893b.setColor(this.f49892a.a() == i11 ? this.f49892a.j() : this.f49892a.g());
            int iK = this.f49892a.a() == i11 ? this.f49892a.k() : this.f49892a.h();
            this.f49900d.set(fE, 0.0f, iK + fE, this.f49892a.c());
            fE += iK + this.f49892a.e();
            canvas.drawRoundRect(this.f49900d, this.f49892a.i(), this.f49892a.i(), this.f49893b);
            i11++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int iD = this.f49892a.d();
        if (iD <= 1) {
            return;
        }
        int i13 = iD - 1;
        setMeasuredDimension((this.f49892a.e() * i13) + (this.f49892a.h() * i13) + this.f49892a.k(), this.f49892a.c());
    }
}
