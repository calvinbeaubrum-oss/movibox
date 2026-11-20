package x3;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f79864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f79865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f79866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f79867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f79868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f79869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final short[] f79870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public short[] f79871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f79872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short[] f79873l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f79874m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public short[] f79875n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f79876o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f79877p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f79878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f79879r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f79880s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f79881t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f79882u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f79883v;

    public b(int i11, int i12, float f11, float f12, int i13) {
        this.f79862a = i11;
        this.f79863b = i12;
        this.f79864c = f11;
        this.f79865d = f12;
        this.f79866e = i11 / i13;
        this.f79867f = i11 / LogSeverity.WARNING_VALUE;
        int i14 = i11 / 65;
        this.f79868g = i14;
        int i15 = i14 * 2;
        this.f79869h = i15;
        this.f79870i = new short[i15];
        this.f79871j = new short[i15 * i12];
        this.f79873l = new short[i15 * i12];
        this.f79875n = new short[i15 * i12];
    }

    public static void p(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = (i13 * i12) + i16;
            int i18 = (i15 * i12) + i16;
            int i19 = (i14 * i12) + i16;
            for (int i21 = 0; i21 < i11; i21++) {
                sArr[i17] = (short) (((sArr2[i19] * (i11 - i21)) + (sArr3[i18] * i21)) / i11);
                i17 += i12;
                i19 += i12;
                i18 += i12;
            }
        }
    }

    public final void a(float f11, int i11) {
        int i12;
        int i13;
        if (this.f79874m == i11) {
            return;
        }
        int i14 = this.f79862a;
        int i15 = (int) (i14 / f11);
        while (true) {
            if (i15 <= 16384 && i14 <= 16384) {
                break;
            }
            i15 /= 2;
            i14 /= 2;
        }
        o(i11);
        int i16 = 0;
        while (true) {
            int i17 = this.f79876o;
            if (i16 >= i17 - 1) {
                u(i17 - 1);
                return;
            }
            while (true) {
                i12 = this.f79877p;
                int i18 = (i12 + 1) * i15;
                i13 = this.f79878q;
                if (i18 <= i13 * i14) {
                    break;
                }
                this.f79873l = f(this.f79873l, this.f79874m, 1);
                int i19 = 0;
                while (true) {
                    int i21 = this.f79863b;
                    if (i19 < i21) {
                        this.f79873l[(this.f79874m * i21) + i19] = n(this.f79875n, (i21 * i16) + i19, i14, i15);
                        i19++;
                    }
                }
                this.f79878q++;
                this.f79874m++;
            }
            int i22 = i12 + 1;
            this.f79877p = i22;
            if (i22 == i14) {
                this.f79877p = 0;
                z3.a.g(i13 == i15);
                this.f79878q = 0;
            }
            i16++;
        }
    }

    public final void b(float f11) {
        int iW;
        int i11 = this.f79872k;
        if (i11 < this.f79869h) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f79879r > 0) {
                iW = c(i12);
            } else {
                int iG = g(this.f79871j, i12);
                iW = ((double) f11) > 1.0d ? iG + w(this.f79871j, i12, f11, iG) : m(this.f79871j, i12, f11, iG);
            }
            i12 += iW;
        } while (this.f79869h + i12 <= i11);
        v(i12);
    }

    public final int c(int i11) {
        int iMin = Math.min(this.f79869h, this.f79879r);
        d(this.f79871j, i11, iMin);
        this.f79879r -= iMin;
        return iMin;
    }

    public final void d(short[] sArr, int i11, int i12) {
        short[] sArrF = f(this.f79873l, this.f79874m, i12);
        this.f79873l = sArrF;
        int i13 = this.f79863b;
        System.arraycopy(sArr, i11 * i13, sArrF, this.f79874m * i13, i13 * i12);
        this.f79874m += i12;
    }

    public final void e(short[] sArr, int i11, int i12) {
        int i13 = this.f79869h / i12;
        int i14 = this.f79863b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f79870i[i17] = (short) (i18 / i15);
        }
    }

    public final short[] f(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f79863b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    public final int g(short[] sArr, int i11) {
        int iH;
        int i12 = this.f79862a;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.f79863b == 1 && i13 == 1) {
            iH = h(sArr, i11, this.f79867f, this.f79868g);
        } else {
            e(sArr, i11, i13);
            int iH2 = h(this.f79870i, 0, this.f79867f / i13, this.f79868g / i13);
            if (i13 != 1) {
                int i14 = iH2 * i13;
                int i15 = i13 * 4;
                int i16 = i14 - i15;
                int i17 = i14 + i15;
                int i18 = this.f79867f;
                if (i16 < i18) {
                    i16 = i18;
                }
                int i19 = this.f79868g;
                if (i17 > i19) {
                    i17 = i19;
                }
                if (this.f79863b == 1) {
                    iH = h(sArr, i11, i16, i17);
                } else {
                    e(sArr, i11, 1);
                    iH = h(this.f79870i, 0, i16, i17);
                }
            } else {
                iH = iH2;
            }
        }
        int i21 = q(this.f79882u, this.f79883v) ? this.f79880s : iH;
        this.f79881t = this.f79882u;
        this.f79880s = iH;
        return i21;
    }

    public final int h(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f79863b;
        int i15 = 255;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        while (i12 <= i13) {
            int iAbs = 0;
            for (int i19 = 0; i19 < i12; i19++) {
                iAbs += Math.abs(sArr[i14 + i19] - sArr[(i14 + i12) + i19]);
            }
            if (iAbs * i17 < i16 * i12) {
                i17 = i12;
                i16 = iAbs;
            }
            if (iAbs * i15 > i18 * i12) {
                i15 = i12;
                i18 = iAbs;
            }
            i12++;
        }
        this.f79882u = i16 / i17;
        this.f79883v = i18 / i15;
        return i17;
    }

    public void i() {
        this.f79872k = 0;
        this.f79874m = 0;
        this.f79876o = 0;
        this.f79877p = 0;
        this.f79878q = 0;
        this.f79879r = 0;
        this.f79880s = 0;
        this.f79881t = 0;
        this.f79882u = 0;
        this.f79883v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f79863b, this.f79874m);
        shortBuffer.put(this.f79873l, 0, this.f79863b * iMin);
        int i11 = this.f79874m - iMin;
        this.f79874m = i11;
        short[] sArr = this.f79873l;
        int i12 = this.f79863b;
        System.arraycopy(sArr, iMin * i12, sArr, 0, i11 * i12);
    }

    public int k() {
        return this.f79874m * this.f79863b * 2;
    }

    public int l() {
        return this.f79872k * this.f79863b * 2;
    }

    public final int m(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            this.f79879r = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] sArrF = f(this.f79873l, this.f79874m, i14);
        this.f79873l = sArrF;
        int i15 = this.f79863b;
        System.arraycopy(sArr, i11 * i15, sArrF, this.f79874m * i15, i15 * i12);
        p(i13, this.f79863b, this.f79873l, this.f79874m + i12, sArr, i11 + i12, sArr, i11);
        this.f79874m += i14;
        return i13;
    }

    public final short n(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f79863b];
        int i14 = this.f79878q * i12;
        int i15 = this.f79877p;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    public final void o(int i11) {
        int i12 = this.f79874m - i11;
        short[] sArrF = f(this.f79875n, this.f79876o, i12);
        this.f79875n = sArrF;
        short[] sArr = this.f79873l;
        int i13 = this.f79863b;
        System.arraycopy(sArr, i11 * i13, sArrF, this.f79876o * i13, i13 * i12);
        this.f79874m = i11;
        this.f79876o += i12;
    }

    public final boolean q(int i11, int i12) {
        return i11 != 0 && this.f79880s != 0 && i12 <= i11 * 3 && i11 * 2 > this.f79881t * 3;
    }

    public final void r() {
        int i11 = this.f79874m;
        float f11 = this.f79864c;
        float f12 = this.f79865d;
        float f13 = f11 / f12;
        float f14 = this.f79866e * f12;
        double d11 = f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            b(f13);
        } else {
            d(this.f79871j, 0, this.f79872k);
            this.f79872k = 0;
        }
        if (f14 != 1.0f) {
            a(f14, i11);
        }
    }

    public void s() {
        int i11;
        int i12 = this.f79872k;
        float f11 = this.f79864c;
        float f12 = this.f79865d;
        int i13 = this.f79874m + ((int) ((((i12 / (f11 / f12)) + this.f79876o) / (this.f79866e * f12)) + 0.5f));
        this.f79871j = f(this.f79871j, i12, (this.f79869h * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f79869h;
            int i15 = this.f79863b;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.f79871j[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f79872k += i11 * 2;
        r();
        if (this.f79874m > i13) {
            this.f79874m = i13;
        }
        this.f79872k = 0;
        this.f79879r = 0;
        this.f79876o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i11 = this.f79863b;
        int i12 = iRemaining / i11;
        short[] sArrF = f(this.f79871j, this.f79872k, i12);
        this.f79871j = sArrF;
        shortBuffer.get(sArrF, this.f79872k * this.f79863b, ((i11 * i12) * 2) / 2);
        this.f79872k += i12;
        r();
    }

    public final void u(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f79875n;
        int i12 = this.f79863b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f79876o - i11) * i12);
        this.f79876o -= i11;
    }

    public final void v(int i11) {
        int i12 = this.f79872k - i11;
        short[] sArr = this.f79871j;
        int i13 = this.f79863b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f79872k = i12;
    }

    public final int w(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.f79879r = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] sArrF = f(this.f79873l, this.f79874m, i13);
        this.f79873l = sArrF;
        p(i13, this.f79863b, sArrF, this.f79874m, sArr, i11, sArr, i11 + i12);
        this.f79874m += i13;
        return i13;
    }
}
