package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import androidx.work.k;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class WorkManagerUtil extends zzbs {
    @UsedByReflection("This class must be instantiated reflectively so that the default class loader can be used.")
    public WorkManagerUtil() {
    }

    private static void zzb(Context context) {
        try {
            WorkManager.i(context.getApplicationContext(), new androidx.work.a.b().a());
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbt
    public final void zze(@NonNull IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        try {
            WorkManager workManagerG = WorkManager.g(context);
            workManagerG.c("offline_ping_sender_work");
            workManagerG.d(new k.a(OfflinePingSender.class).i(new androidx.work.b.a().b(NetworkType.CONNECTED).a()).a("offline_ping_sender_work").b());
        } catch (IllegalStateException e11) {
            zzcec.zzk("Failed to instantiate WorkManager.", e11);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbt
    public final boolean zzf(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2) {
        return zzg(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    @Override // com.google.android.gms.ads.internal.util.zzbt
    public final boolean zzg(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws Throwable {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        androidx.work.b bVarA = new androidx.work.b.a().b(NetworkType.CONNECTED).a();
        try {
            WorkManager.g(context).d(new k.a(OfflineNotificationPoster.class).i(bVarA).l(new androidx.work.d.a().e("uri", zzaVar.zza).e("gws_query_id", zzaVar.zzb).e("image_url", zzaVar.zzc).a()).a("offline_notification_work").b());
            return true;
        } catch (IllegalStateException e11) {
            zzcec.zzk("Failed to instantiate WorkManager.", e11);
            return false;
        }
    }
}
