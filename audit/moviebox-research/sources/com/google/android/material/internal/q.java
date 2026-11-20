package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View[] f37064b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(@NonNull ValueAnimator valueAnimator, @NonNull View view);
    }

    @SuppressLint({"LambdaLast"})
    public q(@NonNull a aVar, @NonNull Collection<View> collection) {
        this.f37063a = aVar;
        this.f37064b = (View[]) collection.toArray(new View[0]);
    }

    @SuppressLint({"LambdaLast"})
    public q(@NonNull a aVar, @NonNull View... viewArr) {
        this.f37063a = aVar;
        this.f37064b = viewArr;
    }

    @NonNull
    public static q e(@NonNull Collection<View> collection) {
        return new q(new p(), collection);
    }

    @NonNull
    public static q f(@NonNull View... viewArr) {
        return new q(new p(), viewArr);
    }

    @NonNull
    public static q g(@NonNull View... viewArr) {
        return new q(new a() { // from class: com.google.android.material.internal.m
            @Override // com.google.android.material.internal.q.a
            public final void a(ValueAnimator valueAnimator, View view) {
                q.i(valueAnimator, view);
            }
        }, viewArr);
    }

    public static void h(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static void i(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        Float f11 = (Float) valueAnimator.getAnimatedValue();
        view.setScaleX(f11.floatValue());
        view.setScaleY(f11.floatValue());
    }

    public static void j(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static void k(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @NonNull
    public static q l(@NonNull Collection<View> collection) {
        return new q(new n(), collection);
    }

    @NonNull
    public static q m(@NonNull View... viewArr) {
        return new q(new n(), viewArr);
    }

    @NonNull
    public static q n(@NonNull View... viewArr) {
        return new q(new a() { // from class: com.google.android.material.internal.o
            @Override // com.google.android.material.internal.q.a
            public final void a(ValueAnimator valueAnimator, View view) {
                q.k(valueAnimator, view);
            }
        }, viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        for (View view : this.f37064b) {
            this.f37063a.a(valueAnimator, view);
        }
    }
}
