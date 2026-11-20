package g7;

import android.view.Choreographer;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends c implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.h f65451m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f65443d = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f65444f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f65445g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f65446h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f65447i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f65448j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f65449k = -2.1474836E9f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f65450l = 2.1474836E9f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f65452n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f65453o = false;

    public void A() {
        G(-q());
    }

    public void B(com.airbnb.lottie.h hVar) {
        boolean z11 = this.f65451m == null;
        this.f65451m = hVar;
        if (z11) {
            E(Math.max(this.f65449k, hVar.p()), Math.min(this.f65450l, hVar.f()));
        } else {
            E((int) hVar.p(), (int) hVar.f());
        }
        float f11 = this.f65447i;
        this.f65447i = 0.0f;
        this.f65446h = 0.0f;
        C((int) f11);
        h();
    }

    public void C(float f11) {
        if (this.f65446h == f11) {
            return;
        }
        float fB = k.b(f11, p(), o());
        this.f65446h = fB;
        if (this.f65453o) {
            fB = (float) Math.floor(fB);
        }
        this.f65447i = fB;
        this.f65445g = 0L;
        h();
    }

    public void D(float f11) {
        E(this.f65449k, f11);
    }

    public void E(float f11, float f12) {
        if (f11 > f12) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f11), Float.valueOf(f12)));
        }
        com.airbnb.lottie.h hVar = this.f65451m;
        float fP = hVar == null ? -3.4028235E38f : hVar.p();
        com.airbnb.lottie.h hVar2 = this.f65451m;
        float f13 = hVar2 == null ? Float.MAX_VALUE : hVar2.f();
        float fB = k.b(f11, fP, f13);
        float fB2 = k.b(f12, fP, f13);
        if (fB == this.f65449k && fB2 == this.f65450l) {
            return;
        }
        this.f65449k = fB;
        this.f65450l = fB2;
        C((int) k.b(this.f65447i, fB, fB2));
    }

    public void F(int i11) {
        E(i11, (int) this.f65450l);
    }

    public void G(float f11) {
        this.f65443d = f11;
    }

    public void H(boolean z11) {
        this.f65453o = z11;
    }

    public final void I() {
        if (this.f65451m == null) {
            return;
        }
        float f11 = this.f65447i;
        if (f11 < this.f65449k || f11 > this.f65450l) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f65449k), Float.valueOf(this.f65450l), Float.valueOf(this.f65447i)));
        }
    }

    @Override // g7.c
    public void a() {
        super.a();
        b(r());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        x();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j11) {
        v();
        if (this.f65451m == null || !isRunning()) {
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("LottieValueAnimator#doFrame");
        }
        long j12 = this.f65445g;
        float fN = (j12 != 0 ? j11 - j12 : 0L) / n();
        float f11 = this.f65446h;
        if (r()) {
            fN = -fN;
        }
        float f12 = f11 + fN;
        boolean z11 = !k.d(f12, p(), o());
        float f13 = this.f65446h;
        float fB = k.b(f12, p(), o());
        this.f65446h = fB;
        if (this.f65453o) {
            fB = (float) Math.floor(fB);
        }
        this.f65447i = fB;
        this.f65445g = j11;
        if (!this.f65453o || this.f65446h != f13) {
            h();
        }
        if (z11) {
            if (getRepeatCount() == -1 || this.f65448j < getRepeatCount()) {
                d();
                this.f65448j++;
                if (getRepeatMode() == 2) {
                    this.f65444f = !this.f65444f;
                    A();
                } else {
                    float fO = r() ? o() : p();
                    this.f65446h = fO;
                    this.f65447i = fO;
                }
                this.f65445g = j11;
            } else {
                float fP = this.f65443d < 0.0f ? p() : o();
                this.f65446h = fP;
                this.f65447i = fP;
                x();
                b(r());
            }
        }
        I();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fP;
        float fO;
        float fP2;
        if (this.f65451m == null) {
            return 0.0f;
        }
        if (r()) {
            fP = o() - this.f65447i;
            fO = o();
            fP2 = p();
        } else {
            fP = this.f65447i - p();
            fO = o();
            fP2 = p();
        }
        return fP / (fO - fP2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(l());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.h hVar = this.f65451m;
        if (hVar == null) {
            return 0L;
        }
        return (long) hVar.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f65452n;
    }

    public void j() {
        this.f65451m = null;
        this.f65449k = -2.1474836E9f;
        this.f65450l = 2.1474836E9f;
    }

    public void k() {
        x();
        b(r());
    }

    public float l() {
        com.airbnb.lottie.h hVar = this.f65451m;
        if (hVar == null) {
            return 0.0f;
        }
        return (this.f65447i - hVar.p()) / (this.f65451m.f() - this.f65451m.p());
    }

    public float m() {
        return this.f65447i;
    }

    public final float n() {
        com.airbnb.lottie.h hVar = this.f65451m;
        if (hVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / hVar.i()) / Math.abs(this.f65443d);
    }

    public float o() {
        com.airbnb.lottie.h hVar = this.f65451m;
        if (hVar == null) {
            return 0.0f;
        }
        float f11 = this.f65450l;
        return f11 == 2.1474836E9f ? hVar.f() : f11;
    }

    public float p() {
        com.airbnb.lottie.h hVar = this.f65451m;
        if (hVar == null) {
            return 0.0f;
        }
        float f11 = this.f65449k;
        return f11 == -2.1474836E9f ? hVar.p() : f11;
    }

    public float q() {
        return this.f65443d;
    }

    public final boolean r() {
        return q() < 0.0f;
    }

    public void s() {
        x();
        c();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i11) {
        super.setRepeatMode(i11);
        if (i11 == 2 || !this.f65444f) {
            return;
        }
        this.f65444f = false;
        A();
    }

    public void t() {
        this.f65452n = true;
        g(r());
        C((int) (r() ? o() : p()));
        this.f65445g = 0L;
        this.f65448j = 0;
        v();
    }

    public void v() {
        if (isRunning()) {
            y(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void x() {
        y(true);
    }

    public void y(boolean z11) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z11) {
            this.f65452n = false;
        }
    }

    public void z() {
        this.f65452n = true;
        v();
        this.f65445g = 0L;
        if (r() && m() == p()) {
            C(o());
        } else if (!r() && m() == o()) {
            C(p());
        }
        f();
    }
}
