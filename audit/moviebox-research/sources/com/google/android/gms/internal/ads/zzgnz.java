package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgnz {
    private static final zzgnz zza = new zzgnz();
    private static final zzgny zzb = new zzgny(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgnz zza() {
        return zza;
    }

    public final zzgry zzb() {
        zzgry zzgryVar = (zzgry) this.zzc.get();
        return zzgryVar == null ? zzb : zzgryVar;
    }
}
