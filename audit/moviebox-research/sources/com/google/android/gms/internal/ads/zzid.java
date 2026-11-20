package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(24)
final class zzid {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = androidx.media3.decoder.d.a(0, 0);

    public static /* bridge */ /* synthetic */ void zza(zzid zzidVar, int i11, int i12) {
        zzidVar.zzb.set(i11, i12);
        zzidVar.zza.setPattern(zzidVar.zzb);
    }
}
