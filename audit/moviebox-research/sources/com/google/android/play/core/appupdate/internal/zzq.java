package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class zzq extends zzn {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzn zzb;
    final /* synthetic */ y zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(y yVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzn zznVar) {
        super(taskCompletionSource);
        this.zzc = yVar;
        this.zza = taskCompletionSource2;
        this.zzb = zznVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        synchronized (this.zzc.f38074f) {
            try {
                y.n(this.zzc, this.zza);
                if (this.zzc.f38079k.getAndIncrement() > 0) {
                    this.zzc.f38070b.d("Already connected to the service.", new Object[0]);
                }
                y.p(this.zzc, this.zzb);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
