package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcdh extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcdl zza;

    public zzcdh(zzcdl zzcdlVar) {
        this.zza = zzcdlVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcdl zzcdlVar = this.zza;
        zzbgi zzbgiVar = new zzbgi(zzcdlVar.zze, zzcdlVar.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                com.google.android.gms.ads.internal.zzt.zze();
                zzbgl.zza(this.zza.zzh, zzbgiVar);
            } catch (IllegalArgumentException e11) {
                zzcec.zzk("Cannot config CSI reporter.", e11);
            }
        }
    }
}
