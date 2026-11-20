package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzha implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhx zzb;

    public zzha(zzhx zzhxVar, long j11) {
        this.zzb = zzhxVar;
        this.zza = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzt.zzm().zzf.zzb(this.zza);
        this.zzb.zzt.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
