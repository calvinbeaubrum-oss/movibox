package com.bytedance.sdk.component.adexpress.TRI;

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
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WP extends ImageView {
    private Matrix We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Paint f26700sc;
    private int zY;

    public WP(Context context) {
        this(context, null);
    }

    public WP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WP(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.pFF = 25;
        this.zY = 25;
        Paint paint = new Paint();
        this.f26700sc = paint;
        paint.setAntiAlias(true);
        this.f26700sc.setFilterBitmap(true);
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
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmapSc = sc(drawable);
        if (bitmapSc == null) {
            super.onDraw(canvas);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmapSc, tileMode, tileMode);
        float fMax = (bitmapSc.getWidth() == getWidth() && bitmapSc.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapSc.getWidth(), (getHeight() * 1.0f) / bitmapSc.getHeight());
        this.We.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.We);
        this.f26700sc.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.pFF, this.zY, this.f26700sc);
    }

    public void setXRound(int i11) {
        this.pFF = i11;
        postInvalidate();
    }

    public void setYRound(int i11) {
        this.zY = i11;
        postInvalidate();
    }
}
