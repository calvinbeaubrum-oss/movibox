package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeql implements zzeqt {
    final /* synthetic */ zzeqm zza;

    public zzeql(zzeqm zzeqmVar) {
        this.zza = zzeqmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdjn zzdjnVar = (zzdjn) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdjnVar;
            this.zza.zzj.zzj();
        }
    }
}
