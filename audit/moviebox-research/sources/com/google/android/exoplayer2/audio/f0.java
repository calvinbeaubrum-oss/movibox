package com.google.android.exoplayer2.audio;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f32840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f32841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f32842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f32843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f32844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f32845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final short[] f32846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public short[] f32847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f32848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short[] f32849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f32850m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public short[] f32851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f32852o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f32853p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f32854q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f32855r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f32856s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f32857t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f32858u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f32859v;

    public f0(int i11, int i12, float f11, float f12, int i13) {
        this.f32838a = i11;
        this.f32839b = i12;
        this.f32840c = f11;
        this.f32841d = f12;
        this.f32842e = i11 / i13;
        this.f32843f = i11 / LogSeverity.WARNING_VALUE;
        int i14 = i11 / 65;
        this.f32844g = i14;
        int i15 = i14 * 2;
        this.f32845h = i15;
        this.f32846i = new short[i15];
        this.f32847j = new short[i15 * i12];
        this.f32849l = new short[i15 * i12];
        this.f32851n = new short[i15 * i12];
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
        if (this.f32850m == i11) {
            return;
        }
        int i14 = this.f32838a;
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
            int i17 = this.f32852o;
            if (i16 >= i17 - 1) {
                u(i17 - 1);
                return;
            }
            while (true) {
                i12 = this.f32853p;
                int i18 = (i12 + 1) * i15;
                i13 = this.f32854q;
                if (i18 <= i13 * i14) {
                    break;
                }
                this.f32849l = f(this.f32849l, this.f32850m, 1);
                int i19 = 0;
                while (true) {
                    int i21 = this.f32839b;
                    if (i19 < i21) {
                        this.f32849l[(this.f32850m * i21) + i19] = n(this.f32851n, (i21 * i16) + i19, i14, i15);
                        i19++;
                    }
                }
                this.f32854q++;
                this.f32850m++;
            }
            int i22 = i12 + 1;
            this.f32853p = i22;
            if (i22 == i14) {
                this.f32853p = 0;
                com.google.android.exoplayer2.util.a.g(i13 == i15);
                this.f32854q = 0;
            }
            i16++;
        }
    }

    public final void b(float f11) {
        int iW;
        int i11 = this.f32848k;
        if (i11 < this.f32845h) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f32855r > 0) {
                iW = c(i12);
            } else {
                int iG = g(this.f32847j, i12);
                iW = ((double) f11) > 1.0d ? iG + w(this.f32847j, i12, f11, iG) : m(this.f32847j, i12, f11, iG);
            }
            i12 += iW;
        } while (this.f32845h + i12 <= i11);
        v(i12);
    }

    public final int c(int i11) {
        int iMin = Math.min(this.f32845h, this.f32855r);
        d(this.f32847j, i11, iMin);
        this.f32855r -= iMin;
        return iMin;
    }

    public final void d(short[] sArr, int i11, int i12) {
        short[] sArrF = f(this.f32849l, this.f32850m, i12);
        this.f32849l = sArrF;
        int i13 = this.f32839b;
        System.arraycopy(sArr, i11 * i13, sArrF, this.f32850m * i13, i13 * i12);
        this.f32850m += i12;
    }

    public final void e(short[] sArr, int i11, int i12) {
        int i13 = this.f32845h / i12;
        int i14 = this.f32839b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f32846i[i17] = (short) (i18 / i15);
        }
    }

    public final short[] f(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f32839b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    public final int g(short[] sArr, int i11) {
        int iH;
        int i12 = this.f32838a;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.f32839b == 1 && i13 == 1) {
            iH = h(sArr, i11, this.f32843f, this.f32844g);
        } else {
            e(sArr, i11, i13);
            int iH2 = h(this.f32846i, 0, this.f32843f / i13, this.f32844g / i13);
            if (i13 != 1) {
                int i14 = iH2 * i13;
                int i15 = i13 * 4;
                int i16 = i14 - i15;
                int i17 = i14 + i15;
                int i18 = this.f32843f;
                if (i16 < i18) {
                    i16 = i18;
                }
                int i19 = this.f32844g;
                if (i17 > i19) {
                    i17 = i19;
                }
                if (this.f32839b == 1) {
                    iH = h(sArr, i11, i16, i17);
                } else {
                    e(sArr, i11, 1);
                    iH = h(this.f32846i, 0, i16, i17);
                }
            } else {
                iH = iH2;
            }
        }
        int i21 = q(this.f32858u, this.f32859v) ? this.f32856s : iH;
        this.f32857t = this.f32858u;
        this.f32856s = iH;
        return i21;
    }

    public final int h(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f32839b;
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
        this.f32858u = i16 / i17;
        this.f32859v = i18 / i15;
        return i17;
    }

    public void i() {
        this.f32848k = 0;
        this.f32850m = 0;
        this.f32852o = 0;
        this.f32853p = 0;
        this.f32854q = 0;
        this.f32855r = 0;
        this.f32856s = 0;
        this.f32857t = 0;
        this.f32858u = 0;
        this.f32859v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f32839b, this.f32850m);
        shortBuffer.put(this.f32849l, 0, this.f32839b * iMin);
        int i11 = this.f32850m - iMin;
        this.f32850m = i11;
        short[] sArr = this.f32849l;
        int i12 = this.f32839b;
        System.arraycopy(sArr, iMin * i12, sArr, 0, i11 * i12);
    }

    public int k() {
        return this.f32850m * this.f32839b * 2;
    }

    public int l() {
        return this.f32848k * this.f32839b * 2;
    }

    public final int m(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            this.f32855r = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] sArrF = f(this.f32849l, this.f32850m, i14);
        this.f32849l = sArrF;
        int i15 = this.f32839b;
        System.arraycopy(sArr, i11 * i15, sArrF, this.f32850m * i15, i15 * i12);
        p(i13, this.f32839b, this.f32849l, this.f32850m + i12, sArr, i11 + i12, sArr, i11);
        this.f32850m += i14;
        return i13;
    }

    public final short n(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f32839b];
        int i14 = this.f32854q * i12;
        int i15 = this.f32853p;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    public final void o(int i11) {
        int i12 = this.f32850m - i11;
        short[] sArrF = f(this.f32851n, this.f32852o, i12);
        this.f32851n = sArrF;
        short[] sArr = this.f32849l;
        int i13 = this.f32839b;
        System.arraycopy(sArr, i11 * i13, sArrF, this.f32852o * i13, i13 * i12);
        this.f32850m = i11;
        this.f32852o += i12;
    }

    public final boolean q(int i11, int i12) {
        return i11 != 0 && this.f32856s != 0 && i12 <= i11 * 3 && i11 * 2 > this.f32857t * 3;
    }

    public final void r() {
        int i11 = this.f32850m;
        float f11 = this.f32840c;
        float f12 = this.f32841d;
        float f13 = f11 / f12;
        float f14 = this.f32842e * f12;
        double d11 = f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            b(f13);
        } else {
            d(this.f32847j, 0, this.f32848k);
            this.f32848k = 0;
        }
        if (f14 != 1.0f) {
            a(f14, i11);
        }
    }

    public void s() {
        int i11;
        int i12 = this.f32848k;
        float f11 = this.f32840c;
        float f12 = this.f32841d;
        int i13 = this.f32850m + ((int) ((((i12 / (f11 / f12)) + this.f32852o) / (this.f32842e * f12)) + 0.5f));
        this.f32847j = f(this.f32847j, i12, (this.f32845h * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f32845h;
            int i15 = this.f32839b;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.f32847j[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f32848k += i11 * 2;
        r();
        if (this.f32850m > i13) {
            this.f32850m = i13;
        }
        this.f32848k = 0;
        this.f32855r = 0;
        this.f32852o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i11 = this.f32839b;
        int i12 = iRemaining / i11;
        short[] sArrF = f(this.f32847j, this.f32848k, i12);
        this.f32847j = sArrF;
        shortBuffer.get(sArrF, this.f32848k * this.f32839b, ((i11 * i12) * 2) / 2);
        this.f32848k += i12;
        r();
    }

    public final void u(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f32851n;
        int i12 = this.f32839b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f32852o - i11) * i12);
        this.f32852o -= i11;
    }

    public final void v(int i11) {
        int i12 = this.f32848k - i11;
        short[] sArr = this.f32847j;
        int i13 = this.f32839b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f32848k = i12;
    }

    public final int w(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.f32855r = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] sArrF = f(this.f32849l, this.f32850m, i13);
        this.f32849l = sArrF;
        p(i13, this.f32839b, sArrF, this.f32850m, sArr, i11, sArr, i11 + i12);
        this.f32850m += i13;
        return i13;
    }
}
