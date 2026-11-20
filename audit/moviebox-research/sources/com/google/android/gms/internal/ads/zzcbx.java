package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbx {
    private final Clock zza;
    private final zzcbv zzb;

    public zzcbx(Clock clock, zzcbv zzcbvVar) {
        this.zza = clock;
        this.zzb = zzcbvVar;
    }

    public static zzcbx zza(Context context) {
        return zzcci.zzd(context).zzb();
    }

    public final void zzb(int i11, long j11) {
        this.zzb.zza(i11, j11);
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzff zzffVar) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
