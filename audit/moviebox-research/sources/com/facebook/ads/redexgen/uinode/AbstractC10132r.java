package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10132r {
    public static final int[] A00 = new int[0];
    public static final long[] A01 = new long[0];
    public static final Object[] A02 = new Object[0];

    public static int A00(int i11) {
        return A01(i11 * 8) / 8;
    }

    public static int A01(int i11) {
        for (int i12 = 4; i12 < 32; i12++) {
            if (i11 <= (1 << i12) - 12) {
                return (1 << i12) - 12;
            }
        }
        return i11;
    }

    public static int A02(int[] iArr, int i11, int i12) {
        int i13 = 0;
        int i14 = i11 - 1;
        while (i13 <= i14) {
            int i15 = (i13 + i14) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i12) {
                i13 = i15 + 1;
            } else {
                if (i16 <= i12) {
                    return i15;
                }
                i14 = i15 - 1;
            }
        }
        return i13 ^ (-1);
    }

    public static int A03(long[] jArr, int i11, long j11) {
        int i12 = 0;
        int i13 = i11 - 1;
        while (i12 <= i13) {
            int i14 = (i12 + i13) >>> 1;
            long j12 = jArr[i14];
            if (j12 < j11) {
                i12 = i14 + 1;
            } else {
                if (j12 <= j11) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return i12 ^ (-1);
    }

    public static boolean A04(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
