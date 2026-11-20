package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfim {

    @Nullable
    static Task zza;

    @Nullable
    public static AppSetIdClient zzb;
    private static final Object zzc = new Object();

    @Nullable
    public static Task zza(Context context) {
        Task task;
        zzb(context, false);
        synchronized (zzc) {
            task = zza;
        }
        return task;
    }

    public static void zzb(Context context, boolean z11) {
        synchronized (zzc) {
            try {
                if (zzb == null) {
                    zzb = AppSet.getClient(context);
                }
                Task task = zza;
                if (task == null || ((task.isComplete() && !zza.isSuccessful()) || (z11 && zza.isComplete()))) {
                    zza = ((AppSetIdClient) Preconditions.checkNotNull(zzb, "the appSetIdClient shouldn't be null")).getAppSetIdInfo();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
