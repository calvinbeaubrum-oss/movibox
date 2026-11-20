package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgek implements Runnable {
    final Future zza;
    final zzgej zzb;

    public zzgek(Future future, zzgej zzgejVar) {
        this.zza = future;
        this.zzb = zzgejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Object obj = this.zza;
        if ((obj instanceof zzgfq) && (thZza = zzgfr.zza((zzgfq) obj)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzgen.zzp(this.zza));
        } catch (ExecutionException e11) {
            this.zzb.zza(e11.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzfww zzfwwVarZza = zzfwx.zza(this);
        zzfwwVarZza.zza(this.zzb);
        return zzfwwVarZza.toString();
    }
}
