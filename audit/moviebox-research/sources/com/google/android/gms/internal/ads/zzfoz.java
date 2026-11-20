package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfoz {

    @SuppressLint({"StaticFieldLeak"})
    private static final zzfoz zza = new zzfoz();
    private Context zzb;

    private zzfoz() {
    }

    public static zzfoz zzb() {
        return zza;
    }

    public final Context zza() {
        return this.zzb;
    }

    public final void zzc(Context context) {
        this.zzb = context != null ? context.getApplicationContext() : null;
    }
}
