package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class h extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f37056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f37057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f37058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f37059d;

    public h(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        this.f37056a = drawable.getConstantState().newDrawable().mutate();
        Drawable drawableMutate = drawable2.getConstantState().newDrawable().mutate();
        this.f37057b = drawableMutate;
        drawableMutate.setAlpha(0);
        this.f37058c = new float[2];
    }

    public void a(float f11) {
        if (this.f37059d != f11) {
            this.f37059d = f11;
            j.a(f11, this.f37058c);
            this.f37056a.setAlpha((int) (this.f37058c[0] * 255.0f));
            this.f37057b.setAlpha((int) (this.f37058c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f37056a.draw(canvas);
        this.f37057b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f37056a.getIntrinsicHeight(), this.f37057b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f37056a.getIntrinsicWidth(), this.f37057b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f37056a.getMinimumHeight(), this.f37057b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f37056a.getMinimumWidth(), this.f37057b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f37056a.isStateful() || this.f37057b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (this.f37059d <= 0.5f) {
            this.f37056a.setAlpha(i11);
            this.f37057b.setAlpha(0);
        } else {
            this.f37056a.setAlpha(0);
            this.f37057b.setAlpha(i11);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        this.f37056a.setBounds(i11, i12, i13, i14);
        this.f37057b.setBounds(i11, i12, i13, i14);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f37056a.setColorFilter(colorFilter);
        this.f37057b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f37056a.setState(iArr) || this.f37057b.setState(iArr);
    }
}
