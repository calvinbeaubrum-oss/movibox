package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import g20.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class CircleNavigator extends View implements f20.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f71791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f71794d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f71796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Interpolator f71797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f71798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<PointF> f71799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f71800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f71801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f71802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f71803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f71804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f71805p;

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    public CircleNavigator(Context context) {
        super(context);
        this.f71797h = new LinearInterpolator();
        this.f71798i = new Paint(1);
        this.f71799j = new ArrayList();
        this.f71805p = true;
        c(context);
    }

    public final void a(Canvas canvas) {
        this.f71798i.setStyle(Paint.Style.STROKE);
        this.f71798i.setStrokeWidth(this.f71793c);
        int size = this.f71799j.size();
        for (int i11 = 0; i11 < size; i11++) {
            PointF pointF = this.f71799j.get(i11);
            canvas.drawCircle(pointF.x, pointF.y, this.f71791a, this.f71798i);
        }
    }

    public final void b(Canvas canvas) {
        this.f71798i.setStyle(Paint.Style.FILL);
        if (this.f71799j.size() > 0) {
            canvas.drawCircle(this.f71800k, (int) ((getHeight() / 2.0f) + 0.5f), this.f71791a, this.f71798i);
        }
    }

    public final void c(Context context) {
        this.f71804o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f71791a = b.a(context, 3.0d);
        this.f71794d = b.a(context, 8.0d);
        this.f71793c = b.a(context, 1.0d);
    }

    public final int d(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.f71791a * 2) + (this.f71793c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public final int e(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f71796g;
            return (this.f71793c * 2) + (this.f71791a * i12 * 2) + ((i12 - 1) * this.f71794d) + getPaddingLeft() + getPaddingRight();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public final void f() {
        this.f71799j.clear();
        if (this.f71796g > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i11 = this.f71791a;
            int i12 = (i11 * 2) + this.f71794d;
            int paddingLeft = i11 + ((int) ((this.f71793c / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i13 = 0; i13 < this.f71796g; i13++) {
                this.f71799j.add(new PointF(paddingLeft, height));
                paddingLeft += i12;
            }
            this.f71800k = this.f71799j.get(this.f71795f).x;
        }
    }

    public a getCircleClickListener() {
        return null;
    }

    public int getCircleColor() {
        return this.f71792b;
    }

    public int getCircleCount() {
        return this.f71796g;
    }

    public int getCircleSpacing() {
        return this.f71794d;
    }

    public int getRadius() {
        return this.f71791a;
    }

    public Interpolator getStartInterpolator() {
        return this.f71797h;
    }

    public int getStrokeWidth() {
        return this.f71793c;
    }

    public boolean isFollowTouch() {
        return this.f71805p;
    }

    public boolean isTouchable() {
        return this.f71801l;
    }

    @Override // f20.a
    public void notifyDataSetChanged() {
        f();
        invalidate();
    }

    @Override // f20.a
    public void onAttachToMagicIndicator() {
    }

    @Override // f20.a
    public void onDetachFromMagicIndicator() {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f71798i.setColor(this.f71792b);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        f();
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(e(i11), d(i12));
    }

    @Override // f20.a
    public void onPageScrollStateChanged(int i11) {
    }

    @Override // f20.a
    public void onPageScrolled(int i11, float f11, int i12) {
        if (!this.f71805p || this.f71799j.isEmpty()) {
            return;
        }
        int iMin = Math.min(this.f71799j.size() - 1, i11);
        int iMin2 = Math.min(this.f71799j.size() - 1, i11 + 1);
        PointF pointF = this.f71799j.get(iMin);
        PointF pointF2 = this.f71799j.get(iMin2);
        float f12 = pointF.x;
        this.f71800k = f12 + ((pointF2.x - f12) * this.f71797h.getInterpolation(f11));
        invalidate();
    }

    @Override // f20.a
    public void onPageSelected(int i11) {
        this.f71795f = i11;
        if (this.f71805p) {
            return;
        }
        this.f71800k = this.f71799j.get(i11).x;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (motionEvent.getAction() != 0 || !this.f71801l) {
            return super.onTouchEvent(motionEvent);
        }
        this.f71802m = x11;
        this.f71803n = y11;
        return true;
    }

    public void setCircleClickListener(a aVar) {
        if (this.f71801l) {
            return;
        }
        this.f71801l = true;
    }

    public void setCircleColor(int i11) {
        this.f71792b = i11;
        invalidate();
    }

    public void setCircleCount(int i11) {
        this.f71796g = i11;
    }

    public void setCircleSpacing(int i11) {
        this.f71794d = i11;
        f();
        invalidate();
    }

    public void setFollowTouch(boolean z11) {
        this.f71805p = z11;
    }

    public void setRadius(int i11) {
        this.f71791a = i11;
        f();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f71797h = interpolator;
        if (interpolator == null) {
            this.f71797h = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i11) {
        this.f71793c = i11;
        invalidate();
    }

    public void setTouchable(boolean z11) {
        this.f71801l = z11;
    }
}
