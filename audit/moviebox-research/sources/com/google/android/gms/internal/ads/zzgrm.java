package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgrm implements zzgqf {
    private final zzgpq zza;

    public zzgrm(zzgpq zzgpqVar) throws GeneralSecurityException {
        if (!zzgmv.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        this.zza = zzgpqVar;
    }
}
