package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgcz extends zzged implements Runnable {
    s zza;
    Class zzb;
    Object zzc;

    public zzgcz(s sVar, Class cls, Object obj) {
        sVar.getClass();
        this.zza = sVar;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object objZzp;
        s sVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((sVar == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = sVar instanceof zzgfq ? ((zzgfq) sVar).zzl() : null;
            objZzp = th == null ? zzgen.zzp(sVar) : null;
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + String.valueOf(sVar.getClass()) + " threw " + String.valueOf(e11.getClass()) + " without a cause");
            }
            th = cause;
        } catch (Throwable th2) {
            th = th2;
        }
        if (th == null) {
            zzc(objZzp);
            return;
        }
        if (!cls.isInstance(th)) {
            zzs(sVar);
            return;
        }
        try {
            Object objZze = zze(obj, th);
            this.zzb = null;
            this.zzc = null;
            zzf(objZze);
        } catch (Throwable th3) {
            try {
                zzgff.zza(th3);
                zzd(th3);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        String str;
        s sVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZza = super.zza();
        if (sVar != null) {
            str = "inputFuture=[" + sVar.toString() + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (strZza != null) {
                return str.concat(strZza);
            }
            return null;
        }
        return str + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    public abstract Object zze(Object obj, Throwable th2) throws Exception;

    public abstract void zzf(Object obj);
}
