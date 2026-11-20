package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class Layer extends ConstraintHelper {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConstraintLayout f6738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6739o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6740p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6741q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6742r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f6743s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6744t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6745u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6746v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6747w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View[] f6748x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6749y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6750z;

    public Layer(Context context) {
        super(context);
        this.f6735k = Float.NaN;
        this.f6736l = Float.NaN;
        this.f6737m = Float.NaN;
        this.f6739o = 1.0f;
        this.f6740p = 1.0f;
        this.f6741q = Float.NaN;
        this.f6742r = Float.NaN;
        this.f6743s = Float.NaN;
        this.f6744t = Float.NaN;
        this.f6745u = Float.NaN;
        this.f6746v = Float.NaN;
        this.f6747w = true;
        this.f6748x = null;
        this.f6749y = 0.0f;
        this.f6750z = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6735k = Float.NaN;
        this.f6736l = Float.NaN;
        this.f6737m = Float.NaN;
        this.f6739o = 1.0f;
        this.f6740p = 1.0f;
        this.f6741q = Float.NaN;
        this.f6742r = Float.NaN;
        this.f6743s = Float.NaN;
        this.f6744t = Float.NaN;
        this.f6745u = Float.NaN;
        this.f6746v = Float.NaN;
        this.f6747w = true;
        this.f6748x = null;
        this.f6749y = 0.0f;
        this.f6750z = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f6735k = Float.NaN;
        this.f6736l = Float.NaN;
        this.f6737m = Float.NaN;
        this.f6739o = 1.0f;
        this.f6740p = 1.0f;
        this.f6741q = Float.NaN;
        this.f6742r = Float.NaN;
        this.f6743s = Float.NaN;
        this.f6744t = Float.NaN;
        this.f6745u = Float.NaN;
        this.f6746v = Float.NaN;
        this.f6747w = true;
        this.f6748x = null;
        this.f6749y = 0.0f;
        this.f6750z = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7271f = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.A = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.B = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void l() {
        if (this.f6738n == null) {
            return;
        }
        if (this.f6747w || Float.isNaN(this.f6741q) || Float.isNaN(this.f6742r)) {
            if (!Float.isNaN(this.f6735k) && !Float.isNaN(this.f6736l)) {
                this.f6742r = this.f6736l;
                this.f6741q = this.f6735k;
                return;
            }
            View[] viewArrJ = j(this.f6738n);
            int left = viewArrJ[0].getLeft();
            int top = viewArrJ[0].getTop();
            int right = viewArrJ[0].getRight();
            int bottom = viewArrJ[0].getBottom();
            for (int i11 = 0; i11 < this.f7268b; i11++) {
                View view = viewArrJ[i11];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f6743s = right;
            this.f6744t = bottom;
            this.f6745u = left;
            this.f6746v = top;
            if (Float.isNaN(this.f6735k)) {
                this.f6741q = (left + right) / 2;
            } else {
                this.f6741q = this.f6735k;
            }
            if (Float.isNaN(this.f6736l)) {
                this.f6742r = (top + bottom) / 2;
            } else {
                this.f6742r = this.f6736l;
            }
        }
    }

    public final void m() {
        int i11;
        if (this.f6738n == null || (i11 = this.f7268b) == 0) {
            return;
        }
        View[] viewArr = this.f6748x;
        if (viewArr == null || viewArr.length != i11) {
            this.f6748x = new View[i11];
        }
        for (int i12 = 0; i12 < this.f7268b; i12++) {
            this.f6748x[i12] = this.f6738n.getViewById(this.f7267a[i12]);
        }
    }

    public final void n() {
        if (this.f6738n == null) {
            return;
        }
        if (this.f6748x == null) {
            m();
        }
        l();
        double radians = Float.isNaN(this.f6737m) ? 0.0d : Math.toRadians(this.f6737m);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f11 = this.f6739o;
        float f12 = f11 * fCos;
        float f13 = this.f6740p;
        float f14 = (-f13) * fSin;
        float f15 = f11 * fSin;
        float f16 = f13 * fCos;
        for (int i11 = 0; i11 < this.f7268b; i11++) {
            View view = this.f6748x[i11];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f17 = left - this.f6741q;
            float f18 = top - this.f6742r;
            float f19 = (((f12 * f17) + (f14 * f18)) - f17) + this.f6749y;
            float f21 = (((f17 * f15) + (f16 * f18)) - f18) + this.f6750z;
            view.setTranslationX(f19);
            view.setTranslationY(f21);
            view.setScaleY(this.f6740p);
            view.setScaleX(this.f6739o);
            if (!Float.isNaN(this.f6737m)) {
                view.setRotation(this.f6737m);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6738n = (ConstraintLayout) getParent();
        if (this.A || this.B) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i11 = 0; i11 < this.f7268b; i11++) {
                View viewById = this.f6738n.getViewById(this.f7267a[i11]);
                if (viewById != null) {
                    if (this.A) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.B && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        d();
    }

    @Override // android.view.View
    public void setPivotX(float f11) {
        this.f6735k = f11;
        n();
    }

    @Override // android.view.View
    public void setPivotY(float f11) {
        this.f6736l = f11;
        n();
    }

    @Override // android.view.View
    public void setRotation(float f11) {
        this.f6737m = f11;
        n();
    }

    @Override // android.view.View
    public void setScaleX(float f11) {
        this.f6739o = f11;
        n();
    }

    @Override // android.view.View
    public void setScaleY(float f11) {
        this.f6740p = f11;
        n();
    }

    @Override // android.view.View
    public void setTranslationX(float f11) {
        this.f6749y = f11;
        n();
    }

    @Override // android.view.View
    public void setTranslationY(float f11) {
        this.f6750z = f11;
        n();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        d();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        m();
        this.f6741q = Float.NaN;
        this.f6742r = Float.NaN;
        ConstraintWidget constraintWidgetB = ((ConstraintLayout.b) getLayoutParams()).b();
        constraintWidgetB.o1(0);
        constraintWidgetB.P0(0);
        l();
        layout(((int) this.f6745u) - getPaddingLeft(), ((int) this.f6746v) - getPaddingTop(), ((int) this.f6743s) + getPaddingRight(), ((int) this.f6744t) + getPaddingBottom());
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f6738n = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f6737m = rotation;
        } else {
            if (Float.isNaN(this.f6737m)) {
                return;
            }
            this.f6737m = rotation;
        }
    }
}
