package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageFilterView.c f7160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7163d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f7164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewOutlineProvider f7165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f7166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable[] f7167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LayerDrawable f7168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f7170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f7171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f7173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f7174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f7175q;

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterButton.this.f7162c) / 2.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f7163d);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f7160a = new ImageFilterView.c();
        this.f7161b = 0.0f;
        this.f7162c = 0.0f;
        this.f7163d = Float.NaN;
        this.f7167i = new Drawable[2];
        this.f7169k = true;
        this.f7170l = null;
        this.f7171m = null;
        this.f7172n = Float.NaN;
        this.f7173o = Float.NaN;
        this.f7174p = Float.NaN;
        this.f7175q = Float.NaN;
        init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7160a = new ImageFilterView.c();
        this.f7161b = 0.0f;
        this.f7162c = 0.0f;
        this.f7163d = Float.NaN;
        this.f7167i = new Drawable[2];
        this.f7169k = true;
        this.f7170l = null;
        this.f7171m = null;
        this.f7172n = Float.NaN;
        this.f7173o = Float.NaN;
        this.f7174p = Float.NaN;
        this.f7175q = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7160a = new ImageFilterView.c();
        this.f7161b = 0.0f;
        this.f7162c = 0.0f;
        this.f7163d = Float.NaN;
        this.f7167i = new Drawable[2];
        this.f7169k = true;
        this.f7170l = null;
        this.f7171m = null;
        this.f7172n = Float.NaN;
        this.f7173o = Float.NaN;
        this.f7174p = Float.NaN;
        this.f7175q = Float.NaN;
        init(context, attributeSet);
    }

    private void setOverlay(boolean z11) {
        this.f7169k = z11;
    }

    public final void c() {
        if (Float.isNaN(this.f7172n) && Float.isNaN(this.f7173o) && Float.isNaN(this.f7174p) && Float.isNaN(this.f7175q)) {
            return;
        }
        float f11 = Float.isNaN(this.f7172n) ? 0.0f : this.f7172n;
        float f12 = Float.isNaN(this.f7173o) ? 0.0f : this.f7173o;
        float f13 = Float.isNaN(this.f7174p) ? 1.0f : this.f7174p;
        float f14 = Float.isNaN(this.f7175q) ? 0.0f : this.f7175q;
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

    public final void d() {
        if (Float.isNaN(this.f7172n) && Float.isNaN(this.f7173o) && Float.isNaN(this.f7174p) && Float.isNaN(this.f7175q)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f7160a.f7201f;
    }

    public float getCrossfade() {
        return this.f7161b;
    }

    public float getImagePanX() {
        return this.f7172n;
    }

    public float getImagePanY() {
        return this.f7173o;
    }

    public float getImageRotate() {
        return this.f7175q;
    }

    public float getImageZoom() {
        return this.f7174p;
    }

    public float getRound() {
        return this.f7163d;
    }

    public float getRoundPercent() {
        return this.f7162c;
    }

    public float getSaturation() {
        return this.f7160a.f7200e;
    }

    public float getWarmth() {
        return this.f7160a.f7202g;
    }

    public final void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f7170l = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f7161b = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f7169k));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f7172n));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f7173o));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f7175q));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f7174p));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f7171m = drawable;
            if (this.f7170l == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f7171m = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f7167i;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f7171m = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f7167i;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f7171m = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f7167i[1] = this.f7170l.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f7167i);
            this.f7168j = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f7161b * 255.0f));
            if (!this.f7169k) {
                this.f7168j.getDrawable(0).setAlpha((int) ((1.0f - this.f7161b) * 255.0f));
            }
            super.setImageDrawable(this.f7168j);
        }
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        c();
    }

    public void setAltImageResource(int i11) {
        Drawable drawableMutate = d1.a.b(getContext(), i11).mutate();
        this.f7170l = drawableMutate;
        Drawable[] drawableArr = this.f7167i;
        drawableArr[0] = this.f7171m;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7167i);
        this.f7168j = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7161b);
    }

    public void setBrightness(float f11) {
        ImageFilterView.c cVar = this.f7160a;
        cVar.f7199d = f11;
        cVar.c(this);
    }

    public void setContrast(float f11) {
        ImageFilterView.c cVar = this.f7160a;
        cVar.f7201f = f11;
        cVar.c(this);
    }

    public void setCrossfade(float f11) {
        this.f7161b = f11;
        if (this.f7167i != null) {
            if (!this.f7169k) {
                this.f7168j.getDrawable(0).setAlpha((int) ((1.0f - this.f7161b) * 255.0f));
            }
            this.f7168j.getDrawable(1).setAlpha((int) (this.f7161b * 255.0f));
            super.setImageDrawable(this.f7168j);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f7170l == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f7171m = drawableMutate;
        Drawable[] drawableArr = this.f7167i;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f7170l;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7167i);
        this.f7168j = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7161b);
    }

    public void setImagePanX(float f11) {
        this.f7172n = f11;
        d();
    }

    public void setImagePanY(float f11) {
        this.f7173o = f11;
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i11) {
        if (this.f7170l == null) {
            super.setImageResource(i11);
            return;
        }
        Drawable drawableMutate = d1.a.b(getContext(), i11).mutate();
        this.f7171m = drawableMutate;
        Drawable[] drawableArr = this.f7167i;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f7170l;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7167i);
        this.f7168j = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7161b);
    }

    public void setImageRotate(float f11) {
        this.f7175q = f11;
        d();
    }

    public void setImageZoom(float f11) {
        this.f7174p = f11;
        d();
    }

    @RequiresApi(21)
    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7163d = f11;
            float f12 = this.f7162c;
            this.f7162c = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7163d != f11;
        this.f7163d = f11;
        if (f11 != 0.0f) {
            if (this.f7164f == null) {
                this.f7164f = new Path();
            }
            if (this.f7166h == null) {
                this.f7166h = new RectF();
            }
            if (this.f7165g == null) {
                b bVar = new b();
                this.f7165g = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7166h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7164f.reset();
            Path path = this.f7164f;
            RectF rectF = this.f7166h;
            float f13 = this.f7163d;
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
        boolean z11 = this.f7162c != f11;
        this.f7162c = f11;
        if (f11 != 0.0f) {
            if (this.f7164f == null) {
                this.f7164f = new Path();
            }
            if (this.f7166h == null) {
                this.f7166h = new RectF();
            }
            if (this.f7165g == null) {
                a aVar = new a();
                this.f7165g = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f7162c) / 2.0f;
            this.f7166h.set(0.0f, 0.0f, width, height);
            this.f7164f.reset();
            this.f7164f.addRoundRect(this.f7166h, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        ImageFilterView.c cVar = this.f7160a;
        cVar.f7200e = f11;
        cVar.c(this);
    }

    public void setWarmth(float f11) {
        ImageFilterView.c cVar = this.f7160a;
        cVar.f7202g = f11;
        cVar.c(this);
    }
}
