package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfm extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzfo zzb;
    private final long zzc;
    private final String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfo zzfoVar, Runnable runnable, boolean z11, String str) {
        super(runnable, null);
        this.zzb = zzfoVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfo.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z11;
        if (andIncrement == Long.MAX_VALUE) {
            zzfoVar.zzt.zzay().zzd().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfm(zzfo zzfoVar, Callable callable, boolean z11, String str) {
        super(callable);
        this.zzb = zzfoVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzfo.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z11;
        if (andIncrement == Long.MAX_VALUE) {
            zzfoVar.zzt.zzay().zzd().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        zzfm zzfmVar = (zzfm) obj;
        boolean z11 = this.zza;
        if (z11 == zzfmVar.zza) {
            long j11 = this.zzc;
            long j12 = zzfmVar.zzc;
            if (j11 < j12) {
                return -1;
            }
            if (j11 <= j12) {
                this.zzb.zzt.zzay().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
                return 0;
            }
        } else if (z11) {
            return -1;
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th2) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzt.zzay().zzd().zzb(this.zzd, th2);
        if ((th2 instanceof zzfk) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
        }
        super.setException(th2);
    }
}
