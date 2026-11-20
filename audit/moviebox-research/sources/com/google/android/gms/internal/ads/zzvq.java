package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzvq implements zzwh {
    final /* synthetic */ zzvt zza;
    private final int zzb;

    public zzvq(zzvt zzvtVar, int i11) {
        this.zza = zzvtVar;
        this.zzb = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zza(zzlb zzlbVar, zzih zzihVar, int i11) {
        return this.zza.zzg(this.zzb, zzlbVar, zzihVar, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zzb(long j11) {
        return this.zza.zzi(this.zzb, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zzd() throws IOException {
        this.zza.zzI(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final boolean zze() {
        return this.zza.zzP(this.zzb);
    }
}
