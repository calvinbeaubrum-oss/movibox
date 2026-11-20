package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdkh implements zzhhd {
    private final zzdjr zza;
    private final zzhhu zzb;

    public zzdkh(zzdjr zzdjrVar, zzhhu zzhhuVar) {
        this.zza = zzdjrVar;
        this.zzb = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzd((Executor) this.zzb.zzb());
    }
}
