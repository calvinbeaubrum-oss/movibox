package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaom {
    public static int zza(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && bArr[i11] != 71) {
            i11++;
        }
        return i11;
    }

    public static long zzb(zzfp zzfpVar, int i11, int i12) {
        zzfpVar.zzK(i11);
        if (zzfpVar.zzb() < 5) {
            return C.TIME_UNSET;
        }
        int iZzg = zzfpVar.zzg();
        if ((8388608 & iZzg) != 0 || ((iZzg >> 8) & 8191) != i12 || (iZzg & 32) == 0 || zzfpVar.zzm() < 7 || zzfpVar.zzb() < 7 || (zzfpVar.zzm() & 16) != 16) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[6];
        zzfpVar.zzG(bArr, 0, 6);
        long j11 = bArr[0];
        long j12 = bArr[1];
        long j13 = bArr[2];
        long j14 = bArr[3] & 255;
        return ((j11 & 255) << 25) | ((j12 & 255) << 17) | ((j13 & 255) << 9) | (j14 + j14) | ((((long) bArr[4]) & 255) >> 7);
    }
}
