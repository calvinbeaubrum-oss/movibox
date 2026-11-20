package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzghg {

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
        zzghl.zzd();
        zzgqy.zza();
        zzght.zza(true);
        zzgjd.zza(true);
        if (zzgmw.zzb()) {
            return;
        }
        zzgil.zza(true);
        zzgjq.zza(true);
        zzgke.zza(true);
        zzgko.zza(true);
        zzgks.zza(true);
        zzglw.zza(true);
    }
}
