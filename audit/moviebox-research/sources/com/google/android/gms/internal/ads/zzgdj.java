package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgdj extends zzged implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    s zza;
    Object zzb;

    public zzgdj(s sVar, Object obj) {
        sVar.getClass();
        this.zza = sVar;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (sVar == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (sVar.isCancelled()) {
            zzs(sVar);
            return;
        }
        try {
            try {
                Object objZze = zze(obj, zzgen.zzp(sVar));
                this.zzb = null;
                zzf(objZze);
            } catch (Throwable th2) {
                try {
                    zzgff.zza(th2);
                    zzd(th2);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e11) {
            zzd(e11);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e12) {
            zzd(e12.getCause());
        } catch (Exception e13) {
            zzd(e13);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        String str;
        s sVar = this.zza;
        Object obj = this.zzb;
        String strZza = super.zza();
        if (sVar != null) {
            str = "inputFuture=[" + sVar.toString() + "], ";
        } else {
            str = "";
        }
        if (obj == null) {
            if (strZza != null) {
                return str.concat(strZza);
            }
            return null;
        }
        return str + "function=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    public abstract Object zze(Object obj, Object obj2) throws Exception;

    public abstract void zzf(Object obj);
}
