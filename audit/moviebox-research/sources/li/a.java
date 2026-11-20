package li;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f70283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f70285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f70286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f70287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f70289h;

    public a(int i11, float f11, float f12, float f13, int i12, float f14, int i13, float f15, int i14, float f16) {
        this.f70282a = i11;
        this.f70283b = g3.a.a(f11, f12, f13);
        this.f70284c = i12;
        this.f70286e = f14;
        this.f70285d = i13;
        this.f70287f = f15;
        this.f70288g = i14;
        d(f16, f12, f13, f15);
        this.f70289h = b(f15);
    }

    public static a c(float f11, float f12, float f13, float f14, int[] iArr, float f15, int[] iArr2, float f16, int[] iArr3) {
        a aVar = null;
        int i11 = 1;
        for (int i12 : iArr3) {
            int length = iArr2.length;
            int i13 = 0;
            while (i13 < length) {
                int i14 = iArr2[i13];
                int length2 = iArr.length;
                int i15 = 0;
                while (i15 < length2) {
                    int i16 = i15;
                    int i17 = length2;
                    int i18 = i13;
                    int i19 = length;
                    a aVar2 = new a(i11, f12, f13, f14, iArr[i15], f15, i14, f16, i12, f11);
                    if (aVar == null || aVar2.f70289h < aVar.f70289h) {
                        if (aVar2.f70289h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i11++;
                    i15 = i16 + 1;
                    length2 = i17;
                    i13 = i18;
                    length = i19;
                }
                i13++;
            }
        }
        return aVar;
    }

    public final float a(float f11, int i11, float f12, int i12, int i13) {
        if (i11 <= 0) {
            f12 = 0.0f;
        }
        float f13 = i12 / 2.0f;
        return (f11 - ((i11 + f13) * f12)) / (i13 + f13);
    }

    public final float b(float f11) {
        if (g()) {
            return Math.abs(f11 - this.f70287f) * this.f70282a;
        }
        return Float.MAX_VALUE;
    }

    public final void d(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f();
        int i11 = this.f70284c;
        if (i11 > 0 && f15 > 0.0f) {
            float f16 = this.f70283b;
            this.f70283b = f16 + Math.min(f15 / i11, f13 - f16);
        } else if (i11 > 0 && f15 < 0.0f) {
            float f17 = this.f70283b;
            this.f70283b = f17 + Math.max(f15 / i11, f12 - f17);
        }
        int i12 = this.f70284c;
        float f18 = i12 > 0 ? this.f70283b : 0.0f;
        this.f70283b = f18;
        float fA = a(f11, i12, f18, this.f70285d, this.f70288g);
        this.f70287f = fA;
        float f19 = (this.f70283b + fA) / 2.0f;
        this.f70286e = f19;
        int i13 = this.f70285d;
        if (i13 <= 0 || fA == f14) {
            return;
        }
        float f21 = (f14 - fA) * this.f70288g;
        float fMin = Math.min(Math.abs(f21), f19 * 0.1f * i13);
        if (f21 > 0.0f) {
            this.f70286e -= fMin / this.f70285d;
            this.f70287f += fMin / this.f70288g;
        } else {
            this.f70286e += fMin / this.f70285d;
            this.f70287f -= fMin / this.f70288g;
        }
    }

    public int e() {
        return this.f70284c + this.f70285d + this.f70288g;
    }

    public final float f() {
        return (this.f70287f * this.f70288g) + (this.f70286e * this.f70285d) + (this.f70283b * this.f70284c);
    }

    public final boolean g() {
        int i11 = this.f70288g;
        if (i11 <= 0 || this.f70284c <= 0 || this.f70285d <= 0) {
            return i11 <= 0 || this.f70284c <= 0 || this.f70287f > this.f70283b;
        }
        float f11 = this.f70287f;
        float f12 = this.f70286e;
        return f11 > f12 && f12 > this.f70283b;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.f70282a + ", smallCount=" + this.f70284c + ", smallSize=" + this.f70283b + ", mediumCount=" + this.f70285d + ", mediumSize=" + this.f70286e + ", largeCount=" + this.f70288g + ", largeSize=" + this.f70287f + ", cost=" + this.f70289h + "]";
    }
}
