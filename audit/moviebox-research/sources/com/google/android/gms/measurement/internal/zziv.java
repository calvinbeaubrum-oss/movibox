package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zziv implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjm zzc;

    public zziv(zzjm zzjmVar, zzq zzqVar, Bundle bundle) {
        this.zzc = zzjmVar;
        this.zza = zzqVar;
        this.zzb = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzjmVar = this.zzc;
        zzdx zzdxVar = zzjmVar.zzb;
        if (zzdxVar == null) {
            zzjmVar.zzt.zzay().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzdxVar.zzr(this.zzb, this.zza);
        } catch (RemoteException e11) {
            this.zzc.zzt.zzay().zzd().zzb("Failed to send default event parameters to service", e11);
        }
    }
}
