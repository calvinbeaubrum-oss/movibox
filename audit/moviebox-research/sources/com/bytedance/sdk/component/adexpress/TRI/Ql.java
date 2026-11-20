package com.bytedance.sdk.component.adexpress.TRI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
public class Ql extends ImageView {
    private boolean ExN;
    private float Ol;
    private float Qj;
    private boolean Ql;
    private boolean SR;
    private boolean TRI;
    private volatile boolean Tf;
    private int UFX;
    private int WH;
    private AnimatedImageDrawable We;
    private long pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26677qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Movie f26678sc;
    private int zY;

    public Ql(Context context) {
        super(context);
        this.ExN = Build.VERSION.SDK_INT >= 28;
        this.TRI = false;
        this.Ql = true;
        this.SR = true;
        sc();
    }

    private void pFF() {
        if (this.f26678sc == null || this.ExN || !this.Ql) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void sc(Canvas canvas) {
        Movie movie = this.f26678sc;
        if (movie == null) {
            return;
        }
        movie.setTime(this.zY);
        float f11 = this.Ol;
        if (f11 == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.f26678sc.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f11, f11);
            Movie movie2 = this.f26678sc;
            float f12 = this.f26677qr;
            float f13 = this.Ol;
            movie2.draw(canvas, f12 / f13, this.Qj / f13);
        }
        canvas.restore();
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && b.a(drawable)) {
            AnimatedImageDrawable animatedImageDrawableA = c.a(drawable);
            this.We = animatedImageDrawableA;
            if (!this.Tf) {
                animatedImageDrawableA.start();
            }
            if (!this.SR) {
                animatedImageDrawableA.setRepeatCount(0);
            }
        }
        pFF();
    }

    private void zY() {
        if (this.f26678sc == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.pFF == 0) {
            this.pFF = jUptimeMillis;
        }
        int iDuration = this.f26678sc.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (this.SR || Math.abs(iDuration - this.zY) >= 60) {
            this.zY = (int) ((jUptimeMillis - this.pFF) % ((long) iDuration));
        } else {
            this.zY = iDuration;
            this.Tf = true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f26678sc == null || this.ExN) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.Tf) {
                sc(canvas);
                return;
            }
            zY();
            sc(canvas);
            pFF();
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("GifView", "onDraw->Throwable->", th2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f26678sc != null && !this.ExN) {
            this.f26677qr = (getWidth() - this.WH) / 2.0f;
            this.Qj = (getHeight() - this.UFX) / 2.0f;
        }
        this.Ql = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i11, i12);
        if (this.ExN || (movie = this.f26678sc) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.f26678sc.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i11) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i11))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i12) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i12))) ? 1.0f : iHeight / size);
        this.Ol = fMax;
        int i13 = (int) (iWidth * fMax);
        this.WH = i13;
        int i14 = (int) (iHeight * fMax);
        this.UFX = i14;
        setMeasuredDimension(i13, i14);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i11) {
        super.onScreenStateChanged(i11);
        if (this.f26678sc != null) {
            this.Ql = i11 == 1;
            pFF();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (this.f26678sc != null) {
            this.Ql = i11 == 0;
            pFF();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        if (this.f26678sc != null) {
            this.Ql = i11 == 0;
            pFF();
        }
    }

    public void sc() {
        if (this.ExN) {
            return;
        }
        setLayerType(1, null);
    }

    public void setRepeatConfig(boolean z11) {
        AnimatedImageDrawable animatedImageDrawable;
        this.SR = z11;
        if (z11) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.We) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("GifView", "setRepeatConfig error", e11);
        }
    }
}
