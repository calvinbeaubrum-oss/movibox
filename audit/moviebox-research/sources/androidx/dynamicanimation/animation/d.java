package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends b<d> {
    public e A;
    public float B;
    public boolean C;

    public <K> d(K k11, c<K> cVar) {
        super(k11, cVar);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    public <K> d(K k11, c<K> cVar, float f11) {
        super(k11, cVar);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
        this.A = new e(f11);
    }

    @Override // androidx.dynamicanimation.animation.b
    public void i() {
        p();
        this.A.g(d());
        super.i();
    }

    @Override // androidx.dynamicanimation.animation.b
    public boolean k(long j11) {
        if (this.C) {
            float f11 = this.B;
            if (f11 != Float.MAX_VALUE) {
                this.A.e(f11);
                this.B = Float.MAX_VALUE;
            }
            this.f8252b = this.A.a();
            this.f8251a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j12 = j11 / 2;
            b.o oVarH = this.A.h(this.f8252b, this.f8251a, j12);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            b.o oVarH2 = this.A.h(oVarH.f8263a, oVarH.f8264b, j12);
            this.f8252b = oVarH2.f8263a;
            this.f8251a = oVarH2.f8264b;
        } else {
            b.o oVarH3 = this.A.h(this.f8252b, this.f8251a, j11);
            this.f8252b = oVarH3.f8263a;
            this.f8251a = oVarH3.f8264b;
        }
        float fMax = Math.max(this.f8252b, this.f8258h);
        this.f8252b = fMax;
        float fMin = Math.min(fMax, this.f8257g);
        this.f8252b = fMin;
        if (!o(fMin, this.f8251a)) {
            return false;
        }
        this.f8252b = this.A.a();
        this.f8251a = 0.0f;
        return true;
    }

    public void l(float f11) {
        if (e()) {
            this.B = f11;
            return;
        }
        if (this.A == null) {
            this.A = new e(f11);
        }
        this.A.e(f11);
        i();
    }

    public boolean m() {
        return this.A.f8267b > 0.0d;
    }

    public e n() {
        return this.A;
    }

    public boolean o(float f11, float f12) {
        return this.A.c(f11, f12);
    }

    public final void p() {
        e eVar = this.A;
        if (eVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dA = eVar.a();
        if (dA > this.f8257g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.f8258h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public d q(e eVar) {
        this.A = eVar;
        return this;
    }

    public void r() {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f8256f) {
            this.C = true;
        }
    }
}
