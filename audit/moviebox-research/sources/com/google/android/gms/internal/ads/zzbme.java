package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzbme implements zzbng {
    public final /* synthetic */ zzdiu zza;
    public final /* synthetic */ zzcse zzb;

    public /* synthetic */ zzbme(zzdiu zzdiuVar, zzcse zzcseVar) {
        this.zza = zzdiuVar;
        this.zzb = zzcseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        zzbnf.zzc(map, this.zza);
        final String str = (String) map.get("u");
        if (str == null) {
            zzcec.zzj("URL missing from click GMSG.");
            return;
        }
        final zzcse zzcseVar = this.zzb;
        zzgee zzgeeVarZzu = zzgee.zzu(zzbnf.zza(zzcjkVar, str));
        zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.internal.ads.zzbmg
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj2) {
                zzcse zzcseVar2;
                String str2 = (String) obj2;
                zzbng zzbngVar = zzbnf.zza;
                return (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue() && (zzcseVar2 = zzcseVar) != null && zzcse.zzh(str)) ? zzcseVar2.zzb(str2, com.google.android.gms.ads.internal.client.zzay.zze()) : zzgen.zzh(str2);
            }
        };
        zzgey zzgeyVar = zzcep.zza;
        zzgen.zzr(zzgen.zzn(zzgeeVarZzu, zzgduVar, zzgeyVar), new zzbmu(zzcjkVar), zzgeyVar);
    }
}
