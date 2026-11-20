package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
final class zztq implements zzss {
    private final MediaCodec zza;

    public zztq(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzd(int i11, int i12, int i13, long j11, int i14) {
        this.zza.queueInputBuffer(i11, 0, i13, j11, i14);
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zze(int i11, int i12, zzie zzieVar, long j11, int i13) {
        this.zza.queueSecureInputBuffer(i11, 0, zzieVar.zza(), j11, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzf(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzh() {
    }
}
