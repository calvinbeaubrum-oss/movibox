package com.warkiz.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class IndicatorSeekBar extends View {
    public boolean A;
    public int A0;
    public float[] B;
    public int B0;
    public boolean C;
    public Drawable C0;
    public boolean D;
    public Bitmap D0;
    public boolean E;
    public int E0;
    public int F;
    public boolean F0;
    public String[] G;
    public float G0;
    public float[] H;
    public int H0;
    public float[] I;
    public boolean I0;
    public float J;
    public boolean J0;
    public int K;
    public Typeface L;
    public int M;
    public int N;
    public int O;
    public CharSequence[] P;
    public d Q;
    public int R;
    public int S;
    public boolean T;
    public int U;
    public View V;
    public View W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f62672a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f62673a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f62674b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f62675b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextPaint f62676c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float[] f62677c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f62678d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f62679d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f62680e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f62681f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f62682f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f62683g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f62684g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f62685h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public Bitmap f62686h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f62687i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Bitmap f62688i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f62689j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Drawable f62690j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f62691k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f62692k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f62693l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f62694l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f62695m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f62696m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f62697n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f62698n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f62699o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f62700o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f62701p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RectF f62702p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f62703q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public RectF f62704q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f62705r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f62706r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f62707s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f62708s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f62709t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f62710t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f62711u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f62712u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f62713v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int[] f62714v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f62715w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f62716w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f62717x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public float f62718x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f62719y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public float f62720y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f62721z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Bitmap f62722z0;

    /* JADX INFO: compiled from: source.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f62723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f62724b;

        public a(float f11, int i11) {
            this.f62723a = f11;
            this.f62724b = i11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IndicatorSeekBar indicatorSeekBar = IndicatorSeekBar.this;
            indicatorSeekBar.f62685h = indicatorSeekBar.f62713v;
            if (this.f62723a - IndicatorSeekBar.this.B[this.f62724b] > 0.0f) {
                IndicatorSeekBar.this.f62713v = this.f62723a - ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else {
                IndicatorSeekBar.this.f62713v = this.f62723a + ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            IndicatorSeekBar indicatorSeekBar2 = IndicatorSeekBar.this;
            indicatorSeekBar2.X(indicatorSeekBar2.f62713v);
            IndicatorSeekBar.this.setSeekListener(false);
            if (IndicatorSeekBar.this.Q != null && IndicatorSeekBar.this.T) {
                IndicatorSeekBar.this.Q.j();
                IndicatorSeekBar.this.a0();
            }
            IndicatorSeekBar.this.invalidate();
        }
    }

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62687i = -1.0f;
        this.f62689j = -1.0f;
        this.f62717x = 1;
        this.f62672a = context;
        A(context, attributeSet);
        D();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f62687i = -1.0f;
        this.f62689j = -1.0f;
        this.f62717x = 1;
        this.f62672a = context;
        A(context, attributeSet);
        D();
    }

    private float getAmplitude() {
        float f11 = this.f62709t;
        float f12 = this.f62711u;
        if (f11 - f12 > 0.0f) {
            return f11 - f12;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        float fAbs = Math.abs(this.f62709t - this.f62711u);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            float[] fArr = this.B;
            if (i11 >= fArr.length) {
                return i12;
            }
            float fAbs2 = Math.abs(fArr[i11] - this.f62713v);
            if (fAbs2 <= fAbs) {
                i12 = i11;
                fAbs = fAbs2;
            }
            i11++;
        }
    }

    private int getLeftSideTickColor() {
        return this.C ? this.f62680e0 : this.f62682f0;
    }

    private int getLeftSideTickTextsColor() {
        return this.C ? this.N : this.M;
    }

    private int getLeftSideTrackSize() {
        return this.C ? this.f62706r0 : this.f62708s0;
    }

    private int getRightSideTickColor() {
        return this.C ? this.f62682f0 : this.f62680e0;
    }

    private int getRightSideTickTextsColor() {
        return this.C ? this.M : this.N;
    }

    private int getRightSideTrackSize() {
        return this.C ? this.f62708s0 : this.f62706r0;
    }

    private float getThumbCenterX() {
        return this.C ? this.f62704q0.right : this.f62702p0.right;
    }

    private int getThumbPosOnTick() {
        if (this.f62679d0 != 0) {
            return Math.round((getThumbCenterX() - this.f62695m) / this.f62705r);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.f62679d0 != 0) {
            return (getThumbCenterX() - this.f62695m) / this.f62705r;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z11) {
        if (this.f62678d != null && U()) {
            this.f62678d.c(p(z11));
        }
    }

    public static com.warkiz.widget.a with(@NonNull Context context) {
        return new com.warkiz.widget.a(context);
    }

    public final void A(Context context, AttributeSet attributeSet) {
        com.warkiz.widget.a aVar = new com.warkiz.widget.a(context);
        if (attributeSet == null) {
            l(aVar);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndicatorSeekBar);
        this.f62709t = typedArrayObtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_max, aVar.f62727b);
        this.f62711u = typedArrayObtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_min, aVar.f62728c);
        this.f62713v = typedArrayObtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_progress, aVar.f62729d);
        this.f62715w = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_progress_value_float, aVar.f62730e);
        this.f62719y = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_user_seekable, aVar.f62733h);
        this.f62691k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_clear_default_padding, aVar.f62735j);
        this.f62721z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_only_thumb_draggable, aVar.f62734i);
        this.A = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_seek_smoothly, aVar.f62731f);
        this.C = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_r2l, aVar.f62732g);
        this.f62706r0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_track_background_size, aVar.f62742q);
        this.f62708s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_track_progress_size, aVar.f62744s);
        this.f62710t0 = typedArrayObtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_track_background_color, aVar.f62743r);
        this.f62712u0 = typedArrayObtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_track_progress_color, aVar.f62745t);
        this.f62700o0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_track_rounded_corners, aVar.f62746u);
        this.B0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_thumb_size, aVar.f62749x);
        this.C0 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.J0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        L(typedArrayObtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_thumb_color), aVar.f62750y);
        this.F0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_show_thumb_text, aVar.f62748w);
        this.H0 = typedArrayObtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_thumb_text_color, aVar.f62747v);
        this.f62679d0 = typedArrayObtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_ticks_count, aVar.H);
        this.f62692k0 = typedArrayObtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_show_tick_marks_type, aVar.I);
        this.f62698n0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_tick_marks_size, aVar.K);
        N(typedArrayObtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_tick_marks_color), aVar.J);
        this.f62690j0 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.IndicatorSeekBar_isb_tick_marks_drawable);
        this.f62696m0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.N);
        this.f62694l0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.M);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_show_tick_texts, aVar.B);
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_tick_texts_size, aVar.D);
        O(typedArrayObtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_tick_texts_color), aVar.C);
        this.P = typedArrayObtainStyledAttributes.getTextArray(R$styleable.IndicatorSeekBar_isb_tick_texts_array);
        J(typedArrayObtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.F);
        this.f62673a0 = typedArrayObtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_show_indicator, aVar.f62736k);
        this.R = typedArrayObtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_indicator_color, aVar.f62737l);
        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_indicator_text_size, aVar.f62739n);
        this.S = typedArrayObtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_indicator_text_color, aVar.f62738m);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.V = View.inflate(this.f62672a, resourceId, null);
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.W = View.inflate(this.f62672a, resourceId2, null);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void B() {
        if (this.f62691k) {
            return;
        }
        int iA = g.a(this.f62672a, 16.0f);
        if (getPaddingLeft() == 0) {
            setPadding(iA, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            setPadding(getPaddingLeft(), getPaddingTop(), iA, getPaddingBottom());
        }
    }

    public final void C() {
        int i11 = this.f62673a0;
        if (i11 != 0 && this.Q == null) {
            d dVar = new d(this.f62672a, this, this.R, i11, this.U, this.S, this.V, this.W);
            this.Q = dVar;
            this.V = dVar.d();
        }
    }

    public final void D() {
        E();
        int i11 = this.f62706r0;
        int i12 = this.f62708s0;
        if (i11 > i12) {
            this.f62706r0 = i12;
        }
        if (this.C0 == null) {
            float f11 = this.B0 / 2.0f;
            this.f62718x0 = f11;
            this.f62720y0 = f11 * 1.2f;
        } else {
            float fMin = Math.min(g.a(this.f62672a, 30.0f), this.B0) / 2.0f;
            this.f62718x0 = fMin;
            this.f62720y0 = fMin;
        }
        if (this.f62690j0 == null) {
            this.f62684g0 = this.f62698n0 / 2.0f;
        } else {
            this.f62684g0 = Math.min(g.a(this.f62672a, 30.0f), this.f62698n0) / 2.0f;
        }
        this.f62683g = Math.max(this.f62720y0, this.f62684g0) * 2.0f;
        G();
        S();
        this.f62685h = this.f62713v;
        q();
        this.f62702p0 = new RectF();
        this.f62704q0 = new RectF();
        B();
        C();
    }

    public final void E() {
        float f11 = this.f62709t;
        float f12 = this.f62711u;
        if (f11 < f12) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.f62713v < f12) {
            this.f62713v = f12;
        }
        if (this.f62713v > f11) {
            this.f62713v = f11;
        }
    }

    public final void F() {
        this.f62699o = getMeasuredWidth();
        this.f62695m = getPaddingStart();
        this.f62697n = getPaddingEnd();
        this.f62701p = getPaddingTop();
        float f11 = (this.f62699o - this.f62695m) - this.f62697n;
        this.f62703q = f11;
        int i11 = this.f62679d0;
        this.f62705r = f11 / (i11 + (-1) > 0 ? i11 - 1 : 1);
    }

    public final void G() {
        if (this.f62674b == null) {
            this.f62674b = new Paint();
        }
        if (this.f62700o0) {
            this.f62674b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.f62674b.setAntiAlias(true);
        int i11 = this.f62706r0;
        if (i11 > this.f62708s0) {
            this.f62708s0 = i11;
        }
    }

    public final void H() {
        if (this.f62676c == null) {
            TextPaint textPaint = new TextPaint();
            this.f62676c = textPaint;
            textPaint.setAntiAlias(true);
            this.f62676c.setTextAlign(Paint.Align.CENTER);
            this.f62676c.setTextSize(this.K);
        }
        if (this.f62681f == null) {
            this.f62681f = new Rect();
        }
    }

    public final void I() {
        int i11 = this.f62679d0;
        if (i11 == 0) {
            return;
        }
        if (this.D) {
            this.G = new String[i11];
        }
        for (int i12 = 0; i12 < this.f62677c0.length; i12++) {
            if (this.D) {
                this.G[i12] = z(i12);
                TextPaint textPaint = this.f62676c;
                String str = this.G[i12];
                textPaint.getTextBounds(str, 0, str.length(), this.f62681f);
                this.H[i12] = this.f62681f.width();
                this.I[i12] = this.f62695m + (this.f62705r * i12);
            }
            this.f62677c0[i12] = this.f62695m + (this.f62705r * i12);
        }
    }

    public final void J(int i11, Typeface typeface) {
        if (i11 == 0) {
            this.L = Typeface.DEFAULT;
            return;
        }
        if (i11 == 1) {
            this.L = Typeface.MONOSPACE;
            return;
        }
        if (i11 == 2) {
            this.L = Typeface.SANS_SERIF;
            return;
        }
        if (i11 == 3) {
            this.L = Typeface.SERIF;
        } else if (typeface == null) {
            this.L = Typeface.DEFAULT;
        } else {
            this.L = typeface;
        }
    }

    public final void K() {
        Drawable drawable = this.C0;
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap bitmapW = w(drawable, true);
            this.f62722z0 = bitmapW;
            this.D0 = bitmapW;
            return;
        }
        try {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            Class<?> cls = stateListDrawable.getClass();
            int iIntValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
            if (iIntValue != 2) {
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            }
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i11 = 0; i11 < iIntValue; i11++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i11));
                if (iArr.length <= 0) {
                    this.f62722z0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), true);
                } else {
                    if (iArr[0] != 16842919) {
                        throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                    }
                    this.D0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), true);
                }
            }
        } catch (Exception unused) {
            Bitmap bitmapW2 = w(this.C0, true);
            this.f62722z0 = bitmapW2;
            this.D0 = bitmapW2;
        }
    }

    public final void L(ColorStateList colorStateList, int i11) {
        if (colorStateList == null) {
            this.A0 = i11;
            this.E0 = i11;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i12 = iArr2[0];
                this.A0 = i12;
                this.E0 = i12;
            } else {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int[] iArr3 = iArr[i13];
                    if (iArr3.length == 0) {
                        this.E0 = iArr2[i13];
                    } else {
                        if (iArr3[0] != 16842919) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                        }
                        this.A0 = iArr2[i13];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    public final void M() {
        Drawable drawable = this.f62690j0;
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap bitmapW = w(drawable, false);
            this.f62686h0 = bitmapW;
            this.f62688i0 = bitmapW;
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        try {
            Class<?> cls = stateListDrawable.getClass();
            int iIntValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
            if (iIntValue != 2) {
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            }
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i11 = 0; i11 < iIntValue; i11++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i11));
                if (iArr.length <= 0) {
                    this.f62686h0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), false);
                } else {
                    if (iArr[0] != 16842913) {
                        throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                    }
                    this.f62688i0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i11)), false);
                }
            }
        } catch (Exception unused) {
            Bitmap bitmapW2 = w(this.f62690j0, false);
            this.f62686h0 = bitmapW2;
            this.f62688i0 = bitmapW2;
        }
    }

    public final void N(ColorStateList colorStateList, int i11) {
        if (colorStateList == null) {
            this.f62682f0 = i11;
            this.f62680e0 = i11;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i12 = iArr2[0];
                this.f62682f0 = i12;
                this.f62680e0 = i12;
            } else {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int[] iArr3 = iArr[i13];
                    if (iArr3.length == 0) {
                        this.f62680e0 = iArr2[i13];
                    } else {
                        if (iArr3[0] != 16842913) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                        }
                        this.f62682f0 = iArr2[i13];
                    }
                }
            }
        } catch (Exception e11) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e11.getMessage());
        }
    }

    public final void O(ColorStateList colorStateList, int i11) {
        if (colorStateList == null) {
            this.N = i11;
            this.M = i11;
            this.O = i11;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i12 = iArr2[0];
                this.N = i12;
                this.M = i12;
                this.O = i12;
                return;
            }
            if (iArr.length != 3) {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
            }
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int[] iArr3 = iArr[i13];
                if (iArr3.length == 0) {
                    this.N = iArr2[i13];
                } else {
                    int i14 = iArr3[0];
                    if (i14 == 16842913) {
                        this.M = iArr2[i13];
                    } else {
                        if (i14 != 16843623) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                        }
                        this.O = iArr2[i13];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    public final void P() {
        if (!this.C) {
            RectF rectF = this.f62702p0;
            rectF.left = this.f62695m;
            rectF.top = this.f62701p + this.f62720y0;
            rectF.right = (((this.f62713v - this.f62711u) * this.f62703q) / getAmplitude()) + this.f62695m;
            RectF rectF2 = this.f62702p0;
            float f11 = rectF2.top;
            rectF2.bottom = f11;
            RectF rectF3 = this.f62704q0;
            rectF3.left = rectF2.right;
            rectF3.top = f11;
            rectF3.right = this.f62699o - this.f62697n;
            rectF3.bottom = f11;
            return;
        }
        RectF rectF4 = this.f62704q0;
        int i11 = this.f62695m;
        rectF4.left = i11;
        rectF4.top = this.f62701p + this.f62720y0;
        rectF4.right = i11 + (this.f62703q * (1.0f - ((this.f62713v - this.f62711u) / getAmplitude())));
        RectF rectF5 = this.f62704q0;
        float f12 = rectF5.top;
        rectF5.bottom = f12;
        RectF rectF6 = this.f62702p0;
        rectF6.left = rectF5.right;
        rectF6.top = f12;
        rectF6.right = this.f62699o - this.f62697n;
        rectF6.bottom = f12;
    }

    public final boolean Q(float f11, float f12) {
        if (this.f62687i == -1.0f) {
            this.f62687i = g.a(this.f62672a, 5.0f);
        }
        float f13 = this.f62695m;
        float f14 = this.f62687i;
        boolean z11 = f11 >= f13 - (f14 * 2.0f) && f11 <= ((float) (this.f62699o - this.f62697n)) + (2.0f * f14);
        float f15 = this.f62702p0.top;
        float f16 = this.f62720y0;
        return z11 && ((f12 > ((f15 - f16) - f14) ? 1 : (f12 == ((f15 - f16) - f14) ? 0 : -1)) >= 0 && (f12 > ((f15 + f16) + f14) ? 1 : (f12 == ((f15 + f16) + f14) ? 0 : -1)) <= 0);
    }

    public final boolean R(float f11) {
        X(this.f62713v);
        float f12 = this.C ? this.f62704q0.right : this.f62702p0.right;
        int i11 = this.B0;
        return f12 - (((float) i11) / 2.0f) <= f11 && f11 <= f12 + (((float) i11) / 2.0f);
    }

    public final void S() {
        if (T()) {
            H();
            this.f62676c.setTypeface(this.L);
            this.f62676c.getTextBounds("j", 0, 1, this.f62681f);
            this.F = this.f62681f.height() + g.a(this.f62672a, 3.0f);
        }
    }

    public final boolean T() {
        return this.F0 || (this.f62679d0 != 0 && this.D);
    }

    public final boolean U() {
        if (this.f62715w) {
            return this.f62685h != this.f62713v;
        }
        return Math.round(this.f62685h) != Math.round(this.f62713v);
    }

    public final void V(MotionEvent motionEvent) {
        X(n(o(k(motionEvent))));
        setSeekListener(true);
        invalidate();
        Z();
    }

    public final void W() {
        P();
        if (T()) {
            this.f62676c.getTextBounds("j", 0, 1, this.f62681f);
            float fRound = this.f62701p + this.f62683g + Math.round(this.f62681f.height() - this.f62676c.descent()) + g.a(this.f62672a, 3.0f);
            this.J = fRound;
            this.G0 = fRound;
        }
        if (this.f62677c0 == null) {
            return;
        }
        I();
        if (this.f62679d0 > 2) {
            float f11 = this.B[getClosestIndex()];
            this.f62713v = f11;
            this.f62685h = f11;
        }
        X(this.f62713v);
    }

    public final void X(float f11) {
        if (this.C) {
            this.f62704q0.right = this.f62695m + (this.f62703q * (1.0f - ((f11 - this.f62711u) / getAmplitude())));
            this.f62702p0.left = this.f62704q0.right;
            return;
        }
        this.f62702p0.right = (((f11 - this.f62711u) * this.f62703q) / getAmplitude()) + this.f62695m;
        this.f62704q0.left = this.f62702p0.right;
    }

    public void Y() {
        this.V.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.warkiz.widget.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.V.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.a0();
                IndicatorSeekBar.this.V.setVisibility(0);
            }
        }, 300L);
    }

    public final void Z() {
        if (this.T) {
            a0();
            return;
        }
        d dVar = this.Q;
        if (dVar == null) {
            return;
        }
        dVar.g();
        if (this.Q.i()) {
            this.Q.p(getThumbCenterX());
        } else {
            this.Q.o(getThumbCenterX());
        }
    }

    public final void a0() {
        d dVar;
        int i11;
        if (!this.T || (dVar = this.Q) == null) {
            return;
        }
        dVar.l(getIndicatorTextString());
        int thumbCenterX = 0;
        this.V.measure(0, 0);
        int measuredWidth = this.V.getMeasuredWidth();
        float thumbCenterX2 = getThumbCenterX();
        if (this.f62689j == -1.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) this.f62672a.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                this.f62689j = displayMetrics.widthPixels;
            }
        }
        float f11 = measuredWidth / 2;
        float f12 = f11 + thumbCenterX2;
        int i12 = this.f62699o;
        if (f12 > i12) {
            thumbCenterX = i12 - measuredWidth;
            i11 = (int) ((thumbCenterX2 - thumbCenterX) - f11);
        } else if (thumbCenterX2 - f11 < 0.0f) {
            i11 = -((int) (f11 - thumbCenterX2));
        } else {
            thumbCenterX = (int) (getThumbCenterX() - f11);
            i11 = 0;
        }
        this.Q.r(thumbCenterX);
        this.Q.q(i11);
    }

    public void customSectionTrackColor(@NonNull b bVar) {
        int i11 = this.f62679d0;
        int i12 = i11 + (-1) > 0 ? i11 - 1 : 1;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i13] = this.f62710t0;
        }
        this.f62716w0 = bVar.a(iArr);
        this.f62714v0 = iArr;
        invalidate();
    }

    public void customTickTexts(@NonNull String[] strArr) {
        this.P = strArr;
        if (this.G != null) {
            int i11 = 0;
            while (i11 < this.G.length) {
                String strValueOf = i11 < strArr.length ? String.valueOf(strArr[i11]) : "";
                int i12 = this.C ? (this.f62679d0 - 1) - i11 : i11;
                this.G[i12] = strValueOf;
                TextPaint textPaint = this.f62676c;
                if (textPaint != null && this.f62681f != null) {
                    textPaint.getTextBounds(strValueOf, 0, strValueOf.length(), this.f62681f);
                    this.H[i12] = this.f62681f.width();
                }
                i11++;
            }
            invalidate();
        }
    }

    public void customTickTextsTypeface(@NonNull Typeface typeface) {
        this.L = typeface;
        S();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public d getIndicator() {
        return this.Q;
    }

    public View getIndicatorContentView() {
        return this.V;
    }

    public String getIndicatorTextString() {
        String[] strArr;
        String str = this.f62675b0;
        if (str == null || !str.contains("${TICK_TEXT}")) {
            String str2 = this.f62675b0;
            if (str2 != null && str2.contains("${PROGRESS}")) {
                return this.f62675b0.replace("${PROGRESS}", y(this.f62713v));
            }
        } else if (this.f62679d0 > 2 && (strArr = this.G) != null) {
            return this.f62675b0.replace("${TICK_TEXT}", strArr[getThumbPosOnTick()]);
        }
        return y(this.f62713v);
    }

    public float getMax() {
        return this.f62709t;
    }

    public float getMin() {
        return this.f62711u;
    }

    public e getOnSeekChangeListener() {
        return this.f62678d;
    }

    public int getProgress() {
        return Math.round(this.f62713v);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.f62713v).setScale(this.f62717x, 4).floatValue();
    }

    public int getTickCount() {
        return this.f62679d0;
    }

    public void hideThumb(boolean z11) {
        this.I0 = z11;
        invalidate();
    }

    public void hideThumbText(boolean z11) {
        this.F0 = !z11;
        invalidate();
    }

    public final float k(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        int i11 = this.f62695m;
        if (x11 >= i11) {
            float x12 = motionEvent.getX();
            int i12 = this.f62699o;
            int i13 = this.f62697n;
            if (x12 <= i12 - i13) {
                return motionEvent.getX();
            }
            i11 = i12 - i13;
        }
        return i11;
    }

    public final void l(com.warkiz.widget.a aVar) {
        this.f62709t = aVar.f62727b;
        this.f62711u = aVar.f62728c;
        this.f62713v = aVar.f62729d;
        this.f62715w = aVar.f62730e;
        this.f62679d0 = aVar.H;
        this.A = aVar.f62731f;
        this.C = aVar.f62732g;
        this.f62719y = aVar.f62733h;
        this.f62691k = aVar.f62735j;
        this.f62721z = aVar.f62734i;
        this.f62673a0 = aVar.f62736k;
        this.R = aVar.f62737l;
        this.S = aVar.f62738m;
        this.U = aVar.f62739n;
        this.V = aVar.f62740o;
        this.W = aVar.f62741p;
        this.f62706r0 = aVar.f62742q;
        this.f62710t0 = aVar.f62743r;
        this.f62708s0 = aVar.f62744s;
        this.f62712u0 = aVar.f62745t;
        this.f62700o0 = aVar.f62746u;
        this.B0 = aVar.f62749x;
        this.C0 = aVar.A;
        this.H0 = aVar.f62747v;
        L(aVar.f62751z, aVar.f62750y);
        this.F0 = aVar.f62748w;
        this.f62692k0 = aVar.I;
        this.f62698n0 = aVar.K;
        this.f62690j0 = aVar.L;
        this.f62694l0 = aVar.M;
        this.f62696m0 = aVar.N;
        N(aVar.O, aVar.J);
        this.D = aVar.B;
        this.K = aVar.D;
        this.P = aVar.E;
        this.L = aVar.F;
        O(aVar.G, aVar.C);
    }

    public final boolean m() {
        if (this.f62679d0 < 3 || !this.A || !this.J0) {
            return false;
        }
        int closestIndex = getClosestIndex();
        float f11 = this.f62713v;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f11 - this.B[closestIndex]));
        valueAnimatorOfFloat.start();
        valueAnimatorOfFloat.addUpdateListener(new a(f11, closestIndex));
        return true;
    }

    public final float n(float f11) {
        this.f62685h = this.f62713v;
        float amplitude = this.f62711u + ((getAmplitude() * (f11 - this.f62695m)) / this.f62703q);
        this.f62713v = amplitude;
        return amplitude;
    }

    public final float o(float f11) {
        if (this.f62679d0 > 2 && !this.A) {
            f11 = this.f62695m + (this.f62705r * Math.round((f11 - this.f62695m) / this.f62705r));
        }
        return this.C ? (this.f62703q - f11) + (this.f62695m * 2) : f11;
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        v(canvas);
        t(canvas);
        u(canvas);
        r(canvas);
        s(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(View.resolveSize(g.a(this.f62672a, 170.0f), i11), Math.round(this.f62683g + getPaddingTop() + getPaddingBottom()) + this.F);
        F();
        W();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setProgress(bundle.getFloat("isb_progress"));
        super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.f62713v);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        post(new Runnable() { // from class: com.warkiz.widget.IndicatorSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                IndicatorSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0020  */
    /* JADX WARN: Code duplicated, block: B:18:0x0026  */
    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0036  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        d dVar;
        if (!this.f62719y || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            performClick();
            float x11 = motionEvent.getX();
            if (Q(x11, motionEvent.getY())) {
                if (this.f62721z && !R(x11)) {
                    return false;
                }
                this.f62707s = true;
                e eVar2 = this.f62678d;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
                V(motionEvent);
                return true;
            }
        } else if (action == 1) {
            this.f62707s = false;
            eVar = this.f62678d;
            if (eVar != null) {
                eVar.b(this);
            }
            if (!m()) {
                invalidate();
            }
            dVar = this.Q;
            if (dVar != null) {
                dVar.f();
            }
        } else if (action == 2) {
            V(motionEvent);
        } else if (action == 3) {
            this.f62707s = false;
            eVar = this.f62678d;
            if (eVar != null) {
                eVar.b(this);
            }
            if (!m()) {
                invalidate();
            }
            dVar = this.Q;
            if (dVar != null) {
                dVar.f();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final f p(boolean z11) {
        String[] strArr;
        if (this.f62693l == null) {
            this.f62693l = new f(this);
        }
        this.f62693l.f62770b = getProgress();
        this.f62693l.f62771c = getProgressFloat();
        this.f62693l.f62772d = z11;
        if (this.f62679d0 > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.D && (strArr = this.G) != null) {
                this.f62693l.f62774f = strArr[thumbPosOnTick];
            }
            if (this.C) {
                this.f62693l.f62773e = (this.f62679d0 - thumbPosOnTick) - 1;
            } else {
                this.f62693l.f62773e = thumbPosOnTick;
            }
        }
        return this.f62693l;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void q() {
        int i11 = this.f62679d0;
        if (i11 < 0 || i11 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.f62679d0);
        }
        if (i11 == 0) {
            return;
        }
        this.f62677c0 = new float[i11];
        if (this.D) {
            this.I = new float[i11];
            this.H = new float[i11];
        }
        this.B = new float[i11];
        int i12 = 0;
        while (true) {
            float[] fArr = this.B;
            if (i12 >= fArr.length) {
                return;
            }
            float f11 = this.f62711u;
            float f12 = i12 * (this.f62709t - f11);
            int i13 = this.f62679d0;
            fArr[i12] = f11 + (f12 / (i13 + (-1) > 0 ? i13 - 1 : 1));
            i12++;
        }
    }

    public final void r(Canvas canvas) {
        if (this.I0) {
            return;
        }
        float thumbCenterX = getThumbCenterX();
        if (this.C0 == null) {
            if (this.f62707s) {
                this.f62674b.setColor(this.E0);
            } else {
                this.f62674b.setColor(this.A0);
            }
            canvas.drawCircle(thumbCenterX, this.f62702p0.top, this.f62707s ? this.f62720y0 : this.f62718x0, this.f62674b);
            return;
        }
        if (this.f62722z0 == null || this.D0 == null) {
            K();
        }
        if (this.f62722z0 == null || this.D0 == null) {
            throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
        }
        this.f62674b.setAlpha(255);
        if (this.f62707s) {
            Bitmap bitmap = this.D0;
            canvas.drawBitmap(bitmap, thumbCenterX - (bitmap.getWidth() / 2.0f), this.f62702p0.top - (this.D0.getHeight() / 2.0f), this.f62674b);
        } else {
            Bitmap bitmap2 = this.f62722z0;
            canvas.drawBitmap(bitmap2, thumbCenterX - (bitmap2.getWidth() / 2.0f), this.f62702p0.top - (this.f62722z0.getHeight() / 2.0f), this.f62674b);
        }
    }

    public final void s(Canvas canvas) {
        if (this.F0) {
            if (!this.D || this.f62679d0 <= 2) {
                this.f62676c.setColor(this.H0);
                canvas.drawText(y(this.f62713v), getThumbCenterX(), this.G0, this.f62676c);
            }
        }
    }

    public void setDecimalScale(int i11) {
        this.f62717x = i11;
    }

    @Override // android.view.View
    public void setEnabled(boolean z11) {
        if (z11 == isEnabled()) {
            return;
        }
        super.setEnabled(z11);
        if (isEnabled()) {
            setAlpha(1.0f);
            if (this.T) {
                this.V.setAlpha(1.0f);
                return;
            }
            return;
        }
        setAlpha(0.3f);
        if (this.T) {
            this.V.setAlpha(0.3f);
        }
    }

    public void setIndicatorStayAlways(boolean z11) {
        this.T = z11;
    }

    public void setIndicatorTextFormat(String str) {
        this.f62675b0 = str;
        I();
        a0();
    }

    public synchronized void setMax(float f11) {
        this.f62709t = Math.max(this.f62711u, f11);
        E();
        q();
        W();
        invalidate();
        a0();
    }

    public synchronized void setMin(float f11) {
        this.f62711u = Math.min(this.f62709t, f11);
        E();
        q();
        W();
        invalidate();
        a0();
    }

    public void setOnSeekChangeListener(@NonNull e eVar) {
        this.f62678d = eVar;
    }

    public synchronized void setProgress(float f11) {
        try {
            this.f62685h = this.f62713v;
            float f12 = this.f62711u;
            if (f11 < f12) {
                f11 = f12;
            } else {
                f12 = this.f62709t;
                if (f11 > f12) {
                    f11 = f12;
                }
            }
            this.f62713v = f11;
            if (!this.A && this.f62679d0 > 2) {
                this.f62713v = this.B[getClosestIndex()];
            }
            setSeekListener(false);
            X(this.f62713v);
            postInvalidate();
            a0();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void setR2L(boolean z11) {
        this.C = z11;
        requestLayout();
        invalidate();
        a0();
    }

    public void setThumbAdjustAuto(boolean z11) {
        this.J0 = z11;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.C0 = null;
            this.f62722z0 = null;
            this.D0 = null;
        } else {
            this.C0 = drawable;
            float fMin = Math.min(g.a(this.f62672a, 30.0f), this.B0) / 2.0f;
            this.f62718x0 = fMin;
            this.f62720y0 = fMin;
            this.f62683g = Math.max(fMin, this.f62684g0) * 2.0f;
            K();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i11) {
        int i12 = this.f62679d0;
        if (i12 < 0 || i12 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.f62679d0);
        }
        this.f62679d0 = i11;
        q();
        I();
        F();
        W();
        invalidate();
        a0();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f62690j0 = null;
            this.f62686h0 = null;
            this.f62688i0 = null;
        } else {
            this.f62690j0 = drawable;
            float fMin = Math.min(g.a(this.f62672a, 30.0f), this.f62698n0) / 2.0f;
            this.f62684g0 = fMin;
            this.f62683g = Math.max(this.f62720y0, fMin) * 2.0f;
            M();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z11) {
        this.f62719y = z11;
    }

    public void showBothEndsTickTextsOnly(boolean z11) {
        this.E = z11;
    }

    public final void t(Canvas canvas) {
        Bitmap bitmap;
        if (this.f62679d0 != 0) {
            if (this.f62692k0 == 0 && this.f62690j0 == null) {
                return;
            }
            float thumbCenterX = getThumbCenterX();
            for (int i11 = 0; i11 < this.f62677c0.length; i11++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.f62696m0 || thumbCenterX < this.f62677c0[i11]) && ((!this.f62694l0 || (i11 != 0 && i11 != this.f62677c0.length - 1)) && (i11 != getThumbPosOnTick() || this.f62679d0 <= 2 || this.A))) {
                    float f11 = i11;
                    if (f11 <= thumbPosOnTickFloat) {
                        this.f62674b.setColor(getLeftSideTickColor());
                    } else {
                        this.f62674b.setColor(getRightSideTickColor());
                    }
                    if (this.f62690j0 != null) {
                        if (this.f62688i0 == null || this.f62686h0 == null) {
                            M();
                        }
                        Bitmap bitmap2 = this.f62688i0;
                        if (bitmap2 == null || (bitmap = this.f62686h0) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        }
                        if (f11 <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.f62677c0[i11] - (bitmap.getWidth() / 2.0f), this.f62702p0.top - (this.f62686h0.getHeight() / 2.0f), this.f62674b);
                        } else {
                            canvas.drawBitmap(bitmap, this.f62677c0[i11] - (bitmap.getWidth() / 2.0f), this.f62702p0.top - (this.f62686h0.getHeight() / 2.0f), this.f62674b);
                        }
                    } else {
                        int i12 = this.f62692k0;
                        if (i12 == 1) {
                            canvas.drawCircle(this.f62677c0[i11], this.f62702p0.top, this.f62684g0, this.f62674b);
                        } else if (i12 == 3) {
                            int iA = g.a(this.f62672a, 1.0f);
                            float leftSideTrackSize = thumbCenterX >= this.f62677c0[i11] ? getLeftSideTrackSize() : getRightSideTrackSize();
                            float f12 = this.f62677c0[i11];
                            float f13 = iA;
                            float f14 = this.f62702p0.top;
                            float f15 = leftSideTrackSize / 2.0f;
                            canvas.drawRect(f12 - f13, f14 - f15, f12 + f13, f14 + f15, this.f62674b);
                        } else if (i12 == 2) {
                            float f16 = this.f62677c0[i11];
                            int i13 = this.f62698n0;
                            float f17 = this.f62702p0.top;
                            canvas.drawRect(f16 - (i13 / 2.0f), f17 - (i13 / 2.0f), f16 + (i13 / 2.0f), f17 + (i13 / 2.0f), this.f62674b);
                        }
                    }
                }
            }
        }
    }

    public void thumbColor(int i11) {
        this.A0 = i11;
        this.E0 = i11;
        invalidate();
    }

    public void thumbColorStateList(@NonNull ColorStateList colorStateList) {
        L(colorStateList, this.A0);
        invalidate();
    }

    public void tickMarksColor(int i11) {
        this.f62682f0 = i11;
        this.f62680e0 = i11;
        invalidate();
    }

    public void tickMarksColor(@NonNull ColorStateList colorStateList) {
        N(colorStateList, this.f62682f0);
        invalidate();
    }

    public void tickTextsColor(int i11) {
        this.N = i11;
        this.M = i11;
        this.O = i11;
        invalidate();
    }

    public void tickTextsColorStateList(@NonNull ColorStateList colorStateList) {
        O(colorStateList, this.M);
        invalidate();
    }

    public final void u(Canvas canvas) {
        if (this.G == null) {
            return;
        }
        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
        int i11 = 0;
        while (true) {
            String[] strArr = this.G;
            if (i11 >= strArr.length) {
                return;
            }
            if (!this.E || i11 == 0 || i11 == strArr.length - 1) {
                if (i11 == getThumbPosOnTick() && i11 == thumbPosOnTickFloat) {
                    this.f62676c.setColor(this.O);
                } else if (i11 < thumbPosOnTickFloat) {
                    this.f62676c.setColor(getLeftSideTickTextsColor());
                } else {
                    this.f62676c.setColor(getRightSideTickTextsColor());
                }
                int length = this.C ? (this.G.length - i11) - 1 : i11;
                if (i11 == 0) {
                    canvas.drawText(this.G[length], this.I[i11] + (this.H[length] / 2.0f), this.J, this.f62676c);
                } else {
                    String[] strArr2 = this.G;
                    if (i11 == strArr2.length - 1) {
                        canvas.drawText(strArr2[length], this.I[i11] - (this.H[length] / 2.0f), this.J, this.f62676c);
                    } else {
                        canvas.drawText(strArr2[length], this.I[i11], this.J, this.f62676c);
                    }
                }
            }
            i11++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0078  */
    /* JADX WARN: Code duplicated, block: B:21:0x0083  */
    public final void v(Canvas canvas) {
        if (!this.f62716w0) {
            this.f62674b.setColor(this.f62712u0);
            this.f62674b.setStrokeWidth(this.f62708s0);
            RectF rectF = this.f62702p0;
            canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, this.f62674b);
            this.f62674b.setColor(this.f62710t0);
            this.f62674b.setStrokeWidth(this.f62706r0);
            RectF rectF2 = this.f62704q0;
            canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.f62674b);
            return;
        }
        int i11 = this.f62679d0;
        int i12 = i11 + (-1) > 0 ? i11 - 1 : 1;
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.C) {
                this.f62674b.setColor(this.f62714v0[(i12 - i13) - 1]);
            } else {
                this.f62674b.setColor(this.f62714v0[i13]);
            }
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            float f11 = i13;
            if (f11 < thumbPosOnTickFloat) {
                int i14 = i13 + 1;
                if (thumbPosOnTickFloat < i14) {
                    float thumbCenterX = getThumbCenterX();
                    this.f62674b.setStrokeWidth(getLeftSideTrackSize());
                    float f12 = this.f62677c0[i13];
                    RectF rectF3 = this.f62702p0;
                    canvas.drawLine(f12, rectF3.top, thumbCenterX, rectF3.bottom, this.f62674b);
                    this.f62674b.setStrokeWidth(getRightSideTrackSize());
                    RectF rectF4 = this.f62702p0;
                    canvas.drawLine(thumbCenterX, rectF4.top, this.f62677c0[i14], rectF4.bottom, this.f62674b);
                } else {
                    if (f11 < thumbPosOnTickFloat) {
                        this.f62674b.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.f62674b.setStrokeWidth(getRightSideTrackSize());
                    }
                    float[] fArr = this.f62677c0;
                    float f13 = fArr[i13];
                    RectF rectF5 = this.f62702p0;
                    canvas.drawLine(f13, rectF5.top, fArr[i13 + 1], rectF5.bottom, this.f62674b);
                }
            } else {
                if (f11 < thumbPosOnTickFloat) {
                    this.f62674b.setStrokeWidth(getLeftSideTrackSize());
                } else {
                    this.f62674b.setStrokeWidth(getRightSideTrackSize());
                }
                float[] fArr2 = this.f62677c0;
                float f14 = fArr2[i13];
                RectF rectF6 = this.f62702p0;
                canvas.drawLine(f14, rectF6.top, fArr2[i13 + 1], rectF6.bottom, this.f62674b);
            }
        }
    }

    public final Bitmap w(Drawable drawable, boolean z11) {
        int intrinsicHeight;
        if (drawable == null) {
            return null;
        }
        int iA = g.a(this.f62672a, 30.0f);
        if (drawable.getIntrinsicWidth() > iA) {
            int i11 = z11 ? this.B0 : this.f62698n0;
            intrinsicHeight = x(drawable, i11);
            if (i11 > iA) {
                intrinsicHeight = x(drawable, iA);
            } else {
                iA = i11;
            }
        } else {
            iA = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public final int x(Drawable drawable, int i11) {
        return Math.round(((i11 * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
    }

    public final String y(float f11) {
        return this.f62715w ? c.b(f11, this.f62717x) : String.valueOf(Math.round(f11));
    }

    public final String z(int i11) {
        CharSequence[] charSequenceArr = this.P;
        if (charSequenceArr == null) {
            return y(this.B[i11]);
        }
        return i11 < charSequenceArr.length ? String.valueOf(charSequenceArr[i11]) : "";
    }
}
