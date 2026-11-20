package com.applovin.impl;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class nk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f21353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f21354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f21355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final short[] f21359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private short[] f21360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f21361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private short[] f21362l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f21363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private short[] f21364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f21365o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f21366p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f21367q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f21368r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f21369s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f21370t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f21371u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f21372v;

    public nk(int i11, int i12, float f11, float f12, int i13) {
        this.f21351a = i11;
        this.f21352b = i12;
        this.f21353c = f11;
        this.f21354d = f12;
        this.f21355e = i11 / i13;
        this.f21356f = i11 / LogSeverity.WARNING_VALUE;
        int i14 = i11 / 65;
        this.f21357g = i14;
        int i15 = i14 * 2;
        this.f21358h = i15;
        this.f21359i = new short[i15];
        int i16 = i15 * i12;
        this.f21360j = new short[i16];
        this.f21362l = new short[i16];
        this.f21364n = new short[i16];
    }

    private int a(int i11) {
        int iMin = Math.min(this.f21358h, this.f21368r);
        a(this.f21360j, i11, iMin);
        this.f21368r -= iMin;
        return iMin;
    }

    private int a(short[] sArr, int i11) {
        int iA;
        int i12 = this.f21351a;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.f21352b == 1 && i13 == 1) {
            iA = a(sArr, i11, this.f21356f, this.f21357g);
        } else {
            b(sArr, i11, i13);
            int iA2 = a(this.f21359i, 0, this.f21356f / i13, this.f21357g / i13);
            if (i13 != 1) {
                int i14 = iA2 * i13;
                int i15 = i13 * 4;
                int i16 = i14 - i15;
                int i17 = i14 + i15;
                int i18 = this.f21356f;
                if (i16 < i18) {
                    i16 = i18;
                }
                int i19 = this.f21357g;
                if (i17 > i19) {
                    i17 = i19;
                }
                if (this.f21352b == 1) {
                    iA = a(sArr, i11, i16, i17);
                } else {
                    b(sArr, i11, 1);
                    iA = a(this.f21359i, 0, i16, i17);
                }
            } else {
                iA = iA2;
            }
        }
        int i21 = a(this.f21371u, this.f21372v) ? this.f21369s : iA;
        this.f21370t = this.f21371u;
        this.f21369s = iA;
        return i21;
    }

    private int a(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            this.f21368r = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
            i13 = i12;
        }
        int i14 = i12 + i13;
        short[] sArrC = c(this.f21362l, this.f21363m, i14);
        this.f21362l = sArrC;
        int i15 = this.f21352b;
        System.arraycopy(sArr, i11 * i15, sArrC, this.f21363m * i15, i15 * i12);
        a(i13, this.f21352b, this.f21362l, this.f21363m + i12, sArr, i11 + i12, sArr, i11);
        this.f21363m += i14;
        return i13;
    }

    private int a(short[] sArr, int i11, int i12, int i13) {
        int i14 = i11 * this.f21352b;
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
        this.f21371u = i16 / i17;
        this.f21372v = i18 / i15;
        return i17;
    }

    private void a(float f11) {
        int iB;
        int i11 = this.f21361k;
        if (i11 < this.f21358h) {
            return;
        }
        int i12 = 0;
        do {
            if (this.f21368r > 0) {
                iB = a(i12);
            } else {
                int iA = a(this.f21360j, i12);
                iB = ((double) f11) > 1.0d ? iA + b(this.f21360j, i12, f11, iA) : a(this.f21360j, i12, f11, iA);
            }
            i12 += iB;
        } while (this.f21358h + i12 <= i11);
        d(i12);
    }

    private void a(float f11, int i11) {
        int i12;
        int i13;
        if (this.f21363m == i11) {
            return;
        }
        int i14 = this.f21351a;
        int i15 = (int) (i14 / f11);
        while (true) {
            if (i15 <= 16384 && i14 <= 16384) {
                break;
            }
            i15 /= 2;
            i14 /= 2;
        }
        b(i11);
        int i16 = 0;
        while (true) {
            int i17 = this.f21365o - 1;
            if (i16 >= i17) {
                c(i17);
                return;
            }
            while (true) {
                i12 = this.f21366p + 1;
                int i18 = i12 * i15;
                i13 = this.f21367q;
                if (i18 <= i13 * i14) {
                    break;
                }
                this.f21362l = c(this.f21362l, this.f21363m, 1);
                int i19 = 0;
                while (true) {
                    int i21 = this.f21352b;
                    if (i19 < i21) {
                        this.f21362l[(this.f21363m * i21) + i19] = b(this.f21364n, (i21 * i16) + i19, i14, i15);
                        i19++;
                    }
                }
                this.f21367q++;
                this.f21363m++;
            }
            this.f21366p = i12;
            if (i12 == i14) {
                this.f21366p = 0;
                b1.b(i13 == i15);
                this.f21367q = 0;
            }
            i16++;
        }
    }

    private static void a(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
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

    private void a(short[] sArr, int i11, int i12) {
        short[] sArrC = c(this.f21362l, this.f21363m, i12);
        this.f21362l = sArrC;
        int i13 = this.f21352b;
        System.arraycopy(sArr, i11 * i13, sArrC, this.f21363m * i13, i13 * i12);
        this.f21363m += i12;
    }

    private boolean a(int i11, int i12) {
        return i11 != 0 && this.f21369s != 0 && i12 <= i11 * 3 && i11 * 2 > this.f21370t * 3;
    }

    private int b(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.f21368r = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] sArrC = c(this.f21362l, this.f21363m, i13);
        this.f21362l = sArrC;
        a(i13, this.f21352b, sArrC, this.f21363m, sArr, i11, sArr, i11 + i12);
        this.f21363m += i13;
        return i13;
    }

    private short b(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[i11 + this.f21352b];
        int i14 = this.f21367q * i12;
        int i15 = this.f21366p;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((s11 * i18) + ((i19 - i18) * s12)) / i19);
    }

    private void b(int i11) {
        int i12 = this.f21363m - i11;
        short[] sArrC = c(this.f21364n, this.f21365o, i12);
        this.f21364n = sArrC;
        short[] sArr = this.f21362l;
        int i13 = this.f21352b;
        System.arraycopy(sArr, i11 * i13, sArrC, this.f21365o * i13, i13 * i12);
        this.f21363m = i11;
        this.f21365o += i12;
    }

    private void b(short[] sArr, int i11, int i12) {
        int i13 = this.f21358h / i12;
        int i14 = this.f21352b;
        int i15 = i12 * i14;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.f21359i[i17] = (short) (i18 / i15);
        }
    }

    private void c(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.f21364n;
        int i12 = this.f21352b;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.f21365o - i11) * i12);
        this.f21365o -= i11;
    }

    private short[] c(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.f21352b;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    private void d() {
        int i11 = this.f21363m;
        float f11 = this.f21353c;
        float f12 = this.f21354d;
        float f13 = f11 / f12;
        float f14 = this.f21355e * f12;
        double d11 = f13;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            a(f13);
        } else {
            a(this.f21360j, 0, this.f21361k);
            this.f21361k = 0;
        }
        if (f14 != 1.0f) {
            a(f14, i11);
        }
    }

    private void d(int i11) {
        int i12 = this.f21361k - i11;
        short[] sArr = this.f21360j;
        int i13 = this.f21352b;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.f21361k = i12;
    }

    public void a() {
        this.f21361k = 0;
        this.f21363m = 0;
        this.f21365o = 0;
        this.f21366p = 0;
        this.f21367q = 0;
        this.f21368r = 0;
        this.f21369s = 0;
        this.f21370t = 0;
        this.f21371u = 0;
        this.f21372v = 0;
    }

    public void a(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f21352b, this.f21363m);
        shortBuffer.put(this.f21362l, 0, this.f21352b * iMin);
        int i11 = this.f21363m - iMin;
        this.f21363m = i11;
        short[] sArr = this.f21362l;
        int i12 = this.f21352b;
        System.arraycopy(sArr, iMin * i12, sArr, 0, i11 * i12);
    }

    public int b() {
        return this.f21363m * this.f21352b * 2;
    }

    public void b(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i11 = this.f21352b;
        int i12 = iRemaining / i11;
        short[] sArrC = c(this.f21360j, this.f21361k, i12);
        this.f21360j = sArrC;
        shortBuffer.get(sArrC, this.f21361k * this.f21352b, ((i11 * i12) * 2) / 2);
        this.f21361k += i12;
        d();
    }

    public int c() {
        return this.f21361k * this.f21352b * 2;
    }

    public void e() {
        int i11;
        int i12 = this.f21361k;
        float f11 = this.f21353c;
        float f12 = this.f21354d;
        int i13 = this.f21363m + ((int) ((((i12 / (f11 / f12)) + this.f21365o) / (this.f21355e * f12)) + 0.5f));
        this.f21360j = c(this.f21360j, i12, (this.f21358h * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.f21358h * 2;
            int i15 = this.f21352b;
            if (i14 >= i11 * i15) {
                break;
            }
            this.f21360j[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.f21361k += i11;
        d();
        if (this.f21363m > i13) {
            this.f21363m = i13;
        }
        this.f21361k = 0;
        this.f21368r = 0;
        this.f21365o = 0;
    }
}
