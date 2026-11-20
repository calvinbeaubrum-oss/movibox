package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgoi {
    private final zzgxq zza;
    private final Class zzb;

    public /* synthetic */ zzgoi(zzgxq zzgxqVar, Class cls, zzgoh zzgohVar) {
        this.zza = zzgxqVar;
        this.zzb = cls;
    }

    public static zzgoi zzb(zzgog zzgogVar, zzgxq zzgxqVar, Class cls) {
        return new zzgof(zzgxqVar, cls, zzgogVar);
    }

    public abstract zzggq zza(zzgpc zzgpcVar) throws GeneralSecurityException;

    public final zzgxq zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
