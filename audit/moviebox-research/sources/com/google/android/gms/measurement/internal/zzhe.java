package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhe implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhx zzb;

    public zzhe(zzhx zzhxVar, long j11) {
        this.zzb = zzhxVar;
        this.zza = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzt.zzt().zzu(new AtomicReference());
    }
}
