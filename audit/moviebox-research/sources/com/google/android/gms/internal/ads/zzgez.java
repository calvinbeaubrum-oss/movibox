package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgez implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgdb zzb;

    public zzgez(Executor executor, zzgdb zzgdbVar) {
        this.zza = executor;
        this.zzb = zzgdbVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e11) {
            this.zzb.zzd(e11);
        }
    }
}
