package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzig implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzie zzb;
    final /* synthetic */ zzie zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzim zze;

    public zzig(zzim zzimVar, Bundle bundle, zzie zzieVar, zzie zzieVar2, long j11) {
        this.zze = zzimVar;
        this.zza = bundle;
        this.zzb = zzieVar;
        this.zzc = zzieVar2;
        this.zzd = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzim.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
