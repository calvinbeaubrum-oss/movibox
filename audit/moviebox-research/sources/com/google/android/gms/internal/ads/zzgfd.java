package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfd extends zzgfa implements ScheduledExecutorService {
    final ScheduledExecutorService zza;

    public zzgfd(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j11, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgfn zzgfnVarZze = zzgfn.zze(runnable, null);
        return new zzgfb(zzgfnVarZze, scheduledExecutorService.schedule(zzgfnVarZze, j11, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j11, TimeUnit timeUnit) {
        zzgfn zzgfnVar = new zzgfn(callable);
        return new zzgfb(zzgfnVar, this.zza.schedule(zzgfnVar, j11, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        zzgfc zzgfcVar = new zzgfc(runnable);
        return new zzgfb(zzgfcVar, this.zza.scheduleAtFixedRate(zzgfcVar, j11, j12, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        zzgfc zzgfcVar = new zzgfc(runnable);
        return new zzgfb(zzgfcVar, this.zza.scheduleWithFixedDelay(zzgfcVar, j11, j12, timeUnit));
    }
}
