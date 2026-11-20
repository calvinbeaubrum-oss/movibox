package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfmw implements zzgej {
    final /* synthetic */ zzfmz zza;
    final /* synthetic */ zzfmo zzb;
    final /* synthetic */ boolean zzc;

    public zzfmw(zzfmz zzfmzVar, zzfmo zzfmoVar, boolean z11) {
        this.zza = zzfmzVar;
        this.zzb = zzfmoVar;
        this.zzc = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        zzfmo zzfmoVar = this.zzb;
        if (zzfmoVar.zzj()) {
            zzfmz zzfmzVar = this.zza;
            zzfmoVar.zzg(th2);
            zzfmoVar.zzf(false);
            zzfmzVar.zza(zzfmoVar);
            if (this.zzc) {
                this.zza.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zzb(Object obj) {
        zzfmo zzfmoVar = this.zzb;
        zzfmoVar.zzf(true);
        this.zza.zza(zzfmoVar);
        if (this.zzc) {
            this.zza.zzg();
        }
    }
}
