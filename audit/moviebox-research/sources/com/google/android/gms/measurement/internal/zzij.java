package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzij implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzim zzb;

    public zzij(zzim zzimVar, long j11) {
        this.zzb = zzimVar;
        this.zza = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzt.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
