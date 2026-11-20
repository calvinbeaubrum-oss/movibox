package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzekg implements zzgej {
    final /* synthetic */ zzekh zza;

    public zzekg(zzekh zzekhVar) {
        this.zza = zzekhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zza.zza.zzd().zza(th2);
        this.zza.zzd.zzbK(zzeVarZza);
        zzfie.zzb(zzeVarZza.zza, th2, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* synthetic */ void zzb(Object obj) {
        ((zzcuf) obj).zzj();
    }
}
