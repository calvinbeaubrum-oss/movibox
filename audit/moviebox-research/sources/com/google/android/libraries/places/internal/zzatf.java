package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzatf {
    static final zzatf zza = new zzatf(true);
    private static volatile boolean zzb = false;
    private final Map zzc;

    public zzatf() {
        this.zzc = new HashMap();
    }

    public zzatf(boolean z11) {
        this.zzc = Collections.emptyMap();
    }

    public static zzatf zza() {
        return zza;
    }

    public final zzats zzb(zzavf zzavfVar, int i11) {
        return (zzats) this.zzc.get(new zzate(zzavfVar, i11));
    }
}
