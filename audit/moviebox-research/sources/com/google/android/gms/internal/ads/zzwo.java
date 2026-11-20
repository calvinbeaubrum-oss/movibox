package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzwo implements zzwh {
    private final zzwh zza;
    private final long zzb;

    public zzwo(zzwh zzwhVar, long j11) {
        this.zza = zzwhVar;
        this.zzb = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zza(zzlb zzlbVar, zzih zzihVar, int i11) {
        int iZza = this.zza.zza(zzlbVar, zzihVar, i11);
        if (iZza != -4) {
            return iZza;
        }
        zzihVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zzb(long j11) {
        return this.zza.zzb(j11 - this.zzb);
    }

    public final zzwh zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final boolean zze() {
        return this.zza.zze();
    }
}
