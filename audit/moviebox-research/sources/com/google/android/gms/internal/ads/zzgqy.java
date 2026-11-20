package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgqy {

    @Deprecated
    static final zzgwc zza;

    @Deprecated
    static final zzgwc zzb;

    @Deprecated
    static final zzgwc zzc;

    static {
        zzgwc zzgwcVarZzc = zzgwc.zzc();
        zza = zzgwcVarZzc;
        zzb = zzgwcVarZzc;
        zzc = zzgwcVarZzc;
        try {
            zza();
        } catch (GeneralSecurityException e11) {
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgre.zzd();
        zzgqi.zzd();
        zzgqr.zza(true);
        if (zzgmw.zzb()) {
            return;
        }
        zzgpu.zzd(true);
    }
}
