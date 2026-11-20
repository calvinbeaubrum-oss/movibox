package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f7178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f7180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f7181d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Path f7185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewOutlineProvider f7186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f7187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable[] f7188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LayerDrawable f7189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f7191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f7192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f7193q;

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.f7183g) / 2.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f7184h);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f7196a = new float[20];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorMatrix f7197b = new ColorMatrix();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorMatrix f7198c = new ColorMatrix();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7199d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7200e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7201f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7202g = 1.0f;

        public final void a(float f11) {
            float[] fArr = this.f7196a;
            fArr[0] = f11;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f11;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void b(float f11) {
            float f12 = 1.0f - f11;
            float f13 = 0.2999f * f12;
            float f14 = 0.587f * f12;
            float f15 = f12 * 0.114f;
            float[] fArr = this.f7196a;
            fArr[0] = f13 + f11;
            fArr[1] = f14;
            fArr[2] = f15;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f13;
            fArr[6] = f14 + f11;
            fArr[7] = f15;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f13;
            fArr[11] = f14;
            fArr[12] = f15 + f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void c(ImageView imageView) {
            boolean z11;
            this.f7197b.reset();
            float f11 = this.f7200e;
            boolean z12 = true;
            if (f11 != 1.0f) {
                b(f11);
                this.f7197b.set(this.f7196a);
                z11 = true;
            } else {
                z11 = false;
            }
            float f12 = this.f7201f;
            if (f12 != 1.0f) {
                this.f7198c.setScale(f12, f12, f12, 1.0f);
                this.f7197b.postConcat(this.f7198c);
                z11 = true;
            }
            float f13 = this.f7202g;
            if (f13 != 1.0f) {
                d(f13);
                this.f7198c.set(this.f7196a);
                this.f7197b.postConcat(this.f7198c);
            } else {
                z12 = z11;
            }
            float f14 = this.f7199d;
            if (f14 != 1.0f) {
                a(f14);
                this.f7198c.set(this.f7196a);
                this.f7197b.postConcat(this.f7198c);
            } else if (!z12) {
                imageView.clearColorFilter();
                return;
            }
            imageView.setColorFilter(new ColorMatrixColorFilter(this.f7197b));
        }

        public final void d(float f11) {
            float fLog;
            float fPow;
            float fLog2;
            if (f11 <= 0.0f) {
                f11 = 0.01f;
            }
            float f12 = (5000.0f / f11) / 100.0f;
            if (f12 > 66.0f) {
                double d11 = f12 - 60.0f;
                fPow = ((float) Math.pow(d11, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d11, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f12)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            if (f12 < 66.0f) {
                fLog2 = f12 > 19.0f ? (((float) Math.log(f12 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
            } else {
                fLog2 = 255.0f;
            }
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f7196a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f7178a = new c();
        this.f7179b = true;
        this.f7180c = null;
        this.f7181d = null;
        this.f7182f = 0.0f;
        this.f7183g = 0.0f;
        this.f7184h = Float.NaN;
        this.f7188l = new Drawable[2];
        this.f7190n = Float.NaN;
        this.f7191o = Float.NaN;
        this.f7192p = Float.NaN;
        this.f7193q = Float.NaN;
        init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7178a = new c();
        this.f7179b = true;
        this.f7180c = null;
        this.f7181d = null;
        this.f7182f = 0.0f;
        this.f7183g = 0.0f;
        this.f7184h = Float.NaN;
        this.f7188l = new Drawable[2];
        this.f7190n = Float.NaN;
        this.f7191o = Float.NaN;
        this.f7192p = Float.NaN;
        this.f7193q = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7178a = new c();
        this.f7179b = true;
        this.f7180c = null;
        this.f7181d = null;
        this.f7182f = 0.0f;
        this.f7183g = 0.0f;
        this.f7184h = Float.NaN;
        this.f7188l = new Drawable[2];
        this.f7190n = Float.NaN;
        this.f7191o = Float.NaN;
        this.f7192p = Float.NaN;
        this.f7193q = Float.NaN;
        init(context, attributeSet);
    }

    private void c() {
        if (Float.isNaN(this.f7190n) && Float.isNaN(this.f7191o) && Float.isNaN(this.f7192p) && Float.isNaN(this.f7193q)) {
            return;
        }
        float f11 = Float.isNaN(this.f7190n) ? 0.0f : this.f7190n;
        float f12 = Float.isNaN(this.f7191o) ? 0.0f : this.f7191o;
        float f13 = Float.isNaN(this.f7192p) ? 1.0f : this.f7192p;
        float f14 = Float.isNaN(this.f7193q) ? 0.0f : this.f7193q;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f15 = f13 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f15, f15);
        float f16 = intrinsicWidth * f15;
        float f17 = f15 * intrinsicHeight;
        matrix.postTranslate((((f11 * (width - f16)) + width) - f16) * 0.5f, (((f12 * (height - f17)) + height) - f17) * 0.5f);
        matrix.postRotate(f14, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void d() {
        if (Float.isNaN(this.f7190n) && Float.isNaN(this.f7191o) && Float.isNaN(this.f7192p) && Float.isNaN(this.f7193q)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f7180c = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f7182f = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f7179b));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f7190n));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f7191o));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f7193q));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f7192p));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f7181d = drawable;
            if (this.f7180c == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f7181d = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f7188l;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f7181d = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f7188l;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f7181d = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f7188l[1] = this.f7180c.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f7188l);
            this.f7189m = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f7182f * 255.0f));
            if (!this.f7179b) {
                this.f7189m.getDrawable(0).setAlpha((int) ((1.0f - this.f7182f) * 255.0f));
            }
            super.setImageDrawable(this.f7189m);
        }
    }

    private void setOverlay(boolean z11) {
        this.f7179b = z11;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f7178a.f7199d;
    }

    public float getContrast() {
        return this.f7178a.f7201f;
    }

    public float getCrossfade() {
        return this.f7182f;
    }

    public float getImagePanX() {
        return this.f7190n;
    }

    public float getImagePanY() {
        return this.f7191o;
    }

    public float getImageRotate() {
        return this.f7193q;
    }

    public float getImageZoom() {
        return this.f7192p;
    }

    public float getRound() {
        return this.f7184h;
    }

    public float getRoundPercent() {
        return this.f7183g;
    }

    public float getSaturation() {
        return this.f7178a.f7200e;
    }

    public float getWarmth() {
        return this.f7178a.f7202g;
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        c();
    }

    public void setAltImageResource(int i11) {
        Drawable drawableMutate = d1.a.b(getContext(), i11).mutate();
        this.f7180c = drawableMutate;
        Drawable[] drawableArr = this.f7188l;
        drawableArr[0] = this.f7181d;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7188l);
        this.f7189m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7182f);
    }

    public void setBrightness(float f11) {
        c cVar = this.f7178a;
        cVar.f7199d = f11;
        cVar.c(this);
    }

    public void setContrast(float f11) {
        c cVar = this.f7178a;
        cVar.f7201f = f11;
        cVar.c(this);
    }

    public void setCrossfade(float f11) {
        this.f7182f = f11;
        if (this.f7188l != null) {
            if (!this.f7179b) {
                this.f7189m.getDrawable(0).setAlpha((int) ((1.0f - this.f7182f) * 255.0f));
            }
            this.f7189m.getDrawable(1).setAlpha((int) (this.f7182f * 255.0f));
            super.setImageDrawable(this.f7189m);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f7180c == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f7181d = drawableMutate;
        Drawable[] drawableArr = this.f7188l;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f7180c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7188l);
        this.f7189m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7182f);
    }

    public void setImagePanX(float f11) {
        this.f7190n = f11;
        d();
    }

    public void setImagePanY(float f11) {
        this.f7191o = f11;
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i11) {
        if (this.f7180c == null) {
            super.setImageResource(i11);
            return;
        }
        Drawable drawableMutate = d1.a.b(getContext(), i11).mutate();
        this.f7181d = drawableMutate;
        Drawable[] drawableArr = this.f7188l;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f7180c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7188l);
        this.f7189m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7182f);
    }

    public void setImageRotate(float f11) {
        this.f7193q = f11;
        d();
    }

    public void setImageZoom(float f11) {
        this.f7192p = f11;
        d();
    }

    @RequiresApi(21)
    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7184h = f11;
            float f12 = this.f7183g;
            this.f7183g = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7184h != f11;
        this.f7184h = f11;
        if (f11 != 0.0f) {
            if (this.f7185i == null) {
                this.f7185i = new Path();
            }
            if (this.f7187k == null) {
                this.f7187k = new RectF();
            }
            if (this.f7186j == null) {
                b bVar = new b();
                this.f7186j = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7187k.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7185i.reset();
            Path path = this.f7185i;
            RectF rectF = this.f7187k;
            float f13 = this.f7184h;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f11) {
        boolean z11 = this.f7183g != f11;
        this.f7183g = f11;
        if (f11 != 0.0f) {
            if (this.f7185i == null) {
                this.f7185i = new Path();
            }
            if (this.f7187k == null) {
                this.f7187k = new RectF();
            }
            if (this.f7186j == null) {
                a aVar = new a();
                this.f7186j = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f7183g) / 2.0f;
            this.f7187k.set(0.0f, 0.0f, width, height);
            this.f7185i.reset();
            this.f7185i.addRoundRect(this.f7187k, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        c cVar = this.f7178a;
        cVar.f7200e = f11;
        cVar.c(this);
    }

    public void setWarmth(float f11) {
        c cVar = this.f7178a;
        cVar.f7202g = f11;
        cVar.c(this);
    }
}
