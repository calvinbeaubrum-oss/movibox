package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadf implements zzadu {
    private final zzadh zza;
    private final long zzb;

    public zzadf(zzadh zzadhVar, long j11) {
        this.zza = zzadhVar;
        this.zzb = j11;
    }

    private final zzadv zzb(long j11, long j12) {
        return new zzadv((j11 * 1000000) / ((long) this.zza.zze), this.zzb + j12);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        zzek.zzb(this.zza.zzk);
        zzadh zzadhVar = this.zza;
        zzadg zzadgVar = zzadhVar.zzk;
        long[] jArr = zzadgVar.zza;
        long[] jArr2 = zzadgVar.zzb;
        int iZzc = zzfy.zzc(jArr, zzadhVar.zzb(j11), true, false);
        zzadv zzadvVarZzb = zzb(iZzc == -1 ? 0L : jArr[iZzc], iZzc != -1 ? jArr2[iZzc] : 0L);
        if (zzadvVarZzb.zzb == j11 || iZzc == jArr.length - 1) {
            return new zzads(zzadvVarZzb, zzadvVarZzb);
        }
        int i11 = iZzc + 1;
        return new zzads(zzadvVarZzb, zzb(jArr[i11], jArr2[i11]));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
