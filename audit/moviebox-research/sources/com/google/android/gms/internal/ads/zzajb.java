package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajb {
    public final zzaea zza;
    public zzajp zzd;
    public zzaix zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private boolean zzl;
    public final zzajo zzb = new zzajo();
    public final zzfp zzc = new zzfp();
    private final zzfp zzj = new zzfp(1);
    private final zzfp zzk = new zzfp();

    public zzajb(zzaea zzaeaVar, zzajp zzajpVar, zzaix zzaixVar) {
        this.zza = zzaeaVar;
        this.zzd = zzajpVar;
        this.zze = zzaixVar;
        zzh(zzajpVar, zzaixVar);
    }

    public final int zza() {
        int i11;
        if (this.zzl) {
            i11 = this.zzb.zzj[this.zzf] ? 1 : 0;
        } else {
            i11 = this.zzd.zzg[this.zzf];
        }
        return zzf() != null ? i11 | 1073741824 : i11;
    }

    public final int zzb() {
        return !this.zzl ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i11, int i12) {
        zzfp zzfpVar;
        zzajn zzajnVarZzf = zzf();
        if (zzajnVarZzf == null) {
            return 0;
        }
        int i13 = zzajnVarZzf.zzd;
        if (i13 != 0) {
            zzfpVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzajnVarZzf.zze;
            int i14 = zzfy.zza;
            zzfp zzfpVar2 = this.zzk;
            int length = bArr.length;
            zzfpVar2.zzI(bArr, length);
            zzfpVar = this.zzk;
            i13 = length;
        }
        boolean zZzb = this.zzb.zzb(this.zzf);
        boolean z11 = zZzb || i12 != 0;
        zzfp zzfpVar3 = this.zzj;
        zzfpVar3.zzM()[0] = (byte) ((true != z11 ? 0 : 128) | i13);
        zzfpVar3.zzK(0);
        this.zza.zzs(this.zzj, 1, 1);
        this.zza.zzs(zzfpVar, i13, 1);
        if (!z11) {
            return i13 + 1;
        }
        if (!zZzb) {
            this.zzc.zzH(8);
            zzfp zzfpVar4 = this.zzc;
            byte[] bArrZzM = zzfpVar4.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 1;
            bArrZzM[2] = 0;
            bArrZzM[3] = (byte) i12;
            bArrZzM[4] = (byte) ((i11 >> 24) & 255);
            bArrZzM[5] = (byte) ((i11 >> 16) & 255);
            bArrZzM[6] = (byte) ((i11 >> 8) & 255);
            bArrZzM[7] = (byte) (i11 & 255);
            this.zza.zzs(zzfpVar4, 8, 1);
            return i13 + 9;
        }
        int i15 = i13 + 1;
        zzfp zzfpVar5 = this.zzb.zzn;
        int iZzq = zzfpVar5.zzq();
        zzfpVar5.zzL(-2);
        int i16 = (iZzq * 6) + 2;
        if (i12 != 0) {
            this.zzc.zzH(i16);
            byte[] bArrZzM2 = this.zzc.zzM();
            zzfpVar5.zzG(bArrZzM2, 0, i16);
            int i17 = (((bArrZzM2[2] & 255) << 8) | (bArrZzM2[3] & 255)) + i12;
            bArrZzM2[2] = (byte) ((i17 >> 8) & 255);
            bArrZzM2[3] = (byte) (i17 & 255);
            zzfpVar5 = this.zzc;
        }
        this.zza.zzs(zzfpVar5, i16, 1);
        return i15 + i16;
    }

    public final long zzd() {
        return !this.zzl ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzajo zzajoVar = this.zzb;
        return zzajoVar.zzi[this.zzf];
    }

    @Nullable
    public final zzajn zzf() {
        if (!this.zzl) {
            return null;
        }
        zzajo zzajoVar = this.zzb;
        zzaix zzaixVar = zzajoVar.zza;
        int i11 = zzfy.zza;
        int i12 = zzaixVar.zza;
        zzajn zzajnVarZza = zzajoVar.zzm;
        if (zzajnVarZza == null) {
            zzajnVarZza = this.zzd.zza.zza(i12);
        }
        if (zzajnVarZza == null || !zzajnVarZza.zza) {
            return null;
        }
        return zzajnVarZza;
    }

    public final void zzh(zzajp zzajpVar, zzaix zzaixVar) {
        this.zzd = zzajpVar;
        this.zze = zzaixVar;
        this.zza.zzl(zzajpVar.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzajo zzajoVar = this.zzb;
        zzajoVar.zzd = 0;
        zzajoVar.zzp = 0L;
        zzajoVar.zzq = false;
        zzajoVar.zzk = false;
        zzajoVar.zzo = false;
        zzajoVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i11 = this.zzg + 1;
        this.zzg = i11;
        int[] iArr = this.zzb.zzg;
        int i12 = this.zzh;
        if (i11 != iArr[i12]) {
            return true;
        }
        this.zzh = i12 + 1;
        this.zzg = 0;
        return false;
    }
}
