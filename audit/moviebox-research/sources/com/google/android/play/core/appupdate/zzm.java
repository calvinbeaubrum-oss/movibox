package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class zzm extends com.google.android.play.core.appupdate.internal.zzn {
    final /* synthetic */ String zza;
    final /* synthetic */ TaskCompletionSource zzb;
    final /* synthetic */ u zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(u uVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzc = uVar;
        this.zza = str;
        this.zzb = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.appupdate.internal.l] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        try {
            ?? E = this.zzc.f38103a.e();
            u uVar = this.zzc;
            E.Z(uVar.f38104b, u.b(uVar, this.zza), new t(this.zzc, this.zzb, this.zza));
        } catch (RemoteException e11) {
            u.f38101e.c(e11, "requestUpdateInfo(%s)", this.zza);
            this.zzb.trySetException(new RuntimeException(e11));
        }
    }
}
