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
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LinePagerIndicator extends View implements c {
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f71838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f71839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f71840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f71841d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f71842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f71843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f71844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f71845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f71846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<a> f71847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Integer> f71848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f71849m;

    public LinePagerIndicator(Context context) {
        super(context);
        this.f71839b = new LinearInterpolator();
        this.f71840c = new LinearInterpolator();
        this.f71849m = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f71846j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f71842f = b.a(context, 3.0d);
        this.f71844h = b.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.f71848l;
    }

    public Interpolator getEndInterpolator() {
        return this.f71840c;
    }

    public float getLineHeight() {
        return this.f71842f;
    }

    public float getLineWidth() {
        return this.f71844h;
    }

    public int getMode() {
        return this.f71838a;
    }

    public Paint getPaint() {
        return this.f71846j;
    }

    public float getRoundRadius() {
        return this.f71845i;
    }

    public Interpolator getStartInterpolator() {
        return this.f71839b;
    }

    public float getXOffset() {
        return this.f71843g;
    }

    public float getYOffset() {
        return this.f71841d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f71849m;
        float f11 = this.f71845i;
        canvas.drawRoundRect(rectF, f11, f11, this.f71846j);
    }

    @Override // h20.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // h20.c
    public void onPageScrolled(int i11, float f11, int i12) {
        float fB;
        float fB2;
        float fB3;
        float f12;
        float f13;
        int i13;
        List<a> list = this.f71847k;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.f71848l;
        if (list2 != null && list2.size() > 0) {
            this.f71846j.setColor(g20.a.a(f11, this.f71848l.get(Math.abs(i11) % this.f71848l.size()).intValue(), this.f71848l.get(Math.abs(i11 + 1) % this.f71848l.size()).intValue()));
        }
        a aVarA = e20.a.a(this.f71847k, i11);
        a aVarA2 = e20.a.a(this.f71847k, i11 + 1);
        int i14 = this.f71838a;
        if (i14 != 0) {
            if (i14 == 1) {
                float f14 = aVarA.f66889e;
                f13 = this.f71843g;
                fB = f14 + f13;
                f12 = aVarA2.f66889e + f13;
                fB2 = aVarA.f66891g - f13;
                i13 = aVarA2.f66891g;
            } else {
                fB = aVarA.f66885a + ((aVarA.b() - this.f71844h) / 2.0f);
                float fB4 = aVarA2.f66885a + ((aVarA2.b() - this.f71844h) / 2.0f);
                fB2 = ((aVarA.b() + this.f71844h) / 2.0f) + aVarA.f66885a;
                fB3 = ((aVarA2.b() + this.f71844h) / 2.0f) + aVarA2.f66885a;
                f12 = fB4;
            }
            this.f71849m.left = fB + ((f12 - fB) * this.f71839b.getInterpolation(f11));
            this.f71849m.right = fB2 + ((fB3 - fB2) * this.f71840c.getInterpolation(f11));
            this.f71849m.top = (getHeight() - this.f71842f) - this.f71841d;
            this.f71849m.bottom = getHeight() - this.f71841d;
            invalidate();
        }
        float f15 = aVarA.f66885a;
        f13 = this.f71843g;
        fB = f15 + f13;
        f12 = aVarA2.f66885a + f13;
        fB2 = aVarA.f66887c - f13;
        i13 = aVarA2.f66887c;
        fB3 = i13 - f13;
        this.f71849m.left = fB + ((f12 - fB) * this.f71839b.getInterpolation(f11));
        this.f71849m.right = fB2 + ((fB3 - fB2) * this.f71840c.getInterpolation(f11));
        this.f71849m.top = (getHeight() - this.f71842f) - this.f71841d;
        this.f71849m.bottom = getHeight() - this.f71841d;
        invalidate();
    }

    @Override // h20.c
    public void onPageSelected(int i11) {
    }

    @Override // h20.c
    public void onPositionDataProvide(List<a> list) {
        this.f71847k = list;
    }

    public void setColors(Integer... numArr) {
        this.f71848l = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f71840c = interpolator;
        if (interpolator == null) {
            this.f71840c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f11) {
        this.f71842f = f11;
    }

    public void setLineWidth(float f11) {
        this.f71844h = f11;
    }

    public void setMode(int i11) {
        if (i11 == 2 || i11 == 0 || i11 == 1) {
            this.f71838a = i11;
            return;
        }
        throw new IllegalArgumentException("mode " + i11 + " not supported.");
    }

    public void setRoundRadius(float f11) {
        this.f71845i = f11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f71839b = interpolator;
        if (interpolator == null) {
            this.f71839b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f11) {
        this.f71843g = f11;
    }

    public void setYOffset(float f11) {
        this.f71841d = f11;
    }
}
