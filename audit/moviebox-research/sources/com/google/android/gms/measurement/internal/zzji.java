package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzji implements Runnable {
    final /* synthetic */ zzdx zza;
    final /* synthetic */ zzjl zzb;

    public zzji(zzjl zzjlVar, zzdx zzdxVar) {
        this.zzb = zzjlVar;
        this.zza = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            try {
                this.zzb.zzb = false;
                if (!this.zzb.zza.zzL()) {
                    this.zzb.zza.zzt.zzay().zzc().zza("Connected to remote service");
                    this.zzb.zza.zzJ(this.zza);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
