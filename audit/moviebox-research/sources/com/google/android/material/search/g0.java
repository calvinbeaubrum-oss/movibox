package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchView f37412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f37413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f37414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f37415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f37416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Toolbar f37417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Toolbar f37418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f37419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final EditText f37420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageButton f37421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f37422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TouchObserverFrameLayout f37423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ti.h f37424m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public AnimatorSet f37425n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SearchBar f37426o;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!g0.this.f37412a.k()) {
                g0.this.f37412a.x();
            }
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g0.this.f37414c.setVisibility(0);
            g0.this.f37426o.stopOnLoadAnimation();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g0.this.f37414c.setVisibility(8);
            if (!g0.this.f37412a.k()) {
                g0.this.f37412a.clearFocusAndHideKeyboard();
            }
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!g0.this.f37412a.k()) {
                g0.this.f37412a.x();
            }
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g0.this.f37414c.setVisibility(0);
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.SHOWING);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g0.this.f37414c.setVisibility(8);
            if (!g0.this.f37412a.k()) {
                g0.this.f37412a.clearFocusAndHideKeyboard();
            }
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g0.this.f37412a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f37431a;

        public e(boolean z11) {
            this.f37431a = z11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g0.this.U(this.f37431a ? 1.0f : 0.0f);
            g0.this.f37414c.resetClipBoundsAndCornerRadius();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g0.this.U(this.f37431a ? 0.0f : 1.0f);
        }
    }

    public g0(SearchView searchView) {
        this.f37412a = searchView;
        this.f37413b = searchView.f37365a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f37366b;
        this.f37414c = clippableRoundedCornerLayout;
        this.f37415d = searchView.f37369f;
        this.f37416e = searchView.f37370g;
        this.f37417f = searchView.f37371h;
        this.f37418g = searchView.f37372i;
        this.f37419h = searchView.f37373j;
        this.f37420i = searchView.f37374k;
        this.f37421j = searchView.f37375l;
        this.f37422k = searchView.f37376m;
        this.f37423l = searchView.f37377n;
        this.f37424m = new ti.h(clippableRoundedCornerLayout);
    }

    public static /* synthetic */ void N(androidx.appcompat.graphics.drawable.c cVar, ValueAnimator valueAnimator) {
        cVar.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void O(com.google.android.material.internal.h hVar, ValueAnimator valueAnimator) {
        hVar.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final Animator A(boolean z11) {
        return K(z11, true, this.f37420i);
    }

    public final AnimatorSet B(boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f37425n == null) {
            animatorSet.playTogether(s(z11), t(z11));
        }
        animatorSet.playTogether(H(z11), G(z11), u(z11), w(z11), F(z11), z(z11), q(z11), A(z11), I(z11));
        animatorSet.addListener(new e(z11));
        return animatorSet;
    }

    public final int C(View view) {
        int marginEnd = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        return com.google.android.material.internal.f0.p(this.f37426o) ? this.f37426o.getLeft() - marginEnd : (this.f37426o.getRight() - this.f37412a.getWidth()) + marginEnd;
    }

    public final int D(View view) {
        int marginStart = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        int paddingStart = ViewCompat.getPaddingStart(this.f37426o);
        return com.google.android.material.internal.f0.p(this.f37426o) ? ((this.f37426o.getWidth() - this.f37426o.getRight()) + marginStart) - paddingStart : (this.f37426o.getLeft() - marginStart) + paddingStart;
    }

    public final int E() {
        return ((this.f37426o.getTop() + this.f37426o.getBottom()) / 2) - ((this.f37416e.getTop() + this.f37416e.getBottom()) / 2);
    }

    public final Animator F(boolean z11) {
        return K(z11, false, this.f37415d);
    }

    public final Animator G(boolean z11) {
        Rect rectM = this.f37424m.m();
        Rect rectL = this.f37424m.l();
        if (rectM == null) {
            rectM = com.google.android.material.internal.f0.c(this.f37412a);
        }
        if (rectL == null) {
            rectL = com.google.android.material.internal.f0.b(this.f37414c, this.f37426o);
        }
        final Rect rect = new Rect(rectL);
        final float cornerSize = this.f37426o.getCornerSize();
        final float fMax = Math.max(this.f37414c.getCornerRadius(), this.f37424m.k());
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new com.google.android.material.internal.u(rect), rectL, rectM);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.f0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37407a.P(cornerSize, fMax, rect, valueAnimator);
            }
        });
        valueAnimatorOfObject.setDuration(z11 ? 300L : 250L);
        valueAnimatorOfObject.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        return valueAnimatorOfObject;
    }

    public final Animator H(boolean z11) {
        TimeInterpolator timeInterpolator = z11 ? ii.b.f67201a : ii.b.f67202b;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z11 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.internal.v.a(z11, timeInterpolator));
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.f(this.f37413b));
        return valueAnimatorOfFloat;
    }

    public final Animator I(boolean z11) {
        return K(z11, true, this.f37419h);
    }

    public final AnimatorSet J(boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(L());
        k(animatorSet);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        animatorSet.setDuration(z11 ? 350L : 300L);
        return animatorSet;
    }

    public final Animator K(boolean z11, boolean z12, View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z12 ? D(view) : C(view), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.m(view));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(com.google.android.material.internal.q.n(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(z11 ? 300L : 250L);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        return animatorSet;
    }

    public final Animator L() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f37414c.getHeight(), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.n(this.f37414c));
        return valueAnimatorOfFloat;
    }

    public AnimatorSet M() {
        return this.f37426o != null ? b0() : c0();
    }

    public final /* synthetic */ void P(float f11, float f12, Rect rect, ValueAnimator valueAnimator) {
        this.f37414c.updateClipBoundsAndCornerRadius(rect, ii.b.a(f11, f12, valueAnimator.getAnimatedFraction()));
    }

    public final /* synthetic */ void Q() {
        AnimatorSet animatorSetB = B(true);
        animatorSetB.addListener(new a());
        animatorSetB.start();
    }

    public final /* synthetic */ void R() {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f37414c;
        clippableRoundedCornerLayout.setTranslationY(clippableRoundedCornerLayout.getHeight());
        AnimatorSet animatorSetJ = J(true);
        animatorSetJ.addListener(new c());
        animatorSetJ.start();
    }

    @Nullable
    public androidx.activity.b S() {
        return this.f37424m.c();
    }

    public final void T(float f11) {
        ActionMenuView actionMenuViewB;
        if (!this.f37412a.isMenuItemsAnimated() || (actionMenuViewB = ToolbarUtils.b(this.f37417f)) == null) {
            return;
        }
        actionMenuViewB.setAlpha(f11);
    }

    public final void U(float f11) {
        this.f37421j.setAlpha(f11);
        this.f37422k.setAlpha(f11);
        this.f37423l.setAlpha(f11);
        T(f11);
    }

    public final void V(Drawable drawable) {
        if (drawable instanceof androidx.appcompat.graphics.drawable.c) {
            ((androidx.appcompat.graphics.drawable.c) drawable).setProgress(1.0f);
        }
        if (drawable instanceof com.google.android.material.internal.h) {
            ((com.google.android.material.internal.h) drawable).a(1.0f);
        }
    }

    public final void W(Toolbar toolbar) {
        ActionMenuView actionMenuViewB = ToolbarUtils.b(toolbar);
        if (actionMenuViewB != null) {
            for (int i11 = 0; i11 < actionMenuViewB.getChildCount(); i11++) {
                View childAt = actionMenuViewB.getChildAt(i11);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    public void X(SearchBar searchBar) {
        this.f37426o = searchBar;
    }

    public final void Y() {
        Menu menu = this.f37418g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.f37426o.getMenuResId() == -1 || !this.f37412a.isMenuItemsAnimated()) {
            this.f37418g.setVisibility(8);
            return;
        }
        this.f37418g.inflateMenu(this.f37426o.getMenuResId());
        W(this.f37418g);
        this.f37418g.setVisibility(0);
    }

    public void Z() {
        if (this.f37426o != null) {
            d0();
        } else {
            e0();
        }
    }

    public void a0(@NonNull androidx.activity.b bVar) {
        this.f37424m.t(bVar, this.f37426o);
    }

    public final AnimatorSet b0() {
        if (this.f37412a.k()) {
            this.f37412a.clearFocusAndHideKeyboard();
        }
        AnimatorSet animatorSetB = B(false);
        animatorSetB.addListener(new b());
        animatorSetB.start();
        return animatorSetB;
    }

    public final AnimatorSet c0() {
        if (this.f37412a.k()) {
            this.f37412a.clearFocusAndHideKeyboard();
        }
        AnimatorSet animatorSetJ = J(false);
        animatorSetJ.addListener(new d());
        animatorSetJ.start();
        return animatorSetJ;
    }

    public final void d0() {
        if (this.f37412a.k()) {
            this.f37412a.x();
        }
        this.f37412a.setTransitionState(SearchView.TransitionState.SHOWING);
        Y();
        this.f37420i.setText(this.f37426o.getText());
        EditText editText = this.f37420i;
        editText.setSelection(editText.getText().length());
        this.f37414c.setVisibility(4);
        this.f37414c.post(new Runnable() { // from class: com.google.android.material.search.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f37397a.Q();
            }
        });
    }

    public final void e0() {
        if (this.f37412a.k()) {
            final SearchView searchView = this.f37412a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.d0
                @Override // java.lang.Runnable
                public final void run() {
                    searchView.x();
                }
            }, 150L);
        }
        this.f37414c.setVisibility(4);
        this.f37414c.post(new Runnable() { // from class: com.google.android.material.search.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f37406a.R();
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @RequiresApi(34)
    public void f0(@NonNull androidx.activity.b bVar) {
        if (bVar.a() <= 0.0f) {
            return;
        }
        ti.h hVar = this.f37424m;
        SearchBar searchBar = this.f37426o;
        hVar.v(bVar, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.f37425n;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime((long) (bVar.a() * this.f37425n.getDuration()));
            return;
        }
        if (this.f37412a.k()) {
            this.f37412a.clearFocusAndHideKeyboard();
        }
        if (this.f37412a.isAnimatedNavigationIcon()) {
            AnimatorSet animatorSetS = s(false);
            this.f37425n = animatorSetS;
            animatorSetS.start();
            this.f37425n.pause();
        }
    }

    public final void j(AnimatorSet animatorSet) {
        ActionMenuView actionMenuViewB = ToolbarUtils.b(this.f37417f);
        if (actionMenuViewB == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C(actionMenuViewB), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.m(actionMenuViewB));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(com.google.android.material.internal.q.n(actionMenuViewB));
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
    }

    public final void k(AnimatorSet animatorSet) {
        ImageButton imageButtonE = ToolbarUtils.e(this.f37417f);
        if (imageButtonE == null) {
            return;
        }
        Drawable drawableQ = d3.a.q(imageButtonE.getDrawable());
        if (!this.f37412a.isAnimatedNavigationIcon()) {
            V(drawableQ);
        } else {
            m(animatorSet, drawableQ);
            n(animatorSet, drawableQ);
        }
    }

    public final void l(AnimatorSet animatorSet) {
        ImageButton imageButtonE = ToolbarUtils.e(this.f37417f);
        if (imageButtonE == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(D(imageButtonE), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.m(imageButtonE));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(com.google.android.material.internal.q.n(imageButtonE));
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
    }

    public final void m(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof androidx.appcompat.graphics.drawable.c) {
            final androidx.appcompat.graphics.drawable.c cVar = (androidx.appcompat.graphics.drawable.c) drawable;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.b0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    g0.N(cVar, valueAnimator);
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
    }

    public final void n(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof com.google.android.material.internal.h) {
            final com.google.android.material.internal.h hVar = (com.google.android.material.internal.h) drawable;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.a0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    g0.O(hVar, valueAnimator);
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
    }

    @RequiresApi(34)
    public void o() {
        this.f37424m.g(this.f37426o);
        AnimatorSet animatorSet = this.f37425n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.f37425n = null;
    }

    @RequiresApi(34)
    public void p() {
        this.f37424m.j(M().getTotalDuration(), this.f37426o);
        if (this.f37425n != null) {
            t(false).start();
            this.f37425n.resume();
        }
        this.f37425n = null;
    }

    public final Animator q(boolean z11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z11 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        if (this.f37412a.isMenuItemsAnimated()) {
            valueAnimatorOfFloat.addUpdateListener(new com.google.android.material.internal.i(ToolbarUtils.b(this.f37418g), ToolbarUtils.b(this.f37417f)));
        }
        return valueAnimatorOfFloat;
    }

    public ti.h r() {
        return this.f37424m;
    }

    public final AnimatorSet s(boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        k(animatorSet);
        animatorSet.setDuration(z11 ? 300L : 250L);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        return animatorSet;
    }

    public final AnimatorSet t(boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        l(animatorSet);
        j(animatorSet);
        animatorSet.setDuration(z11 ? 300L : 250L);
        animatorSet.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        return animatorSet;
    }

    public final Animator u(boolean z11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z11 ? 50L : 42L);
        valueAnimatorOfFloat.setStartDelay(z11 ? 250L : 0L);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67201a));
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.f(this.f37421j));
        return valueAnimatorOfFloat;
    }

    public final Animator v(boolean z11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z11 ? 150L : 83L);
        valueAnimatorOfFloat.setStartDelay(z11 ? 75L : 0L);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67201a));
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.f(this.f37422k, this.f37423l));
        return valueAnimatorOfFloat;
    }

    public final Animator w(boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v(z11), y(z11), x(z11));
        return animatorSet;
    }

    public final Animator x(boolean z11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        valueAnimatorOfFloat.setDuration(z11 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.g(this.f37423l));
        return valueAnimatorOfFloat;
    }

    public final Animator y(boolean z11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat((this.f37423l.getHeight() * 0.050000012f) / 2.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(z11 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.internal.v.a(z11, ii.b.f67202b));
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.n(this.f37422k));
        return valueAnimatorOfFloat;
    }

    public final Animator z(boolean z11) {
        return K(z11, false, this.f37418g);
    }
}
