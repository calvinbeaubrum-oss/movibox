package com.transsion.publish.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.transsion.publish.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class CircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f56628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f56629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56631d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f56632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f56633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f56636j;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56634h = 100;
        this.f56636j = 0;
        a(context, attributeSet);
        b();
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressbar, 0, 0);
        this.f56632f = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_ra, 80.0f);
        this.f56633g = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleProgressbar_strokesWidth, 10.0f);
        this.f56630c = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressbar_ringsColor, 16711680);
        this.f56631d = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressbar_textsColor, 16777215);
    }

    public final void b() {
        Paint paint = new Paint();
        this.f56628a = paint;
        paint.setAntiAlias(true);
        this.f56628a.setDither(true);
        this.f56628a.setColor(this.f56630c);
        this.f56628a.setStyle(Paint.Style.STROKE);
        this.f56628a.setStrokeCap(Paint.Cap.ROUND);
        this.f56628a.setStrokeWidth(this.f56633g);
        Paint paint2 = new Paint();
        this.f56629b = paint2;
        paint2.setAntiAlias(true);
        this.f56629b.setStyle(Paint.Style.FILL);
        this.f56629b.setColor(this.f56631d);
        this.f56629b.setTextSize(this.f56632f / 2.0f);
        this.f56629b.getFontMetrics();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f56635i >= 0) {
            RectF rectF = new RectF((getWidth() / 2) - this.f56632f, (getHeight() / 2) - this.f56632f, (getWidth() / 2) + this.f56632f, (getHeight() / 2) + this.f56632f);
            canvas.drawArc(rectF, 0.0f, 0.0f, false, this.f56628a);
            canvas.drawArc(rectF, -90.0f, (this.f56635i / this.f56634h) * 360.0f, false, this.f56628a);
        }
    }

    public void setProgress(int i11) {
        this.f56635i = i11;
        postInvalidate();
    }

    public void setRingColor(int i11) {
        this.f56630c = i11;
        this.f56628a.setColor(i11);
        postInvalidate();
    }
}
