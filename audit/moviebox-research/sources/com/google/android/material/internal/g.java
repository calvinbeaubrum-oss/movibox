package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f37046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f37047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AnimatorListenerAdapter> f37048c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<View> f37049d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ValueAnimator.AnimatorUpdateListener f37050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f37051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f37052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f37053h;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            g.this.f37047b.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f37047b.setVisibility(8);
        }
    }

    public g(@NonNull View view, @NonNull View view2) {
        this.f37046a = view;
        this.f37047b = view2;
    }

    @NonNull
    public g c(@NonNull Collection<View> collection) {
        this.f37049d.addAll(collection);
        return this;
    }

    @NonNull
    public g d(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f37048c.add(animatorListenerAdapter);
        return this;
    }

    public final void e(Animator animator, List<AnimatorListenerAdapter> list) {
        Iterator<AnimatorListenerAdapter> it = list.iterator();
        while (it.hasNext()) {
            animator.addListener(it.next());
        }
    }

    public final AnimatorSet f(boolean z11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(j(z11), k(z11), h(z11));
        return animatorSet;
    }

    @NonNull
    public Animator g() {
        AnimatorSet animatorSetF = f(false);
        animatorSetF.addListener(new b());
        e(animatorSetF, this.f37048c);
        return animatorSetF;
    }

    public final Animator h(boolean z11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat((this.f37047b.getLeft() - this.f37046a.getLeft()) + (this.f37046a.getRight() - this.f37047b.getRight()), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(q.l(this.f37049d));
        valueAnimatorOfFloat.setDuration(this.f37051f);
        valueAnimatorOfFloat.setInterpolator(v.a(z11, ii.b.f67202b));
        return valueAnimatorOfFloat;
    }

    @NonNull
    public Animator i() {
        AnimatorSet animatorSetF = f(true);
        animatorSetF.addListener(new a());
        e(animatorSetF, this.f37048c);
        return animatorSetF;
    }

    public final Animator j(boolean z11) {
        Rect rectD = f0.d(this.f37046a, this.f37052g);
        Rect rectD2 = f0.d(this.f37047b, this.f37053h);
        final Rect rect = new Rect(rectD);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new u(rect), rectD, rectD2);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37034a.l(rect, valueAnimator);
            }
        });
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f37050e;
        if (animatorUpdateListener != null) {
            valueAnimatorOfObject.addUpdateListener(animatorUpdateListener);
        }
        valueAnimatorOfObject.setDuration(this.f37051f);
        valueAnimatorOfObject.setInterpolator(v.a(z11, ii.b.f67202b));
        return valueAnimatorOfObject;
    }

    public final Animator k(boolean z11) {
        List<View> listI = f0.i(this.f37047b);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(q.e(listI));
        valueAnimatorOfFloat.setDuration(this.f37051f);
        valueAnimatorOfFloat.setInterpolator(v.a(z11, ii.b.f67201a));
        return valueAnimatorOfFloat;
    }

    public final /* synthetic */ void l(Rect rect, ValueAnimator valueAnimator) {
        f0.u(this.f37047b, rect);
    }

    @NonNull
    public g m(@Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f37050e = animatorUpdateListener;
        return this;
    }

    @NonNull
    public g n(int i11) {
        this.f37052g = i11;
        return this;
    }

    @NonNull
    public g o(long j11) {
        this.f37051f = j11;
        return this;
    }
}
