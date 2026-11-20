package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzapl implements Runnable {
    final /* synthetic */ zzaqa zza;
    final /* synthetic */ zzapm zzb;

    public zzapl(zzapm zzapmVar, zzaqa zzaqaVar) {
        this.zza = zzaqaVar;
        this.zzb = zzapmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
