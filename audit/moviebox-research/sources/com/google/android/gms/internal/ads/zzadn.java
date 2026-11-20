package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadn implements zzadu {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzadn(long[] jArr, long[] jArr2, long j11) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzek.zzd(length == length2);
        boolean z11 = length2 > 0;
        this.zzd = z11;
        if (!z11 || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i11 = length2 + 1;
            long[] jArr3 = new long[i11];
            this.zza = jArr3;
            long[] jArr4 = new long[i11];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.zzc = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        if (!this.zzd) {
            zzadv zzadvVar = zzadv.zza;
            return new zzads(zzadvVar, zzadvVar);
        }
        int iZzc = zzfy.zzc(this.zzb, j11, true, true);
        zzadv zzadvVar2 = new zzadv(this.zzb[iZzc], this.zza[iZzc]);
        if (zzadvVar2.zzb != j11) {
            long[] jArr = this.zzb;
            if (iZzc != jArr.length - 1) {
                int i11 = iZzc + 1;
                return new zzads(zzadvVar2, new zzadv(jArr[i11], this.zza[i11]));
            }
        }
        return new zzads(zzadvVar2, zzadvVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return this.zzd;
    }
}
