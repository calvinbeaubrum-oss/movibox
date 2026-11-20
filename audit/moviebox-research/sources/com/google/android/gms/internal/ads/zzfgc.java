package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfgc implements zzeqt {
    final /* synthetic */ zzfgd zza;

    public zzfgc(zzfgd zzfgdVar) {
        this.zza = zzfgdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            try {
                this.zza.zzi = (zzdso) obj;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdq)).booleanValue()) {
                    ((zzdso) obj).zzd().zza = this.zza.zzd;
                }
                this.zza.zzi.zzj();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
