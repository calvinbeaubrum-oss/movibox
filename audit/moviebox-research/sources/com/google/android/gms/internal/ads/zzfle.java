package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfle {
    private static final s zza = zzgen.zzh(null);
    private final zzgey zzb;
    private final ScheduledExecutorService zzc;
    private final zzflf zzd;

    public zzfle(zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzflf zzflfVar) {
        this.zzb = zzgeyVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzflfVar;
    }

    public final zzfku zza(Object obj, s... sVarArr) {
        return new zzfku(this, obj, Arrays.asList(sVarArr), null);
    }

    public final zzfld zzb(Object obj, s sVar) {
        return new zzfld(this, obj, sVar, Collections.singletonList(sVar), sVar);
    }

    public abstract String zzf(Object obj);
}
