package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzavc implements Runnable {
    final /* synthetic */ zzavd zza;

    public zzavc(zzavd zzavdVar) {
        this.zza = zzavdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.zza.zzb != null) {
            return;
        }
        synchronized (zzavd.zzc) {
            if (this.zza.zzb != null) {
                return;
            }
            boolean z11 = false;
            try {
                zBooleanValue = ((Boolean) zzbgc.zzcq.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzavd.zza = zzfst.zzb(this.zza.zze.zza, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z11 = zBooleanValue;
            this.zza.zzb = Boolean.valueOf(z11);
            zzavd.zzc.open();
        }
    }
}
