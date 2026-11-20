package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tn.lib.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class CircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f49497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f49498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f49499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49500d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f49502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f49503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49507l;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49505j = 100;
        this.f49507l = 0;
        a(context, attributeSet);
        b();
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressbar, 0, 0);
        this.f49503h = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_progressRadius, 80.0f);
        this.f49504i = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_progressStrokesWidth, 10.0f);
        this.f49500d = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressbar_progressBgColor, 15658734);
        this.f49501f = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressbar_progressRingsColor, 16734911);
        this.f49502g = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressbar_progressTextsColor, 16777215);
        this.f49505j = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleProgressbar_progressMax, 100);
        this.f49506k = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleProgressbar_progressCurrent, 0);
    }

    public final void b() {
        Paint paint = new Paint();
        this.f49497a = paint;
        paint.setAntiAlias(true);
        this.f49497a.setDither(true);
        this.f49497a.setColor(this.f49500d);
        Paint paint2 = this.f49497a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = this.f49497a;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        this.f49497a.setStrokeWidth(this.f49504i);
        Paint paint4 = new Paint();
        this.f49498b = paint4;
        paint4.setAntiAlias(true);
        this.f49498b.setDither(true);
        this.f49498b.setColor(this.f49501f);
        this.f49498b.setStyle(style);
        this.f49498b.setStrokeCap(cap);
        this.f49498b.setStrokeWidth(this.f49504i);
        Paint paint5 = new Paint();
        this.f49499c = paint5;
        paint5.setAntiAlias(true);
        this.f49499c.setStyle(Paint.Style.FILL);
        this.f49499c.setColor(this.f49502g);
        this.f49499c.setTextSize(this.f49503h / 2.0f);
        this.f49499c.getFontMetrics();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f49503h, this.f49497a);
        if (this.f49506k >= 0) {
            RectF rectF = new RectF((getWidth() / 2) - this.f49503h, (getHeight() / 2) - this.f49503h, (getWidth() / 2) + this.f49503h, (getHeight() / 2) + this.f49503h);
            canvas.drawArc(rectF, 0.0f, 0.0f, false, this.f49498b);
            canvas.drawArc(rectF, -90.0f, (this.f49506k / this.f49505j) * 360.0f, false, this.f49498b);
        }
    }

    public void setMax(int i11) {
        this.f49505j = i11;
        postInvalidate();
    }

    public void setProgress(int i11) {
        this.f49506k = i11;
        postInvalidate();
    }

    public void setRingColor(int i11) {
        this.f49501f = i11;
        this.f49498b.setColor(i11);
        postInvalidate();
    }
}
