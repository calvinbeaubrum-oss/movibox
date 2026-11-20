package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgoa {
    private static final zzgoa zza = new zzgoa();
    private final Map zzb = new HashMap();

    public static zzgoa zzb() {
        return zza;
    }

    public final synchronized zzggq zza(String str) throws GeneralSecurityException {
        if (!this.zzb.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzggq) this.zzb.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzggq zzggqVar) throws GeneralSecurityException {
        try {
            if (!this.zzb.containsKey(str)) {
                this.zzb.put(str, zzggqVar);
                return;
            }
            if (((zzggq) this.zzb.get(str)).equals(zzggqVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(this.zzb.get(str)) + "), cannot insert " + String.valueOf(zzggqVar));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzggq) entry.getValue());
        }
    }
}
