package androidx.dynamicanimation.animation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f8266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f8267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f8269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f8270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f8271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f8272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f8273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f8274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b.o f8275j;

    public e() {
        this.f8266a = Math.sqrt(1500.0d);
        this.f8267b = 0.5d;
        this.f8268c = false;
        this.f8274i = Double.MAX_VALUE;
        this.f8275j = new b.o();
    }

    public e(float f11) {
        this.f8266a = Math.sqrt(1500.0d);
        this.f8267b = 0.5d;
        this.f8268c = false;
        this.f8274i = Double.MAX_VALUE;
        this.f8275j = new b.o();
        this.f8274i = f11;
    }

    public float a() {
        return (float) this.f8274i;
    }

    public final void b() {
        if (this.f8268c) {
            return;
        }
        if (this.f8274i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d11 = this.f8267b;
        if (d11 > 1.0d) {
            double d12 = this.f8266a;
            this.f8271f = ((-d11) * d12) + (d12 * Math.sqrt((d11 * d11) - 1.0d));
            double d13 = this.f8267b;
            double d14 = this.f8266a;
            this.f8272g = ((-d13) * d14) - (d14 * Math.sqrt((d13 * d13) - 1.0d));
        } else if (d11 >= 0.0d && d11 < 1.0d) {
            this.f8273h = this.f8266a * Math.sqrt(1.0d - (d11 * d11));
        }
        this.f8268c = true;
    }

    public boolean c(float f11, float f12) {
        return ((double) Math.abs(f12)) < this.f8270e && ((double) Math.abs(f11 - a())) < this.f8269d;
    }

    public e d(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f8267b = f11;
        this.f8268c = false;
        return this;
    }

    public e e(float f11) {
        this.f8274i = f11;
        return this;
    }

    public e f(float f11) {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f8266a = Math.sqrt(f11);
        this.f8268c = false;
        return this;
    }

    public void g(double d11) {
        double dAbs = Math.abs(d11);
        this.f8269d = dAbs;
        this.f8270e = dAbs * 62.5d;
    }

    public b.o h(double d11, double d12, long j11) {
        double dCos;
        double dPow;
        b();
        double d13 = j11 / 1000.0d;
        double d14 = d11 - this.f8274i;
        double d15 = this.f8267b;
        if (d15 > 1.0d) {
            double d16 = this.f8272g;
            double d17 = this.f8271f;
            double d18 = d14 - (((d16 * d14) - d12) / (d16 - d17));
            double d19 = ((d14 * d16) - d12) / (d16 - d17);
            dPow = (Math.pow(2.718281828459045d, d16 * d13) * d18) + (Math.pow(2.718281828459045d, this.f8271f * d13) * d19);
            double d21 = this.f8272g;
            double dPow2 = d18 * d21 * Math.pow(2.718281828459045d, d21 * d13);
            double d22 = this.f8271f;
            dCos = dPow2 + (d19 * d22 * Math.pow(2.718281828459045d, d22 * d13));
        } else if (d15 == 1.0d) {
            double d23 = this.f8266a;
            double d24 = d12 + (d23 * d14);
            double d25 = d14 + (d24 * d13);
            dPow = Math.pow(2.718281828459045d, (-d23) * d13) * d25;
            double dPow3 = d25 * Math.pow(2.718281828459045d, (-this.f8266a) * d13);
            double d26 = this.f8266a;
            dCos = (d24 * Math.pow(2.718281828459045d, (-d26) * d13)) + (dPow3 * (-d26));
        } else {
            double d27 = 1.0d / this.f8273h;
            double d28 = this.f8266a;
            double d29 = d27 * ((d15 * d28 * d14) + d12);
            double dPow4 = Math.pow(2.718281828459045d, (-d15) * d28 * d13) * ((Math.cos(this.f8273h * d13) * d14) + (Math.sin(this.f8273h * d13) * d29));
            double d31 = this.f8266a;
            double d32 = this.f8267b;
            double d33 = (-d31) * dPow4 * d32;
            double dPow5 = Math.pow(2.718281828459045d, (-d32) * d31 * d13);
            double d34 = this.f8273h;
            double dSin = (-d34) * d14 * Math.sin(d34 * d13);
            double d35 = this.f8273h;
            dCos = d33 + (dPow5 * (dSin + (d29 * d35 * Math.cos(d35 * d13))));
            dPow = dPow4;
        }
        b.o oVar = this.f8275j;
        oVar.f8263a = (float) (dPow + this.f8274i);
        oVar.f8264b = (float) dCos;
        return oVar;
    }
}
