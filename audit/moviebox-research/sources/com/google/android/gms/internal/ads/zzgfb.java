package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgfb extends zzgeh implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzgfb(s sVar, ScheduledFuture scheduledFuture) {
        super(sVar);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgeg, java.util.concurrent.Future
    public final boolean cancel(boolean z11) {
        boolean zCancel = zzb().cancel(z11);
        if (zCancel) {
            this.zza.cancel(z11);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
