package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public Drawable f36933q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f36934r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f36935s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f36936t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f36937u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f36938v;

    public ForegroundLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36934r = new Rect();
        this.f36935s = new Rect();
        this.f36936t = 119;
        this.f36937u = true;
        this.f36938v = false;
        TypedArray typedArrayI = b0.i(context, attributeSet, R$styleable.ForegroundLinearLayout, i11, 0, new int[0]);
        this.f36936t = typedArrayI.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.f36936t);
        Drawable drawable = typedArrayI.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f36937u = typedArrayI.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayI.recycle();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f36933q;
        if (drawable != null) {
            if (this.f36938v) {
                this.f36938v = false;
                Rect rect = this.f36934r;
                Rect rect2 = this.f36935s;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f36937u) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f36936t, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f11, float f12) {
        super.drawableHotspotChanged(f11, f12);
        Drawable drawable = this.f36933q;
        if (drawable != null) {
            drawable.setHotspot(f11, f12);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f36933q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f36933q.setState(getDrawableState());
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f36933q;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f36936t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f36933q;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f36938v = z11 | this.f36938v;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f36938v = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f36933q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f36933q);
            }
            this.f36933q = drawable;
            this.f36938v = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f36936t == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i11) {
        if (this.f36936t != i11) {
            if ((8388615 & i11) == 0) {
                i11 |= GravityCompat.START;
            }
            if ((i11 & 112) == 0) {
                i11 |= 48;
            }
            this.f36936t = i11;
            if (i11 == 119 && this.f36933q != null) {
                this.f36933q.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f36933q;
    }
}
