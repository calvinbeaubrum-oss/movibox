package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerc implements zzexq {
    private final Context zza;

    public zzerc(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcJ)).booleanValue()) {
            return zzgen.zzh(new zzerd(z2.a.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
        }
        return zzgen.zzh(null);
    }
}
