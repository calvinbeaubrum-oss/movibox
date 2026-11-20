package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w {
    public static int a() {
        WindowManager windowManager = (WindowManager) e0.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) e0.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int c() {
        WindowManager windowManager = (WindowManager) e0.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static void d(@NonNull Activity activity) {
        activity.getWindow().addFlags(1024);
    }
}
