package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzqd {

    @Nullable
    private final zzqc zza;
    private int zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;

    public zzqd(AudioTrack audioTrack) {
        int i11 = zzfy.zza;
        this.zza = new zzqc(audioTrack);
        zzh(0);
    }

    private final void zzh(int i11) {
        this.zzb = i11;
        long j11 = 10000;
        if (i11 == 0) {
            this.zze = 0L;
            this.zzf = -1L;
            this.zzc = System.nanoTime() / 1000;
        } else {
            if (i11 == 1) {
                this.zzd = 10000L;
                return;
            }
            j11 = (i11 == 2 || i11 == 3) ? 10000000L : 500000L;
        }
        this.zzd = j11;
    }

    @TargetApi(19)
    public final long zza() {
        return this.zza.zza();
    }

    @TargetApi(19)
    public final long zzb() {
        return this.zza.zzb();
    }

    public final void zzc() {
        if (this.zzb == 4) {
            zzh(0);
        }
    }

    public final void zzd() {
        zzh(4);
    }

    public final void zze() {
        zzh(0);
    }

    public final boolean zzf() {
        return this.zzb == 2;
    }

    @TargetApi(19)
    public final boolean zzg(long j11) {
        if (j11 - this.zze < this.zzd) {
            return false;
        }
        zzqc zzqcVar = this.zza;
        this.zze = j11;
        boolean zZzc = zzqcVar.zzc();
        int i11 = this.zzb;
        if (i11 == 0) {
            if (!zZzc) {
                if (j11 - this.zzc <= 500000) {
                    return false;
                }
                zzh(3);
                return false;
            }
            if (this.zza.zzb() < this.zzc) {
                return false;
            }
            this.zzf = this.zza.zza();
            zzh(1);
            return true;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return zZzc;
                }
                if (!zZzc) {
                    return false;
                }
                zzh(0);
                return true;
            }
            if (!zZzc) {
                zzh(0);
                return false;
            }
        } else {
            if (!zZzc) {
                zzh(0);
                return false;
            }
            if (this.zza.zza() > this.zzf) {
                zzh(2);
                return true;
            }
        }
        return true;
    }
}
