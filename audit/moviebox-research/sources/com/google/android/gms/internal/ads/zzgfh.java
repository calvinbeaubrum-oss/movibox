package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfh implements Runnable {
    zzgfk zza;

    public zzgfh(zzgfk zzgfkVar) {
        this.zza = zzgfkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar;
        zzgfk zzgfkVar = this.zza;
        if (zzgfkVar == null || (sVar = zzgfkVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (sVar.isDone()) {
            zzgfkVar.zzs(sVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgfkVar.zzb;
            zzgfkVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th2) {
                    zzgfkVar.zzd(new zzgfj(str, null));
                    throw th2;
                }
            }
            zzgfkVar.zzd(new zzgfj(str + ": " + sVar.toString(), null));
            sVar.cancel(true);
        } catch (Throwable th3) {
            sVar.cancel(true);
            throw th3;
        }
    }
}
