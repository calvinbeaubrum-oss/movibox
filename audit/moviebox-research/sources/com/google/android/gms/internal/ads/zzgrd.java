package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgrd implements zzggp {
    private final zzggx zza;
    private final zzgrx zzb;
    private final zzgrx zzc;

    public /* synthetic */ zzgrd(zzggx zzggxVar, zzgrc zzgrcVar) {
        zzgrx zzgrxVarZza;
        this.zza = zzggxVar;
        if (zzggxVar.zzf()) {
            zzgry zzgryVarZzb = zzgnz.zza().zzb();
            zzgsd zzgsdVarZza = zzgns.zza(zzggxVar);
            this.zzb = zzgryVarZzb.zza(zzgsdVarZza, "mac", "compute");
            zzgrxVarZza = zzgryVarZzb.zza(zzgsdVarZza, "mac", "verify");
        } else {
            zzgrxVarZza = zzgns.zza;
            this.zzb = zzgrxVarZza;
        }
        this.zzc = zzgrxVarZza;
    }
}
