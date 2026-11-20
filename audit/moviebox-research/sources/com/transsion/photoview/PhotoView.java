package com.transsion.photoview;

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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PhotoViewAttachment f54102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView.ScaleType f54103b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }

    private void a() {
        this.f54102a = new PhotoViewAttachment(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f54103b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f54103b = null;
        }
    }

    public PhotoViewAttachment getAttachment() {
        return this.f54102a;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.f54102a.C(matrix);
    }

    public RectF getDisplayRect() {
        return this.f54102a.D();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f54102a.G();
    }

    public float getMaximumScale() {
        return this.f54102a.J();
    }

    public float getMediumScale() {
        return this.f54102a.K();
    }

    public float getMinimumScale() {
        return this.f54102a.L();
    }

    public float getScale() {
        return this.f54102a.M();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f54102a.N();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.f54102a.O(matrix);
    }

    public boolean isZoomable() {
        return this.f54102a.R();
    }

    public void setAllowParentInterceptOnEdge(boolean z11) {
        this.f54102a.T(z11);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f54102a.U(matrix);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i11, int i12, int i13, int i14) {
        boolean frame = super.setFrame(i11, i12, i13, i14);
        if (frame) {
            this.f54102a.t0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttachment photoViewAttachment = this.f54102a;
        if (photoViewAttachment != null) {
            photoViewAttachment.t0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i11) {
        super.setImageResource(i11);
        PhotoViewAttachment photoViewAttachment = this.f54102a;
        if (photoViewAttachment != null) {
            photoViewAttachment.t0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttachment photoViewAttachment = this.f54102a;
        if (photoViewAttachment != null) {
            photoViewAttachment.t0();
        }
    }

    public void setMaximumScale(float f11) {
        this.f54102a.W(f11);
    }

    public void setMediumScale(float f11) {
        this.f54102a.X(f11);
    }

    public void setMinimumScale(float f11) {
        this.f54102a.Y(f11);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f54102a.Z(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f54102a.a0(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f54102a.b0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f54102a.c0(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f54102a.d0(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f54102a.e0(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f54102a.f0(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f54102a.g0(hVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.f54102a.h0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.f54102a.i0(kVar);
    }

    public void setRotationBy(float f11) {
        this.f54102a.j0(f11);
    }

    public void setRotationTo(float f11) {
        this.f54102a.k0(f11);
    }

    public void setScale(float f11) {
        this.f54102a.l0(f11);
    }

    public void setScale(float f11, float f12, float f13, boolean z11) {
        this.f54102a.m0(f11, f12, f13, z11);
    }

    public void setScale(float f11, boolean z11) {
        this.f54102a.n0(f11, z11);
    }

    public void setScaleLevels(float f11, float f12, float f13) {
        this.f54102a.o0(f11, f12, f13);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttachment photoViewAttachment = this.f54102a;
        if (photoViewAttachment == null) {
            this.f54103b = scaleType;
        } else {
            photoViewAttachment.p0(scaleType);
        }
    }

    public void setSlideUpAndDownListener(i iVar) {
        this.f54102a.q0(iVar);
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.f54102a.U(matrix);
    }

    public void setZoomTransitionDuration(int i11) {
        this.f54102a.r0(i11);
    }

    public void setZoomable(boolean z11) {
        this.f54102a.s0(z11);
    }
}
