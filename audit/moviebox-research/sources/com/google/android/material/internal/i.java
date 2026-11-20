package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final View f37060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final View f37061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f37062c = new float[2];

    public i(@Nullable View view, @Nullable View view2) {
        this.f37060a = view;
        this.f37061b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        j.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f37062c);
        View view = this.f37060a;
        if (view != null) {
            view.setAlpha(this.f37062c[0]);
        }
        View view2 = this.f37061b;
        if (view2 != null) {
            view2.setAlpha(this.f37062c[1]);
        }
    }
}
