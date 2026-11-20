package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzail implements zzaii {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    @Nullable
    private final long[] zzf;

    private zzail(long j11, int i11, long j12, long j13, @Nullable long[] jArr) {
        this.zza = j11;
        this.zzb = i11;
        this.zzc = j12;
        this.zzf = jArr;
        this.zzd = j13;
        this.zze = j13 != -1 ? j11 + j13 : -1L;
    }

    @Nullable
    public static zzail zzb(long j11, zzaik zzaikVar, long j12) {
        long j13 = zzaikVar.zzb;
        if (j13 == -1) {
            j13 = -1;
        }
        zzado zzadoVar = zzaikVar.zza;
        long jZzr = zzfy.zzr((j13 * ((long) zzadoVar.zzg)) - 1, zzadoVar.zzd);
        long j14 = zzaikVar.zzc;
        if (j14 == -1 || zzaikVar.zzf == null) {
            return new zzail(j12, zzaikVar.zza.zzc, jZzr, -1L, null);
        }
        if (j11 != -1) {
            long j15 = j12 + j14;
            if (j11 != j15) {
                zzff.zzf("XingSeeker", "XING data size mismatch: " + j11 + ", " + j15);
            }
        }
        return new zzail(j12, zzaikVar.zza.zzc, jZzr, zzaikVar.zzc, zzaikVar.zzf);
    }

    private final long zze(int i11) {
        return (this.zzc * ((long) i11)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j11) {
        if (!zzh()) {
            return 0L;
        }
        long j12 = j11 - this.zza;
        if (j12 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzf;
        zzek.zzb(jArr);
        double d11 = (j12 * 256.0d) / this.zzd;
        int iZzc = zzfy.zzc(jArr, (long) d11, true, true);
        long jZze = zze(iZzc);
        long j13 = jArr[iZzc];
        int i11 = iZzc + 1;
        long jZze2 = zze(i11);
        long j14 = iZzc == 99 ? 256L : jArr[i11];
        return jZze + Math.round((j13 == j14 ? 0.0d : (d11 - j13) / (j14 - j13)) * (jZze2 - jZze));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        if (!zzh()) {
            zzadv zzadvVar = new zzadv(0L, this.zza + ((long) this.zzb));
            return new zzads(zzadvVar, zzadvVar);
        }
        long jMax = Math.max(0L, Math.min(j11, this.zzc));
        double d11 = (jMax * 100.0d) / this.zzc;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                long[] jArr = this.zzf;
                zzek.zzb(jArr);
                double d13 = jArr[i11];
                d12 = d13 + ((d11 - ((double) i11)) * ((i11 == 99 ? 256.0d : jArr[i11 + 1]) - d13));
            }
        }
        long j12 = this.zzd;
        zzadv zzadvVar2 = new zzadv(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d12 / 256.0d) * j12), j12 - 1)));
        return new zzads(zzadvVar2, zzadvVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return this.zzf != null;
    }
}
