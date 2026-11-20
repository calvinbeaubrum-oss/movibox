package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdmt implements zzgej {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdmv zzb;

    public zzdmt(zzdmv zzdmvVar, String str, boolean z11) {
        this.zzb = zzdmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(th2, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze.zzT((zzcjk) obj);
        zzdmv zzdmvVar = this.zzb;
        zzceu zzceuVarZzp = zzdmvVar.zze.zzp();
        zzfod zzfodVarZzf = zzdmvVar.zzf(this.zza, true);
        if (zzfodVarZzf != null && zzceuVarZzp != null) {
            zzceuVarZzp.zzc(zzfodVarZzf);
        } else if (zzceuVarZzp != null) {
            zzceuVarZzp.cancel(false);
        }
    }
}
