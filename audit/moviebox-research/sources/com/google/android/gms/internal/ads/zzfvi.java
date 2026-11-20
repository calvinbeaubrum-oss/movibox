package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfvi extends zzfvu {
    final /* synthetic */ zzfvc zza;
    final /* synthetic */ zzfvq zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfvl zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvi(zzfvl zzfvlVar, TaskCompletionSource taskCompletionSource, zzfvc zzfvcVar, zzfvq zzfvqVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfvcVar;
        this.zzb = zzfvqVar;
        this.zzc = taskCompletionSource2;
        this.zzd = zzfvlVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfum] */
    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zza() {
        try {
            ?? Zze = this.zzd.zza.zze();
            if (Zze == 0) {
                return;
            }
            zzfvc zzfvcVar = this.zza;
            String str = this.zzd.zzd;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfvcVar.zzb());
            bundle.putString("callerPackage", str);
            bundle.putString(PushConstants.PROVIDER_FIELD_APP_ID, zzfvcVar.zza());
            Zze.zze(bundle, new zzfvk(this.zzd, this.zzb));
        } catch (RemoteException e11) {
            zzfvl.zzb.zzb(e11, "dismiss overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e11));
        }
    }
}
