package hm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f66535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f66536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f66537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f66538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f66539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f66540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f66541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f66542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f66543i;

    public n(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.f66535a = f11;
        this.f66536b = f14;
        this.f66537c = f17;
        this.f66538d = f12;
        this.f66539e = f15;
        this.f66540f = f18;
        this.f66541g = f13;
        this.f66542h = f16;
        this.f66543i = f19;
    }

    public static n b(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, float f22, float f23, float f24, float f25, float f26, float f27) {
        return d(f19, f21, f22, f23, f24, f25, f26, f27).e(c(f11, f12, f13, f14, f15, f16, f17, f18));
    }

    public static n c(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        return d(f11, f12, f13, f14, f15, f16, f17, f18).a();
    }

    public static n d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        float f19 = ((f11 - f13) + f15) - f17;
        float f21 = ((f12 - f14) + f16) - f18;
        if (f19 == 0.0f && f21 == 0.0f) {
            return new n(f13 - f11, f15 - f13, f11, f14 - f12, f16 - f14, f12, 0.0f, 0.0f, 1.0f);
        }
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = f14 - f16;
        float f25 = f18 - f16;
        float f26 = (f22 * f25) - (f23 * f24);
        float f27 = ((f25 * f19) - (f23 * f21)) / f26;
        float f28 = ((f22 * f21) - (f19 * f24)) / f26;
        return new n((f27 * f13) + (f13 - f11), (f28 * f17) + (f17 - f11), f11, (f14 - f12) + (f27 * f14), (f18 - f12) + (f28 * f18), f12, f27, f28, 1.0f);
    }

    public n a() {
        float f11 = this.f66539e;
        float f12 = this.f66543i;
        float f13 = this.f66540f;
        float f14 = this.f66542h;
        float f15 = (f11 * f12) - (f13 * f14);
        float f16 = this.f66541g;
        float f17 = this.f66538d;
        float f18 = (f13 * f16) - (f17 * f12);
        float f19 = (f17 * f14) - (f11 * f16);
        float f21 = this.f66537c;
        float f22 = this.f66536b;
        float f23 = (f21 * f14) - (f22 * f12);
        float f24 = this.f66535a;
        return new n(f15, f18, f19, f23, (f12 * f24) - (f21 * f16), (f16 * f22) - (f14 * f24), (f22 * f13) - (f21 * f11), (f21 * f17) - (f13 * f24), (f24 * f11) - (f22 * f17));
    }

    public n e(n nVar) {
        float f11 = this.f66535a;
        float f12 = nVar.f66535a;
        float f13 = this.f66538d;
        float f14 = nVar.f66536b;
        float f15 = this.f66541g;
        float f16 = nVar.f66537c;
        float f17 = (f11 * f12) + (f13 * f14) + (f15 * f16);
        float f18 = nVar.f66538d;
        float f19 = nVar.f66539e;
        float f21 = nVar.f66540f;
        float f22 = (f11 * f18) + (f13 * f19) + (f15 * f21);
        float f23 = nVar.f66541g;
        float f24 = nVar.f66542h;
        float f25 = nVar.f66543i;
        float f26 = (f11 * f23) + (f13 * f24) + (f15 * f25);
        float f27 = this.f66536b;
        float f28 = this.f66539e;
        float f29 = this.f66542h;
        float f31 = (f27 * f12) + (f28 * f14) + (f29 * f16);
        float f32 = (f27 * f18) + (f28 * f19) + (f29 * f21);
        float f33 = (f29 * f25) + (f27 * f23) + (f28 * f24);
        float f34 = this.f66537c;
        float f35 = this.f66540f;
        float f36 = (f12 * f34) + (f14 * f35);
        float f37 = this.f66543i;
        return new n(f17, f22, f26, f31, f32, f33, (f16 * f37) + f36, (f18 * f34) + (f19 * f35) + (f21 * f37), (f34 * f23) + (f35 * f24) + (f37 * f25));
    }

    public void f(float[] fArr) {
        float f11 = this.f66535a;
        float f12 = this.f66536b;
        float f13 = this.f66537c;
        float f14 = this.f66538d;
        float f15 = this.f66539e;
        float f16 = this.f66540f;
        float f17 = this.f66541g;
        float f18 = this.f66542h;
        float f19 = this.f66543i;
        int length = fArr.length - 1;
        for (int i11 = 0; i11 < length; i11 += 2) {
            float f21 = fArr[i11];
            int i12 = i11 + 1;
            float f22 = fArr[i12];
            float f23 = (f13 * f21) + (f16 * f22) + f19;
            fArr[i11] = (((f11 * f21) + (f14 * f22)) + f17) / f23;
            fArr[i12] = (((f21 * f12) + (f22 * f15)) + f18) / f23;
        }
    }
}
