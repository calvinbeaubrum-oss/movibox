package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgcq {
    private static final long[][] zza = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r8 > 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (r8 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long zza(long j11, long j12, RoundingMode roundingMode) {
        roundingMode.getClass();
        long j13 = j11 / j12;
        long j14 = j11 - (j12 * j13);
        if (j14 != 0) {
            int i11 = ((int) ((j11 ^ j12) >> 63)) | 1;
            switch (zzgcp.zza[roundingMode.ordinal()]) {
                case 1:
                    zzgcr.zzb(false);
                case 2:
                case 3:
                    break;
                case 4:
                    return j13 + ((long) i11);
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    long jAbs = Math.abs(j14);
                    long jAbs2 = jAbs - (Math.abs(j12) - jAbs);
                    return jAbs2 != 0 ? j13 : j13;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static long zzb(long j11, long j12) {
        zzgcr.zza("a", j11);
        zzgcr.zza(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, j12);
        if (j11 == 0) {
            return j12;
        }
        if (j12 == 0) {
            return j11;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j11);
        long jNumberOfTrailingZeros = j11 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j12);
        long j13 = j12 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j13) {
            long j14 = jNumberOfTrailingZeros - j13;
            long j15 = (j14 >> 63) & j14;
            long j16 = (j14 - j15) - j15;
            jNumberOfTrailingZeros = j16 >> Long.numberOfTrailingZeros(j16);
            j13 += j15;
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static long zzc(long j11, long j12) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j12) + Long.numberOfLeadingZeros(~j12);
        if (iNumberOfLeadingZeros > 65) {
            return j11 * j12;
        }
        long j13 = ((j11 ^ j12) >>> 63) + Long.MAX_VALUE;
        if ((iNumberOfLeadingZeros < 64) || ((j12 == Long.MIN_VALUE) & (j11 < 0))) {
            return j13;
        }
        long j14 = j11 * j12;
        return (j11 == 0 || j14 / j11 == j12) ? j14 : j13;
    }
}
