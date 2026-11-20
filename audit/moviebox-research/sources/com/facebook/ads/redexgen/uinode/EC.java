package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EC implements XV {
    public static byte[] A03;
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    static {
        A02();
    }

    public EC(long[] jArr, long[] jArr2, long j11) {
        this.A02 = jArr;
        this.A01 = jArr2;
        this.A00 = j11;
    }

    public static EC A00(long j11, long j12, By by, C1376Hz c1376Hz) {
        int iA0E;
        long j13 = j12;
        c1376Hz.A0Z(10);
        int iA08 = c1376Hz.A08();
        if (iA08 <= 0) {
            return null;
        }
        int i11 = by.A03;
        long jA0F = IF.A0F(iA08, ((long) (i11 >= 32000 ? 1152 : 576)) * 1000000, i11);
        int iA0I = c1376Hz.A0I();
        int iA0I2 = c1376Hz.A0I();
        int iA0I3 = c1376Hz.A0I();
        c1376Hz.A0Z(2);
        long j14 = j13 + ((long) by.A02);
        long[] jArr = new long[iA0I];
        long[] jArr2 = new long[iA0I];
        for (int i12 = 0; i12 < iA0I; i12++) {
            jArr[i12] = (((long) i12) * jA0F) / ((long) iA0I);
            jArr2[i12] = Math.max(j13, j14);
            switch (iA0I3) {
                case 1:
                    iA0E = c1376Hz.A0E();
                    break;
                case 2:
                    iA0E = c1376Hz.A0I();
                    break;
                case 3:
                    iA0E = c1376Hz.A0G();
                    break;
                case 4:
                    iA0E = c1376Hz.A0H();
                    break;
                default:
                    return null;
            }
            j13 += (long) (iA0E * iA0I2);
        }
        if (j11 != -1 && j11 != j13) {
            Log.w(A01(27, 10, 87), A01(2, 25, 74) + j11 + A01(0, 2, 106) + j13);
        }
        return new EC(jArr, jArr2, jA0F);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 75, Ascii.GS, 9, Ascii.EM, 2, 107, 47, 42, Utf8.REPLACEMENT_BYTE, 42, 107, 56, 34, 49, 46, 107, 38, 34, 56, 38, 42, Utf8.REPLACEMENT_BYTE, 40, 35, 113, 107, 0, 52, 36, Utf8.REPLACEMENT_BYTE, 5, 51, 51, 61, 51, 36};
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final long A6r() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final C0 A7t(long j11) {
        int iA0B = IF.A0B(this.A02, j11, true, true);
        C2 c11 = new C2(this.A02[iA0B], this.A01[iA0B]);
        return (c11.A01 >= j11 || iA0B == this.A02.length - 1) ? new C0(c11) : new C0(c11, new C2(this.A02[iA0B + 1], this.A01[iA0B + 1]));
    }

    @Override // com.facebook.ads.redexgen.uinode.XV
    public final long A88(long j11) {
        return this.A02[IF.A0B(this.A01, j11, true, true)];
    }

    @Override // com.facebook.ads.redexgen.uinode.C1
    public final boolean A9I() {
        return true;
    }
}
