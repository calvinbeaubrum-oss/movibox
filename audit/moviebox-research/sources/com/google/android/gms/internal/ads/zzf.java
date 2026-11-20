package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
final class zzf {
    public static void zza(AudioAttributes.Builder builder, int i11) {
        builder.setAllowedCapturePolicy(i11);
    }
}
