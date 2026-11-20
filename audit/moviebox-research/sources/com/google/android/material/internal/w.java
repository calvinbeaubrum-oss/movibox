package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f37105a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public b f37106b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ValueAnimator f37107c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Animator.AnimatorListener f37108d = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w wVar = w.this;
            if (wVar.f37107c == animator) {
                wVar.f37107c = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f37110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f37111b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f37110a = iArr;
            this.f37111b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f37108d);
        this.f37105a.add(bVar);
    }
}
