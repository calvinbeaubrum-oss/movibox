package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends i<ObjectAnimator> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f37263k = {0, 1350, 2700, 4050};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f37264l = {667, 2017, 3367, 4717};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f37265m = {1000, 2350, 3700, 5050};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Property<d, Float> f37266n = new c(Float.class, "animationFraction");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Property<d, Float> f37267o = new C0386d(Float.class, "completeEndFraction");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjectAnimator f37268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f37269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q3.b f37270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.material.progressindicator.b f37271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f37272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f37273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l6.b f37275j;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f37272g = (dVar.f37272g + 4) % d.this.f37271f.f37253c.length;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            l6.b bVar = dVar.f37275j;
            if (bVar != null) {
                bVar.b(dVar.f37309a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Property<d, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f11) {
            dVar.t(f11.floatValue());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0386d extends Property<d, Float> {
        public C0386d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f11) {
            dVar.u(f11.floatValue());
        }
    }

    public d(@NonNull e eVar) {
        super(1);
        this.f37272g = 0;
        this.f37275j = null;
        this.f37271f = eVar;
        this.f37270e = new q3.b();
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f37268c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(@NonNull l6.b bVar) {
        this.f37275j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
        ObjectAnimator objectAnimator = this.f37269d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f37309a.isVisible()) {
            this.f37269d.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        q();
        s();
        this.f37268c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f37275j = null;
    }

    public final float o() {
        return this.f37273h;
    }

    public final float p() {
        return this.f37274i;
    }

    public final void q() {
        if (this.f37268c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f37266n, 0.0f, 1.0f);
            this.f37268c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f37268c.setInterpolator(null);
            this.f37268c.setRepeatCount(-1);
            this.f37268c.addListener(new a());
        }
        if (this.f37269d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f37267o, 0.0f, 1.0f);
            this.f37269d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f37269d.setInterpolator(this.f37270e);
            this.f37269d.addListener(new b());
        }
    }

    public final void r(int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            float fB = b(i11, f37265m[i12], 333);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i13 = i12 + this.f37272g;
                int[] iArr = this.f37271f.f37253c;
                int length = i13 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i14 = iArr[length];
                int i15 = iArr[length2];
                float interpolation = this.f37270e.getInterpolation(fB);
                this.f37310b.get(0).f37307c = ii.d.b().evaluate(interpolation, Integer.valueOf(i14), Integer.valueOf(i15)).intValue();
                return;
            }
        }
    }

    public void s() {
        this.f37272g = 0;
        this.f37310b.get(0).f37307c = this.f37271f.f37253c[0];
        this.f37274i = 0.0f;
    }

    public void t(float f11) {
        this.f37273h = f11;
        int i11 = (int) (f11 * 5400.0f);
        v(i11);
        r(i11);
        this.f37309a.invalidateSelf();
    }

    public final void u(float f11) {
        this.f37274i = f11;
    }

    public final void v(int i11) {
        h.a aVar = this.f37310b.get(0);
        float f11 = this.f37273h;
        aVar.f37305a = (f11 * 1520.0f) - 20.0f;
        aVar.f37306b = f11 * 1520.0f;
        for (int i12 = 0; i12 < 4; i12++) {
            aVar.f37306b += this.f37270e.getInterpolation(b(i11, f37263k[i12], 667)) * 250.0f;
            aVar.f37305a += this.f37270e.getInterpolation(b(i11, f37264l[i12], 667)) * 250.0f;
        }
        float f12 = aVar.f37305a;
        float f13 = aVar.f37306b;
        aVar.f37305a = (f12 + ((f13 - f12) * this.f37274i)) / 360.0f;
        aVar.f37306b = f13 / 360.0f;
    }
}
