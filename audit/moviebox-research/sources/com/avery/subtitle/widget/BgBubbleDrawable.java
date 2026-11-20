package com.avery.subtitle.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BgBubbleDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f25102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f25103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f25104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitmapShader f25105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f25106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f25107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f25108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f25110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f25111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f25112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f25113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f25114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f25115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f25116o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f25117p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrowLocation f25118q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BubbleType f25119r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f25120s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f25121t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f25122u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f25123v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f25124w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f25125x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f25126y;

    /* JADX INFO: compiled from: source.java */
    public enum ArrowLocation {
        LEFT(0),
        RIGHT(1),
        TOP(2),
        BOTTOM(3),
        NONE(4);

        private int mValue;

        ArrowLocation(int i11) {
            this.mValue = i11;
        }

        public static ArrowLocation getDefault() {
            return LEFT;
        }

        public static ArrowLocation mapIntToValue(int i11) {
            for (ArrowLocation arrowLocation : values()) {
                if (i11 == arrowLocation.getIntValue()) {
                    return arrowLocation;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum BubbleType {
        COLOR,
        BITMAP,
        SHADER
    }

    /* JADX INFO: compiled from: source.java */
    public enum GradientDirection {
        HORIZONTAL(1),
        VERTICAL(0);

        private int mValue;

        GradientDirection(int i11) {
            this.mValue = i11;
        }

        public static GradientDirection getDefault() {
            return VERTICAL;
        }

        public static GradientDirection mapIntToValue(int i11) {
            for (GradientDirection gradientDirection : values()) {
                if (i11 == gradientDirection.getIntValue()) {
                    return gradientDirection;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25128b;

        static {
            int[] iArr = new int[BubbleType.values().length];
            f25128b = iArr;
            try {
                iArr[BubbleType.SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25128b[BubbleType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25128b[BubbleType.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ArrowLocation.values().length];
            f25127a = iArr2;
            try {
                iArr2[ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25127a[ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25127a[ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25127a[ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25127a[ArrowLocation.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        public static float A = 0.0f;
        public static int B = -1291845632;
        public static float C = 0.0f;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static float f25129u = 25.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static float f25130v = 25.0f;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static float f25131w = 20.0f;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static float f25132x = 50.0f;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static int f25133y = -65536;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static int f25134z = 255;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f25135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f25136b = A;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25137c = B;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f25138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f25139e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f25140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f25141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f25142h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f25143i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f25144j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f25145k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Bitmap f25146l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public BubbleType f25147m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ArrowLocation f25148n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f25149o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f25150p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f25151q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f25152r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f25153s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int[] f25154t;

        public b() {
            float f11 = C;
            this.f25138d = f11;
            this.f25139e = f11;
            this.f25140f = f25129u;
            this.f25141g = f25131w;
            this.f25142h = f25130v;
            this.f25143i = f25132x;
            this.f25144j = f25133y;
            this.f25145k = f25134z;
            this.f25147m = BubbleType.COLOR;
            this.f25148n = ArrowLocation.LEFT;
        }

        public b p(float f11) {
            this.f25141g = f11 * 2.0f;
            return this;
        }

        public b q(ArrowLocation arrowLocation) {
            this.f25148n = arrowLocation;
            return this;
        }

        public b r(int i11) {
            this.f25144j = i11;
            s(BubbleType.COLOR);
            return this;
        }

        public b s(BubbleType bubbleType) {
            this.f25147m = bubbleType;
            return this;
        }

        public BgBubbleDrawable t() {
            if (this.f25135a != null) {
                return new BgBubbleDrawable(this);
            }
            throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
        }

        public b u(RectF rectF) {
            this.f25135a = rectF;
            return this;
        }
    }

    public BgBubbleDrawable(b bVar) {
        this.f25103b = new Path();
        this.f25104c = new Path();
        this.f25106e = new Paint(1);
        this.f25107f = new Paint();
        this.f25121t = 255;
        this.f25108g = bVar.f25136b;
        this.f25109h = bVar.f25137c;
        this.f25110i = bVar.f25138d;
        this.f25111j = bVar.f25139e;
        this.f25102a = bVar.f25135a;
        this.f25113l = bVar.f25141g;
        this.f25121t = bVar.f25145k;
        this.f25114m = bVar.f25142h;
        this.f25112k = bVar.f25140f;
        this.f25115n = bVar.f25143i;
        this.f25116o = bVar.f25144j;
        this.f25117p = bVar.f25146l;
        this.f25118q = bVar.f25148n;
        this.f25119r = bVar.f25147m;
        this.f25120s = bVar.f25149o;
        this.f25122u = bVar.f25150p;
        this.f25123v = bVar.f25151q;
        this.f25124w = bVar.f25152r;
        this.f25125x = bVar.f25153s;
        this.f25126y = bVar.f25154t;
    }

    public final void a(Canvas canvas) {
        int i11 = a.f25128b[this.f25119r.ordinal()];
        if (i11 == 1) {
            this.f25106e.setShader(new LinearGradient(this.f25122u, this.f25123v, this.f25124w, this.f25125x, this.f25126y, (float[]) null, Shader.TileMode.CLAMP));
        } else if (i11 == 2) {
            this.f25106e.setColor(this.f25116o);
        } else if (i11 == 3) {
            if (this.f25117p == null) {
                return;
            }
            if (this.f25105d == null) {
                Bitmap bitmap = this.f25117p;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f25105d = new BitmapShader(bitmap, tileMode, tileMode);
            }
            this.f25106e.setShader(this.f25105d);
            g();
        }
        e(this.f25118q, this.f25103b);
        this.f25106e.setAlpha(Math.abs(this.f25121t));
        if (this.f25108g > 0.0f) {
            this.f25107f.setColor(0);
            this.f25107f.setAlpha(Math.abs(this.f25121t));
            this.f25107f.setAntiAlias(true);
            this.f25107f.setShadowLayer(this.f25108g, this.f25110i, this.f25111j, this.f25109h);
            this.f25107f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
            canvas.drawPath(this.f25103b, this.f25107f);
        }
        canvas.drawPath(this.f25103b, this.f25106e);
    }

    public final void b(RectF rectF, Path path) {
        if (this.f25120s) {
            this.f25115n = ((rectF.right - rectF.left) / 2.0f) - (this.f25112k / 2.0f);
        }
        path.moveTo(rectF.left + this.f25113l, rectF.top);
        path.lineTo(rectF.width() - this.f25113l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f25113l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.f25114m) - this.f25113l);
        float f14 = rectF.right;
        float f15 = this.f25113l;
        float f16 = rectF.bottom;
        float f17 = this.f25114m;
        path.arcTo(new RectF(f14 - f15, (f16 - f15) - f17, f14, f16 - f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f25112k + this.f25115n, rectF.bottom - this.f25114m);
        path.lineTo(rectF.left + this.f25115n + (this.f25112k / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.f25115n, rectF.bottom - this.f25114m);
        path.lineTo(rectF.left + Math.min(this.f25113l, this.f25115n), rectF.bottom - this.f25114m);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f21 = this.f25113l;
        float f22 = this.f25114m;
        path.arcTo(new RectF(f18, (f19 - f21) - f22, f21 + f18, f19 - f22), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f25113l);
        float f23 = rectF.left;
        float f24 = rectF.top;
        float f25 = this.f25113l;
        path.arcTo(new RectF(f23, f24, f25 + f23, f25 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void c(RectF rectF, Path path) {
        if (this.f25120s) {
            this.f25115n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f25112k / 2.0f);
        }
        path.moveTo(this.f25112k + rectF.left + this.f25113l, rectF.top);
        path.lineTo(rectF.width() - this.f25113l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f25113l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f25113l);
        float f14 = rectF.right;
        float f15 = this.f25113l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f25112k + this.f25113l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = this.f25112k;
        float f19 = rectF.bottom;
        float f21 = this.f25113l;
        path.arcTo(new RectF(f17 + f18, f19 - f21, f21 + f17 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.f25112k, this.f25114m + this.f25115n);
        path.lineTo(rectF.left, this.f25115n + (this.f25114m / 2.0f));
        path.lineTo(rectF.left + this.f25112k, this.f25115n);
        path.lineTo(rectF.left + this.f25112k, rectF.top + this.f25113l);
        float f22 = rectF.left;
        float f23 = this.f25112k;
        float f24 = rectF.top;
        float f25 = this.f25113l;
        path.arcTo(new RectF(f22 + f23, f24, f22 + f25 + f23, f25 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void d(RectF rectF, Path path) {
        if (this.f25120s) {
            this.f25115n = ((rectF.right - rectF.left) / 2.0f) - (this.f25112k / 2.0f);
        }
        path.moveTo(rectF.left + this.f25113l, rectF.top);
        path.lineTo(rectF.width() - this.f25113l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f25113l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f25113l);
        float f14 = rectF.right;
        float f15 = this.f25113l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f25113l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = rectF.bottom;
        float f19 = this.f25113l;
        path.arcTo(new RectF(f17, f18 - f19, f19 + f17, f18), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f25113l);
        float f21 = rectF.left;
        float f22 = rectF.top;
        float f23 = this.f25113l;
        path.arcTo(new RectF(f21, f22, f23 + f21, f23 + f22), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    public final void e(ArrowLocation arrowLocation, Path path) {
        int i11 = a.f25127a[arrowLocation.ordinal()];
        if (i11 == 1) {
            c(this.f25102a, path);
            return;
        }
        if (i11 == 2) {
            f(this.f25102a, path);
            return;
        }
        if (i11 == 3) {
            h(this.f25102a, path);
        } else if (i11 == 4) {
            b(this.f25102a, path);
        } else {
            if (i11 != 5) {
                return;
            }
            d(this.f25102a, path);
        }
    }

    public final void f(RectF rectF, Path path) {
        if (this.f25120s) {
            this.f25115n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f25112k / 2.0f);
        }
        path.moveTo(rectF.left + this.f25113l, rectF.top);
        path.lineTo((rectF.width() - this.f25113l) - this.f25112k, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f25113l;
        float f13 = this.f25112k;
        float f14 = rectF.top;
        path.arcTo(new RectF((f11 - f12) - f13, f14, f11 - f13, f12 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.f25112k, this.f25115n);
        path.lineTo(rectF.right, this.f25115n + (this.f25114m / 2.0f));
        path.lineTo(rectF.right - this.f25112k, this.f25115n + this.f25114m);
        path.lineTo(rectF.right - this.f25112k, rectF.bottom - this.f25113l);
        float f15 = rectF.right;
        float f16 = this.f25113l;
        float f17 = this.f25112k;
        float f18 = rectF.bottom;
        path.arcTo(new RectF((f15 - f16) - f17, f18 - f16, f15 - f17, f18), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f25112k, rectF.bottom);
        float f19 = rectF.left;
        float f21 = rectF.bottom;
        float f22 = this.f25113l;
        path.arcTo(new RectF(f19, f21 - f22, f22 + f19, f21), 90.0f, 90.0f);
        float f23 = rectF.left;
        float f24 = rectF.top;
        float f25 = this.f25113l;
        path.arcTo(new RectF(f23, f24, f25 + f23, f25 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void g() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.f25117p.getWidth(), getIntrinsicHeight() / this.f25117p.getHeight());
        RectF rectF = this.f25102a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f25105d.setLocalMatrix(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f25102a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f25102a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(RectF rectF, Path path) {
        if (this.f25120s) {
            this.f25115n = ((rectF.right - rectF.left) / 2.0f) - (this.f25112k / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.f25115n, this.f25113l), rectF.top + this.f25114m);
        path.lineTo(rectF.left + this.f25115n, rectF.top + this.f25114m);
        path.lineTo(rectF.left + (this.f25112k / 2.0f) + this.f25115n, rectF.top);
        path.lineTo(rectF.left + this.f25112k + this.f25115n, rectF.top + this.f25114m);
        path.lineTo(rectF.right - this.f25113l, rectF.top + this.f25114m);
        float f11 = rectF.right;
        float f12 = this.f25113l;
        float f13 = rectF.top;
        float f14 = this.f25114m;
        path.arcTo(new RectF(f11 - f12, f13 + f14, f11, f12 + f13 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f25113l);
        float f15 = rectF.right;
        float f16 = this.f25113l;
        float f17 = rectF.bottom;
        path.arcTo(new RectF(f15 - f16, f17 - f16, f15, f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f25113l, rectF.bottom);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f21 = this.f25113l;
        path.arcTo(new RectF(f18, f19 - f21, f21 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f25114m + this.f25113l);
        float f22 = rectF.left;
        float f23 = rectF.top;
        float f24 = this.f25114m;
        float f25 = this.f25113l;
        path.arcTo(new RectF(f22, f23 + f24, f25 + f22, f25 + f23 + f24), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f25121t = i11;
        this.f25106e.setAlpha(i11);
        this.f25107f.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f25106e.setColorFilter(colorFilter);
        this.f25107f.setColorFilter(colorFilter);
    }
}
