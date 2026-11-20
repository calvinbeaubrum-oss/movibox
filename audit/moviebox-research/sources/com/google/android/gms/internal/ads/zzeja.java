package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeja implements zzdkw {
    private final zzcei zza;
    private final s zzb;
    private final zzfgm zzc;
    private final zzcjk zzd;
    private final zzfhh zze;
    private final zzbni zzf;
    private final boolean zzg;
    private final zzehs zzh;

    public zzeja(zzcei zzceiVar, s sVar, zzfgm zzfgmVar, zzcjk zzcjkVar, zzfhh zzfhhVar, boolean z11, zzbni zzbniVar, zzehs zzehsVar) {
        this.zza = zzceiVar;
        this.zzb = sVar;
        this.zzc = zzfgmVar;
        this.zzd = zzcjkVar;
        this.zze = zzfhhVar;
        this.zzg = z11;
        this.zzf = zzbniVar;
        this.zzh = zzehsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z11, Context context, zzdbk zzdbkVar) {
        int i11;
        zzctq zzctqVar = (zzctq) zzgen.zzq(this.zzb);
        this.zzd.zzao(true);
        boolean zZze = this.zzg ? this.zzf.zze(true) : true;
        boolean z12 = this.zzg;
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, true, z12 ? this.zzf.zzd() : false, z12 ? this.zzf.zza() : 0.0f, -1, z11, this.zzc.zzP, false);
        if (zzdbkVar != null) {
            zzdbkVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdkl zzdklVarZzg = zzctqVar.zzg();
        zzcjk zzcjkVar = this.zzd;
        int i12 = this.zzc.zzR;
        if (i12 == -1) {
            com.google.android.gms.ads.internal.client.zzw zzwVar = this.zze.zzj;
            if (zzwVar != null) {
                int i13 = zzwVar.zza;
                if (i13 == 1) {
                    i11 = 7;
                } else if (i13 == 2) {
                    i11 = 6;
                }
            }
            zzcec.zze("Error setting app open orientation; no targeting orientation available.");
            i12 = this.zzc.zzR;
            i11 = i12;
        } else {
            i11 = i12;
        }
        zzcei zzceiVar = this.zza;
        zzfgm zzfgmVar = this.zzc;
        String str = zzfgmVar.zzC;
        zzfgr zzfgrVar = zzfgmVar.zzt;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdklVarZzg, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i11, zzceiVar, str, zzjVar, zzfgrVar.zzb, zzfgrVar.zza, this.zze.zzf, zzdbkVar, zzfgmVar.zzaj ? this.zzh : null), true);
    }
}
