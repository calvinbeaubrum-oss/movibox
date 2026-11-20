package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.apache.tools.zip.UnixStat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaik {
    public final zzado zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;

    @Nullable
    public final long[] zzf;

    private zzaik(zzado zzadoVar, long j11, long j12, @Nullable long[] jArr, int i11, int i12) {
        this.zza = zzadoVar;
        this.zzb = j11;
        this.zzc = j12;
        this.zzf = jArr;
        this.zzd = i11;
        this.zze = i12;
    }

    public static zzaik zza(zzado zzadoVar, zzfp zzfpVar) {
        long[] jArr;
        int i11;
        int i12;
        int iZzg = zzfpVar.zzg();
        int iZzp = (iZzg & 1) != 0 ? zzfpVar.zzp() : -1;
        long jZzu = (iZzg & 2) != 0 ? zzfpVar.zzu() : -1L;
        if ((iZzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i13 = 0; i13 < 100; i13++) {
                jArr2[i13] = zzfpVar.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzg & 8) != 0) {
            zzfpVar.zzL(4);
        }
        if (zzfpVar.zzb() >= 24) {
            zzfpVar.zzL(21);
            int iZzo = zzfpVar.zzo();
            i12 = iZzo & UnixStat.PERM_MASK;
            i11 = iZzo >> 12;
        } else {
            i11 = -1;
            i12 = -1;
        }
        return new zzaik(zzadoVar, iZzp, jZzu, jArr, i11, i12);
    }
}
