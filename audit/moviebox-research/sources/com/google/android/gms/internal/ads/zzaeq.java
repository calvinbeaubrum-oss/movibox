package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaeq {
    protected final zzaea zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzaeq(int i11, int i12, long j11, int i13, zzaea zzaeaVar) {
        i12 = i12 != 1 ? 2 : i12;
        this.zzd = j11;
        this.zze = i13;
        this.zza = zzaeaVar;
        this.zzb = zzi(i11, i12 == 2 ? 1667497984 : 1651965952);
        this.zzc = i12 == 2 ? zzi(i11, 1650720768) : -1;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i11, int i12) {
        return (((i11 % 10) + 48) << 8) | ((i11 / 10) + 48) | i12;
    }

    private final long zzj(int i11) {
        return (this.zzd * ((long) i11)) / ((long) this.zze);
    }

    private final zzadv zzk(int i11) {
        return new zzadv(((long) this.zzl[i11]) * zzj(1), this.zzk[i11]);
    }

    public final zzads zza(long j11) {
        int iZzj = (int) (j11 / zzj(1));
        int iZzb = zzfy.zzb(this.zzl, iZzj, true, true);
        if (this.zzl[iZzb] == iZzj) {
            zzadv zzadvVarZzk = zzk(iZzb);
            return new zzads(zzadvVarZzk, zzadvVarZzk);
        }
        zzadv zzadvVarZzk2 = zzk(iZzb);
        int i11 = iZzb + 1;
        return i11 < this.zzk.length ? new zzads(zzadvVarZzk2, zzk(i11)) : new zzads(zzadvVarZzk2, zzadvVarZzk2);
    }

    public final void zzb(long j11) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i11 = this.zzj;
        jArr2[i11] = j11;
        this.zzl[i11] = this.zzi;
        this.zzj = i11 + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i11) {
        this.zzf = i11;
        this.zzg = i11;
    }

    public final void zzf(long j11) {
        if (this.zzj == 0) {
            this.zzh = 0;
        } else {
            this.zzh = this.zzl[zzfy.zzc(this.zzk, j11, true, true)];
        }
    }

    public final boolean zzg(int i11) {
        return this.zzb == i11 || this.zzc == i11;
    }

    public final boolean zzh(zzacv zzacvVar) throws IOException {
        int i11 = this.zzg;
        int iZzf = i11 - this.zza.zzf(zzacvVar, i11, false);
        this.zzg = iZzf;
        boolean z11 = iZzf == 0;
        if (z11) {
            if (this.zzf > 0) {
                this.zza.zzt(zzj(this.zzh), Arrays.binarySearch(this.zzl, this.zzh) >= 0 ? 1 : 0, this.zzf, 0, null);
            }
            this.zzh++;
        }
        return z11;
    }
}
