package com.google.android.gms.internal.ads;

import com.hisavana.common.tracking.TrackingKey;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcto {
    private final zzflw zza;
    private final zzdwf zzb;
    private final zzfgy zzc;

    public zzcto(zzdwf zzdwfVar, zzfgy zzfgyVar, zzflw zzflwVar) {
        this.zza = zzflwVar;
        this.zzb = zzdwfVar;
        this.zzc = zzfgyVar;
    }

    private static String zzb(int i11) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return "h";
        }
        if (i12 == 1) {
            return "bb";
        }
        if (i12 == 2) {
            return "cc";
        }
        if (i12 != 3) {
            return i12 != 4 ? "u" : "ac";
        }
        return "cb";
    }

    public final void zza(long j11, int i11) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzflw zzflwVar = this.zza;
            zzfgy zzfgyVar = this.zzc;
            zzflv zzflvVarZzb = zzflv.zzb("ad_closed");
            zzflvVarZzb.zzg(zzfgyVar.zzb.zzb);
            zzflvVarZzb.zza(TrackingKey.SHOW_TIME, String.valueOf(j11));
            zzflvVarZzb.zza("ad_format", "app_open_ad");
            zzflvVarZzb.zza("acr", zzb(i11));
            zzflwVar.zzb(zzflvVarZzb);
            return;
        }
        zzdwf zzdwfVar = this.zzb;
        zzfgy zzfgyVar2 = this.zzc;
        zzdwe zzdweVarZza = zzdwfVar.zza();
        zzdweVarZza.zze(zzfgyVar2.zzb.zzb);
        zzdweVarZza.zzb("action", "ad_closed");
        zzdweVarZza.zzb(TrackingKey.SHOW_TIME, String.valueOf(j11));
        zzdweVarZza.zzb("ad_format", "app_open_ad");
        zzdweVarZza.zzb("acr", zzb(i11));
        zzdweVarZza.zzg();
    }
}
