package com.transsion.baseui.widget.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.baseui.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f51562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ls.a f51563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51564c;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.f51562a = new Paint();
        this.f51563b = new ls.a();
        this.f51564c = true;
        a(context, null);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f51562a = new Paint();
        this.f51563b = new ls.a();
        this.f51564c = true;
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f51562a = new Paint();
        this.f51563b = new ls.a();
        this.f51564c = true;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f51562a = new Paint();
        this.f51563b = new ls.a();
        this.f51564c = true;
        a(context, attributeSet);
    }

    public final void a(Context context, @Nullable AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        setLayerType(1, null);
        setWillNotDraw(false);
        this.f51563b.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new a.C0559a().a());
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
        try {
            setShimmer(((typedArrayObtainStyledAttributes.hasValue(R$styleable.ShimmerFrameLayout_shimmer_colored) && typedArrayObtainStyledAttributes.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_colored, false)) ? new a.c() : new a.C0559a()).c(typedArrayObtainStyledAttributes).a());
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f51564c) {
            this.f51563b.draw(canvas);
        }
    }

    public void hideShimmer() {
        stopShimmer();
        this.f51564c = false;
        invalidate();
    }

    public boolean isShimmerStarted() {
        return this.f51563b.a();
    }

    public boolean isShimmerVisible() {
        return this.f51564c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f51564c && getVisibility() == 0) {
            this.f51563b.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f51563b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            stopShimmer();
        } else if (this.f51564c && isAttachedToWindow()) {
            this.f51563b.b();
        }
    }

    public ShimmerFrameLayout setShimmer(@Nullable a aVar) {
        this.f51563b.d(aVar);
        if (aVar == null || !aVar.f51582o) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.f51562a);
        }
        return this;
    }

    public void setShimmerListener(Animator.AnimatorListener animatorListener) {
        this.f51563b.e(animatorListener);
    }

    public void showShimmer(boolean z11) {
        this.f51564c = true;
        if (z11) {
            startShimmer();
        }
        invalidate();
    }

    public void startShimmer() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.f51563b.f();
    }

    public void startShimmer(int i11, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.f51563b.g(i11, animatorListenerAdapter);
    }

    public void stopShimmer() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.f51563b.h();
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f51563b;
    }
}
