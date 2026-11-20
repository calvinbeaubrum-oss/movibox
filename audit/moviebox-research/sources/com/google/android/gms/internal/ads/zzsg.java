package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
final class zzsg implements zzsr {
    private final MediaCodec zza;
    private final zzsm zzb;
    private final zzss zzc;
    private boolean zzd;
    private int zze = 0;

    public /* synthetic */ zzsg(MediaCodec mediaCodec, HandlerThread handlerThread, zzss zzssVar, zzsf zzsfVar) {
        this.zza = mediaCodec;
        this.zzb = new zzsm(handlerThread);
        this.zzc = zzssVar;
    }

    public static /* synthetic */ void zzh(zzsg zzsgVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        zzsgVar.zzb.zzf(zzsgVar.zza);
        int i12 = zzfy.zza;
        Trace.beginSection("configureCodec");
        zzsgVar.zza.configure(mediaFormat, surface, (MediaCrypto) null, i11);
        Trace.endSection();
        zzsgVar.zzc.zzh();
        Trace.beginSection("startCodec");
        zzsgVar.zza.start();
        Trace.endSection();
        zzsgVar.zze = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzr(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @Nullable
    public final ByteBuffer zzf(int i11) {
        return this.zza.getInputBuffer(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    @Nullable
    public final ByteBuffer zzg(int i11) {
        return this.zza.getOutputBuffer(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzj(int i11, int i12, int i13, long j11, int i14) {
        this.zzc.zzd(i11, 0, i13, j11, i14);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzk(int i11, int i12, zzie zzieVar, long j11, int i13) {
        this.zzc.zze(i11, 0, zzieVar, j11, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzg();
                this.zzb.zzg();
            }
            this.zze = 2;
            if (this.zzd) {
            }
        } finally {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzm(int i11, long j11) {
        this.zza.releaseOutputBuffer(i11, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzn(int i11, boolean z11) {
        this.zza.releaseOutputBuffer(i11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzp(Bundle bundle) {
        this.zzc.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsr
    public final void zzq(int i11) {
        this.zza.setVideoScalingMode(i11);
    }
}
