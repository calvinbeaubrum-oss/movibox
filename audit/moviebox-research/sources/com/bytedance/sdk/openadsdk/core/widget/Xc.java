package com.bytedance.sdk.openadsdk.core.widget;

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
import android.util.AttributeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc extends com.bytedance.sdk.openadsdk.core.ExN.We {
    private final RectF ExN;
    private BitmapShader TRI;
    private final Matrix We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Paint f28546sc;
    private int zY;

    public Xc(Context context) {
        this(context, null);
    }

    public Xc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Xc(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.pFF = 25;
        this.zY = 25;
        this.ExN = new RectF();
        Paint paint = new Paint();
        this.f28546sc = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.We = new Matrix();
    }

    private Bitmap sc(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmapSc;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.TRI == null && (bitmapSc = sc(drawable)) != null) {
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.TRI = new BitmapShader(bitmapSc, tileMode, tileMode);
            float fMax = (bitmapSc.getWidth() == getWidth() && bitmapSc.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapSc.getWidth(), (getHeight() * 1.0f) / bitmapSc.getHeight());
            this.We.setScale(fMax, fMax);
            this.TRI.setLocalMatrix(this.We);
        }
        BitmapShader bitmapShader = this.TRI;
        if (bitmapShader == null) {
            super.onDraw(canvas);
        } else {
            this.f28546sc.setShader(bitmapShader);
            canvas.drawRoundRect(this.ExN, this.pFF, this.zY, this.f28546sc);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.ExN.set(0.0f, 0.0f, i11, i12);
    }

    public void setXRound(int i11) {
        this.pFF = i11;
        postInvalidate();
    }

    public void setYRound(int i11) {
        this.zY = i11;
        postInvalidate();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.TRI = null;
    }
}
