package com.tn.lib.view.bubbleview;

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
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f49681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f49682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f49683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitmapShader f49684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f49685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f49686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f49687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f49689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f49690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f49691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f49692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f49693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f49694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f49695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f49696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrowLocation f49697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BubbleType f49698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f49699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f49701u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f49702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f49703w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f49704x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f49705y;

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
        VERTICAL(0),
        HORIZONTAL(1),
        TOP_LEFT_BOTTOM_RIGHT(2),
        TOP_RIGHT_BOTTOM_LEFT(3),
        BOTTOM_LEFT_TOP_RIGHT(4),
        BOTTOM_RIGHT_TOP_LEFT(5);

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
        public static final /* synthetic */ int[] f49706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f49707b;

        static {
            int[] iArr = new int[BubbleType.values().length];
            f49707b = iArr;
            try {
                iArr[BubbleType.SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49707b[BubbleType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49707b[BubbleType.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ArrowLocation.values().length];
            f49706a = iArr2;
            try {
                iArr2[ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49706a[ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f49706a[ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f49706a[ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f49706a[ArrowLocation.NONE.ordinal()] = 5;
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
        public static float f49708u = 25.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static float f49709v = 25.0f;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static float f49710w = 20.0f;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static float f49711x = 50.0f;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static int f49712y = -65536;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static int f49713z = 255;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f49714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f49715b = A;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f49716c = B;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f49717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f49718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f49719f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f49720g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f49721h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f49722i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f49723j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f49724k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Bitmap f49725l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public BubbleType f49726m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ArrowLocation f49727n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f49728o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f49729p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f49730q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f49731r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f49732s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int[] f49733t;

        public b() {
            float f11 = C;
            this.f49717d = f11;
            this.f49718e = f11;
            this.f49719f = f49708u;
            this.f49720g = f49710w;
            this.f49721h = f49709v;
            this.f49722i = f49711x;
            this.f49723j = f49712y;
            this.f49724k = f49713z;
            this.f49726m = BubbleType.COLOR;
            this.f49727n = ArrowLocation.LEFT;
        }

        public BubbleDrawable A() {
            if (this.f49714a != null) {
                return new BubbleDrawable(this);
            }
            throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
        }

        public b B(RectF rectF) {
            this.f49714a = rectF;
            return this;
        }

        public b C(int i11) {
            this.f49716c = i11;
            return this;
        }

        public b D(float f11) {
            this.f49717d = f11;
            return this;
        }

        public b E(float f11) {
            this.f49718e = f11;
            return this;
        }

        public b F(float f11) {
            this.f49715b = f11;
            return this;
        }

        public b p(int i11) {
            this.f49724k = i11;
            return this;
        }

        public b q(float f11) {
            this.f49720g = f11 * 2.0f;
            return this;
        }

        public b r(boolean z11) {
            this.f49728o = z11;
            return this;
        }

        public b s(float f11) {
            this.f49721h = f11;
            return this;
        }

        public b t(ArrowLocation arrowLocation) {
            this.f49727n = arrowLocation;
            return this;
        }

        public b u(float f11) {
            this.f49722i = f11;
            return this;
        }

        public b v(float f11) {
            this.f49719f = f11;
            return this;
        }

        public b w(Bitmap bitmap) {
            this.f49725l = bitmap;
            z(BubbleType.BITMAP);
            return this;
        }

        public b x(int i11) {
            this.f49723j = i11;
            z(BubbleType.COLOR);
            return this;
        }

        public b y(float f11, float f12, float f13, float f14, @NonNull int[] iArr) {
            this.f49729p = f11;
            this.f49730q = f12;
            this.f49731r = f13;
            this.f49732s = f14;
            this.f49733t = iArr;
            z(BubbleType.SHADER);
            return this;
        }

        public b z(BubbleType bubbleType) {
            this.f49726m = bubbleType;
            return this;
        }
    }

    public BubbleDrawable(b bVar) {
        this.f49682b = new Path();
        this.f49683c = new Path();
        this.f49685e = new Paint(1);
        this.f49686f = new Paint();
        this.f49700t = 255;
        this.f49687g = bVar.f49715b;
        this.f49688h = bVar.f49716c;
        this.f49689i = bVar.f49717d;
        this.f49690j = bVar.f49718e;
        this.f49681a = bVar.f49714a;
        this.f49692l = bVar.f49720g;
        this.f49700t = bVar.f49724k;
        this.f49693m = bVar.f49721h;
        this.f49691k = bVar.f49719f;
        this.f49694n = bVar.f49722i;
        this.f49695o = bVar.f49723j;
        this.f49696p = bVar.f49725l;
        this.f49697q = bVar.f49727n;
        this.f49698r = bVar.f49726m;
        this.f49699s = bVar.f49728o;
        this.f49701u = bVar.f49729p;
        this.f49702v = bVar.f49730q;
        this.f49703w = bVar.f49731r;
        this.f49704x = bVar.f49732s;
        this.f49705y = bVar.f49733t;
    }

    public final void a(Canvas canvas) {
        int i11 = a.f49707b[this.f49698r.ordinal()];
        if (i11 == 1) {
            this.f49685e.setShader(new LinearGradient(this.f49701u, this.f49702v, this.f49703w, this.f49704x, this.f49705y, (float[]) null, Shader.TileMode.CLAMP));
        } else if (i11 == 2) {
            this.f49685e.setColor(this.f49695o);
        } else if (i11 == 3) {
            if (this.f49696p == null) {
                return;
            }
            if (this.f49684d == null) {
                Bitmap bitmap = this.f49696p;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f49684d = new BitmapShader(bitmap, tileMode, tileMode);
            }
            this.f49685e.setShader(this.f49684d);
            g();
        }
        e(this.f49697q, this.f49682b);
        if (this.f49687g > 0.0f) {
            this.f49686f.setColor(0);
            this.f49686f.setAlpha(Math.abs(this.f49700t));
            this.f49686f.setAntiAlias(true);
            this.f49686f.setShadowLayer(this.f49687g, this.f49689i, this.f49690j, this.f49688h);
            this.f49686f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
            canvas.drawPath(this.f49682b, this.f49686f);
        }
        canvas.drawPath(this.f49682b, this.f49685e);
    }

    public final void b(RectF rectF, Path path) {
        if (this.f49699s) {
            this.f49694n = ((rectF.right - rectF.left) / 2.0f) - (this.f49691k / 2.0f);
        }
        path.moveTo(rectF.left + this.f49692l, rectF.top);
        path.lineTo(rectF.width() - this.f49692l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f49692l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.f49693m) - this.f49692l);
        float f14 = rectF.right;
        float f15 = this.f49692l;
        float f16 = rectF.bottom;
        float f17 = this.f49693m;
        path.arcTo(new RectF(f14 - f15, (f16 - f15) - f17, f14, f16 - f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f49691k + this.f49694n, rectF.bottom - this.f49693m);
        path.lineTo(rectF.left + this.f49694n + (this.f49691k / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.f49694n, rectF.bottom - this.f49693m);
        path.lineTo(rectF.left + Math.min(this.f49692l, this.f49694n), rectF.bottom - this.f49693m);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f21 = this.f49692l;
        float f22 = this.f49693m;
        path.arcTo(new RectF(f18, (f19 - f21) - f22, f21 + f18, f19 - f22), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f49692l);
        float f23 = rectF.left;
        float f24 = rectF.top;
        float f25 = this.f49692l;
        path.arcTo(new RectF(f23, f24, f25 + f23, f25 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void c(RectF rectF, Path path) {
        if (this.f49699s) {
            this.f49694n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f49691k / 2.0f);
        }
        path.moveTo(this.f49691k + rectF.left + this.f49692l, rectF.top);
        path.lineTo(rectF.width() - this.f49692l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f49692l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f49692l);
        float f14 = rectF.right;
        float f15 = this.f49692l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f49691k + this.f49692l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = this.f49691k;
        float f19 = rectF.bottom;
        float f21 = this.f49692l;
        path.arcTo(new RectF(f17 + f18, f19 - f21, f21 + f17 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.f49691k, this.f49693m + this.f49694n);
        path.lineTo(rectF.left, this.f49694n + (this.f49693m / 2.0f));
        path.lineTo(rectF.left + this.f49691k, this.f49694n);
        path.lineTo(rectF.left + this.f49691k, rectF.top + this.f49692l);
        float f22 = rectF.left;
        float f23 = this.f49691k;
        float f24 = rectF.top;
        float f25 = this.f49692l;
        path.arcTo(new RectF(f22 + f23, f24, f22 + f25 + f23, f25 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void d(RectF rectF, Path path) {
        if (this.f49699s) {
            this.f49694n = ((rectF.right - rectF.left) / 2.0f) - (this.f49691k / 2.0f);
        }
        path.moveTo(rectF.left + this.f49692l, rectF.top);
        path.lineTo(rectF.width() - this.f49692l, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f49692l;
        float f13 = rectF.top;
        path.arcTo(new RectF(f11 - f12, f13, f11, f12 + f13), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f49692l);
        float f14 = rectF.right;
        float f15 = this.f49692l;
        float f16 = rectF.bottom;
        path.arcTo(new RectF(f14 - f15, f16 - f15, f14, f16), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f49692l, rectF.bottom);
        float f17 = rectF.left;
        float f18 = rectF.bottom;
        float f19 = this.f49692l;
        path.arcTo(new RectF(f17, f18 - f19, f19 + f17, f18), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f49692l);
        float f21 = rectF.left;
        float f22 = rectF.top;
        float f23 = this.f49692l;
        path.arcTo(new RectF(f21, f22, f23 + f21, f23 + f22), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    public final void e(ArrowLocation arrowLocation, Path path) {
        int i11 = a.f49706a[arrowLocation.ordinal()];
        if (i11 == 1) {
            c(this.f49681a, path);
            return;
        }
        if (i11 == 2) {
            f(this.f49681a, path);
            return;
        }
        if (i11 == 3) {
            h(this.f49681a, path);
        } else if (i11 == 4) {
            b(this.f49681a, path);
        } else {
            if (i11 != 5) {
                return;
            }
            d(this.f49681a, path);
        }
    }

    public final void f(RectF rectF, Path path) {
        if (this.f49699s) {
            this.f49694n = ((rectF.bottom - rectF.top) / 2.0f) - (this.f49691k / 2.0f);
        }
        path.moveTo(rectF.left + this.f49692l, rectF.top);
        path.lineTo((rectF.width() - this.f49692l) - this.f49691k, rectF.top);
        float f11 = rectF.right;
        float f12 = this.f49692l;
        float f13 = this.f49691k;
        float f14 = rectF.top;
        path.arcTo(new RectF((f11 - f12) - f13, f14, f11 - f13, f12 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.f49691k, this.f49694n);
        path.lineTo(rectF.right, this.f49694n + (this.f49693m / 2.0f));
        path.lineTo(rectF.right - this.f49691k, this.f49694n + this.f49693m);
        path.lineTo(rectF.right - this.f49691k, rectF.bottom - this.f49692l);
        float f15 = rectF.right;
        float f16 = this.f49692l;
        float f17 = this.f49691k;
        float f18 = rectF.bottom;
        path.arcTo(new RectF((f15 - f16) - f17, f18 - f16, f15 - f17, f18), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f49691k, rectF.bottom);
        float f19 = rectF.left;
        float f21 = rectF.bottom;
        float f22 = this.f49692l;
        path.arcTo(new RectF(f19, f21 - f22, f22 + f19, f21), 90.0f, 90.0f);
        float f23 = rectF.left;
        float f24 = rectF.top;
        float f25 = this.f49692l;
        path.arcTo(new RectF(f23, f24, f25 + f23, f25 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void g() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.f49696p.getWidth(), getIntrinsicHeight() / this.f49696p.getHeight());
        RectF rectF = this.f49681a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.f49684d.setLocalMatrix(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f49681a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f49681a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(RectF rectF, Path path) {
        if (this.f49699s) {
            this.f49694n = ((rectF.right - rectF.left) / 2.0f) - (this.f49691k / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.f49694n, this.f49692l), rectF.top + this.f49693m);
        path.lineTo(rectF.left + this.f49694n, rectF.top + this.f49693m);
        path.lineTo(rectF.left + (this.f49691k / 2.0f) + this.f49694n, rectF.top);
        path.lineTo(rectF.left + this.f49691k + this.f49694n, rectF.top + this.f49693m);
        path.lineTo(rectF.right - this.f49692l, rectF.top + this.f49693m);
        float f11 = rectF.right;
        float f12 = this.f49692l;
        float f13 = rectF.top;
        float f14 = this.f49693m;
        path.arcTo(new RectF(f11 - f12, f13 + f14, f11, f12 + f13 + f14), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f49692l);
        float f15 = rectF.right;
        float f16 = this.f49692l;
        float f17 = rectF.bottom;
        path.arcTo(new RectF(f15 - f16, f17 - f16, f15, f17), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f49692l, rectF.bottom);
        float f18 = rectF.left;
        float f19 = rectF.bottom;
        float f21 = this.f49692l;
        path.arcTo(new RectF(f18, f19 - f21, f21 + f18, f19), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f49693m + this.f49692l);
        float f22 = rectF.left;
        float f23 = rectF.top;
        float f24 = this.f49693m;
        float f25 = this.f49692l;
        path.arcTo(new RectF(f22, f23 + f24, f25 + f22, f25 + f23 + f24), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f49700t = i11;
        this.f49685e.setAlpha(i11);
        this.f49686f.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f49685e.setColorFilter(colorFilter);
        this.f49686f.setColorFilter(colorFilter);
    }
}
