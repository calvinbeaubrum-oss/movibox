package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzcwh implements zzemi {
    protected final zzfgy zza;
    protected final zzfgm zzb;
    private final zzdbw zzc;
    private final zzdcj zzd;

    @Nullable
    private final zzfea zze;
    private final zzdaq zzf;
    private final zzdfe zzg;
    private final zzdcn zzh;
    private final zzdij zzi;

    public zzcwh(zzcwg zzcwgVar) {
        this.zza = zzcwgVar.zza;
        this.zzb = zzcwgVar.zzb;
        this.zzc = zzcwgVar.zzc;
        this.zzd = zzcwgVar.zzd;
        this.zze = zzcwgVar.zze;
        this.zzf = zzcwgVar.zzf;
        this.zzg = zzcwgVar.zzg;
        this.zzh = zzcwgVar.zzh;
        this.zzi = zzcwgVar.zzi;
    }

    public void zzb() {
        this.zzc.zza(null);
    }

    public void zzj() {
        this.zzd.zzr();
        this.zzh.zza(this);
    }

    public final zzdaq zzl() {
        return this.zzf;
    }

    public final zzdbw zzm() {
        return this.zzc;
    }

    public final zzdfc zzn() {
        return this.zzg.zzi();
    }

    @Nullable
    public final zzfea zzo() {
        return this.zze;
    }

    public final zzfgy zzp() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzemi
    public final void zzq() {
        this.zzi.zzs();
    }
}
