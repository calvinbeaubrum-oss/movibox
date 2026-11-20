package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.n0;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"ViewConstructor"})
public class r extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f37777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CheckableImageButton f37779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f37780d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f37781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnLongClickListener f37782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final CheckableImageButton f37783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f37784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.f> f37786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f37787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f37788m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37789n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public ImageView.ScaleType f37790o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnLongClickListener f37791p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public CharSequence f37792q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final TextView f37793r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f37794s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public EditText f37795t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public final AccessibilityManager f37796u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener f37797v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextWatcher f37798w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextInputLayout.e f37799x;

    /* JADX INFO: compiled from: source.java */
    public class a extends com.google.android.material.internal.a0 {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.o().a(editable);
        }

        @Override // com.google.android.material.internal.a0, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            r.this.o().b(charSequence, i11, i12, i13);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements TextInputLayout.e {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(@NonNull TextInputLayout textInputLayout) {
            if (r.this.f37795t == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.f37795t != null) {
                r.this.f37795t.removeTextChangedListener(r.this.f37798w);
                if (r.this.f37795t.getOnFocusChangeListener() == r.this.o().e()) {
                    r.this.f37795t.setOnFocusChangeListener(null);
                }
            }
            r.this.f37795t = textInputLayout.getEditText();
            if (r.this.f37795t != null) {
                r.this.f37795t.addTextChangedListener(r.this.f37798w);
            }
            r.this.o().n(r.this.f37795t);
            r rVar = r.this;
            rVar.m0(rVar.o());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.h();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.R();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<s> f37803a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f37804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f37805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f37806d;

        public d(r rVar, n0 n0Var) {
            this.f37804b = rVar;
            this.f37805c = n0Var.n(R$styleable.TextInputLayout_endIconDrawable, 0);
            this.f37806d = n0Var.n(R$styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        public final s b(int i11) {
            if (i11 == -1) {
                return new g(this.f37804b);
            }
            if (i11 == 0) {
                return new v(this.f37804b);
            }
            if (i11 == 1) {
                return new x(this.f37804b, this.f37806d);
            }
            if (i11 == 2) {
                return new f(this.f37804b);
            }
            if (i11 == 3) {
                return new p(this.f37804b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i11);
        }

        public s c(int i11) {
            s sVar = this.f37803a.get(i11);
            if (sVar != null) {
                return sVar;
            }
            s sVarB = b(i11);
            this.f37803a.append(i11, sVarB);
            return sVarB;
        }
    }

    public r(TextInputLayout textInputLayout, n0 n0Var) {
        super(textInputLayout.getContext());
        this.f37785j = 0;
        this.f37786k = new LinkedHashSet<>();
        this.f37798w = new a();
        b bVar = new b();
        this.f37799x = bVar;
        this.f37796u = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f37777a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f37778b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonK = k(this, layoutInflaterFrom, R$id.text_input_error_icon);
        this.f37779c = checkableImageButtonK;
        CheckableImageButton checkableImageButtonK2 = k(frameLayout, layoutInflaterFrom, R$id.text_input_end_icon);
        this.f37783h = checkableImageButtonK2;
        this.f37784i = new d(this, n0Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f37793r = appCompatTextView;
        E(n0Var);
        D(n0Var);
        F(n0Var);
        frameLayout.addView(checkableImageButtonK2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonK);
        textInputLayout.addOnEditTextAttachedListener(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public int A() {
        return ViewCompat.getPaddingEnd(this) + ViewCompat.getPaddingEnd(this.f37793r) + ((I() || J()) ? this.f37783h.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.f37783h.getLayoutParams()) : 0);
    }

    public void A0(boolean z11) {
        if (this.f37785j == 1) {
            this.f37783h.performClick();
            if (z11) {
                this.f37783h.jumpDrawablesToCurrentState();
            }
        }
    }

    public TextView B() {
        return this.f37793r;
    }

    public final void B0() {
        this.f37778b.setVisibility((this.f37783h.getVisibility() != 0 || J()) ? 8 : 0);
        setVisibility((I() || J() || ((this.f37792q == null || this.f37794s) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public boolean C() {
        return this.f37785j != 0;
    }

    public final void C0() {
        this.f37779c.setVisibility(u() != null && this.f37777a.isErrorEnabled() && this.f37777a.X() ? 0 : 8);
        B0();
        D0();
        if (C()) {
            return;
        }
        this.f37777a.i0();
    }

    public final void D(n0 n0Var) {
        if (!n0Var.s(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            if (n0Var.s(R$styleable.TextInputLayout_endIconTint)) {
                this.f37787l = vi.d.b(getContext(), n0Var, R$styleable.TextInputLayout_endIconTint);
            }
            if (n0Var.s(R$styleable.TextInputLayout_endIconTintMode)) {
                this.f37788m = com.google.android.material.internal.f0.r(n0Var.k(R$styleable.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (n0Var.s(R$styleable.TextInputLayout_endIconMode)) {
            Z(n0Var.k(R$styleable.TextInputLayout_endIconMode, 0));
            if (n0Var.s(R$styleable.TextInputLayout_endIconContentDescription)) {
                V(n0Var.p(R$styleable.TextInputLayout_endIconContentDescription));
            }
            T(n0Var.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (n0Var.s(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            if (n0Var.s(R$styleable.TextInputLayout_passwordToggleTint)) {
                this.f37787l = vi.d.b(getContext(), n0Var, R$styleable.TextInputLayout_passwordToggleTint);
            }
            if (n0Var.s(R$styleable.TextInputLayout_passwordToggleTintMode)) {
                this.f37788m = com.google.android.material.internal.f0.r(n0Var.k(R$styleable.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            Z(n0Var.a(R$styleable.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            V(n0Var.p(R$styleable.TextInputLayout_passwordToggleContentDescription));
        }
        Y(n0Var.f(R$styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        if (n0Var.s(R$styleable.TextInputLayout_endIconScaleType)) {
            c0(t.b(n0Var.k(R$styleable.TextInputLayout_endIconScaleType, -1)));
        }
    }

    public void D0() {
        if (this.f37777a.f37684d == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.f37793r, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f37777a.f37684d.getPaddingTop(), (I() || J()) ? 0 : ViewCompat.getPaddingEnd(this.f37777a.f37684d), this.f37777a.f37684d.getPaddingBottom());
    }

    public final void E(n0 n0Var) {
        if (n0Var.s(R$styleable.TextInputLayout_errorIconTint)) {
            this.f37780d = vi.d.b(getContext(), n0Var, R$styleable.TextInputLayout_errorIconTint);
        }
        if (n0Var.s(R$styleable.TextInputLayout_errorIconTintMode)) {
            this.f37781f = com.google.android.material.internal.f0.r(n0Var.k(R$styleable.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (n0Var.s(R$styleable.TextInputLayout_errorIconDrawable)) {
            h0(n0Var.g(R$styleable.TextInputLayout_errorIconDrawable));
        }
        this.f37779c.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.f37779c, 2);
        this.f37779c.setClickable(false);
        this.f37779c.setPressable(false);
        this.f37779c.setFocusable(false);
    }

    public final void E0() {
        int visibility = this.f37793r.getVisibility();
        int i11 = (this.f37792q == null || this.f37794s) ? 8 : 0;
        if (visibility != i11) {
            o().q(i11 == 0);
        }
        B0();
        this.f37793r.setVisibility(i11);
        this.f37777a.i0();
    }

    public final void F(n0 n0Var) {
        this.f37793r.setVisibility(8);
        this.f37793r.setId(R$id.textinput_suffix_text);
        this.f37793r.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.f37793r, 1);
        v0(n0Var.n(R$styleable.TextInputLayout_suffixTextAppearance, 0));
        if (n0Var.s(R$styleable.TextInputLayout_suffixTextColor)) {
            w0(n0Var.c(R$styleable.TextInputLayout_suffixTextColor));
        }
        u0(n0Var.p(R$styleable.TextInputLayout_suffixText));
    }

    public boolean G() {
        return this.f37783h.isCheckable();
    }

    public boolean H() {
        return C() && this.f37783h.isChecked();
    }

    public boolean I() {
        return this.f37778b.getVisibility() == 0 && this.f37783h.getVisibility() == 0;
    }

    public boolean J() {
        return this.f37779c.getVisibility() == 0;
    }

    public boolean K() {
        return this.f37785j == 1;
    }

    public void L(boolean z11) {
        this.f37794s = z11;
        E0();
    }

    public void M() {
        C0();
        O();
        N();
        if (o().t()) {
            z0(this.f37777a.X());
        }
    }

    public void N() {
        t.d(this.f37777a, this.f37783h, this.f37787l);
    }

    public void O() {
        t.d(this.f37777a, this.f37779c, this.f37780d);
    }

    public void P(boolean z11) {
        boolean z12;
        boolean zIsActivated;
        boolean zIsChecked;
        s sVarO = o();
        boolean z13 = true;
        if (!sVarO.l() || (zIsChecked = this.f37783h.isChecked()) == sVarO.m()) {
            z12 = false;
        } else {
            this.f37783h.setChecked(!zIsChecked);
            z12 = true;
        }
        if (!sVarO.j() || (zIsActivated = this.f37783h.isActivated()) == sVarO.k()) {
            z13 = z12;
        } else {
            S(!zIsActivated);
        }
        if (z11 || z13) {
            N();
        }
    }

    public void Q(@NonNull TextInputLayout.f fVar) {
        this.f37786k.remove(fVar);
    }

    public final void R() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f37797v;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.f37796u) == null) {
            return;
        }
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    public void S(boolean z11) {
        this.f37783h.setActivated(z11);
    }

    public void T(boolean z11) {
        this.f37783h.setCheckable(z11);
    }

    public void U(@StringRes int i11) {
        V(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void V(@Nullable CharSequence charSequence) {
        if (n() != charSequence) {
            this.f37783h.setContentDescription(charSequence);
        }
    }

    public void W(int i11) {
        X(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    public void X(@Nullable Drawable drawable) {
        this.f37783h.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f37777a, this.f37783h, this.f37787l, this.f37788m);
            N();
        }
    }

    public void Y(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i11 != this.f37789n) {
            this.f37789n = i11;
            t.g(this.f37783h, i11);
            t.g(this.f37779c, i11);
        }
    }

    public void Z(int i11) {
        if (this.f37785j == i11) {
            return;
        }
        y0(o());
        int i12 = this.f37785j;
        this.f37785j = i11;
        l(i12);
        f0(i11 != 0);
        s sVarO = o();
        W(v(sVarO));
        U(sVarO.c());
        T(sVarO.l());
        if (!sVarO.i(this.f37777a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f37777a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i11);
        }
        x0(sVarO);
        a0(sVarO.f());
        EditText editText = this.f37795t;
        if (editText != null) {
            sVarO.n(editText);
            m0(sVarO);
        }
        t.a(this.f37777a, this.f37783h, this.f37787l, this.f37788m);
        P(true);
    }

    public void a0(@Nullable View.OnClickListener onClickListener) {
        t.h(this.f37783h, onClickListener, this.f37791p);
    }

    public void b0(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f37791p = onLongClickListener;
        t.i(this.f37783h, onLongClickListener);
    }

    public void c0(@NonNull ImageView.ScaleType scaleType) {
        this.f37790o = scaleType;
        t.j(this.f37783h, scaleType);
        t.j(this.f37779c, scaleType);
    }

    public void d0(@Nullable ColorStateList colorStateList) {
        if (this.f37787l != colorStateList) {
            this.f37787l = colorStateList;
            t.a(this.f37777a, this.f37783h, colorStateList, this.f37788m);
        }
    }

    public void e0(@Nullable PorterDuff.Mode mode) {
        if (this.f37788m != mode) {
            this.f37788m = mode;
            t.a(this.f37777a, this.f37783h, this.f37787l, mode);
        }
    }

    public void f0(boolean z11) {
        if (I() != z11) {
            this.f37783h.setVisibility(z11 ? 0 : 8);
            B0();
            D0();
            this.f37777a.i0();
        }
    }

    public void g(@NonNull TextInputLayout.f fVar) {
        this.f37786k.add(fVar);
    }

    public void g0(int i11) {
        h0(i11 != 0 ? d1.a.b(getContext(), i11) : null);
        O();
    }

    public final void h() {
        if (this.f37797v == null || this.f37796u == null || !ViewCompat.isAttachedToWindow(this)) {
            return;
        }
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f37796u, this.f37797v);
    }

    public void h0(@Nullable Drawable drawable) {
        this.f37779c.setImageDrawable(drawable);
        C0();
        t.a(this.f37777a, this.f37779c, this.f37780d, this.f37781f);
    }

    public void i() {
        this.f37783h.performClick();
        this.f37783h.jumpDrawablesToCurrentState();
    }

    public void i0(@Nullable View.OnClickListener onClickListener) {
        t.h(this.f37779c, onClickListener, this.f37782g);
    }

    public void j() {
        this.f37786k.clear();
    }

    public void j0(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f37782g = onLongClickListener;
        t.i(this.f37779c, onLongClickListener);
    }

    public final CheckableImageButton k(ViewGroup viewGroup, LayoutInflater layoutInflater, int i11) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R$layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i11);
        t.e(checkableImageButton);
        if (vi.d.j(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public void k0(@Nullable ColorStateList colorStateList) {
        if (this.f37780d != colorStateList) {
            this.f37780d = colorStateList;
            t.a(this.f37777a, this.f37779c, colorStateList, this.f37781f);
        }
    }

    public final void l(int i11) {
        Iterator<TextInputLayout.f> it = this.f37786k.iterator();
        while (it.hasNext()) {
            it.next().a(this.f37777a, i11);
        }
    }

    public void l0(@Nullable PorterDuff.Mode mode) {
        if (this.f37781f != mode) {
            this.f37781f = mode;
            t.a(this.f37777a, this.f37779c, this.f37780d, mode);
        }
    }

    @Nullable
    public CheckableImageButton m() {
        if (J()) {
            return this.f37779c;
        }
        if (C() && I()) {
            return this.f37783h;
        }
        return null;
    }

    public final void m0(s sVar) {
        if (this.f37795t == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f37795t.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f37783h.setOnFocusChangeListener(sVar.g());
        }
    }

    @Nullable
    public CharSequence n() {
        return this.f37783h.getContentDescription();
    }

    public void n0(@StringRes int i11) {
        o0(i11 != 0 ? getResources().getText(i11) : null);
    }

    public s o() {
        return this.f37784i.c(this.f37785j);
    }

    public void o0(@Nullable CharSequence charSequence) {
        this.f37783h.setContentDescription(charSequence);
    }

    @Nullable
    public Drawable p() {
        return this.f37783h.getDrawable();
    }

    public void p0(int i11) {
        q0(i11 != 0 ? d1.a.b(getContext(), i11) : null);
    }

    public int q() {
        return this.f37789n;
    }

    public void q0(@Nullable Drawable drawable) {
        this.f37783h.setImageDrawable(drawable);
    }

    public int r() {
        return this.f37785j;
    }

    public void r0(boolean z11) {
        if (z11 && this.f37785j != 1) {
            Z(1);
        } else {
            if (z11) {
                return;
            }
            Z(0);
        }
    }

    @NonNull
    public ImageView.ScaleType s() {
        return this.f37790o;
    }

    public void s0(@Nullable ColorStateList colorStateList) {
        this.f37787l = colorStateList;
        t.a(this.f37777a, this.f37783h, colorStateList, this.f37788m);
    }

    public CheckableImageButton t() {
        return this.f37783h;
    }

    public void t0(@Nullable PorterDuff.Mode mode) {
        this.f37788m = mode;
        t.a(this.f37777a, this.f37783h, this.f37787l, mode);
    }

    public Drawable u() {
        return this.f37779c.getDrawable();
    }

    public void u0(@Nullable CharSequence charSequence) {
        this.f37792q = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f37793r.setText(charSequence);
        E0();
    }

    public final int v(s sVar) {
        int i11 = this.f37784i.f37805c;
        return i11 == 0 ? sVar.d() : i11;
    }

    public void v0(int i11) {
        androidx.core.widget.m.p(this.f37793r, i11);
    }

    @Nullable
    public CharSequence w() {
        return this.f37783h.getContentDescription();
    }

    public void w0(@NonNull ColorStateList colorStateList) {
        this.f37793r.setTextColor(colorStateList);
    }

    @Nullable
    public Drawable x() {
        return this.f37783h.getDrawable();
    }

    public final void x0(@NonNull s sVar) {
        sVar.s();
        this.f37797v = sVar.h();
        h();
    }

    @Nullable
    public CharSequence y() {
        return this.f37792q;
    }

    public final void y0(@NonNull s sVar) {
        R();
        this.f37797v = null;
        sVar.u();
    }

    @Nullable
    public ColorStateList z() {
        return this.f37793r.getTextColors();
    }

    public final void z0(boolean z11) {
        if (!z11 || p() == null) {
            t.a(this.f37777a, this.f37783h, this.f37787l, this.f37788m);
            return;
        }
        Drawable drawableMutate = d3.a.r(p()).mutate();
        d3.a.n(drawableMutate, this.f37777a.getErrorCurrentTextColors());
        this.f37783h.setImageDrawable(drawableMutate);
    }
}
