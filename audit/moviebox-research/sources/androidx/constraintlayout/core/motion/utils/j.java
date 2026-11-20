package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f6477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f6478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f6479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6484j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f6475a = 0.5d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6476b = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6485k = 0;

    @Override // androidx.constraintlayout.core.motion.utils.l
    public boolean a() {
        double d11 = ((double) this.f6481g) - this.f6478d;
        double d12 = this.f6477c;
        double d13 = this.f6482h;
        return Math.sqrt((((d13 * d13) * ((double) this.f6483i)) + ((d12 * d11) * d11)) / d12) <= ((double) this.f6484j);
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float b() {
        return 0.0f;
    }

    public final void c(double d11) {
        double d12 = this.f6477c;
        double d13 = this.f6475a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d12 / ((double) this.f6483i)) * d11) * 4.0d)) + 1.0d);
        double d14 = d11 / ((double) iSqrt);
        int i11 = 0;
        while (i11 < iSqrt) {
            float f11 = this.f6481g;
            double d15 = this.f6478d;
            float f12 = this.f6482h;
            double d16 = d12;
            double d17 = ((-d12) * (((double) f11) - d15)) - (((double) f12) * d13);
            float f13 = this.f6483i;
            double d18 = d13;
            double d19 = ((double) f12) + (((d17 / ((double) f13)) * d14) / 2.0d);
            double d21 = ((((-((((double) f11) + ((d14 * d19) / 2.0d)) - d15)) * d16) - (d19 * d18)) / ((double) f13)) * d14;
            float f14 = (float) (((double) f12) + d21);
            this.f6482h = f14;
            float f15 = (float) (((double) f11) + ((((double) f12) + (d21 / 2.0d)) * d14));
            this.f6481g = f15;
            int i12 = this.f6485k;
            if (i12 > 0) {
                if (f15 < 0.0f && (i12 & 1) == 1) {
                    this.f6481g = -f15;
                    this.f6482h = -f14;
                }
                float f16 = this.f6481g;
                if (f16 > 1.0f && (i12 & 2) == 2) {
                    this.f6481g = 2.0f - f16;
                    this.f6482h = -this.f6482h;
                }
            }
            i11++;
            d12 = d16;
            d13 = d18;
        }
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        this.f6478d = f12;
        this.f6475a = f16;
        this.f6476b = false;
        this.f6481g = f11;
        this.f6479e = f13;
        this.f6477c = f15;
        this.f6483i = f14;
        this.f6484j = f17;
        this.f6485k = i11;
        this.f6480f = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.l
    public float getInterpolation(float f11) {
        c(f11 - this.f6480f);
        this.f6480f = f11;
        return this.f6481g;
    }
}
