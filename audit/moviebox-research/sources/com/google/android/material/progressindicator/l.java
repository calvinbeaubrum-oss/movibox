package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends i<ObjectAnimator> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Property<l, Float> f37319i = new b(Float.class, "animationFraction");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjectAnimator f37320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q3.b f37321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.google.android.material.progressindicator.b f37322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f37324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f37325h;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f37323f = (lVar.f37323f + 1) % l.this.f37322e.f37253c.length;
            l.this.f37324g = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Property<l, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f11) {
            lVar.r(f11.floatValue());
        }
    }

    public l(@NonNull n nVar) {
        super(3);
        this.f37323f = 1;
        this.f37322e = nVar;
        this.f37321d = new q3.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f37325h;
    }

    private void o() {
        if (this.f37320c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f37319i, 0.0f, 1.0f);
            this.f37320c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f37320c.setInterpolator(null);
            this.f37320c.setRepeatCount(-1);
            this.f37320c.addListener(new a());
        }
    }

    private void s(int i11) {
        this.f37310b.get(0).f37305a = 0.0f;
        float fB = b(i11, 0, 667);
        h.a aVar = this.f37310b.get(0);
        h.a aVar2 = this.f37310b.get(1);
        float interpolation = this.f37321d.getInterpolation(fB);
        aVar2.f37305a = interpolation;
        aVar.f37306b = interpolation;
        h.a aVar3 = this.f37310b.get(1);
        h.a aVar4 = this.f37310b.get(2);
        float interpolation2 = this.f37321d.getInterpolation(fB + 0.49925038f);
        aVar4.f37305a = interpolation2;
        aVar3.f37306b = interpolation2;
        this.f37310b.get(2).f37306b = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f37320c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(@Nullable l6.b bVar) {
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        o();
        q();
        this.f37320c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
    }

    public final void p() {
        if (!this.f37324g || this.f37310b.get(1).f37306b >= 1.0f) {
            return;
        }
        this.f37310b.get(2).f37307c = this.f37310b.get(1).f37307c;
        this.f37310b.get(1).f37307c = this.f37310b.get(0).f37307c;
        this.f37310b.get(0).f37307c = this.f37322e.f37253c[this.f37323f];
        this.f37324g = false;
    }

    public void q() {
        this.f37324g = true;
        this.f37323f = 1;
        for (h.a aVar : this.f37310b) {
            com.google.android.material.progressindicator.b bVar = this.f37322e;
            aVar.f37307c = bVar.f37253c[0];
            aVar.f37308d = bVar.f37257g / 2;
        }
    }

    public void r(float f11) {
        this.f37325h = f11;
        s((int) (f11 * 333.0f));
        p();
        this.f37309a.invalidateSelf();
    }
}
