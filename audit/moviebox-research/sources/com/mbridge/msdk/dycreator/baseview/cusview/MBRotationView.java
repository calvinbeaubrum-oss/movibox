package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBRotationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f43430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Camera f43431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f43432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f43439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f43440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f43441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f43442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f43443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f43444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f43445p;

    public MBRotationView(Context context) {
        super(context);
        this.f43435f = 40;
        this.f43436g = 20;
        this.f43437h = 0;
        this.f43438i = 0;
        this.f43440k = 0;
        this.f43441l = 0.5f;
        this.f43442m = 0.9f;
        this.f43443n = true;
        this.f43444o = false;
        this.f43445p = false;
        this.f43430a = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.a(MBRotationView.this);
            }
        };
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43435f = 40;
        this.f43436g = 20;
        this.f43437h = 0;
        this.f43438i = 0;
        this.f43440k = 0;
        this.f43441l = 0.5f;
        this.f43442m = 0.9f;
        this.f43443n = true;
        this.f43444o = false;
        this.f43445p = false;
        this.f43430a = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.a(MBRotationView.this);
            }
        };
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43435f = 40;
        this.f43436g = 20;
        this.f43437h = 0;
        this.f43438i = 0;
        this.f43440k = 0;
        this.f43441l = 0.5f;
        this.f43442m = 0.9f;
        this.f43443n = true;
        this.f43444o = false;
        this.f43445p = false;
        this.f43430a = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.a(MBRotationView.this);
            }
        };
        a();
    }

    private int a(int i11) {
        int i12;
        int i13;
        int i14;
        if (i11 == 0) {
            i12 = this.f43445p ? this.f43438i - 2 : this.f43438i + 2;
        } else if (i11 != 1) {
            if (i11 != 2) {
                i12 = i11 != 3 ? 0 : this.f43438i;
            } else if (this.f43445p) {
                i13 = this.f43438i;
                i12 = i13 - 1;
            } else {
                i14 = this.f43438i;
                i12 = i14 + 1;
            }
        } else if (this.f43445p) {
            i14 = this.f43438i;
            i12 = i14 + 1;
        } else {
            i13 = this.f43438i;
            i12 = i13 - 1;
        }
        int childCount = i12 % getChildCount();
        return childCount >= 0 ? childCount : childCount + getChildCount();
    }

    private void a() {
        this.f43431b = new Camera();
        this.f43432c = new Matrix();
        setWillNotDraw(false);
    }

    private void a(int i11, int i12, int i13) {
        float f11 = (-i11) / 2.0f;
        if (i13 == 0) {
            this.f43431b.translate(0.0f, f11, 0.0f);
            float f12 = -i12;
            this.f43431b.rotateX(f12);
            this.f43431b.translate(0.0f, f11, 0.0f);
            this.f43431b.translate(0.0f, f11, 0.0f);
            this.f43431b.rotateX(f12);
            this.f43431b.translate(0.0f, f11, 0.0f);
            return;
        }
        if (i13 == 1) {
            this.f43431b.translate(0.0f, f11, 0.0f);
            this.f43431b.rotateX(i12);
            this.f43431b.translate(0.0f, f11, 0.0f);
        } else if (i13 != 2) {
            if (i13 != 3) {
                return;
            }
            this.f43431b.rotateX(0.0f);
        } else {
            this.f43431b.translate(0.0f, f11, 0.0f);
            this.f43431b.rotateX(-i12);
            this.f43431b.translate(0.0f, f11, 0.0f);
        }
    }

    private void a(Canvas canvas, int i11, int i12, int i13) {
        canvas.save();
        this.f43431b.save();
        this.f43432c.reset();
        float f11 = i11;
        this.f43431b.translate(0.0f, f11, 0.0f);
        this.f43431b.rotateX(this.f43437h);
        this.f43431b.translate(0.0f, f11, 0.0f);
        if (i11 == 0) {
            if (this.f43445p) {
                a(this.f43433d, this.f43435f, i13);
            } else {
                a(-this.f43433d, -this.f43435f, i13);
            }
        } else if (i11 > 0) {
            a(this.f43433d, this.f43435f, i13);
        } else if (i11 < 0) {
            a(-this.f43433d, -this.f43435f, i13);
        }
        this.f43431b.getMatrix(this.f43432c);
        this.f43431b.restore();
        this.f43432c.preTranslate((-getWidth()) / 2, -i12);
        this.f43432c.postTranslate(getWidth() / 2, i12);
        canvas.concat(this.f43432c);
        View childAt = getChildAt(a(i13));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    public static /* synthetic */ void a(MBRotationView mBRotationView) {
        if (mBRotationView.getChildCount() == 0) {
            return;
        }
        int i11 = mBRotationView.f43437h - 1;
        mBRotationView.f43437h = i11;
        int i12 = mBRotationView.f43438i;
        mBRotationView.f43439j = i12;
        int i13 = mBRotationView.f43435f;
        int i14 = i12 - (i11 / i13);
        int i15 = i11 % i13;
        mBRotationView.f43437h = i15;
        mBRotationView.f43438i = i14;
        int iA = Math.abs(i15) > mBRotationView.f43435f / 2 ? mBRotationView.a(2) : mBRotationView.a(3);
        if (mBRotationView.f43440k != iA) {
            mBRotationView.f43440k = iA;
        }
        mBRotationView.invalidate();
        if (mBRotationView.f43443n) {
            mBRotationView.postDelayed(mBRotationView.f43430a, 1000 / mBRotationView.f43436g);
        }
    }

    private void b(int i11, int i12, int i13) {
        if (i13 == 0) {
            float f11 = (-i11) / 2;
            this.f43431b.translate(f11, 0.0f, 0.0f);
            float f12 = -i12;
            this.f43431b.rotateY(f12);
            this.f43431b.translate(f11, 0.0f, 0.0f);
            this.f43431b.translate(f11, 0.0f, 0.0f);
            this.f43431b.rotateY(f12);
            this.f43431b.translate(f11, 0.0f, 0.0f);
            return;
        }
        if (i13 == 1) {
            float f13 = i11 / 2;
            this.f43431b.translate(f13, 0.0f, 0.0f);
            this.f43431b.rotateY(i12);
            this.f43431b.translate(f13, 0.0f, 0.0f);
            return;
        }
        if (i13 != 2) {
            if (i13 != 3) {
                return;
            }
            this.f43431b.rotateY(0.0f);
        } else {
            float f14 = (-i11) / 2;
            this.f43431b.translate(f14, 0.0f, 0.0f);
            this.f43431b.rotateY(-i12);
            this.f43431b.translate(f14, 0.0f, 0.0f);
        }
    }

    private void b(Canvas canvas, int i11, int i12, int i13) {
        canvas.save();
        this.f43431b.save();
        this.f43432c.reset();
        float f11 = i11;
        this.f43431b.translate(f11, 0.0f, 0.0f);
        this.f43431b.rotateY(this.f43437h);
        this.f43431b.translate(f11, 0.0f, 0.0f);
        if (i11 == 0) {
            if (this.f43445p) {
                b(this.f43434e, this.f43435f, i13);
            } else {
                b(-this.f43434e, -this.f43435f, i13);
            }
        } else if (i11 > 0) {
            b(this.f43434e, this.f43435f, i13);
        } else if (i11 < 0) {
            b(-this.f43434e, -this.f43435f, i13);
        }
        this.f43431b.getMatrix(this.f43432c);
        this.f43431b.restore();
        this.f43432c.preTranslate(-i12, (-getHeight()) / 2);
        this.f43432c.postTranslate(i12, getHeight() / 2);
        canvas.concat(this.f43432c);
        View childAt = getChildAt(a(i13));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.f43444o) {
            int height = getHeight() / 2;
            int i11 = ((this.f43437h * this.f43433d) / 2) / this.f43435f;
            a(canvas, i11, height, 0);
            a(canvas, i11, height, 1);
            if (Math.abs(this.f43437h) > this.f43435f / 2) {
                a(canvas, i11, height, 3);
                a(canvas, i11, height, 2);
                return;
            } else {
                a(canvas, i11, height, 2);
                a(canvas, i11, height, 3);
                return;
            }
        }
        int width = getWidth() / 2;
        int i12 = ((this.f43437h * this.f43434e) / 2) / this.f43435f;
        b(canvas, i12, width, 0);
        b(canvas, i12, width, 1);
        if (Math.abs(this.f43437h) > this.f43435f / 2) {
            b(canvas, i12, width, 3);
            b(canvas, i12, width, 2);
        } else {
            b(canvas, i12, width, 2);
            b(canvas, i12, width, 3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        float f11 = i15;
        float f12 = this.f43441l;
        int i16 = (int) (((1.0f - f12) * f11) / 2.0f);
        int i17 = i14 - i12;
        float f13 = i17;
        float f14 = this.f43442m;
        int i18 = (int) (((1.0f - f14) * f13) / 2.0f);
        this.f43433d = (int) (f13 * f14);
        this.f43434e = (int) (f11 * f12);
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            childAt.layout(i16, i18, i15 - i16, i17 - i18);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i21 = layoutParams.width;
            int i22 = this.f43434e;
            if (i21 != i22) {
                layoutParams.width = i22;
                layoutParams.height = this.f43433d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z11) {
        if (z11) {
            postDelayed(this.f43430a, 1000 / this.f43436g);
        }
        this.f43443n = z11;
    }

    public void setHeightRatio(float f11) {
        this.f43442m = f11;
    }

    public void setRotateV(boolean z11) {
        this.f43444o = z11;
        invalidate();
    }

    public void setWidthRatio(float f11) {
        this.f43441l = f11;
    }
}
