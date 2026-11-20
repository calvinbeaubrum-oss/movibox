package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfgh implements zzeqt {
    final /* synthetic */ zzfgj zza;

    public zzfgh(zzfgj zzfgjVar) {
        this.zza = zzfgjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            try {
                this.zza.zzd = (zzdso) obj;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdq)).booleanValue()) {
                    ((zzdso) obj).zzd().zza = this.zza.zzc;
                }
                this.zza.zzd.zzj();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
