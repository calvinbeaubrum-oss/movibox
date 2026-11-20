package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzyf extends zzyc {
    private final boolean zze;
    private final zzxu zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;
    private final boolean zzp;
    private final int zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    public zzyf(int i11, zzcz zzczVar, int i12, zzxu zzxuVar, int i13, int i14, boolean z11) {
        boolean z12;
        boolean z13;
        int i15;
        byte b11;
        boolean z14;
        zzam zzamVar;
        int i16;
        int i17;
        int i18;
        super(i11, zzczVar, 0);
        int i19 = 0;
        this.zzf = zzxuVar;
        int i21 = true != zzxuVar.zzK ? 16 : 24;
        if (z11) {
            zzam zzamVar2 = this.zzd;
            int i22 = zzamVar2.zzr;
            float f11 = zzamVar2.zzt;
            if (f11 == -1.0f || f11 <= 2.1474836E9f) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            z12 = false;
        }
        this.zze = z12;
        if (!z11 || (((i16 = (zzamVar = this.zzd).zzr) != -1 && i16 < 0) || ((i17 = zzamVar.zzs) != -1 && i17 < 0))) {
            z13 = false;
        } else {
            float f12 = zzamVar.zzt;
            if ((f12 == -1.0f || f12 >= 0.0f) && ((i18 = zzamVar.zzi) == -1 || i18 >= 0)) {
                z13 = true;
            } else {
                z13 = false;
            }
        }
        this.zzg = z13;
        this.zzh = zzyg.zzo(i13, false);
        zzam zzamVar3 = this.zzd;
        this.zzi = zzamVar3.zzi;
        this.zzj = zzamVar3.zza();
        this.zzl = zzyg.zza(this.zzd.zzf, 0);
        int i23 = this.zzd.zzf;
        this.zzm = i23 == 0 || (i23 & 1) != 0;
        int i24 = 0;
        while (true) {
            if (i24 >= zzxuVar.zzo.size()) {
                i24 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxuVar.zzo.get(i24))) {
                break;
            } else {
                i24++;
            }
        }
        this.zzk = i24;
        this.zzo = (i13 & 384) == 128;
        this.zzp = (i13 & 64) == 64;
        zzam zzamVar4 = this.zzd;
        String str2 = zzamVar4.zzm;
        if (str2 == null) {
            i15 = 0;
        } else {
            i15 = 4;
            switch (str2) {
                case "video/dolby-vision":
                    b11 = 0;
                    break;
                case "video/av01":
                    b11 = 1;
                    break;
                case "video/hevc":
                    b11 = 2;
                    break;
                case "video/avc":
                    b11 = 4;
                    break;
                case "video/x-vnd.on2.vp9":
                    b11 = 3;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                i15 = 5;
            } else if (b11 != 1) {
                if (b11 == 2) {
                    i15 = 3;
                } else if (b11 == 3) {
                    i15 = 2;
                } else if (b11 != 4) {
                    i15 = 0;
                } else {
                    i15 = 1;
                }
            }
        }
        this.zzq = i15;
        if ((zzamVar4.zzf & 16384) == 0) {
            zzxu zzxuVar2 = this.zzf;
            if (zzyg.zzo(i13, zzxuVar2.zzT) && ((z14 = this.zze) || zzxuVar2.zzI)) {
                i19 = (zzyg.zzo(i13, false) && this.zzg && z14 && zzamVar4.zzi != -1 && (i21 & i13) != 0) ? 2 : 1;
            }
        }
        this.zzn = i19;
    }

    public static /* synthetic */ int zza(zzyf zzyfVar, zzyf zzyfVar2) {
        zzgbj zzgbjVarZza = (zzyfVar.zze && zzyfVar.zzh) ? zzyg.zzc : zzyg.zzc.zza();
        zzfzp zzfzpVarZzk = zzfzp.zzk();
        Integer numValueOf = Integer.valueOf(zzyfVar.zzi);
        Integer numValueOf2 = Integer.valueOf(zzyfVar2.zzi);
        boolean z11 = zzyfVar.zzf.zzB;
        return zzfzpVarZzk.zzd(numValueOf, numValueOf2, zzyg.zzd).zzd(Integer.valueOf(zzyfVar.zzj), Integer.valueOf(zzyfVar2.zzj), zzgbjVarZza).zzd(Integer.valueOf(zzyfVar.zzi), Integer.valueOf(zzyfVar2.zzi), zzgbjVarZza).zza();
    }

    public static /* synthetic */ int zzd(zzyf zzyfVar, zzyf zzyfVar2) {
        zzfzp zzfzpVarZzd = zzfzp.zzk().zze(zzyfVar.zzh, zzyfVar2.zzh).zzb(zzyfVar.zzl, zzyfVar2.zzl).zze(zzyfVar.zzm, zzyfVar2.zzm).zze(zzyfVar.zze, zzyfVar2.zze).zze(zzyfVar.zzg, zzyfVar2.zzg).zzd(Integer.valueOf(zzyfVar.zzk), Integer.valueOf(zzyfVar2.zzk), zzgbj.zzc().zza());
        boolean z11 = zzyfVar.zzo;
        zzfzp zzfzpVarZze = zzfzpVarZzd.zze(z11, zzyfVar2.zzo);
        boolean z12 = zzyfVar.zzp;
        zzfzp zzfzpVarZze2 = zzfzpVarZze.zze(z12, zzyfVar2.zzp);
        if (z11 && z12) {
            zzfzpVarZze2 = zzfzpVarZze2.zzb(zzyfVar.zzq, zzyfVar2.zzq);
        }
        return zzfzpVarZze2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        zzyf zzyfVar = (zzyf) zzycVar;
        if (!zzfy.zzF(this.zzd.zzm, zzyfVar.zzd.zzm)) {
            return false;
        }
        boolean z11 = this.zzf.zzL;
        return this.zzo == zzyfVar.zzo && this.zzp == zzyfVar.zzp;
    }
}
