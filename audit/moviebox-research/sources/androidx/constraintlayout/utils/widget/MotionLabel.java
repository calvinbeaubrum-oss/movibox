package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.GravityCompat;
import com.google.android.material.card.MaterialCardView;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionLabel extends View implements c {
    public static String W = "MotionLabel";
    public boolean A;
    public float B;
    public float C;
    public float D;
    public Drawable E;
    public Matrix F;
    public Bitmap G;
    public BitmapShader H;
    public Matrix I;
    public float J;
    public float K;
    public float L;
    public float M;
    public Paint N;
    public int O;
    public Rect P;
    public Paint Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextPaint f7221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f7222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7224d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f7228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f7229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f7230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f7231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f7234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f7237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f7238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f7239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f7242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Layout f7243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7244y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7245z;

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = MotionLabel.this.getWidth();
            int height = MotionLabel.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionLabel.this.f7226g) / 2.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f7227h);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.f7221a = new TextPaint();
        this.f7222b = new Path();
        this.f7223c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7224d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7225f = false;
        this.f7226g = 0.0f;
        this.f7227h = Float.NaN;
        this.f7230k = 48.0f;
        this.f7231l = Float.NaN;
        this.f7234o = 0.0f;
        this.f7235p = "Hello World";
        this.f7236q = true;
        this.f7237r = new Rect();
        this.f7238s = 1;
        this.f7239t = 1;
        this.f7240u = 1;
        this.f7241v = 1;
        this.f7244y = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.f7245z = 0;
        this.A = false;
        this.J = Float.NaN;
        this.K = Float.NaN;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = new Paint();
        this.O = 0;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        this.V = Float.NaN;
        f(context, null);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7221a = new TextPaint();
        this.f7222b = new Path();
        this.f7223c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7224d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7225f = false;
        this.f7226g = 0.0f;
        this.f7227h = Float.NaN;
        this.f7230k = 48.0f;
        this.f7231l = Float.NaN;
        this.f7234o = 0.0f;
        this.f7235p = "Hello World";
        this.f7236q = true;
        this.f7237r = new Rect();
        this.f7238s = 1;
        this.f7239t = 1;
        this.f7240u = 1;
        this.f7241v = 1;
        this.f7244y = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.f7245z = 0;
        this.A = false;
        this.J = Float.NaN;
        this.K = Float.NaN;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = new Paint();
        this.O = 0;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        this.V = Float.NaN;
        f(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7221a = new TextPaint();
        this.f7222b = new Path();
        this.f7223c = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7224d = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.f7225f = false;
        this.f7226g = 0.0f;
        this.f7227h = Float.NaN;
        this.f7230k = 48.0f;
        this.f7231l = Float.NaN;
        this.f7234o = 0.0f;
        this.f7235p = "Hello World";
        this.f7236q = true;
        this.f7237r = new Rect();
        this.f7238s = 1;
        this.f7239t = 1;
        this.f7240u = 1;
        this.f7241v = 1;
        this.f7244y = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        this.f7245z = 0;
        this.A = false;
        this.J = Float.NaN;
        this.K = Float.NaN;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = new Paint();
        this.O = 0;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        this.V = Float.NaN;
        f(context, attributeSet);
    }

    private float getHorizontalOffset() {
        float f11 = Float.isNaN(this.f7231l) ? 1.0f : this.f7230k / this.f7231l;
        TextPaint textPaint = this.f7221a;
        String str = this.f7235p;
        return (((((Float.isNaN(this.C) ? getMeasuredWidth() : this.C) - getPaddingLeft()) - getPaddingRight()) - (f11 * textPaint.measureText(str, 0, str.length()))) * (this.L + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f11 = Float.isNaN(this.f7231l) ? 1.0f : this.f7230k / this.f7231l;
        Paint.FontMetrics fontMetrics = this.f7221a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.D) ? getMeasuredHeight() : this.D) - getPaddingTop()) - getPaddingBottom();
        float f12 = fontMetrics.descent;
        float f13 = fontMetrics.ascent;
        return (((measuredHeight - ((f12 - f13) * f11)) * (1.0f - this.M)) / 2.0f) - (f11 * f13);
    }

    public final void c(float f11, float f12, float f13, float f14) {
        if (this.I == null) {
            return;
        }
        this.C = f13 - f11;
        this.D = f14 - f12;
        k();
    }

    public Bitmap d(Bitmap bitmap, int i11) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i12 = 0; i12 < i11 && width >= 32 && height >= 32; i12++) {
            width /= 2;
            height /= 2;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
        }
        return bitmapCreateScaledBitmap;
    }

    public void e(float f11) {
        if (this.f7225f || f11 != 1.0f) {
            this.f7222b.reset();
            String str = this.f7235p;
            int length = str.length();
            this.f7221a.getTextBounds(str, 0, length, this.f7237r);
            this.f7221a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f7222b);
            if (f11 != 1.0f) {
                Log.v(W, androidx.constraintlayout.motion.widget.a.a() + " scale " + f11);
                Matrix matrix = new Matrix();
                matrix.postScale(f11, f11);
                this.f7222b.transform(matrix);
            }
            Rect rect = this.f7237r;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f7236q = false;
        }
    }

    public final void f(Context context, AttributeSet attributeSet) {
        h(context, attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.f7242w = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.f7231l = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f7231l);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.f7230k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f7230k);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.f7232m = typedArrayObtainStyledAttributes.getInt(index, this.f7232m);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.f7233n = typedArrayObtainStyledAttributes.getInt(index, this.f7233n);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.f7223c = typedArrayObtainStyledAttributes.getColor(index, this.f7223c);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.f7227h);
                    this.f7227h = dimension;
                    setRound(dimension);
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f11 = typedArrayObtainStyledAttributes.getFloat(index, this.f7226g);
                    this.f7226g = f11;
                    setRoundPercent(f11);
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.f7245z = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.f7224d = typedArrayObtainStyledAttributes.getInt(index, this.f7224d);
                    this.f7225f = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.f7234o = typedArrayObtainStyledAttributes.getDimension(index, this.f7234o);
                    this.f7225f = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.E = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.f7225f = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.S = typedArrayObtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.M = typedArrayObtainStyledAttributes.getFloat(index, this.M);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.J = typedArrayObtainStyledAttributes.getDimension(index, this.J);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.K = typedArrayObtainStyledAttributes.getDimension(index, this.K);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.O = typedArrayObtainStyledAttributes.getInt(index, this.O);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        j();
        i();
    }

    public final void g(String str, int i11, int i12) {
        Typeface typefaceCreate;
        if (str != null) {
            typefaceCreate = Typeface.create(str, i12);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (i11 == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i11 == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i11 == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (i12 <= 0) {
            this.f7221a.setFakeBoldText(false);
            this.f7221a.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        } else {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(i12) : Typeface.create(typefaceCreate, i12);
            setTypeface(typefaceDefaultFromStyle);
            int i13 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i12;
            this.f7221a.setFakeBoldText((i13 & 1) != 0);
            this.f7221a.setTextSkewX((i13 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public float getRound() {
        return this.f7227h;
    }

    public float getRoundPercent() {
        return this.f7226g;
    }

    public float getScaleFromTextSize() {
        return this.f7231l;
    }

    public float getTextBackgroundPanX() {
        return this.S;
    }

    public float getTextBackgroundPanY() {
        return this.T;
    }

    public float getTextBackgroundRotate() {
        return this.V;
    }

    public float getTextBackgroundZoom() {
        return this.U;
    }

    public int getTextOutlineColor() {
        return this.f7224d;
    }

    public float getTextPanX() {
        return this.L;
    }

    public float getTextPanY() {
        return this.M;
    }

    public float getTextureHeight() {
        return this.J;
    }

    public float getTextureWidth() {
        return this.K;
    }

    public Typeface getTypeface() {
        return this.f7221a.getTypeface();
    }

    public final void h(Context context, @Nullable AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f7221a;
        int i11 = typedValue.data;
        this.f7223c = i11;
        textPaint.setColor(i11);
    }

    public void i() {
        this.f7238s = getPaddingLeft();
        this.f7239t = getPaddingRight();
        this.f7240u = getPaddingTop();
        this.f7241v = getPaddingBottom();
        g(this.f7242w, this.f7233n, this.f7232m);
        this.f7221a.setColor(this.f7223c);
        this.f7221a.setStrokeWidth(this.f7234o);
        this.f7221a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7221a.setFlags(128);
        setTextSize(this.f7230k);
        this.f7221a.setAntiAlias(true);
    }

    public final void j() {
        if (this.E != null) {
            this.I = new Matrix();
            int intrinsicWidth = this.E.getIntrinsicWidth();
            int intrinsicHeight = this.E.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.K) ? 128 : (int) this.K;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.J) ? 128 : (int) this.J;
            }
            if (this.O != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.G = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.G);
            this.E.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.E.setFilterBitmap(true);
            this.E.draw(canvas);
            if (this.O != 0) {
                this.G = d(this.G, 4);
            }
            Bitmap bitmap = this.G;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.H = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public final void k() {
        float f11 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f12 = Float.isNaN(this.T) ? 0.0f : this.T;
        float f13 = Float.isNaN(this.U) ? 1.0f : this.U;
        float f14 = Float.isNaN(this.V) ? 0.0f : this.V;
        this.I.reset();
        float width = this.G.getWidth();
        float height = this.G.getHeight();
        float f15 = Float.isNaN(this.K) ? this.C : this.K;
        float f16 = Float.isNaN(this.J) ? this.D : this.J;
        float f17 = f13 * (width * f16 < height * f15 ? f15 / width : f16 / height);
        this.I.postScale(f17, f17);
        float f18 = width * f17;
        float f19 = f15 - f18;
        float f21 = f17 * height;
        float f22 = f16 - f21;
        if (!Float.isNaN(this.J)) {
            f22 = this.J / 2.0f;
        }
        if (!Float.isNaN(this.K)) {
            f19 = this.K / 2.0f;
        }
        this.I.postTranslate((((f11 * f19) + f15) - f18) * 0.5f, (((f12 * f22) + f16) - f21) * 0.5f);
        this.I.postRotate(f14, f15 / 2.0f, f16 / 2.0f);
        this.H.setLocalMatrix(this.I);
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void layout(float f11, float f12, float f13, float f14) {
        int i11 = (int) (f11 + 0.5f);
        this.B = f11 - i11;
        int i12 = (int) (f13 + 0.5f);
        int i13 = i12 - i11;
        int i14 = (int) (f14 + 0.5f);
        int i15 = (int) (0.5f + f12);
        int i16 = i14 - i15;
        float f15 = f13 - f11;
        this.C = f15;
        float f16 = f14 - f12;
        this.D = f16;
        c(f11, f12, f13, f14);
        if (getMeasuredHeight() == i16 && getMeasuredWidth() == i13) {
            super.layout(i11, i15, i12, i14);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
            super.layout(i11, i15, i12, i14);
        }
        if (this.A) {
            if (this.P == null) {
                this.Q = new Paint();
                this.P = new Rect();
                this.Q.set(this.f7221a);
                this.R = this.Q.getTextSize();
            }
            this.C = f15;
            this.D = f16;
            Paint paint = this.Q;
            String str = this.f7235p;
            paint.getTextBounds(str, 0, str.length(), this.P);
            int iWidth = this.P.width();
            float fHeight = this.P.height() * 1.3f;
            float f17 = (f15 - this.f7239t) - this.f7238s;
            float f18 = (f16 - this.f7241v) - this.f7240u;
            float f19 = iWidth;
            if (f19 * f18 > fHeight * f17) {
                this.f7221a.setTextSize((this.R * f17) / f19);
            } else {
                this.f7221a.setTextSize((this.R * f18) / fHeight);
            }
            if (this.f7225f || !Float.isNaN(this.f7231l)) {
                e(Float.isNaN(this.f7231l) ? 1.0f : this.f7230k / this.f7231l);
            }
        }
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        boolean zIsNaN = Float.isNaN(this.f7231l);
        float f11 = zIsNaN ? 1.0f : this.f7230k / this.f7231l;
        this.C = i13 - i11;
        this.D = i14 - i12;
        if (this.A) {
            if (this.P == null) {
                this.Q = new Paint();
                this.P = new Rect();
                this.Q.set(this.f7221a);
                this.R = this.Q.getTextSize();
            }
            Paint paint = this.Q;
            String str = this.f7235p;
            paint.getTextBounds(str, 0, str.length(), this.P);
            int iWidth = this.P.width();
            int iHeight = (int) (this.P.height() * 1.3f);
            float f12 = (this.C - this.f7239t) - this.f7238s;
            float f13 = (this.D - this.f7241v) - this.f7240u;
            if (zIsNaN) {
                float f14 = iWidth;
                float f15 = iHeight;
                if (f14 * f13 > f15 * f12) {
                    this.f7221a.setTextSize((this.R * f12) / f14);
                } else {
                    this.f7221a.setTextSize((this.R * f13) / f15);
                }
            } else {
                float f16 = iWidth;
                float f17 = iHeight;
                f11 = f16 * f13 > f17 * f12 ? f12 / f16 : f13 / f17;
            }
        }
        if (this.f7225f || !zIsNaN) {
            c(i11, i12, i13, i14);
            e(f11);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f11 = Float.isNaN(this.f7231l) ? 1.0f : this.f7230k / this.f7231l;
        super.onDraw(canvas);
        if (!this.f7225f && f11 == 1.0f) {
            canvas.drawText(this.f7235p, this.B + this.f7238s + getHorizontalOffset(), this.f7240u + getVerticalOffset(), this.f7221a);
            return;
        }
        if (this.f7236q) {
            e(f11);
        }
        if (this.F == null) {
            this.F = new Matrix();
        }
        if (!this.f7225f) {
            float horizontalOffset = this.f7238s + getHorizontalOffset();
            float verticalOffset = this.f7240u + getVerticalOffset();
            this.F.reset();
            this.F.preTranslate(horizontalOffset, verticalOffset);
            this.f7222b.transform(this.F);
            this.f7221a.setColor(this.f7223c);
            this.f7221a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f7221a.setStrokeWidth(this.f7234o);
            canvas.drawPath(this.f7222b, this.f7221a);
            this.F.reset();
            this.F.preTranslate(-horizontalOffset, -verticalOffset);
            this.f7222b.transform(this.F);
            return;
        }
        this.N.set(this.f7221a);
        this.F.reset();
        float horizontalOffset2 = this.f7238s + getHorizontalOffset();
        float verticalOffset2 = this.f7240u + getVerticalOffset();
        this.F.postTranslate(horizontalOffset2, verticalOffset2);
        this.F.preScale(f11, f11);
        this.f7222b.transform(this.F);
        if (this.H != null) {
            this.f7221a.setFilterBitmap(true);
            this.f7221a.setShader(this.H);
        } else {
            this.f7221a.setColor(this.f7223c);
        }
        this.f7221a.setStyle(Paint.Style.FILL);
        this.f7221a.setStrokeWidth(this.f7234o);
        canvas.drawPath(this.f7222b, this.f7221a);
        if (this.H != null) {
            this.f7221a.setShader(null);
        }
        this.f7221a.setColor(this.f7224d);
        this.f7221a.setStyle(Paint.Style.STROKE);
        this.f7221a.setStrokeWidth(this.f7234o);
        canvas.drawPath(this.f7222b, this.f7221a);
        this.F.reset();
        this.F.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f7222b.transform(this.F);
        this.f7221a.set(this.N);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        this.A = false;
        this.f7238s = getPaddingLeft();
        this.f7239t = getPaddingRight();
        this.f7240u = getPaddingTop();
        this.f7241v = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f7221a;
            String str = this.f7235p;
            textPaint.getTextBounds(str, 0, str.length(), this.f7237r);
            if (mode != 1073741824) {
                size = (int) (this.f7237r.width() + 0.99999f);
            }
            size += this.f7238s + this.f7239t;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f7221a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f7240u + this.f7241v + fontMetricsInt;
            }
        } else if (this.f7245z != 0) {
            this.A = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i11) {
        if ((i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i11 |= GravityCompat.START;
        }
        if ((i11 & 112) == 0) {
            i11 |= 48;
        }
        if (i11 != this.f7244y) {
            invalidate();
        }
        this.f7244y = i11;
        int i12 = i11 & 112;
        if (i12 == 48) {
            this.M = -1.0f;
        } else if (i12 != 80) {
            this.M = 0.0f;
        } else {
            this.M = 1.0f;
        }
        int i13 = i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i13 != 3) {
            if (i13 != 5) {
                if (i13 != 8388611) {
                    if (i13 != 8388613) {
                        this.L = 0.0f;
                        return;
                    }
                }
            }
            this.L = 1.0f;
            return;
        }
        this.L = -1.0f;
    }

    @RequiresApi(21)
    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7227h = f11;
            float f12 = this.f7226g;
            this.f7226g = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7227h != f11;
        this.f7227h = f11;
        if (f11 != 0.0f) {
            if (this.f7222b == null) {
                this.f7222b = new Path();
            }
            if (this.f7229j == null) {
                this.f7229j = new RectF();
            }
            if (this.f7228i == null) {
                b bVar = new b();
                this.f7228i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7229j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7222b.reset();
            Path path = this.f7222b;
            RectF rectF = this.f7229j;
            float f13 = this.f7227h;
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
        boolean z11 = this.f7226g != f11;
        this.f7226g = f11;
        if (f11 != 0.0f) {
            if (this.f7222b == null) {
                this.f7222b = new Path();
            }
            if (this.f7229j == null) {
                this.f7229j = new RectF();
            }
            if (this.f7228i == null) {
                a aVar = new a();
                this.f7228i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f7226g) / 2.0f;
            this.f7229j.set(0.0f, 0.0f, width, height);
            this.f7222b.reset();
            this.f7222b.addRoundRect(this.f7229j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f11) {
        this.f7231l = f11;
    }

    public void setText(CharSequence charSequence) {
        this.f7235p = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f11) {
        this.S = f11;
        k();
        invalidate();
    }

    public void setTextBackgroundPanY(float f11) {
        this.T = f11;
        k();
        invalidate();
    }

    public void setTextBackgroundRotate(float f11) {
        this.V = f11;
        k();
        invalidate();
    }

    public void setTextBackgroundZoom(float f11) {
        this.U = f11;
        k();
        invalidate();
    }

    public void setTextFillColor(int i11) {
        this.f7223c = i11;
        invalidate();
    }

    public void setTextOutlineColor(int i11) {
        this.f7224d = i11;
        this.f7225f = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f11) {
        this.f7234o = f11;
        this.f7225f = true;
        if (Float.isNaN(f11)) {
            this.f7234o = 1.0f;
            this.f7225f = false;
        }
        invalidate();
    }

    public void setTextPanX(float f11) {
        this.L = f11;
        invalidate();
    }

    public void setTextPanY(float f11) {
        this.M = f11;
        invalidate();
    }

    public void setTextSize(float f11) {
        this.f7230k = f11;
        Log.v(W, androidx.constraintlayout.motion.widget.a.a() + "  " + f11 + " / " + this.f7231l);
        TextPaint textPaint = this.f7221a;
        if (!Float.isNaN(this.f7231l)) {
            f11 = this.f7231l;
        }
        textPaint.setTextSize(f11);
        e(Float.isNaN(this.f7231l) ? 1.0f : this.f7230k / this.f7231l);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f11) {
        this.J = f11;
        k();
        invalidate();
    }

    public void setTextureWidth(float f11) {
        this.K = f11;
        k();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f7221a.getTypeface() != typeface) {
            this.f7221a.setTypeface(typeface);
            if (this.f7243x != null) {
                this.f7243x = null;
                requestLayout();
                invalidate();
            }
        }
    }
}
