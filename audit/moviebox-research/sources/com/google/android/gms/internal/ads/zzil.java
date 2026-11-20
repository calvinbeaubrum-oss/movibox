package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzil {
    private final Context zza;
    private final zzij zzb;

    public zzil(Context context, Handler handler, zzik zzikVar) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzij(this, handler, zzikVar);
    }
}
