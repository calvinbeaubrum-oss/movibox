package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaca implements zzadu {
    private final zzacd zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzaca(zzacd zzacdVar, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.zza = zzacdVar;
        this.zzb = j11;
        this.zzc = j13;
        this.zzd = j14;
        this.zze = j15;
        this.zzf = j16;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzb;
    }

    public final long zzf(long j11) {
        return this.zza.zza(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        zzadv zzadvVar = new zzadv(j11, zzacc.zzf(this.zza.zza(j11), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
