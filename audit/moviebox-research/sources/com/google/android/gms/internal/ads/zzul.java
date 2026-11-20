package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzul extends zzcx {
    private final zzbp zzc;

    public zzul(zzbp zzbpVar) {
        this.zzc = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zza(Object obj) {
        return obj == zzuk.zzd ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcu zzd(int i11, zzcu zzcuVar, boolean z11) {
        zzcuVar.zzl(z11 ? 0 : null, z11 ? zzuk.zzd : null, 0, C.TIME_UNSET, 0L, zzd.zza, true);
        return zzcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcw zze(int i11, zzcw zzcwVar, long j11) {
        zzcwVar.zza(zzcw.zza, this.zzc, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
        zzcwVar.zzm = true;
        return zzcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final Object zzf(int i11) {
        return zzuk.zzd;
    }
}
