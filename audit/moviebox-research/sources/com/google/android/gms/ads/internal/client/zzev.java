package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzev implements Runnable {
    final /* synthetic */ zzew zza;

    public zzev(zzew zzewVar) {
        this.zza = zzewVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzew zzewVar = this.zza;
        if (zzewVar.zza != null) {
            try {
                zzewVar.zza.zze(1);
            } catch (RemoteException e11) {
                zzcec.zzk("Could not notify onAdFailedToLoad event.", e11);
            }
        }
    }
}
