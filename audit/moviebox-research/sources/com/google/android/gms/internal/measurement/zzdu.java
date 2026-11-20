package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
abstract class zzdu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzef zzk;

    public zzdu(zzef zzefVar, boolean z11) {
        this.zzk = zzefVar;
        this.zzh = zzefVar.zza.currentTimeMillis();
        this.zzi = zzefVar.zza.elapsedRealtime();
        this.zzj = z11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzk.zzh) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e11) {
            this.zzk.zzT(e11, false, this.zzj);
            zzb();
        }
    }

    public abstract void zza() throws RemoteException;

    public void zzb() {
    }
}
