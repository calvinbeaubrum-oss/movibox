package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzava implements Runnable {
    final /* synthetic */ zzavb zza;

    public zzava(zzavb zzavbVar) {
        this.zza = zzavbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzo) {
            if (this.zza.zzp) {
                return;
            }
            this.zza.zzp = true;
            try {
                zzavb.zzj(this.zza);
            } catch (Exception e11) {
                this.zza.zzh.zzc(2023, -1L, e11);
            }
            synchronized (this.zza.zzo) {
                this.zza.zzp = false;
            }
        }
    }
}
