package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzer implements Runnable {
    final /* synthetic */ zzet zza;

    public zzer(zzet zzetVar) {
        this.zza = zzetVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzeu zzeuVar = this.zza.zza;
        if (zzeuVar.zza != null) {
            try {
                zzeuVar.zza.zze(1);
            } catch (RemoteException e11) {
                zzcec.zzk("Could not notify onAdFailedToLoad event.", e11);
            }
        }
    }
}
