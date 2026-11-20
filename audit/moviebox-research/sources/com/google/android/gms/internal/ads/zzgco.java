package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgco {
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (((r6 & 1) & (r7 != java.math.RoundingMode.HALF_EVEN ? 0 : 1)) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        if (r0 > 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r5 > 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r5 < 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(int i11, int i12, RoundingMode roundingMode) {
        roundingMode.getClass();
        int i13 = i11 / 8;
        int i14 = i11 - (i13 * 8);
        if (i14 != 0) {
            int i15 = ((i11 ^ 8) >> 31) | 1;
            switch (zzgcn.zza[roundingMode.ordinal()]) {
                case 1:
                    zzgcr.zzb(false);
                case 2:
                    return i13;
                case 3:
                    break;
                case 4:
                    return i13 + i15;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    int iAbs = Math.abs(i14);
                    int iAbs2 = iAbs - (Math.abs(8) - iAbs);
                    if (iAbs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            break;
                        }
                        return i13 + i15;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return i13;
    }
}
