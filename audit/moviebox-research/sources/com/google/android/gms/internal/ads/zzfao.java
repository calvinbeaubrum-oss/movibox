package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.s;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfao implements zzexq {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbwx zzc;

    public zzfao(zzbwx zzbwxVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzc = zzbwxVar;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 49;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzm(zzgen.zzo(zzgen.zzh(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdZ)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzfws() { // from class: com.google.android.gms.internal.ads.zzfan
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return new zzfap((Bundle) obj);
            }
        }, zzcep.zza);
    }
}
