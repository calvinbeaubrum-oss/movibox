package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgef extends zzgee {
    private final s zza;

    public zzgef(s sVar) {
        sVar.getClass();
        this.zza = sVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb, com.google.common.util.concurrent.s
    public final void addListener(Runnable runnable, Executor executor) {
        this.zza.addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzgdb, java.util.concurrent.Future
    public final boolean cancel(boolean z11) {
        return this.zza.cancel(z11);
    }

    @Override // com.google.android.gms.internal.ads.zzgdb, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb, java.util.concurrent.Future
    public final Object get(long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j11, timeUnit);
    }

    @Override // com.google.android.gms.internal.ads.zzgdb, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb, java.util.concurrent.Future
    public final boolean isDone() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String toString() {
        return this.zza.toString();
    }
}
