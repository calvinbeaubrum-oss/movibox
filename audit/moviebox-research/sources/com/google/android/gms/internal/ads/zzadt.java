package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzadt implements zzadu {
    private final long zza;
    private final zzads zzb;

    public zzadt(long j11, long j12) {
        this.zza = j11;
        zzadv zzadvVar = j12 == 0 ? zzadv.zza : new zzadv(0L, j12);
        this.zzb = new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return false;
    }
}
