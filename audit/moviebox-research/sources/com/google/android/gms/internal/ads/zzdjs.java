package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdjs implements zzhhd {
    private final zzdjr zza;
    private final zzhhu zzb;

    public zzdjs(zzdjr zzdjrVar, zzhhu zzhhuVar) {
        this.zza = zzdjrVar;
        this.zzb = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdim((zzczu) this.zzb.zzb(), zzcep.zzf));
        zzhhl.zzb(setSingleton);
        return setSingleton;
    }
}
