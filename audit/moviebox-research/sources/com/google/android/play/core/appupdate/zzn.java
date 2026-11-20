package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzn extends com.google.android.play.core.appupdate.internal.zzn {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ u zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(u uVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, String str) {
        super(taskCompletionSource);
        this.zzc = uVar;
        this.zza = taskCompletionSource2;
        this.zzb = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.appupdate.internal.l] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        try {
            this.zzc.f38103a.e().T(this.zzc.f38104b, u.i(), new s(this.zzc, this.zza));
        } catch (RemoteException e11) {
            u.f38101e.c(e11, "completeUpdate(%s)", this.zzb);
            this.zza.trySetException(new RuntimeException(e11));
        }
    }
}
