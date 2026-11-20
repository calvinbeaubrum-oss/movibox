package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgzf {
    static final zzgzf zza = new zzgzf(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgzf zzd;
    private final Map zze;

    public zzgzf() {
        this.zze = new HashMap();
    }

    public zzgzf(boolean z11) {
        this.zze = Collections.emptyMap();
    }

    public static zzgzf zza() {
        return zza;
    }

    public static zzgzf zzb() {
        zzgzf zzgzfVar = zzd;
        if (zzgzfVar != null) {
            return zzgzfVar;
        }
        synchronized (zzgzf.class) {
            try {
                zzgzf zzgzfVar2 = zzd;
                if (zzgzfVar2 != null) {
                    return zzgzfVar2;
                }
                zzgzf zzgzfVarZzb = zzgzn.zzb(zzgzf.class);
                zzd = zzgzfVarZzb;
                return zzgzfVarZzb;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final zzgzs zzc(zzhbe zzhbeVar, int i11) {
        return (zzgzs) this.zze.get(new zzgze(zzhbeVar, i11));
    }
}
