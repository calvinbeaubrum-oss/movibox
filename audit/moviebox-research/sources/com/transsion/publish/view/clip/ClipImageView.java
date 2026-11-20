package com.transsion.publish.view.clip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ClipImageView extends BaseClipImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static float SCALE_MAX = 4.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static float f56712r = 2.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f56713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f56714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f56715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScaleGestureDetector f56716d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f56717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GestureDetector f56718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f56721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f56722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f56723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f56724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f56725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f56726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f56727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f56728q;

    /* JADX INFO: compiled from: source.java */
    public class AutoScaleRunnable implements Runnable {
        static final float BIGGER = 1.07f;
        static final float SMALLER = 0.93f;
        private float mTargetScale;
        private float tmpScale;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private float f56729x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private float f56730y;

        public AutoScaleRunnable(float f11, float f12, float f13) {
            this.mTargetScale = f11;
            this.f56729x = f12;
            this.f56730y = f13;
            if (ClipImageView.this.getScale() < this.mTargetScale) {
                this.tmpScale = BIGGER;
            } else {
                this.tmpScale = SMALLER;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = ClipImageView.this.f56717f;
            float f11 = this.tmpScale;
            matrix.postScale(f11, f11, this.f56729x, this.f56730y);
            ClipImageView.this.g();
            ClipImageView clipImageView = ClipImageView.this;
            clipImageView.setImageMatrix(clipImageView.f56717f);
            float scale = ClipImageView.this.getScale();
            float f12 = this.tmpScale;
            if ((f12 > 1.0f && scale < this.mTargetScale) || (f12 < 1.0f && this.mTargetScale < scale)) {
                ClipImageView.this.postDelayed(this, 16L);
                return;
            }
            float f13 = this.mTargetScale / scale;
            ClipImageView.this.f56717f.postScale(f13, f13, this.f56729x, this.f56730y);
            ClipImageView.this.g();
            ClipImageView clipImageView2 = ClipImageView.this;
            clipImageView2.setImageMatrix(clipImageView2.f56717f);
            ClipImageView.this.f56719h = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ClipImageView.this.f56719h) {
                return true;
            }
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (ClipImageView.this.getScale() < ClipImageView.f56712r) {
                ClipImageView clipImageView = ClipImageView.this;
                clipImageView.postDelayed(clipImageView.new AutoScaleRunnable(ClipImageView.f56712r, x11, y11), 16L);
                ClipImageView.this.f56719h = true;
            } else {
                ClipImageView clipImageView2 = ClipImageView.this;
                clipImageView2.postDelayed(clipImageView2.new AutoScaleRunnable(clipImageView2.f56713a, x11, y11), 16L);
                ClipImageView.this.f56719h = true;
            }
            return true;
        }
    }

    public ClipImageView(Context context) {
        this(context, null);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56713a = 1.0f;
        this.f56714b = true;
        this.f56715c = new float[9];
        this.f56716d = null;
        this.f56717f = new Matrix();
        this.f56725n = 16;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f56718g = new GestureDetector(context, new a());
        this.f56716d = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.f56717f;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public Bitmap clip() {
        return clip(null);
    }

    public Bitmap clip(Rect rect) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(bitmapCreateBitmap));
        if (rect == null) {
            return Bitmap.createBitmap(bitmapCreateBitmap, this.f56725n, this.f56728q, getWidth() - (this.f56725n * 2), getWidth() - (this.f56725n * 2));
        }
        return (rect.width() <= 0 || rect.height() <= 0) ? bitmapCreateBitmap : Bitmap.createBitmap(bitmapCreateBitmap, rect.left, rect.top, rect.width(), rect.height());
    }

    public final void g() {
        float f11;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        double dWidth = ((double) matrixRectF.width()) + 0.01d;
        int i11 = this.f56725n;
        float f12 = 0.0f;
        if (dWidth >= width - (i11 * 2)) {
            float f13 = matrixRectF.left;
            f11 = f13 > ((float) i11) ? (-f13) + i11 : 0.0f;
            float f14 = matrixRectF.right;
            if (f14 < width - i11) {
                f11 = (width - i11) - f14;
            }
        } else {
            f11 = 0.0f;
        }
        double dHeight = ((double) matrixRectF.height()) + 0.01d;
        int i12 = this.f56728q;
        if (dHeight >= height - (i12 * 2)) {
            float f15 = matrixRectF.top;
            f12 = f15 > ((float) i12) ? (-f15) + i12 : 0.0f;
            float f16 = matrixRectF.bottom;
            if (f16 < height - i12) {
                f12 = (height - i12) - f16;
            }
        }
        this.f56717f.postTranslate(f11, f12);
    }

    public final float getScale() {
        this.f56717f.getValues(this.f56715c);
        return this.f56715c[0];
    }

    public final boolean h(float f11, float f12) {
        return Math.sqrt((double) ((f11 * f11) + (f12 * f12))) >= ((double) this.f56720i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        if (!this.f56714b || (drawable = getDrawable()) == null) {
            return;
        }
        if (this.f56726o == 0) {
            this.f56728q = (getHeight() - (getWidth() - (this.f56725n * 2))) / 2;
        } else {
            this.f56725n = (getWidth() - this.f56726o) / 2;
            this.f56728q = (getHeight() - this.f56727p) / 2;
        }
        float width = getWidth();
        float height = getHeight();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fMax = Math.max((getWidth() - (this.f56725n * 2)) / intrinsicWidth, (getHeight() - (this.f56728q * 2)) / intrinsicHeight);
        this.f56713a = fMax;
        f56712r = fMax * 2.0f;
        SCALE_MAX = 4.0f * fMax;
        this.f56717f.postTranslate((width - intrinsicWidth) / 2.0f, (height - intrinsicHeight) / 2.0f);
        this.f56717f.postScale(fMax, fMax, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.f56717f);
        this.f56714b = false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        float f11 = SCALE_MAX;
        if ((scale < f11 && scaleFactor > 1.0f) || (scale > this.f56713a && scaleFactor < 1.0f)) {
            float f12 = scaleFactor * scale;
            float f13 = this.f56713a;
            if (f12 < f13) {
                scaleFactor = f13 / scale;
            }
            if (scaleFactor * scale > f11) {
                scaleFactor = f11 / scale;
            }
            this.f56717f.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            g();
            setImageMatrix(this.f56717f);
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009c  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f56718g.onTouchEvent(motionEvent)) {
            return true;
        }
        this.f56716d.onTouchEvent(motionEvent);
        int pointerCount = motionEvent.getPointerCount();
        float x11 = 0.0f;
        float y11 = 0.0f;
        for (int i11 = 0; i11 < pointerCount; i11++) {
            x11 += motionEvent.getX(i11);
            y11 += motionEvent.getY(i11);
        }
        float f11 = pointerCount;
        float f12 = x11 / f11;
        float f13 = y11 / f11;
        if (pointerCount != this.f56724m) {
            this.f56723l = false;
            this.f56721j = f12;
            this.f56722k = f13;
        }
        this.f56724m = pointerCount;
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f56724m = 0;
        } else if (action == 2) {
            float f14 = f12 - this.f56721j;
            float f15 = f13 - this.f56722k;
            if (!this.f56723l) {
                this.f56723l = h(f14, f15);
            }
            if (this.f56723l && getDrawable() != null) {
                RectF matrixRectF = getMatrixRectF();
                if (matrixRectF.width() <= getWidth() - (this.f56725n * 2)) {
                    f14 = 0.0f;
                }
                this.f56717f.postTranslate(f14, matrixRectF.height() > ((float) (getHeight() - (this.f56728q * 2))) ? f15 : 0.0f);
                g();
                setImageMatrix(this.f56717f);
            }
            this.f56721j = f12;
            this.f56722k = f13;
        } else if (action == 3) {
            this.f56724m = 0;
        }
        return true;
    }

    public void setCropWH(int i11, int i12) {
        this.f56726o = i11;
        this.f56727p = i12;
    }
}
