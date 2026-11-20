package com.transsion.push.utils;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationAssistUtils {
    public static boolean a() {
        try {
            Class.forName("android.app.AppOpsManager");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        if (!a()) {
            return true;
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i11 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i11), packageName)).intValue() == 0;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean isOpenNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 24) {
            return notificationManager == null || notificationManager.areNotificationsEnabled();
        }
        return b(context);
    }
}
