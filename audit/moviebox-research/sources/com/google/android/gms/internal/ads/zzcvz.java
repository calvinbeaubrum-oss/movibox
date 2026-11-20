package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcvz {
    private final zzddm zza;

    @Nullable
    private final zzdft zzb;

    public zzcvz(zzddm zzddmVar, @Nullable zzdft zzdftVar) {
        this.zza = zzddmVar;
        this.zzb = zzdftVar;
    }

    public final zzddm zza() {
        return this.zza;
    }

    @Nullable
    public final zzdft zzb() {
        return this.zzb;
    }

    public final zzdim zzc() {
        zzdft zzdftVar = this.zzb;
        return zzdftVar != null ? new zzdim(zzdftVar, zzcep.zzf) : new zzdim(new zzcvy(this), zzcep.zzf);
    }
}
