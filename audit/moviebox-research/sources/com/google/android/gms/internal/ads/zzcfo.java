package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcfo implements Runnable {
    final /* synthetic */ zzcfp zza;

    public zzcfo(zzcfp zzcfpVar) {
        this.zza = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp zzcfpVar = this.zza;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzd();
        }
    }
}
