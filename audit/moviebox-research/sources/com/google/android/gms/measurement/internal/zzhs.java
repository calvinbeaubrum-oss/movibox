package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhs implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzai zze;
    final /* synthetic */ zzhx zzf;

    public zzhs(zzhx zzhxVar, zzai zzaiVar, int i11, long j11, boolean z11, zzai zzaiVar2) {
        this.zzf = zzhxVar;
        this.zza = zzaiVar;
        this.zzb = i11;
        this.zzc = j11;
        this.zzd = z11;
        this.zze = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zzV(this.zza);
        zzhx.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzpd.zzc();
        if (this.zzf.zzt.zzf().zzs(null, zzdu.zzam)) {
            zzhx.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
