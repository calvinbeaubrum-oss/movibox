package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import g20.b;
import h20.c;
import i20.a;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class WrapPagerIndicator extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f71867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f71870d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Interpolator f71871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Interpolator f71872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<a> f71873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f71874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f71875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71876k;

    public WrapPagerIndicator(Context context) {
        super(context);
        this.f71871f = new LinearInterpolator();
        this.f71872g = new LinearInterpolator();
        this.f71875j = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f71874i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f71867a = b.a(context, 6.0d);
        this.f71868b = b.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.f71872g;
    }

    public int getFillColor() {
        return this.f71869c;
    }

    public int getHorizontalPadding() {
        return this.f71868b;
    }

    public Paint getPaint() {
        return this.f71874i;
    }

    public float getRoundRadius() {
        return this.f71870d;
    }

    public Interpolator getStartInterpolator() {
        return this.f71871f;
    }

    public int getVerticalPadding() {
        return this.f71867a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f71874i.setColor(this.f71869c);
        RectF rectF = this.f71875j;
        float f11 = this.f71870d;
        canvas.drawRoundRect(rectF, f11, f11, this.f71874i);
    }

    @Override // h20.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // h20.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List<a> list = this.f71873h;
        if (list == null || list.isEmpty()) {
            return;
        }
        a aVarA = e20.a.a(this.f71873h, i11);
        a aVarA2 = e20.a.a(this.f71873h, i11 + 1);
        RectF rectF = this.f71875j;
        int i13 = aVarA.f66889e;
        rectF.left = (i13 - this.f71868b) + ((aVarA2.f66889e - i13) * this.f71872g.getInterpolation(f11));
        RectF rectF2 = this.f71875j;
        rectF2.top = aVarA.f66890f - this.f71867a;
        int i14 = aVarA.f66891g;
        rectF2.right = this.f71868b + i14 + ((aVarA2.f66891g - i14) * this.f71871f.getInterpolation(f11));
        RectF rectF3 = this.f71875j;
        rectF3.bottom = aVarA.f66892h + this.f71867a;
        if (!this.f71876k) {
            this.f71870d = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // h20.c
    public void onPageSelected(int i11) {
    }

    @Override // h20.c
    public void onPositionDataProvide(List<a> list) {
        this.f71873h = list;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f71872g = interpolator;
        if (interpolator == null) {
            this.f71872g = new LinearInterpolator();
        }
    }

    public void setFillColor(int i11) {
        this.f71869c = i11;
    }

    public void setHorizontalPadding(int i11) {
        this.f71868b = i11;
    }

    public void setRoundRadius(float f11) {
        this.f71870d = f11;
        this.f71876k = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f71871f = interpolator;
        if (interpolator == null) {
            this.f71871f = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i11) {
        this.f71867a = i11;
    }
}
