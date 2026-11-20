package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzetp {
    public final s zza;
    private final long zzb;
    private final Clock zzc;

    public zzetp(s sVar, long j11, Clock clock) {
        this.zza = sVar;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + j11;
    }

    public final boolean zza() {
        return this.zzb < this.zzc.elapsedRealtime();
    }
}
