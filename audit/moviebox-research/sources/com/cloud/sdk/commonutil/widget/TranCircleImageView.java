package com.cloud.sdk.commonutil.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.sdk.commonutil.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TranCircleImageView extends ImageView {
    public static final int BOTTOM = 2;
    public static final int CENTER = 1;
    public static final int FITXY = 3;
    public static final int TOP = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f30314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f30315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f30316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f30317d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f30318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f30319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f30320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f30321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f30322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f30323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f30324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f30325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f30326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f30327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f30328p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f30329q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f30330r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f30331s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f30332t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f30333u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f30334v;

    public TranCircleImageView(Context context) {
        super(context);
        initData();
    }

    public TranCircleImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30314a = context;
        e(attributeSet);
    }

    public final void a(Canvas canvas, RectF rectF, Paint paint, float f11) {
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{g(this.f30322j, f11), g(this.f30323k, f11), g(this.f30324l, f11), g(this.f30325m, f11), g(this.f30328p, f11), g(this.f30329q, f11), g(this.f30326n, f11), g(this.f30327o, f11)}, Path.Direction.CW);
        path.close();
        canvas.drawPath(path, paint);
    }

    public final boolean b(Drawable drawable) {
        return drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0;
    }

    public final Bitmap c(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            Log.e("TranCircleImageView", Log.getStackTraceString(th2));
            return null;
        }
    }

    public final Rect d(@NonNull Bitmap bitmap, int i11, int i12) {
        int i13;
        int i14;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i15 = width * i12;
        int i16 = i11 * height;
        int[] iArr = {width, height};
        int i17 = 0;
        if (i15 == i16) {
            return new Rect(0, 0, width, height);
        }
        if (i15 > i16) {
            iArr[0] = i16 / i12;
        } else if (i15 < i16) {
            iArr[1] = i15 / i11;
        }
        Boolean boolValueOf = Boolean.valueOf(width > iArr[0]);
        int i18 = this.f30334v;
        if (i18 != 0) {
            if (i18 == 1) {
                i14 = boolValueOf.booleanValue() ? (width - iArr[0]) / 2 : 0;
                i13 = boolValueOf.booleanValue() ? 0 : (height - iArr[1]) / 2;
                width = boolValueOf.booleanValue() ? (width + iArr[0]) / 2 : iArr[0];
                height = boolValueOf.booleanValue() ? iArr[1] : (height + iArr[1]) / 2;
            } else if (i18 == 2) {
                i14 = boolValueOf.booleanValue() ? (width - iArr[0]) / 2 : 0;
                i13 = boolValueOf.booleanValue() ? 0 : height - iArr[1];
                width = boolValueOf.booleanValue() ? (width + iArr[0]) / 2 : iArr[0];
                if (boolValueOf.booleanValue()) {
                    height = iArr[1];
                }
            } else if (i18 != 3) {
                height = 0;
                width = 0;
            }
            i17 = i14;
            return new Rect(i17, i13, width, height);
        }
        int i19 = boolValueOf.booleanValue() ? (width - iArr[0]) / 2 : 0;
        width = boolValueOf.booleanValue() ? (width + iArr[0]) / 2 : iArr[0];
        i17 = i19;
        height = iArr[1];
        i13 = 0;
        return new Rect(i17, i13, width, height);
    }

    public final void e(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.f30314a.obtainStyledAttributes(attributeSet, R$styleable.TranCircleImageView);
        this.f30317d = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_radiusYL, 0.0f);
        this.f30318f = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadiusYL, 0.0f);
        this.f30319g = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadiusYL, 0.0f);
        this.f30320h = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadiusYL, 0.0f);
        this.f30321i = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadiusYL, 0.0f);
        this.f30334v = typedArrayObtainStyledAttributes.getInt(R$styleable.TranCircleImageView_scaleTypeYL, 0);
        this.f30330r = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_borderWidthYL, 0.0f);
        this.f30331s = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_borderSpaceYL, 0.0f);
        this.f30332t = typedArrayObtainStyledAttributes.getColor(R$styleable.TranCircleImageView_borderColorYL, -1);
        this.f30322j = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadius_xYL, 0.0f);
        this.f30323k = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadius_yYL, 0.0f);
        this.f30324l = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadius_xYL, 0.0f);
        this.f30325m = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadius_yYL, 0.0f);
        this.f30326n = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadius_xYL, 0.0f);
        this.f30327o = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadius_yYL, 0.0f);
        this.f30328p = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadius_xYL, 0.0f);
        this.f30329q = typedArrayObtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadius_yYL, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        initData();
    }

    public final void f() {
        float f11 = this.f30317d;
        if (f11 != 0.0f) {
            float f12 = this.f30318f;
            if (f12 == 0.0f) {
                f12 = f11;
            }
            this.f30318f = f12;
            float f13 = this.f30319g;
            if (f13 == 0.0f) {
                f13 = f11;
            }
            this.f30319g = f13;
            float f14 = this.f30320h;
            if (f14 == 0.0f) {
                f14 = f11;
            }
            this.f30320h = f14;
            float f15 = this.f30321i;
            if (f15 != 0.0f) {
                f11 = f15;
            }
            this.f30321i = f11;
        }
        float f16 = this.f30322j;
        if (f16 == 0.0f) {
            f16 = this.f30318f;
        }
        this.f30322j = f16;
        float f17 = this.f30323k;
        if (f17 == 0.0f) {
            f17 = this.f30318f;
        }
        this.f30323k = f17;
        float f18 = this.f30324l;
        if (f18 == 0.0f) {
            f18 = this.f30319g;
        }
        this.f30324l = f18;
        float f19 = this.f30325m;
        if (f19 == 0.0f) {
            f19 = this.f30319g;
        }
        this.f30325m = f19;
        float f21 = this.f30326n;
        if (f21 == 0.0f) {
            f21 = this.f30320h;
        }
        this.f30326n = f21;
        float f22 = this.f30327o;
        if (f22 == 0.0f) {
            f22 = this.f30320h;
        }
        this.f30327o = f22;
        float f23 = this.f30328p;
        if (f23 == 0.0f) {
            f23 = this.f30321i;
        }
        this.f30328p = f23;
        float f24 = this.f30329q;
        if (f24 == 0.0f) {
            f24 = this.f30321i;
        }
        this.f30329q = f24;
    }

    public final float g(float f11, float f12) {
        return Math.max(f11 - f12, 0.0f);
    }

    public Paint getBorderPaint() {
        return this.f30316c;
    }

    public Paint getPaint() {
        return this.f30315b;
    }

    public void initData() {
        f();
        this.f30333u = (this.f30330r == 0.0f && this.f30331s == 0.0f && this.f30322j == 0.0f && this.f30323k == 0.0f && this.f30324l == 0.0f && this.f30325m == 0.0f && this.f30326n == 0.0f && this.f30327o == 0.0f && this.f30328p == 0.0f && this.f30329q == 0.0f) ? false : true;
        this.f30315b = new Paint(1);
        Paint paint = new Paint(1);
        this.f30316c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f30316c.setStrokeWidth(this.f30330r);
        this.f30316c.setColor(this.f30332t);
        if (this.f30333u) {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            if (this.f30330r != 0.0f) {
                RectF rectF = new RectF(paddingLeft, paddingTop, measuredWidth - paddingRight, measuredHeight - paddingBottom);
                float f11 = this.f30330r / 2.0f;
                rectF.inset(f11, f11);
                a(canvas, rectF, this.f30316c, f11);
            }
            if (!b(drawable) || !this.f30333u) {
                super.onDraw(canvas);
                return;
            }
            RectF rectF2 = new RectF(paddingLeft, paddingTop, measuredWidth - paddingRight, measuredHeight - paddingBottom);
            float f12 = this.f30330r + this.f30331s;
            float f13 = f12 > 1.0f ? f12 - 1.0f : 0.0f;
            rectF2.inset(f13, f13);
            int iSaveLayer = canvas.saveLayer(rectF2, null, 31);
            a(canvas, rectF2, this.f30315b, f13);
            Paint paint = this.f30315b;
            if (paint != null) {
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            Bitmap bitmapC = c(drawable);
            canvas.drawBitmap(bitmapC, d(bitmapC, (int) rectF2.width(), (int) rectF2.height()), rectF2, this.f30315b);
            Paint paint2 = this.f30315b;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restoreToCount(iSaveLayer);
        } catch (Throwable th2) {
            Log.e("TranCircleImageView", Log.getStackTraceString(th2));
        }
    }

    public void setBorderColor(int i11) {
        this.f30332t = i11;
        Paint paint = this.f30316c;
        if (paint != null) {
            paint.setColor(i11);
        }
    }

    public void setBorderSpace(float f11) {
        this.f30331s = f11;
    }

    public void setBorderWidth(float f11) {
        this.f30330r = f11;
        Paint paint = this.f30316c;
        if (paint != null) {
            paint.setStrokeWidth(f11);
        }
    }

    public void setBottomLeftRadius(float f11) {
        setBottomLeftRadius_x(f11);
        setBottomLeftRadius_y(f11);
    }

    public void setBottomLeftRadius_x(float f11) {
        this.f30326n = f11;
    }

    public void setBottomLeftRadius_y(float f11) {
        this.f30327o = f11;
    }

    public void setBottomRightRadius(float f11) {
        setBottomRightRadius_x(f11);
        setBottomRightRadius_y(f11);
    }

    public void setBottomRightRadius_x(float f11) {
        this.f30328p = f11;
    }

    public void setBottomRightRadius_y(float f11) {
        this.f30329q = f11;
    }

    public void setCircle(boolean z11) {
        this.f30333u = z11;
    }

    public void setRadius(float f11) {
        setTopLeftRadius(f11);
        setTopRightRadius(f11);
        setBottomLeftRadius(f11);
        setBottomRightRadius(f11);
    }

    public void setStyleType(int i11) {
        this.f30334v = i11;
    }

    public void setTopLeftRadius(float f11) {
        setTopLeftRadius_x(f11);
        setTopLeftRadius_y(f11);
    }

    public void setTopLeftRadius_x(float f11) {
        this.f30322j = f11;
    }

    public void setTopLeftRadius_y(float f11) {
        this.f30323k = f11;
    }

    public void setTopRightRadius(float f11) {
        setTopRightRadius_x(f11);
        setTopRightRadius_y(f11);
    }

    public void setTopRightRadius_x(float f11) {
        this.f30324l = f11;
    }

    public void setTopRightRadius_y(float f11) {
        this.f30325m = f11;
    }
}
