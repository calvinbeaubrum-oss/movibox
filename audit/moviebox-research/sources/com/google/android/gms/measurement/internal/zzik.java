package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzik implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzim zzc;

    public zzik(zzim zzimVar, zzie zzieVar, long j11) {
        this.zzc = zzimVar;
        this.zza = zzieVar;
        this.zzb = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzim zzimVar = this.zzc;
        zzimVar.zza = null;
        zzimVar.zzt.zzt().zzG(null);
    }
}
