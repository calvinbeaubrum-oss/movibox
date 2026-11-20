package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgnh {
    private final zzgxq zza;
    private final Class zzb;

    public /* synthetic */ zzgnh(zzgxq zzgxqVar, Class cls, zzgng zzgngVar) {
        this.zza = zzgxqVar;
        this.zzb = cls;
    }

    public static zzgnh zzb(zzgnf zzgnfVar, zzgxq zzgxqVar, Class cls) {
        return new zzgne(zzgxqVar, cls, zzgnfVar);
    }

    public abstract zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) throws GeneralSecurityException;

    public final zzgxq zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
