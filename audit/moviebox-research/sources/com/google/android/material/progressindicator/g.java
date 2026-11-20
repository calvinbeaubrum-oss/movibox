package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g extends Drawable implements Animatable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Property<g, Float> f37287p = new c(Float.class, "growFraction");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f37288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.material.progressindicator.b f37289b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f37291d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f37292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f37293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f37294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<l6.b> f37296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l6.b f37297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f37299m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f37301o;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f37300n = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.android.material.progressindicator.a f37290c = new com.google.android.material.progressindicator.a();

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g.this.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            g.super.setVisible(false, false);
            g.this.e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Property<g, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(g gVar) {
            return Float.valueOf(gVar.h());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(g gVar, Float f11) {
            gVar.n(f11.floatValue());
        }
    }

    public g(@NonNull Context context, @NonNull com.google.android.material.progressindicator.b bVar) {
        this.f37288a = context;
        this.f37289b = bVar;
        setAlpha(255);
    }

    public final void d(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z11 = this.f37298l;
        this.f37298l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f37298l = z11;
    }

    public final void e() {
        l6.b bVar = this.f37297k;
        if (bVar != null) {
            bVar.b(this);
        }
        List<l6.b> list = this.f37296j;
        if (list == null || this.f37298l) {
            return;
        }
        Iterator<l6.b> it = list.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public final void f() {
        l6.b bVar = this.f37297k;
        if (bVar != null) {
            bVar.c(this);
        }
        List<l6.b> list = this.f37296j;
        if (list == null || this.f37298l) {
            return;
        }
        Iterator<l6.b> it = list.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    public final void g(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z11 = this.f37298l;
        this.f37298l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f37298l = z11;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f37301o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        if (this.f37289b.b() || this.f37289b.a()) {
            return (this.f37294h || this.f37293g) ? this.f37295i : this.f37299m;
        }
        return 1.0f;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        return k() || j();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f37292f;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f37294h;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f37291d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f37293g;
    }

    public final void l() {
        if (this.f37291d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f37287p, 0.0f, 1.0f);
            this.f37291d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f37291d.setInterpolator(ii.b.f67202b);
            p(this.f37291d);
        }
        if (this.f37292f == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f37287p, 1.0f, 0.0f);
            this.f37292f = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f37292f.setInterpolator(ii.b.f67202b);
            o(this.f37292f);
        }
    }

    public void m(@NonNull l6.b bVar) {
        if (this.f37296j == null) {
            this.f37296j = new ArrayList();
        }
        if (this.f37296j.contains(bVar)) {
            return;
        }
        this.f37296j.add(bVar);
    }

    public void n(float f11) {
        if (this.f37299m != f11) {
            this.f37299m = f11;
            invalidateSelf();
        }
    }

    public final void o(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f37292f;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f37292f = valueAnimator;
        valueAnimator.addListener(new b());
    }

    public final void p(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f37291d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f37291d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public boolean q(boolean z11, boolean z12, boolean z13) {
        return r(z11, z12, z13 && this.f37290c.a(this.f37288a.getContentResolver()) > 0.0f);
    }

    public boolean r(boolean z11, boolean z12, boolean z13) {
        l();
        if (!isVisible() && !z11) {
            return false;
        }
        ValueAnimator valueAnimator = z11 ? this.f37291d : this.f37292f;
        ValueAnimator valueAnimator2 = z11 ? this.f37292f : this.f37291d;
        if (!z13) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z11, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z14 = !z11 || super.setVisible(z11, false);
        if (!(z11 ? this.f37289b.b() : this.f37289b.a())) {
            g(valueAnimator);
            return z14;
        }
        if (z12 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z14;
    }

    public boolean s(@NonNull l6.b bVar) {
        List<l6.b> list = this.f37296j;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f37296j.remove(bVar);
        if (!this.f37296j.isEmpty()) {
            return true;
        }
        this.f37296j = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f37301o = i11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f37300n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        return q(z11, z12, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}
