package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzenj implements zzdkw {
    private final Context zza;
    private final zzdtk zzb;
    private final zzfhh zzc;
    private final zzcei zzd;
    private final zzfgm zze;
    private final s zzf;
    private final zzcjk zzg;
    private final zzbni zzh;
    private final boolean zzi;
    private final zzehs zzj;

    public zzenj(Context context, zzdtk zzdtkVar, zzfhh zzfhhVar, zzcei zzceiVar, zzfgm zzfgmVar, s sVar, zzcjk zzcjkVar, zzbni zzbniVar, boolean z11, zzehs zzehsVar) {
        this.zza = context;
        this.zzb = zzdtkVar;
        this.zzc = zzfhhVar;
        this.zzd = zzceiVar;
        this.zze = zzfgmVar;
        this.zzf = sVar;
        this.zzg = zzcjkVar;
        this.zzh = zzbniVar;
        this.zzi = z11;
        this.zzj = zzehsVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x008b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ee  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z11, Context context, zzdbk zzdbkVar) {
        zzcjk zzcjkVar;
        zzcjk zzcjkVar2;
        boolean zZze;
        boolean z12;
        boolean zZzd;
        float fZza;
        zzdsp zzdspVar = (zzdsp) zzgen.zzq(this.zzf);
        try {
            zzfgm zzfgmVar = this.zze;
            if (this.zzg.zzaD()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaM)).booleanValue()) {
                    final zzcjk zzcjkVarZza = this.zzb.zza(this.zzc.zze, null, null);
                    zzbnx.zzb(zzcjkVarZza, zzdspVar.zzg());
                    final zzdto zzdtoVar = new zzdto();
                    zzdtoVar.zza(this.zza, (View) zzcjkVarZza);
                    zzdspVar.zzl().zzi(zzcjkVarZza, true, this.zzi ? this.zzh : null);
                    zzcjkVarZza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzenh
                        @Override // com.google.android.gms.internal.ads.zzckw
                        public final void zza(boolean z13, int i11, String str, String str2) {
                            zzdtoVar.zzb();
                            zzcjk zzcjkVar3 = zzcjkVarZza;
                            zzcjkVar3.zzZ();
                            zzcjkVar3.zzN().zzr();
                        }
                    });
                    zzcjkVarZza.zzN().zzH(new zzckx() { // from class: com.google.android.gms.internal.ads.zzeni
                        @Override // com.google.android.gms.internal.ads.zzckx
                        public final void zza() {
                            zzcjkVarZza.zzY();
                        }
                    });
                    zzfgr zzfgrVar = zzfgmVar.zzt;
                    zzcjkVarZza.zzac(zzfgrVar.zzb, zzfgrVar.zza, null);
                    zzcjkVar = zzcjkVarZza;
                } else {
                    zzcjkVar2 = this.zzg;
                }
                zzcjkVar.zzao(true);
                if (this.zzi) {
                    zZze = this.zzh.zze(false);
                } else {
                    zZze = false;
                }
                com.google.android.gms.ads.internal.zzt.zzp();
                Context context2 = this.zza;
                z12 = this.zzi;
                boolean zZzH = com.google.android.gms.ads.internal.util.zzt.zzH(context2);
                if (z12) {
                    zZzd = this.zzh.zzd();
                } else {
                    zZzd = false;
                }
                if (this.zzi) {
                    fZza = this.zzh.zza();
                } else {
                    fZza = 0.0f;
                }
                zzfgm zzfgmVar2 = this.zze;
                com.google.android.gms.ads.internal.zzj zzjVar = new com.google.android.gms.ads.internal.zzj(zZze, zZzH, zZzd, fZza, -1, z11, zzfgmVar2.zzP, zzfgmVar2.zzQ);
                if (zzdbkVar != null) {
                    zzdbkVar.zzf();
                }
                com.google.android.gms.ads.internal.zzt.zzi();
                zzdkl zzdklVarZzh = zzdspVar.zzh();
                zzfgm zzfgmVar3 = this.zze;
                zzcei zzceiVar = this.zzd;
                int i11 = zzfgmVar3.zzR;
                String str = zzfgmVar3.zzC;
                zzfgr zzfgrVar2 = zzfgmVar3.zzt;
                String str2 = zzfgrVar2.zzb;
                String str3 = zzfgrVar2.zza;
                zzfhh zzfhhVar = this.zzc;
                com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdklVarZzh, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i11, zzceiVar, str, zzjVar, str2, str3, zzfhhVar.zzf, zzdbkVar, zzfgmVar3.zzaj ? this.zzj : null), true);
            }
            zzcjkVar2 = this.zzg;
            zzcjkVar = zzcjkVar2;
            zzcjkVar.zzao(true);
            if (this.zzi) {
                zZze = this.zzh.zze(false);
            } else {
                zZze = false;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            Context context3 = this.zza;
            z12 = this.zzi;
            boolean zZzH2 = com.google.android.gms.ads.internal.util.zzt.zzH(context3);
            if (z12) {
                zZzd = this.zzh.zzd();
            } else {
                zZzd = false;
            }
            if (this.zzi) {
                fZza = this.zzh.zza();
            } else {
                fZza = 0.0f;
            }
            zzfgm zzfgmVar4 = this.zze;
            com.google.android.gms.ads.internal.zzj zzjVar2 = new com.google.android.gms.ads.internal.zzj(zZze, zZzH2, zZzd, fZza, -1, z11, zzfgmVar4.zzP, zzfgmVar4.zzQ);
            if (zzdbkVar != null) {
                zzdbkVar.zzf();
            }
            com.google.android.gms.ads.internal.zzt.zzi();
            zzdkl zzdklVarZzh2 = zzdspVar.zzh();
            zzfgm zzfgmVar5 = this.zze;
            zzcei zzceiVar2 = this.zzd;
            int i12 = zzfgmVar5.zzR;
            String str4 = zzfgmVar5.zzC;
            zzfgr zzfgrVar3 = zzfgmVar5.zzt;
            String str5 = zzfgrVar3.zzb;
            String str6 = zzfgrVar3.zza;
            zzfhh zzfhhVar2 = this.zzc;
            if (zzfgmVar5.zzaj) {
            }
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdklVarZzh2, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcjkVar, i12, zzceiVar2, str4, zzjVar2, str5, str6, zzfhhVar2.zzf, zzdbkVar, zzfgmVar5.zzaj ? this.zzj : null), true);
        } catch (zzcjw e11) {
            zzcec.zzh("", e11);
        }
    }
}
