package com.transsion.player.exo;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f54278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f54280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f54281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f54282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f54283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f54284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f54285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f54286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short[] f54287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public short[] f54288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f54289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public short[] f54290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f54291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public short[] f54292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f54293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f54294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f54295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f54296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f54297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f54298u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f54299v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f54300w;

    public d(int i11, int i12, float f11, float f12, float f13, int i13) {
        this.f54278a = i11;
        this.f54279b = i12;
        this.f54280c = f11;
        this.f54281d = f12;
        this.f54282e = f13;
        this.f54283f = i11 / i13;
        this.f54284g = i11 / LogSeverity.WARNING_VALUE;
        int i14 = i11 / 65;
        this.f54285h = i14;
        int i15 = i14 * 2;
        this.f54286i = i15;
        this.f54287j = new short[i15];
        this.f54288k = new short[i15 * i12];
        this.f54290m = new short[i15 * i12];
        this.f54292o = new short[i15 * i12];
    }

    public static void o(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
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
        if (this.f54291n == i11) {
            return;
        }
        int i14 = this.f54278a;
        int i15 = (int) (i14 / f11);
        while (true) {
            if (i15 <= 16384 && i14 <= 16384) {
                break;
            }
            i15 /= 2;
            i14 /= 2;
        }
        n(i11);
        int i16 = 0;
        while (true) {
            int i17 = this.f54293p;
            if (i16 >= i17 - 1) {
                t(i17 - 1);
                return;
            }
            while (true) {
                i12 = this.f54294q;
                int i18 = (i12 + 1) * i15;
                i13 = this.f54295r;
                if (i18 <= i13 * i14) {
                    break;
                }
                this.f54290m = f(this.f54290m, this.f54291n, 1);
                int i19 = 0;
                while (true) {
                    int i21 = this.f54279b;
                    if (i19 < i21) {
                        this.f54290m[(this.f54291n * i21) + i19] = m(this.f54292o, (i21 * i16) + i19, i14, i15);
                        i19++;
                    }
                }
                this.f54295r++;
                this.f54291n++;
            }
            int i22 = i12 + 1;
            this.f54294q = i22;
            if (i22 == i14) {
                this.f54294q = 0;
                z3.a.g(i13 == i15);
                this.f54295r = 0;
            }
            i16++;
        }
    }

    public final void b(float f11) {
        int iX;
        int i11 = this.f54289l;
        if (i11 < this.f54286i) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f54296s > 0) {
                iX = c(i12);
            } else {
                int iG = g(this.f54288k, i12);
                iX = ((double) f11) > 1.0d ? iG + x(this.f54288k, i12, f11, iG) : l(this.f54288k, i12, f11, iG);
            }
            i12 += iX;
        } while (this.f54286i + i12 <= i11);
        u(i12);
    }

    public final int c(int i11) {
        int iMin = Math.min(this.f54286i, this.f54296s);
        d(this.f54288k, i11, iMin);
        this.f54296s -= iMin;
        return iMin;
    }

    public final void d(short[] sArr, int i11, int i12) {
        short[] sArrF = f(this.f54290m, this.f54291n, i12);
        this.f54290m = sArrF;
        int i13 = this.f54279b;
        System.arraycopy(sArr, i11 * i13, sArrF, this.f54291n * i13, i13 * i12);
        this.f54291n += i12;
    }

    public final void e(short[] sArr, int i11, int i12) {
        int i13 = this.f54286i / i12;
        int i14 = this.f54279b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f54287j[i17] = (short) (i18 / i15);
        }
    }

    public final short[] f(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f54279b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    public final int g(short[] sArr, int i11) {
        int iH;
        int i12 = this.f54278a;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.f54279b == 1 && i13 == 1) {
            iH = h(sArr, i11, this.f54284g, this.f54285h);
        } else {
            e(sArr, i11, i13);
            int iH2 = h(this.f54287j, 0, this.f54284g / i13, this.f54285h / i13);
            if (i13 != 1) {
                int i14 = iH2 * i13;
                int i15 = i13 * 4;
                int i16 = i14 - i15;
                int i17 = i14 + i15;
                int i18 = this.f54284g;
                if (i16 < i18) {
                    i16 = i18;
                }
                int i19 = this.f54285h;
                if (i17 > i19) {
                    i17 = i19;
                }
                if (this.f54279b == 1) {
                    iH = h(sArr, i11, i16, i17);
                } else {
                    e(sArr, i11, 1);
                    iH = h(this.f54287j, 0, i16, i17);
                }
            } else {
                iH = iH2;
            }
        }
        int i21 = p(this.f54299v, this.f54300w) ? this.f54297t : iH;
        this.f54298u = this.f54299v;
        this.f54297t = iH;
        return i21;
    }

    public final int h(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f54279b;
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
        this.f54299v = i16 / i17;
        this.f54300w = i18 / i15;
        return i17;
    }

    public void i() {
        this.f54289l = 0;
        this.f54291n = 0;
        this.f54293p = 0;
        this.f54294q = 0;
        this.f54295r = 0;
        this.f54296s = 0;
        this.f54297t = 0;
        this.f54298u = 0;
        this.f54299v = 0;
        this.f54300w = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f54279b, this.f54291n);
        shortBuffer.put(this.f54290m, 0, this.f54279b * iMin);
        int i11 = this.f54291n - iMin;
        this.f54291n = i11;
        short[] sArr = this.f54290m;
        int i12 = this.f54279b;
        System.arraycopy(sArr, iMin * i12, sArr, 0, i11 * i12);
    }

    public int k() {
        return this.f54291n * this.f54279b * 2;
    }

    public final int l(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            this.f54296s = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] sArrF = f(this.f54290m, this.f54291n, i14);
        this.f54290m = sArrF;
        int i15 = this.f54279b;
        System.arraycopy(sArr, i11 * i15, sArrF, this.f54291n * i15, i15 * i12);
        o(i13, this.f54279b, this.f54290m, this.f54291n + i12, sArr, i11 + i12, sArr, i11);
        this.f54291n += i14;
        return i13;
    }

    public final short m(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f54279b];
        int i14 = this.f54295r * i12;
        int i15 = this.f54294q;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    public final void n(int i11) {
        int i12 = this.f54291n - i11;
        short[] sArrF = f(this.f54292o, this.f54293p, i12);
        this.f54292o = sArrF;
        short[] sArr = this.f54290m;
        int i13 = this.f54279b;
        System.arraycopy(sArr, i11 * i13, sArrF, this.f54293p * i13, i13 * i12);
        this.f54291n = i11;
        this.f54293p += i12;
    }

    public final boolean p(int i11, int i12) {
        return i11 != 0 && this.f54297t != 0 && i12 <= i11 * 3 && i11 * 2 > this.f54298u * 3;
    }

    public final void q() {
        int i11 = this.f54291n;
        float f11 = this.f54280c;
        float f12 = this.f54281d;
        float f13 = f11 / f12;
        float f14 = this.f54283f * f12;
        double d11 = f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            b(f13);
        } else {
            d(this.f54288k, 0, this.f54289l);
            this.f54289l = 0;
        }
        if (f14 != 1.0f) {
            a(f14, i11);
        }
        float f15 = this.f54282e;
        if (f15 != 1.0f) {
            v(this.f54290m, i11, this.f54291n - i11, f15);
        }
    }

    public void r() {
        int i11;
        int i12 = this.f54289l;
        float f11 = this.f54280c;
        float f12 = this.f54281d;
        int i13 = this.f54291n + ((int) ((((i12 / (f11 / f12)) + this.f54293p) / (this.f54283f * f12)) + 0.5f));
        this.f54288k = f(this.f54288k, i12, (this.f54286i * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f54286i;
            int i15 = this.f54279b;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.f54288k[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f54289l += i11 * 2;
        q();
        if (this.f54291n > i13) {
            this.f54291n = i13;
        }
        this.f54289l = 0;
        this.f54296s = 0;
        this.f54293p = 0;
    }

    public void s(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i11 = this.f54279b;
        int i12 = iRemaining / i11;
        short[] sArrF = f(this.f54288k, this.f54289l, i12);
        this.f54288k = sArrF;
        shortBuffer.get(sArrF, this.f54289l * this.f54279b, ((i11 * i12) * 2) / 2);
        this.f54289l += i12;
        q();
    }

    public final void t(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f54292o;
        int i12 = this.f54279b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f54293p - i11) * i12);
        this.f54293p -= i11;
    }

    public final void u(int i11) {
        int i12 = this.f54289l - i11;
        short[] sArr = this.f54288k;
        int i13 = this.f54279b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f54289l = i12;
    }

    public final void v(short[] sArr, int i11, int i12, float f11) {
        int i13 = (int) (f11 * 4096.0f);
        int i14 = this.f54279b;
        int i15 = i11 * i14;
        int i16 = (i12 * i14) + i15;
        while (i15 < i16) {
            int i17 = (sArr[i15] * i13) >> 12;
            if (i17 > 32767) {
                i17 = 32767;
            } else if (i17 < -32767) {
                i17 = -32767;
            }
            sArr[i15] = (short) i17;
            i15++;
        }
    }

    public void w(float f11) {
        this.f54282e = f11;
    }

    public final int x(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.f54296s = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] sArrF = f(this.f54290m, this.f54291n, i13);
        this.f54290m = sArrF;
        o(i13, this.f54279b, sArrF, this.f54291n, sArr, i11, sArr, i11 + i12);
        this.f54291n += i13;
        return i13;
    }
}
