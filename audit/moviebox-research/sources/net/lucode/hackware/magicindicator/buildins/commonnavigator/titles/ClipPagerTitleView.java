package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import h20.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ClipPagerTitleView extends View implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f71877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f71880d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f71881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f71882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f71883h;

    public ClipPagerTitleView(Context context) {
        super(context);
        this.f71883h = new Rect();
        a(context);
    }

    private void a(Context context) {
        int iA = g20.b.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f71882g = paint;
        paint.setTextSize(iA);
        int iA2 = g20.b.a(context, 10.0d);
        setPadding(iA2, 0, iA2, 0);
    }

    public final int b(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : this.f71883h.height() + getPaddingTop() + getPaddingBottom();
        }
        return Math.min(this.f71883h.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    public final void c() {
        Paint paint = this.f71882g;
        String str = this.f71877a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f71883h);
    }

    public final int d(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : this.f71883h.width() + getPaddingLeft() + getPaddingRight();
        }
        return Math.min(this.f71883h.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    public int getClipColor() {
        return this.f71879c;
    }

    @Override // h20.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f71882g.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // h20.b
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.f71883h.width() / 2);
    }

    @Override // h20.b
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.f71883h.width() / 2);
    }

    @Override // h20.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f71882g.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.f71877a;
    }

    public int getTextColor() {
        return this.f71878b;
    }

    public float getTextSize() {
        return this.f71882g.getTextSize();
    }

    @Override // h20.d
    public void onDeselected(int i11, int i12) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = (getWidth() - this.f71883h.width()) / 2;
        Paint.FontMetrics fontMetrics = this.f71882g.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f71882g.setColor(this.f71878b);
        float f11 = width;
        float f12 = height;
        canvas.drawText(this.f71877a, f11, f12, this.f71882g);
        canvas.save();
        if (this.f71880d) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.f71881f, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.f71881f), 0.0f, getWidth(), getHeight());
        }
        this.f71882g.setColor(this.f71879c);
        canvas.drawText(this.f71877a, f11, f12, this.f71882g);
        canvas.restore();
    }

    @Override // h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
        this.f71880d = z11;
        this.f71881f = f11;
        invalidate();
    }

    @Override // h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
        this.f71880d = !z11;
        this.f71881f = 1.0f - f11;
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        c();
        setMeasuredDimension(d(i11), b(i12));
    }

    @Override // h20.d
    public void onSelected(int i11, int i12) {
    }

    public void setClipColor(int i11) {
        this.f71879c = i11;
        invalidate();
    }

    public void setText(String str) {
        this.f71877a = str;
        requestLayout();
    }

    public void setTextColor(int i11) {
        this.f71878b = i11;
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f71882g.setTextSize(f11);
        requestLayout();
    }
}
