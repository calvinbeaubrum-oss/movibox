package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaid implements zzaii {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzaid(long[] jArr, long[] jArr2, long j11) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j11 == C.TIME_UNSET ? zzfy.zzq(jArr2[jArr2.length - 1]) : j11;
    }

    public static zzaid zzb(long j11, zzagv zzagvVar, long j12) {
        int length = zzagvVar.zzd.length;
        int i11 = length + 1;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        jArr[0] = j11;
        long j13 = 0;
        jArr2[0] = 0;
        for (int i12 = 1; i12 <= length; i12++) {
            int i13 = i12 - 1;
            j11 += (long) (zzagvVar.zzb + zzagvVar.zzd[i13]);
            j13 += (long) (zzagvVar.zzc + zzagvVar.zze[i13]);
            jArr[i12] = j11;
            jArr2[i12] = j13;
        }
        return new zzaid(jArr, jArr2, j12);
    }

    private static Pair zze(long j11, long[] jArr, long[] jArr2) {
        int iZzc = zzfy.zzc(jArr, j11, true, true);
        long j12 = jArr[iZzc];
        long j13 = jArr2[iZzc];
        int i11 = iZzc + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        long j14 = jArr[i11];
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) ((j14 == j12 ? 0.0d : (j11 - j12) / (j14 - j12)) * (jArr2[i11] - j13))) + j13));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j11) {
        return zzfy.zzq(((Long) zze(j11, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        Pair pairZze = zze(zzfy.zzt(Math.max(0L, Math.min(j11, this.zzc))), this.zzb, this.zza);
        zzadv zzadvVar = new zzadv(zzfy.zzq(((Long) pairZze.first).longValue()), ((Long) pairZze.second).longValue());
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
