package com.tn.lib.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, null);
    }

    public RoundLinesIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f49893b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f49892a.d() <= 1) {
            return;
        }
        this.f49893b.setColor(this.f49892a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f49892a.c()), this.f49892a.i(), this.f49892a.i(), this.f49893b);
        this.f49893b.setColor(this.f49892a.j());
        int iA = this.f49892a.a() * this.f49892a.k();
        canvas.drawRoundRect(new RectF(iA, 0.0f, iA + this.f49892a.k(), this.f49892a.c()), this.f49892a.i(), this.f49892a.i(), this.f49893b);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int iD = this.f49892a.d();
        if (iD <= 1) {
            return;
        }
        setMeasuredDimension(this.f49892a.k() * iD, this.f49892a.c());
    }
}
