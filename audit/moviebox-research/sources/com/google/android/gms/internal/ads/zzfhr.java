package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfhr implements zzgej {
    final /* synthetic */ zzcjk zza;
    final /* synthetic */ zzcse zzb;
    final /* synthetic */ zzfny zzc;
    final /* synthetic */ zzehh zzd;

    public zzfhr(zzcjk zzcjkVar, zzcse zzcseVar, zzfny zzfnyVar, zzehh zzehhVar) {
        this.zza = zzcjkVar;
        this.zzb = zzcseVar;
        this.zzc = zzfnyVar;
        this.zzd = zzehhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzaj) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue() && this.zzb != null && zzcse.zzh(str)) {
                this.zzb.zzg(str, this.zzc, com.google.android.gms.ads.internal.client.zzay.zze());
                return;
            } else {
                this.zzc.zzc(str, null);
                return;
            }
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        String str2 = this.zza.zzP().zzb;
        int i11 = 2;
        if (!com.google.android.gms.ads.internal.zzt.zzo().zzz(this.zza.getContext())) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgo)).booleanValue() || !this.zza.zzD().zzT) {
                i11 = 1;
            }
        }
        this.zzd.zzd(new zzehj(jCurrentTimeMillis, str2, str, i11));
    }
}
