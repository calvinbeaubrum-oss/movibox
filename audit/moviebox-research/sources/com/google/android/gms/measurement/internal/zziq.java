package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zziq implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjm zzb;

    public zziq(zzjm zzjmVar, zzq zzqVar) {
        this.zzb = zzjmVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzjmVar = this.zzb;
        zzdx zzdxVar = zzjmVar.zzb;
        if (zzdxVar == null) {
            zzjmVar.zzt.zzay().zzd().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzdxVar.zzm(this.zza);
        } catch (RemoteException e11) {
            this.zzb.zzt.zzay().zzd().zzb("Failed to reset data on the service: remote exception", e11);
        }
        this.zzb.zzQ();
    }
}
