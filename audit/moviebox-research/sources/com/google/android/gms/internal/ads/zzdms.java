package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdms implements zzayq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdmv zzb;

    public zzdms(zzdmv zzdmvVar, String str) {
        this.zza = str;
        this.zzb = zzdmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayq
    public final void zzby(zzayp zzaypVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbJ)).booleanValue()) {
            if (zzaypVar.zzj) {
                zzdmv zzdmvVar = this.zzb;
                zzdmvVar.zzy.put(this.zza, Boolean.TRUE);
                zzdmv zzdmvVar2 = this.zzb;
                zzdmvVar2.zzA(zzdmvVar2.zzo.zzf(), this.zzb.zzo.zzl(), this.zzb.zzo.zzm(), true);
                return;
            }
            return;
        }
        synchronized (this) {
            try {
                if (zzaypVar.zzj) {
                    zzdmv zzdmvVar3 = this.zzb;
                    if (zzdmvVar3.zzo == null) {
                        return;
                    }
                    zzdmvVar3.zzy.put(this.zza, Boolean.TRUE);
                    zzdmv zzdmvVar4 = this.zzb;
                    zzdmvVar4.zzA(zzdmvVar4.zzo.zzf(), this.zzb.zzo.zzl(), this.zzb.zzo.zzm(), true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
