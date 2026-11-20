package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6497k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6500n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6498l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6501o = false;

    @Override // androidx.constraintlayout.core.motion.utils.l
    public boolean a() {
        return b() < 1.0E-5f && Math.abs(this.f6495i - this.f6500n) < 1.0E-5f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float b() {
        return this.f6498l ? -e(this.f6500n) : e(this.f6500n);
    }

    public final float c(float f11) {
        this.f6501o = false;
        float f12 = this.f6490d;
        if (f11 <= f12) {
            float f13 = this.f6487a;
            return (f13 * f11) + ((((this.f6488b - f13) * f11) * f11) / (f12 * 2.0f));
        }
        int i11 = this.f6496j;
        if (i11 == 1) {
            return this.f6493g;
        }
        float f14 = f11 - f12;
        float f15 = this.f6491e;
        if (f14 < f15) {
            float f16 = this.f6493g;
            float f17 = this.f6488b;
            return f16 + (f17 * f14) + ((((this.f6489c - f17) * f14) * f14) / (f15 * 2.0f));
        }
        if (i11 == 2) {
            return this.f6494h;
        }
        float f18 = f14 - f15;
        float f19 = this.f6492f;
        if (f18 > f19) {
            this.f6501o = true;
            return this.f6495i;
        }
        float f21 = this.f6494h;
        float f22 = this.f6489c;
        return (f21 + (f22 * f18)) - (((f22 * f18) * f18) / (f19 * 2.0f));
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f6501o = false;
        this.f6499m = f11;
        boolean z11 = f11 > f12;
        this.f6498l = z11;
        if (z11) {
            f(-f13, f11 - f12, f15, f16, f14);
        } else {
            f(f13, f12 - f11, f15, f16, f14);
        }
    }

    public float e(float f11) {
        float f12 = this.f6490d;
        if (f11 <= f12) {
            float f13 = this.f6487a;
            return f13 + (((this.f6488b - f13) * f11) / f12);
        }
        int i11 = this.f6496j;
        if (i11 == 1) {
            return 0.0f;
        }
        float f14 = f11 - f12;
        float f15 = this.f6491e;
        if (f14 < f15) {
            float f16 = this.f6488b;
            return f16 + (((this.f6489c - f16) * f14) / f15);
        }
        if (i11 == 2) {
            return this.f6494h;
        }
        float f17 = f14 - f15;
        float f18 = this.f6492f;
        if (f17 >= f18) {
            return this.f6495i;
        }
        float f19 = this.f6489c;
        return f19 - ((f17 * f19) / f18);
    }

    public final void f(float f11, float f12, float f13, float f14, float f15) {
        this.f6501o = false;
        if (f11 == 0.0f) {
            f11 = 1.0E-4f;
        }
        this.f6487a = f11;
        float f16 = f11 / f13;
        float f17 = (f16 * f11) / 2.0f;
        if (f11 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f12 - ((((-f11) / f13) * f11) / 2.0f)) * f13);
            if (fSqrt < f14) {
                this.f6497k = "backward accelerate, decelerate";
                this.f6496j = 2;
                this.f6487a = f11;
                this.f6488b = fSqrt;
                this.f6489c = 0.0f;
                float f18 = (fSqrt - f11) / f13;
                this.f6490d = f18;
                this.f6491e = fSqrt / f13;
                this.f6493g = ((f11 + fSqrt) * f18) / 2.0f;
                this.f6494h = f12;
                this.f6495i = f12;
                return;
            }
            this.f6497k = "backward accelerate cruse decelerate";
            this.f6496j = 3;
            this.f6487a = f11;
            this.f6488b = f14;
            this.f6489c = f14;
            float f19 = (f14 - f11) / f13;
            this.f6490d = f19;
            float f21 = f14 / f13;
            this.f6492f = f21;
            float f22 = ((f11 + f14) * f19) / 2.0f;
            float f23 = (f21 * f14) / 2.0f;
            this.f6491e = ((f12 - f22) - f23) / f14;
            this.f6493g = f22;
            this.f6494h = f12 - f23;
            this.f6495i = f12;
            return;
        }
        if (f17 >= f12) {
            this.f6497k = "hard stop";
            this.f6496j = 1;
            this.f6487a = f11;
            this.f6488b = 0.0f;
            this.f6493g = f12;
            this.f6490d = (2.0f * f12) / f11;
            return;
        }
        float f24 = f12 - f17;
        float f25 = f24 / f11;
        if (f25 + f16 < f15) {
            this.f6497k = "cruse decelerate";
            this.f6496j = 2;
            this.f6487a = f11;
            this.f6488b = f11;
            this.f6489c = 0.0f;
            this.f6493g = f24;
            this.f6494h = f12;
            this.f6490d = f25;
            this.f6491e = f16;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f13 * f12) + ((f11 * f11) / 2.0f));
        float f26 = (fSqrt2 - f11) / f13;
        this.f6490d = f26;
        float f27 = fSqrt2 / f13;
        this.f6491e = f27;
        if (fSqrt2 < f14) {
            this.f6497k = "accelerate decelerate";
            this.f6496j = 2;
            this.f6487a = f11;
            this.f6488b = fSqrt2;
            this.f6489c = 0.0f;
            this.f6490d = f26;
            this.f6491e = f27;
            this.f6493g = ((f11 + fSqrt2) * f26) / 2.0f;
            this.f6494h = f12;
            return;
        }
        this.f6497k = "accelerate cruse decelerate";
        this.f6496j = 3;
        this.f6487a = f11;
        this.f6488b = f14;
        this.f6489c = f14;
        float f28 = (f14 - f11) / f13;
        this.f6490d = f28;
        float f29 = f14 / f13;
        this.f6492f = f29;
        float f31 = ((f11 + f14) * f28) / 2.0f;
        float f32 = (f29 * f14) / 2.0f;
        this.f6491e = ((f12 - f31) - f32) / f14;
        this.f6493g = f31;
        this.f6494h = f12 - f32;
        this.f6495i = f12;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float getInterpolation(float f11) {
        float fC = c(f11);
        this.f6500n = f11;
        return this.f6498l ? this.f6499m - fC : this.f6499m + fC;
    }
}
