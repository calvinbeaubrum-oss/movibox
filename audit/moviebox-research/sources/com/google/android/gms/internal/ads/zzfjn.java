package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfjn implements zzgej {
    final /* synthetic */ zzfjq zza;
    final /* synthetic */ zzfjr zzb;

    public zzfjn(zzfjr zzfjrVar, zzfjq zzfjqVar) {
        this.zza = zzfjqVar;
        this.zzb = zzfjrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zzb) {
            try {
                this.zzb.zze = null;
                this.zzb.zzd.addFirst(this.zza);
                zzfjr zzfjrVar = this.zzb;
                if (zzfjrVar.zzf == 1) {
                    zzfjrVar.zzh();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
