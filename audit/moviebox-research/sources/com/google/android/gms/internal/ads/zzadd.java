package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadd {
    public static int zza(zzfp zzfpVar, int i11) {
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return zzfpVar.zzm() + 1;
            case 7:
                return zzfpVar.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i11 - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzacv zzacvVar, zzadh zzadhVar) throws IOException {
        zzacvVar.zzj();
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzl(1, false);
        byte[] bArr = new byte[1];
        zzackVar.zzm(bArr, 0, 1, false);
        int i11 = bArr[0] & 1;
        boolean z11 = 1 == i11;
        zzackVar.zzl(2, false);
        int i12 = 1 != i11 ? 6 : 7;
        zzfp zzfpVar = new zzfp(i12);
        zzfpVar.zzJ(zzacy.zza(zzacvVar, zzfpVar.zzM(), 0, i12));
        zzacvVar.zzj();
        zzadc zzadcVar = new zzadc();
        if (zzd(zzfpVar, zzadhVar, z11, zzadcVar)) {
            return zzadcVar.zza;
        }
        throw zzcc.zza(null, null);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b0 A[ORIG_RETURN, RETURN] */
    public static boolean zzc(zzfp zzfpVar, zzadh zzadhVar, int i11, zzadc zzadcVar) {
        int iZza;
        int iZzd = zzfpVar.zzd();
        long jZzu = zzfpVar.zzu();
        long j11 = jZzu >>> 16;
        if (j11 != i11) {
            return false;
        }
        boolean z11 = (j11 & 1) == 1;
        long j12 = jZzu >> 12;
        long j13 = jZzu >> 8;
        long j14 = jZzu >> 4;
        long j15 = jZzu >> 1;
        long j16 = jZzu & 1;
        int i12 = (int) (j14 & 15);
        if (i12 > 7 ? !(i12 > 10 || zzadhVar.zzg != 2) : i12 == zzadhVar.zzg - 1) {
            int i13 = (int) (j15 & 7);
            if ((i13 == 0 || i13 == zzadhVar.zzi) && j16 != 1 && zzd(zzfpVar, zzadhVar, z11, zzadcVar) && (iZza = zza(zzfpVar, (int) (j12 & 15))) != -1 && iZza <= zzadhVar.zzb) {
                int i14 = zzadhVar.zze;
                int i15 = (int) (j13 & 15);
                if (i15 != 0) {
                    if (i15 <= 11) {
                        if (i15 == zzadhVar.zzf) {
                            if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i15 == 12) {
                        if (zzfpVar.zzm() * 1000 == i14) {
                            if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i15 <= 14) {
                        int iZzq = zzfpVar.zzq();
                        if (i15 == 14) {
                            iZzq *= 10;
                        }
                        if (iZzq == i14) {
                            if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                                return true;
                            }
                        }
                    }
                } else if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzd(zzfp zzfpVar, zzadh zzadhVar, boolean z11, zzadc zzadcVar) {
        try {
            long jZzw = zzfpVar.zzw();
            if (!z11) {
                jZzw *= (long) zzadhVar.zzb;
            }
            zzadcVar.zza = jZzw;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
