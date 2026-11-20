package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Xc extends View {
    private ValueAnimator ExN;
    private int TRI;
    private float We;
    private Paint pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26703qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26704sc;
    private RectF zY;

    public Xc(Context context) {
        super(context);
        this.TRI = 1500;
        this.f26704sc = context;
        Paint paint = new Paint();
        this.pFF = paint;
        paint.setAntiAlias(true);
        this.pFF.setStyle(Paint.Style.STROKE);
        this.pFF.setStrokeWidth(10.0f);
        this.pFF.setColor(Color.parseColor("#80FFFFFF"));
        this.zY = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f26703qr) {
            return;
        }
        canvas.drawArc(this.zY, 270.0f, this.We, false, this.pFF);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.zY.set(5.0f, 5.0f, i11 - 5, i12 - 5);
    }

    public void pFF() {
        ValueAnimator valueAnimator = this.ExN;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void sc() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.ExN = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.TRI);
        this.ExN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.Xc.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Xc.this.We = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Xc.this.requestLayout();
            }
        });
        this.ExN.start();
    }

    public void setDuration(int i11) {
        this.TRI = i11;
    }

    public void zY() {
        this.f26703qr = true;
        invalidate();
    }
}
