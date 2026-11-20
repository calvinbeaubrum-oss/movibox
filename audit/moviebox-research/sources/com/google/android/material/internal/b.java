package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final boolean f36978t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    @NonNull
    public static final Paint f36979u0 = null;
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public vi.a D;
    public vi.a E;

    @Nullable
    public CharSequence G;

    @Nullable
    public CharSequence H;
    public boolean I;
    public boolean K;

    @Nullable
    public Bitmap L;
    public Paint M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public float R;
    public int S;
    public int[] T;
    public boolean U;

    @NonNull
    public final TextPaint V;

    @NonNull
    public final TextPaint W;
    public TimeInterpolator X;
    public TimeInterpolator Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f36980a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f36981a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f36982b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f36983b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36984c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ColorStateList f36985c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f36986d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f36987d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f36988e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f36989e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36990f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f36991f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Rect f36992g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ColorStateList f36993g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Rect f36994h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f36995h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RectF f36996i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f36997i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f36999j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public StaticLayout f37001k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f37003l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f37005m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f37006n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f37007n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f37008o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public CharSequence f37009o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f37010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f37012q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f37014r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f37016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f37018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f37019u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f37020v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f37021w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f37022x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Typeface f37023y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Typeface f37024z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36998j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f37000k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f37002l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f37004m = 15.0f;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public boolean J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f37011p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f37013q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f37015r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f37017s0 = StaticLayoutBuilderCompat.f36952n;

    /* JADX INFO: compiled from: source.java */
    public class a implements vi.a.InterfaceC0876a {
        public a() {
        }

        @Override // vi.a.InterfaceC0876a
        public void a(Typeface typeface) {
            b.this.m0(typeface);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0385b implements vi.a.InterfaceC0876a {
        public C0385b() {
        }

        @Override // vi.a.InterfaceC0876a
        public void a(Typeface typeface) {
            b.this.x0(typeface);
        }
    }

    public b(View view) {
        this.f36980a = view;
        TextPaint textPaint = new TextPaint(TsExtractor.TS_STREAM_TYPE_AC3);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f36994h = new Rect();
        this.f36992g = new Rect();
        this.f36996i = new RectF();
        this.f36988e = e();
        Z(view.getContext().getResources().getConfiguration());
    }

    public static boolean T(float f11, float f12) {
        return Math.abs(f11 - f12) < 1.0E-5f;
    }

    public static float Y(float f11, float f12, float f13, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f13 = timeInterpolator.getInterpolation(f13);
        }
        return ii.b.a(f11, f12, f13);
    }

    public static int a(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb(Math.round((Color.alpha(i11) * f12) + (Color.alpha(i12) * f11)), Math.round((Color.red(i11) * f12) + (Color.red(i12) * f11)), Math.round((Color.green(i11) * f12) + (Color.green(i12) * f11)), Math.round((Color.blue(i11) * f12) + (Color.blue(i12) * f11)));
    }

    public static boolean d0(@NonNull Rect rect, int i11, int i12, int i13, int i14) {
        return rect.left == i11 && rect.top == i12 && rect.right == i13 && rect.bottom == i14;
    }

    public float A() {
        Q(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void A0(boolean z11) {
        this.f36984c = z11;
    }

    public int B() {
        return this.f36998j;
    }

    public void B0(float f11) {
        this.f36986d = f11;
        this.f36988e = e();
    }

    public float C() {
        Q(this.W);
        return -this.W.ascent();
    }

    @RequiresApi(23)
    public void C0(int i11) {
        this.f37017s0 = i11;
    }

    public float D() {
        return this.f37002l;
    }

    public final void D0(float f11) {
        h(f11);
        boolean z11 = f36978t0 && this.N != 1.0f;
        this.K = z11;
        if (z11) {
            n();
        }
        ViewCompat.postInvalidateOnAnimation(this.f36980a);
    }

    public Typeface E() {
        Typeface typeface = this.f37024z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @RequiresApi(23)
    public void E0(float f11) {
        this.f37013q0 = f11;
    }

    public float F() {
        return this.f36982b;
    }

    @RequiresApi(23)
    public void F0(float f11) {
        this.f37015r0 = f11;
    }

    public float G() {
        return this.f36988e;
    }

    public void G0(int i11) {
        if (i11 != this.f37011p0) {
            this.f37011p0 = i11;
            j();
            b0();
        }
    }

    @RequiresApi(23)
    public int H() {
        return this.f37017s0;
    }

    public void H0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        b0();
    }

    public int I() {
        StaticLayout staticLayout = this.f37001k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public void I0(boolean z11) {
        this.J = z11;
    }

    @RequiresApi(23)
    public float J() {
        return this.f37001k0.getSpacingAdd();
    }

    public final boolean J0(int[] iArr) {
        this.T = iArr;
        if (!W()) {
            return false;
        }
        b0();
        return true;
    }

    @RequiresApi(23)
    public float K() {
        return this.f37001k0.getSpacingMultiplier();
    }

    @RequiresApi(23)
    public void K0(@Nullable x xVar) {
        if (xVar != null) {
            c0(true);
        }
    }

    public int L() {
        return this.f37011p0;
    }

    public void L0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            b0();
        }
    }

    public final Layout.Alignment M() {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f36998j, this.I ? 1 : 0) & 7;
        if (absoluteGravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (absoluteGravity != 5) {
            return this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    public void M0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        b0();
    }

    @Nullable
    public TimeInterpolator N() {
        return this.X;
    }

    public void N0(@NonNull TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        b0();
    }

    @Nullable
    public CharSequence O() {
        return this.G;
    }

    public void O0(Typeface typeface) {
        boolean zN0 = n0(typeface);
        boolean zY0 = y0(typeface);
        if (zN0 || zY0) {
            b0();
        }
    }

    public final void P(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f37004m);
        textPaint.setTypeface(this.f37021w);
        textPaint.setLetterSpacing(this.f36995h0);
    }

    public final boolean P0() {
        return this.f37011p0 > 1 && (!this.I || this.f36984c) && !this.K;
    }

    public final void Q(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f37002l);
        textPaint.setTypeface(this.f37024z);
        textPaint.setLetterSpacing(this.f36997i0);
    }

    @NonNull
    public TextUtils.TruncateAt R() {
        return this.F;
    }

    public final void S(float f11) {
        if (this.f36984c) {
            this.f36996i.set(f11 < this.f36988e ? this.f36992g : this.f36994h);
            return;
        }
        this.f36996i.left = Y(this.f36992g.left, this.f36994h.left, f11, this.X);
        this.f36996i.top = Y(this.f37012q, this.f37014r, f11, this.X);
        this.f36996i.right = Y(this.f36992g.right, this.f36994h.right, f11, this.X);
        this.f36996i.bottom = Y(this.f36992g.bottom, this.f36994h.bottom, f11, this.X);
    }

    public final boolean U() {
        return ViewCompat.getLayoutDirection(this.f36980a) == 1;
    }

    public boolean V() {
        return this.J;
    }

    public final boolean W() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f37008o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f37006n) != null && colorStateList.isStateful());
    }

    public final boolean X(@NonNull CharSequence charSequence, boolean z11) {
        return (z11 ? androidx.core.text.u.f7878d : androidx.core.text.u.f7877c).a(charSequence, 0, charSequence.length());
    }

    public void Z(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f37023y;
            if (typeface != null) {
                this.f37022x = vi.i.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = vi.i.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f37022x;
            if (typeface3 == null) {
                typeface3 = this.f37023y;
            }
            this.f37021w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f37024z = typeface4;
            c0(true);
        }
    }

    public final float a0(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public final void b(boolean z11) {
        StaticLayout staticLayout;
        i(1.0f, z11);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f37001k0) != null) {
            this.f37009o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f37009o0;
        float fA0 = 0.0f;
        if (charSequence2 != null) {
            this.f37003l0 = a0(this.V, charSequence2);
        } else {
            this.f37003l0 = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f37000k, this.I ? 1 : 0);
        int i11 = absoluteGravity & 112;
        if (i11 == 48) {
            this.f37014r = this.f36994h.top;
        } else if (i11 != 80) {
            this.f37014r = this.f36994h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f37014r = this.f36994h.bottom + this.V.ascent();
        }
        int i12 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i12 == 1) {
            this.f37018t = this.f36994h.centerX() - (this.f37003l0 / 2.0f);
        } else if (i12 != 5) {
            this.f37018t = this.f36994h.left;
        } else {
            this.f37018t = this.f36994h.right - this.f37003l0;
        }
        i(0.0f, z11);
        StaticLayout staticLayout2 = this.f37001k0;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.f37001k0;
        if (staticLayout3 == null || this.f37011p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fA0 = a0(this.V, charSequence3);
            }
        } else {
            fA0 = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f37001k0;
        this.f37010p = staticLayout4 != null ? staticLayout4.getLineCount() : 0;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f36998j, this.I ? 1 : 0);
        int i13 = absoluteGravity2 & 112;
        if (i13 == 48) {
            this.f37012q = this.f36992g.top;
        } else if (i13 != 80) {
            this.f37012q = this.f36992g.centerY() - (height / 2.0f);
        } else {
            this.f37012q = (this.f36992g.bottom - height) + this.V.descent();
        }
        int i14 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i14 == 1) {
            this.f37016s = this.f36992g.centerX() - (fA0 / 2.0f);
        } else if (i14 != 5) {
            this.f37016s = this.f36992g.left;
        } else {
            this.f37016s = this.f36992g.right - fA0;
        }
        j();
        D0(this.f36982b);
    }

    public void b0() {
        c0(false);
    }

    public final void c() {
        g(this.f36982b);
    }

    public void c0(boolean z11) {
        if ((this.f36980a.getHeight() <= 0 || this.f36980a.getWidth() <= 0) && !z11) {
            return;
        }
        b(z11);
        c();
    }

    public final float d(float f11) {
        float f12 = this.f36988e;
        return f11 <= f12 ? ii.b.b(1.0f, 0.0f, this.f36986d, f12, f11) : ii.b.b(0.0f, 1.0f, f12, 1.0f, f11);
    }

    public final float e() {
        float f11 = this.f36986d;
        return f11 + ((1.0f - f11) * 0.5f);
    }

    public void e0(@Nullable ColorStateList colorStateList) {
        if (this.f37008o == colorStateList && this.f37006n == colorStateList) {
            return;
        }
        this.f37008o = colorStateList;
        this.f37006n = colorStateList;
        b0();
    }

    public final boolean f(@NonNull CharSequence charSequence) {
        boolean zU = U();
        return this.J ? X(charSequence, zU) : zU;
    }

    public void f0(int i11, int i12, int i13, int i14) {
        if (d0(this.f36994h, i11, i12, i13, i14)) {
            return;
        }
        this.f36994h.set(i11, i12, i13, i14);
        this.U = true;
    }

    public final void g(float f11) {
        float f12;
        S(f11);
        if (!this.f36984c) {
            this.f37019u = Y(this.f37016s, this.f37018t, f11, this.X);
            this.f37020v = Y(this.f37012q, this.f37014r, f11, this.X);
            D0(f11);
            f12 = f11;
        } else if (f11 < this.f36988e) {
            this.f37019u = this.f37016s;
            this.f37020v = this.f37012q;
            D0(0.0f);
            f12 = 0.0f;
        } else {
            this.f37019u = this.f37018t;
            this.f37020v = this.f37014r - Math.max(0, this.f36990f);
            D0(1.0f);
            f12 = 1.0f;
        }
        TimeInterpolator timeInterpolator = ii.b.f67202b;
        i0(1.0f - Y(0.0f, 1.0f, 1.0f - f11, timeInterpolator));
        t0(Y(1.0f, 0.0f, f11, timeInterpolator));
        if (this.f37008o != this.f37006n) {
            this.V.setColor(a(y(), w(), f12));
        } else {
            this.V.setColor(w());
        }
        int i11 = Build.VERSION.SDK_INT;
        float f13 = this.f36995h0;
        float f14 = this.f36997i0;
        if (f13 != f14) {
            this.V.setLetterSpacing(Y(f14, f13, f11, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f13);
        }
        this.P = Y(this.f36987d0, this.Z, f11, null);
        this.Q = Y(this.f36989e0, this.f36981a0, f11, null);
        this.R = Y(this.f36991f0, this.f36983b0, f11, null);
        int iA = a(x(this.f36993g0), x(this.f36985c0), f11);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.f36984c) {
            this.V.setAlpha((int) (d(f11) * this.V.getAlpha()));
            if (i11 >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, com.google.android.material.color.b.a(this.S, textPaint.getAlpha()));
            }
        }
        ViewCompat.postInvalidateOnAnimation(this.f36980a);
    }

    public void g0(@NonNull Rect rect) {
        f0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void h(float f11) {
        i(f11, false);
    }

    public void h0(int i11) {
        vi.e eVar = new vi.e(this.f36980a.getContext(), i11);
        if (eVar.i() != null) {
            this.f37008o = eVar.i();
        }
        if (eVar.j() != 0.0f) {
            this.f37004m = eVar.j();
        }
        ColorStateList colorStateList = eVar.f78897c;
        if (colorStateList != null) {
            this.f36985c0 = colorStateList;
        }
        this.f36981a0 = eVar.f78902h;
        this.f36983b0 = eVar.f78903i;
        this.Z = eVar.f78904j;
        this.f36995h0 = eVar.f78906l;
        vi.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new vi.a(new a(), eVar.e());
        eVar.h(this.f36980a.getContext(), this.E);
        b0();
    }

    public final void i(float f11, boolean z11) {
        float f12;
        float f13;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f36994h.width();
        float fWidth2 = this.f36992g.width();
        if (T(f11, 1.0f)) {
            f12 = this.f37004m;
            f13 = this.f36995h0;
            this.N = 1.0f;
            typeface = this.f37021w;
        } else {
            float f14 = this.f37002l;
            float f15 = this.f36997i0;
            Typeface typeface2 = this.f37024z;
            if (T(f11, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = Y(this.f37002l, this.f37004m, f11, this.Y) / this.f37002l;
            }
            float f16 = this.f37004m / this.f37002l;
            fWidth = (z11 || this.f36984c || fWidth2 * f16 <= fWidth) ? fWidth2 : Math.min(fWidth / f16, fWidth2);
            f12 = f14;
            f13 = f15;
            typeface = typeface2;
        }
        boolean z12 = false;
        if (fWidth > 0.0f) {
            boolean z13 = this.O != f12;
            boolean z14 = this.f36999j0 != f13;
            boolean z15 = this.C != typeface;
            StaticLayout staticLayout = this.f37001k0;
            boolean z16 = z13 || z14 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z15 || this.U;
            this.O = f12;
            this.f36999j0 = f13;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            z12 = z16;
        }
        if (this.H == null || z12) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f36999j0);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(P0() ? this.f37011p0 : 1, fWidth, this.I);
            this.f37001k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    public final void i0(float f11) {
        this.f37005m0 = f11;
        ViewCompat.postInvalidateOnAnimation(this.f36980a);
    }

    public final void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    public void j0(ColorStateList colorStateList) {
        if (this.f37008o != colorStateList) {
            this.f37008o = colorStateList;
            b0();
        }
    }

    public final StaticLayout k(int i11, float f11, boolean z11) {
        StaticLayout staticLayoutA = null;
        try {
            staticLayoutA = StaticLayoutBuilderCompat.c(this.G, this.V, (int) f11).e(this.F).h(z11).d(i11 == 1 ? Layout.Alignment.ALIGN_NORMAL : M()).g(false).j(i11).i(this.f37013q0, this.f37015r0).f(this.f37017s0).k(null).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e11) {
            Log.e("CollapsingTextHelper", e11.getCause().getMessage(), e11);
        }
        return (StaticLayout) androidx.core.util.i.g(staticLayoutA);
    }

    public void k0(int i11) {
        if (this.f37000k != i11) {
            this.f37000k = i11;
            b0();
        }
    }

    public void l(@NonNull Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || this.f36996i.width() <= 0.0f || this.f36996i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f11 = this.f37019u;
        float f12 = this.f37020v;
        boolean z11 = this.K && this.L != null;
        float f13 = this.N;
        if (f13 != 1.0f && !this.f36984c) {
            canvas.scale(f13, f13, f11, f12);
        }
        if (z11) {
            canvas.drawBitmap(this.L, f11, f12, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!P0() || (this.f36984c && this.f36982b <= this.f36988e)) {
            canvas.translate(f11, f12);
            this.f37001k0.draw(canvas);
        } else {
            m(canvas, this.f37019u - this.f37001k0.getLineStart(0), f12);
        }
        canvas.restoreToCount(iSave);
    }

    public void l0(float f11) {
        if (this.f37004m != f11) {
            this.f37004m = f11;
            b0();
        }
    }

    public final void m(@NonNull Canvas canvas, float f11, float f12) {
        int alpha = this.V.getAlpha();
        canvas.translate(f11, f12);
        if (!this.f36984c) {
            this.V.setAlpha((int) (this.f37007n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, com.google.android.material.color.b.a(this.S, textPaint.getAlpha()));
            }
            this.f37001k0.draw(canvas);
        }
        if (!this.f36984c) {
            this.V.setAlpha((int) (this.f37005m0 * alpha));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, com.google.android.material.color.b.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f37001k0.getLineBaseline(0);
        CharSequence charSequence = this.f37009o0;
        float f13 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.V);
        if (i11 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f36984c) {
            return;
        }
        String strTrim = this.f37009o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f37001k0.getLineEnd(0), str.length()), 0.0f, f13, (Paint) this.V);
    }

    public void m0(Typeface typeface) {
        if (n0(typeface)) {
            b0();
        }
    }

    public final void n() {
        if (this.L != null || this.f36992g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f37001k0.getWidth();
        int height = this.f37001k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f37001k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    public final boolean n0(Typeface typeface) {
        vi.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f37023y == typeface) {
            return false;
        }
        this.f37023y = typeface;
        Typeface typefaceB = vi.i.b(this.f36980a.getContext().getResources().getConfiguration(), typeface);
        this.f37022x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f37023y;
        }
        this.f37021w = typefaceB;
        return true;
    }

    public void o(@NonNull RectF rectF, int i11, int i12) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i11, i12), this.f36994h.left);
        rectF.top = this.f36994h.top;
        rectF.right = Math.min(t(rectF, i11, i12), this.f36994h.right);
        rectF.bottom = this.f36994h.top + r();
    }

    public void o0(int i11) {
        this.f36990f = i11;
    }

    public ColorStateList p() {
        return this.f37008o;
    }

    public void p0(int i11, int i12, int i13, int i14) {
        if (d0(this.f36992g, i11, i12, i13, i14)) {
            return;
        }
        this.f36992g.set(i11, i12, i13, i14);
        this.U = true;
    }

    public int q() {
        return this.f37000k;
    }

    public void q0(@NonNull Rect rect) {
        p0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float r() {
        P(this.W);
        return -this.W.ascent();
    }

    public void r0(float f11) {
        if (this.f36997i0 != f11) {
            this.f36997i0 = f11;
            b0();
        }
    }

    public final float s(int i11, int i12) {
        if (i12 == 17 || (i12 & 7) == 1) {
            return (i11 / 2.0f) - (this.f37003l0 / 2.0f);
        }
        if ((i12 & GravityCompat.END) == 8388613 || (i12 & 5) == 5) {
            return this.I ? this.f36994h.left : this.f36994h.right - this.f37003l0;
        }
        return this.I ? this.f36994h.right - this.f37003l0 : this.f36994h.left;
    }

    public void s0(int i11) {
        vi.e eVar = new vi.e(this.f36980a.getContext(), i11);
        if (eVar.i() != null) {
            this.f37006n = eVar.i();
        }
        if (eVar.j() != 0.0f) {
            this.f37002l = eVar.j();
        }
        ColorStateList colorStateList = eVar.f78897c;
        if (colorStateList != null) {
            this.f36993g0 = colorStateList;
        }
        this.f36989e0 = eVar.f78902h;
        this.f36991f0 = eVar.f78903i;
        this.f36987d0 = eVar.f78904j;
        this.f36997i0 = eVar.f78906l;
        vi.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        this.D = new vi.a(new C0385b(), eVar.e());
        eVar.h(this.f36980a.getContext(), this.D);
        b0();
    }

    public final float t(@NonNull RectF rectF, int i11, int i12) {
        if (i12 == 17 || (i12 & 7) == 1) {
            return (i11 / 2.0f) + (this.f37003l0 / 2.0f);
        }
        if ((i12 & GravityCompat.END) == 8388613 || (i12 & 5) == 5) {
            return this.I ? rectF.left + this.f37003l0 : this.f36994h.right;
        }
        return this.I ? this.f36994h.right : rectF.left + this.f37003l0;
    }

    public final void t0(float f11) {
        this.f37007n0 = f11;
        ViewCompat.postInvalidateOnAnimation(this.f36980a);
    }

    public float u() {
        return this.f37004m;
    }

    public void u0(ColorStateList colorStateList) {
        if (this.f37006n != colorStateList) {
            this.f37006n = colorStateList;
            b0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f37021w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(int i11) {
        if (this.f36998j != i11) {
            this.f36998j = i11;
            b0();
        }
    }

    public int w() {
        return x(this.f37008o);
    }

    public void w0(float f11) {
        if (this.f37002l != f11) {
            this.f37002l = f11;
            b0();
        }
    }

    public final int x(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void x0(Typeface typeface) {
        if (y0(typeface)) {
            b0();
        }
    }

    public final int y() {
        return x(this.f37006n);
    }

    public final boolean y0(Typeface typeface) {
        vi.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceB = vi.i.b(this.f36980a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.B;
        }
        this.f37024z = typefaceB;
        return true;
    }

    public int z() {
        return this.f37010p;
    }

    public void z0(float f11) {
        float fA = g3.a.a(f11, 0.0f, 1.0f);
        if (fA != this.f36982b) {
            this.f36982b = fA;
            c();
        }
    }
}
