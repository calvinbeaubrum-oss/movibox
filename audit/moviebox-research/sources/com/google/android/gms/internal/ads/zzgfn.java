package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfn extends zzged implements RunnableFuture {
    private volatile zzgew zza;

    public zzgfn(zzgdt zzgdtVar) {
        this.zza = new zzgfl(this, zzgdtVar);
    }

    public zzgfn(Callable callable) {
        this.zza = new zzgfm(this, callable);
    }

    public static zzgfn zze(Runnable runnable, Object obj) {
        return new zzgfn(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgew zzgewVar = this.zza;
        if (zzgewVar != null) {
            zzgewVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        zzgew zzgewVar = this.zza;
        if (zzgewVar == null) {
            return super.zza();
        }
        return "task=[" + zzgewVar.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final void zzb() {
        zzgew zzgewVar;
        if (zzt() && (zzgewVar = this.zza) != null) {
            zzgewVar.zzh();
        }
        this.zza = null;
    }
}
