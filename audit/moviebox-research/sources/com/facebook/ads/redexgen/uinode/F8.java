package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F8 {
    public static String[] A0I = {"AXNp2q2PpEahITHLh", "xQEpoEpGgC2eanPxpW7aZYHhG9yms2rq", "3j6TAof", "i8THqobYCLYXuqAnsJGXzeKTVyKCbEfb", "ggw9auSRsP4B09On0iatBfmdaYF861sQ", "10OfiNQ0BRtOqE95ZnYZi1qGxLNxD1sx", "iFzh6NRuyiOyJdjYiPViJ2RhowiTnlD0", "JJpEbWQFS8eJaCoVgzG8fIG9CRI9jzfg"};
    public int A00;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public Format A08;
    public int A01 = 1000;
    public int[] A0D = new int[1000];
    public long[] A0E = new long[1000];
    public long[] A0F = new long[1000];
    public int[] A0B = new int[1000];
    public int[] A0C = new int[1000];
    public C3[] A0H = new C3[1000];
    public Format[] A0G = new Format[1000];
    public long A06 = Long.MIN_VALUE;
    public long A07 = Long.MIN_VALUE;
    public boolean A09 = true;
    public boolean A0A = true;

    private int A00(int i11) {
        int i12 = this.A04 + i11;
        int i13 = this.A01;
        return i12 < i13 ? i12 : i12 - i13;
    }

    private int A01(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12 && this.A0F[i11] <= j11; i14++) {
            if (!z11 || (this.A0B[i11] & 1) != 0) {
                i13 = i14;
            }
            i11++;
            if (i11 == this.A01) {
                i11 = 0;
            }
        }
        return i13;
    }

    private long A02(int i11) {
        this.A06 = Math.max(this.A06, A03(i11));
        int i12 = this.A02 - i11;
        this.A02 = i12;
        this.A00 += i11;
        int i13 = this.A04 + i11;
        this.A04 = i13;
        int i14 = this.A01;
        if (i13 >= i14) {
            this.A04 = i13 - i14;
        }
        int i15 = this.A03 - i11;
        this.A03 = i15;
        if (i15 < 0) {
            this.A03 = 0;
        }
        if (i12 != 0) {
            return this.A0E[this.A04];
        }
        int i16 = this.A04;
        if (i16 != 0) {
            i14 = i16;
        }
        int i17 = i14 - 1;
        return this.A0E[i17] + ((long) this.A0C[i17]);
    }

    private long A03(int i11) {
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        long jMax = Long.MIN_VALUE;
        int iA00 = A00(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            jMax = Math.max(jMax, this.A0F[iA00]);
            if ((this.A0B[iA00] & 1) != 0) {
                break;
            }
            iA00--;
            if (iA00 == -1) {
                int i13 = this.A01;
                String[] strArr = A0I;
                if (strArr[6].charAt(24) == strArr[3].charAt(24)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[2] = "ogUh654";
                strArr2[5] = "2cGjVSXzBWiJJ6u2fOJU9D000d34dgjx";
                iA00 = i13 - 1;
            }
        }
        return jMax;
    }

    private final synchronized void A04(long j11) {
        this.A07 = Math.max(this.A07, j11);
    }

    public final int A05() {
        return this.A00 + this.A03;
    }

    public final int A06() {
        return this.A00 + this.A02;
    }

    public final synchronized int A07() {
        int i11;
        int i12 = this.A02;
        i11 = i12 - this.A03;
        this.A03 = i12;
        return i11;
    }

    public final synchronized int A08(long j11, boolean z11, boolean z12) {
        int iA00 = A00(this.A03);
        if (!A0I() || j11 < this.A0F[iA00] || (j11 > this.A07 && !z12)) {
            return -1;
        }
        int iA01 = A01(iA00, this.A02 - this.A03, j11, z11);
        if (iA01 == -1) {
            return -1;
        }
        this.A03 += iA01;
        return iA01;
    }

    public final synchronized int A09(C11789p c11789p, C1773Xr c1773Xr, boolean z11, boolean z12, Format format, F7 f11) {
        if (!A0I()) {
            if (z12) {
                c1773Xr.A02(4);
                return -4;
            }
            Format format2 = this.A08;
            if (format2 == null || (!z11 && format2 == format)) {
                return -3;
            }
            c11789p.A00 = format2;
            return -5;
        }
        int iA00 = A00(this.A03);
        if (z11 || this.A0G[iA00] != format) {
            c11789p.A00 = this.A0G[iA00];
            return -5;
        }
        if (c1773Xr.A0B()) {
            return -3;
        }
        c1773Xr.A00 = this.A0F[iA00];
        c1773Xr.A02(this.A0B[iA00]);
        f11.A00 = this.A0C[iA00];
        f11.A01 = this.A0E[iA00];
        f11.A02 = this.A0H[iA00];
        this.A03++;
        return -4;
    }

    public final synchronized long A0A() {
        int i11 = this.A02;
        if (i11 == 0) {
            return -1L;
        }
        return A02(i11);
    }

    public final synchronized long A0B() {
        return this.A07;
    }

    public final long A0C(int i11) {
        int iA06 = A06() - i11;
        AbstractC1351Ha.A03(iA06 >= 0 && iA06 <= this.A02 - this.A03);
        int i12 = this.A02 - iA06;
        this.A02 = i12;
        this.A07 = Math.max(this.A06, A03(i12));
        int i13 = this.A02;
        if (i13 == 0) {
            return 0L;
        }
        int iA00 = A00(i13 - 1);
        return this.A0E[iA00] + ((long) this.A0C[iA00]);
    }

    public final synchronized long A0D(long j11, boolean z11, boolean z12) {
        int i11;
        int i12 = this.A02;
        if (i12 != 0) {
            long[] jArr = this.A0F;
            int i13 = this.A04;
            if (j11 >= jArr[i13]) {
                if (z12 && (i11 = this.A03) != i12) {
                    i12 = i11 + 1;
                }
                int iA01 = A01(i13, i12, j11, z11);
                if (iA01 == -1) {
                    return -1L;
                }
                return A02(iA01);
            }
        }
        return -1L;
    }

    public final synchronized Format A0E() {
        return this.A09 ? null : this.A08;
    }

    public final synchronized void A0F() {
        this.A03 = 0;
    }

    public final synchronized void A0G(long j11, int i11, long j12, int i12, C3 c11) {
        if (this.A0A) {
            if ((i11 & 1) == 0) {
                return;
            } else {
                this.A0A = false;
            }
        }
        AbstractC1351Ha.A04(!this.A09);
        A04(j11);
        int iA00 = A00(this.A02);
        this.A0F[iA00] = j11;
        long[] jArr = this.A0E;
        jArr[iA00] = j12;
        this.A0C[iA00] = i12;
        this.A0B[iA00] = i11;
        this.A0H[iA00] = c11;
        this.A0G[iA00] = this.A08;
        this.A0D[iA00] = this.A05;
        int i13 = this.A02 + 1;
        this.A02 = i13;
        int i14 = this.A01;
        if (i13 == i14) {
            int i15 = i14 + 1000;
            int[] iArr = new int[i15];
            long[] jArr2 = new long[i15];
            long[] jArr3 = new long[i15];
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            C3[] c3Arr = new C3[i15];
            Format[] formatArr = new Format[i15];
            int i16 = this.A04;
            int i17 = i14 - i16;
            System.arraycopy(jArr, i16, jArr2, 0, i17);
            System.arraycopy(this.A0F, this.A04, jArr3, 0, i17);
            System.arraycopy(this.A0B, this.A04, iArr2, 0, i17);
            System.arraycopy(this.A0C, this.A04, iArr3, 0, i17);
            System.arraycopy(this.A0H, this.A04, c3Arr, 0, i17);
            System.arraycopy(this.A0G, this.A04, formatArr, 0, i17);
            System.arraycopy(this.A0D, this.A04, iArr, 0, i17);
            int i18 = this.A04;
            System.arraycopy(this.A0E, 0, jArr2, i17, i18);
            System.arraycopy(this.A0F, 0, jArr3, i17, i18);
            System.arraycopy(this.A0B, 0, iArr2, i17, i18);
            System.arraycopy(this.A0C, 0, iArr3, i17, i18);
            System.arraycopy(this.A0H, 0, c3Arr, i17, i18);
            System.arraycopy(this.A0G, 0, formatArr, i17, i18);
            System.arraycopy(this.A0D, 0, iArr, i17, i18);
            this.A0E = jArr2;
            this.A0F = jArr3;
            this.A0B = iArr2;
            this.A0C = iArr3;
            this.A0H = c3Arr;
            this.A0G = formatArr;
            this.A0D = iArr;
            this.A04 = 0;
            this.A02 = this.A01;
            this.A01 = i15;
        }
    }

    public final void A0H(boolean z11) {
        this.A02 = 0;
        this.A00 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A0A = true;
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        if (z11) {
            this.A08 = null;
            this.A09 = true;
        }
    }

    public final synchronized boolean A0I() {
        return this.A03 != this.A02;
    }

    public final synchronized boolean A0J(long j11) {
        if (this.A02 == 0) {
            return j11 > this.A06;
        }
        if (Math.max(this.A06, A03(this.A03)) >= j11) {
            return false;
        }
        int i11 = this.A02;
        int iA00 = A00(i11 - 1);
        while (i11 > this.A03 && this.A0F[iA00] >= j11) {
            i11--;
            iA00--;
            if (iA00 == -1) {
                iA00 = this.A01 - 1;
            }
        }
        A0C(this.A00 + i11);
        return true;
    }

    public final synchronized boolean A0K(Format format) {
        try {
            if (format == null) {
                this.A09 = true;
                return false;
            }
            this.A09 = false;
            if (IF.A0g(format, this.A08)) {
                return false;
            }
            this.A08 = format;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
