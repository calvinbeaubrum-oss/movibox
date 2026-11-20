package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfbr implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzfbt zzd;
    final /* synthetic */ zzfbu zze;

    public zzfbr(zzfbu zzfbuVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzfbt zzfbtVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzfbtVar;
        this.zze = zzfbuVar;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.internal.ads.zzdae, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        zzfmz zzfmzVar;
        zzctp zzctpVar = (zzctp) this.zze.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzctpVar == null ? zzfij.zzb(th2, null) : zzctpVar.zzb().zza(th2);
        synchronized (this.zze) {
            try {
                this.zze.zzj = null;
                if (zzctpVar != null) {
                    zzctpVar.zzc().zzbK(zzeVarZzb);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzia)).booleanValue()) {
                        this.zze.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbq
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zze.zzd.zzbK(zzeVarZzb);
                            }
                        });
                    }
                } else {
                    this.zze.zzd.zzbK(zzeVarZzb);
                    this.zze.zzm(this.zzd).zzh().zzb().zzc().zzh();
                }
                zzfie.zzb(zzeVarZzb.zza, th2, "AppOpenAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                    zzfnc zzfncVar = this.zze.zzh;
                    zzfmo zzfmoVar = this.zzc;
                    zzfmoVar.zza(zzeVarZzb);
                    zzfmoVar.zzg(th2);
                    zzfmoVar.zzf(false);
                    zzfncVar.zzb(zzfmoVar.zzl());
                } else {
                    zzfmzVar.zzc(zzeVarZzb);
                    zzfmo zzfmoVar2 = this.zzc;
                    zzfmoVar2.zzg(th2);
                    zzfmoVar2.zzf(false);
                    zzfmzVar.zza(zzfmoVar2);
                    zzfmzVar.zzg();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfmz zzfmzVar;
        zzcwh zzcwhVar = (zzcwh) obj;
        synchronized (this.zze) {
            try {
                this.zze.zzj = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzia)).booleanValue()) {
                    zzcwhVar.zzn().zzb(this.zze.zzd);
                }
                this.zza.zzb(zzcwhVar);
                if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                    zzfnc zzfncVar = this.zze.zzh;
                    zzfmo zzfmoVar = this.zzc;
                    zzfmoVar.zzb(zzcwhVar.zzp().zzb);
                    zzfmoVar.zzd(zzcwhVar.zzl().zzg());
                    zzfmoVar.zzf(true);
                    zzfncVar.zzb(zzfmoVar.zzl());
                } else {
                    zzfmzVar.zzf(zzcwhVar.zzp().zzb);
                    zzfmzVar.zze(zzcwhVar.zzl().zzg());
                    zzfmo zzfmoVar2 = this.zzc;
                    zzfmoVar2.zzf(true);
                    zzfmzVar.zza(zzfmoVar2);
                    zzfmzVar.zzg();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
