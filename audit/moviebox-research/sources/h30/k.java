package h30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f66181a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66182b = 200;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66183c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f66184d = new int[94];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f66185e = new int[94];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f66186f = new float[94];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f66187g = new float[94];

    public k() {
        f();
    }

    public void a() {
        for (int i11 = 0; i11 < 94; i11++) {
            float[] fArr = this.f66186f;
            float f11 = this.f66184d[i11];
            int i12 = this.f66181a;
            fArr[i11] = f11 / i12;
            this.f66187g[i11] = this.f66185e[i11] / i12;
        }
    }

    public boolean b() {
        return this.f66181a > this.f66182b;
    }

    public float c(float[] fArr, float f11, float[] fArr2, float f12) {
        return (f11 * d(fArr, this.f66186f)) + (f12 * d(fArr2, this.f66187g));
    }

    public float d(float[] fArr, float[] fArr2) {
        float f11 = 0.0f;
        for (int i11 = 0; i11 < 94; i11++) {
            float f12 = fArr[i11] - fArr2[i11];
            f11 += f12 * f12;
        }
        return ((float) Math.sqrt(f11)) / 94.0f;
    }

    public boolean e() {
        return this.f66181a > 1;
    }

    public void f() {
        this.f66181a = 0;
        this.f66183c = 0;
        for (int i11 = 0; i11 < 94; i11++) {
            int[] iArr = this.f66184d;
            this.f66185e[i11] = 0;
            iArr[i11] = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    public boolean g(byte[] bArr, int i11) {
        if (this.f66183c == 1) {
            return false;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = this.f66183c;
            if (1 == i14) {
                break;
            }
            if (i14 == 0) {
                byte b11 = bArr[i13];
                if ((b11 & 128) != 0) {
                    if (255 == (b11 & 255) || 161 > (b11 & 255)) {
                        this.f66183c = 1;
                    } else {
                        this.f66181a++;
                        int[] iArr = this.f66184d;
                        int i15 = (b11 & 255) - 161;
                        iArr[i15] = iArr[i15] + 1;
                        this.f66183c = 2;
                    }
                }
            } else if (i14 != 1) {
                if (i14 != 2) {
                    this.f66183c = 1;
                } else {
                    byte b12 = bArr[i13];
                    if ((b12 & 128) == 0 || 255 == (b12 & 255) || 161 > (b12 & 255)) {
                        this.f66183c = 1;
                    } else {
                        this.f66181a++;
                        int[] iArr2 = this.f66185e;
                        int i16 = (b12 & 255) - 161;
                        iArr2[i16] = iArr2[i16] + 1;
                        this.f66183c = 0;
                    }
                }
            }
            i12++;
            i13++;
        }
        return 1 != this.f66183c;
    }
}
