package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.n0;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"ViewConstructor"})
public class y extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f37847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f37848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public CharSequence f37849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f37850d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f37851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f37852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public ImageView.ScaleType f37854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnLongClickListener f37855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f37856k;

    public y(TextInputLayout textInputLayout, n0 n0Var) {
        super(textInputLayout.getContext());
        this.f37847a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f37850d = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f37848b = appCompatTextView;
        j(n0Var);
        i(n0Var);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public void A(boolean z11) {
        if (l() != z11) {
            this.f37850d.setVisibility(z11 ? 0 : 8);
            C();
            D();
        }
    }

    public void B(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f37848b.getVisibility() != 0) {
            accessibilityNodeInfoCompat.setTraversalAfter(this.f37850d);
        } else {
            accessibilityNodeInfoCompat.setLabelFor(this.f37848b);
            accessibilityNodeInfoCompat.setTraversalAfter(this.f37848b);
        }
    }

    public void C() {
        EditText editText = this.f37847a.f37684d;
        if (editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.f37848b, l() ? 0 : ViewCompat.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void D() {
        int i11 = (this.f37849c == null || this.f37856k) ? 8 : 0;
        setVisibility((this.f37850d.getVisibility() == 0 || i11 == 0) ? 0 : 8);
        this.f37848b.setVisibility(i11);
        this.f37847a.i0();
    }

    @Nullable
    public CharSequence a() {
        return this.f37849c;
    }

    @Nullable
    public ColorStateList b() {
        return this.f37848b.getTextColors();
    }

    public int c() {
        return ViewCompat.getPaddingStart(this) + ViewCompat.getPaddingStart(this.f37848b) + (l() ? this.f37850d.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) this.f37850d.getLayoutParams()) : 0);
    }

    @NonNull
    public TextView d() {
        return this.f37848b;
    }

    @Nullable
    public CharSequence e() {
        return this.f37850d.getContentDescription();
    }

    @Nullable
    public Drawable f() {
        return this.f37850d.getDrawable();
    }

    public int g() {
        return this.f37853h;
    }

    @NonNull
    public ImageView.ScaleType h() {
        return this.f37854i;
    }

    public final void i(n0 n0Var) {
        this.f37848b.setVisibility(8);
        this.f37848b.setId(R$id.textinput_prefix_text);
        this.f37848b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f37848b, 1);
        p(n0Var.n(R$styleable.TextInputLayout_prefixTextAppearance, 0));
        if (n0Var.s(R$styleable.TextInputLayout_prefixTextColor)) {
            q(n0Var.c(R$styleable.TextInputLayout_prefixTextColor));
        }
        o(n0Var.p(R$styleable.TextInputLayout_prefixText));
    }

    public final void j(n0 n0Var) {
        if (vi.d.j(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f37850d.getLayoutParams(), 0);
        }
        v(null);
        w(null);
        if (n0Var.s(R$styleable.TextInputLayout_startIconTint)) {
            this.f37851f = vi.d.b(getContext(), n0Var, R$styleable.TextInputLayout_startIconTint);
        }
        if (n0Var.s(R$styleable.TextInputLayout_startIconTintMode)) {
            this.f37852g = com.google.android.material.internal.f0.r(n0Var.k(R$styleable.TextInputLayout_startIconTintMode, -1), null);
        }
        if (n0Var.s(R$styleable.TextInputLayout_startIconDrawable)) {
            t(n0Var.g(R$styleable.TextInputLayout_startIconDrawable));
            if (n0Var.s(R$styleable.TextInputLayout_startIconContentDescription)) {
                s(n0Var.p(R$styleable.TextInputLayout_startIconContentDescription));
            }
            r(n0Var.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        u(n0Var.f(R$styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        if (n0Var.s(R$styleable.TextInputLayout_startIconScaleType)) {
            x(t.b(n0Var.k(R$styleable.TextInputLayout_startIconScaleType, -1)));
        }
    }

    public boolean k() {
        return this.f37850d.isCheckable();
    }

    public boolean l() {
        return this.f37850d.getVisibility() == 0;
    }

    public void m(boolean z11) {
        this.f37856k = z11;
        D();
    }

    public void n() {
        t.d(this.f37847a, this.f37850d, this.f37851f);
    }

    public void o(@Nullable CharSequence charSequence) {
        this.f37849c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f37848b.setText(charSequence);
        D();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        C();
    }

    public void p(int i11) {
        androidx.core.widget.m.p(this.f37848b, i11);
    }

    public void q(@NonNull ColorStateList colorStateList) {
        this.f37848b.setTextColor(colorStateList);
    }

    public void r(boolean z11) {
        this.f37850d.setCheckable(z11);
    }

    public void s(@Nullable CharSequence charSequence) {
        if (e() != charSequence) {
            this.f37850d.setContentDescription(charSequence);
        }
    }

    public void t(@Nullable Drawable drawable) {
        this.f37850d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f37847a, this.f37850d, this.f37851f, this.f37852g);
            A(true);
            n();
        } else {
            A(false);
            v(null);
            w(null);
            s(null);
        }
    }

    public void u(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i11 != this.f37853h) {
            this.f37853h = i11;
            t.g(this.f37850d, i11);
        }
    }

    public void v(@Nullable View.OnClickListener onClickListener) {
        t.h(this.f37850d, onClickListener, this.f37855j);
    }

    public void w(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f37855j = onLongClickListener;
        t.i(this.f37850d, onLongClickListener);
    }

    public void x(@NonNull ImageView.ScaleType scaleType) {
        this.f37854i = scaleType;
        t.j(this.f37850d, scaleType);
    }

    public void y(@Nullable ColorStateList colorStateList) {
        if (this.f37851f != colorStateList) {
            this.f37851f = colorStateList;
            t.a(this.f37847a, this.f37850d, colorStateList, this.f37852g);
        }
    }

    public void z(@Nullable PorterDuff.Mode mode) {
        if (this.f37852g != mode) {
            this.f37852g = mode;
            t.a(this.f37847a, this.f37850d, this.f37851f, mode);
        }
    }
}
