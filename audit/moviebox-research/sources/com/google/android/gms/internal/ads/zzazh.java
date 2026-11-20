package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzazh implements Runnable {
    final /* synthetic */ zzazi zza;

    public zzazh(zzazi zzaziVar) {
        this.zza = zzaziVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzc) {
            zzazi zzaziVar = this.zza;
            if (zzaziVar.zzd && zzaziVar.zze) {
                zzaziVar.zzd = false;
                zzcec.zze("App went background");
                Iterator it = this.zza.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzazj) it.next()).zza(false);
                    } catch (Exception e11) {
                        zzcec.zzh("", e11);
                    }
                }
            } else {
                zzcec.zze("App is still foreground");
            }
        }
    }
}
