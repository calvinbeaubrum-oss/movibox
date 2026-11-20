package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelx extends zzelw {
    private final zzclg zza;
    private final zzdaf zzb;
    private final zzdgo zzc;
    private final zzemh zzd;
    private final zzeis zze;

    public zzelx(zzclg zzclgVar, zzdaf zzdafVar, zzdgo zzdgoVar, zzemh zzemhVar, zzeis zzeisVar) {
        this.zza = zzclgVar;
        this.zzb = zzdafVar;
        this.zzc = zzdgoVar;
        this.zzd = zzemhVar;
        this.zze = zzeisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelw
    public final s zzc(zzfhh zzfhhVar, Bundle bundle, zzfgm zzfgmVar, zzfgy zzfgyVar) {
        zzdaf zzdafVar = this.zzb;
        zzdafVar.zzi(zzfhhVar);
        zzdafVar.zzf(bundle);
        zzdafVar.zzg(new zzczz(zzfgyVar, zzfgmVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzds)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzclg zzclgVar = this.zza;
        zzdaf zzdafVar2 = this.zzb;
        zzcts zzctsVarZzd = zzclgVar.zzd();
        zzctsVarZzd.zzd(zzdafVar2.zzj());
        zzctsVarZzd.zzc(this.zzc);
        zzcxp zzcxpVarZzb = zzctsVarZzd.zze().zzb();
        return zzcxpVarZzb.zzi(zzcxpVarZzb.zzj());
    }
}
