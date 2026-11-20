package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfeg implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzfeg(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfed zzb() {
        Context context = (Context) this.zza.zzb();
        zzfir zzfirVar = (zzfir) this.zzb.zzb();
        zzfjj zzfjjVar = (zzfjj) this.zzc.zzb();
        zzcdf zzcdfVarZzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgr)).booleanValue() ? com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh() : com.google.android.gms.ads.internal.zzt.zzo().zzi().zzi();
        boolean z11 = false;
        if (zzcdfVarZzh != null && zzcdfVarZzh.zzh()) {
            z11 = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgt)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgq)).booleanValue() || z11) {
                zzfji zzfjiVarZza = zzfjjVar.zza(zzfiz.Rewarded, context, zzfirVar, new zzfdh(new zzfde()));
                zzfdt zzfdtVar = new zzfdt(new zzfds());
                zzfiv zzfivVar = zzfjiVarZza.zza;
                zzgey zzgeyVar = zzcep.zza;
                return new zzfdj(zzfdtVar, new zzfdp(zzfivVar, zzgeyVar), zzfjiVarZza.zzb, zzfjiVarZza.zza.zza().zzf, zzgeyVar);
            }
        }
        return new zzfds();
    }
}
