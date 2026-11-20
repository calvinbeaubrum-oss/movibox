package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgmn {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long jZzb = zzb(bArr, 0, 0);
        long jZzb2 = zzb(bArr, 3, 2) & 67108611;
        long jZzb3 = zzb(bArr, 6, 4) & 67092735;
        long jZzb4 = zzb(bArr, 9, 6) & 66076671;
        long jZzb5 = zzb(bArr, 12, 8) & 1048575;
        int i11 = 17;
        byte[] bArr3 = new byte[17];
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        int i12 = 0;
        while (true) {
            int length = bArr2.length;
            if (i12 >= length) {
                long j16 = j11 + (j12 >> 26);
                long j17 = j16 & 67108863;
                long j18 = j13 + (j16 >> 26);
                long j19 = j18 & 67108863;
                long j21 = j14 + (j18 >> 26);
                long j22 = j21 & 67108863;
                long j23 = j15 + ((j21 >> 26) * 5);
                long j24 = j23 & 67108863;
                long j25 = j24 + 5;
                long j26 = (j12 & 67108863) + (j23 >> 26);
                long j27 = j26 + (j25 >> 26);
                long j28 = (j27 >> 26) + j17;
                long j29 = j19 + (j28 >> 26);
                long j31 = (j22 + (j29 >> 26)) - 67108864;
                long j32 = j31 >> 63;
                long j33 = ~j32;
                long j34 = (j26 & j32) | (j27 & 67108863 & j33);
                long j35 = (j17 & j32) | (j28 & 67108863 & j33);
                long j36 = (j19 & j32) | (j29 & 67108863 & j33);
                long j37 = (j22 & j32) | (j31 & j33);
                long jZzc = (((j32 & j24) | (j25 & 67108863 & j33) | (j34 << 26)) & 4294967295L) + zzc(bArr, 16);
                long jZzc2 = (((j34 >> 6) | (j35 << 20)) & 4294967295L) + zzc(bArr, 20);
                long jZzc3 = (((j35 >> 12) | (j36 << 14)) & 4294967295L) + zzc(bArr, 24);
                long jZzc4 = (((j36 >> 18) | (j37 << 8)) & 4294967295L) + zzc(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, jZzc & 4294967295L, 0);
                long j38 = jZzc2 + (jZzc >> 32);
                zzd(bArr4, j38 & 4294967295L, 4);
                long j39 = jZzc3 + (j38 >> 32);
                zzd(bArr4, j39 & 4294967295L, 8);
                zzd(bArr4, (jZzc4 + (j39 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
            int iMin = Math.min(16, length - i12);
            System.arraycopy(bArr2, i12, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, i11, (byte) 0);
            }
            long j40 = jZzb5 * 5;
            long j41 = jZzb4 * 5;
            long j42 = jZzb3 * 5;
            long jZzb6 = j15 + zzb(bArr3, 0, 0);
            long jZzb7 = j12 + zzb(bArr3, 3, 2);
            long jZzb8 = j11 + zzb(bArr3, 6, 4);
            long jZzb9 = j13 + zzb(bArr3, 9, 6);
            long jZzb10 = j14 + (zzb(bArr3, 12, 8) | ((long) (bArr3[16] << Ascii.CAN)));
            long j43 = jZzb7 * jZzb;
            long j44 = jZzb7 * jZzb2;
            long j45 = jZzb7 * jZzb3;
            long j46 = jZzb9 * jZzb;
            long j47 = jZzb7 * jZzb4;
            long j48 = jZzb10 * jZzb;
            long j49 = (jZzb6 * jZzb) + (jZzb7 * j40) + (jZzb8 * j41) + (jZzb9 * j42) + (jZzb2 * 5 * jZzb10);
            long j50 = (jZzb6 * jZzb2) + j43 + (jZzb8 * j40) + (jZzb9 * j41) + (j42 * jZzb10) + (j49 >> 26);
            long j51 = (jZzb6 * jZzb3) + j44 + (jZzb8 * jZzb) + (jZzb9 * j40) + (j41 * jZzb10) + (j50 >> 26);
            long j52 = (jZzb6 * jZzb4) + j45 + (jZzb8 * jZzb2) + j46 + (jZzb10 * j40) + (j51 >> 26);
            long j53 = (jZzb6 * jZzb5) + j47 + (jZzb8 * jZzb3) + (jZzb9 * jZzb2) + j48 + (j52 >> 26);
            long j54 = (j49 & 67108863) + ((j53 >> 26) * 5);
            j12 = (j50 & 67108863) + (j54 >> 26);
            i12 += 16;
            j11 = j51 & 67108863;
            j13 = j52 & 67108863;
            j14 = j53 & 67108863;
            i11 = 17;
            j15 = j54 & 67108863;
        }
    }

    private static long zzb(byte[] bArr, int i11, int i12) {
        return (zzc(bArr, i11) >> i12) & 67108863;
    }

    private static long zzc(byte[] bArr, int i11) {
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        int i14 = bArr[i11 + 2] & 255;
        return ((long) (((bArr[i11 + 3] & 255) << 24) | (i13 << 8) | i12 | (i14 << 16))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j11, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i11 + i12] = (byte) (255 & j11);
            j11 >>= 8;
        }
    }
}
