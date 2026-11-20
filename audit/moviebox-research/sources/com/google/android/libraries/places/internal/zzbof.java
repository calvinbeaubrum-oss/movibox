package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbof implements Thread.UncaughtExceptionHandler {
    public zzbof(zzbpo zzbpoVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        throw new zzbdq(zzbdo.zze(th2).zzg("Uncaught exception in the SynchronizationContext. Re-thrown."), null);
    }
}
