package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import java.util.Iterator;
import java.util.LinkedHashSet;
import ti.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f36223k = R$attr.motionDurationLong2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f36224l = R$attr.motionDurationMedium4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f36225m = R$attr.motionEasingEmphasizedInterpolator;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinkedHashSet<b> f36226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f36229d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TimeInterpolator f36230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public ViewPropertyAnimator f36234j;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f36234j = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(@NonNull View view, int i11);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f36226a = new LinkedHashSet<>();
        this.f36231g = 0;
        this.f36232h = 2;
        this.f36233i = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36226a = new LinkedHashSet<>();
        this.f36231g = 0;
        this.f36232h = 2;
        this.f36233i = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, @NonNull View view2, int i11, int i12) {
        return i11 == 2;
    }

    public void F(@NonNull b bVar) {
        this.f36226a.add(bVar);
    }

    public final void G(@NonNull V v11, int i11, long j11, TimeInterpolator timeInterpolator) {
        this.f36234j = v11.animate().translationY(i11).setInterpolator(timeInterpolator).setDuration(j11).setListener(new a());
    }

    public void H() {
        this.f36226a.clear();
    }

    public boolean I() {
        return this.f36232h == 1;
    }

    public boolean J() {
        return this.f36232h == 2;
    }

    public void K(@NonNull b bVar) {
        this.f36226a.remove(bVar);
    }

    public void L(@NonNull V v11, int i11) {
        this.f36233i = i11;
        if (this.f36232h == 1) {
            v11.setTranslationY(this.f36231g + i11);
        }
    }

    public void M(@NonNull V v11) {
        N(v11, true);
    }

    public void N(@NonNull V v11, boolean z11) {
        if (I()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f36234j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v11.clearAnimation();
        }
        Q(v11, 1);
        int i11 = this.f36231g + this.f36233i;
        if (z11) {
            G(v11, i11, this.f36228c, this.f36230f);
        } else {
            v11.setTranslationY(i11);
        }
    }

    public void O(@NonNull V v11) {
        P(v11, true);
    }

    public void P(@NonNull V v11, boolean z11) {
        if (J()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f36234j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v11.clearAnimation();
        }
        Q(v11, 2);
        if (z11) {
            G(v11, 0, this.f36227b, this.f36229d);
        } else {
            v11.setTranslationY(0);
        }
    }

    public final void Q(@NonNull V v11, int i11) {
        this.f36232h = i11;
        Iterator<b> it = this.f36226a.iterator();
        while (it.hasNext()) {
            it.next().a(v11, this.f36232h);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        this.f36231g = v11.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v11.getLayoutParams()).bottomMargin;
        this.f36227b = j.f(v11.getContext(), f36223k, 225);
        this.f36228c = j.f(v11.getContext(), f36224l, 175);
        Context context = v11.getContext();
        int i12 = f36225m;
        this.f36229d = j.g(context, i12, ii.b.f67204d);
        this.f36230f = j.g(v11.getContext(), i12, ii.b.f67203c);
        return super.l(coordinatorLayout, v11, i11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, @NonNull V v11, @NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        if (i12 > 0) {
            M(v11);
        } else if (i12 < 0) {
            O(v11);
        }
    }
}
