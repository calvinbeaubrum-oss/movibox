package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.WEB_CRASH)
final class zzsw {
    public static void zza(zzsp zzspVar, zzpb zzpbVar) {
        LogSessionId logSessionIdZza = zzpbVar.zza();
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        zzspVar.zzb.setString("log-session-id", logSessionIdZza.getStringId());
    }
}
