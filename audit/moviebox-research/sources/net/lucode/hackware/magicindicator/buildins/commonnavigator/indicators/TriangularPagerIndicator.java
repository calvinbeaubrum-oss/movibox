package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import g20.b;
import h20.c;
import i20.a;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class TriangularPagerIndicator extends View implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f71856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f71857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f71859d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f71861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f71862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f71863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Path f71864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Interpolator f71865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f71866l;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.f71864j = new Path();
        this.f71865k = new LinearInterpolator();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f71857b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f71858c = b.a(context, 3.0d);
        this.f71861g = b.a(context, 14.0d);
        this.f71860f = b.a(context, 8.0d);
    }

    public int getLineColor() {
        return this.f71859d;
    }

    public int getLineHeight() {
        return this.f71858c;
    }

    public Interpolator getStartInterpolator() {
        return this.f71865k;
    }

    public int getTriangleHeight() {
        return this.f71860f;
    }

    public int getTriangleWidth() {
        return this.f71861g;
    }

    public float getYOffset() {
        return this.f71863i;
    }

    public boolean isReverse() {
        return this.f71862h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f71857b.setColor(this.f71859d);
        if (this.f71862h) {
            canvas.drawRect(0.0f, (getHeight() - this.f71863i) - this.f71860f, getWidth(), ((getHeight() - this.f71863i) - this.f71860f) + this.f71858c, this.f71857b);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.f71858c) - this.f71863i, getWidth(), getHeight() - this.f71863i, this.f71857b);
        }
        this.f71864j.reset();
        if (this.f71862h) {
            this.f71864j.moveTo(this.f71866l - (this.f71861g / 2), (getHeight() - this.f71863i) - this.f71860f);
            this.f71864j.lineTo(this.f71866l, getHeight() - this.f71863i);
            this.f71864j.lineTo(this.f71866l + (this.f71861g / 2), (getHeight() - this.f71863i) - this.f71860f);
        } else {
            this.f71864j.moveTo(this.f71866l - (this.f71861g / 2), getHeight() - this.f71863i);
            this.f71864j.lineTo(this.f71866l, (getHeight() - this.f71860f) - this.f71863i);
            this.f71864j.lineTo(this.f71866l + (this.f71861g / 2), getHeight() - this.f71863i);
        }
        this.f71864j.close();
        canvas.drawPath(this.f71864j, this.f71857b);
    }

    @Override // h20.c
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // h20.c
    public void onPageScrolled(int i11, float f11, int i12) {
        List<a> list = this.f71856a;
        if (list == null || list.isEmpty()) {
            return;
        }
        a aVarA = e20.a.a(this.f71856a, i11);
        a aVarA2 = e20.a.a(this.f71856a, i11 + 1);
        int i13 = aVarA.f66885a;
        float f12 = i13 + ((aVarA.f66887c - i13) / 2);
        int i14 = aVarA2.f66885a;
        this.f71866l = f12 + (((i14 + ((aVarA2.f66887c - i14) / 2)) - f12) * this.f71865k.getInterpolation(f11));
        invalidate();
    }

    @Override // h20.c
    public void onPageSelected(int i11) {
    }

    @Override // h20.c
    public void onPositionDataProvide(List<a> list) {
        this.f71856a = list;
    }

    public void setLineColor(int i11) {
        this.f71859d = i11;
    }

    public void setLineHeight(int i11) {
        this.f71858c = i11;
    }

    public void setReverse(boolean z11) {
        this.f71862h = z11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f71865k = interpolator;
        if (interpolator == null) {
            this.f71865k = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i11) {
        this.f71860f = i11;
    }

    public void setTriangleWidth(int i11) {
        this.f71861g = i11;
    }

    public void setYOffset(float f11) {
        this.f71863i = f11;
    }
}
