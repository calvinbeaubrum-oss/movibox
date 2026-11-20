package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelu extends zzelw {
    private final zzclg zza;
    private final zzdlf zzb;
    private final zzdaf zzc;
    private final zzdgo zzd;
    private final zzemh zze;
    private final zzeis zzf;

    public zzelu(zzclg zzclgVar, zzdlf zzdlfVar, zzdaf zzdafVar, zzdgo zzdgoVar, zzemh zzemhVar, zzeis zzeisVar) {
        this.zza = zzclgVar;
        this.zzb = zzdlfVar;
        this.zzc = zzdafVar;
        this.zzd = zzdgoVar;
        this.zze = zzemhVar;
        this.zzf = zzeisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelw
    public final s zzc(zzfhh zzfhhVar, Bundle bundle, zzfgm zzfgmVar, zzfgy zzfgyVar) {
        zzdaf zzdafVar = this.zzc;
        zzdafVar.zzi(zzfhhVar);
        zzdafVar.zzf(bundle);
        zzdafVar.zzg(new zzczz(zzfgyVar, zzfgmVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzds)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzclg zzclgVar = this.zza;
        zzdaf zzdafVar2 = this.zzc;
        zzdlj zzdljVarZzh = zzclgVar.zzh();
        zzdljVarZzh.zzf(zzdafVar2.zzj());
        zzdljVarZzh.zze(this.zzd);
        zzdljVarZzh.zzd(this.zzb);
        zzdljVarZzh.zzc(new zzcuc(null));
        zzcxp zzcxpVarZza = zzdljVarZzh.zzg().zza();
        return zzcxpVarZza.zzi(zzcxpVarZza.zzj());
    }
}
