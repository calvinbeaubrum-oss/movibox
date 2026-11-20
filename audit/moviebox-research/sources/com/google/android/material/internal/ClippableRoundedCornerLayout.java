package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Path f36927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f36928b;

    public ClippableRoundedCornerLayout(@NonNull Context context) {
        super(context);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f36927a == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.f36927a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public float getCornerRadius() {
        return this.f36928b;
    }

    public void resetClipBoundsAndCornerRadius() {
        this.f36927a = null;
        this.f36928b = 0.0f;
        invalidate();
    }

    public void updateClipBoundsAndCornerRadius(float f11, float f12, float f13, float f14, float f15) {
        updateClipBoundsAndCornerRadius(new RectF(f11, f12, f13, f14), f15);
    }

    public void updateClipBoundsAndCornerRadius(@NonNull Rect rect, float f11) {
        updateClipBoundsAndCornerRadius(rect.left, rect.top, rect.right, rect.bottom, f11);
    }

    public void updateClipBoundsAndCornerRadius(@NonNull RectF rectF, float f11) {
        if (this.f36927a == null) {
            this.f36927a = new Path();
        }
        this.f36928b = f11;
        this.f36927a.reset();
        this.f36927a.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        this.f36927a.close();
        invalidate();
    }

    public void updateCornerRadius(float f11) {
        updateClipBoundsAndCornerRadius(getLeft(), getTop(), getRight(), getBottom(), f11);
    }
}
