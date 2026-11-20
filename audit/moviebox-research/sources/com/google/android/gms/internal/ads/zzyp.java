package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyp {
    public final int zza;
    public final zzmi[] zzb;
    public final zzyi[] zzc;
    public final zzdk zzd;

    @Nullable
    public final Object zze;

    public zzyp(zzmi[] zzmiVarArr, zzyi[] zzyiVarArr, zzdk zzdkVar, @Nullable Object obj) {
        this.zzb = zzmiVarArr;
        this.zzc = (zzyi[]) zzyiVarArr.clone();
        this.zzd = zzdkVar;
        this.zze = obj;
        this.zza = zzmiVarArr.length;
    }

    public final boolean zza(@Nullable zzyp zzypVar, int i11) {
        return zzypVar != null && zzfy.zzF(this.zzb[i11], zzypVar.zzb[i11]) && zzfy.zzF(this.zzc[i11], zzypVar.zzc[i11]);
    }

    public final boolean zzb(int i11) {
        return this.zzb[i11] != null;
    }
}
