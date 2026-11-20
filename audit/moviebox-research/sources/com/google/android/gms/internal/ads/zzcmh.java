package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcmh implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzcmh(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbzp zzb() {
        Context contextZza = ((zzclm) this.zza).zza();
        zzfnc zzfncVar = (zzfnc) this.zzb.zzb();
        zzbrx zzbrxVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(contextZza, zzcei.zza(), zzfncVar);
        zzbrr zzbrrVar = zzbru.zza;
        zzbrxVarZzb.zza("google.afma.request.getAdDictionary", zzbrrVar, zzbrrVar);
        return new zzbzo(contextZza, com.google.android.gms.ads.internal.zzt.zzf().zzb(contextZza, zzcei.zza(), zzfncVar).zza("google.afma.sdkConstants.getSdkConstants", zzbrrVar, zzbrrVar));
    }
}
