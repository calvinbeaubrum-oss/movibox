package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzddm extends zzdgl {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    private long zzd;
    private long zze;
    private boolean zzf;

    @Nullable
    private ScheduledFuture zzg;

    public zzddm(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzd = -1L;
        this.zze = -1L;
        this.zzf = false;
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
    }

    private final synchronized void zze(long j11) {
        try {
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzg.cancel(true);
            }
            this.zzd = this.zzc.elapsedRealtime() + j11;
            this.zzg = this.zzb.schedule(new zzddl(this, null), j11, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zza() {
        this.zzf = false;
        zze(0L);
    }

    public final synchronized void zzb() {
        try {
            if (this.zzf) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zze = -1L;
            } else {
                this.zzg.cancel(true);
                this.zze = this.zzd - this.zzc.elapsedRealtime();
            }
            this.zzf = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzc() {
        try {
            if (this.zzf) {
                if (this.zze > 0 && this.zzg.isCancelled()) {
                    zze(this.zze);
                }
                this.zzf = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzd(int i11) {
        if (i11 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i11);
            if (this.zzf) {
                long j11 = this.zze;
                if (j11 <= 0 || millis >= j11) {
                    millis = j11;
                }
                this.zze = millis;
                return;
            }
            long jElapsedRealtime = this.zzc.elapsedRealtime();
            long j12 = this.zzd;
            if (jElapsedRealtime > j12 || j12 - this.zzc.elapsedRealtime() > millis) {
                zze(millis);
            }
        }
    }
}
