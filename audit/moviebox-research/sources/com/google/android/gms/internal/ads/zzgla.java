package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgla extends zzghh {
    private final zzglf zza;

    private zzgla(zzglf zzglfVar) {
        this.zza = zzglfVar;
    }

    public static zzgla zza(zzglf zzglfVar) throws GeneralSecurityException {
        return new zzgla(zzglfVar);
    }

    public final zzglf zzb() {
        return this.zza;
    }
}
