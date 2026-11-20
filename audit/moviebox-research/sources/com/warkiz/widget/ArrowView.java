package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ArrowView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f62660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f62661d;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int iA = g.a(context, 12.0f);
        this.f62658a = iA;
        int iA2 = g.a(context, 7.0f);
        this.f62659b = iA2;
        Path path = new Path();
        this.f62660c = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo(iA, 0.0f);
        path.lineTo(iA / 2.0f, iA2);
        path.close();
        Paint paint = new Paint();
        this.f62661d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.f62660c, this.f62661d);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(this.f62658a, this.f62659b);
    }

    public void setColor(int i11) {
        this.f62661d.setColor(i11);
        invalidate();
    }
}
