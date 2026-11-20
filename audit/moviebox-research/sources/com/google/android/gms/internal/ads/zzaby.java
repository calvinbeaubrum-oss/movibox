package com.google.android.gms.internal.ads;

import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaby {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE, 480, LogSeverity.WARNING_VALUE, LogSeverity.WARNING_VALUE, 2048};

    /* JADX WARN: Code duplicated, block: B:44:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    public static zzabx zza(zzfo zzfoVar) {
        int i11;
        int i12;
        int iZzd;
        int iZzd2 = zzfoVar.zzd(16);
        int iZzd3 = zzfoVar.zzd(16);
        if (iZzd3 == 65535) {
            iZzd3 = zzfoVar.zzd(24);
            i11 = 7;
        } else {
            i11 = 4;
        }
        int i13 = iZzd3 + i11;
        if (iZzd2 == 44097) {
            i13 += 2;
        }
        int i14 = i13;
        int iZzd4 = zzfoVar.zzd(2);
        if (iZzd4 == 3) {
            int i15 = 0;
            while (true) {
                iZzd = i15 + zzfoVar.zzd(2);
                if (!zzfoVar.zzo()) {
                    break;
                }
                i15 = (iZzd + 1) << 2;
            }
            iZzd4 = iZzd + 3;
        }
        int i16 = iZzd4;
        int iZzd5 = zzfoVar.zzd(10);
        if (zzfoVar.zzo() && zzfoVar.zzd(3) > 0) {
            zzfoVar.zzm(2);
        }
        int i17 = true != zzfoVar.zzo() ? 44100 : 48000;
        int iZzd6 = zzfoVar.zzd(4);
        if (i17 == 44100 && iZzd6 == 13) {
            i12 = zzb[13];
        } else if (i17 != 48000 || iZzd6 >= 14) {
            i12 = 0;
        } else {
            int i18 = zzb[iZzd6];
            int i19 = iZzd5 % 5;
            if (i19 == 1) {
                if (iZzd6 != 3 || iZzd6 == 8) {
                    i18++;
                }
            } else if (i19 != 2) {
                if (i19 != 3) {
                    if (i19 == 4 && (iZzd6 == 3 || iZzd6 == 8 || iZzd6 == 11)) {
                        i18++;
                    }
                } else if (iZzd6 != 3) {
                    i18++;
                } else {
                    i18++;
                }
            } else if (iZzd6 == 8 || iZzd6 == 11) {
                i18++;
            }
            i12 = i18;
        }
        return new zzabx(i16, 2, i17, i14, i12, null);
    }

    public static void zzb(int i11, zzfp zzfpVar) {
        zzfpVar.zzH(7);
        byte[] bArrZzM = zzfpVar.zzM();
        bArrZzM[0] = -84;
        bArrZzM[1] = 64;
        bArrZzM[2] = -1;
        bArrZzM[3] = -1;
        bArrZzM[4] = (byte) ((i11 >> 16) & 255);
        bArrZzM[5] = (byte) ((i11 >> 8) & 255);
        bArrZzM[6] = (byte) (i11 & 255);
    }
}
