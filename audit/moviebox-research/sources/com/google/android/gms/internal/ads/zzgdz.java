package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgdz extends zzgew {
    private final Executor zza;
    final /* synthetic */ zzgea zzb;

    public zzgdz(zzgea zzgeaVar, Executor executor) {
        this.zzb = zzgeaVar;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzc(Object obj);

    @Override // com.google.android.gms.internal.ads.zzgew
    public final void zzd(Throwable th2) {
        this.zzb.zza = null;
        if (th2 instanceof ExecutionException) {
            this.zzb.zzd(((ExecutionException) th2).getCause());
        } else if (th2 instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzd(th2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e11) {
            this.zzb.zzd(e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
