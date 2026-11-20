package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmj implements zzflw {
    private final zzfmg zza;
    private final zzfme zzb;

    public zzfmj(zzfmg zzfmgVar, zzfme zzfmeVar) {
        this.zza = zzfmgVar;
        this.zzb = zzfmeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final String zza(zzflv zzflvVar) {
        zzfme zzfmeVar = this.zzb;
        Map mapZzj = zzflvVar.zzj();
        zzfmeVar.zza(mapZzj);
        return this.zza.zza(mapZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final void zzb(zzflv zzflvVar) {
    }
}
