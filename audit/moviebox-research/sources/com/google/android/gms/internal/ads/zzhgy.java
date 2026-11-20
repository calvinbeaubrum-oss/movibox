package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzhgy {
    final LinkedHashMap zza;

    public zzhgy(int i11) {
        this.zza = zzhha.zzb(i11);
    }

    public final zzhgy zza(Object obj, zzhhm zzhhmVar) {
        zzhhl.zza(obj, "key");
        zzhhl.zza(zzhhmVar, "provider");
        this.zza.put(obj, zzhhmVar);
        return this;
    }
}
