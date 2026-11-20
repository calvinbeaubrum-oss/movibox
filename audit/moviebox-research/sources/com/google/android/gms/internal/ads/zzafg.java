package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzafg {
    protected final zzaea zza;

    public zzafg(zzaea zzaeaVar) {
        this.zza = zzaeaVar;
    }

    public abstract boolean zza(zzfp zzfpVar) throws zzcc;

    public abstract boolean zzb(zzfp zzfpVar, long j11) throws zzcc;

    public final boolean zzf(zzfp zzfpVar, long j11) throws zzcc {
        return zza(zzfpVar) && zzb(zzfpVar, j11);
    }
}
