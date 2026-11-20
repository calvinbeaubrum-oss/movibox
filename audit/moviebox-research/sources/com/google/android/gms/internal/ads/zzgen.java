package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgen extends zzgep {
    /* JADX WARN: Multi-variable type inference failed */
    public static zzgem zza(Iterable iterable) {
        return new zzgem(false, zzgaa.zzj(iterable), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgem zzb(Iterable iterable) {
        int i11 = zzgaa.zzd;
        iterable.getClass();
        return new zzgem(true, zzgaa.zzj(iterable), null);
    }

    @SafeVarargs
    public static zzgem zzc(s... sVarArr) {
        return new zzgem(true, zzgaa.zzk(sVarArr), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s zzd(Iterable iterable) {
        return new zzgdv(zzgaa.zzj(iterable), true);
    }

    public static s zze(s sVar, Class cls, zzfws zzfwsVar, Executor executor) {
        zzgcy zzgcyVar = new zzgcy(sVar, cls, zzfwsVar);
        sVar.addListener(zzgcyVar, zzgfe.zzc(executor, zzgcyVar));
        return zzgcyVar;
    }

    public static s zzf(s sVar, Class cls, zzgdu zzgduVar, Executor executor) {
        zzgcx zzgcxVar = new zzgcx(sVar, cls, zzgduVar);
        sVar.addListener(zzgcxVar, zzgfe.zzc(executor, zzgcxVar));
        return zzgcxVar;
    }

    public static s zzg(Throwable th2) {
        th2.getClass();
        return new zzgeq(th2);
    }

    public static s zzh(Object obj) {
        return obj == null ? zzger.zza : new zzger(obj);
    }

    public static s zzi() {
        return zzger.zza;
    }

    public static s zzj(Callable callable, Executor executor) {
        zzgfn zzgfnVar = new zzgfn(callable);
        executor.execute(zzgfnVar);
        return zzgfnVar;
    }

    public static s zzk(zzgdt zzgdtVar, Executor executor) {
        zzgfn zzgfnVar = new zzgfn(zzgdtVar);
        executor.execute(zzgfnVar);
        return zzgfnVar;
    }

    @SafeVarargs
    public static s zzl(s... sVarArr) {
        return new zzgdv(zzgaa.zzk(sVarArr), false);
    }

    public static s zzm(s sVar, zzfws zzfwsVar, Executor executor) {
        zzgdi zzgdiVar = new zzgdi(sVar, zzfwsVar);
        sVar.addListener(zzgdiVar, zzgfe.zzc(executor, zzgdiVar));
        return zzgdiVar;
    }

    public static s zzn(s sVar, zzgdu zzgduVar, Executor executor) {
        int i11 = zzgdj.zzc;
        executor.getClass();
        zzgdh zzgdhVar = new zzgdh(sVar, zzgduVar);
        sVar.addListener(zzgdhVar, zzgfe.zzc(executor, zzgdhVar));
        return zzgdhVar;
    }

    public static s zzo(s sVar, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return sVar.isDone() ? sVar : zzgfk.zzf(sVar, j11, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgfp.zza(future);
        }
        throw new IllegalStateException(zzfxt.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgfp.zza(future);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof Error) {
                throw new zzgec((Error) cause);
            }
            throw new zzgfo(cause);
        }
    }

    public static void zzr(s sVar, zzgej zzgejVar, Executor executor) {
        zzgejVar.getClass();
        sVar.addListener(new zzgek(sVar, zzgejVar), executor);
    }
}
