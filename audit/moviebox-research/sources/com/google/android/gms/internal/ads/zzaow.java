package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaow implements zzadu {
    private final zzaot zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaow(zzaot zzaotVar, int i11, long j11, long j12) {
        this.zza = zzaotVar;
        this.zzb = i11;
        this.zzc = j11;
        long j13 = (j12 - j11) / ((long) zzaotVar.zzd);
        this.zzd = j13;
        this.zze = zzb(j13);
    }

    private final long zzb(long j11) {
        return zzfy.zzs(j11 * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.FLOOR);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        long jMax = Math.max(0L, Math.min((((long) this.zza.zzc) * j11) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long j12 = ((long) this.zza.zzd) * jMax;
        long jZzb = zzb(jMax);
        zzadv zzadvVar = new zzadv(jZzb, this.zzc + j12);
        if (jZzb >= j11 || jMax == this.zzd - 1) {
            return new zzads(zzadvVar, zzadvVar);
        }
        long j13 = jMax + 1;
        return new zzads(zzadvVar, new zzadv(zzb(j13), this.zzc + (j13 * ((long) this.zza.zzd))));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
