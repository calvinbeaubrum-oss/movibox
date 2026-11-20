package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfl implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfo zza;
    private final String zzb;

    public zzfl(zzfo zzfoVar, String str) {
        this.zza = zzfoVar;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th2) {
        this.zza.zzt.zzay().zzd().zzb(this.zzb, th2);
    }
}
