package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaci implements zzadu {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzaci(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length <= 0) {
            this.zzf = 0L;
        } else {
            int i11 = length - 1;
            this.zzf = jArr2[i11] + jArr3[i11];
        }
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        return "ChunkIndex(length=" + this.zza + ", sizes=" + Arrays.toString(this.zzb) + ", offsets=" + Arrays.toString(jArr3) + ", timeUs=" + Arrays.toString(jArr2) + ", durationsUs=" + Arrays.toString(jArr) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        long[] jArr = this.zze;
        int iZzc = zzfy.zzc(jArr, j11, true, true);
        zzadv zzadvVar = new zzadv(jArr[iZzc], this.zzc[iZzc]);
        if (zzadvVar.zzb >= j11 || iZzc == this.zza - 1) {
            return new zzads(zzadvVar, zzadvVar);
        }
        int i11 = iZzc + 1;
        return new zzads(zzadvVar, new zzadv(this.zze[i11], this.zzc[i11]));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
