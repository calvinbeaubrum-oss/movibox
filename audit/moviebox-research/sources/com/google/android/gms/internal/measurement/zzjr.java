package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjr {
    static final zzjr zza = new zzjr(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzjr zzd;
    private final Map zze;

    public zzjr() {
        this.zze = new HashMap();
    }

    public zzjr(boolean z11) {
        this.zze = Collections.emptyMap();
    }

    public static zzjr zza() {
        zzjr zzjrVar = zzd;
        if (zzjrVar != null) {
            return zzjrVar;
        }
        synchronized (zzjr.class) {
            try {
                zzjr zzjrVar2 = zzd;
                if (zzjrVar2 != null) {
                    return zzjrVar2;
                }
                zzjr zzjrVarZzb = zzjz.zzb(zzjr.class);
                zzd = zzjrVarZzb;
                return zzjrVarZzb;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final zzkd zzb(zzlm zzlmVar, int i11) {
        return (zzkd) this.zze.get(new zzjq(zzlmVar, i11));
    }
}
