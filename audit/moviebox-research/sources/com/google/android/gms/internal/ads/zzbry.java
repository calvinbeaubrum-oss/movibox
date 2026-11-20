package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbry implements zzcey {
    final /* synthetic */ zzbrd zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzceu zzc;
    final /* synthetic */ zzbsb zzd;

    public zzbry(zzbsb zzbsbVar, zzbrd zzbrdVar, Object obj, zzceu zzceuVar) {
        this.zza = zzbrdVar;
        this.zzb = obj;
        this.zzc = zzceuVar;
        this.zzd = zzbsbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcey
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzceu zzceuVar = this.zzc;
        zzbsb.zzd(this.zzd, this.zza, (zzbrk) obj, obj2, zzceuVar);
    }
}
