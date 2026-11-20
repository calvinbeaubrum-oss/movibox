package b3;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f13992k = k(b.f13958c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f13994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f13996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f13997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f13998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f13999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f14000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f14001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f14002j;

    public l(float f11, float f12, float f13, float f14, float f15, float f16, float[] fArr, float f17, float f18, float f19) {
        this.f13998f = f11;
        this.f13993a = f12;
        this.f13994b = f13;
        this.f13995c = f14;
        this.f13996d = f15;
        this.f13997e = f16;
        this.f13999g = fArr;
        this.f14000h = f17;
        this.f14001i = f18;
        this.f14002j = f19;
    }

    @NonNull
    public static l k(@NonNull float[] fArr, float f11, float f12, float f13, boolean z11) {
        float[][] fArr2 = b.f13956a;
        float f14 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f15 = fArr3[0] * f14;
        float f16 = fArr[1];
        float f17 = f15 + (fArr3[1] * f16);
        float f18 = fArr[2];
        float f19 = f17 + (fArr3[2] * f18);
        float[] fArr4 = fArr2[1];
        float f21 = (fArr4[0] * f14) + (fArr4[1] * f16) + (fArr4[2] * f18);
        float[] fArr5 = fArr2[2];
        float f22 = (f14 * fArr5[0]) + (f16 * fArr5[1]) + (f18 * fArr5[2]);
        float f23 = (f13 / 10.0f) + 0.8f;
        float fD = ((double) f23) >= 0.9d ? b.d(0.59f, 0.69f, (f23 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f23 - 0.8f) * 10.0f);
        float fExp = z11 ? 1.0f : (1.0f - (((float) Math.exp(((-f11) - 42.0f) / 92.0f)) * 0.2777778f)) * f23;
        double d11 = fExp;
        if (d11 > 1.0d) {
            fExp = 1.0f;
        } else if (d11 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f19) * fExp) + 1.0f) - fExp, (((100.0f / f21) * fExp) + 1.0f) - fExp, (((100.0f / f22) * fExp) + 1.0f) - fExp};
        float f24 = 1.0f / ((5.0f * f11) + 1.0f);
        float f25 = f24 * f24 * f24 * f24;
        float f26 = 1.0f - f25;
        float fCbrt = (f25 * f11) + (0.1f * f26 * f26 * ((float) Math.cbrt(((double) f11) * 5.0d)));
        float fH = b.h(f12) / fArr[1];
        double d12 = fH;
        float fSqrt = ((float) Math.sqrt(d12)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d12, 0.2d));
        float fPow2 = (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f22)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f19)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f21)) / 100.0d, 0.42d), fPow2};
        float f27 = fArr7[0];
        float f28 = fArr7[1];
        return new l(fH, ((((f27 * 400.0f) / (f27 + 27.13f)) * 2.0f) + ((f28 * 400.0f) / (f28 + 27.13f)) + (((400.0f * fPow2) / (fPow2 + 27.13f)) * 0.05f)) * fPow, fPow, fPow, fD, f23, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float a() {
        return this.f13993a;
    }

    public float b() {
        return this.f13996d;
    }

    public float c() {
        return this.f14000h;
    }

    public float d() {
        return this.f14001i;
    }

    public float e() {
        return this.f13998f;
    }

    public float f() {
        return this.f13994b;
    }

    public float g() {
        return this.f13997e;
    }

    public float h() {
        return this.f13995c;
    }

    @NonNull
    public float[] i() {
        return this.f13999g;
    }

    public float j() {
        return this.f14002j;
    }
}
