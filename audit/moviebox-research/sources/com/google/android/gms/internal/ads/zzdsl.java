package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdsl implements zzbnw {
    private final zzdce zza;

    @Nullable
    private final zzcag zzb;
    private final String zzc;
    private final String zzd;

    public zzdsl(zzdce zzdceVar, zzfgm zzfgmVar) {
        this.zza = zzdceVar;
        this.zzb = zzfgmVar.zzm;
        this.zzc = zzfgmVar.zzk;
        this.zzd = zzfgmVar.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbnw
    public final void zza(zzcag zzcagVar) {
        int i11;
        String str;
        zzcag zzcagVar2 = this.zzb;
        if (zzcagVar2 != null) {
            zzcagVar = zzcagVar2;
        }
        if (zzcagVar != null) {
            str = zzcagVar.zza;
            i11 = zzcagVar.zzb;
        } else {
            i11 = 1;
            str = "";
        }
        this.zza.zzd(new zzbzr(str, i11), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbnw
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbnw
    public final void zzc() {
        this.zza.zzf();
    }
}
