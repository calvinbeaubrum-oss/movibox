package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfw {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzfw(long j11) {
        zzi(0L);
    }

    public static long zzg(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long zzh(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public final synchronized long zza(long j11) {
        try {
            if (!zzj()) {
                long jLongValue = this.zza;
                if (jLongValue == 9223372036854775806L) {
                    Long l11 = (Long) this.zzd.get();
                    l11.getClass();
                    jLongValue = l11.longValue();
                }
                this.zzb = jLongValue - j11;
                notifyAll();
            }
            this.zzc = j11;
        } catch (Throwable th2) {
            throw th2;
        }
        return j11 + this.zzb;
    }

    public final synchronized long zzb(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        try {
            long j12 = this.zzc;
            if (j12 != C.TIME_UNSET) {
                long jZzh = zzh(j12);
                long j13 = (4294967296L + jZzh) / 8589934592L;
                long j14 = (((-1) + j13) * 8589934592L) + j11;
                j11 += j13 * 8589934592L;
                if (Math.abs(j14 - jZzh) < Math.abs(j11 - jZzh)) {
                    j11 = j14;
                }
            }
            return zza(zzg(j11));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized long zzc(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = this.zzc;
        if (j12 != C.TIME_UNSET) {
            long jZzh = zzh(j12);
            long j13 = jZzh / 8589934592L;
            Long.signum(j13);
            long j14 = (j13 * 8589934592L) + j11;
            j11 += (j13 + 1) * 8589934592L;
            if (j14 >= jZzh) {
                j11 = j14;
            }
        }
        return zza(zzg(j11));
    }

    public final synchronized long zzd() {
        long j11 = this.zza;
        return (j11 == Long.MAX_VALUE || j11 == 9223372036854775806L) ? C.TIME_UNSET : j11;
    }

    public final synchronized long zze() {
        long j11;
        try {
            j11 = this.zzc;
        } catch (Throwable th2) {
            throw th2;
        }
        return j11 != C.TIME_UNSET ? j11 + this.zzb : zzd();
    }

    public final synchronized long zzf() {
        return this.zzb;
    }

    public final synchronized void zzi(long j11) {
        this.zza = j11;
        this.zzb = j11 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.zzc = C.TIME_UNSET;
    }

    public final synchronized boolean zzj() {
        return this.zzb != C.TIME_UNSET;
    }
}
