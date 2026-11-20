package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzach {
    public static void zza(long j11, zzfp zzfpVar, zzaea[] zzaeaVarArr) {
        int iZzg;
        while (true) {
            if (zzfpVar.zzb() <= 1) {
                return;
            }
            int iZzc = zzc(zzfpVar);
            int iZzc2 = zzc(zzfpVar);
            int iZzd = zzfpVar.zzd() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzfpVar.zzb()) {
                zzff.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzd = zzfpVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzm = zzfpVar.zzm();
                int iZzq = zzfpVar.zzq();
                if (iZzq == 49) {
                    iZzg = zzfpVar.zzg();
                    iZzq = 49;
                } else {
                    iZzg = 0;
                }
                int iZzm2 = zzfpVar.zzm();
                if (iZzq == 47) {
                    zzfpVar.zzL(1);
                    iZzq = 47;
                }
                boolean z11 = iZzm == 181 && (iZzq == 49 || iZzq == 47) && iZzm2 == 3;
                if (iZzq == 49) {
                    z11 &= iZzg == 1195456820;
                }
                if (z11) {
                    zzb(j11, zzfpVar, zzaeaVarArr);
                }
            }
            zzfpVar.zzK(iZzd);
        }
    }

    public static void zzb(long j11, zzfp zzfpVar, zzaea[] zzaeaVarArr) {
        int iZzm = zzfpVar.zzm();
        if ((iZzm & 64) != 0) {
            int i11 = iZzm & 31;
            zzfpVar.zzL(1);
            int iZzd = zzfpVar.zzd();
            for (zzaea zzaeaVar : zzaeaVarArr) {
                int i12 = i11 * 3;
                zzfpVar.zzK(iZzd);
                zzaeaVar.zzr(zzfpVar, i12);
                zzek.zzf(j11 != C.TIME_UNSET);
                zzaeaVar.zzt(j11, 1, i12, 0, null);
            }
        }
    }

    private static int zzc(zzfp zzfpVar) {
        int i11 = 0;
        while (zzfpVar.zzb() != 0) {
            int iZzm = zzfpVar.zzm();
            i11 += iZzm;
            if (iZzm != 255) {
                return i11;
            }
        }
        return -1;
    }
}
