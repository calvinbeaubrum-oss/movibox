package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgmy {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgmy() {
    }

    public /* synthetic */ zzgmy(zzgmx zzgmxVar) {
    }

    public final zzgmy zza(Enum r11, Object obj) {
        this.zza.put(r11, obj);
        this.zzb.put(obj, r11);
        return this;
    }

    public final zzgna zzb() {
        return new zzgna(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), null);
    }
}
