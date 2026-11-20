package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcbv {
    private final Clock zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzcch zzc;

    public zzcbv(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcch zzcchVar) {
        this.zza = clock;
        this.zzb = zzgVar;
        this.zzc = zzcchVar;
    }

    public final void zza(int i11, long j11) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzap)).booleanValue()) {
            return;
        }
        if (j11 - this.zzb.zzf() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaq)).booleanValue()) {
            this.zzb.zzL(i11);
            this.zzb.zzM(j11);
        } else {
            this.zzb.zzL(-1);
            this.zzb.zzM(j11);
        }
    }
}
