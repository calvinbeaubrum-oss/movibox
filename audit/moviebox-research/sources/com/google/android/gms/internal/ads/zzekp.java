package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzekp implements zzdkw {
    private final Context zza;
    private final zzcei zzb;
    private final s zzc;
    private final zzfgm zzd;
    private final zzcjk zze;
    private final zzfhh zzf;
    private final zzbni zzg;
    private final boolean zzh;
    private final zzehs zzi;

    public zzekp(Context context, zzcei zzceiVar, s sVar, zzfgm zzfgmVar, zzcjk zzcjkVar, zzfhh zzfhhVar, boolean z11, zzbni zzbniVar, zzehs zzehsVar) {
        this.zza = context;
        this.zzb = zzceiVar;
        this.zzc = sVar;
        this.zzd = zzfgmVar;
        this.zze = zzcjkVar;
        this.zzf = zzfhhVar;
        this.zzg = zzbniVar;
        this.zzh = z11;
        this.zzi = zzehsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z11, Context context, zzdbk zzdbkVar) {
        zzdjo zzdjoVar = (zzdjo) zzgen.zzq(this.zzc);
        this.zze.zzao(true);
        boolean zZze = this.zzh ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.zzt.zzp();
        Context context2 = this.zza;
        boolean z12 = this.zzh;
        com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, com.google.android.gms.ads.internal.util.zzt.zzH(context2), z12 ? this.zzg.zzd() : false, this.zzh ? this.zzg.zza() : 0.0f, -1, z11, this.zzd.zzP, false);
        if (zzdbkVar != null) {
            zzdbkVar.zzf();
        }
        com.google.android.gms.ads.internal.zzt.zzi();
        zzdkl zzdklVarZzh = zzdjoVar.zzh();
        zzcjk zzcjkVar = this.zze;
        zzfgm zzfgmVar = this.zzd;
        zzcei zzceiVar = this.zzb;
        int i11 = zzfgmVar.zzR;
        String str = zzfgmVar.zzC;
        zzfgr zzfgrVar = zzfgmVar.zzt;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdklVarZzh, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i11, zzceiVar, str, zzjVar, zzfgrVar.zzb, zzfgrVar.zza, this.zzf.zzf, zzdbkVar, zzfgmVar.zzaj ? this.zzi : null), true);
    }
}
