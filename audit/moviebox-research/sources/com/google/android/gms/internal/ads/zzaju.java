package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaju extends zzake {

    @Nullable
    private zzadh zza;

    @Nullable
    private zzajt zzb;

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final long zza(zzfp zzfpVar) {
        if (!zzd(zzfpVar.zzM())) {
            return -1L;
        }
        int i11 = (zzfpVar.zzM()[2] & 255) >> 4;
        if (i11 == 6) {
            zzfpVar.zzL(4);
            zzfpVar.zzw();
        } else if (i11 == 7) {
            i11 = 7;
            zzfpVar.zzL(4);
            zzfpVar.zzw();
        }
        int iZza = zzadd.zza(zzfpVar, i11);
        zzfpVar.zzK(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzb(boolean z11) {
        super.zzb(z11);
        if (z11) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final boolean zzc(zzfp zzfpVar, long j11, zzakb zzakbVar) {
        byte[] bArrZzM = zzfpVar.zzM();
        zzadh zzadhVar = this.zza;
        if (zzadhVar == null) {
            zzadh zzadhVar2 = new zzadh(bArrZzM, 17);
            this.zza = zzadhVar2;
            zzakbVar.zza = zzadhVar2.zzc(Arrays.copyOfRange(bArrZzM, 9, zzfpVar.zze()), null);
            return true;
        }
        if ((bArrZzM[0] & Ascii.DEL) == 3) {
            zzadg zzadgVarZzb = zzade.zzb(zzfpVar);
            zzadh zzadhVarZzf = zzadhVar.zzf(zzadgVarZzb);
            this.zza = zzadhVarZzf;
            this.zzb = new zzajt(zzadhVarZzf, zzadgVarZzb);
            return true;
        }
        if (!zzd(bArrZzM)) {
            return true;
        }
        zzajt zzajtVar = this.zzb;
        if (zzajtVar != null) {
            zzajtVar.zza(j11);
            zzakbVar.zzb = this.zzb;
        }
        zzakbVar.zza.getClass();
        return false;
    }
}
