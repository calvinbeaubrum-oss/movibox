package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaij implements zzaii {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaij(long[] jArr, long[] jArr2, long j11, long j12) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j11;
        this.zzd = j12;
    }

    @Nullable
    public static zzaij zzb(long j11, long j12, zzado zzadoVar, zzfp zzfpVar) {
        int iZzm;
        zzfpVar.zzL(10);
        int iZzg = zzfpVar.zzg();
        if (iZzg <= 0) {
            return null;
        }
        int i11 = zzadoVar.zzd;
        long jZzs = zzfy.zzs(iZzg, ((long) (i11 >= 32000 ? 1152 : 576)) * 1000000, i11, RoundingMode.FLOOR);
        int iZzq = zzfpVar.zzq();
        int iZzq2 = zzfpVar.zzq();
        int iZzq3 = zzfpVar.zzq();
        zzfpVar.zzL(2);
        long j13 = j12 + ((long) zzadoVar.zzc);
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        long j14 = j12;
        int i12 = 0;
        while (i12 < iZzq) {
            long j15 = j13;
            long j16 = jZzs;
            jArr[i12] = (((long) i12) * jZzs) / ((long) iZzq);
            jArr2[i12] = Math.max(j14, j15);
            if (iZzq3 == 1) {
                iZzm = zzfpVar.zzm();
            } else if (iZzq3 == 2) {
                iZzm = zzfpVar.zzq();
            } else if (iZzq3 == 3) {
                iZzm = zzfpVar.zzo();
            } else {
                if (iZzq3 != 4) {
                    return null;
                }
                iZzm = zzfpVar.zzp();
            }
            j14 += ((long) iZzm) * ((long) iZzq2);
            i12++;
            j13 = j15;
            iZzq = iZzq;
            jZzs = j16;
        }
        long j17 = jZzs;
        if (j11 != -1 && j11 != j14) {
            zzff.zzf("VbriSeeker", "VBRI data size mismatch: " + j11 + ", " + j14);
        }
        return new zzaij(jArr, jArr2, j17, j14);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j11) {
        return this.zza[zzfy.zzc(this.zzb, j11, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        long[] jArr = this.zza;
        int iZzc = zzfy.zzc(jArr, j11, true, true);
        zzadv zzadvVar = new zzadv(jArr[iZzc], this.zzb[iZzc]);
        if (zzadvVar.zzb < j11) {
            long[] jArr2 = this.zza;
            if (iZzc != jArr2.length - 1) {
                int i11 = iZzc + 1;
                return new zzads(zzadvVar, new zzadv(jArr2[i11], this.zzb[i11]));
            }
        }
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
