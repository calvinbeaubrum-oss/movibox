package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import k1.h;
import z3.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class NotificationUtil {
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    /* JADX INFO: compiled from: source.java */
    public @interface Importance {
    }

    private NotificationUtil() {
    }

    public static void createNotificationChannel(Context context, String str, int i11, int i12) {
        if (Util.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            z.a();
            notificationManager.createNotificationChannel(h.a(str, context.getString(i11), i12));
        }
    }

    public static void setNotification(Context context, int i11, Notification notification) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notification != null) {
            notificationManager.notify(i11, notification);
        } else {
            notificationManager.cancel(i11);
        }
    }
}
