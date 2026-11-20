package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfk extends zzged {
    private s zza;
    private ScheduledFuture zzb;

    private zzgfk(s sVar) {
        sVar.getClass();
        this.zza = sVar;
    }

    public static s zzf(s sVar, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgfk zzgfkVar = new zzgfk(sVar);
        zzgfh zzgfhVar = new zzgfh(zzgfkVar);
        zzgfkVar.zzb = scheduledExecutorService.schedule(zzgfhVar, j11, timeUnit);
        sVar.addListener(zzgfhVar, zzgeb.INSTANCE);
        return zzgfkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        s sVar = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (sVar == null) {
            return null;
        }
        String str = "inputFuture=[" + sVar.toString() + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final void zzb() {
        zzr(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
