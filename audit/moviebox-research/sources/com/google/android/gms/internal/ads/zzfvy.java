package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfvy extends zzfvu {
    final /* synthetic */ zzfwe zza;

    public zzfvy(zzfwe zzfweVar) {
        this.zza = zzfweVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zza() {
        synchronized (this.zza.zzg) {
            try {
                if (this.zza.zzl.get() > 0 && this.zza.zzl.decrementAndGet() > 0) {
                    this.zza.zzc.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                zzfwe zzfweVar = this.zza;
                if (zzfweVar.zzn != null) {
                    zzfweVar.zzc.zzc("Unbind from service.", new Object[0]);
                    zzfwe zzfweVar2 = this.zza;
                    zzfweVar2.zzb.unbindService(zzfweVar2.zzm);
                    this.zza.zzh = false;
                    this.zza.zzn = null;
                    this.zza.zzm = null;
                }
                this.zza.zzw();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
