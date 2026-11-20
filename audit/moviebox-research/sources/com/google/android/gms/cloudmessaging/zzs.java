package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs {

    @Nullable
    private static zzs zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private zzm zzd = new zzm(this, null);
    private int zze = 1;

    public zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzs zzb(Context context) {
        try {
            if (zza == null) {
                com.google.android.gms.internal.cloudmessaging.zze.zza();
                zza = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zza;
    }

    private final synchronized int zzf() {
        int i11;
        i11 = this.zze;
        this.zze = i11 + 1;
        return i11;
    }

    private final synchronized <T> Task<T> zzg(zzp<T> zzpVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(zzpVar);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 9);
                sb2.append("Queueing ");
                sb2.append(strValueOf);
            }
            if (!this.zzd.zzg(zzpVar)) {
                zzm zzmVar = new zzm(this, null);
                this.zzd = zzmVar;
                zzmVar.zzg(zzpVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zzpVar.zzb.getTask();
    }

    public final Task<Void> zzc(int i11, Bundle bundle) {
        return zzg(new zzo(zzf(), 2, bundle));
    }

    public final Task<Bundle> zzd(int i11, Bundle bundle) {
        return zzg(new zzr(zzf(), 1, bundle));
    }
}
