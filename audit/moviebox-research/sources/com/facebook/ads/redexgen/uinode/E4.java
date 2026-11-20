package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E4 implements XV {
    public static byte[] A05;
    public static String[] A06 = {"ilqNaxLa84KwPxLclQkuXaDAjXKjVBay", "YYRGnxFlW9XodSzMr5d0AgWnEUGN8SAb", "TFjL0s25LaCBEteV0vZTEC31LOIwZtzx", "GUmZTVO9tTTKl3Mpcsedxo5lbewk1Lj3", "rxyeYW6RMQKKTnfalukPqNZ2KBfsB6S5", "mDRU4t7MoPNm7z5QI5KjgmazMAxk28NE", "eki8tF0EBXj6l5GM9f5RfEnwS82fHKRK", "1REkWmsZMDj0bgzORsQu3VEtsLn99tZ6"};
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long[] A04;

    static {
        A03();
    }

    public E4(long j11, int i11, long j12) {
        this(j11, i11, j12, -1L, null);
    }

    public E4(long j11, int i11, long j12, long j13, long[] jArr) {
        this.A02 = j11;
        this.A00 = i11;
        this.A03 = j12;
        this.A01 = j13;
        this.A04 = jArr;
    }

    private long A00(int i11) {
        return (this.A03 * ((long) i11)) / 100;
    }

    public static E4 A01(long j11, long j12, By by, C1376Hz c1376Hz) {
        int iA0H;
        int i11 = by.A04;
        int i12 = by.A03;
        int iA08 = c1376Hz.A08();
        if ((iA08 & 1) != 1 || (iA0H = c1376Hz.A0H()) == 0) {
            return null;
        }
        long jA0F = IF.A0F(iA0H, ((long) i11) * 1000000, i12);
        if ((iA08 & 6) != 6) {
            return new E4(j12, by.A02, jA0F);
        }
        long jA0H = c1376Hz.A0H();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = c1376Hz.A0E();
        }
        if (j11 != -1 && j11 != j12 + jA0H) {
            Log.w(A02(27, 10, 25), A02(2, 25, 119) + j11 + A02(0, 2, 77) + (j12 + jA0H));
        }
        return new E4(j12, by.A02, jA0F, jA0H, jArr);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-24, -36, 62, 47, 52, 45, 6, 74, 71, 90, 71, 6, 89, 79, 96, 75, 6, 83, 79, 89, 83, 71, 90, 73, 78, 32, 6, -32, -15, -10, -17, -37, -19, -19, -13, -19, -6};
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        double d11;
        if (!A9I()) {
            return new C0(new C2(0L, this.A02 + ((long) this.A00)));
        }
        long jA0E = IF.A0E(j11, 0L, this.A03);
        double d12 = (jA0E * 100.0d) / this.A03;
        if (d12 <= 0.0d) {
            d11 = 0.0d;
        } else if (d12 >= 100.0d) {
            d11 = 256.0d;
        } else {
            int i11 = (int) d12;
            long[] jArr = this.A04;
            double d13 = jArr[i11];
            double d14 = i11 == 99 ? 256.0d : jArr[i11 + 1];
            double d15 = i11;
            String[] strArr = A06;
            if (strArr[1].charAt(15) != strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[5] = "OMtgh7AGIO6dejZGwnLWpymQ4IFINQQk";
            strArr2[2] = "IsjlGA9bpSadN6h09kE1zH4HNrdroVjr";
            d11 = ((d14 - d13) * (d12 - d15)) + d13;
        }
        return new C0(new C2(jA0E, this.A02 + IF.A0E(Math.round((d11 / 256.0d) * this.A01), this.A00, this.A01 - 1)));
    }

    @Override // com.facebook.ads.redexgen.uinode.XV
    public final long A88(long j11) {
        long j12 = j11 - this.A02;
        if (!A9I()) {
            return 0L;
        }
        int i11 = this.A00;
        String[] strArr = A06;
        if (strArr[5].charAt(8) == strArr[2].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[5] = "W8nk4dNFk5UYs2ixe7nvUw2jVo0XpVlf";
        strArr2[2] = "94Ku6bJ3HPlMD7WZMvisRyq3A9jYmrd2";
        if (j12 <= i11) {
            return 0L;
        }
        double d11 = (j12 * 256.0d) / this.A01;
        int iA0B = IF.A0B(this.A04, (long) d11, true, true);
        long jA00 = A00(iA0B);
        long j13 = this.A04[iA0B];
        long jA01 = A00(iA0B + 1);
        long j14 = iA0B == 99 ? 256L : this.A04[iA0B + 1];
        return Math.round((jA01 - jA00) * (j13 == j14 ? 0.0d : (d11 - j13) / (j14 - j13))) + jA00;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return this.A04 != null;
    }
}
