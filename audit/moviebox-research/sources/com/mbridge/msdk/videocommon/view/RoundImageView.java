package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.widget.MBImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class RoundImageView extends MBImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f48592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f48593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f48594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Matrix f48596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BitmapShader f48597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f48598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f48599h;

    public RoundImageView(Context context) {
        super(context);
        this.f48596e = new Matrix();
        Paint paint = new Paint();
        this.f48594c = paint;
        paint.setAntiAlias(true);
        this.f48593b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f48592a = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48596e = new Matrix();
        Paint paint = new Paint();
        this.f48594c = paint;
        paint.setAntiAlias(true);
        this.f48593b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f48592a = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f48596e = new Matrix();
        Paint paint = new Paint();
        this.f48594c = paint;
        paint.setAntiAlias(true);
        this.f48593b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f48592a = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            ad.b("View", th2.getMessage());
            return null;
        }
    }

    @Override // com.mbridge.msdk.widget.MBImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        try {
            if (getDrawable() == null) {
                return;
            }
            try {
                Drawable drawable = getDrawable();
                if (drawable != null && (bitmapA = a(drawable)) != null && !bitmapA.isRecycled()) {
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    this.f48597f = new BitmapShader(bitmapA, tileMode, tileMode);
                    int i11 = this.f48592a;
                    float fMax = 1.0f;
                    if (i11 == 0) {
                        fMax = (this.f48598g * 1.0f) / Math.min(bitmapA.getWidth(), bitmapA.getHeight());
                    } else if (i11 == 1) {
                        fMax = Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
                    }
                    this.f48596e.setScale(fMax, fMax);
                    this.f48597f.setLocalMatrix(this.f48596e);
                    this.f48594c.setShader(this.f48597f);
                }
            } catch (Throwable th2) {
                ad.b("RoundImageView", th2.getMessage());
            }
            if (this.f48592a != 1) {
                int i12 = this.f48595d;
                canvas.drawCircle(i12, i12, i12, this.f48594c);
            } else {
                RectF rectF = this.f48599h;
                int i13 = this.f48593b;
                canvas.drawRoundRect(rectF, i13, i13, this.f48594c);
            }
        } catch (Throwable th3) {
            ad.b("RoundImageView", th3.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f48592a == 0) {
            int iMin = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f48598g = iMin;
            this.f48595d = iMin / 2;
            setMeasuredDimension(iMin, iMin);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
        this.f48592a = bundle.getInt("state_type");
        this.f48593b = bundle.getInt("state_border_radius");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f48592a);
        bundle.putInt("state_border_radius", this.f48593b);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.f48592a == 1) {
            this.f48599h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i11) {
        int iA = ai.a(getContext(), i11);
        if (this.f48593b != iA) {
            this.f48593b = iA;
            invalidate();
        }
    }

    public void setType(int i11) {
        if (this.f48592a != i11) {
            this.f48592a = i11;
            if (i11 != 1 && i11 != 0) {
                this.f48592a = 0;
            }
            requestLayout();
        }
    }
}
