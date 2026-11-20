package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.color.b;
import com.google.android.material.internal.f0;
import vi.d;
import yi.i;
import yi.n;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f36429u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f36430v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f36431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public n f36432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public PorterDuff.Mode f36439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public ColorStateList f36440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public ColorStateList f36441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ColorStateList f36442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public Drawable f36443m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f36447q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LayerDrawable f36449s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f36450t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f36444n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f36445o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f36446p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f36448r = true;

    static {
        int i11 = Build.VERSION.SDK_INT;
        f36429u = true;
        f36430v = i11 <= 22;
    }

    public a(MaterialButton materialButton, @NonNull n nVar) {
        this.f36431a = materialButton;
        this.f36432b = nVar;
    }

    public void A(boolean z11) {
        this.f36444n = z11;
        K();
    }

    public void B(@Nullable ColorStateList colorStateList) {
        if (this.f36441k != colorStateList) {
            this.f36441k = colorStateList;
            K();
        }
    }

    public void C(int i11) {
        if (this.f36438h != i11) {
            this.f36438h = i11;
            K();
        }
    }

    public void D(@Nullable ColorStateList colorStateList) {
        if (this.f36440j != colorStateList) {
            this.f36440j = colorStateList;
            if (f() != null) {
                d3.a.o(f(), this.f36440j);
            }
        }
    }

    public void E(@Nullable PorterDuff.Mode mode) {
        if (this.f36439i != mode) {
            this.f36439i = mode;
            if (f() == null || this.f36439i == null) {
                return;
            }
            d3.a.p(f(), this.f36439i);
        }
    }

    public void F(boolean z11) {
        this.f36448r = z11;
    }

    public final void G(int i11, int i12) {
        int paddingStart = ViewCompat.getPaddingStart(this.f36431a);
        int paddingTop = this.f36431a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f36431a);
        int paddingBottom = this.f36431a.getPaddingBottom();
        int i13 = this.f36435e;
        int i14 = this.f36436f;
        this.f36436f = i12;
        this.f36435e = i11;
        if (!this.f36445o) {
            H();
        }
        ViewCompat.setPaddingRelative(this.f36431a, paddingStart, (paddingTop + i11) - i13, paddingEnd, (paddingBottom + i12) - i14);
    }

    public final void H() {
        this.f36431a.setInternalBackground(a());
        i iVarF = f();
        if (iVarF != null) {
            iVarF.c0(this.f36450t);
            iVarF.setState(this.f36431a.getDrawableState());
        }
    }

    public final void I(@NonNull n nVar) {
        if (f36430v && !this.f36445o) {
            int paddingStart = ViewCompat.getPaddingStart(this.f36431a);
            int paddingTop = this.f36431a.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.f36431a);
            int paddingBottom = this.f36431a.getPaddingBottom();
            H();
            ViewCompat.setPaddingRelative(this.f36431a, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(nVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(nVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(nVar);
        }
    }

    public void J(int i11, int i12) {
        Drawable drawable = this.f36443m;
        if (drawable != null) {
            drawable.setBounds(this.f36433c, this.f36435e, i12 - this.f36434d, i11 - this.f36436f);
        }
    }

    public final void K() {
        i iVarF = f();
        i iVarN = n();
        if (iVarF != null) {
            iVarF.m0(this.f36438h, this.f36441k);
            if (iVarN != null) {
                iVarN.l0(this.f36438h, this.f36444n ? b.d(this.f36431a, R$attr.colorSurface) : 0);
            }
        }
    }

    @NonNull
    public final InsetDrawable L(Drawable drawable) {
        return new InsetDrawable(drawable, this.f36433c, this.f36435e, this.f36434d, this.f36436f);
    }

    public final Drawable a() {
        i iVar = new i(this.f36432b);
        iVar.S(this.f36431a.getContext());
        d3.a.o(iVar, this.f36440j);
        PorterDuff.Mode mode = this.f36439i;
        if (mode != null) {
            d3.a.p(iVar, mode);
        }
        iVar.m0(this.f36438h, this.f36441k);
        i iVar2 = new i(this.f36432b);
        iVar2.setTint(0);
        iVar2.l0(this.f36438h, this.f36444n ? b.d(this.f36431a, R$attr.colorSurface) : 0);
        if (f36429u) {
            i iVar3 = new i(this.f36432b);
            this.f36443m = iVar3;
            d3.a.n(iVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(wi.b.e(this.f36442l), L(new LayerDrawable(new Drawable[]{iVar2, iVar})), this.f36443m);
            this.f36449s = rippleDrawable;
            return rippleDrawable;
        }
        wi.a aVar = new wi.a(this.f36432b);
        this.f36443m = aVar;
        d3.a.o(aVar, wi.b.e(this.f36442l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{iVar2, iVar, this.f36443m});
        this.f36449s = layerDrawable;
        return L(layerDrawable);
    }

    public int b() {
        return this.f36437g;
    }

    public int c() {
        return this.f36436f;
    }

    public int d() {
        return this.f36435e;
    }

    @Nullable
    public q e() {
        LayerDrawable layerDrawable = this.f36449s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f36449s.getNumberOfLayers() > 2 ? (q) this.f36449s.getDrawable(2) : (q) this.f36449s.getDrawable(1);
    }

    @Nullable
    public i f() {
        return g(false);
    }

    @Nullable
    public final i g(boolean z11) {
        LayerDrawable layerDrawable = this.f36449s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f36429u ? (i) ((LayerDrawable) ((InsetDrawable) this.f36449s.getDrawable(0)).getDrawable()).getDrawable(!z11 ? 1 : 0) : (i) this.f36449s.getDrawable(!z11 ? 1 : 0);
    }

    @Nullable
    public ColorStateList h() {
        return this.f36442l;
    }

    @NonNull
    public n i() {
        return this.f36432b;
    }

    @Nullable
    public ColorStateList j() {
        return this.f36441k;
    }

    public int k() {
        return this.f36438h;
    }

    public ColorStateList l() {
        return this.f36440j;
    }

    public PorterDuff.Mode m() {
        return this.f36439i;
    }

    @Nullable
    public final i n() {
        return g(true);
    }

    public boolean o() {
        return this.f36445o;
    }

    public boolean p() {
        return this.f36447q;
    }

    public boolean q() {
        return this.f36448r;
    }

    public void r(@NonNull TypedArray typedArray) {
        this.f36433c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f36434d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f36435e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f36436f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R$styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
            this.f36437g = dimensionPixelSize;
            z(this.f36432b.w(dimensionPixelSize));
            this.f36446p = true;
        }
        this.f36438h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f36439i = f0.r(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f36440j = d.a(this.f36431a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.f36441k = d.a(this.f36431a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.f36442l = d.a(this.f36431a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f36447q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.f36450t = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        this.f36448r = typedArray.getBoolean(R$styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = ViewCompat.getPaddingStart(this.f36431a);
        int paddingTop = this.f36431a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f36431a);
        int paddingBottom = this.f36431a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            t();
        } else {
            H();
        }
        ViewCompat.setPaddingRelative(this.f36431a, paddingStart + this.f36433c, paddingTop + this.f36435e, paddingEnd + this.f36434d, paddingBottom + this.f36436f);
    }

    public void s(int i11) {
        if (f() != null) {
            f().setTint(i11);
        }
    }

    public void t() {
        this.f36445o = true;
        this.f36431a.setSupportBackgroundTintList(this.f36440j);
        this.f36431a.setSupportBackgroundTintMode(this.f36439i);
    }

    public void u(boolean z11) {
        this.f36447q = z11;
    }

    public void v(int i11) {
        if (this.f36446p && this.f36437g == i11) {
            return;
        }
        this.f36437g = i11;
        this.f36446p = true;
        z(this.f36432b.w(i11));
    }

    public void w(int i11) {
        G(this.f36435e, i11);
    }

    public void x(int i11) {
        G(i11, this.f36436f);
    }

    public void y(@Nullable ColorStateList colorStateList) {
        if (this.f36442l != colorStateList) {
            this.f36442l = colorStateList;
            boolean z11 = f36429u;
            if (z11 && (this.f36431a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f36431a.getBackground()).setColor(wi.b.e(colorStateList));
            } else {
                if (z11 || !(this.f36431a.getBackground() instanceof wi.a)) {
                    return;
                }
                ((wi.a) this.f36431a.getBackground()).setTintList(wi.b.e(colorStateList));
            }
        }
    }

    public void z(@NonNull n nVar) {
        this.f36432b = nVar;
        I(nVar);
    }
}
