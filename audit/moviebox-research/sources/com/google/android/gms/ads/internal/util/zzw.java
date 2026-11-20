package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbgc;
import k1.h;
import z3.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(26)
public class zzw extends zzv {
    @Override // com.google.android.gms.ads.internal.util.zzab
    @Nullable
    public final Intent zzf(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final void zzg(Context context, String str, String str2) {
        z.a();
        NotificationChannel notificationChannelA = h.a("offline_notification_channel", "AdMob Offline Notifications", ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzir)).intValue());
        notificationChannelA.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelA);
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final boolean zzh(Context context, String str) {
        NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        return notificationChannel != null && notificationChannel.getImportance() == 0;
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final int zzi(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzt.zzp();
        return (zzt.zzz(context, "android.permission.ACCESS_NETWORK_STATE") && telephonyManager.isDataEnabled()) ? 2 : 1;
    }
}
