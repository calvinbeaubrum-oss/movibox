package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgem {
    private final boolean zza;
    private final zzgaa zzb;

    public /* synthetic */ zzgem(boolean z11, zzgaa zzgaaVar, zzgel zzgelVar) {
        this.zza = z11;
        this.zzb = zzgaaVar;
    }

    public final s zza(Callable callable, Executor executor) {
        return new zzgea(this.zzb, this.zza, executor, callable);
    }
}
