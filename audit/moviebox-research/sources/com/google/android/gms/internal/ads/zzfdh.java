package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfdh implements zzfjp {
    private final zzfed zza;

    public zzfdh(zzfed zzfedVar) {
        this.zza = zzfedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfjp
    public final s zza(zzfjq zzfjqVar) {
        zzfdi zzfdiVar = (zzfdi) zzfjqVar;
        return ((zzfde) this.zza).zzb(zzfdiVar.zzb, zzfdiVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfjp
    public final void zzb(zzfje zzfjeVar) {
        zzfjeVar.zza = ((zzfde) this.zza).zza();
    }
}
