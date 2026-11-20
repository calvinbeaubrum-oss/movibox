package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.WEB_CRASH)
final class zzqi {
    public static zzpg zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z11) {
        int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return zzpg.zza;
        }
        zzpe zzpeVar = new zzpe();
        boolean z12 = false;
        if (zzfy.zza > 32 && playbackOffloadSupport == 2) {
            z12 = true;
        }
        zzpeVar.zza(true);
        zzpeVar.zzb(z12);
        zzpeVar.zzc(z11);
        return zzpeVar.zzd();
    }
}
