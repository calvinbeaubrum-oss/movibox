package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoc {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfw zza = new zzfw(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzfp zzb = new zzfp();

    public zzaoc(int i11) {
    }

    private final int zze(zzacv zzacvVar) {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacvVar.zzj();
        return 0;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar, int i11) throws IOException {
        if (i11 <= 0) {
            zze(zzacvVar);
            return 0;
        }
        boolean z11 = this.zze;
        long j11 = C.TIME_UNSET;
        if (!z11) {
            long jZzd = zzacvVar.zzd();
            int iMin = (int) Math.min(112800L, jZzd);
            long j12 = jZzd - ((long) iMin);
            if (zzacvVar.zzf() == j12) {
                this.zzb.zzH(iMin);
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin, false);
                zzfp zzfpVar = this.zzb;
                int iZzd = zzfpVar.zzd();
                int iZze = zzfpVar.zze();
                for (int i12 = iZze - 188; i12 >= iZzd; i12--) {
                    byte[] bArrZzM = zzfpVar.zzM();
                    int i13 = 0;
                    for (int i14 = -4; i14 <= 4; i14++) {
                        int i15 = (i14 * 188) + i12;
                        if (i15 >= iZzd && i15 < iZze && bArrZzM[i15] == 71) {
                            i13++;
                            if (i13 == 5) {
                                long jZzb = zzaom.zzb(zzfpVar, i12, i11);
                                if (jZzb == C.TIME_UNSET) {
                                    break;
                                }
                                j11 = jZzb;
                                break;
                            }
                        } else {
                            i13 = 0;
                        }
                    }
                }
                this.zzg = j11;
                this.zze = true;
                return 0;
            }
            zzadrVar.zza = j12;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zze(zzacvVar);
                return 0;
            }
            if (this.zzd) {
                long j13 = this.zzf;
                if (j13 == C.TIME_UNSET) {
                    zze(zzacvVar);
                    return 0;
                }
                zzfw zzfwVar = this.zza;
                this.zzh = zzfwVar.zzc(this.zzg) - zzfwVar.zzb(j13);
                zze(zzacvVar);
                return 0;
            }
            int iMin2 = (int) Math.min(112800L, zzacvVar.zzd());
            if (zzacvVar.zzf() == 0) {
                this.zzb.zzH(iMin2);
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin2, false);
                zzfp zzfpVar2 = this.zzb;
                int iZze2 = zzfpVar2.zze();
                for (int iZzd2 = zzfpVar2.zzd(); iZzd2 < iZze2; iZzd2++) {
                    if (zzfpVar2.zzM()[iZzd2] == 71) {
                        long jZzb2 = zzaom.zzb(zzfpVar2, iZzd2, i11);
                        if (jZzb2 != C.TIME_UNSET) {
                            j11 = jZzb2;
                            break;
                        }
                    }
                }
                this.zzf = j11;
                this.zzd = true;
                return 0;
            }
            zzadrVar.zza = 0L;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfw zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
