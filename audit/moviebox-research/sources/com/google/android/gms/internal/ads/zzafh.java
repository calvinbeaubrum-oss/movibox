package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafh extends zzafg {
    private final zzfp zzb;
    private final zzfp zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzafh(zzaea zzaeaVar) {
        super(zzaeaVar);
        this.zzb = new zzfp(zzgm.zza);
        this.zzc = new zzfp(4);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean zza(zzfp zzfpVar) throws zzaff {
        int iZzm = zzfpVar.zzm();
        int i11 = iZzm >> 4;
        int i12 = iZzm & 15;
        if (i12 == 7) {
            this.zzg = i11;
            return i11 != 5;
        }
        throw new zzaff("Video format not supported: " + i12);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean zzb(zzfp zzfpVar, long j11) throws zzcc {
        int i11;
        int iZzm = zzfpVar.zzm();
        long jZzh = zzfpVar.zzh();
        if (iZzm == 0) {
            if (!this.zze) {
                zzfp zzfpVar2 = new zzfp(new byte[zzfpVar.zzb()]);
                zzfpVar.zzG(zzfpVar2.zzM(), 0, zzfpVar.zzb());
                zzabz zzabzVarZza = zzabz.zza(zzfpVar2);
                this.zzd = zzabzVarZza.zzb;
                zzak zzakVar = new zzak();
                zzakVar.zzW(MimeTypes.VIDEO_H264);
                zzakVar.zzz(zzabzVarZza.zzk);
                zzakVar.zzab(zzabzVarZza.zzc);
                zzakVar.zzI(zzabzVarZza.zzd);
                zzakVar.zzS(zzabzVarZza.zzj);
                zzakVar.zzL(zzabzVarZza.zza);
                this.zza.zzl(zzakVar.zzac());
                this.zze = true;
                return false;
            }
        } else if (iZzm == 1 && this.zze) {
            int i12 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i11 = i12;
            } else if (i12 != 0) {
                i11 = 1;
            }
            byte[] bArrZzM = this.zzc.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 0;
            bArrZzM[2] = 0;
            int i13 = 4 - this.zzd;
            int i14 = 0;
            while (zzfpVar.zzb() > 0) {
                zzfpVar.zzG(this.zzc.zzM(), i13, this.zzd);
                this.zzc.zzK(0);
                zzfp zzfpVar3 = this.zzc;
                zzfp zzfpVar4 = this.zzb;
                int iZzp = zzfpVar3.zzp();
                zzfpVar4.zzK(0);
                this.zza.zzr(this.zzb, 4);
                this.zza.zzr(zzfpVar, iZzp);
                i14 = i14 + 4 + iZzp;
            }
            this.zza.zzt(j11 + (jZzh * 1000), i11, i14, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
