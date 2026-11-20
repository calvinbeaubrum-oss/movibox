package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.WEB_CRASH)
final class zzkf {
    public static zzpb zza(Context context, zzko zzkoVar, boolean z11) {
        zzox zzoxVarZzb = zzox.zzb(context);
        if (zzoxVarZzb == null) {
            zzff.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzpb(LogSessionId.LOG_SESSION_ID_NONE);
        }
        if (z11) {
            zzkoVar.zzz(zzoxVarZzb);
        }
        return new zzpb(zzoxVarZzb.zza());
    }
}
