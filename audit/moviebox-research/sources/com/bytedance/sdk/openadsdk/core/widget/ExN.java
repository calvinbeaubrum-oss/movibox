package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.c;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"AppCompatCustomView"})
public class ExN extends ImageView {
    private boolean BT;
    private AnimatedImageDrawable ExN;
    private float Ol;
    private float Qj;
    private volatile boolean Ql;
    private boolean SR;
    private boolean TRI;
    private int Tf;
    private int UFX;
    private float WH;
    private int We;
    private Movie pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f28527qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f28528sc;
    private long zY;

    public ExN(Context context) {
        super(context);
        this.TRI = Build.VERSION.SDK_INT >= 28;
        this.f28527qr = false;
        this.SR = true;
        this.BT = true;
        sc();
    }

    private void We() {
        if (this.pFF == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.zY == 0) {
            this.zY = jUptimeMillis;
        }
        int iDuration = this.pFF.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (this.BT || Math.abs(iDuration - this.We) >= 60) {
            this.We = (int) ((jUptimeMillis - this.zY) % ((long) iDuration));
        } else {
            this.We = iDuration;
            this.Ql = true;
        }
    }

    private AnimatedImageDrawable pFF(int i11) {
        if (i11 != -1 && Build.VERSION.SDK_INT >= 28) {
            return sc(ImageDecoder.createSource(getResources(), i11));
        }
        return null;
    }

    private AnimatedImageDrawable pFF(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return sc(zY(bArr));
    }

    private Movie sc(int i11) {
        try {
            return Movie.decodeStream(getResources().openRawResource(i11));
        } catch (Throwable unused) {
            return null;
        }
    }

    private Movie sc(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private AnimatedImageDrawable sc(ImageDecoder.Source source) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return null;
            }
            Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source);
            setImageDrawable(drawableDecodeDrawable);
            if (com.bumptech.glide.load.resource.drawable.b.a(drawableDecodeDrawable)) {
                AnimatedImageDrawable animatedImageDrawableA = c.a(drawableDecodeDrawable);
                if (!this.Ql) {
                    animatedImageDrawableA.start();
                }
                return animatedImageDrawableA;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static File sc(Context context, String str, String str2) {
        return com.bytedance.sdk.component.utils.TRI.sc(context, com.bytedance.sdk.openadsdk.multipro.pFF.zY(), str, str2);
    }

    private void sc(Canvas canvas) {
        Movie movie = this.pFF;
        if (movie == null) {
            return;
        }
        movie.setTime(this.We);
        float f11 = this.WH;
        if (f11 == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.pFF.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f11, f11);
            Movie movie2 = this.pFF;
            float f12 = this.Qj;
            float f13 = this.WH;
            movie2.draw(canvas, f12 / f13, this.Ol / f13);
        }
        canvas.restore();
    }

    private ImageDecoder.Source zY(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            File fileSc = sc(getContext(), com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? "GIF_AD_CACHE/" : "/GIF_CACHE/", "TT_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileSc);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(fileSc);
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return sourceCreateSource;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.bytedance.sdk.component.utils.Tf.sc("GifView", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        return null;
    }

    private void zY() {
        if (this.pFF == null || this.TRI || !this.SR) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.pFF == null || this.TRI) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.Ql) {
                sc(canvas);
                return;
            }
            We();
            sc(canvas);
            zY();
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("GifView", "onDraw->Throwable->", th2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.pFF != null && !this.TRI) {
            this.Qj = (getWidth() - this.UFX) / 2.0f;
            this.Ol = (getHeight() - this.Tf) / 2.0f;
        }
        this.SR = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i11, i12);
        if (this.TRI || (movie = this.pFF) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.pFF.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i11) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i11))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i12) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i12))) ? 1.0f : iHeight / size);
        this.WH = fMax;
        int i13 = (int) (iWidth * fMax);
        this.UFX = i13;
        int i14 = (int) (iHeight * fMax);
        this.Tf = i14;
        setMeasuredDimension(i13, i14);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i11) {
        super.onScreenStateChanged(i11);
        if (this.pFF != null) {
            this.SR = i11 == 1;
            zY();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (this.pFF != null) {
            this.SR = i11 == 0;
            zY();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        if (this.pFF != null) {
            this.SR = i11 == 0;
            zY();
        }
    }

    public void pFF() {
        if (this.pFF == null || !this.Ql) {
            return;
        }
        this.Ql = false;
        if (!this.TRI) {
            this.zY = SystemClock.uptimeMillis() - ((long) this.We);
            invalidate();
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.ExN;
        if (animatedImageDrawable == null || animatedImageDrawable.isRunning()) {
            return;
        }
        this.ExN.start();
    }

    public void sc() {
        if (this.TRI) {
            return;
        }
        setLayerType(1, null);
    }

    public void sc(int i11, boolean z11) {
        this.Ql = z11;
        this.f28528sc = i11;
        if (i11 != -1) {
            if (this.TRI) {
                this.ExN = pFF(i11);
            } else {
                this.pFF = sc(i11);
            }
        }
    }

    public void sc(byte[] bArr, boolean z11) {
        this.Ql = z11;
        if (bArr != null) {
            if (this.TRI) {
                this.ExN = pFF(bArr);
            } else {
                this.pFF = sc(bArr);
            }
            zY();
        }
    }

    public void setRepeatConfig(boolean z11) {
        AnimatedImageDrawable animatedImageDrawable;
        this.BT = z11;
        if (z11) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.ExN) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("GifView", "setRepeatConfig error", e11);
        }
    }
}
