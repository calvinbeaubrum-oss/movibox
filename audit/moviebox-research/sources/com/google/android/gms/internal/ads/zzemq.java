package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzemq {

    @Nullable
    private zzemh zza;

    public zzemq() {
    }

    private zzemq(zzemh zzemhVar) {
        this.zza = zzemhVar;
    }

    public static zzemq zzb(zzemh zzemhVar) {
        return new zzemq(zzemhVar);
    }

    public final zzemh zza(Clock clock, zzemj zzemjVar, zzeis zzeisVar, zzfny zzfnyVar) {
        zzemh zzemhVar = this.zza;
        return zzemhVar != null ? zzemhVar : new zzemh(clock, zzemjVar, zzeisVar, zzfnyVar);
    }
}
