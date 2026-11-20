package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SeekBar f1722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f1724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f1725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1727i;

    public n(SeekBar seekBar) {
        super(seekBar);
        this.f1724f = null;
        this.f1725g = null;
        this.f1726h = false;
        this.f1727i = false;
        this.f1722d = seekBar;
    }

    @Override // androidx.appcompat.widget.l
    public void c(AttributeSet attributeSet, int i11) {
        super.c(attributeSet, i11);
        n0 n0VarV = n0.v(this.f1722d.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i11, 0);
        SeekBar seekBar = this.f1722d;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), R$styleable.AppCompatSeekBar, attributeSet, n0VarV.r(), i11, 0);
        Drawable drawableH = n0VarV.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.f1722d.setThumb(drawableH);
        }
        j(n0VarV.g(R$styleable.AppCompatSeekBar_tickMark));
        if (n0VarV.s(R$styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1725g = b0.e(n0VarV.k(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1725g);
            this.f1727i = true;
        }
        if (n0VarV.s(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1724f = n0VarV.c(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.f1726h = true;
        }
        n0VarV.x();
        f();
    }

    public final void f() {
        Drawable drawable = this.f1723e;
        if (drawable != null) {
            if (this.f1726h || this.f1727i) {
                Drawable drawableR = d3.a.r(drawable.mutate());
                this.f1723e = drawableR;
                if (this.f1726h) {
                    d3.a.o(drawableR, this.f1724f);
                }
                if (this.f1727i) {
                    d3.a.p(this.f1723e, this.f1725g);
                }
                if (this.f1723e.isStateful()) {
                    this.f1723e.setState(this.f1722d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f1723e != null) {
            int max = this.f1722d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1723e.getIntrinsicWidth();
                int intrinsicHeight = this.f1723e.getIntrinsicHeight();
                int i11 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i12 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1723e.setBounds(-i11, -i12, i11, i12);
                float width = ((this.f1722d.getWidth() - this.f1722d.getPaddingLeft()) - this.f1722d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1722d.getPaddingLeft(), this.f1722d.getHeight() / 2);
                for (int i13 = 0; i13 <= max; i13++) {
                    this.f1723e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f1723e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1722d.getDrawableState())) {
            this.f1722d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f1723e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f1723e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1723e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1722d);
            d3.a.m(drawable, this.f1722d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f1722d.getDrawableState());
            }
            f();
        }
        this.f1722d.invalidate();
    }
}
