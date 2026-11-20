package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdyh extends zzbpg {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfmo zzd;
    final /* synthetic */ zzceu zze;
    final /* synthetic */ zzdyi zzf;

    public zzdyh(zzdyi zzdyiVar, Object obj, String str, long j11, zzfmo zzfmoVar, zzceu zzceuVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j11;
        this.zzd = zzfmoVar;
        this.zze = zzceuVar;
        this.zzf = zzdyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, "error");
            this.zzf.zzo.zzb(this.zzb, "error");
            zzfnc zzfncVar = this.zzf.zzp;
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzc(str);
            zzfmoVar.zzf(false);
            zzfncVar.zzb(zzfmoVar.zzl());
            this.zze.zzc(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfnc zzfncVar = this.zzf.zzp;
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzf(true);
            zzfncVar.zzb(zzfmoVar.zzl());
            this.zze.zzc(Boolean.TRUE);
        }
    }
}
