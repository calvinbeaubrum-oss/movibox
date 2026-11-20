package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbwm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class OfflineNotificationPoster extends Worker {
    private final zzbwm zza;

    public OfflineNotificationPoster(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzay.zza().zzm(context, new zzbsr());
    }

    @Override // androidx.work.Worker
    @NonNull
    public final i.a doWork() {
        try {
            this.zza.zzj(ObjectWrapper.wrap(getApplicationContext()), new zza(getInputData().i("uri"), getInputData().i("gws_query_id"), getInputData().i("image_url")));
            return i.a.c();
        } catch (RemoteException unused) {
            return i.a.a();
        }
    }
}
