package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfxw implements zzfxu {
    private static final zzfxu zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfxv
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzfxu zzb;
    private Object zzc;

    public zzfxw(zzfxu zzfxuVar) {
        this.zzb = zzfxuVar;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final Object zza() {
        zzfxu zzfxuVar = this.zzb;
        zzfxu zzfxuVar2 = zza;
        if (zzfxuVar != zzfxuVar2) {
            synchronized (this) {
                try {
                    if (this.zzb != zzfxuVar2) {
                        Object objZza = this.zzb.zza();
                        this.zzc = objZza;
                        this.zzb = zzfxuVar2;
                        return objZza;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.zzc;
    }
}
