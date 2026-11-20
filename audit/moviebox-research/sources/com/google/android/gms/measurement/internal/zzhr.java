package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhr implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzhx zzg;

    public zzhr(zzhx zzhxVar, zzai zzaiVar, long j11, int i11, long j12, boolean z11, zzai zzaiVar2) {
        this.zzg = zzhxVar;
        this.zza = zzaiVar;
        this.zzb = j11;
        this.zzc = i11;
        this.zzd = j12;
        this.zze = z11;
        this.zzf = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzhx.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpd.zzc();
        if (this.zzg.zzt.zzf().zzs(null, zzdu.zzam)) {
            zzhx.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
