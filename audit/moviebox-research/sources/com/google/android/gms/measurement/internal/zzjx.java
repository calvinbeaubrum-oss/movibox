package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzjx implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjy zzc;

    public zzjx(zzjy zzjyVar, long j11, long j12) {
        this.zzc = zzjyVar;
        this.zza = j11;
        this.zzb = j12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzt.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjw
            @Override // java.lang.Runnable
            public final void run() {
                zzjx zzjxVar = this.zza;
                zzjy zzjyVar = zzjxVar.zzc;
                long j11 = zzjxVar.zza;
                long j12 = zzjxVar.zzb;
                zzjyVar.zza.zzg();
                zzjyVar.zza.zzt.zzay().zzc().zza("Application going to the background");
                zzjyVar.zza.zzt.zzm().zzm.zza(true);
                Bundle bundle = new Bundle();
                if (!zzjyVar.zza.zzt.zzf().zzu()) {
                    zzjyVar.zza.zzb.zzb(j12);
                    zzjyVar.zza.zzb.zzd(false, false, j12);
                }
                zzjyVar.zza.zzt.zzq().zzH("auto", "_ab", j11, bundle);
            }
        });
    }
}
