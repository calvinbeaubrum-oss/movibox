package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zztp implements zzsr {
    private final MediaCodec zza;

    public /* synthetic */ zztp(MediaCodec mediaCodec, zzto zztoVar) {
        this.zza = mediaCodec;
        int i11 = zzfy.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final int zza() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3) {
                int i11 = zzfy.zza;
                iDequeueOutputBuffer = -3;
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @Nullable
    public final ByteBuffer zzf(int i11) {
        int i12 = zzfy.zza;
        return this.zza.getInputBuffer(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @Nullable
    public final ByteBuffer zzg(int i11) {
        int i12 = zzfy.zza;
        return this.zza.getOutputBuffer(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzi() {
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzj(int i11, int i12, int i13, long j11, int i14) {
        this.zza.queueInputBuffer(i11, 0, i13, j11, i14);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzk(int i11, int i12, zzie zzieVar, long j11, int i13) {
        this.zza.queueSecureInputBuffer(i11, 0, zzieVar.zza(), j11, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzl() {
        this.zza.release();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @RequiresApi(21)
    public final void zzm(int i11, long j11) {
        this.zza.releaseOutputBuffer(i11, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzn(int i11, boolean z11) {
        this.zza.releaseOutputBuffer(i11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @RequiresApi(23)
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @RequiresApi(19)
    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzq(int i11) {
        this.zza.setVideoScalingMode(i11);
    }
}
