package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgnw {
    private static final zzgnw zza = new zzgnw();
    private final Map zzb = new HashMap();

    public static zzgnw zza() {
        return zza;
    }

    public final synchronized void zzb(zzgnv zzgnvVar, Class cls) throws GeneralSecurityException {
        try {
            zzgnv zzgnvVar2 = (zzgnv) this.zzb.get(cls);
            if (zzgnvVar2 != null && !zzgnvVar2.equals(zzgnvVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            this.zzb.put(cls, zzgnvVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
