package com.facebook.ads.redexgen.uinode;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B6 {
    public static String[] A0M = {"OjKCpSHRaQgRVuqtUlgsb9O8", "00OaDgM7p4igg1vHbesCR74DVTlAeC7z", "TzmlGabo8AOjcKFjChfq2OdnE6jP", "eUJX5SGKEEZf9vIFl", "j2zFnhkJHUredpBjDjfUiogYLN6sD6KJ", "gWZYAfYL2BaqEY2VQTncveV2", "fwiYKc5SQMrWihGSp5I7vQU09P9mYkrS", "9p8sUcgEmhCbeCaZ4cFvJcsv2VoCKNVu"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public short[] A0A;
    public short[] A0B;
    public short[] A0C;
    public final float A0D;
    public final float A0E;
    public final float A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final short[] A0L;

    public B6(int i11, int i12, float f11, float f12, int i13) {
        this.A0H = i11;
        this.A0G = i12;
        this.A0F = f11;
        this.A0D = f12;
        this.A0E = i11 / i13;
        this.A0K = i11 / LogSeverity.WARNING_VALUE;
        int i14 = i11 / 65;
        this.A0I = i14;
        int i15 = i14 * 2;
        this.A0J = i15;
        this.A0L = new short[i15];
        this.A0A = new short[i15 * i12];
        this.A0B = new short[i15 * i12];
        this.A0C = new short[i15 * i12];
    }

    private int A00(int i11) {
        int iMin = Math.min(this.A0J, this.A09);
        A0D(this.A0A, i11, iMin);
        this.A09 -= iMin;
        return iMin;
    }

    private int A01(short[] sArr, int i11) {
        int iA04;
        int i12 = this.A0H;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.A0G == 1 && i13 == 1) {
            iA04 = A04(sArr, i11, this.A0K, this.A0I);
        } else {
            A0E(sArr, i11, i13);
            iA04 = A04(this.A0L, 0, this.A0K / i13, this.A0I / i13);
            if (i13 != 1) {
                int i14 = iA04 * i13;
                int i15 = i14 - (i13 * 4);
                int i16 = (i13 * 4) + i14;
                if (i15 < this.A0K) {
                    i15 = this.A0K;
                }
                if (i16 > this.A0I) {
                    i16 = this.A0I;
                }
                if (this.A0G == 1) {
                    iA04 = A04(sArr, i11, i15, i16);
                } else {
                    A0E(sArr, i11, 1);
                    iA04 = A04(this.A0L, 0, i15, i16);
                }
            }
        }
        int i17 = this.A02;
        int i18 = this.A01;
        String[] strArr = A0M;
        if (strArr[5].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A0M[1] = "8bhQeTnLevaZP1Rdp3IHUAHszuXZY5fw";
        int i19 = A0F(i17, i18) ? this.A08 : iA04;
        this.A07 = this.A02;
        this.A08 = iA04;
        return i19;
    }

    private int A02(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 < 0.5f) {
            i13 = (int) ((i12 * f11) / (1.0f - f11));
        } else {
            i13 = i12;
            this.A09 = (int) ((i12 * ((2.0f * f11) - 1.0f)) / (1.0f - f11));
        }
        short[] sArrA0G = A0G(this.A0B, this.A05, i12 + i13);
        this.A0B = sArrA0G;
        int i14 = this.A0G;
        System.arraycopy(sArr, i11 * i14, sArrA0G, this.A05 * i14, i14 * i12);
        A0C(i13, this.A0G, this.A0B, this.A05 + i12, sArr, i11 + i12, sArr, i11);
        this.A05 += i12 + i13;
        return i13;
    }

    private int A03(short[] sArr, int i11, float f11, int i12) {
        int i13;
        if (f11 >= 2.0f) {
            i13 = (int) (i12 / (f11 - 1.0f));
        } else {
            this.A09 = (int) ((i12 * (2.0f - f11)) / (f11 - 1.0f));
            i13 = i12;
        }
        short[] sArrA0G = A0G(this.A0B, this.A05, i13);
        this.A0B = sArrA0G;
        A0C(i13, this.A0G, sArrA0G, this.A05, sArr, i11, sArr, i11 + i12);
        this.A05 += i13;
        return i13;
    }

    private int A04(short[] sArr, int i11, int i12, int i13) {
        int i14 = 0;
        int i15 = 255;
        int i16 = 1;
        int i17 = 0;
        int i18 = i11 * this.A0G;
        while (i12 <= i13) {
            int iAbs = 0;
            for (int i19 = 0; i19 < i12; i19++) {
                iAbs += Math.abs(sArr[i18 + i19] - sArr[(i18 + i12) + i19]);
            }
            if (iAbs * i14 < i16 * i12) {
                i16 = iAbs;
                i14 = i12;
            }
            if (iAbs * i15 > i17 * i12) {
                i17 = iAbs;
                i15 = i12;
            }
            i12++;
        }
        this.A02 = i16 / i14;
        this.A01 = i17 / i15;
        return i14;
    }

    private short A05(short[] sArr, int i11, int i12, int i13) {
        short s11 = sArr[i11];
        short s12 = sArr[this.A0G + i11];
        int i14 = this.A03 * i12;
        int i15 = this.A04;
        int i16 = i15 * i13;
        int i17 = (i15 + 1) * i13;
        int i18 = i17 - i14;
        int i19 = i17 - i16;
        return (short) (((i18 * s11) + ((i19 - i18) * s12)) / i19);
    }

    private void A06() {
        int i11 = this.A05;
        float f11 = this.A0F;
        float f12 = this.A0D;
        float f13 = f11 / f12;
        float f14 = this.A0E * f12;
        if (f13 > 1.00001d || f13 < 0.99999d) {
            A07(f13);
        } else {
            A0D(this.A0A, 0, this.A00);
            this.A00 = 0;
        }
        if (f14 != 1.0f) {
            A08(f14, i11);
        }
    }

    private void A07(float f11) {
        if (this.A00 < this.A0J) {
            return;
        }
        int i11 = this.A00;
        int iA03 = 0;
        do {
            if (this.A09 > 0) {
                iA03 += A00(iA03);
            } else {
                int iA01 = A01(this.A0A, iA03);
                iA03 = ((double) f11) > 1.0d ? iA03 + A03(this.A0A, iA03, f11, iA01) + iA01 : iA03 + A02(this.A0A, iA03, f11, iA01);
            }
        } while (this.A0J + iA03 <= i11);
        A0B(iA03);
    }

    private void A08(float f11, int i11) {
        int i12;
        int i13;
        if (this.A05 == i11) {
            return;
        }
        int i14 = (int) (this.A0H / f11);
        int i15 = this.A0H;
        while (true) {
            if (i14 <= 16384 && i15 <= 16384) {
                break;
            }
            i14 /= 2;
            i15 /= 2;
        }
        A09(i11);
        int i16 = 0;
        while (true) {
            int i17 = this.A06;
            if (i16 >= i17 - 1) {
                A0A(i17 - 1);
                return;
            }
            while (true) {
                i12 = this.A04;
                if (A0M[1].charAt(13) != '1') {
                    throw new RuntimeException();
                }
                A0M[3] = "26TQ7N8S6PTfGLZ92";
                int i18 = (i12 + 1) * i14;
                i13 = this.A03;
                if (i18 > i13 * i15) {
                    this.A0B = A0G(this.A0B, this.A05, 1);
                    int i19 = 0;
                    while (true) {
                        int i21 = this.A0G;
                        String[] strArr = A0M;
                        if (strArr[7].charAt(8) == strArr[4].charAt(8)) {
                            A0M[2] = "aOt6eVUEyRCtQxkUrkKyixjvz9Bn1k7";
                            if (i19 >= i21) {
                                break;
                            }
                            this.A0B[(this.A05 * i21) + i19] = A05(this.A0C, (i21 * i16) + i19, i15, i14);
                            i19++;
                        } else {
                            A0M[3] = "VbKq7NM7PdmAUrole";
                            if (i19 >= i21) {
                                break;
                            }
                            this.A0B[(this.A05 * i21) + i19] = A05(this.A0C, (i21 * i16) + i19, i15, i14);
                            i19++;
                        }
                    }
                    this.A03++;
                    this.A05++;
                }
            }
            int i22 = i12 + 1;
            this.A04 = i22;
            if (i22 == i15) {
                String[] strArr2 = A0M;
                if (strArr2[5].length() != strArr2[0].length()) {
                    throw new RuntimeException();
                }
                A0M[6] = "dm69MZtNxJx8v5BsJDIKlnc92CG6PQ3Q";
                this.A04 = 0;
                AbstractC1351Ha.A04(i13 == i14);
                this.A03 = 0;
            }
            i16++;
        }
    }

    private void A09(int i11) {
        int i12 = this.A05 - i11;
        short[] sArrA0G = A0G(this.A0C, this.A06, i12);
        this.A0C = sArrA0G;
        short[] sArr = this.A0B;
        int i13 = this.A0G;
        System.arraycopy(sArr, i11 * i13, sArrA0G, this.A06 * i13, i13 * i12);
        this.A05 = i11;
        this.A06 += i12;
    }

    private void A0A(int i11) {
        if (i11 == 0) {
            return;
        }
        short[] sArr = this.A0C;
        int i12 = this.A0G;
        System.arraycopy(sArr, i11 * i12, sArr, 0, (this.A06 - i11) * i12);
        this.A06 -= i11;
    }

    private void A0B(int i11) {
        int i12 = this.A00 - i11;
        short[] sArr = this.A0A;
        int i13 = this.A0G;
        System.arraycopy(sArr, i11 * i13, sArr, 0, i13 * i12);
        this.A00 = i12;
    }

    public static void A0C(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
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

    private void A0D(short[] sArr, int i11, int i12) {
        short[] sArrA0G = A0G(this.A0B, this.A05, i12);
        this.A0B = sArrA0G;
        int i13 = this.A0G;
        System.arraycopy(sArr, i11 * i13, sArrA0G, this.A05 * i13, i13 * i12);
        this.A05 += i12;
    }

    private void A0E(short[] sArr, int i11, int i12) {
        int i13 = this.A0J / i12;
        int i14 = this.A0G;
        int i15 = i14 * i12;
        int i16 = i11 * i14;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                i18 += sArr[(i17 * i15) + i16 + i19];
            }
            this.A0L[i17] = (short) (i18 / i15);
        }
    }

    private boolean A0F(int i11, int i12) {
        return i11 != 0 && this.A08 != 0 && i12 <= i11 * 3 && i11 * 2 > this.A07 * 3;
    }

    private short[] A0G(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.A0G;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, i13 * (((i14 * 3) / 2) + i12));
    }

    public final int A0H() {
        return this.A05;
    }

    public final void A0I() {
        this.A00 = 0;
        this.A05 = 0;
        this.A06 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A09 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0J() {
        int i11;
        int i12 = this.A00;
        float f11 = this.A0F;
        float f12 = this.A0D;
        int i13 = this.A05 + ((int) ((((i12 / (f11 / f12)) + this.A06) / (this.A0E * f12)) + 0.5f));
        this.A0A = A0G(this.A0A, this.A00, (this.A0J * 2) + i12);
        int i14 = 0;
        while (true) {
            i11 = this.A0J;
            int i15 = this.A0G;
            if (i14 >= i11 * 2 * i15) {
                break;
            }
            this.A0A[(i15 * i12) + i14] = 0;
            i14++;
        }
        this.A00 += i11 * 2;
        A06();
        if (this.A05 > i13) {
            this.A05 = i13;
        }
        this.A00 = 0;
        this.A09 = 0;
        this.A06 = 0;
    }

    public final void A0K(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.A0G, this.A05);
        shortBuffer.put(this.A0B, 0, this.A0G * iMin);
        int i11 = this.A05 - iMin;
        this.A05 = i11;
        short[] sArr = this.A0B;
        int i12 = this.A0G;
        System.arraycopy(sArr, iMin * i12, sArr, 0, i11 * i12);
    }

    public final void A0L(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i11 = this.A0G;
        int i12 = iRemaining / i11;
        short[] sArrA0G = A0G(this.A0A, this.A00, i12);
        this.A0A = sArrA0G;
        shortBuffer.get(sArrA0G, this.A00 * this.A0G, ((i11 * i12) * 2) / 2);
        this.A00 += i12;
        A06();
    }
}
