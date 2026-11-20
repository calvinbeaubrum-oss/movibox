package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class p extends s {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f37761s = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f37762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f37763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f37764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public AutoCompleteTextView f37765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View.OnClickListener f37766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View.OnFocusChangeListener f37767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AccessibilityManagerCompat.TouchExplorationStateChangeListener f37768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f37770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f37771n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f37772o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public AccessibilityManager f37773p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f37774q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f37775r;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f37775r.start();
        }
    }

    public p(@NonNull r rVar) {
        super(rVar);
        this.f37766i = new View.OnClickListener() { // from class: com.google.android.material.textfield.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f37754a.J(view);
            }
        };
        this.f37767j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z11) {
                this.f37755a.K(view, z11);
            }
        };
        this.f37768k = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.k
            @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z11) {
                this.f37756a.L(z11);
            }
        };
        this.f37772o = Long.MAX_VALUE;
        this.f37763f = ti.j.f(rVar.getContext(), R$attr.motionDurationShort3, 67);
        this.f37762e = ti.j.f(rVar.getContext(), R$attr.motionDurationShort3, 50);
        this.f37764g = ti.j.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, ii.b.f67201a);
    }

    @NonNull
    public static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void F() {
        this.f37775r = E(this.f37763f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f37762e, 1.0f, 0.0f);
        this.f37774q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z11) {
        this.f37769l = z11;
        r();
        if (z11) {
            return;
        }
        O(false);
        this.f37770m = false;
    }

    public final ValueAnimator E(int i11, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f37764g);
        valueAnimatorOfFloat.setDuration(i11);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37757a.I(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f37772o;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    public final /* synthetic */ void H() {
        boolean zIsPopupShowing = this.f37765h.isPopupShowing();
        O(zIsPopupShowing);
        this.f37770m = zIsPopupShowing;
    }

    public final /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f37810d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final /* synthetic */ void L(boolean z11) {
        AutoCompleteTextView autoCompleteTextView = this.f37765h;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        ViewCompat.setImportantForAccessibility(this.f37810d, z11 ? 2 : 1);
    }

    public final /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f37770m = false;
            }
            Q();
            R();
        }
        return false;
    }

    public final /* synthetic */ void N() {
        R();
        O(false);
    }

    public final void O(boolean z11) {
        if (this.f37771n != z11) {
            this.f37771n = z11;
            this.f37775r.cancel();
            this.f37774q.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void P() {
        this.f37765h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f37759a.M(view, motionEvent);
            }
        });
        if (f37761s) {
            this.f37765h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.o
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.f37760a.N();
                }
            });
        }
        this.f37765h.setThreshold(0);
    }

    public final void Q() {
        if (this.f37765h == null) {
            return;
        }
        if (G()) {
            this.f37770m = false;
        }
        if (this.f37770m) {
            this.f37770m = false;
            return;
        }
        if (f37761s) {
            O(!this.f37771n);
        } else {
            this.f37771n = !this.f37771n;
            r();
        }
        if (!this.f37771n) {
            this.f37765h.dismissDropDown();
        } else {
            this.f37765h.requestFocus();
            this.f37765h.showDropDown();
        }
    }

    public final void R() {
        this.f37770m = true;
        this.f37772o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f37773p.isTouchExplorationEnabled() && q.a(this.f37765h) && !this.f37810d.hasFocus()) {
            this.f37765h.dismissDropDown();
        }
        this.f37765h.post(new Runnable() { // from class: com.google.android.material.textfield.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f37758a.H();
            }
        });
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return f37761s ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f37767j;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f37766i;
    }

    @Override // com.google.android.material.textfield.s
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f37768k;
    }

    @Override // com.google.android.material.textfield.s
    public boolean i(int i11) {
        return i11 != 0;
    }

    @Override // com.google.android.material.textfield.s
    public boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean k() {
        return this.f37769l;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return this.f37771n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(@Nullable EditText editText) {
        this.f37765h = D(editText);
        P();
        this.f37807a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f37773p.isTouchExplorationEnabled()) {
            ViewCompat.setImportantForAccessibility(this.f37810d, 2);
        }
        this.f37807a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!q.a(this.f37765h)) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    @SuppressLint({"WrongConstant"})
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        if (!this.f37773p.isEnabled() || q.a(this.f37765h)) {
            return;
        }
        boolean z11 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f37771n && !this.f37765h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z11) {
            Q();
            R();
        }
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        F();
        this.f37773p = (AccessibilityManager) this.f37809c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.s
    public boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f37765h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f37761s) {
                this.f37765h.setOnDismissListener(null);
            }
        }
    }
}
