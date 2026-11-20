package com.google.android.gms.ads.internal.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcb {
    private long zza;
    private long zzb = Long.MIN_VALUE;
    private final Object zzc = new Object();

    public zzcb(long j11) {
        this.zza = j11;
    }

    public final void zza(long j11) {
        synchronized (this.zzc) {
            this.zza = j11;
        }
    }

    public final boolean zzb() {
        synchronized (this.zzc) {
            try {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                if (this.zzb + this.zza > jElapsedRealtime) {
                    return false;
                }
                this.zzb = jElapsedRealtime;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
