package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadx implements zzadu {
    public zzadx(long j11) {
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        zzadv zzadvVar = new zzadv(j11, 0L);
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
