package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfub {
    private final String zza;
    private final long zzb;

    public zzfub() {
        this.zza = null;
        this.zzb = -1L;
    }

    public zzfub(String str, long j11) {
        this.zza = str;
        this.zzb = j11;
    }

    public final long zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zza != null && this.zzb >= 0;
    }
}
