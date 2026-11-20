package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzih implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ zzie zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzim zze;

    public zzih(zzim zzimVar, zzie zzieVar, zzie zzieVar2, long j11, boolean z11) {
        this.zze = zzimVar;
        this.zza = zzieVar;
        this.zzb = zzieVar2;
        this.zzc = j11;
        this.zzd = z11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
