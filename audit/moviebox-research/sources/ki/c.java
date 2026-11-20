package ki;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import com.google.logging.type.LogSeverity;
import ti.j;
import vi.d;
import yi.e;
import yi.f;
import yi.i;
import yi.m;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    public static final Drawable A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final double f68574z = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final MaterialCardView f68575a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final i f68577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final i f68578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f68579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f68581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f68582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Drawable f68583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Drawable f68584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public ColorStateList f68585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ColorStateList f68586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public n f68587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public ColorStateList f68588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public Drawable f68589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public LayerDrawable f68590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public i f68591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public i f68592r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f68594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public ValueAnimator f68595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TimeInterpolator f68596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f68597w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f68598x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Rect f68576b = new Rect();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f68593s = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f68599y = 0.0f;

    /* JADX INFO: compiled from: source.java */
    public class a extends InsetDrawable {
        public a(Drawable drawable, int i11, int i12, int i13, int i14) {
            super(drawable, i11, i12, i13, i14);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        A = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public c(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i11, int i12) {
        this.f68575a = materialCardView;
        i iVar = new i(materialCardView.getContext(), attributeSet, i11, i12);
        this.f68577c = iVar;
        iVar.S(materialCardView.getContext());
        iVar.j0(-12303292);
        n.b bVarV = iVar.G().v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i11, R$style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.CardView_cardCornerRadius)) {
            bVarV.o(typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f68578d = new i();
        Z(bVarV.m());
        this.f68596v = j.g(materialCardView.getContext(), R$attr.motionEasingLinearInterpolator, ii.b.f67201a);
        this.f68597w = j.f(materialCardView.getContext(), R$attr.motionDurationShort2, LogSeverity.NOTICE_VALUE);
        this.f68598x = j.f(materialCardView.getContext(), R$attr.motionDurationShort1, LogSeverity.NOTICE_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Nullable
    public ColorStateList A() {
        return this.f68588n;
    }

    public int B() {
        return this.f68582h;
    }

    @NonNull
    public Rect C() {
        return this.f68576b;
    }

    @NonNull
    public final Drawable D(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.f68575a.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(f());
            iCeil = (int) Math.ceil(e());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new a(drawable, iCeil, iCeil2, iCeil, iCeil2);
    }

    public boolean E() {
        return this.f68593s;
    }

    public boolean F() {
        return this.f68594t;
    }

    public final boolean G() {
        return (this.f68581g & 80) == 80;
    }

    public final boolean H() {
        return (this.f68581g & GravityCompat.END) == 8388613;
    }

    public final /* synthetic */ void I(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f68584j.setAlpha((int) (255.0f * fFloatValue));
        this.f68599y = fFloatValue;
    }

    public void J(@NonNull TypedArray typedArray) {
        ColorStateList colorStateListA = d.a(this.f68575a.getContext(), typedArray, R$styleable.MaterialCardView_strokeColor);
        this.f68588n = colorStateListA;
        if (colorStateListA == null) {
            this.f68588n = ColorStateList.valueOf(-1);
        }
        this.f68582h = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z11 = typedArray.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        this.f68594t = z11;
        this.f68575a.setLongClickable(z11);
        this.f68586l = d.a(this.f68575a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIconTint);
        R(d.e(this.f68575a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIcon));
        U(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0));
        T(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0));
        this.f68581g = typedArray.getInteger(R$styleable.MaterialCardView_checkedIconGravity, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END);
        ColorStateList colorStateListA2 = d.a(this.f68575a.getContext(), typedArray, R$styleable.MaterialCardView_rippleColor);
        this.f68585k = colorStateListA2;
        if (colorStateListA2 == null) {
            this.f68585k = ColorStateList.valueOf(com.google.android.material.color.b.d(this.f68575a, R$attr.colorControlHighlight));
        }
        N(d.a(this.f68575a.getContext(), typedArray, R$styleable.MaterialCardView_cardForegroundColor));
        l0();
        i0();
        m0();
        this.f68575a.setBackgroundInternal(D(this.f68577c));
        Drawable drawableT = f0() ? t() : this.f68578d;
        this.f68583i = drawableT;
        this.f68575a.setForeground(D(drawableT));
    }

    public void K(int i11, int i12) {
        int iCeil;
        int iCeil2;
        int i13;
        int i14;
        if (this.f68590p != null) {
            if (this.f68575a.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(f() * 2.0f);
                iCeil2 = (int) Math.ceil(e() * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i15 = H() ? ((i11 - this.f68579e) - this.f68580f) - iCeil2 : this.f68579e;
            int i16 = G() ? this.f68579e : ((i12 - this.f68579e) - this.f68580f) - iCeil;
            int i17 = H() ? this.f68579e : ((i11 - this.f68579e) - this.f68580f) - iCeil2;
            int i18 = G() ? ((i12 - this.f68579e) - this.f68580f) - iCeil : this.f68579e;
            if (ViewCompat.getLayoutDirection(this.f68575a) == 1) {
                i14 = i17;
                i13 = i15;
            } else {
                i13 = i17;
                i14 = i15;
            }
            this.f68590p.setLayerInset(2, i14, i18, i13, i16);
        }
    }

    public void L(boolean z11) {
        this.f68593s = z11;
    }

    public void M(ColorStateList colorStateList) {
        this.f68577c.d0(colorStateList);
    }

    public void N(@Nullable ColorStateList colorStateList) {
        i iVar = this.f68578d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        iVar.d0(colorStateList);
    }

    public void O(boolean z11) {
        this.f68594t = z11;
    }

    public void P(boolean z11) {
        Q(z11, false);
    }

    public void Q(boolean z11, boolean z12) {
        Drawable drawable = this.f68584j;
        if (drawable != null) {
            if (z12) {
                b(z11);
            } else {
                drawable.setAlpha(z11 ? 255 : 0);
                this.f68599y = z11 ? 1.0f : 0.0f;
            }
        }
    }

    public void R(@Nullable Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = d3.a.r(drawable).mutate();
            this.f68584j = drawableMutate;
            d3.a.o(drawableMutate, this.f68586l);
            P(this.f68575a.isChecked());
        } else {
            this.f68584j = A;
        }
        LayerDrawable layerDrawable = this.f68590p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, this.f68584j);
        }
    }

    public void S(int i11) {
        this.f68581g = i11;
        K(this.f68575a.getMeasuredWidth(), this.f68575a.getMeasuredHeight());
    }

    public void T(int i11) {
        this.f68579e = i11;
    }

    public void U(int i11) {
        this.f68580f = i11;
    }

    public void V(@Nullable ColorStateList colorStateList) {
        this.f68586l = colorStateList;
        Drawable drawable = this.f68584j;
        if (drawable != null) {
            d3.a.o(drawable, colorStateList);
        }
    }

    public void W(float f11) {
        Z(this.f68587m.w(f11));
        this.f68583i.invalidateSelf();
        if (e0() || d0()) {
            h0();
        }
        if (e0()) {
            k0();
        }
    }

    public void X(float f11) {
        this.f68577c.e0(f11);
        i iVar = this.f68578d;
        if (iVar != null) {
            iVar.e0(f11);
        }
        i iVar2 = this.f68592r;
        if (iVar2 != null) {
            iVar2.e0(f11);
        }
    }

    public void Y(@Nullable ColorStateList colorStateList) {
        this.f68585k = colorStateList;
        l0();
    }

    public void Z(@NonNull n nVar) {
        this.f68587m = nVar;
        this.f68577c.setShapeAppearanceModel(nVar);
        i iVar = this.f68577c;
        iVar.i0(!iVar.V());
        i iVar2 = this.f68578d;
        if (iVar2 != null) {
            iVar2.setShapeAppearanceModel(nVar);
        }
        i iVar3 = this.f68592r;
        if (iVar3 != null) {
            iVar3.setShapeAppearanceModel(nVar);
        }
        i iVar4 = this.f68591q;
        if (iVar4 != null) {
            iVar4.setShapeAppearanceModel(nVar);
        }
    }

    public void a0(ColorStateList colorStateList) {
        if (this.f68588n == colorStateList) {
            return;
        }
        this.f68588n = colorStateList;
        m0();
    }

    public void b(boolean z11) {
        float f11 = z11 ? 1.0f : 0.0f;
        float f12 = z11 ? 1.0f - this.f68599y : this.f68599y;
        ValueAnimator valueAnimator = this.f68595u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f68595u = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f68599y, f11);
        this.f68595u = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ki.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f68573a.I(valueAnimator2);
            }
        });
        this.f68595u.setInterpolator(this.f68596v);
        this.f68595u.setDuration((long) ((z11 ? this.f68597w : this.f68598x) * f12));
        this.f68595u.start();
    }

    public void b0(int i11) {
        if (i11 == this.f68582h) {
            return;
        }
        this.f68582h = i11;
        m0();
    }

    public final float c() {
        return Math.max(Math.max(d(this.f68587m.q(), this.f68577c.L()), d(this.f68587m.s(), this.f68577c.M())), Math.max(d(this.f68587m.k(), this.f68577c.v()), d(this.f68587m.i(), this.f68577c.u())));
    }

    public void c0(int i11, int i12, int i13, int i14) {
        this.f68576b.set(i11, i12, i13, i14);
        h0();
    }

    public final float d(e eVar, float f11) {
        if (eVar instanceof m) {
            return (float) ((1.0d - f68574z) * ((double) f11));
        }
        if (eVar instanceof f) {
            return f11 / 2.0f;
        }
        return 0.0f;
    }

    public final boolean d0() {
        return this.f68575a.getPreventCornerOverlap() && !g();
    }

    public final float e() {
        return this.f68575a.getMaxCardElevation() + (e0() ? c() : 0.0f);
    }

    public final boolean e0() {
        return this.f68575a.getPreventCornerOverlap() && g() && this.f68575a.getUseCompatPadding();
    }

    public final float f() {
        return (this.f68575a.getMaxCardElevation() * 1.5f) + (e0() ? c() : 0.0f);
    }

    public final boolean f0() {
        if (this.f68575a.isClickable()) {
            return true;
        }
        View view = this.f68575a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final boolean g() {
        return this.f68577c.V();
    }

    public void g0() {
        Drawable drawable = this.f68583i;
        Drawable drawableT = f0() ? t() : this.f68578d;
        this.f68583i = drawableT;
        if (drawable != drawableT) {
            j0(drawableT);
        }
    }

    @NonNull
    public final Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        i iVarJ = j();
        this.f68591q = iVarJ;
        iVarJ.d0(this.f68585k);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f68591q);
        return stateListDrawable;
    }

    public void h0() {
        int iC = (int) (((d0() || e0()) ? c() : 0.0f) - v());
        MaterialCardView materialCardView = this.f68575a;
        Rect rect = this.f68576b;
        materialCardView.d(rect.left + iC, rect.top + iC, rect.right + iC, rect.bottom + iC);
    }

    @NonNull
    public final Drawable i() {
        if (!wi.b.f79522a) {
            return h();
        }
        this.f68592r = j();
        return new RippleDrawable(this.f68585k, null, this.f68592r);
    }

    public void i0() {
        this.f68577c.c0(this.f68575a.getCardElevation());
    }

    @NonNull
    public final i j() {
        return new i(this.f68587m);
    }

    public final void j0(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f68575a.getForeground() instanceof InsetDrawable)) {
            this.f68575a.setForeground(D(drawable));
        } else {
            ((InsetDrawable) this.f68575a.getForeground()).setDrawable(drawable);
        }
    }

    @RequiresApi(api = 23)
    public void k() {
        Drawable drawable = this.f68589o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i11 = bounds.bottom;
            this.f68589o.setBounds(bounds.left, bounds.top, bounds.right, i11 - 1);
            this.f68589o.setBounds(bounds.left, bounds.top, bounds.right, i11);
        }
    }

    public void k0() {
        if (!E()) {
            this.f68575a.setBackgroundInternal(D(this.f68577c));
        }
        this.f68575a.setForeground(D(this.f68583i));
    }

    @NonNull
    public i l() {
        return this.f68577c;
    }

    public final void l0() {
        Drawable drawable;
        if (wi.b.f79522a && (drawable = this.f68589o) != null) {
            ((RippleDrawable) drawable).setColor(this.f68585k);
            return;
        }
        i iVar = this.f68591q;
        if (iVar != null) {
            iVar.d0(this.f68585k);
        }
    }

    public ColorStateList m() {
        return this.f68577c.z();
    }

    public void m0() {
        this.f68578d.m0(this.f68582h, this.f68588n);
    }

    public ColorStateList n() {
        return this.f68578d.z();
    }

    @Nullable
    public Drawable o() {
        return this.f68584j;
    }

    public int p() {
        return this.f68581g;
    }

    public int q() {
        return this.f68579e;
    }

    public int r() {
        return this.f68580f;
    }

    @Nullable
    public ColorStateList s() {
        return this.f68586l;
    }

    @NonNull
    public final Drawable t() {
        if (this.f68589o == null) {
            this.f68589o = i();
        }
        if (this.f68590p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f68589o, this.f68578d, this.f68584j});
            this.f68590p = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.f68590p;
    }

    public float u() {
        return this.f68577c.L();
    }

    public final float v() {
        if (this.f68575a.getPreventCornerOverlap() && this.f68575a.getUseCompatPadding()) {
            return (float) ((1.0d - f68574z) * ((double) this.f68575a.getCardViewRadius()));
        }
        return 0.0f;
    }

    public float w() {
        return this.f68577c.A();
    }

    @Nullable
    public ColorStateList x() {
        return this.f68585k;
    }

    public n y() {
        return this.f68587m;
    }

    public int z() {
        ColorStateList colorStateList = this.f68588n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
