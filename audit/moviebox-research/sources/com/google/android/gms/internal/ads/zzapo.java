package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapo {
    private int zza = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
    private int zzb;

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final void zzc(zzaqj zzaqjVar) throws zzaqj {
        int i11 = this.zzb + 1;
        this.zzb = i11;
        int i12 = this.zza;
        this.zza = i12 + i12;
        if (i11 > 1) {
            throw zzaqjVar;
        }
    }
}
