package com.cloud.tmc.miniapp.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import p013OoooO0.o00Oo0;
import q0.c;
import q0.d;
import q0.e;
import q0.f;
import q0.g;
import q0.h;
import q0.i;
import q0.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PhotoView extends AppCompatImageView {
    public o00Oo0 OooO00o;
    public ImageView.ScaleType OooO0O0;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        OooO00o();
    }

    public final void OooO00o() {
        this.OooO00o = new o00Oo0(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.OooO0O0;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.OooO0O0 = null;
        }
    }

    public o00Oo0 getAttacher() {
        return this.OooO00o;
    }

    public RectF getDisplayRect() {
        return this.OooO00o.h();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.OooO00o.f247n;
    }

    public float getMaximumScale() {
        return this.OooO00o.f239f;
    }

    public float getMediumScale() {
        return this.OooO00o.f238d;
    }

    public float getMinimumScale() {
        return this.OooO00o.f237c;
    }

    public float getScale() {
        return this.OooO00o.k();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.OooO00o.f258y;
    }

    public void setAllowParentInterceptOnEdge(boolean z11) {
        this.OooO00o.f240g = z11;
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i11, int i12, int i13, int i14) {
        boolean frame = super.setFrame(i11, i12, i13, i14);
        if (frame) {
            this.OooO00o.l();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        o00Oo0 o00oo0 = this.OooO00o;
        if (o00oo0 != null) {
            o00oo0.l();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i11) {
        super.setImageResource(i11);
        o00Oo0 o00oo0 = this.OooO00o;
        if (o00oo0 != null) {
            o00oo0.l();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        o00Oo0 o00oo0 = this.OooO00o;
        if (o00oo0 != null) {
            o00oo0.l();
        }
    }

    public void setMaximumScale(float f11) {
        o00Oo0 o00oo0 = this.OooO00o;
        i.a(o00oo0.f237c, o00oo0.f238d, f11);
        o00oo0.f239f = f11;
    }

    public void setMediumScale(float f11) {
        o00Oo0 o00oo0 = this.OooO00o;
        i.a(o00oo0.f237c, f11, o00oo0.f239f);
        o00oo0.f238d = f11;
    }

    public void setMinimumScale(float f11) {
        o00Oo0 o00oo0 = this.OooO00o;
        i.a(f11, o00oo0.f238d, o00oo0.f239f);
        o00oo0.f237c = f11;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.OooO00o.f252s = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.OooO00o.f244k.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.OooO00o.f253t = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.OooO00o.getClass();
    }

    public void setOnOutsidePhotoTapListener(d dVar) {
        this.OooO00o.getClass();
    }

    public void setOnPhotoTapListener(e eVar) {
        this.OooO00o.getClass();
    }

    public void setOnScaleChangeListener(f fVar) {
        this.OooO00o.getClass();
    }

    public void setOnSingleFlingListener(g gVar) {
        this.OooO00o.getClass();
    }

    public void setOnViewDragListener(j jVar) {
        this.OooO00o.getClass();
    }

    public void setOnViewTapListener(h hVar) {
        this.OooO00o.f251r = hVar;
    }

    public void setRotationBy(float f11) {
        o00Oo0 o00oo0 = this.OooO00o;
        o00oo0.f248o.postRotate(f11 % 360.0f);
        o00oo0.c();
    }

    public void setRotationTo(float f11) {
        o00Oo0 o00oo0 = this.OooO00o;
        o00oo0.f248o.setRotate(f11 % 360.0f);
        o00oo0.c();
    }

    public void setScale(float f11) {
        o00Oo0 o00oo0 = this.OooO00o;
        o00oo0.d(f11, o00oo0.f243j.getRight() / 2, o00oo0.f243j.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        o00Oo0 o00oo0 = this.OooO00o;
        if (o00oo0 == null) {
            this.OooO0O0 = scaleType;
            return;
        }
        if (scaleType == null) {
            return;
        }
        if (i.a.f74118a[scaleType.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        if (scaleType != o00oo0.f258y) {
            o00oo0.f258y = scaleType;
            o00oo0.l();
        }
    }

    public void setZoomTransitionDuration(int i11) {
        this.OooO00o.f236b = i11;
    }

    public void setZoomable(boolean z11) {
        o00Oo0 o00oo0 = this.OooO00o;
        o00oo0.f257x = z11;
        o00oo0.l();
    }
}
