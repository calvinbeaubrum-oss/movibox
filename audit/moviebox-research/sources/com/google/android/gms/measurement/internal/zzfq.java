package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfq implements Runnable {
    final /* synthetic */ zzgu zza;
    final /* synthetic */ zzfr zzb;

    public zzfq(zzfr zzfrVar, zzgu zzguVar) {
        this.zzb = zzfrVar;
        this.zza = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfr.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
