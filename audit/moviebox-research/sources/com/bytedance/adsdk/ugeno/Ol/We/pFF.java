package com.bytedance.adsdk.ugeno.Ol.We;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.load.resource.drawable.b;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends Drawable {
    private float BT;
    private final Paint ExN;
    private final Paint Ol;
    private final RectF Qj;
    private Shader.TileMode Ql;
    private boolean SR;
    private ColorStateList Sfl;
    private final int TRI;
    private Shader.TileMode Tf;
    private final RectF UFX;
    private final Matrix WH;
    private final Bitmap We;
    private boolean Xc;
    private ImageView.ScaleType YIK;
    private final boolean[] dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final int f26331qr;
    private float wjp;
    private final RectF zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final RectF f26332sc = new RectF();
    private final RectF pFF = new RectF();

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Ol.We.pFF$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26333sc;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f26333sc = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26333sc[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26333sc[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26333sc[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26333sc[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26333sc[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26333sc[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public pFF(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.zY = rectF;
        this.Qj = new RectF();
        this.WH = new Matrix();
        this.UFX = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.Tf = tileMode;
        this.Ql = tileMode;
        this.SR = true;
        this.BT = 0.0f;
        this.dE = new boolean[]{true, true, true, true};
        this.Xc = false;
        this.wjp = 0.0f;
        this.Sfl = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.YIK = ImageView.ScaleType.FIT_CENTER;
        this.We = bitmap;
        int width = bitmap.getWidth();
        this.TRI = width;
        int height = bitmap.getHeight();
        this.f26331qr = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.ExN = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.Ol = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.Sfl.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.wjp);
    }

    public static Bitmap pFF(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    private void pFF(Canvas canvas) {
        float f11;
        if (pFF(this.dE) || this.BT == 0.0f) {
            return;
        }
        RectF rectF = this.pFF;
        float f12 = rectF.left;
        float f13 = rectF.top;
        float fWidth = rectF.width() + f12;
        float fHeight = f13 + this.pFF.height();
        float f14 = this.BT;
        float f15 = this.wjp / 2.0f;
        if (!this.dE[0]) {
            canvas.drawLine(f12 - f15, f13, f12 + f14, f13, this.Ol);
            canvas.drawLine(f12, f13 - f15, f12, f13 + f14, this.Ol);
        }
        if (!this.dE[1]) {
            canvas.drawLine((fWidth - f14) - f15, f13, fWidth, f13, this.Ol);
            canvas.drawLine(fWidth, f13 - f15, fWidth, f13 + f14, this.Ol);
        }
        if (this.dE[2]) {
            f11 = f14;
        } else {
            f11 = f14;
            canvas.drawLine((fWidth - f14) - f15, fHeight, fWidth + f15, fHeight, this.Ol);
            canvas.drawLine(fWidth, fHeight - f11, fWidth, fHeight, this.Ol);
        }
        if (this.dE[3]) {
            return;
        }
        canvas.drawLine(f12 - f15, fHeight, f12 + f11, fHeight, this.Ol);
        canvas.drawLine(f12, fHeight - f11, f12, fHeight, this.Ol);
    }

    private static boolean pFF(boolean[] zArr) {
        for (boolean z11 : zArr) {
            if (z11) {
                return false;
            }
        }
        return true;
    }

    public static Drawable sc(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof pFF) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && b.a(drawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i11 = 0; i11 < numberOfLayers; i11++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i11), sc(layerDrawable.getDrawable(i11)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapPFF = pFF(drawable);
        return bitmapPFF != null ? new pFF(bitmapPFF) : drawable;
    }

    public static pFF sc(Bitmap bitmap) {
        if (bitmap != null) {
            return new pFF(bitmap);
        }
        return null;
    }

    private void sc() {
        float fWidth;
        float fHeight;
        int i11 = AnonymousClass1.f26333sc[this.YIK.ordinal()];
        if (i11 == 1) {
            this.Qj.set(this.f26332sc);
            RectF rectF = this.Qj;
            float f11 = this.wjp;
            rectF.inset(f11 / 2.0f, f11 / 2.0f);
            this.WH.reset();
            this.WH.setTranslate((int) (((this.Qj.width() - this.TRI) * 0.5f) + 0.5f), (int) (((this.Qj.height() - this.f26331qr) * 0.5f) + 0.5f));
        } else if (i11 == 2) {
            this.Qj.set(this.f26332sc);
            RectF rectF2 = this.Qj;
            float f12 = this.wjp;
            rectF2.inset(f12 / 2.0f, f12 / 2.0f);
            this.WH.reset();
            float fWidth2 = 0.0f;
            if (this.TRI * this.Qj.height() > this.Qj.width() * this.f26331qr) {
                fWidth = this.Qj.height() / this.f26331qr;
                fWidth2 = (this.Qj.width() - (this.TRI * fWidth)) * 0.5f;
                fHeight = 0.0f;
            } else {
                fWidth = this.Qj.width() / this.TRI;
                fHeight = (this.Qj.height() - (this.f26331qr * fWidth)) * 0.5f;
            }
            this.WH.setScale(fWidth, fWidth);
            Matrix matrix = this.WH;
            float f13 = this.wjp;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f13 / 2.0f), ((int) (fHeight + 0.5f)) + (f13 / 2.0f));
        } else if (i11 == 3) {
            this.WH.reset();
            float fMin = (((float) this.TRI) > this.f26332sc.width() || ((float) this.f26331qr) > this.f26332sc.height()) ? Math.min(this.f26332sc.width() / this.TRI, this.f26332sc.height() / this.f26331qr) : 1.0f;
            float fWidth3 = (int) (((this.f26332sc.width() - (this.TRI * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.f26332sc.height() - (this.f26331qr * fMin)) * 0.5f) + 0.5f);
            this.WH.setScale(fMin, fMin);
            this.WH.postTranslate(fWidth3, fHeight2);
            this.Qj.set(this.zY);
            this.WH.mapRect(this.Qj);
            RectF rectF3 = this.Qj;
            float f14 = this.wjp;
            rectF3.inset(f14 / 2.0f, f14 / 2.0f);
            this.WH.setRectToRect(this.zY, this.Qj, Matrix.ScaleToFit.FILL);
        } else if (i11 == 5) {
            this.Qj.set(this.zY);
            this.WH.setRectToRect(this.zY, this.f26332sc, Matrix.ScaleToFit.END);
            this.WH.mapRect(this.Qj);
            RectF rectF4 = this.Qj;
            float f15 = this.wjp;
            rectF4.inset(f15 / 2.0f, f15 / 2.0f);
            this.WH.setRectToRect(this.zY, this.Qj, Matrix.ScaleToFit.FILL);
        } else if (i11 == 6) {
            this.Qj.set(this.zY);
            this.WH.setRectToRect(this.zY, this.f26332sc, Matrix.ScaleToFit.START);
            this.WH.mapRect(this.Qj);
            RectF rectF5 = this.Qj;
            float f16 = this.wjp;
            rectF5.inset(f16 / 2.0f, f16 / 2.0f);
            this.WH.setRectToRect(this.zY, this.Qj, Matrix.ScaleToFit.FILL);
        } else if (i11 != 7) {
            this.Qj.set(this.zY);
            this.WH.setRectToRect(this.zY, this.f26332sc, Matrix.ScaleToFit.CENTER);
            this.WH.mapRect(this.Qj);
            RectF rectF6 = this.Qj;
            float f17 = this.wjp;
            rectF6.inset(f17 / 2.0f, f17 / 2.0f);
            this.WH.setRectToRect(this.zY, this.Qj, Matrix.ScaleToFit.FILL);
        } else {
            this.Qj.set(this.f26332sc);
            RectF rectF7 = this.Qj;
            float f18 = this.wjp;
            rectF7.inset(f18 / 2.0f, f18 / 2.0f);
            this.WH.reset();
            this.WH.setRectToRect(this.zY, this.Qj, Matrix.ScaleToFit.FILL);
        }
        this.pFF.set(this.Qj);
        this.SR = true;
    }

    private void sc(Canvas canvas) {
        if (pFF(this.dE) || this.BT == 0.0f) {
            return;
        }
        RectF rectF = this.pFF;
        float f11 = rectF.left;
        float f12 = rectF.top;
        float fWidth = rectF.width() + f11;
        float fHeight = this.pFF.height() + f12;
        float f13 = this.BT;
        if (!this.dE[0]) {
            this.UFX.set(f11, f12, f11 + f13, f12 + f13);
            canvas.drawRect(this.UFX, this.ExN);
        }
        if (!this.dE[1]) {
            this.UFX.set(fWidth - f13, f12, fWidth, f13);
            canvas.drawRect(this.UFX, this.ExN);
        }
        if (!this.dE[2]) {
            this.UFX.set(fWidth - f13, fHeight - f13, fWidth, fHeight);
            canvas.drawRect(this.UFX, this.ExN);
        }
        if (this.dE[3]) {
            return;
        }
        this.UFX.set(f11, fHeight - f13, f13 + f11, fHeight);
        canvas.drawRect(this.UFX, this.ExN);
    }

    private static boolean sc(boolean[] zArr) {
        for (boolean z11 : zArr) {
            if (z11) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.SR) {
            BitmapShader bitmapShader = new BitmapShader(this.We, this.Tf, this.Ql);
            Shader.TileMode tileMode = this.Tf;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.Ql == tileMode2) {
                bitmapShader.setLocalMatrix(this.WH);
            }
            this.ExN.setShader(bitmapShader);
            this.SR = false;
        }
        if (this.Xc) {
            if (this.wjp <= 0.0f) {
                canvas.drawOval(this.pFF, this.ExN);
                return;
            } else {
                canvas.drawOval(this.pFF, this.ExN);
                canvas.drawOval(this.Qj, this.Ol);
                return;
            }
        }
        if (!sc(this.dE)) {
            canvas.drawRect(this.pFF, this.ExN);
            if (this.wjp > 0.0f) {
                canvas.drawRect(this.Qj, this.Ol);
                return;
            }
            return;
        }
        float f11 = this.BT;
        if (this.wjp <= 0.0f) {
            canvas.drawRoundRect(this.pFF, f11, f11, this.ExN);
            sc(canvas);
        } else {
            canvas.drawRoundRect(this.pFF, f11, f11, this.ExN);
            canvas.drawRoundRect(this.Qj, f11, f11, this.Ol);
            sc(canvas);
            pFF(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ExN.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.ExN.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f26331qr;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.TRI;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.Sfl.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f26332sc.set(rect);
        sc();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.Sfl.getColorForState(iArr, 0);
        if (this.Ol.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.Ol.setColor(colorForState);
        return true;
    }

    public pFF pFF(Shader.TileMode tileMode) {
        if (this.Ql != tileMode) {
            this.Ql = tileMode;
            this.SR = true;
            invalidateSelf();
        }
        return this;
    }

    public pFF sc(float f11) {
        this.wjp = f11;
        this.Ol.setStrokeWidth(f11);
        return this;
    }

    public pFF sc(float f11, float f12, float f13, float f14) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f11));
        hashSet.add(Float.valueOf(f12));
        hashSet.add(Float.valueOf(f13));
        hashSet.add(Float.valueOf(f14));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.BT = 0.0f;
        } else {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
            }
            this.BT = fFloatValue;
        }
        boolean[] zArr = this.dE;
        zArr[0] = f11 > 0.0f;
        zArr[1] = f12 > 0.0f;
        zArr[2] = f13 > 0.0f;
        zArr[3] = f14 > 0.0f;
        return this;
    }

    public pFF sc(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.Sfl = colorStateList;
        this.Ol.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public pFF sc(Shader.TileMode tileMode) {
        if (this.Tf != tileMode) {
            this.Tf = tileMode;
            this.SR = true;
            invalidateSelf();
        }
        return this;
    }

    public pFF sc(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.YIK != scaleType) {
            this.YIK = scaleType;
            sc();
        }
        return this;
    }

    public pFF sc(boolean z11) {
        this.Xc = z11;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.ExN.setAlpha(i11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ExN.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z11) {
        this.ExN.setDither(z11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z11) {
        this.ExN.setFilterBitmap(z11);
        invalidateSelf();
    }
}
