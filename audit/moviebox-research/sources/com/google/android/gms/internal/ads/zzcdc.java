package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdc {
    public final s zza(Context context, int i11) {
        zzceu zzceuVar = new zzceu();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        if (zzcdv.zzt(context)) {
            zzcep.zza.execute(new zzcdb(this, context, zzceuVar));
        }
        return zzceuVar;
    }
}
