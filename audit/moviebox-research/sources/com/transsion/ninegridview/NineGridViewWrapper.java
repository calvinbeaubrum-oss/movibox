package com.transsion.ninegridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class NineGridViewWrapper extends ShapeableImageView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f53935u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f53936v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f53937w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f53938x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextPaint f53939y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f53940z;

    public NineGridViewWrapper(Context context) {
        this(context, null);
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridViewWrapper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f53935u = 0;
        this.f53936v = -2013265920;
        this.f53937w = 35.0f;
        this.f53938x = -1;
        this.f53940z = "";
        this.f53937w = TypedValue.applyDimension(2, 35.0f, getContext().getResources().getDisplayMetrics());
        TextPaint textPaint = new TextPaint();
        this.f53939y = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.f53939y.setAntiAlias(true);
        this.f53939y.setTextSize(this.f53937w);
        this.f53939y.setColor(this.f53938x);
    }

    public int getMaskColor() {
        return this.f53936v;
    }

    public int getMoreNum() {
        return this.f53935u;
    }

    public int getTextColor() {
        return this.f53938x;
    }

    public float getTextSize() {
        return this.f53937w;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.google.android.material.imageview.ShapeableImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f53935u > 0) {
            canvas.drawColor(this.f53936v);
            canvas.drawText(this.f53940z, getWidth() / 2, (getHeight() / 2) - ((this.f53939y.ascent() + this.f53939y.descent()) / 2.0f), this.f53939y);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setMaskColor(int i11) {
        this.f53936v = i11;
        invalidate();
    }

    public void setMoreNum(int i11) {
        this.f53935u = i11;
        this.f53940z = "+" + i11;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f53938x = i11;
        this.f53939y.setColor(i11);
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f53937w = f11;
        this.f53939y.setTextSize(f11);
        invalidate();
    }
}
