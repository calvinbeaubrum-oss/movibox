package com.bytedance.adsdk.ugeno.Ol.We;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.sc.ExN;
import com.bytedance.adsdk.ugeno.sc.TRI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends ImageView implements IAnimation, ExN {
    static final /* synthetic */ boolean pFF = true;
    private int BT;
    private TRI Dl;
    private final float[] ExN;
    private ColorFilter Ol;
    private float Qj;
    private boolean Ql;
    private boolean SR;
    private Shader.TileMode Sfl;
    private Drawable TRI;
    private boolean Tf;
    private Drawable UFX;
    private boolean WH;
    private ImageView.ScaleType Xc;
    private com.bytedance.adsdk.ugeno.zY YIK;
    private int dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private ColorStateList f26335qr;
    private Shader.TileMode wjp;
    private float zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Shader.TileMode f26334sc = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] We = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Ol.We.sc$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26336sc;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f26336sc = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26336sc[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26336sc[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26336sc[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26336sc[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26336sc[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26336sc[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public sc(Context context) {
        super(context);
        this.ExN = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f26335qr = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.Qj = 0.0f;
        this.Ol = null;
        this.WH = false;
        this.Tf = false;
        this.Ql = false;
        this.SR = false;
        Shader.TileMode tileMode = f26334sc;
        this.wjp = tileMode;
        this.Sfl = tileMode;
        this.Dl = new TRI(this);
    }

    private void We() {
        Drawable drawable = this.UFX;
        if (drawable == null || !this.WH) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.UFX = drawableMutate;
        if (this.Tf) {
            drawableMutate.setColorFilter(this.Ol);
        }
    }

    private Drawable pFF() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i11 = this.dE;
        if (i11 != 0) {
            try {
                drawable = resources.getDrawable(i11);
            } catch (Exception e11) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.dE, e11);
                this.dE = 0;
            }
        }
        return pFF.sc(drawable);
    }

    private Drawable sc() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i11 = this.BT;
        if (i11 != 0) {
            try {
                drawable = resources.getDrawable(i11);
            } catch (Exception e11) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.BT, e11);
                this.BT = 0;
            }
        }
        return pFF.sc(drawable);
    }

    private void sc(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof pFF) {
            pFF pff = (pFF) drawable;
            pff.sc(scaleType).sc(this.Qj).sc(this.f26335qr).sc(this.Ql).sc(this.wjp).pFF(this.Sfl);
            float[] fArr = this.ExN;
            if (fArr != null) {
                pff.sc(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            We();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i11 = 0; i11 < numberOfLayers; i11++) {
                sc(layerDrawable.getDrawable(i11), scaleType);
            }
        }
    }

    private void sc(boolean z11) {
        if (this.SR) {
            if (z11) {
                this.TRI = pFF.sc(this.TRI);
            }
            sc(this.TRI, ImageView.ScaleType.FIT_XY);
        }
    }

    private void zY() {
        sc(this.UFX, this.Xc);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f26335qr.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f26335qr;
    }

    public float getBorderRadius() {
        return this.Dl.sc();
    }

    public float getBorderWidth() {
        return this.Qj;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f11 : this.ExN) {
            fMax = Math.max(f11, fMax);
        }
        return fMax;
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.sc.ExN
    public float getRipple() {
        return this.zY;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getRubIn() {
        return this.Dl.getRubIn();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.Xc;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getShine() {
        return this.Dl.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.ExN
    public float getStretch() {
        return this.Dl.getStretch();
    }

    public Shader.TileMode getTileModeX() {
        return this.wjp;
    }

    public Shader.TileMode getTileModeY() {
        return this.Sfl;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.YIK;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.zY zYVar = this.YIK;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.bytedance.adsdk.ugeno.zY zYVar = this.YIK;
        if (zYVar != null) {
            zYVar.sc(canvas, this);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.zY zYVar = this.YIK;
        if (zYVar != null) {
            zYVar.sc(i11, i12, i13, i14);
        }
        super.onLayout(z11, i11, i12, i13, i14);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i11, int i12) {
        com.bytedance.adsdk.ugeno.zY zYVar = this.YIK;
        if (zYVar == null) {
            super.onMeasure(i11, i12);
        } else {
            int[] iArrSc = zYVar.sc(i11, i12);
            super.onMeasure(iArrSc[0], iArrSc[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.adsdk.ugeno.zY zYVar = this.YIK;
        if (zYVar != null) {
            zYVar.pFF(i11, i12, i13, i13);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
    }

    public void sc(float f11, float f12, float f13, float f14) {
        float[] fArr = this.ExN;
        if (fArr[0] == f11 && fArr[1] == f12 && fArr[2] == f14 && fArr[3] == f13) {
            return;
        }
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[3] = f13;
        fArr[2] = f14;
        zY();
        sc(false);
        invalidate();
    }

    public void sc(com.bytedance.adsdk.ugeno.zY zYVar) {
        this.YIK = zYVar;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        ColorDrawable colorDrawable = new ColorDrawable(i11);
        this.TRI = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.TRI = drawable;
        sc(true);
        super.setBackgroundDrawable(this.TRI);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i11) {
        if (this.dE != i11) {
            this.dE = i11;
            Drawable drawablePFF = pFF();
            this.TRI = drawablePFF;
            setBackgroundDrawable(drawablePFF);
        }
    }

    public void setBorderColor(int i11) {
        setBorderColor(ColorStateList.valueOf(i11));
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f26335qr.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.f26335qr = colorStateList;
        zY();
        sc(false);
        if (this.Qj > 0.0f) {
            invalidate();
        }
    }

    public void setBorderRadius(float f11) {
        TRI tri = this.Dl;
        if (tri != null) {
            tri.sc(f11);
        }
    }

    public void setBorderWidth(float f11) {
        if (this.Qj == f11) {
            return;
        }
        this.Qj = f11;
        zY();
        sc(false);
        invalidate();
    }

    public void setBorderWidth(int i11) {
        setBorderWidth(getResources().getDimension(i11));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.Ol != colorFilter) {
            this.Ol = colorFilter;
            this.Tf = true;
            this.WH = true;
            We();
            invalidate();
        }
    }

    public void setCornerRadius(float f11) {
        sc(f11, f11, f11, f11);
    }

    public void setCornerRadiusDimen(int i11) {
        float dimension = getResources().getDimension(i11);
        sc(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.BT = 0;
        this.UFX = pFF.sc(bitmap);
        zY();
        super.setImageDrawable(this.UFX);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.BT = 0;
        this.UFX = pFF.sc(drawable);
        zY();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i11) {
        if (this.BT != i11) {
            this.BT = i11;
            this.UFX = sc();
            zY();
            super.setImageDrawable(this.UFX);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z11) {
        this.Ql = z11;
        zY();
        sc(false);
        invalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f11) {
        this.zY = f11;
        TRI tri = this.Dl;
        if (tri != null) {
            tri.pFF(f11);
        }
        postInvalidate();
    }

    public void setRubIn(float f11) {
        TRI tri = this.Dl;
        if (tri != null) {
            tri.ExN(f11);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!pFF && scaleType == null) {
            throw new AssertionError();
        }
        if (this.Xc != scaleType) {
            this.Xc = scaleType;
            int i11 = AnonymousClass1.f26336sc[scaleType.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            zY();
            sc(false);
            invalidate();
        }
    }

    public void setShine(float f11) {
        TRI tri = this.Dl;
        if (tri != null) {
            tri.zY(f11);
        }
    }

    public void setStretch(float f11) {
        TRI tri = this.Dl;
        if (tri != null) {
            tri.We(f11);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.wjp == tileMode) {
            return;
        }
        this.wjp = tileMode;
        zY();
        sc(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.Sfl == tileMode) {
            return;
        }
        this.Sfl = tileMode;
        zY();
        sc(false);
        invalidate();
    }
}
