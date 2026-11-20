package com.to.aboomy.pager2banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class IndicatorView extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Interpolator f50238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f50239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f50240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f50241d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f50242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f50244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f50245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f50246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f50247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelativeLayout.LayoutParams f50248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f50249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f50250n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f50251o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f50252p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f50253q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f50254r;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f50238a = new DecelerateInterpolator();
        this.f50244h = -7829368;
        this.f50245i = -1;
        this.f50250n = a(3.5f);
        this.f50251o = 1.0f;
        this.f50252p = a(3.5f);
        this.f50253q = 1.0f;
        this.f50254r = a(10.0f);
        this.f50247k = new RectF();
        this.f50246j = new Paint(1);
    }

    private float getRatioRadius() {
        return this.f50250n * this.f50251o;
    }

    private float getRatioSelectedRadius() {
        return this.f50252p * this.f50253q;
    }

    public final int a(float f11) {
        return (int) (f11 * getContext().getResources().getDisplayMetrics().density);
    }

    public final void b(Canvas canvas, float f11) {
        g(canvas, f11);
        if (this.f50240c == null) {
            this.f50240c = new Path();
        }
        if (this.f50239b == null) {
            this.f50239b = new AccelerateInterpolator();
        }
        float fH = h(this.f50242f);
        float fH2 = h((this.f50242f + 1) % this.f50243g) - fH;
        float interpolation = (this.f50239b.getInterpolation(this.f50241d) * fH2) + fH;
        float fI = fH + (fH2 * i());
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f12 = this.f50252p * 0.57f;
        float f13 = this.f50253q * f12;
        float fI2 = ((f13 - ratioSelectedRadius) * i()) + ratioSelectedRadius;
        float interpolation2 = f13 + ((ratioSelectedRadius - f13) * this.f50239b.getInterpolation(this.f50241d));
        float fI3 = (this.f50252p - f12) * i();
        float interpolation3 = (this.f50252p - f12) * this.f50239b.getInterpolation(this.f50241d);
        this.f50246j.setColor(this.f50245i);
        float f14 = this.f50252p;
        this.f50247k.set(interpolation - fI2, (f11 - f14) + fI3, interpolation + fI2, (f14 + f11) - fI3);
        canvas.drawRoundRect(this.f50247k, fI2, fI2, this.f50246j);
        float f15 = (f11 - f12) - interpolation3;
        float f16 = f12 + f11 + interpolation3;
        this.f50247k.set(fI - interpolation2, f15, fI + interpolation2, f16);
        canvas.drawRoundRect(this.f50247k, interpolation2, interpolation2, this.f50246j);
        this.f50240c.reset();
        this.f50240c.moveTo(fI, f11);
        this.f50240c.lineTo(fI, f15);
        float f17 = ((interpolation - fI) / 2.0f) + fI;
        this.f50240c.quadTo(f17, f11, interpolation, (f11 - this.f50252p) + fI3);
        this.f50240c.lineTo(interpolation, (this.f50252p + f11) - fI3);
        this.f50240c.quadTo(f17, f11, fI, f16);
        this.f50240c.close();
        canvas.drawPath(this.f50240c, this.f50246j);
    }

    public final void c(Canvas canvas, float f11) {
        g(canvas, f11);
        float fI = i();
        float fH = h(this.f50242f);
        float fH2 = h((this.f50242f + 1) % this.f50243g);
        float ratioRadius = getRatioRadius();
        float f12 = this.f50252p;
        float f13 = this.f50253q * f12;
        float f14 = (f13 - ratioRadius) * fI;
        float f15 = f13 - f14;
        float f16 = ratioRadius + f14;
        float f17 = (f12 - this.f50250n) * fI;
        this.f50246j.setColor(this.f50245i);
        if (fI < 0.99f) {
            RectF rectF = this.f50247k;
            rectF.set(fH - f15, (f11 - f12) + f17, fH + f15, (f12 + f11) - f17);
            canvas.drawRoundRect(this.f50247k, f15, f15, this.f50246j);
        }
        if (fI > 0.1f) {
            float f18 = this.f50250n;
            float f19 = f11 + f18 + f17;
            RectF rectF2 = this.f50247k;
            rectF2.set(fH2 - f16, (f11 - f18) - f17, fH2 + f16, f19);
            canvas.drawRoundRect(this.f50247k, f16, f16, this.f50246j);
        }
    }

    public final void d(Canvas canvas, float f11) {
        g(canvas, f11);
        float fH = h(this.f50242f);
        float fH2 = h((this.f50242f + 1) % this.f50243g);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f12 = fH - ratioSelectedRadius;
        float f13 = fH + ratioSelectedRadius;
        float f14 = fH2 - ratioSelectedRadius;
        float fI = f12 + ((f14 - f12) * i());
        float fI2 = f13 + (((fH2 + ratioSelectedRadius) - f13) * i());
        RectF rectF = this.f50247k;
        float f15 = this.f50252p;
        rectF.set(fI, f11 - f15, fI2, f11 + f15);
        this.f50246j.setColor(this.f50245i);
        RectF rectF2 = this.f50247k;
        float f16 = this.f50252p;
        canvas.drawRoundRect(rectF2, f16, f16, this.f50246j);
    }

    public final void e(Canvas canvas, float f11) {
        float fMax;
        float fMin;
        g(canvas, f11);
        float fH = h(this.f50242f);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f12 = fH - ratioSelectedRadius;
        float f13 = fH + ratioSelectedRadius;
        float fI = i();
        float fMax2 = this.f50254r + (Math.max(getRatioRadius(), ratioSelectedRadius) * 2.0f);
        int i11 = this.f50242f;
        if ((i11 + 1) % this.f50243g == 0) {
            float f14 = fMax2 * (-i11);
            fMax = f12 + Math.max(f14 * fI * 2.0f, f14);
            fMin = Math.min(f14 * (fI - 0.5f) * 2.0f, 0.0f);
        } else {
            fMax = f12 + Math.max((fI - 0.5f) * fMax2 * 2.0f, 0.0f);
            fMin = Math.min(fI * fMax2 * 2.0f, fMax2);
        }
        float f15 = f13 + fMin;
        RectF rectF = this.f50247k;
        float f16 = this.f50252p;
        rectF.set(fMax, f11 - f16, f15, f11 + f16);
        this.f50246j.setColor(this.f50245i);
        RectF rectF2 = this.f50247k;
        float f17 = this.f50252p;
        canvas.drawRoundRect(rectF2, f17, f17, this.f50246j);
    }

    public final void f(Canvas canvas, float f11) {
        float fI = i();
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        float f12 = ratioSelectedRadius - ratioRadius;
        float f13 = f12 * fI;
        int i11 = (this.f50242f + 1) % this.f50243g;
        boolean z11 = i11 == 0;
        this.f50246j.setColor(this.f50244h);
        for (int i12 = 0; i12 < this.f50243g; i12++) {
            float fH = h(i12);
            if (z11) {
                fH += f13;
            }
            float f14 = fH - ratioRadius;
            float f15 = this.f50250n;
            float f16 = f11 - f15;
            float f17 = fH + ratioRadius;
            float f18 = f11 + f15;
            if (this.f50242f + 1 <= i12) {
                this.f50247k.set(f14 + f12, f16, f17 + f12, f18);
            } else {
                this.f50247k.set(f14, f16, f17, f18);
            }
            RectF rectF = this.f50247k;
            float f19 = this.f50250n;
            canvas.drawRoundRect(rectF, f19, f19, this.f50246j);
        }
        this.f50246j.setColor(this.f50245i);
        if (fI < 0.99f) {
            float fH2 = h(this.f50242f) - ratioSelectedRadius;
            if (z11) {
                fH2 += f13;
            }
            RectF rectF2 = this.f50247k;
            float f21 = this.f50252p;
            rectF2.set(fH2, f11 - f21, (((ratioSelectedRadius * 2.0f) + fH2) + f12) - f13, f11 + f21);
            RectF rectF3 = this.f50247k;
            float f22 = this.f50252p;
            canvas.drawRoundRect(rectF3, f22, f22, this.f50246j);
        }
        if (fI > 0.1f) {
            float fH3 = h(i11) + ratioSelectedRadius;
            if (z11) {
                f12 = f13;
            }
            float f23 = fH3 + f12;
            RectF rectF4 = this.f50247k;
            float f24 = this.f50252p;
            rectF4.set((f23 - (ratioSelectedRadius * 2.0f)) - f13, f11 - f24, f23, f11 + f24);
            RectF rectF5 = this.f50247k;
            float f25 = this.f50252p;
            canvas.drawRoundRect(rectF5, f25, f25, this.f50246j);
        }
    }

    public final void g(Canvas canvas, float f11) {
        this.f50246j.setColor(this.f50244h);
        for (int i11 = 0; i11 < this.f50243g; i11++) {
            float fH = h(i11);
            float ratioRadius = getRatioRadius();
            float f12 = this.f50250n;
            this.f50247k.set(fH - ratioRadius, f11 - f12, fH + ratioRadius, f12 + f11);
            RectF rectF = this.f50247k;
            float f13 = this.f50250n;
            canvas.drawRoundRect(rectF, f13, f13, this.f50246j);
        }
    }

    @Override // com.to.aboomy.pager2banner.a
    public RelativeLayout.LayoutParams getParams() {
        if (this.f50248l == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.f50248l = layoutParams;
            layoutParams.addRule(12);
            this.f50248l.addRule(14);
            this.f50248l.bottomMargin = a(10.0f);
        }
        return this.f50248l;
    }

    @Override // com.to.aboomy.pager2banner.a
    public View getView() {
        return this;
    }

    public final float h(int i11) {
        float ratioRadius = getRatioRadius();
        float fMax = Math.max(ratioRadius, getRatioSelectedRadius());
        return getPaddingLeft() + fMax + (((fMax * 2.0f) + this.f50254r) * i11) + (this.f50249m == 3 ? 0.0f : (fMax - ratioRadius) / 2.0f);
    }

    public final float i() {
        return this.f50238a.getInterpolation(this.f50241d);
    }

    @Override // com.to.aboomy.pager2banner.a
    public void initIndicatorCount(int i11, int i12) {
        this.f50243g = i11;
        setVisibility(i11 > 1 ? 0 : 8);
        requestLayout();
    }

    public final int j(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (int) ((Math.max(getRatioSelectedRadius(), getRatioRadius()) * 2.0f) + getPaddingTop() + getPaddingBottom());
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public final int k(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        float fMax = Math.max(ratioSelectedRadius, ratioRadius) * 2.0f;
        int i12 = this.f50243g;
        return (int) ((fMax * i12) + ((i12 - 1) * this.f50254r) + (ratioSelectedRadius - ratioRadius) + getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f50243g == 0) {
            return;
        }
        float height = (getHeight() / 2.0f) + 0.5f;
        int i11 = this.f50249m;
        if (i11 == 0) {
            d(canvas, height);
            return;
        }
        if (i11 == 1) {
            e(canvas, height);
            return;
        }
        if (i11 == 2) {
            b(canvas, height);
        } else if (i11 == 3) {
            f(canvas, height);
        } else if (i11 == 4) {
            c(canvas, height);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(k(i11), j(i12));
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageScrolled(int i11, float f11, int i12) {
        this.f50242f = i11;
        this.f50241d = f11;
        invalidate();
    }

    @Override // com.to.aboomy.pager2banner.a
    public void onPageSelected(int i11) {
    }

    public IndicatorView setIndicatorColor(int i11) {
        this.f50244h = i11;
        return this;
    }

    public IndicatorView setIndicatorRadius(float f11) {
        int iA = a(f11);
        if (this.f50250n == this.f50252p) {
            this.f50252p = iA;
        }
        this.f50250n = iA;
        return this;
    }

    public IndicatorView setIndicatorRatio(float f11) {
        if (this.f50251o == this.f50253q) {
            this.f50253q = f11;
        }
        this.f50251o = f11;
        return this;
    }

    public IndicatorView setIndicatorSelectedRadius(float f11) {
        this.f50252p = a(f11);
        return this;
    }

    public IndicatorView setIndicatorSelectedRatio(float f11) {
        this.f50253q = f11;
        return this;
    }

    public IndicatorView setIndicatorSelectorColor(int i11) {
        this.f50245i = i11;
        return this;
    }

    public IndicatorView setIndicatorSpacing(float f11) {
        this.f50254r = a(f11);
        return this;
    }

    public IndicatorView setIndicatorStyle(int i11) {
        this.f50249m = i11;
        return this;
    }

    public IndicatorView setParams(RelativeLayout.LayoutParams layoutParams) {
        this.f50248l = layoutParams;
        return this;
    }
}
