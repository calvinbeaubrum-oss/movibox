package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzxn extends zzyc implements Comparable {
    private final int zze;
    private final boolean zzf;

    @Nullable
    private final String zzg;
    private final zzxu zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxn(int i11, zzcz zzczVar, int i12, zzxu zzxuVar, int i13, boolean z11, zzfxf zzfxfVar, int i14) {
        int i15;
        int iZzb;
        int iZzb2;
        boolean z12;
        super(i11, zzczVar, i12);
        this.zzh = zzxuVar;
        int i16 = 1;
        int i17 = true != zzxuVar.zzR ? 16 : 24;
        this.zzg = zzyg.zzh(this.zzd.zzd);
        this.zzi = zzyg.zzo(i13, false);
        int i18 = 0;
        while (true) {
            int size = zzxuVar.zzq.size();
            i15 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (i18 >= size) {
                i18 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                iZzb = 0;
                break;
            } else {
                iZzb = zzyg.zzb(this.zzd, (String) zzxuVar.zzq.get(i18), false);
                if (iZzb > 0) {
                    break;
                } else {
                    i18++;
                }
            }
        }
        this.zzk = i18;
        this.zzj = iZzb;
        this.zzl = zzyg.zza(this.zzd.zzf, 0);
        zzam zzamVar = this.zzd;
        int i19 = zzamVar.zzf;
        this.zzm = i19 == 0 || (i19 & 1) != 0;
        this.zzp = 1 == (zzamVar.zze & 1);
        this.zzq = zzamVar.zzz;
        this.zzr = zzamVar.zzA;
        this.zzs = zzamVar.zzi;
        this.zzf = zzfxfVar.zza(zzamVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = zzfy.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i21 = 0; i21 < strArrSplit.length; i21++) {
            strArrSplit[i21] = zzfy.zzC(strArrSplit[i21]);
        }
        int i22 = 0;
        while (true) {
            if (i22 >= strArrSplit.length) {
                i22 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                iZzb2 = 0;
                break;
            } else {
                iZzb2 = zzyg.zzb(this.zzd, strArrSplit[i22], false);
                if (iZzb2 > 0) {
                    break;
                } else {
                    i22++;
                }
            }
        }
        this.zzn = i22;
        this.zzo = iZzb2;
        for (int i23 = 0; i23 < zzxuVar.zzu.size(); i23++) {
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxuVar.zzu.get(i23))) {
                i15 = i23;
                break;
            }
        }
        this.zzt = i15;
        this.zzu = (i13 & 384) == 128;
        this.zzv = (i13 & 64) == 64;
        zzxu zzxuVar2 = this.zzh;
        if (!zzyg.zzo(i13, zzxuVar2.zzT) || (!(z12 = this.zzf) && !zzxuVar2.zzM)) {
            i16 = 0;
        } else if (zzyg.zzo(i13, false) && z12 && this.zzd.zzi != -1 && ((zzxuVar2.zzV || !z11) && (i17 & i13) != 0)) {
            i16 = 2;
        }
        this.zze = i16;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxn zzxnVar) {
        zzgbj zzgbjVarZza = (this.zzf && this.zzi) ? zzyg.zzc : zzyg.zzc.zza();
        zzfzp zzfzpVarZzd = zzfzp.zzk().zze(this.zzi, zzxnVar.zzi).zzd(Integer.valueOf(this.zzk), Integer.valueOf(zzxnVar.zzk), zzgbj.zzc().zza()).zzb(this.zzj, zzxnVar.zzj).zzb(this.zzl, zzxnVar.zzl).zze(this.zzp, zzxnVar.zzp).zze(this.zzm, zzxnVar.zzm).zzd(Integer.valueOf(this.zzn), Integer.valueOf(zzxnVar.zzn), zzgbj.zzc().zza()).zzb(this.zzo, zzxnVar.zzo).zze(this.zzf, zzxnVar.zzf).zzd(Integer.valueOf(this.zzt), Integer.valueOf(zzxnVar.zzt), zzgbj.zzc().zza());
        Integer numValueOf = Integer.valueOf(this.zzs);
        Integer numValueOf2 = Integer.valueOf(zzxnVar.zzs);
        boolean z11 = this.zzh.zzB;
        zzfzp zzfzpVarZzd2 = zzfzpVarZzd.zzd(numValueOf, numValueOf2, zzyg.zzd).zze(this.zzu, zzxnVar.zzu).zze(this.zzv, zzxnVar.zzv).zzd(Integer.valueOf(this.zzq), Integer.valueOf(zzxnVar.zzq), zzgbjVarZza).zzd(Integer.valueOf(this.zzr), Integer.valueOf(zzxnVar.zzr), zzgbjVarZza);
        Integer numValueOf3 = Integer.valueOf(this.zzs);
        Integer numValueOf4 = Integer.valueOf(zzxnVar.zzs);
        if (!zzfy.zzF(this.zzg, zzxnVar.zzg)) {
            zzgbjVarZza = zzyg.zzd;
        }
        return zzfzpVarZzd2.zzd(numValueOf3, numValueOf4, zzgbjVarZza).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        String str;
        zzxn zzxnVar = (zzxn) zzycVar;
        boolean z11 = this.zzh.zzP;
        zzam zzamVar = this.zzd;
        int i11 = zzamVar.zzz;
        if (i11 == -1) {
            return false;
        }
        zzam zzamVar2 = zzxnVar.zzd;
        if (i11 != zzamVar2.zzz || (str = zzamVar.zzm) == null || !TextUtils.equals(str, zzamVar2.zzm)) {
            return false;
        }
        boolean z12 = this.zzh.zzO;
        int i12 = this.zzd.zzA;
        return i12 != -1 && i12 == zzxnVar.zzd.zzA && this.zzu == zzxnVar.zzu && this.zzv == zzxnVar.zzv;
    }
}
