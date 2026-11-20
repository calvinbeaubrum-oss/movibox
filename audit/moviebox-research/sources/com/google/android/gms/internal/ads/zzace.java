package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzace {
    public static final zzace zza = new zzace(-3, C.TIME_UNSET, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzace(int i11, long j11, long j12) {
        this.zzb = i11;
        this.zzc = j11;
        this.zzd = j12;
    }

    public static zzace zzd(long j11, long j12) {
        return new zzace(-1, j11, j12);
    }

    public static zzace zze(long j11) {
        return new zzace(0, C.TIME_UNSET, j11);
    }

    public static zzace zzf(long j11, long j12) {
        return new zzace(-2, j11, j12);
    }
}
