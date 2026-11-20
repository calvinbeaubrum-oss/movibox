package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzst extends zzif {

    @Nullable
    public final zzsv zza;

    @Nullable
    public final String zzb;

    public zzst(Throwable th2, @Nullable zzsv zzsvVar) {
        super("Decoder failed: ".concat(String.valueOf(zzsvVar == null ? null : zzsvVar.zza)), th2);
        this.zza = zzsvVar;
        int i11 = zzfy.zza;
        this.zzb = th2 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th2).getDiagnosticInfo() : null;
    }
}
