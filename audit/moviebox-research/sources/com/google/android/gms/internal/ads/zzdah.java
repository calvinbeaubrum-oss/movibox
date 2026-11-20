package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdah {
    private final Context zza;
    private final zzfhh zzb;
    private final Bundle zzc;

    @Nullable
    private final zzfgz zzd;

    @Nullable
    private final zzczz zze;

    @Nullable
    private final zzeis zzf;

    public /* synthetic */ zzdah(zzdaf zzdafVar, zzdag zzdagVar) {
        this.zza = zzdafVar.zza;
        this.zzb = zzdafVar.zzb;
        this.zzc = zzdafVar.zzc;
        this.zzd = zzdafVar.zzd;
        this.zze = zzdafVar.zze;
        this.zzf = zzdafVar.zzf;
    }

    public final Context zza(Context context) {
        return this.zza;
    }

    @Nullable
    public final Bundle zzb() {
        return this.zzc;
    }

    @Nullable
    public final zzczz zzc() {
        return this.zze;
    }

    public final zzdaf zzd() {
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(this.zza);
        zzdafVar.zzi(this.zzb);
        zzdafVar.zzf(this.zzc);
        zzdafVar.zzg(this.zze);
        zzdafVar.zzd(this.zzf);
        return zzdafVar;
    }

    public final zzeis zze(String str) {
        zzeis zzeisVar = this.zzf;
        return zzeisVar != null ? zzeisVar : new zzeis(str);
    }

    @Nullable
    public final zzfgz zzf() {
        return this.zzd;
    }

    public final zzfhh zzg() {
        return this.zzb;
    }
}
