package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class CircleBubbleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f62664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f62665d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f62666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f62667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f62668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f62669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f62670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f62671k;

    public CircleBubbleView(Context context, float f11, int i11, int i12, String str) {
        super(context, null, 0);
        this.f62665d = context;
        this.f62664c = f11;
        this.f62662a = i11;
        this.f62663b = i12;
        a(str);
    }

    public final void a(String str) {
        Paint paint = new Paint();
        this.f62667g = paint;
        paint.setAntiAlias(true);
        this.f62667g.setStrokeWidth(1.0f);
        this.f62667g.setTextAlign(Paint.Align.CENTER);
        this.f62667g.setTextSize(this.f62664c);
        Rect rect = new Rect();
        this.f62667g.getTextBounds(str, 0, str.length(), rect);
        this.f62668h = rect.width() + g.a(this.f62665d, 4.0f);
        float fA = g.a(this.f62665d, 36.0f);
        if (this.f62668h < fA) {
            this.f62668h = fA;
        }
        this.f62670j = rect.height();
        this.f62669i = this.f62668h * 1.2f;
        b();
    }

    public final void b() {
        this.f62666f = new Path();
        float f11 = this.f62668h;
        this.f62666f.arcTo(new RectF(0.0f, 0.0f, f11, f11), 135.0f, 270.0f);
        this.f62666f.lineTo(this.f62668h / 2.0f, this.f62669i);
        this.f62666f.close();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f62667g.setColor(this.f62663b);
        canvas.drawPath(this.f62666f, this.f62667g);
        this.f62667g.setColor(this.f62662a);
        canvas.drawText(this.f62671k, this.f62668h / 2.0f, (this.f62669i / 2.0f) + (this.f62670j / 4.0f), this.f62667g);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension((int) this.f62668h, (int) this.f62669i);
    }

    public void setProgress(String str) {
        this.f62671k = str;
        invalidate();
    }
}
