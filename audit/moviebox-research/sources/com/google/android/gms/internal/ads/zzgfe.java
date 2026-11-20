package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgfe {
    public static zzgey zza(ExecutorService executorService) {
        if (executorService instanceof zzgey) {
            return (zzgey) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzgfd((ScheduledExecutorService) executorService) : new zzgfa(executorService);
    }

    public static Executor zzb() {
        return zzgeb.INSTANCE;
    }

    public static Executor zzc(Executor executor, zzgdb zzgdbVar) {
        executor.getClass();
        return executor == zzgeb.INSTANCE ? executor : new zzgez(executor, zzgdbVar);
    }
}
