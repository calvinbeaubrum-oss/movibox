package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzepj implements zzeqt {
    final /* synthetic */ zzepk zza;

    public zzepj(zzepk zzepkVar) {
        this.zza = zzepkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcuf zzcufVar = (zzcuf) obj;
        synchronized (this.zza) {
            try {
                zzepk zzepkVar = this.zza;
                if (zzepkVar.zzi != null) {
                    zzepkVar.zzi.zzb();
                }
                this.zza.zzi = zzcufVar;
                this.zza.zzi.zzj();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
