package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
final class zzqn {
    public static void zza(AudioTrack audioTrack, @Nullable zzqp zzqpVar) {
        audioTrack.setPreferredDevice(zzqpVar == null ? null : zzqpVar.zza);
    }
}
