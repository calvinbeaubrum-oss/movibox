package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import com.google.android.material.R$anim;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends i<ObjectAnimator> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f37327k = {533, 567, 850, 750};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f37328l = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Property<m, Float> f37329m = new c(Float.class, "animationFraction");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjectAnimator f37330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f37331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Interpolator[] f37332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.material.progressindicator.b f37333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f37334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f37335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l6.b f37337j;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            m mVar = m.this;
            mVar.f37334g = (mVar.f37334g + 1) % m.this.f37333f.f37253c.length;
            m.this.f37335h = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            m.this.a();
            m mVar = m.this;
            l6.b bVar = mVar.f37337j;
            if (bVar != null) {
                bVar.b(mVar.f37309a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Property<m, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(m mVar) {
            return Float.valueOf(mVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(m mVar, Float f11) {
            mVar.r(f11.floatValue());
        }
    }

    public m(@NonNull Context context, @NonNull n nVar) {
        super(2);
        this.f37334g = 0;
        this.f37337j = null;
        this.f37333f = nVar;
        this.f37332e = new Interpolator[]{l6.f.a(context, R$anim.linear_indeterminate_line1_head_interpolator), l6.f.a(context, R$anim.linear_indeterminate_line1_tail_interpolator), l6.f.a(context, R$anim.linear_indeterminate_line2_head_interpolator), l6.f.a(context, R$anim.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f37336i;
    }

    private void o() {
        if (this.f37330c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f37329m, 0.0f, 1.0f);
            this.f37330c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f37330c.setInterpolator(null);
            this.f37330c.setRepeatCount(-1);
            this.f37330c.addListener(new a());
        }
        if (this.f37331d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f37329m, 1.0f);
            this.f37331d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.f37331d.setInterpolator(null);
            this.f37331d.addListener(new b());
        }
    }

    private void p() {
        if (this.f37335h) {
            Iterator<h.a> it = this.f37310b.iterator();
            while (it.hasNext()) {
                it.next().f37307c = this.f37333f.f37253c[this.f37334g];
            }
            this.f37335h = false;
        }
    }

    private void s(int i11) {
        for (int i12 = 0; i12 < this.f37310b.size(); i12++) {
            h.a aVar = this.f37310b.get(i12);
            int[] iArr = f37328l;
            int i13 = i12 * 2;
            int i14 = iArr[i13];
            int[] iArr2 = f37327k;
            aVar.f37305a = g3.a.a(this.f37332e[i13].getInterpolation(b(i11, i14, iArr2[i13])), 0.0f, 1.0f);
            int i15 = i13 + 1;
            aVar.f37306b = g3.a.a(this.f37332e[i15].getInterpolation(b(i11, iArr[i15], iArr2[i15])), 0.0f, 1.0f);
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f37330c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(@NonNull l6.b bVar) {
        this.f37337j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
        ObjectAnimator objectAnimator = this.f37331d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.f37309a.isVisible()) {
            this.f37331d.setFloatValues(this.f37336i, 1.0f);
            this.f37331d.setDuration((long) ((1.0f - this.f37336i) * 1800.0f));
            this.f37331d.start();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        o();
        q();
        this.f37330c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f37337j = null;
    }

    public void q() {
        this.f37334g = 0;
        Iterator<h.a> it = this.f37310b.iterator();
        while (it.hasNext()) {
            it.next().f37307c = this.f37333f.f37253c[0];
        }
    }

    public void r(float f11) {
        this.f37336i = f11;
        s((int) (f11 * 1800.0f));
        p();
        this.f37309a.invalidateSelf();
    }
}
