package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcuw implements zzhhd {
    private final zzcum zza;
    private final zzhhu zzb;

    public zzcuw(zzcum zzcumVar, zzhhu zzhhuVar) {
        this.zza = zzcumVar;
        this.zzb = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdim((zzcvw) this.zzb.zzb(), zzcep.zzf));
        zzhhl.zzb(setSingleton);
        return setSingleton;
    }
}
