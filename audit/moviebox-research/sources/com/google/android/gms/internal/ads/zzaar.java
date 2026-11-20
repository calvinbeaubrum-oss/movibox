package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(30)
final class zzaar {
    public static void zza(Surface surface, float f11) {
        try {
            surface.setFrameRate(f11, f11 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e11) {
            zzff.zzd("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
        }
    }
}
