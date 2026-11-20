package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
final class zzqh {
    public static zzpg zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z11) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzpg.zza;
        }
        zzpe zzpeVar = new zzpe();
        zzpeVar.zza(true);
        zzpeVar.zzc(z11);
        return zzpeVar.zzd();
    }
}
