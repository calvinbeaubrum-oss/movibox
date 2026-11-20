package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavp extends zzats {
    public long zza;
    public long zzb;

    public zzavp() {
        this.zza = -1L;
        this.zzb = -1L;
    }

    public zzavp(String str) {
        this.zza = -1L;
        this.zzb = -1L;
        HashMap mapZza = zzats.zza(str);
        if (mapZza != null) {
            this.zza = ((Long) mapZza.get(0)).longValue();
            this.zzb = ((Long) mapZza.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzats
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, Long.valueOf(this.zza));
        map.put(1, Long.valueOf(this.zzb));
        return map;
    }
}
