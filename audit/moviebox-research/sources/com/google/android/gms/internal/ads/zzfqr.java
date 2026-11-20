package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqr {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfqr(@NonNull Context context, @NonNull Executor executor, @NonNull Task task, boolean z11) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z11;
    }

    public static zzfqr zza(@NonNull final Context context, @NonNull Executor executor, boolean z11) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z11) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfqp
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfst.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfqq
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfst.zzc());
                }
            });
        }
        return new zzfqr(context, executor, taskCompletionSource.getTask(), z11);
    }

    public static void zzg(int i11) {
        zzf = i11;
    }

    private final Task zzh(final int i11, long j11, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfqn
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.isSuccessful());
                }
            });
        }
        Context context = this.zzb;
        final zzars zzarsVarZza = zzarw.zza();
        zzarsVarZza.zza(context.getPackageName());
        zzarsVarZza.zze(j11);
        zzarsVarZza.zzg(zzf);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzarsVarZza.zzf(stringWriter.toString());
            zzarsVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzarsVarZza.zzb(str2);
        }
        if (str != null) {
            zzarsVarZza.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfqo
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i12 = zzfqr.zza;
                if (!task.isSuccessful()) {
                    return Boolean.FALSE;
                }
                int i13 = i11;
                zzfss zzfssVarZza = ((zzfst) task.getResult()).zza(((zzarw) zzarsVarZza.zzal()).zzax());
                zzfssVarZza.zza(i13);
                zzfssVarZza.zzc();
                return Boolean.TRUE;
            }
        });
    }

    public final Task zzb(int i11, String str) {
        return zzh(i11, 0L, null, null, null, str);
    }

    public final Task zzc(int i11, long j11, Exception exc) {
        return zzh(i11, j11, exc, null, null, null);
    }

    public final Task zzd(int i11, long j11) {
        return zzh(i11, j11, null, null, null, null);
    }

    public final Task zze(int i11, long j11, String str) {
        return zzh(i11, j11, null, null, null, str);
    }

    public final Task zzf(int i11, long j11, String str, Map map) {
        return zzh(i11, j11, null, str, null, null);
    }
}
