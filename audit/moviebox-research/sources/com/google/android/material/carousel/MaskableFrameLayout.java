package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.carousel.MaskableFrameLayout;
import li.g;
import li.k;
import yi.d;
import yi.n;
import yi.q;
import yi.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class MaskableFrameLayout extends FrameLayout implements g, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f36483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f36484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public n f36485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f36486d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Boolean f36487f;

    public MaskableFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36483a = -1.0f;
        this.f36484b = new RectF();
        this.f36486d = r.a(this);
        this.f36487f = null;
        setShapeAppearanceModel(n.f(context, attributeSet, i11, 0, 0).m());
    }

    public static /* synthetic */ d d(d dVar) {
        return dVar instanceof yi.a ? yi.c.b((yi.a) dVar) : dVar;
    }

    public final /* synthetic */ void c(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f36486d.e(canvas, new ji.a.InterfaceC0730a() { // from class: li.h
            @Override // ji.a.InterfaceC0730a
            public final void a(Canvas canvas2) {
                this.f70297a.c(canvas2);
            }
        });
    }

    public final void e() {
        this.f36486d.f(this, this.f36484b);
    }

    public final void f() {
        if (this.f36483a != -1.0f) {
            float fB = ii.b.b(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.f36483a);
            setMaskRectF(new RectF(fB, 0.0f, getWidth() - fB, getHeight()));
        }
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        RectF rectF = this.f36484b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    @NonNull
    public RectF getMaskRectF() {
        return this.f36484b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f36483a;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f36485c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f36487f;
        if (bool != null) {
            this.f36486d.h(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f36487f = Boolean.valueOf(this.f36486d.c());
        this.f36486d.h(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.f36483a != -1.0f) {
            f();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f36484b.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.f36484b.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceCompatClipping(boolean z11) {
        this.f36486d.h(this, z11);
    }

    @Override // li.g
    public void setMaskRectF(@NonNull RectF rectF) {
        this.f36484b.set(rectF);
        e();
    }

    @Deprecated
    public void setMaskXPercentage(float f11) {
        float fA = g3.a.a(f11, 0.0f, 1.0f);
        if (this.f36483a != fA) {
            this.f36483a = fA;
            f();
        }
    }

    public void setOnMaskChangedListener(@Nullable k kVar) {
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        n nVarY = nVar.y(new n.c() { // from class: li.i
            @Override // yi.n.c
            public final yi.d a(yi.d dVar) {
                return MaskableFrameLayout.d(dVar);
            }
        });
        this.f36485c = nVarY;
        this.f36486d.g(this, nVarY);
    }
}
