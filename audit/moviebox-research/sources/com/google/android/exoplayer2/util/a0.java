package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"InlinedApi"})
public final class a0 {
    public static void a(Context context, String str, @StringRes int i11, @StringRes int i12, int i13) {
        if (o0.f35608a >= 26) {
            NotificationManager notificationManager = (NotificationManager) a.e((NotificationManager) context.getSystemService("notification"));
            z3.z.a();
            NotificationChannel notificationChannelA = k1.h.a(str, context.getString(i11), i13);
            if (i12 != 0) {
                notificationChannelA.setDescription(context.getString(i12));
            }
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }
}
