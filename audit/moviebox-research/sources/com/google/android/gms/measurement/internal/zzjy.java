package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzjy {
    final /* synthetic */ zzkc zza;
    private zzjx zzb;

    public zzjy(zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    public final void zza(long j11) {
        this.zzb = new zzjx(this, this.zza.zzt.zzav().currentTimeMillis(), j11);
        this.zza.zzd.postDelayed(this.zzb, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    public final void zzb() {
        this.zza.zzg();
        zzjx zzjxVar = this.zzb;
        if (zzjxVar != null) {
            this.zza.zzd.removeCallbacks(zzjxVar);
        }
        this.zza.zzt.zzm().zzm.zza(false);
    }
}
