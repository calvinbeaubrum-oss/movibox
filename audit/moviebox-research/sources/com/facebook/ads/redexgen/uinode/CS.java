package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class CS {
    public static CR A00(int i11, long[] jArr, int[] iArr, long j11) {
        int i12 = 8192 / i11;
        int iA04 = 0;
        for (int i13 : iArr) {
            iA04 += IF.A04(i13, i12);
        }
        long[] jArr2 = new long[iA04];
        int[] iArr2 = new int[iA04];
        int iMax = 0;
        long[] jArr3 = new long[iA04];
        int[] iArr3 = new int[iA04];
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int i17 = iArr[i16];
            long j12 = jArr[i16];
            while (i17 > 0) {
                int iMin = Math.min(i12, i17);
                jArr2[i15] = j12;
                iArr2[i15] = i11 * iMin;
                iMax = Math.max(iMax, iArr2[i15]);
                jArr3[i15] = ((long) i14) * j11;
                iArr3[i15] = 1;
                j12 += (long) iArr2[i15];
                i14 += iMin;
                i17 -= iMin;
                i15++;
            }
        }
        return new CR(jArr2, iArr2, iMax, jArr3, iArr3, j11 * ((long) i14));
    }
}
