package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfwz implements Serializable {
    public static zzfwz zzc() {
        return zzfwi.zza;
    }

    public static zzfwz zzd(Object obj) {
        return obj == null ? zzfwi.zza : new zzfxj(obj);
    }

    public abstract zzfwz zza(zzfws zzfwsVar);

    public abstract Object zzb(Object obj);
}
