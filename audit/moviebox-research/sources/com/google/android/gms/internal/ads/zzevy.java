package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevy implements zzexq {
    private final zzexq zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzevy(zzexq zzexqVar, long j11, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzexqVar;
        this.zzb = j11;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        s sVarZzb = this.zza.zzb();
        long j11 = this.zzb;
        if (j11 > 0) {
            sVarZzb = zzgen.zzo(sVarZzb, j11, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgen.zzf(sVarZzb, Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzevx
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzh(null);
            }
        }, zzcep.zzf);
    }
}
