package com.google.android.gms.internal.ads;

import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzant {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfw zza = new zzfw(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzfp zzb = new zzfp();

    public static long zzc(zzfp zzfpVar) {
        int iZzd = zzfpVar.zzd();
        if (zzfpVar.zzb() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzfpVar.zzG(bArr, 0, 9);
        zzfpVar.zzK(iZzd);
        byte b11 = bArr[0];
        if ((b11 & 196) != 68) {
            return C.TIME_UNSET;
        }
        byte b12 = bArr[2];
        if ((b12 & 4) != 4) {
            return C.TIME_UNSET;
        }
        byte b13 = bArr[4];
        if ((b13 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j11 = b11;
        long j12 = b12;
        long j13 = (248 & j12) >> 3;
        long j14 = (j12 & 3) << 13;
        return j14 | ((bArr[1] & 255) << 20) | ((j11 & 3) << 28) | (((j11 & 56) >> 3) << 30) | (j13 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b13) & 248) >> 3);
    }

    private final int zzf(zzacv zzacvVar) {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacvVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean z11 = this.zze;
        long j11 = C.TIME_UNSET;
        if (!z11) {
            long jZzd = zzacvVar.zzd();
            int iMin = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, jZzd);
            long j12 = jZzd - ((long) iMin);
            if (zzacvVar.zzf() != j12) {
                zzadrVar.zza = j12;
                return 1;
            }
            this.zzb.zzH(iMin);
            zzacvVar.zzj();
            ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin, false);
            zzfp zzfpVar = this.zzb;
            int iZzd = zzfpVar.zzd();
            for (int iZze = zzfpVar.zze() - 4; iZze >= iZzd; iZze--) {
                if (zzg(zzfpVar.zzM(), iZze) == 442) {
                    zzfpVar.zzK(iZze + 4);
                    long jZzc = zzc(zzfpVar);
                    if (jZzc != C.TIME_UNSET) {
                        j11 = jZzc;
                        break;
                    }
                }
            }
            this.zzg = j11;
            this.zze = true;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zzf(zzacvVar);
                return 0;
            }
            if (this.zzd) {
                long j13 = this.zzf;
                if (j13 == C.TIME_UNSET) {
                    zzf(zzacvVar);
                    return 0;
                }
                zzfw zzfwVar = this.zza;
                this.zzh = zzfwVar.zzc(this.zzg) - zzfwVar.zzb(j13);
                zzf(zzacvVar);
                return 0;
            }
            int iMin2 = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, zzacvVar.zzd());
            if (zzacvVar.zzf() != 0) {
                zzadrVar.zza = 0L;
                return 1;
            }
            this.zzb.zzH(iMin2);
            zzacvVar.zzj();
            ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin2, false);
            zzfp zzfpVar2 = this.zzb;
            int iZze2 = zzfpVar2.zze();
            for (int iZzd2 = zzfpVar2.zzd(); iZzd2 < iZze2 - 3; iZzd2++) {
                if (zzg(zzfpVar2.zzM(), iZzd2) == 442) {
                    zzfpVar2.zzK(iZzd2 + 4);
                    long jZzc2 = zzc(zzfpVar2);
                    if (jZzc2 != C.TIME_UNSET) {
                        j11 = jZzc2;
                        break;
                    }
                }
            }
            this.zzf = j11;
            this.zzd = true;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfw zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
