package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfvx extends zzfvu {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzfvu zzb;
    final /* synthetic */ zzfwe zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvx(zzfwe zzfweVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzfvu zzfvuVar) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = zzfvuVar;
        this.zzc = zzfweVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zza() {
        synchronized (this.zzc.zzg) {
            try {
                zzfwe.zzn(this.zzc, this.zza);
                if (this.zzc.zzl.getAndIncrement() > 0) {
                    this.zzc.zzc.zzc("Already connected to the service.", new Object[0]);
                }
                zzfwe.zzp(this.zzc, this.zzb);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
