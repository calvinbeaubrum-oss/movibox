package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzya extends zzyc implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    /* JADX WARN: Multi-variable type inference failed */
    public zzya(int i11, zzcz zzczVar, int i12, zzxu zzxuVar, int i13, @Nullable String str) {
        int iZzb;
        super(i11, zzczVar, i12);
        int i14 = 0;
        this.zzf = zzyg.zzo(i13, false);
        int i15 = this.zzd.zze;
        int i16 = zzxuVar.zzy;
        this.zzg = 1 == (i15 & 1);
        this.zzh = (i15 & 2) != 0;
        zzgaa zzgaaVarZzm = zzxuVar.zzw.isEmpty() ? zzgaa.zzm("") : zzxuVar.zzw;
        int i17 = 0;
        while (true) {
            if (i17 >= zzgaaVarZzm.size()) {
                i17 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                iZzb = 0;
                break;
            } else {
                iZzb = zzyg.zzb(this.zzd, (String) zzgaaVarZzm.get(i17), false);
                if (iZzb > 0) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        this.zzi = i17;
        this.zzj = iZzb;
        int iZza = zzyg.zza(this.zzd.zzf, zzxuVar.zzx);
        this.zzk = iZza;
        this.zzm = (this.zzd.zzf & 1088) != 0;
        int iZzb2 = zzyg.zzb(this.zzd, str, zzyg.zzh(str) == null);
        this.zzl = iZzb2;
        boolean z11 = iZzb > 0 || (zzxuVar.zzw.isEmpty() && iZza > 0) || this.zzg || (this.zzh && iZzb2 > 0);
        if (zzyg.zzo(i13, zzxuVar.zzT) && z11) {
            i14 = 1;
        }
        this.zze = i14;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzya zzyaVar) {
        zzfzp zzfzpVarZzb = zzfzp.zzk().zze(this.zzf, zzyaVar.zzf).zzd(Integer.valueOf(this.zzi), Integer.valueOf(zzyaVar.zzi), zzgbj.zzc().zza()).zzb(this.zzj, zzyaVar.zzj).zzb(this.zzk, zzyaVar.zzk).zze(this.zzg, zzyaVar.zzg).zzd(Boolean.valueOf(this.zzh), Boolean.valueOf(zzyaVar.zzh), this.zzj == 0 ? zzgbj.zzc() : zzgbj.zzc().zza()).zzb(this.zzl, zzyaVar.zzl);
        if (this.zzk == 0) {
            zzfzpVarZzb = zzfzpVarZzb.zzf(this.zzm, zzyaVar.zzm);
        }
        return zzfzpVarZzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        return false;
    }
}
