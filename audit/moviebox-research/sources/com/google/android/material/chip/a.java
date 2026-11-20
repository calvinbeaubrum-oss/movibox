package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.internal.y;
import com.tn.lib.view.FlowLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import oi.f;
import vi.d;
import vi.e;
import wi.b;
import yi.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends i implements Drawable.Callback, y.b {
    public static final int[] K0 = {R.attr.state_enabled};
    public static final ShapeDrawable L0 = new ShapeDrawable(new OvalShape());

    @Nullable
    public ColorStateList A;

    @Nullable
    public ColorStateList A0;

    @Nullable
    public ColorStateList B;

    @Nullable
    public PorterDuff.Mode B0;
    public float C;
    public int[] C0;
    public float D;
    public boolean D0;

    @Nullable
    public ColorStateList E;

    @Nullable
    public ColorStateList E0;
    public float F;

    @NonNull
    public WeakReference<InterfaceC0380a> F0;

    @Nullable
    public ColorStateList G;
    public TextUtils.TruncateAt G0;

    @Nullable
    public CharSequence H;
    public boolean H0;
    public boolean I;
    public int I0;

    @Nullable
    public Drawable J;
    public boolean J0;

    @Nullable
    public ColorStateList K;
    public float L;
    public boolean M;
    public boolean N;

    @Nullable
    public Drawable O;

    @Nullable
    public Drawable P;

    @Nullable
    public ColorStateList Q;
    public float R;

    @Nullable
    public CharSequence S;
    public boolean T;
    public boolean U;

    @Nullable
    public Drawable V;

    @Nullable
    public ColorStateList W;

    @Nullable
    public ii.i X;

    @Nullable
    public ii.i Y;
    public float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f36580a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f36581b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f36582c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f36583d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f36584e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f36585f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f36586g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    @NonNull
    public final Context f36587h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Paint f36588i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @Nullable
    public final Paint f36589j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Paint.FontMetrics f36590k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final RectF f36591l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final PointF f36592m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final Path f36593n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @NonNull
    public final y f36594o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f36595p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f36596q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f36597r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f36598s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f36599t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f36600u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f36601v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f36602w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f36603x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    @Nullable
    public ColorFilter f36604y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @Nullable
    public PorterDuffColorFilter f36605z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0380a {
        void onChipDrawableSizeChange();
    }

    public a(@NonNull Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.D = -1.0f;
        this.f36588i0 = new Paint(1);
        this.f36590k0 = new Paint.FontMetrics();
        this.f36591l0 = new RectF();
        this.f36592m0 = new PointF();
        this.f36593n0 = new Path();
        this.f36603x0 = 255;
        this.B0 = PorterDuff.Mode.SRC_IN;
        this.F0 = new WeakReference<>(null);
        S(context);
        this.f36587h0 = context;
        y yVar = new y(this);
        this.f36594o0 = yVar;
        this.H = "";
        yVar.g().density = context.getResources().getDisplayMetrics().density;
        this.f36589j0 = null;
        int[] iArr = K0;
        setState(iArr);
        v2(iArr);
        this.H0 = true;
        if (b.f79522a) {
            L0.setTint(-1);
        }
    }

    public static boolean B1(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean C1(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    @NonNull
    public static a D0(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        a aVar = new a(context, attributeSet, i11, i12);
        aVar.E1(attributeSet, i11, i12);
        return aVar;
    }

    public static boolean D1(@Nullable e eVar) {
        return (eVar == null || eVar.i() == null || !eVar.i().isStateful()) ? false : true;
    }

    public static boolean v1(@Nullable int[] iArr, int i11) {
        if (iArr == null) {
            return false;
        }
        for (int i12 : iArr) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public final float A0() {
        this.f36594o0.g().getFontMetrics(this.f36590k0);
        Paint.FontMetrics fontMetrics = this.f36590k0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public boolean A1() {
        return this.N;
    }

    public void A2(@Nullable TextUtils.TruncateAt truncateAt) {
        this.G0 = truncateAt;
    }

    @NonNull
    public Paint.Align B0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.H != null) {
            float fU0 = this.Z + u0() + this.f36582c0;
            if (d3.a.f(this) == 0) {
                pointF.x = rect.left + fU0;
            } else {
                pointF.x = rect.right - fU0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - A0();
        }
        return align;
    }

    public void B2(@Nullable ii.i iVar) {
        this.Y = iVar;
    }

    public final boolean C0() {
        return this.U && this.V != null && this.T;
    }

    public void C2(int i11) {
        B2(ii.i.d(this.f36587h0, i11));
    }

    public void D2(float f11) {
        if (this.f36581b0 != f11) {
            float fU0 = u0();
            this.f36581b0 = f11;
            float fU1 = u0();
            invalidateSelf();
            if (fU0 != fU1) {
                F1();
            }
        }
    }

    public final void E0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (X2()) {
            t0(rect, this.f36591l0);
            RectF rectF = this.f36591l0;
            float f11 = rectF.left;
            float f12 = rectF.top;
            canvas.translate(f11, f12);
            this.V.setBounds(0, 0, (int) this.f36591l0.width(), (int) this.f36591l0.height());
            this.V.draw(canvas);
            canvas.translate(-f11, -f12);
        }
    }

    public final void E1(@Nullable AttributeSet attributeSet, int i11, int i12) {
        TypedArray typedArrayI = b0.i(this.f36587h0, attributeSet, R$styleable.Chip, i11, i12, new int[0]);
        this.J0 = typedArrayI.hasValue(R$styleable.Chip_shapeAppearance);
        l2(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_chipSurfaceColor));
        P1(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_chipBackgroundColor));
        d2(typedArrayI.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        if (typedArrayI.hasValue(R$styleable.Chip_chipCornerRadius)) {
            R1(typedArrayI.getDimension(R$styleable.Chip_chipCornerRadius, 0.0f));
        }
        h2(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_chipStrokeColor));
        j2(typedArrayI.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        I2(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_rippleColor));
        N2(typedArrayI.getText(R$styleable.Chip_android_text));
        e eVarH = d.h(this.f36587h0, typedArrayI, R$styleable.Chip_android_textAppearance);
        eVarH.l(typedArrayI.getDimension(R$styleable.Chip_android_textSize, eVarH.j()));
        if (Build.VERSION.SDK_INT < 23) {
            eVarH.k(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_android_textColor));
        }
        O2(eVarH);
        int i13 = typedArrayI.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i13 == 1) {
            A2(TextUtils.TruncateAt.START);
        } else if (i13 == 2) {
            A2(TextUtils.TruncateAt.MIDDLE);
        } else if (i13 == 3) {
            A2(TextUtils.TruncateAt.END);
        }
        c2(typedArrayI.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            c2(typedArrayI.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        V1(d.e(this.f36587h0, typedArrayI, R$styleable.Chip_chipIcon));
        if (typedArrayI.hasValue(R$styleable.Chip_chipIconTint)) {
            Z1(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_chipIconTint));
        }
        X1(typedArrayI.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        y2(typedArrayI.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            y2(typedArrayI.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        m2(d.e(this.f36587h0, typedArrayI, R$styleable.Chip_closeIcon));
        w2(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_closeIconTint));
        r2(typedArrayI.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        H1(typedArrayI.getBoolean(R$styleable.Chip_android_checkable, false));
        O1(typedArrayI.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            O1(typedArrayI.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        J1(d.e(this.f36587h0, typedArrayI, R$styleable.Chip_checkedIcon));
        if (typedArrayI.hasValue(R$styleable.Chip_checkedIconTint)) {
            L1(d.a(this.f36587h0, typedArrayI, R$styleable.Chip_checkedIconTint));
        }
        L2(ii.i.c(this.f36587h0, typedArrayI, R$styleable.Chip_showMotionSpec));
        B2(ii.i.c(this.f36587h0, typedArrayI, R$styleable.Chip_hideMotionSpec));
        f2(typedArrayI.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        F2(typedArrayI.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        D2(typedArrayI.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        T2(typedArrayI.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        Q2(typedArrayI.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        t2(typedArrayI.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        o2(typedArrayI.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        T1(typedArrayI.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        H2(typedArrayI.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        typedArrayI.recycle();
    }

    public void E2(int i11) {
        D2(this.f36587h0.getResources().getDimension(i11));
    }

    public final void F0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.J0) {
            return;
        }
        this.f36588i0.setColor(this.f36596q0);
        this.f36588i0.setStyle(Paint.Style.FILL);
        this.f36588i0.setColorFilter(t1());
        this.f36591l0.set(rect);
        canvas.drawRoundRect(this.f36591l0, Q0(), Q0(), this.f36588i0);
    }

    public void F1() {
        InterfaceC0380a interfaceC0380a = this.F0.get();
        if (interfaceC0380a != null) {
            interfaceC0380a.onChipDrawableSizeChange();
        }
    }

    public void F2(float f11) {
        if (this.f36580a0 != f11) {
            float fU0 = u0();
            this.f36580a0 = f11;
            float fU1 = u0();
            invalidateSelf();
            if (fU0 != fU1) {
                F1();
            }
        }
    }

    public final void G0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (Y2()) {
            t0(rect, this.f36591l0);
            RectF rectF = this.f36591l0;
            float f11 = rectF.left;
            float f12 = rectF.top;
            canvas.translate(f11, f12);
            this.J.setBounds(0, 0, (int) this.f36591l0.width(), (int) this.f36591l0.height());
            this.J.draw(canvas);
            canvas.translate(-f11, -f12);
        }
    }

    public final boolean G1(@NonNull int[] iArr, @NonNull int[] iArr2) {
        boolean z11;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.A;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f36595p0) : 0);
        boolean state = true;
        if (this.f36595p0 != iL) {
            this.f36595p0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.B;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f36596q0) : 0);
        if (this.f36596q0 != iL2) {
            this.f36596q0 = iL2;
            zOnStateChange = true;
        }
        int iJ = com.google.android.material.color.b.j(iL, iL2);
        if ((this.f36597r0 != iJ) | (z() == null)) {
            this.f36597r0 = iJ;
            d0(ColorStateList.valueOf(iJ));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.E;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f36598s0) : 0;
        if (this.f36598s0 != colorForState) {
            this.f36598s0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.E0 == null || !b.f(iArr)) ? 0 : this.E0.getColorForState(iArr, this.f36599t0);
        if (this.f36599t0 != colorForState2) {
            this.f36599t0 = colorForState2;
            if (this.D0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f36594o0.e() == null || this.f36594o0.e().i() == null) ? 0 : this.f36594o0.e().i().getColorForState(iArr, this.f36600u0);
        if (this.f36600u0 != colorForState3) {
            this.f36600u0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z12 = v1(getState(), R.attr.state_checked) && this.T;
        if (this.f36601v0 == z12 || this.V == null) {
            z11 = false;
        } else {
            float fU0 = u0();
            this.f36601v0 = z12;
            if (fU0 != u0()) {
                zOnStateChange = true;
                z11 = true;
            } else {
                zOnStateChange = true;
                z11 = false;
            }
        }
        ColorStateList colorStateList4 = this.A0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f36602w0) : 0;
        if (this.f36602w0 != colorForState4) {
            this.f36602w0 = colorForState4;
            this.f36605z0 = f.o(this, this.A0, this.B0);
        } else {
            state = zOnStateChange;
        }
        if (C1(this.J)) {
            state |= this.J.setState(iArr);
        }
        if (C1(this.V)) {
            state |= this.V.setState(iArr);
        }
        if (C1(this.O)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.O.setState(iArr3);
        }
        if (b.f79522a && C1(this.P)) {
            state |= this.P.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z11) {
            F1();
        }
        return state;
    }

    public void G2(int i11) {
        F2(this.f36587h0.getResources().getDimension(i11));
    }

    public final void H0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.F <= 0.0f || this.J0) {
            return;
        }
        this.f36588i0.setColor(this.f36598s0);
        this.f36588i0.setStyle(Paint.Style.STROKE);
        if (!this.J0) {
            this.f36588i0.setColorFilter(t1());
        }
        RectF rectF = this.f36591l0;
        float f11 = rect.left;
        float f12 = this.F;
        rectF.set(f11 + (f12 / 2.0f), rect.top + (f12 / 2.0f), rect.right - (f12 / 2.0f), rect.bottom - (f12 / 2.0f));
        float f13 = this.D - (this.F / 2.0f);
        canvas.drawRoundRect(this.f36591l0, f13, f13, this.f36588i0);
    }

    public void H1(boolean z11) {
        if (this.T != z11) {
            this.T = z11;
            float fU0 = u0();
            if (!z11 && this.f36601v0) {
                this.f36601v0 = false;
            }
            float fU1 = u0();
            invalidateSelf();
            if (fU0 != fU1) {
                F1();
            }
        }
    }

    public void H2(int i11) {
        this.I0 = i11;
    }

    public final void I0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.J0) {
            return;
        }
        this.f36588i0.setColor(this.f36595p0);
        this.f36588i0.setStyle(Paint.Style.FILL);
        this.f36591l0.set(rect);
        canvas.drawRoundRect(this.f36591l0, Q0(), Q0(), this.f36588i0);
    }

    public void I1(int i11) {
        H1(this.f36587h0.getResources().getBoolean(i11));
    }

    public void I2(@Nullable ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            b3();
            onStateChange(getState());
        }
    }

    public final void J0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (Z2()) {
            w0(rect, this.f36591l0);
            RectF rectF = this.f36591l0;
            float f11 = rectF.left;
            float f12 = rectF.top;
            canvas.translate(f11, f12);
            this.O.setBounds(0, 0, (int) this.f36591l0.width(), (int) this.f36591l0.height());
            if (b.f79522a) {
                this.P.setBounds(this.O.getBounds());
                this.P.jumpToCurrentState();
                this.P.draw(canvas);
            } else {
                this.O.draw(canvas);
            }
            canvas.translate(-f11, -f12);
        }
    }

    public void J1(@Nullable Drawable drawable) {
        if (this.V != drawable) {
            float fU0 = u0();
            this.V = drawable;
            float fU1 = u0();
            a3(this.V);
            s0(this.V);
            invalidateSelf();
            if (fU0 != fU1) {
                F1();
            }
        }
    }

    public void J2(int i11) {
        I2(d1.a.a(this.f36587h0, i11));
    }

    public final void K0(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f36588i0.setColor(this.f36599t0);
        this.f36588i0.setStyle(Paint.Style.FILL);
        this.f36591l0.set(rect);
        if (!this.J0) {
            canvas.drawRoundRect(this.f36591l0, Q0(), Q0(), this.f36588i0);
        } else {
            h(new RectF(rect), this.f36593n0);
            super.r(canvas, this.f36588i0, this.f36593n0, w());
        }
    }

    public void K1(int i11) {
        J1(d1.a.b(this.f36587h0, i11));
    }

    public void K2(boolean z11) {
        this.H0 = z11;
    }

    public final void L0(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f36589j0;
        if (paint != null) {
            paint.setColor(c3.b.k(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.f36589j0);
            if (Y2() || X2()) {
                t0(rect, this.f36591l0);
                canvas.drawRect(this.f36591l0, this.f36589j0);
            }
            if (this.H != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f36589j0);
            }
            if (Z2()) {
                w0(rect, this.f36591l0);
                canvas.drawRect(this.f36591l0, this.f36589j0);
            }
            this.f36589j0.setColor(c3.b.k(FlowLayout.SPACING_AUTO, 127));
            v0(rect, this.f36591l0);
            canvas.drawRect(this.f36591l0, this.f36589j0);
            this.f36589j0.setColor(c3.b.k(-16711936, 127));
            x0(rect, this.f36591l0);
            canvas.drawRect(this.f36591l0, this.f36589j0);
        }
    }

    public void L1(@Nullable ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (C0()) {
                d3.a.o(this.V, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void L2(@Nullable ii.i iVar) {
        this.X = iVar;
    }

    public final void M0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.H != null) {
            Paint.Align alignB0 = B0(rect, this.f36592m0);
            z0(rect, this.f36591l0);
            if (this.f36594o0.e() != null) {
                this.f36594o0.g().drawableState = getState();
                this.f36594o0.n(this.f36587h0);
            }
            this.f36594o0.g().setTextAlign(alignB0);
            int iSave = 0;
            boolean z11 = Math.round(this.f36594o0.h(p1().toString())) > Math.round(this.f36591l0.width());
            if (z11) {
                iSave = canvas.save();
                canvas.clipRect(this.f36591l0);
            }
            CharSequence charSequenceEllipsize = this.H;
            if (z11 && this.G0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f36594o0.g(), this.f36591l0.width(), this.G0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f36592m0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f36594o0.g());
            if (z11) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void M1(int i11) {
        L1(d1.a.a(this.f36587h0, i11));
    }

    public void M2(int i11) {
        L2(ii.i.d(this.f36587h0, i11));
    }

    @Nullable
    public Drawable N0() {
        return this.V;
    }

    public void N1(int i11) {
        O1(this.f36587h0.getResources().getBoolean(i11));
    }

    public void N2(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.H, charSequence)) {
            return;
        }
        this.H = charSequence;
        this.f36594o0.m(true);
        invalidateSelf();
        F1();
    }

    @Nullable
    public ColorStateList O0() {
        return this.W;
    }

    public void O1(boolean z11) {
        if (this.U != z11) {
            boolean zX2 = X2();
            this.U = z11;
            boolean zX3 = X2();
            if (zX2 != zX3) {
                if (zX3) {
                    s0(this.V);
                } else {
                    a3(this.V);
                }
                invalidateSelf();
                F1();
            }
        }
    }

    public void O2(@Nullable e eVar) {
        this.f36594o0.k(eVar, this.f36587h0);
    }

    @Nullable
    public ColorStateList P0() {
        return this.B;
    }

    public void P1(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    public void P2(int i11) {
        O2(new e(this.f36587h0, i11));
    }

    public float Q0() {
        return this.J0 ? L() : this.D;
    }

    public void Q1(int i11) {
        P1(d1.a.a(this.f36587h0, i11));
    }

    public void Q2(float f11) {
        if (this.f36583d0 != f11) {
            this.f36583d0 = f11;
            invalidateSelf();
            F1();
        }
    }

    public float R0() {
        return this.f36586g0;
    }

    @Deprecated
    public void R1(float f11) {
        if (this.D != f11) {
            this.D = f11;
            setShapeAppearanceModel(G().w(f11));
        }
    }

    public void R2(int i11) {
        Q2(this.f36587h0.getResources().getDimension(i11));
    }

    @Nullable
    public Drawable S0() {
        Drawable drawable = this.J;
        if (drawable != null) {
            return d3.a.q(drawable);
        }
        return null;
    }

    @Deprecated
    public void S1(int i11) {
        R1(this.f36587h0.getResources().getDimension(i11));
    }

    public void S2(float f11) {
        e eVarQ1 = q1();
        if (eVarQ1 != null) {
            eVarQ1.l(f11);
            this.f36594o0.g().setTextSize(f11);
            a();
        }
    }

    public float T0() {
        return this.L;
    }

    public void T1(float f11) {
        if (this.f36586g0 != f11) {
            this.f36586g0 = f11;
            invalidateSelf();
            F1();
        }
    }

    public void T2(float f11) {
        if (this.f36582c0 != f11) {
            this.f36582c0 = f11;
            invalidateSelf();
            F1();
        }
    }

    @Nullable
    public ColorStateList U0() {
        return this.K;
    }

    public void U1(int i11) {
        T1(this.f36587h0.getResources().getDimension(i11));
    }

    public void U2(int i11) {
        T2(this.f36587h0.getResources().getDimension(i11));
    }

    public float V0() {
        return this.C;
    }

    public void V1(@Nullable Drawable drawable) {
        Drawable drawableS0 = S0();
        if (drawableS0 != drawable) {
            float fU0 = u0();
            this.J = drawable != null ? d3.a.r(drawable).mutate() : null;
            float fU1 = u0();
            a3(drawableS0);
            if (Y2()) {
                s0(this.J);
            }
            invalidateSelf();
            if (fU0 != fU1) {
                F1();
            }
        }
    }

    public void V2(boolean z11) {
        if (this.D0 != z11) {
            this.D0 = z11;
            b3();
            onStateChange(getState());
        }
    }

    public float W0() {
        return this.Z;
    }

    public void W1(int i11) {
        V1(d1.a.b(this.f36587h0, i11));
    }

    public boolean W2() {
        return this.H0;
    }

    @Nullable
    public ColorStateList X0() {
        return this.E;
    }

    public void X1(float f11) {
        if (this.L != f11) {
            float fU0 = u0();
            this.L = f11;
            float fU1 = u0();
            invalidateSelf();
            if (fU0 != fU1) {
                F1();
            }
        }
    }

    public final boolean X2() {
        return this.U && this.V != null && this.f36601v0;
    }

    public float Y0() {
        return this.F;
    }

    public void Y1(int i11) {
        X1(this.f36587h0.getResources().getDimension(i11));
    }

    public final boolean Y2() {
        return this.I && this.J != null;
    }

    @Nullable
    public Drawable Z0() {
        Drawable drawable = this.O;
        if (drawable != null) {
            return d3.a.q(drawable);
        }
        return null;
    }

    public void Z1(@Nullable ColorStateList colorStateList) {
        this.M = true;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (Y2()) {
                d3.a.o(this.J, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final boolean Z2() {
        return this.N && this.O != null;
    }

    @Override // com.google.android.material.internal.y.b
    public void a() {
        F1();
        invalidateSelf();
    }

    @Nullable
    public CharSequence a1() {
        return this.S;
    }

    public void a2(int i11) {
        Z1(d1.a.a(this.f36587h0, i11));
    }

    public final void a3(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public float b1() {
        return this.f36585f0;
    }

    public void b2(int i11) {
        c2(this.f36587h0.getResources().getBoolean(i11));
    }

    public final void b3() {
        this.E0 = this.D0 ? b.e(this.G) : null;
    }

    public float c1() {
        return this.R;
    }

    public void c2(boolean z11) {
        if (this.I != z11) {
            boolean zY2 = Y2();
            this.I = z11;
            boolean zY3 = Y2();
            if (zY2 != zY3) {
                if (zY3) {
                    s0(this.J);
                } else {
                    a3(this.J);
                }
                invalidateSelf();
                F1();
            }
        }
    }

    @TargetApi(21)
    public final void c3() {
        this.P = new RippleDrawable(b.e(n1()), this.O, L0);
    }

    public float d1() {
        return this.f36584e0;
    }

    public void d2(float f11) {
        if (this.C != f11) {
            this.C = f11;
            invalidateSelf();
            F1();
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i11 = this.f36603x0;
        int iA = i11 < 255 ? ji.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i11) : 0;
        I0(canvas, bounds);
        F0(canvas, bounds);
        if (this.J0) {
            super.draw(canvas);
        }
        H0(canvas, bounds);
        K0(canvas, bounds);
        G0(canvas, bounds);
        E0(canvas, bounds);
        if (this.H0) {
            M0(canvas, bounds);
        }
        J0(canvas, bounds);
        L0(canvas, bounds);
        if (this.f36603x0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    @NonNull
    public int[] e1() {
        return this.C0;
    }

    public void e2(int i11) {
        d2(this.f36587h0.getResources().getDimension(i11));
    }

    @Nullable
    public ColorStateList f1() {
        return this.Q;
    }

    public void f2(float f11) {
        if (this.Z != f11) {
            this.Z = f11;
            invalidateSelf();
            F1();
        }
    }

    public void g1(@NonNull RectF rectF) {
        x0(getBounds(), rectF);
    }

    public void g2(int i11) {
        f2(this.f36587h0.getResources().getDimension(i11));
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f36603x0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.f36604y0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Z + u0() + this.f36582c0 + this.f36594o0.h(p1().toString()) + this.f36583d0 + y0() + this.f36586g0), this.I0);
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.J0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.D);
        } else {
            outline.setRoundRect(bounds, this.D);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public final float h1() {
        Drawable drawable = this.f36601v0 ? this.V : this.J;
        float fCeil = this.L;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(f0.g(this.f36587h0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    public void h2(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            if (this.J0) {
                n0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final float i1() {
        Drawable drawable = this.f36601v0 ? this.V : this.J;
        float f11 = this.L;
        return (f11 > 0.0f || drawable == null) ? f11 : drawable.getIntrinsicWidth();
    }

    public void i2(int i11) {
        h2(d1.a.a(this.f36587h0, i11));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return B1(this.A) || B1(this.B) || B1(this.E) || (this.D0 && B1(this.E0)) || D1(this.f36594o0.e()) || C0() || C1(this.J) || C1(this.V) || B1(this.A0);
    }

    public TextUtils.TruncateAt j1() {
        return this.G0;
    }

    public void j2(float f11) {
        if (this.F != f11) {
            this.F = f11;
            this.f36588i0.setStrokeWidth(f11);
            if (this.J0) {
                super.o0(f11);
            }
            invalidateSelf();
        }
    }

    @Nullable
    public ii.i k1() {
        return this.Y;
    }

    public void k2(int i11) {
        j2(this.f36587h0.getResources().getDimension(i11));
    }

    public float l1() {
        return this.f36581b0;
    }

    public final void l2(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public float m1() {
        return this.f36580a0;
    }

    public void m2(@Nullable Drawable drawable) {
        Drawable drawableZ0 = Z0();
        if (drawableZ0 != drawable) {
            float fY0 = y0();
            this.O = drawable != null ? d3.a.r(drawable).mutate() : null;
            if (b.f79522a) {
                c3();
            }
            float fY1 = y0();
            a3(drawableZ0);
            if (Z2()) {
                s0(this.O);
            }
            invalidateSelf();
            if (fY0 != fY1) {
                F1();
            }
        }
    }

    @Nullable
    public ColorStateList n1() {
        return this.G;
    }

    public void n2(@Nullable CharSequence charSequence) {
        if (this.S != charSequence) {
            this.S = androidx.core.text.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    @Nullable
    public ii.i o1() {
        return this.X;
    }

    public void o2(float f11) {
        if (this.f36585f0 != f11) {
            this.f36585f0 = f11;
            invalidateSelf();
            if (Z2()) {
                F1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i11) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i11);
        if (Y2()) {
            zOnLayoutDirectionChanged |= d3.a.m(this.J, i11);
        }
        if (X2()) {
            zOnLayoutDirectionChanged |= d3.a.m(this.V, i11);
        }
        if (Z2()) {
            zOnLayoutDirectionChanged |= d3.a.m(this.O, i11);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i11) {
        boolean zOnLevelChange = super.onLevelChange(i11);
        if (Y2()) {
            zOnLevelChange |= this.J.setLevel(i11);
        }
        if (X2()) {
            zOnLevelChange |= this.V.setLevel(i11);
        }
        if (Z2()) {
            zOnLevelChange |= this.O.setLevel(i11);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // yi.i, android.graphics.drawable.Drawable, com.google.android.material.internal.y.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.J0) {
            super.onStateChange(iArr);
        }
        return G1(iArr, e1());
    }

    @Nullable
    public CharSequence p1() {
        return this.H;
    }

    public void p2(int i11) {
        o2(this.f36587h0.getResources().getDimension(i11));
    }

    @Nullable
    public e q1() {
        return this.f36594o0.e();
    }

    public void q2(int i11) {
        m2(d1.a.b(this.f36587h0, i11));
    }

    public float r1() {
        return this.f36583d0;
    }

    public void r2(float f11) {
        if (this.R != f11) {
            this.R = f11;
            invalidateSelf();
            if (Z2()) {
                F1();
            }
        }
    }

    public final void s0(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        d3.a.m(drawable, d3.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.O) {
            if (drawable.isStateful()) {
                drawable.setState(e1());
            }
            d3.a.o(drawable, this.Q);
            return;
        }
        Drawable drawable2 = this.J;
        if (drawable == drawable2 && this.M) {
            d3.a.o(drawable2, this.K);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public float s1() {
        return this.f36582c0;
    }

    public void s2(int i11) {
        r2(this.f36587h0.getResources().getDimension(i11));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j11) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j11);
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (this.f36603x0 != i11) {
            this.f36603x0 = i11;
            invalidateSelf();
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.f36604y0 != colorFilter) {
            this.f36604y0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // yi.i, android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.B0 != mode) {
            this.B0 = mode;
            this.f36605z0 = f.o(this, this.A0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        if (Y2()) {
            visible |= this.J.setVisible(z11, z12);
        }
        if (X2()) {
            visible |= this.V.setVisible(z11, z12);
        }
        if (Z2()) {
            visible |= this.O.setVisible(z11, z12);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (Y2() || X2()) {
            float f11 = this.Z + this.f36580a0;
            float fI1 = i1();
            if (d3.a.f(this) == 0) {
                float f12 = rect.left + f11;
                rectF.left = f12;
                rectF.right = f12 + fI1;
            } else {
                float f13 = rect.right - f11;
                rectF.right = f13;
                rectF.left = f13 - fI1;
            }
            float fH1 = h1();
            float fExactCenterY = rect.exactCenterY() - (fH1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fH1;
        }
    }

    @Nullable
    public final ColorFilter t1() {
        ColorFilter colorFilter = this.f36604y0;
        return colorFilter != null ? colorFilter : this.f36605z0;
    }

    public void t2(float f11) {
        if (this.f36584e0 != f11) {
            this.f36584e0 = f11;
            invalidateSelf();
            if (Z2()) {
                F1();
            }
        }
    }

    public float u0() {
        if (Y2() || X2()) {
            return this.f36580a0 + i1() + this.f36581b0;
        }
        return 0.0f;
    }

    public boolean u1() {
        return this.D0;
    }

    public void u2(int i11) {
        t2(this.f36587h0.getResources().getDimension(i11));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (Z2()) {
            float f11 = this.f36586g0 + this.f36585f0 + this.R + this.f36584e0 + this.f36583d0;
            if (d3.a.f(this) == 0) {
                rectF.right = rect.right - f11;
            } else {
                rectF.left = rect.left + f11;
            }
        }
    }

    public boolean v2(@NonNull int[] iArr) {
        if (Arrays.equals(this.C0, iArr)) {
            return false;
        }
        this.C0 = iArr;
        if (Z2()) {
            return G1(getState(), iArr);
        }
        return false;
    }

    public final void w0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (Z2()) {
            float f11 = this.f36586g0 + this.f36585f0;
            if (d3.a.f(this) == 0) {
                float f12 = rect.right - f11;
                rectF.right = f12;
                rectF.left = f12 - this.R;
            } else {
                float f13 = rect.left + f11;
                rectF.left = f13;
                rectF.right = f13 + this.R;
            }
            float fExactCenterY = rect.exactCenterY();
            float f14 = this.R;
            float f15 = fExactCenterY - (f14 / 2.0f);
            rectF.top = f15;
            rectF.bottom = f15 + f14;
        }
    }

    public boolean w1() {
        return this.T;
    }

    public void w2(@Nullable ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (Z2()) {
                d3.a.o(this.O, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void x0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (Z2()) {
            float f11 = this.f36586g0 + this.f36585f0 + this.R + this.f36584e0 + this.f36583d0;
            if (d3.a.f(this) == 0) {
                float f12 = rect.right;
                rectF.right = f12;
                rectF.left = f12 - f11;
            } else {
                int i11 = rect.left;
                rectF.left = i11;
                rectF.right = i11 + f11;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean x1() {
        return this.U;
    }

    public void x2(int i11) {
        w2(d1.a.a(this.f36587h0, i11));
    }

    public float y0() {
        if (Z2()) {
            return this.f36584e0 + this.R + this.f36585f0;
        }
        return 0.0f;
    }

    public boolean y1() {
        return this.I;
    }

    public void y2(boolean z11) {
        if (this.N != z11) {
            boolean zZ2 = Z2();
            this.N = z11;
            boolean zZ3 = Z2();
            if (zZ2 != zZ3) {
                if (zZ3) {
                    s0(this.O);
                } else {
                    a3(this.O);
                }
                invalidateSelf();
                F1();
            }
        }
    }

    public final void z0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.H != null) {
            float fU0 = this.Z + u0() + this.f36582c0;
            float fY0 = this.f36586g0 + y0() + this.f36583d0;
            if (d3.a.f(this) == 0) {
                rectF.left = rect.left + fU0;
                rectF.right = rect.right - fY0;
            } else {
                rectF.left = rect.left + fY0;
                rectF.right = rect.right - fU0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean z1() {
        return C1(this.O);
    }

    public void z2(@Nullable InterfaceC0380a interfaceC0380a) {
        this.F0 = new WeakReference<>(interfaceC0380a);
    }
}
