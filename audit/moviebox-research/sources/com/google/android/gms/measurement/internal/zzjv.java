package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzjv implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkc zzb;

    public zzjv(zzkc zzkcVar, long j11) {
        this.zzb = zzkcVar;
        this.zza = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc.zzj(this.zzb, this.zza);
    }
}
