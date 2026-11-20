package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsx extends Exception {

    @Nullable
    public final String zza;
    public final boolean zzb;

    @Nullable
    public final zzsv zzc;

    @Nullable
    public final String zzd;

    @Nullable
    public final zzsx zze;

    public zzsx(zzam zzamVar, @Nullable Throwable th2, boolean z11, int i11) {
        this("Decoder init failed: [" + i11 + "], " + zzamVar.toString(), th2, zzamVar.zzm, false, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i11), null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzsx(zzam zzamVar, @Nullable Throwable th2, boolean z11, zzsv zzsvVar) {
        String str = "Decoder init failed: " + zzsvVar.zza + ", " + zzamVar.toString();
        String str2 = zzamVar.zzm;
        int i11 = zzfy.zza;
        this(str, th2, str2, false, zzsvVar, th2 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th2).getDiagnosticInfo() : null, null);
    }

    private zzsx(@Nullable String str, @Nullable Throwable th2, @Nullable String str2, boolean z11, @Nullable zzsv zzsvVar, @Nullable String str3, @Nullable zzsx zzsxVar) {
        super(str, th2);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsvVar;
        this.zzd = str3;
        this.zze = zzsxVar;
    }

    public static /* bridge */ /* synthetic */ zzsx zza(zzsx zzsxVar, zzsx zzsxVar2) {
        return new zzsx(zzsxVar.getMessage(), zzsxVar.getCause(), zzsxVar.zza, false, zzsxVar.zzc, zzsxVar.zzd, zzsxVar2);
    }
}
