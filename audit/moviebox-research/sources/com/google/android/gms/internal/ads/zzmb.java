package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmb {
    private final zzma zza;
    private final zzlz zzb;
    private final zzel zzc;
    private final zzcx zzd;
    private int zze;

    @Nullable
    private Object zzf;
    private final Looper zzg;
    private final int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public zzmb(zzlz zzlzVar, zzma zzmaVar, zzcx zzcxVar, int i11, zzel zzelVar, Looper looper) {
        this.zzb = zzlzVar;
        this.zza = zzmaVar;
        this.zzd = zzcxVar;
        this.zzg = looper;
        this.zzc = zzelVar;
        this.zzh = i11;
    }

    public final int zza() {
        return this.zze;
    }

    public final Looper zzb() {
        return this.zzg;
    }

    public final zzma zzc() {
        return this.zza;
    }

    public final zzmb zzd() {
        zzek.zzf(!this.zzi);
        this.zzi = true;
        this.zzb.zzm(this);
        return this;
    }

    public final zzmb zze(@Nullable Object obj) {
        zzek.zzf(!this.zzi);
        this.zzf = obj;
        return this;
    }

    public final zzmb zzf(int i11) {
        zzek.zzf(!this.zzi);
        this.zze = i11;
        return this;
    }

    @Nullable
    public final Object zzg() {
        return this.zzf;
    }

    public final synchronized void zzh(boolean z11) {
        this.zzj = z11 | this.zzj;
        this.zzk = true;
        notifyAll();
    }

    public final synchronized boolean zzi(long j11) throws InterruptedException, TimeoutException {
        try {
            zzek.zzf(this.zzi);
            zzek.zzf(this.zzg.getThread() != Thread.currentThread());
            long jElapsedRealtime = SystemClock.elapsedRealtime() + j11;
            while (!this.zzk) {
                if (j11 <= 0) {
                    throw new TimeoutException("Message delivery timed out.");
                }
                wait(j11);
                j11 = jElapsedRealtime - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.zzj;
    }

    public final synchronized boolean zzj() {
        return false;
    }
}
