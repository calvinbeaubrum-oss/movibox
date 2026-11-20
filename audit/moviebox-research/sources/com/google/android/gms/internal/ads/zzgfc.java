package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfc extends zzgdb.zzi implements Runnable {
    private final Runnable zza;

    public zzgfc(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th2) {
            zzd(th2);
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        return "task=[" + this.zza.toString() + "]";
    }
}
