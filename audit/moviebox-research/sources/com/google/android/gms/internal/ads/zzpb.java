package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpb {
    public static final zzpb zza;

    @Nullable
    private final zzpa zzb;

    static {
        zza = zzfy.zza < 31 ? new zzpb() : new zzpb(zzpa.zza);
    }

    public zzpb() {
        zzek.zzf(zzfy.zza < 31);
        this.zzb = null;
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public zzpb(LogSessionId logSessionId) {
        this.zzb = new zzpa(logSessionId);
    }

    private zzpb(zzpa zzpaVar) {
        this.zzb = zzpaVar;
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public final LogSessionId zza() {
        zzpa zzpaVar = this.zzb;
        zzpaVar.getClass();
        return zzpaVar.zzb;
    }
}
