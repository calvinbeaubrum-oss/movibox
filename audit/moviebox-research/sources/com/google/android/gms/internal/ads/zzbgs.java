package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzbgs {
    private final Map zza = new HashMap();
    private final zzbgu zzb;

    public zzbgs(zzbgu zzbguVar) {
        this.zzb = zzbguVar;
    }

    public final zzbgu zza() {
        return this.zzb;
    }

    public final void zzb(String str, @Nullable zzbgr zzbgrVar) {
        this.zza.put(str, zzbgrVar);
    }

    public final void zzc(String str, String str2, long j11) {
        zzbgr zzbgrVar = (zzbgr) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbgrVar != null) {
            this.zzb.zze(zzbgrVar, j11, strArr);
        }
        this.zza.put(str, new zzbgr(j11, null, null));
    }
}
