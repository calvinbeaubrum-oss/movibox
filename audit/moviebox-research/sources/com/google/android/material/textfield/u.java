package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    @Nullable
    public ColorStateList A;
    public Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f37812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f37813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f37814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f37815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f37816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f37817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextInputLayout f37818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f37819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f37821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Animator f37822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f37823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public CharSequence f37826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f37827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public TextView f37828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public CharSequence f37829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f37830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f37831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public ColorStateList f37832v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f37833w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f37834x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public TextView f37835y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f37836z;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f37837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f37838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f37839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f37840d;

        public a(int i11, TextView textView, int i12, TextView textView2) {
            this.f37837a = i11;
            this.f37838b = textView;
            this.f37839c = i12;
            this.f37840d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f37824n = this.f37837a;
            u.this.f37822l = null;
            TextView textView = this.f37838b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f37839c == 1 && u.this.f37828r != null) {
                    u.this.f37828r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f37840d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f37840d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f37840d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f37840d.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends View.AccessibilityDelegate {
        public b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f37818h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f37817g = context;
        this.f37818h = textInputLayout;
        this.f37823m = context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
        this.f37811a = ti.j.f(context, R$attr.motionDurationShort4, 217);
        this.f37812b = ti.j.f(context, R$attr.motionDurationMedium4, 167);
        this.f37813c = ti.j.f(context, R$attr.motionDurationShort4, 167);
        this.f37814d = ti.j.g(context, R$attr.motionEasingEmphasizedDecelerateInterpolator, ii.b.f67204d);
        int i11 = R$attr.motionEasingEmphasizedDecelerateInterpolator;
        TimeInterpolator timeInterpolator = ii.b.f67201a;
        this.f37815e = ti.j.g(context, i11, timeInterpolator);
        this.f37816f = ti.j.g(context, R$attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    public boolean A() {
        return this.f37827q;
    }

    public boolean B() {
        return this.f37834x;
    }

    public void C(TextView textView, int i11) {
        FrameLayout frameLayout;
        if (this.f37819i == null) {
            return;
        }
        if (!z(i11) || (frameLayout = this.f37821k) == null) {
            this.f37819i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i12 = this.f37820j - 1;
        this.f37820j = i12;
        O(this.f37819i, i12);
    }

    public final void D(int i11, int i12) {
        TextView textViewM;
        TextView textViewM2;
        if (i11 == i12) {
            return;
        }
        if (i12 != 0 && (textViewM2 = m(i12)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i11 != 0 && (textViewM = m(i11)) != null) {
            textViewM.setVisibility(4);
            if (i11 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f37824n = i12;
    }

    public void E(int i11) {
        this.f37830t = i11;
        TextView textView = this.f37828r;
        if (textView != null) {
            ViewCompat.setAccessibilityLiveRegion(textView, i11);
        }
    }

    public void F(@Nullable CharSequence charSequence) {
        this.f37829s = charSequence;
        TextView textView = this.f37828r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void G(boolean z11) {
        if (this.f37827q == z11) {
            return;
        }
        h();
        if (z11) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f37817g);
            this.f37828r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            this.f37828r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f37828r.setTypeface(typeface);
            }
            H(this.f37831u);
            I(this.f37832v);
            F(this.f37829s);
            E(this.f37830t);
            this.f37828r.setVisibility(4);
            e(this.f37828r, 0);
        } else {
            w();
            C(this.f37828r, 0);
            this.f37828r = null;
            this.f37818h.j0();
            this.f37818h.u0();
        }
        this.f37827q = z11;
    }

    public void H(int i11) {
        this.f37831u = i11;
        TextView textView = this.f37828r;
        if (textView != null) {
            this.f37818h.W(textView, i11);
        }
    }

    public void I(@Nullable ColorStateList colorStateList) {
        this.f37832v = colorStateList;
        TextView textView = this.f37828r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void J(int i11) {
        this.f37836z = i11;
        TextView textView = this.f37835y;
        if (textView != null) {
            androidx.core.widget.m.p(textView, i11);
        }
    }

    public void K(boolean z11) {
        if (this.f37834x == z11) {
            return;
        }
        h();
        if (z11) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f37817g);
            this.f37835y = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            this.f37835y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f37835y.setTypeface(typeface);
            }
            this.f37835y.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f37835y, 1);
            J(this.f37836z);
            L(this.A);
            e(this.f37835y, 1);
            this.f37835y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f37835y, 1);
            this.f37835y = null;
            this.f37818h.j0();
            this.f37818h.u0();
        }
        this.f37834x = z11;
    }

    public void L(@Nullable ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f37835y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final void M(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f37828r, typeface);
            M(this.f37835y, typeface);
        }
    }

    public final void O(@NonNull ViewGroup viewGroup, int i11) {
        if (i11 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean P(@Nullable TextView textView, @NonNull CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f37818h) && this.f37818h.isEnabled() && !(this.f37825o == this.f37824n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public void Q(CharSequence charSequence) {
        h();
        this.f37826p = charSequence;
        this.f37828r.setText(charSequence);
        int i11 = this.f37824n;
        if (i11 != 1) {
            this.f37825o = 1;
        }
        S(i11, this.f37825o, P(this.f37828r, charSequence));
    }

    public void R(CharSequence charSequence) {
        h();
        this.f37833w = charSequence;
        this.f37835y.setText(charSequence);
        int i11 = this.f37824n;
        if (i11 != 2) {
            this.f37825o = 2;
        }
        S(i11, this.f37825o, P(this.f37835y, charSequence));
    }

    public final void S(int i11, int i12, boolean z11) {
        if (i11 == i12) {
            return;
        }
        if (z11) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f37822l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f37834x, this.f37835y, 2, i11, i12);
            i(arrayList, this.f37827q, this.f37828r, 1, i11, i12);
            ii.c.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i12, m(i11), i11, m(i12)));
            animatorSet.start();
        } else {
            D(i11, i12);
        }
        this.f37818h.j0();
        this.f37818h.o0(z11);
        this.f37818h.u0();
    }

    public void e(TextView textView, int i11) {
        if (this.f37819i == null && this.f37821k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f37817g);
            this.f37819i = linearLayout;
            linearLayout.setOrientation(0);
            this.f37818h.addView(this.f37819i, -1, -2);
            this.f37821k = new FrameLayout(this.f37817g);
            this.f37819i.addView(this.f37821k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f37818h.getEditText() != null) {
                f();
            }
        }
        if (z(i11)) {
            this.f37821k.setVisibility(0);
            this.f37821k.addView(textView);
        } else {
            this.f37819i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f37819i.setVisibility(0);
        this.f37820j++;
    }

    public void f() {
        if (g()) {
            EditText editText = this.f37818h.getEditText();
            boolean zJ = vi.d.j(this.f37817g);
            ViewCompat.setPaddingRelative(this.f37819i, v(zJ, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(editText)), v(zJ, R$dimen.material_helper_text_font_1_3_padding_top, this.f37817g.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), v(zJ, R$dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    public final boolean g() {
        return (this.f37819i == null || this.f37818h.getEditText() == null) ? false : true;
    }

    public void h() {
        Animator animator = this.f37822l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void i(@NonNull List<Animator> list, boolean z11, @Nullable TextView textView, int i11, int i12, int i13) {
        if (textView == null || !z11) {
            return;
        }
        if (i11 == i13 || i11 == i12) {
            ObjectAnimator objectAnimatorJ = j(textView, i13 == i11);
            if (i11 == i13 && i12 != 0) {
                objectAnimatorJ.setStartDelay(this.f37813c);
            }
            list.add(objectAnimatorJ);
            if (i13 != i11 || i12 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f37813c);
            list.add(objectAnimatorK);
        }
    }

    public final ObjectAnimator j(TextView textView, boolean z11) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z11 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z11 ? this.f37812b : this.f37813c);
        objectAnimatorOfFloat.setInterpolator(z11 ? this.f37815e : this.f37816f);
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f37823m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f37811a);
        objectAnimatorOfFloat.setInterpolator(this.f37814d);
        return objectAnimatorOfFloat;
    }

    public boolean l() {
        return y(this.f37825o);
    }

    @Nullable
    public final TextView m(int i11) {
        if (i11 == 1) {
            return this.f37828r;
        }
        if (i11 != 2) {
            return null;
        }
        return this.f37835y;
    }

    public int n() {
        return this.f37830t;
    }

    @Nullable
    public CharSequence o() {
        return this.f37829s;
    }

    @Nullable
    public CharSequence p() {
        return this.f37826p;
    }

    public int q() {
        TextView textView = this.f37828r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public ColorStateList r() {
        TextView textView = this.f37828r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence s() {
        return this.f37833w;
    }

    @Nullable
    public View t() {
        return this.f37835y;
    }

    public int u() {
        TextView textView = this.f37835y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int v(boolean z11, int i11, int i12) {
        return z11 ? this.f37817g.getResources().getDimensionPixelSize(i11) : i12;
    }

    public void w() {
        this.f37826p = null;
        h();
        if (this.f37824n == 1) {
            if (!this.f37834x || TextUtils.isEmpty(this.f37833w)) {
                this.f37825o = 0;
            } else {
                this.f37825o = 2;
            }
        }
        S(this.f37824n, this.f37825o, P(this.f37828r, ""));
    }

    public void x() {
        h();
        int i11 = this.f37824n;
        if (i11 == 2) {
            this.f37825o = 0;
        }
        S(i11, this.f37825o, P(this.f37835y, ""));
    }

    public final boolean y(int i11) {
        return (i11 != 1 || this.f37828r == null || TextUtils.isEmpty(this.f37826p)) ? false : true;
    }

    public boolean z(int i11) {
        return i11 == 0 || i11 == 1;
    }
}
