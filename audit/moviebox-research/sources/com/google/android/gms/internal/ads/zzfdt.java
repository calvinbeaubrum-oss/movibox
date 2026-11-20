package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdt implements zzfed {
    private final zzfed zza;

    @Nullable
    private zzdae zzb;

    public zzfdt(zzfed zzfedVar) {
        this.zza = zzfedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzdae zzd() {
        return this.zzb;
    }

    public final synchronized s zzb(zzfee zzfeeVar, zzfec zzfecVar, @Nullable zzdae zzdaeVar) {
        this.zzb = zzdaeVar;
        if (zzfeeVar.zza == null) {
            return ((zzfds) this.zza).zzb(zzfeeVar, zzfecVar, zzdaeVar);
        }
        zzcxp zzcxpVarZzb = zzdaeVar.zzb();
        return zzcxpVarZzb.zzi(zzcxpVarZzb.zzk(zzgen.zzh(zzfeeVar.zza)));
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ s zzc(zzfee zzfeeVar, zzfec zzfecVar, @Nullable Object obj) {
        return zzb(zzfeeVar, zzfecVar, null);
    }
}
