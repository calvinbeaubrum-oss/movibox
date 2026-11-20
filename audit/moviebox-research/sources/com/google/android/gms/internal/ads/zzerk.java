package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerk implements zzexq {
    private final Clock zza;
    private final zzfhh zzb;

    public zzerk(Clock clock, zzfhh zzfhhVar) {
        this.zza = clock;
        this.zzb = zzfhhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return zzgen.zzh(new zzerl(this.zzb, this.zza.currentTimeMillis()));
    }
}
