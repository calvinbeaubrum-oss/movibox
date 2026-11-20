package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfgl {
    private final Clock zza;
    private final Object zzb = new Object();
    private volatile int zzd = 1;
    private volatile long zzc = 0;

    public zzfgl(Clock clock) {
        this.zza = clock;
    }

    private final void zze() {
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzb) {
            try {
                if (this.zzd == 3) {
                    if (this.zzc + ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfX)).longValue() <= jCurrentTimeMillis) {
                        this.zzd = 1;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void zzf(int i11, int i12) {
        zze();
        Object obj = this.zzb;
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (obj) {
            try {
                if (this.zzd != i11) {
                    return;
                }
                this.zzd = i12;
                if (this.zzd == 3) {
                    this.zzc = jCurrentTimeMillis;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z11) {
        if (z11) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z11;
        synchronized (this.zzb) {
            zze();
            z11 = this.zzd == 3;
        }
        return z11;
    }

    public final boolean zzd() {
        boolean z11;
        synchronized (this.zzb) {
            zze();
            z11 = this.zzd == 2;
        }
        return z11;
    }
}
