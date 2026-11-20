package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ToolbarUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Animator f37437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Animator f37438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f37439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f37440g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<SearchBar.b> f37434a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<AnimatorListenerAdapter> f37435b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<AnimatorListenerAdapter> f37436c = new LinkedHashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f37441h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f37442i = null;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.k(new g() { // from class: com.google.android.material.search.i
                @Override // com.google.android.material.search.j.g
                public final void a(SearchBar.b bVar) {
                    bVar.a();
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f37444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Animator f37445b;

        public b(View view, Animator animator) {
            this.f37444a = view;
            this.f37445b = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f37444a.setVisibility(8);
            this.f37445b.start();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.f37442i = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f37448a;

        public d(SearchBar searchBar) {
            this.f37448a = searchBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.f37439f = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f37448a.setVisibility(4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.f37442i = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f37451a;

        public f(SearchBar searchBar) {
            this.f37451a = searchBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f37451a.setVisibility(0);
            j.this.f37440g = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f37451a.stopOnLoadAnimation();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface g {
        void a(SearchBar.b bVar);
    }

    public static /* synthetic */ void A(yi.i iVar, View view, ValueAnimator valueAnimator) {
        iVar.e0(1.0f - valueAnimator.getAnimatedFraction());
        ViewCompat.setBackground(view, iVar);
        view.setAlpha(1.0f);
    }

    public final /* synthetic */ void C(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(t(searchBar, view), o(searchBar, view, appBarLayout));
        animatorSet.addListener(new c());
        Iterator<AnimatorListenerAdapter> it = this.f37435b.iterator();
        while (it.hasNext()) {
            animatorSet.addListener(it.next());
        }
        if (z11) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
        this.f37442i = animatorSet;
    }

    public boolean D(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f37436c.remove(animatorListenerAdapter);
    }

    public boolean E(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f37435b.remove(animatorListenerAdapter);
    }

    public boolean F(SearchBar.b bVar) {
        return this.f37434a.remove(bVar);
    }

    public void G(boolean z11) {
        this.f37441h = z11;
    }

    public void H(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout, boolean z11) {
        Animator animator;
        if (y() && (animator = this.f37442i) != null) {
            animator.cancel();
        }
        this.f37440g = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(l(searchBar, view, appBarLayout), s(searchBar));
        animatorSet.addListener(new e());
        Iterator<AnimatorListenerAdapter> it = this.f37436c.iterator();
        while (it.hasNext()) {
            animatorSet.addListener(it.next());
        }
        if (z11) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
        this.f37442i = animatorSet;
    }

    public void I(final SearchBar searchBar, final View view, @Nullable final AppBarLayout appBarLayout, final boolean z11) {
        Animator animator;
        if (x() && (animator = this.f37442i) != null) {
            animator.cancel();
        }
        this.f37439f = true;
        view.setVisibility(4);
        view.post(new Runnable() { // from class: com.google.android.material.search.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f37398a.C(searchBar, view, appBarLayout, z11);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void J(SearchBar searchBar) {
        k(new g() { // from class: com.google.android.material.search.f
            @Override // com.google.android.material.search.j.g
            public final void a(SearchBar.b bVar) {
                bVar.b();
            }
        });
        TextView textView = searchBar.getTextView();
        View centerView = searchBar.getCenterView();
        View viewF = ToolbarUtils.f(searchBar);
        final Animator animatorV = v(textView, viewF);
        animatorV.addListener(new a());
        this.f37437d = animatorV;
        textView.setAlpha(0.0f);
        if (viewF != null) {
            viewF.setAlpha(0.0f);
        }
        if (centerView instanceof ii.a) {
            ((ii.a) centerView).a(new ii.a.InterfaceC0710a() { // from class: com.google.android.material.search.g
            });
            return;
        }
        if (centerView == 0) {
            animatorV.start();
            return;
        }
        centerView.setAlpha(0.0f);
        centerView.setVisibility(0);
        Animator animatorM = m(centerView);
        this.f37438e = animatorM;
        animatorM.addListener(new b(centerView, animatorV));
        animatorM.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void K(SearchBar searchBar) {
        Animator animator = this.f37437d;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f37438e;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView instanceof ii.a) {
            ((ii.a) centerView).stopAnimation();
        }
        if (centerView != 0) {
            centerView.setAlpha(0.0f);
        }
    }

    public void h(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f37436c.add(animatorListenerAdapter);
    }

    public void i(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f37435b.add(animatorListenerAdapter);
    }

    public void j(SearchBar.b bVar) {
        this.f37434a.add(bVar);
    }

    public final void k(g gVar) {
        Iterator<SearchBar.b> it = this.f37434a.iterator();
        while (it.hasNext()) {
            gVar.a(it.next());
        }
    }

    public final Animator l(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return p(searchBar, view, appBarLayout).o(250L).d(new f(searchBar)).g();
    }

    public final Animator m(@Nullable View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.f(view));
        TimeInterpolator timeInterpolator = ii.b.f67201a;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f37441h ? 250L : 0L);
        valueAnimatorOfFloat.setStartDelay(this.f37441h ? 500L : 0L);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(com.google.android.material.internal.q.f(view));
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(250L);
        valueAnimatorOfFloat2.setStartDelay(750L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    public final List<View> n(View view) {
        boolean zP = com.google.android.material.internal.f0.p(view);
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if ((!zP && (childAt instanceof ActionMenuView)) || (zP && !(childAt instanceof ActionMenuView))) {
                    arrayList.add(childAt);
                }
            }
        }
        return arrayList;
    }

    public final Animator o(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout) {
        return p(searchBar, view, appBarLayout).o(300L).d(new d(searchBar)).i();
    }

    public final com.google.android.material.internal.g p(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout) {
        return new com.google.android.material.internal.g(searchBar, view).m(q(searchBar, view)).n(appBarLayout != null ? appBarLayout.getTop() : 0).c(n(view));
    }

    public final ValueAnimator.AnimatorUpdateListener q(SearchBar searchBar, final View view) {
        final yi.i iVarM = yi.i.m(view.getContext());
        iVarM.a0(searchBar.getCornerSize());
        iVarM.c0(ViewCompat.getElevation(searchBar));
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j.A(iVarM, view, valueAnimator);
            }
        };
    }

    public final List<View> r(SearchBar searchBar) {
        List<View> listI = com.google.android.material.internal.f0.i(searchBar);
        if (searchBar.getCenterView() != null) {
            listI.remove(searchBar.getCenterView());
        }
        return listI;
    }

    public final Animator s(SearchBar searchBar) {
        List<View> listR = r(searchBar);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.e(listR));
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.setInterpolator(ii.b.f67201a);
        return valueAnimatorOfFloat;
    }

    public final Animator t(SearchBar searchBar, final View view) {
        List<View> listR = r(searchBar);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.e(listR));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(0.0f);
            }
        });
        valueAnimatorOfFloat.setDuration(75L);
        valueAnimatorOfFloat.setInterpolator(ii.b.f67201a);
        return valueAnimatorOfFloat;
    }

    public final Animator u(@Nullable View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.f(view));
        valueAnimatorOfFloat.setInterpolator(ii.b.f67201a);
        valueAnimatorOfFloat.setDuration(250L);
        return valueAnimatorOfFloat;
    }

    public final Animator v(TextView textView, @Nullable View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(250L);
        animatorSet.play(w(textView));
        if (view != null) {
            animatorSet.play(u(view));
        }
        return animatorSet;
    }

    public final Animator w(TextView textView) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(com.google.android.material.internal.q.f(textView));
        valueAnimatorOfFloat.setInterpolator(ii.b.f67201a);
        valueAnimatorOfFloat.setDuration(250L);
        return valueAnimatorOfFloat;
    }

    public boolean x() {
        return this.f37440g;
    }

    public boolean y() {
        return this.f37439f;
    }

    public boolean z() {
        return this.f37441h;
    }
}
