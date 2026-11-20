package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
final class zzpc {
    public static int zza(int i11, int i12, zzk zzkVar) {
        for (int i13 = 10; i13 > 0; i13--) {
            int iZzg = zzfy.zzg(i13);
            if (iZzg != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(iZzg).build(), zzkVar.zza().zza)) {
                return i13;
            }
        }
        return 0;
    }

    public static zzgaa<Integer> zzb(zzk zzkVar) {
        zzfzx zzfzxVar = new zzfzx();
        zzgce it = zzpd.zzc.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (zzfy.zza >= zzfy.zzf(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzkVar.zza().zza)) {
                zzfzxVar.zzf(Integer.valueOf(iIntValue));
            }
        }
        zzfzxVar.zzf((Object) 2);
        return zzfzxVar.zzi();
    }
}
