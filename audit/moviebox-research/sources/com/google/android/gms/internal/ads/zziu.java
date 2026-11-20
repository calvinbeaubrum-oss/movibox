package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zziu {
    private final long zza;
    private final long zzb;
    private long zzc = C.TIME_UNSET;
    private long zzd = C.TIME_UNSET;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = C.TIME_UNSET;
    private long zze = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private long zzm = C.TIME_UNSET;
    private long zzn = C.TIME_UNSET;

    public /* synthetic */ zziu(float f11, float f12, long j11, float f13, long j12, long j13, float f14, zzit zzitVar) {
        this.zza = j12;
        this.zzb = j13;
    }

    private static long zzf(long j11, long j12, float f11) {
        return (long) ((j11 * 0.999f) + (j12 * 9.999871E-4f));
    }

    private final void zzg() {
        long j11;
        long j12 = this.zzc;
        if (j12 != C.TIME_UNSET) {
            j11 = this.zzd;
            if (j11 == C.TIME_UNSET) {
                long j13 = this.zzf;
                if (j13 != C.TIME_UNSET && j12 < j13) {
                    j12 = j13;
                }
                j11 = this.zzg;
                if (j11 == C.TIME_UNSET || j12 <= j11) {
                    j11 = j12;
                }
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.zze == j11) {
            return;
        }
        this.zze = j11;
        this.zzh = j11;
        this.zzm = C.TIME_UNSET;
        this.zzn = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
    }

    public final float zza(long j11, long j12) {
        if (this.zzc == C.TIME_UNSET) {
            return 1.0f;
        }
        long j13 = j11 - j12;
        long j14 = this.zzm;
        if (j14 == C.TIME_UNSET) {
            this.zzm = j13;
            this.zzn = 0L;
        } else {
            long jMax = Math.max(j13, zzf(j14, j13, 0.999f));
            this.zzm = jMax;
            this.zzn = zzf(this.zzn, Math.abs(j13 - jMax), 0.999f);
        }
        if (this.zzl != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long jMax2 = this.zzm + (this.zzn * 3);
        if (this.zzh > jMax2) {
            float fZzq = zzfy.zzq(1000L);
            long[] jArr = {jMax2, this.zze, this.zzh - (((long) ((this.zzk - 1.0f) * fZzq)) + ((long) ((this.zzi - 1.0f) * fZzq)))};
            for (int i11 = 1; i11 < 3; i11++) {
                long j15 = jArr[i11];
                if (j15 > jMax2) {
                    jMax2 = j15;
                }
            }
            this.zzh = jMax2;
        } else {
            jMax2 = Math.max(this.zzh, Math.min(j11 - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f)), jMax2));
            this.zzh = jMax2;
            long j16 = this.zzg;
            if (j16 != C.TIME_UNSET && jMax2 > j16) {
                this.zzh = j16;
                jMax2 = j16;
            }
        }
        long j17 = j11 - jMax2;
        if (Math.abs(j17) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j17 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j11 = this.zzh;
        if (j11 == C.TIME_UNSET) {
            return;
        }
        long j12 = j11 + this.zzb;
        this.zzh = j12;
        long j13 = this.zzg;
        if (j13 != C.TIME_UNSET && j12 > j13) {
            this.zzh = j13;
        }
        this.zzl = C.TIME_UNSET;
    }

    public final void zzd(zzbf zzbfVar) {
        long j11 = zzbfVar.zzc;
        this.zzc = zzfy.zzq(C.TIME_UNSET);
        this.zzf = zzfy.zzq(C.TIME_UNSET);
        this.zzg = zzfy.zzq(C.TIME_UNSET);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j11) {
        this.zzd = j11;
        zzg();
    }
}
