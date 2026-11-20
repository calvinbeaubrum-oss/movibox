package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzra extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzrd zza;
    final /* synthetic */ zzrb zzb;

    public zzra(zzrb zzrbVar, zzrd zzrdVar) {
        this.zza = zzrdVar;
        this.zzb = zzrbVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i11) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzrd zzrdVar = this.zzb.zza;
            if (zzrdVar.zzp == null || !zzrdVar.zzO) {
                return;
            }
            zzrdVar.zzp.zzb();
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzrd zzrdVar = this.zzb.zza;
            if (zzrdVar.zzp == null || !zzrdVar.zzO) {
                return;
            }
            zzrdVar.zzp.zzb();
        }
    }
}
