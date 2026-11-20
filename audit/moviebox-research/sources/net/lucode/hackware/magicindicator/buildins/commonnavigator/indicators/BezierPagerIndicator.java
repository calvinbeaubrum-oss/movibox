package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import g20.b;
import h20.c;
import i20.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class BezierPagerIndicator extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f71825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f71826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f71827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f71828d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f71829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f71830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f71831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f71832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f71833j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Path f71834k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Integer> f71835l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Interpolator f71836m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Interpolator f71837n;

    public BezierPagerIndicator(Context context) {
        super(context);
        this.f71834k = new Path();
        this.f71836m = new AccelerateInterpolator();
        this.f71837n = new DecelerateInterpolator();
        b(context);
    }

    public final void a(Canvas canvas) {
        this.f71834k.reset();
        float height = (getHeight() - this.f71830g) - this.f71831h;
        this.f71834k.moveTo(this.f71829f, height);
        this.f71834k.lineTo(this.f71829f, height - this.f71828d);
        Path path = this.f71834k;
        float f11 = this.f71829f;
        float f12 = this.f71827c;
        path.quadTo(f11 + ((f12 - f11) / 2.0f), height, f12, height - this.f71826b);
        this.f71834k.lineTo(this.f71827c, this.f71826b + height);
        Path path2 = this.f71834k;
        float f13 = this.f71829f;
        path2.quadTo(((this.f71827c - f13) / 2.0f) + f13, height, f13, this.f71828d + height);
        this.f71834k.close();
        canvas.drawPath(this.f71834k, this.f71833j);
    }

    public final void b(Context context) {
        Paint paint = new Paint(1);
        this.f71833j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f71831h = b.a(context, 3.5d);
        this.f71832i = b.a(context, 2.0d);
        this.f71830g = b.a(context, 1.5d);
    }

    public float getMaxCircleRadius() {
        return this.f71831h;
    }

    public float getMinCircleRadius() {
        return this.f71832i;
    }

    public float getYOffset() {
        return this.f71830g;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f71827c, (getHeight() - this.f71830g) - this.f71831h, this.f71826b, this.f71833j);
        canvas.drawCircle(this.f71829f, (getHeight() - this.f71830g) - this.f71831h, this.f71828d, this.f71833j);
        a(canvas);
    }

    @Override // h20.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // h20.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List<a> list = this.f71825a;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.f71835l;
        if (list2 != null && list2.size() > 0) {
            this.f71833j.setColor(g20.a.a(f11, this.f71835l.get(Math.abs(i11) % this.f71835l.size()).intValue(), this.f71835l.get(Math.abs(i11 + 1) % this.f71835l.size()).intValue()));
        }
        a aVarA = e20.a.a(this.f71825a, i11);
        a aVarA2 = e20.a.a(this.f71825a, i11 + 1);
        int i13 = aVarA.f66885a;
        float f12 = i13 + ((aVarA.f66887c - i13) / 2);
        int i14 = aVarA2.f66885a;
        float f13 = (i14 + ((aVarA2.f66887c - i14) / 2)) - f12;
        this.f71827c = (this.f71836m.getInterpolation(f11) * f13) + f12;
        this.f71829f = f12 + (f13 * this.f71837n.getInterpolation(f11));
        float f14 = this.f71831h;
        this.f71826b = f14 + ((this.f71832i - f14) * this.f71837n.getInterpolation(f11));
        float f15 = this.f71832i;
        this.f71828d = f15 + ((this.f71831h - f15) * this.f71836m.getInterpolation(f11));
        invalidate();
    }

    @Override // h20.c
    public void onPageSelected(int i11) {
    }

    @Override // h20.c
    public void onPositionDataProvide(List<a> list) {
        this.f71825a = list;
    }

    public void setColors(Integer... numArr) {
        this.f71835l = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f71837n = interpolator;
        if (interpolator == null) {
            this.f71837n = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f11) {
        this.f71831h = f11;
    }

    public void setMinCircleRadius(float f11) {
        this.f71832i = f11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f71836m = interpolator;
        if (interpolator == null) {
            this.f71836m = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f11) {
        this.f71830g = f11;
    }
}
