package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class f extends s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f37741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f37742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f37743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f37744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public EditText f37745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View.OnClickListener f37746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnFocusChangeListener f37747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f37748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f37749m;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f37808b.f0(true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f37808b.f0(false);
        }
    }

    public f(@NonNull r rVar) {
        super(rVar);
        this.f37746j = new View.OnClickListener() { // from class: com.google.android.material.textfield.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f37739a.G(view);
            }
        };
        this.f37747k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z11) {
                this.f37740a.H(view, z11);
            }
        };
        this.f37741e = ti.j.f(rVar.getContext(), R$attr.motionDurationShort3, 100);
        this.f37742f = ti.j.f(rVar.getContext(), R$attr.motionDurationShort3, 150);
        this.f37743g = ti.j.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, ii.b.f67201a);
        this.f37744h = ti.j.g(rVar.getContext(), R$attr.motionEasingEmphasizedInterpolator, ii.b.f67204d);
    }

    public final void A(boolean z11) {
        boolean z12 = this.f37808b.I() == z11;
        if (z11 && !this.f37748l.isRunning()) {
            this.f37749m.cancel();
            this.f37748l.start();
            if (z12) {
                this.f37748l.end();
                return;
            }
            return;
        }
        if (z11) {
            return;
        }
        this.f37748l.cancel();
        this.f37749m.start();
        if (z12) {
            this.f37749m.end();
        }
    }

    public final ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f37743g);
        valueAnimatorOfFloat.setDuration(this.f37741e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37738a.E(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f37744h);
        valueAnimatorOfFloat.setDuration(this.f37742f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37737a.F(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f37748l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f37748l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f37749m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    public final /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f37810d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final /* synthetic */ void F(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f37810d.setScaleX(fFloatValue);
        this.f37810d.setScaleY(fFloatValue);
    }

    public final /* synthetic */ void G(View view) {
        EditText editText = this.f37745i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    public final /* synthetic */ void H(View view, boolean z11) {
        A(J());
    }

    public final /* synthetic */ void I() {
        A(true);
    }

    public final boolean J() {
        EditText editText = this.f37745i;
        return editText != null && (editText.hasFocus() || this.f37810d.hasFocus()) && this.f37745i.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.s
    public void a(@NonNull Editable editable) {
        if (this.f37808b.y() != null) {
            return;
        }
        A(J());
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return R$drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f37747k;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f37746j;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener g() {
        return this.f37747k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(@Nullable EditText editText) {
        this.f37745i = editText;
        this.f37807a.setEndIconVisible(J());
    }

    @Override // com.google.android.material.textfield.s
    public void q(boolean z11) {
        if (this.f37808b.y() == null) {
            return;
        }
        A(z11);
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        D();
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f37745i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f37736a.I();
                }
            });
        }
    }
}
