package com.transsion.publish.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ZoomImageView extends AppCompatImageView implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f56688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f56689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f56690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f56691d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Matrix f56692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScaleGestureDetector f56693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GestureDetector f56694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f56696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OverScroller f56697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f56698l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f56699m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f56700n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f56701o;

    /* JADX INFO: compiled from: source.java */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            ZoomImageView.this.scale(scaleGestureDetector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            ZoomImageView.this.scaleEnd(scaleGestureDetector);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: compiled from: source.java */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ZoomImageView.this.f56697k.computeScrollOffset()) {
                    int currX = ZoomImageView.this.f56697k.getCurrX();
                    int i11 = currX - ZoomImageView.this.f56698l;
                    ZoomImageView.this.f56698l = currX;
                    int currY = ZoomImageView.this.f56697k.getCurrY();
                    int i12 = currY - ZoomImageView.this.f56699m;
                    ZoomImageView.this.f56699m = currY;
                    if (i11 == 0 || i12 == 0) {
                        return;
                    }
                    ZoomImageView.this.p(i11, i12);
                }
            }
        }

        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ZoomImageView.this.o(motionEvent.getX(), motionEvent.getY());
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            ZoomImageView.this.f56698l = (int) motionEvent2.getX();
            ZoomImageView.this.f56699m = (int) motionEvent2.getY();
            RectF matrixRectF = ZoomImageView.this.getMatrixRectF();
            if (matrixRectF == null) {
                return false;
            }
            int i11 = ZoomImageView.this.f56698l;
            int i12 = ZoomImageView.this.f56699m;
            int iRound = Math.round(f11);
            int iRound2 = Math.round(f12);
            int iRound3 = Math.round(matrixRectF.width());
            int iRound4 = Math.round(matrixRectF.height());
            if (i11 != iRound3 || i12 != iRound4) {
                ZoomImageView.this.f56697k.fling(i11, i12, iRound, iRound2, 0, iRound3, 0, iRound4, iRound3, iRound4);
            }
            if (ZoomImageView.this.f56700n != null && ZoomImageView.this.f56700n.isStarted()) {
                ZoomImageView.this.f56700n.end();
            }
            ZoomImageView.this.f56700n = ValueAnimator.ofFloat(0.0f, 1.0f);
            ZoomImageView.this.f56700n.setDuration(500L);
            ZoomImageView.this.f56700n.addUpdateListener(new a());
            ZoomImageView.this.f56700n.start();
            return super.onFling(motionEvent, motionEvent2, f11, f12);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            ZoomImageView.this.p(-f11, -f12);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ZoomImageView.this.f56701o == null) {
                return true;
            }
            ZoomImageView.this.f56701o.onClick(ZoomImageView.this);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f56705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f56706b;

        public c(float f11, float f12) {
            this.f56705a = f11;
            this.f56706b = f12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() / ZoomImageView.this.getScale();
            ZoomImageView.this.f56692f.postScale(fFloatValue, fFloatValue, this.f56705a, this.f56706b);
            ZoomImageView zoomImageView = ZoomImageView.this;
            zoomImageView.setImageMatrix(zoomImageView.f56692f);
            ZoomImageView.this.q();
        }
    }

    public ZoomImageView(Context context) {
        this(context, null);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f56688a = true;
        this.f56695i = false;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f56697k = new OverScroller(context);
        this.f56692f = new Matrix();
        this.f56693g = new ScaleGestureDetector(context, new a());
        this.f56694h = new GestureDetector(context, new b());
    }

    private float getDoubleDrowScale() {
        float scale = getScale();
        if (Math.abs(this.f56689b - scale) < 0.05f) {
            scale = this.f56689b;
        }
        if (Math.abs(this.f56691d - scale) < 0.05f) {
            scale = this.f56691d;
        }
        if (Math.abs(this.f56690c - scale) < 0.05f) {
            scale = this.f56690c;
        }
        float f11 = this.f56691d;
        if (scale == f11) {
            return this.f56695i ? this.f56690c : this.f56689b;
        }
        this.f56695i = scale < f11;
        return f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getMatrixRectF() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        getImageMatrix().mapRect(rectF);
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getScale() {
        float[] fArr = new float[9];
        this.f56692f.getValues(fArr);
        return fArr[0];
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i11) {
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF == null || matrixRectF.isEmpty()) {
            return false;
        }
        if (i11 > 0) {
            return matrixRectF.right >= ((float) (getWidth() + 1));
        }
        return matrixRectF.left <= -1.0f;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i11) {
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF == null || matrixRectF.isEmpty()) {
            return false;
        }
        if (i11 > 0) {
            return matrixRectF.bottom >= ((float) (getHeight() + 1));
        }
        return matrixRectF.top <= -1.0f;
    }

    public final void o(float f11, float f12) {
        ValueAnimator valueAnimator = this.f56696j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            r(getDoubleDrowScale(), f11, f12);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f56688a) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float fMin = (intrinsicWidth <= width || intrinsicHeight > height) ? 1.0f : (width * 1.0f) / intrinsicWidth;
            if (intrinsicWidth <= width && intrinsicHeight > height) {
                fMin = (height * 1.0f) / intrinsicHeight;
            }
            if ((intrinsicWidth <= width && intrinsicHeight <= height) || (intrinsicWidth >= width && intrinsicHeight >= height)) {
                fMin = Math.min((width * 1.0f) / intrinsicWidth, (height * 1.0f) / intrinsicHeight);
            }
            this.f56689b = fMin;
            this.f56691d = fMin * 2.0f;
            this.f56690c = fMin * 4.0f;
            float f11 = (width * 1.0f) / 2.0f;
            float f12 = (height * 1.0f) / 2.0f;
            this.f56692f.postTranslate(f11 - (intrinsicWidth / 2), f12 - (intrinsicHeight / 2));
            Matrix matrix = this.f56692f;
            float f13 = this.f56689b;
            matrix.postScale(f13, f13, f11, f12);
            setImageMatrix(this.f56692f);
            this.f56688a = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f56694h.onTouchEvent(motionEvent) | this.f56693g.onTouchEvent(motionEvent);
    }

    public final void p(float f11, float f12) {
        if (getDrawable() == null) {
            return;
        }
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF.width() <= getWidth()) {
            f11 = 0.0f;
        }
        if (matrixRectF.height() <= getHeight()) {
            f12 = 0.0f;
        }
        if (f11 == 0.0f && f12 == 0.0f) {
            return;
        }
        this.f56692f.postTranslate(f11, f12);
        setImageMatrix(this.f56692f);
        q();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002f A[PHI: r1
  0x002f: PHI (r1v4 float) = (r1v1 float), (r1v9 float) binds: [B:14:0x003f, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    public final void q() {
        float f11;
        float f12;
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float fWidth = matrixRectF.width();
        float fHeight = matrixRectF.height();
        float f13 = matrixRectF.left;
        float f14 = matrixRectF.right;
        float f15 = matrixRectF.top;
        float f16 = matrixRectF.bottom;
        float f17 = 0.0f;
        if (f13 > 0.0f) {
            f11 = width;
            if (fWidth > f11) {
                f12 = -f13;
            } else {
                f12 = ((f11 * 1.0f) / 2.0f) - (((fWidth * 1.0f) / 2.0f) + f13);
            }
        } else {
            f11 = width;
            if (f14 >= f11) {
                f12 = 0.0f;
            } else if (fWidth > f11) {
                f12 = f11 - f14;
            } else {
                f12 = ((f11 * 1.0f) / 2.0f) - (((fWidth * 1.0f) / 2.0f) + f13);
            }
        }
        if (f15 > 0.0f) {
            float f18 = height;
            f17 = fHeight > f18 ? -f15 : ((f18 * 1.0f) / 2.0f) - (f15 + ((fHeight * 1.0f) / 2.0f));
        } else {
            float f19 = height;
            if (f16 < f19) {
                f17 = fHeight > f19 ? f19 - f16 : ((f19 * 1.0f) / 2.0f) - (f15 + ((fHeight * 1.0f) / 2.0f));
            }
        }
        this.f56692f.postTranslate(f12, f17);
        setImageMatrix(this.f56692f);
    }

    public final void r(float f11, float f12, float f13) {
        ValueAnimator valueAnimator = this.f56696j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getScale(), f11);
            this.f56696j = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.f56696j.setInterpolator(new AccelerateInterpolator());
            this.f56696j.addUpdateListener(new c(f12, f13));
            this.f56696j.start();
        }
    }

    public void scale(ScaleGestureDetector scaleGestureDetector) {
        if (getDrawable() == null) {
            return;
        }
        getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.f56692f.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        setImageMatrix(this.f56692f);
        q();
    }

    public void scaleEnd(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor() * getScale();
        float f11 = this.f56689b;
        if (scaleFactor < f11) {
            r(f11, getWidth() / 2, getHeight() / 2);
            return;
        }
        float f12 = this.f56690c;
        if (scaleFactor > f12) {
            r(f12, getWidth() / 2, getHeight() / 2);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f56701o = onClickListener;
    }
}
