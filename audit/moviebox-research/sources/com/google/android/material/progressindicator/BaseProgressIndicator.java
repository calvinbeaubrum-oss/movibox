package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.progressindicator.b;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {
    public static final int HIDE_ESCAPE = 3;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f37234p = R$style.Widget_MaterialComponents_ProgressIndicator;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f37235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f37237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f37238d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f37239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f37240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f37241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.google.android.material.progressindicator.a f37242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f37243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f37245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f37246m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l6.b f37247n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final l6.b f37248o;

    /* JADX INFO: compiled from: source.java */
    public class a extends l6.b {
        public a() {
        }

        @Override // l6.b
        public void b(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.f37236b, BaseProgressIndicator.this.f37237c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends l6.b {
        public b() {
        }

        @Override // l6.b
        public void b(Drawable drawable) {
            super.b(drawable);
            if (BaseProgressIndicator.this.f37243j) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.f37244k);
        }
    }

    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(zi.a.c(context, attributeSet, i11, f37234p), attributeSet, i11);
        this.f37241h = -1L;
        this.f37243j = false;
        this.f37244k = 4;
        this.f37245l = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.k();
            }
        };
        this.f37246m = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.j();
                BaseProgressIndicator.this.f37241h = -1L;
            }
        };
        this.f37247n = new a();
        this.f37248o = new b();
        Context context2 = getContext();
        this.f37235a = (S) i(context2, attributeSet);
        TypedArray typedArrayI = b0.i(context2, attributeSet, R$styleable.BaseProgressIndicator, i11, i12, new int[0]);
        this.f37239f = typedArrayI.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f37240g = Math.min(typedArrayI.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayI.recycle();
        this.f37242i = new com.google.android.material.progressindicator.a();
        this.f37238d = true;
    }

    @Nullable
    private h<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().w();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().x();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f37235a.f37256f;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public j<S> getIndeterminateDrawable() {
        return (j) super.getIndeterminateDrawable();
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f37235a.f37253c;
    }

    public int getIndicatorTrackGapSize() {
        return this.f37235a.f37257g;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public f<S> getProgressDrawable() {
        return (f) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.f37235a.f37255e;
    }

    public int getTrackColor() {
        return this.f37235a.f37254d;
    }

    public int getTrackCornerRadius() {
        return this.f37235a.f37252b;
    }

    public int getTrackThickness() {
        return this.f37235a.f37251a;
    }

    public void h(boolean z11) {
        if (this.f37238d) {
            ((g) getCurrentDrawable()).q(p(), false, z11);
        }
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f37245l);
            return;
        }
        removeCallbacks(this.f37246m);
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f37241h;
        int i11 = this.f37240g;
        if (jUptimeMillis >= i11) {
            this.f37246m.run();
        } else {
            postDelayed(this.f37246m, ((long) i11) - jUptimeMillis);
        }
    }

    public abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public final void j() {
        ((g) getCurrentDrawable()).q(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    public final void k() {
        if (this.f37240g > 0) {
            this.f37241h = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    public boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public final boolean m() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    public final void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().v().d(this.f37247n);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.f37248o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.f37248o);
        }
    }

    public final void o() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.f37248o);
            getIndeterminateDrawable().v().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.f37248o);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (p()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f37246m);
        removeCallbacks(this.f37245l);
        ((g) getCurrentDrawable()).i();
        o();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i11, int i12) {
        try {
            h<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i11) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i12) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        h(i11 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        h(false);
    }

    public boolean p() {
        return ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(@NonNull com.google.android.material.progressindicator.a aVar) {
        this.f37242i = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f37290c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f37290c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i11) {
        this.f37235a.f37256f = i11;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z11) {
        try {
            if (z11 == isIndeterminate()) {
                return;
            }
            g gVar = (g) getCurrentDrawable();
            if (gVar != null) {
                gVar.i();
            }
            super.setIndeterminate(z11);
            g gVar2 = (g) getCurrentDrawable();
            if (gVar2 != null) {
                gVar2.q(p(), false, false);
            }
            if ((gVar2 instanceof j) && p()) {
                ((j) gVar2).v().g();
            }
            this.f37243j = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof j)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((g) drawable).i();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{com.google.android.material.color.b.b(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f37235a.f37253c = iArr;
        getIndeterminateDrawable().v().c();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i11) {
        S s11 = this.f37235a;
        if (s11.f37257g != i11) {
            s11.f37257g = i11;
            s11.e();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i11) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i11, false);
    }

    public void setProgressCompat(int i11, boolean z11) {
        if (!isIndeterminate()) {
            super.setProgress(i11);
            if (getProgressDrawable() == null || z11) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f37236b = i11;
            this.f37237c = z11;
            this.f37243j = true;
            if (!getIndeterminateDrawable().isVisible() || this.f37242i.a(getContext().getContentResolver()) == 0.0f) {
                this.f37247n.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().v().f();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof f)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            f fVar = (f) drawable;
            fVar.i();
            super.setProgressDrawable(fVar);
            fVar.B(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i11) {
        this.f37235a.f37255e = i11;
        invalidate();
    }

    public void setTrackColor(int i11) {
        S s11 = this.f37235a;
        if (s11.f37254d != i11) {
            s11.f37254d = i11;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i11) {
        S s11 = this.f37235a;
        if (s11.f37252b != i11) {
            s11.f37252b = Math.min(i11, s11.f37251a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(int i11) {
        S s11 = this.f37235a;
        if (s11.f37251a != i11) {
            s11.f37251a = i11;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i11) {
        if (i11 != 0 && i11 != 4 && i11 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f37244k = i11;
    }

    public void show() {
        if (this.f37239f <= 0) {
            this.f37245l.run();
        } else {
            removeCallbacks(this.f37245l);
            postDelayed(this.f37245l, this.f37239f);
        }
    }
}
