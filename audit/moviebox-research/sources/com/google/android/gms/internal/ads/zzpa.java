package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.WEB_CRASH)
final class zzpa {
    public static final zzpa zza = new zzpa(LogSessionId.LOG_SESSION_ID_NONE);
    public final LogSessionId zzb;

    public zzpa(LogSessionId logSessionId) {
        this.zzb = logSessionId;
    }
}
