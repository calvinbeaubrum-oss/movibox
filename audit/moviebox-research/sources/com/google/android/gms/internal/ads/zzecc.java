package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecc implements zzece {
    private final Map zza;
    private final zzgey zzb;
    private final zzddq zzc;

    public zzecc(Map map, zzgey zzgeyVar, zzddq zzddqVar) {
        this.zza = map;
        this.zzb = zzgeyVar;
        this.zzc = zzddqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    public final s zzb(final zzbze zzbzeVar) {
        this.zzc.zzbw(zzbzeVar);
        s sVarZzg = zzgen.zzg(new zzead(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzic)).split(",")) {
            final zzhhu zzhhuVar = (zzhhu) this.zza.get(str.trim());
            if (zzhhuVar != null) {
                sVarZzg = zzgen.zzf(sVarZzg, zzead.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeca
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final s zza(Object obj) {
                        return ((zzece) zzhhuVar.zzb()).zzb(zzbzeVar);
                    }
                }, this.zzb);
            }
        }
        zzgen.zzr(sVarZzg, new zzecb(this), zzcep.zzf);
        return sVarZzg;
    }
}
