package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzacj implements zzadu {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzacj(long j11, long j12, int i11, int i12, boolean z11) {
        long jZzc;
        this.zza = j11;
        this.zzb = j12;
        this.zzc = i12 == -1 ? 1 : i12;
        this.zze = i11;
        if (j11 == -1) {
            this.zzd = -1L;
            jZzc = C.TIME_UNSET;
        } else {
            this.zzd = j11 - j12;
            jZzc = zzc(j11, j12, i11);
        }
        this.zzf = jZzc;
    }

    private static long zzc(long j11, long j12, int i11) {
        return (Math.max(0L, j11 - j12) * 8000000) / ((long) i11);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzf;
    }

    public final long zzb(long j11) {
        return zzc(j11, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        long j12 = this.zzd;
        if (j12 == -1) {
            zzadv zzadvVar = new zzadv(0L, this.zzb);
            return new zzads(zzadvVar, zzadvVar);
        }
        long j13 = ((long) this.zze) * j11;
        long j14 = this.zzc;
        long jMin = ((j13 / 8000000) / j14) * j14;
        if (j12 != -1) {
            jMin = Math.min(jMin, j12 - j14);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZzb = zzb(jMax);
        zzadv zzadvVar2 = new zzadv(jZzb, jMax);
        if (this.zzd != -1 && jZzb < j11) {
            long j15 = jMax + ((long) this.zzc);
            if (j15 < this.zza) {
                return new zzads(zzadvVar2, new zzadv(zzb(j15), j15));
            }
        }
        return new zzads(zzadvVar2, zzadvVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return this.zzd != -1;
    }
}
