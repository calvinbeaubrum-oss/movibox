package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdld implements zzcwk {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhhu zzd;
    private final zzdnl zze;

    public zzdld(Map map, Map map2, Map map3, zzhhu zzhhuVar, zzdnl zzdnlVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhhuVar;
        this.zze = zzdnlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwk
    @Nullable
    public final zzein zza(int i11, String str) {
        zzein zzeinVarZza;
        zzein zzeinVar = (zzein) this.zza.get(str);
        if (zzeinVar != null) {
            return zzeinVar;
        }
        if (i11 != 1) {
            if (i11 != 4) {
                return null;
            }
            zzelb zzelbVar = (zzelb) this.zzc.get(str);
            if (zzelbVar != null) {
                return new zzeio(zzelbVar, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcwm
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return new zzcwp((List) obj);
                    }
                });
            }
            zzeinVarZza = (zzein) this.zzb.get(str);
            if (zzeinVarZza == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzeinVarZza = ((zzcwk) this.zzd.zzb()).zza(i11, str)) == null) {
            return null;
        }
        return new zzeio(zzeinVarZza, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcwn
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return new zzcwp((zzcwh) obj);
            }
        });
    }
}
