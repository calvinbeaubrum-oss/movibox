package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcsp implements zzgej {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcsq zzb;

    public zzcsp(zzcsq zzcsqVar, String str) {
        this.zza = str;
        this.zzb = zzcsqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        zzcsq zzcsqVar = this.zzb;
        zzcsqVar.zzh.zza(zzcsqVar.zzg.zzd(zzcsqVar.zze, zzcsqVar.zzf, false, this.zza, null, zzcsqVar.zzf.zzd));
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcsq zzcsqVar = this.zzb;
        String str = (String) obj;
        zzcsqVar.zzh.zza(zzcsqVar.zzg.zzd(zzcsqVar.zze, zzcsqVar.zzf, false, this.zza, str, zzcsqVar.zzf.zzd));
    }
}
