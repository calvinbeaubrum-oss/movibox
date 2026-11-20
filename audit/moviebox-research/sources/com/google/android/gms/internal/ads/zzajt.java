package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajt implements zzajz {
    private final zzadh zza;
    private final zzadg zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzajt(zzadh zzadhVar, zzadg zzadgVar) {
        this.zza = zzadhVar;
        this.zzb = zzadgVar;
    }

    public final void zza(long j11) {
        this.zzc = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final long zzd(zzacv zzacvVar) {
        long j11 = this.zzd;
        if (j11 < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j11 + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final zzadu zze() {
        zzek.zzf(this.zzc != -1);
        return new zzadf(this.zza, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzg(long j11) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzfy.zzc(jArr, j11, true, true)];
    }
}
