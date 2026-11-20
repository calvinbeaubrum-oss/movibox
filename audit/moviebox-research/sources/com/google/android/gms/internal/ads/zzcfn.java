package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcfn implements Runnable {
    final /* synthetic */ zzcfp zza;

    public zzcfn(zzcfp zzcfpVar) {
        this.zza = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp zzcfpVar = this.zza;
        if (zzcfpVar.zzq != null) {
            if (!zzcfpVar.zzr) {
                zzcfpVar.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
